/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.service;

import com.pl.msarelo.wi.hangman.server.domain.Game;

/**
 *
 * @author marcin
 */
public class GameService extends Service<Game> {

    public void createGame(String word) {
	Game game = new Game(word);
	dao.save(game);
    }
}
