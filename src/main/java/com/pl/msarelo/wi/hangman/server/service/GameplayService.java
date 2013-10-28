/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.service;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import com.pl.msarelo.wi.hangman.server.domain.Player;

/**
 *
 * @author marcin
 */
public class GameplayService {

    private PlayerService playerService;
    private GameService gameService;

    public GameplayService(PlayerService playerService, GameService gameService) {
	this.gameService = gameService;
	this.playerService = playerService;
    }

    public Game checkLetter(Long gameId, Long playerId, Character letter) {
	Player player = playerService.findById(playerId);
	Game game = gameService.findById(gameId);
	if (gameService.findById(gameId).getWord().contains(letter.toString())) {
	    game.nextFailureAttempt(player);
	} else {
	    game.nextAttempt(player);
	}
	gameService.dao.saveOrUpdate(game);
	return game;
    }
}
