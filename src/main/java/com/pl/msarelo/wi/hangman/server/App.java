package com.pl.msarelo.wi.hangman.server;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import com.pl.msarelo.wi.hangman.server.service.GameService;
import java.util.List;
import javax.xml.ws.Endpoint;

public class App {

    public static void main(String[] args) {

	GameService gameService = new GameService();
	gameService.createGame("dupa");

	List<Game> games = gameService.getAll();
	GameManager gameManager = new GameManager(games);

//		String url = "http://192.168.2.110:8080/smartphone"; //dom
//		String url = "http://192.168.2.142:8080/smartphone"; // praca
	String url = "http://localhost:8080/smartphone";

	Endpoint.publish(url, gameManager);
	System.out.println(games.size());
//                    System.out.println(smartphoneManager.searchByIsBuyNow().size());
//                    System.out.println(smartphoneManager.searchByAttr("16").size());
	for (Game game : games) {
	    System.out.println(game.getId());
	}

    }
}
