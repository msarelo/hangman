/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Marcin
 */
@Entity
@XmlType(name = "Player")
public class Player extends AbstractEntity {

    private String name;
//    private String login;
//    private String password;

    @ManyToMany
    private List<Game> games;

    public Player() {
    }

    public Player(String name) {
	this.name = name;
//	this.countOfAttempt = 0;
//	this.counOfFailure = 0;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<Game> getGames() {
	return games;
    }

    public void setGames(List<Game> games) {
	this.games = games;
    }

}
