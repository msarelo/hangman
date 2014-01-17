/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client;

import com.pl.msarelo.wi.hangman.server.Game;
import hangman.client.gameManager.GMException;
import hangman.client.gameManager.LocalGameManager;
import hangman.client.view.ExitException;
import hangman.client.view.View;
/**
 *
 * @author Deathek
 */
public class HangmanClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            LocalGameManager GM = LocalGameManager.getInstance(true);
            //getting local players
            do {
                try {
                    GM.getLocalPlayers();
                } catch (GMException couldNotGetPlayers) {
                    View.notify(couldNotGetPlayers.getMessage());
                }
            } while (!GM.isPlayersSet());

            do {
                //joining game
                Game game;
                do {
                    game = GM.chooseGame();
                    try {
                        GM.joinGame(game);
                    } catch (Exception cannotJoinGame) {
                        View.notify(cannotJoinGame.getMessage());
                    }
                } while (!GM.isInGame());
                GM.playGame(game);
            } while (View.getInstance().wannaPlayAgain());
        } catch (ExitException iWannaQuit) {
            View.sayGoodBye();
        }
    }   
}
