/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.gameManager;

import hangman.client.Game;
import hangman.client.Player;
import hangman.client.view.ExitException;
import hangman.client.view.View;
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
        this.localPlayers = new ArrayList<Player>();
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
        List<Player> localPlayersToCreate = this.view.getLocalPlayersList();
        try {
            List<Player> createdPlayers = this.wsClient.createPlayers(localPlayersToCreate);
            this.localPlayers = createdPlayers;
        } catch (WSException couldNotCreatePlayers) {
            throw new GMException("Nie mozna bylo utworzyc graczy. Powod: " + couldNotCreatePlayers.getMessage());
        }
        return this.localPlayers;
    }
    
    public boolean isInGame() {
        return inGame;
    }
    
    public boolean isPlayersSet() {
        return (!this.localPlayers.isEmpty());
    }

    public Game chooseGame() {
        
    }

    public void joinGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void playGame(Game game) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
