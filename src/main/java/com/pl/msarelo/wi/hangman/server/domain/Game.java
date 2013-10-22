/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Marcin
 */
@XmlType(name = "game")
public class Game extends AbstractEntity {

    private String word;
    private Status status;
    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Player> players;

    public Game() {
    }

    public Game(String word) {
	this.word = word;
	this.status = Game.Status.PREPARAE;
    }

    public String getWord() {
	return word;
    }

    public void setWord(String word) {
	this.word = word;
    }

    public Status getStatus() {
	return status;
    }

    public void setStatus(Status status) {
	this.status = status;
    }

    public List<Player> getPlayers() {
	return players;
    }

    public void setPlayers(List<Player> players) {
	this.players = players;
    }

    enum Status {

	ONGOING, ENDED, PREPARAE
    }
}
