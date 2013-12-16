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

//        if (game.getWord().length() > game.getGameResult().getPlayerCountOfFailure().get(player) && game.getWord().length() > game.getGameResult().getPlayerCountOfAttempt().get(player)) {
        if (!game.getUsedChars().contains(letter)) {
            if (!game.getWord().contains(letter.toString())) {
                game.nextFailureAttempt(player);
            } else {
                game.nextAttempt(player);
            }
            game.getUsedChars().add(letter);
        } else {
            game.nextFailureAttempt(player);
        }
//        }

        gameService.dao.saveOrUpdate(game);
        return game;
    }

    public Game startGame(Long gameId, Long playerId) throws Exception {

        Game game = gameService.findById(gameId);
        if (game.getGameResult().getPlayerCountOfAttempt().keySet().toArray()[0] == playerId) {
            game.setStatus(Game.Status.ONGOING);
            game = gameService.dao.saveOrUpdate(game);
        } else{
            throw new Exception("No access to start this game");
        }
        return game;

    }
}
