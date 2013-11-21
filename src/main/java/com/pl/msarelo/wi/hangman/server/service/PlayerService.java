/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.service;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import com.pl.msarelo.wi.hangman.server.domain.Player;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marcin
 */
public class PlayerService extends Service<Player> {

    public Player createPlayer(String name) {
	return dao.save(new Player(name));
    }

    public List<Player> getPlayersAssignedToGame(Game game) {
        
        List<Object> list = new LinkedList<Object>();
        list.add(game);
        return dao.executeNamedQuery("getPlayersAssignedToGame", Arrays.asList(Game.class.getSimpleName()),list );
    }
       
}
