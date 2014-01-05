/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.view;

import hangman.client.Game;
import hangman.client.Player;
import hangman.client.gameManager.LocalGameManager;
import java.util.List;

/**
 *
 * @author Deathek
 */
public class GamePrinter extends View {
    private static GamePrinter intance = null;
    
    private GamePrinter() {};
    
    public static GamePrinter getInstance() {
        if (GamePrinter.intance == null) {
            GamePrinter.intance = new GamePrinter();
        }
        return GamePrinter.intance;
    }

    public void printPlayerList(List<Player> players, Long adminId, Long activePlayerId) {
        this.clearOutput();
        this.printLine("Lista graczy");
        
        for (Player player : players) {
            String playerLine = player.getName();
            if (player.getId() == adminId) {
                playerLine += " (*)";
            }
            if (player.getId() == activePlayerId) {
                playerLine = "-> " + playerLine;
            }

            this.printLine(playerLine);
        }
    }

    void printGame(Game ongoingGame, List<Player> players, Long adminId, Long activePlayerId) {
        this.printPlayerList(players, adminId, activePlayerId);
        this.printGameProgress(LocalGameManager.getInstance().getFailureAttempts(ongoingGame, activePlayerId));
        this.printWordProgress();
    }

    private void printGameProgress(int failureAttempts) {
        if (failureAttempts > 0) {
            if (failureAttempts < 6) {
                if (failureAttempts >= 2) {
                    if (failureAttempts >= 3) {
                        if (failureAttempts > 4) {
                            //4-5
                            this.printLine("   ____");
                        } else if (failureAttempts == 4) {
                            //4
                            this.printLine("   __");
                        }
                        //3
                        this.printLine(" |");
                        this.printLine(" |");
                    }
                    //2
                    this.printLine(" |");
                    this.printLine(" |");
                }
            } else {
                //4-5
                this.printLine("   ____");

                //3/2+6
                this.printLine(" |     |");
                if (failureAttempts > 6) {
                    //3/2+7
                    this.printLine(" |     O");
                } else {
                    //3/2
                    this.printLine(" |");
                }


                //tutaj drukowanie dwojki ;x
                if (failureAttempts > 9) {
                    this.printLine(" |    /|\\");
                } else if (failureAttempts > 8) {
                    this.printLine(" |    / \\");
                } else if (failureAttempts > 7) {
                    this.printLine(" |    /");
                } else {
                    this.printLine(" |");
                }

                if (failureAttempts > 11) {
                    this.printLine(" |    / \\");
                } else if (failureAttempts > 10) {
                    this.printLine(" |    /");
                } else {
                    this.printLine(" |");
                }
            }
            //1
            this.printLine("/ \\");
        }
    }

    private void printWordProgress() {
//
    }
}
