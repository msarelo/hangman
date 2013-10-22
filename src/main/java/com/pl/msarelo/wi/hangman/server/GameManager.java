/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Msi
 */
@WebService
public class GameManager {

    private List<Game> games = new ArrayList<Game>();

    public GameManager(List<Game> games) {

	this.games = games;
    }

    @WebMethod
    public Game getGameById(@WebParam(name = "id") Long id) {
	System.out.println("getGameById with param: " + id);
	Game result = new Game();
	for (Game game : games) {
	    if (game.getId().equals(id)) {
		result = game;
	    }
	}
	return result;
    }

    @WebMethod
    public Game getPlayerById(@WebParam(name = "id") Long id) {
	System.out.println("getPlayerById with param: " + id);
	Game result = new Game();
	for (Game game : games) {
	    if (game.getId().equals(id)) {
		result = game;
	    }
	}
	return result;
    }

    public List<Game> getGameList() {
	System.out.println("getAll");
	return games;
    }

    public void setGameList(List<Game> games) {
	this.games = games;
    }
}
