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
        if (!this.playerExists(name)) {
            return dao.save(new Player(name));
        } else {
            return null;
        }
    }

    public Boolean playerExists(String name) {
        return (this.getByName(name) != null);
    }

    public List<Player> getPlayersAssignedToGame(Game game) {
        List<Object> list = new LinkedList<Object>();
        list.add(game);
        return dao.executeNamedQuery("getPlayersAssignedToGame", Arrays.asList(Game.class.getSimpleName()), list);
    }

    public Player getByName(String name) {
        List<Object> list = new LinkedList<Object>();
        list.add(name);
        List<Player> players = dao.executeNamedQuery("getPlayerByName", Arrays.asList("name"), list);
        if (!players.isEmpty()) {
            return (Player) players.get(0);
        } else {
            return null;
        }
    }

}
