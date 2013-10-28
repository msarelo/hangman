/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marcin
 */
@XmlRootElement(name = "GameList")
public class GameList {

    private List<Game> gameList;

    public GameList() {
    }

    public List<Game> getGameList() {
	return gameList;
    }

    public void setGameList(List<Game> gameList) {
	this.gameList = gameList;
    }

}
