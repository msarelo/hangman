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
    
     private final PlayerService playerService = new PlayerService();

    public Game createGame(Game.Category category, String word, Long playerId) {
        Game game = new Game(category, word);
        game = dao.save(game);

        addPlayerToGame(playerService.findById(playerId), game);
        return game;
    }

    public Game addPlayerToGame(Player player, Game game) {

        if (game.getGameResult().getPlayerCountOfAttempt().containsKey(player.getId())) {
            game.getGameResult().getPlayerCountOfAttempt().remove(player.getId());

        }
        game.getGameResult().getPlayerCountOfAttempt().put(player.getId(), 0);

        if (game.getGameResult().getPlayerCountOfFailure().containsKey(player.getId())) {
            game.getGameResult().getPlayerCountOfFailure().remove(player.getId());
        }
        game.getGameResult().getPlayerCountOfFailure().put(player.getId(), 0);

        game = dao.saveOrUpdate(game);

       
        if (player.getGames().contains(game)) {
            player.getGames().remove(game);
        }
        player.getGames().add(game);
        playerService.dao.saveOrUpdate(player);

        return game;

    }
    
}
