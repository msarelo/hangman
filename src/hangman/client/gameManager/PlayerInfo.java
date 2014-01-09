/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.gameManager;

import com.pl.msarelo.wi.hangman.server.Player;

/**
 *
 * @author Deathek
 */
public class PlayerInfo extends Player {

    private int attempts;
    private int failureAttempts;

    public PlayerInfo(Player player, int attempts, int failureAttempts) {
        this.setId(player.getId());
        this.setName(player.getName());
        this.attempts = attempts;
        this.failureAttempts = failureAttempts;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getFailureAttempts() {
        return failureAttempts;
    }
}
