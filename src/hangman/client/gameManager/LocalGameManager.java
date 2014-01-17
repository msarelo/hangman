/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.gameManager;

import com.pl.msarelo.wi.hangman.server.Game;
import com.pl.msarelo.wi.hangman.server.GameResult;
import com.pl.msarelo.wi.hangman.server.Player;
import com.pl.msarelo.wi.hangman.server.Status;
import hangman.client.view.ExitException;
import hangman.client.view.GoBackException;
import hangman.client.view.SpecialEnum;
import hangman.client.view.View;
import hangman.client.view.enums.CreateGameEnum;
import hangman.client.wsClient.WSClient;
import hangman.client.wsClient.WSException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deathek
 */
public class LocalGameManager {
    private List<Player> localPlayers;
    private static LocalGameManager instance = null;
    
    private boolean inGame;
    private WSClient wsClient;
    private View view;
    private boolean gameCreatedLocally;

    public static final int MAX_ATTEMPTS = 12;
    
    private LocalGameManager() {
        this.localPlayers = new ArrayList<>();
        this.inGame = false;
        this.wsClient = WSClient.getInstance();
        this.view = View.getInstance();

    }
    
    public static LocalGameManager getInstance() {
        return LocalGameManager.getInstance(false);
    }

    public static LocalGameManager getInstance(boolean recreate) {
        if (LocalGameManager.instance == null || recreate) {
            LocalGameManager.instance = new LocalGameManager();
        }
        return LocalGameManager.instance;
    }
    
    public List<Player> getLocalPlayers() throws GMException, ExitException {
        if (!this.isPlayersSet()) {
            this.createLocalPlayers();
        }
        return this.localPlayers;
    }
    
    private List<Player> createLocalPlayers() throws GMException, ExitException {
        List<Player> localPlayers = this.view.getLocalPlayersList();
        try {
            List<Player> existingPlayers = new ArrayList<>();
            List<Player> localPlayersToCreate = new ArrayList<>();

            for (Player playerToCheck : localPlayers) {
                Player existingPlayer = this.wsClient.getPlayerByName(playerToCheck.getName());
                if (existingPlayer != null) {
                    existingPlayers.add(existingPlayer);
                } else {
                    localPlayersToCreate.add(playerToCheck);
                }
            }
            List<Player> createdPlayers = this.wsClient.createPlayers(localPlayersToCreate);
            this.localPlayers = createdPlayers;
            this.localPlayers.addAll(existingPlayers);
        } catch (WSException couldNotCreatePlayers) {
            throw new GMException("Nie mozna bylo utworzyc lub sprawdzic graczy. Powod: " + couldNotCreatePlayers.getMessage());
        }
        return this.localPlayers;
    }
    
    public boolean isInGame() {
        return inGame;
    }
    
    public boolean isPlayersSet() {
        return (!this.localPlayers.isEmpty());
    }

    public Game chooseGame() throws ExitException {
        Game game = null;
        do {
            SpecialEnum choice;
            choice = this.view.joinOrCreateGame();
            try {
                if (choice == CreateGameEnum.CHOOSE_GAME) {
                    List<Game> gamesList = this.wsClient.getGameList();
                    game = this.view.chooseGame(gamesList);
                    this.gameCreatedLocally = false;
                } else {
                    game = this.view.prepareGameData();
                    game = this.wsClient.createGame(game, this.localPlayers.get(0));
                    this.gameCreatedLocally = true;
                }
            } catch (GoBackException goBack) {
                game = null;
            }
        } while (game == null);
        return game;
    }

    public boolean joinGame(Game game) {
        try {            
            if (this.gameCreatedLocally) {
                if (this.getLocalPlayers().size() > 1) {
                    //for local game we need to remove Admin player which was already passed on game creation
                    List<Player> playersToJoin = new ArrayList<>();
                    for (Player player : this.getLocalPlayers()) {
                        if (!player.getId().equals(game.getAdmin().getId())) {
                            playersToJoin.add(player);
                        }
                    }
                    this.inGame = this.wsClient.joinGame(game, playersToJoin);
                } else {
                    //only one player which created the game - no need to add players
                    this.inGame = true;
                }
            } else {
                this.inGame = this.wsClient.joinGame(game, this.getLocalPlayers());
            }
        } catch (Exception ex) { //never gonna happen on this step
        }
        if (!this.inGame) {
            this.view.notify("Nie udalo sie dolaczyc do gry");
        }
        return this.inGame;
    }

