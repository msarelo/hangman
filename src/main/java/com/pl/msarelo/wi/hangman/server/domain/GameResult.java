/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author marcin
 */
@Entity
public class GameResult extends AbstractEntity {

    @OneToOne
    private Game game;

    @ElementCollection
    @CollectionTable(name = "Player_Count_Of_Attempt")
    @MapKeyColumn(name = "Player_id")
    @Column(name = "count")
    private Map<Player, Integer> playerCountOfAttempt = new HashMap<Player, Integer>();

    @ElementCollection
    @CollectionTable(name = "Player_Count_Of_fail")
    @MapKeyColumn(name = "Player_id")
    @Column(name = "fail")
    private Map<Player, Integer> playerCountOfFailure = new HashMap<Player, Integer>();


    public Game getGame() {
	return game;
    }

    public void setGame(Game game) {
	this.game = game;
    }

    public Map<Player, Integer> getPlayerCountOfAttempt() {
	return playerCountOfAttempt;
    }

    public void setPlayerCountOfAttempt(Map<Player, Integer> playerCountOfAttempt) {
	this.playerCountOfAttempt = playerCountOfAttempt;
    }

    public Map<Player, Integer> getPlayerCountOfFailure() {
	return playerCountOfFailure;
    }

    public void setPlayerCountOfFailure(Map<Player, Integer> playerCountOfFailure) {
	this.playerCountOfFailure = playerCountOfFailure;
    }

}
