/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Marcin
 */
@Entity
@XmlType(name = "Player")
@NamedQueries({
    @NamedQuery(
            name = "Player.findAll",
            query = "SELECT f FROM Player f"
    ),
    @NamedQuery(
            name = "Player.getPlayersAssignedToGame",
            query = "SELECT p FROM Player p WHERE :game MEMBER OF p.games"
    ),
    @NamedQuery(
            name = "Player.getPlayerByName",
            query = "SELECT p FROM Player p WHERE :name = p.name"
    )
}
)
public class Player extends AbstractEntity {

    private String name;

    @ManyToMany
    private List<Game> games;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

}