    public void playGame(Game game) throws ExitException {
        Game ongoingGame;
        List<PlayerInfo> players;
        do {
            ongoingGame = this.wsClient.getGameStatus(game.getId());
            players = this.getPlayerInfo(ongoingGame, this.wsClient.getPlayers(game.getId()));

            if (ongoingGame.getStatus() == Status.PREPARAE && this.gameHasLocalAdmin(ongoingGame)) {
                if (1 == this.view.adminStartGame(ongoingGame, players)) {
                    Game gameStarted = this.startGame(game);
                    if (gameStarted.getStatus() != Status.ONGOING) {
                        this.view.cannotJoinToGame();
                    }
                }
            } else if (ongoingGame.getStatus() == Status.PREPARAE) {
                this.view.waitForStart(ongoingGame, players);
            } else {
                if (this.view.getGameStep(ongoingGame, players)) {
                    String letter = this.view.getLetter();
                    Game gameStatus = this.wsClient.checkLetter(ongoingGame.getId(), this.getActivePlayer(ongoingGame, players).getId(), letter);
                    if (this.letterGuessed(ongoingGame, gameStatus, this.getActivePlayer(ongoingGame, players).getId())) {
                        this.view.letterGuessed(ongoingGame, players);
                    } else {
                        this.view.letterNotGuessed(ongoingGame, players);
                    }
                    ongoingGame = gameStatus;
                }
            }
        } while(ongoingGame.getStatus() != Status.ENDED);
        this.view.printGameResult(ongoingGame, players);
    }

    public boolean gameHasLocalAdmin(Game ongoingGame) {
        return (this.getLocalPlayersIds().contains(ongoingGame.getAdmin().getId()));
    }

    private Game startGame(Game game) {
        return this.wsClient.startGame(game);
    }

    private List<Long> getLocalPlayersIds() {
        List<Long> localPlayerIds = new ArrayList<>();
        try {
            for (Player player : this.getLocalPlayers()) {
                localPlayerIds.add(player.getId());
            }
        } catch (GMException | ExitException ex) {
            Logger.getLogger(LocalGameManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return localPlayerIds;
    }

    public Long getFirstPlayer(Game game) {
        return game.getGameResult().getPlayerCountOfAttempt().getEntry().get(0).getKey();
    }

    public PlayerInfo getActivePlayer(Game game, List<PlayerInfo> players) {
        int attemptCount = players.get(0).getAttempts();
        for (PlayerInfo player : players) {
            if (player.getAttempts() < attemptCount) {
                return player;
            }
        }
        return players.get(0);
    }

    public boolean isLocalGame() {
        return this.gameCreatedLocally;
    }

    public int getFailureAttempts(Game game, Long playerId) {
        List<GameResult.PlayerCountOfFailure.Entry> attempts = game.getGameResult().getPlayerCountOfFailure().getEntry();
        for (GameResult.PlayerCountOfFailure.Entry attempt : attempts) {
            if (attempt.getKey().equals(playerId)) {
                return attempt.getValue();
            }
        }
        return 0;
    }

    public int getAttempts(Game game, Long playerId) {
        List<GameResult.PlayerCountOfAttempt.Entry> attempts = game.getGameResult().getPlayerCountOfAttempt().getEntry();
        for (GameResult.PlayerCountOfAttempt.Entry attempt : attempts) {
            if (attempt.getKey().equals(playerId)) {
                return attempt.getValue();
            }
        }
        return 0;
    }

    private List<PlayerInfo> getPlayerInfo(Game game, List<Player> players) {
        List<PlayerInfo> playersInfo = new ArrayList<>();
        for (Player player : players) {
            playersInfo.add(new PlayerInfo(player, this.getAttempts(game, player.getId()), this.getFailureAttempts(game, player.getId())));
        }
        return playersInfo;
    }

    public boolean letterWasUsed(Game game, char charAt) {
        return game.getUsedChars().contains((int)charAt);
    }

    public boolean localPlayerIsActive(Game ongoingGame, List<PlayerInfo> players) {
        return this.getLocalPlayersIds().contains(this.getActivePlayer(ongoingGame, players).getId());
    }

    private boolean letterGuessed(Game previousGameStatus, Game actualGameStatus, Long activePlayerId) {
        int previousFailureCount = this.getFailureAttempts(previousGameStatus, activePlayerId);
        int actualFailureCount = this.getFailureAttempts(actualGameStatus, activePlayerId);
        return (!(previousFailureCount < actualFailureCount));
    }
}
