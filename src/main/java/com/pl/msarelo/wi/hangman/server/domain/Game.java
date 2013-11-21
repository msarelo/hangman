/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Marcin
 */
@XmlType(name = "Game")
@Entity
@NamedQueries({
    @NamedQuery(
            name = "Game.findAll",
            query = "SELECT g FROM Game g"
    )})
public class Game extends AbstractEntity {

    private static final int MAX_ATTEMPTS = 9;

    private String word;
    private Status status;
    private Category category;
    @ElementCollection
    private List<Character> usedChars;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private GameResult gameResult;
    public Game() {
    }

    public Game(Category category, String word) {
        this.word = word;
        this.category = category;
        this.status = Game.Status.PREPARAE;
        this.gameResult = new GameResult();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    @XmlTransient
    public List<Character> getUsedChars() {
        return usedChars;
    }

    public void setUsedChars(List<Character> usedChars) {
        this.usedChars = usedChars;
    }

    public void addChar(char usedChar) {
        this.usedChars.add(usedChar);
    }

    public String nextFailureAttempt(Player player) {
        String result = null;

        nextAttempt(player);

        Integer count = getGameResult().getPlayerCountOfFailure().get(player);

        if (count >= MAX_ATTEMPTS) {
            result = "Player lose";
        } else {
            count++;
            getGameResult().getPlayerCountOfFailure().put(player.getId(), count);
            result = count.toString();
        }
        return result;
    }

    public String nextAttempt(Player player) {
        String result = null;
        Integer count = getGameResult().getPlayerCountOfAttempt().get(player);
        count++;
        getGameResult().getPlayerCountOfAttempt().put(player.getId(), count);
        result = count.toString();

        return result;

    }

//    public List<Player> getPlayers() {
//	return players;
//    }
//
//    public void setPlayers(List<Player> players) {
//	this.players = players;
//    }
    public enum Status {

        ONGOING, ENDED, PREPARAE
    }

    public enum Category {

        BABY_ROOM, BATHROOM, BEDROOM, CAR_PARTS, CLOTHES, CONSTRUCTION_SITE, COOKING_INSTRUCTIONS, COUNTRIES, DINING_ROOM, FAMILY_MEMBERS, FRUIT_VEGETABLES, JOBS, KITCHEN, LIVING_ROOM, OFFICE_EQUIPMENT, PARTS_OF_THE_BODY, UNIVERSE_SPACE, WILD_ANIMALS_PETS, WORKSHOP_TOOLS
    }
}
