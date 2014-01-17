/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.service;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import com.pl.msarelo.wi.hangman.server.domain.Player;
import java.util.List;

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

        Game game = gameService.findById(gameId);

        if (game.getStatus().equals(Game.Status.ONGOING)) {
            Player player = playerService.findById(playerId);
            String word = game.getWord();
            String resultOfAttempt = "";

//        if (game.getWord().length() > game.getGameResult().getPlayerCountOfFailure().get(player.getId()) && game.getWord().length() > game.getGameResult().getPlayerCountOfAttempt().get(player.getId())) {
            System.out.println("checking letter: " + letter);
            if (!game.getUsedChars().contains(letter)) {
                System.out.println("letter not yet used");
                if (!word.toLowerCase().contains(letter.toString().toLowerCase())) {
                    System.out.println("but word does not contain it... really? word: " + word + " letter: " + letter + " toString: " + letter.toString());
                    resultOfAttempt = game.nextFailureAttempt(player);
                } else {
                    resultOfAttempt = game.nextAttempt(player);
                }
                game.getUsedChars().add(letter);
            } else {
                resultOfAttempt = game.nextFailureAttempt(player);
            }

            if (!resultOfAttempt.equals(Game.PLAYER_LOSE) && !resultOfAttempt.equals("")) {
                if (this.isWordGuessed(game)) {
                    game.setStatus(Game.Status.ENDED);
                    game.setWinner(player);
                    System.out.println(Game.Status.ENDED);
                }
            }
//            }

            gameService.dao.saveOrUpdate(game);
        }
        return game;
    }

    public Game startGame(Long gameId, Long playerId) throws Exception {

        Game game = gameService.findById(gameId);
        if (game.getStatus().equals(Game.Status.PREPARAE)) {
            if (game.getAdmin().getId().equals(playerId)) {
                game.setStatus(Game.Status.ONGOING);
                game = gameService.dao.saveOrUpdate(game);
            } else {
                throw new Exception("No access to start this game");
            }
        } else{
            throw  new Exception("You cannot start ONGOING or ENDED game");
        }
        return game;

    }

    public Player getAdmin(Long gameId) {
        return gameService.findById(gameId).getAdmin();
    }

    private boolean isWordGuessed(Game game) {
        List<Character> characters = game.getUsedChars();
        String word = game.getWord().toLowerCase();
        System.out.println("checking word:" + word);
        for (Character character : characters) {
                word = word.replace("" + character, "");
        }
        System.out.println("checking word - letters removed:" + word);
        return (word.length() == 0);
    }
}
