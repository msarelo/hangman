package com.pl.msarelo.wi.hangman.server;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import com.pl.msarelo.wi.hangman.server.service.GameService;
import java.util.List;
import javax.xml.ws.Endpoint;

public class App {

    public static void main(String[] args) {

	GameService gameService = new GameService();
//	gameService.createGame(Game.Category.BATHROOM, "zlew");

	List<Game> games = gameService.getAll();
	GameManager gameManager = new GameManager();

	String url = "http://localhost:8080/hangman";

	Endpoint.publish(url, gameManager);
	System.out.println(games.size());
	for (Game game : games) {
	    System.out.println(game.getId());
	}

    }
}
