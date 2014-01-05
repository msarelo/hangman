/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.wsClient;

import hangman.client.Game;
import hangman.client.Player;
import java.util.List;

/**
 *
 * @author Deathek
 */
public class WSClient {
    hangman.client.GameManagerService service;
    hangman.client.GameManager port;
    
    private static WSClient instance;
    
    private WSClient() {
        this.service = new hangman.client.GameManagerService();
        this.port = service.getGameManagerPort();
    }
    
    public static WSClient getInstance() {
        if (WSClient.instance == null) {
            WSClient.instance = new WSClient();
        }
        return WSClient.instance;
    }
    public List<Game> getGameList() {
            return this.port.getGameList();
    }

    public List<Player> createPlayers(List<Player> localPlayersToCreate) throws WSException {
        for (Player playerToCreate : localPlayersToCreate) {
            Long playerId = this.port.createPlayer(playerToCreate.getName());
            playerToCreate.setId(playerId);
        }
        return localPlayersToCreate;
    }

    public Player getPlayerByName(String playerName) throws WSException {
        return this.port.getPlayerByName(playerName);
    }

    public Game createGame(Game game, Player admin) {
        return this.port.createGame(game.getCategory(), game.getWord(), admin.getId());
    }

    public boolean joinGame(Game game, List<Player> localPlayers) {
        for (Player player : localPlayers) {
            this.port.addPlayerToGame(game.getId(), player.getId());
        }
        return true;
    }

    public Game getGameStatus(Long gameId) {
        return this.port.getGameById(gameId);
    }

    public Game startGame(Game game, Long adminId) {
        return this.port.startGame(game.getId(), adminId);
    }

    public List<Player> getPlayers(Long id) {
        return this.port.getPlayersAssignedToGame(id);
    }
}
