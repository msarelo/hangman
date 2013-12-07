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
}
