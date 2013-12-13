/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.gameManager;

import hangman.client.Game;
import hangman.client.Player;
import hangman.client.view.ExitException;
import hangman.client.view.GoBackException;
import hangman.client.view.SpecialEnum;
import hangman.client.view.View;
import hangman.client.view.enums.CreateGameEnum;
import hangman.client.wsClient.WSClient;
import hangman.client.wsClient.WSException;
import java.util.ArrayList;
import java.util.List;

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
  
    private LocalGameManager() {
        this.localPlayers = new ArrayList<>();
        this.inGame = false;
        this.wsClient = WSClient.getInstance();
        this.view = View.getInstance();
    }
    
    public static LocalGameManager getInstance() {
        if (LocalGameManager.instance == null) {
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
                } else {
                    game = this.view.prepareGameData();
                    game = this.wsClient.createGame(game);
                }
            } catch (GoBackException goBack) {
                game = null;
            }
        } while (game == null);
        return game;
    }

    public void joinGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void playGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
