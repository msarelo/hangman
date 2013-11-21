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
public class GameService extends Service<Game> {

    public void createGame(Game.Category category, String word) {
	Game game = new Game(category, word);
	dao.save(game);
    }

    public Game addPlayerToGame(Player player, Game game) {

	game.getGameResult().getPlayerCountOfAttempt().put(player.getId(), 0);
	game.getGameResult().getPlayerCountOfFailure().put(player.getId(), 0);
        
        game = dao.saveOrUpdate(game);
       
        PlayerService playerService =new PlayerService();
        player.getGames().add(game);
        playerService.dao.saveOrUpdate(player);
        
	return game;

    }
}
