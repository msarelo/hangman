package com.pl.msarelo.wi.hangman.server;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import com.pl.msarelo.wi.hangman.server.domain.Player;
import com.pl.msarelo.wi.hangman.server.service.GameService;
import com.pl.msarelo.wi.hangman.server.service.GameplayService;
import com.pl.msarelo.wi.hangman.server.service.PlayerService;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author marcin
 */
@WebService
public class GameManager {

    private GameService gameService = new GameService();
    private PlayerService playerService = new PlayerService();
    private GameplayService gameplayService = new GameplayService(playerService, gameService);

    public GameManager() {
    }

    @WebMethod
    public Game getGameById(@WebParam(name = "id") Long id) {
        System.out.println("getGameById with param: " + id);
        return gameService.findById(id);
    }

    @WebMethod
    public Player getPlayerById(@WebParam(name = "id") Long id) {
        System.out.println("getPlayerById with param: " + id);
        return playerService.findById(id);
    }

    @WebMethod
    public Player getPlayerByName(@WebParam(name = "name") String name) {
        System.out.println("getPlayerByName with param: " + name);
        return playerService.getByName(name);
    }

    @WebMethod
    public List<Game> getGameList() {
        System.out.println("getGameList");
        return gameService.getAll();
    }

    @WebMethod
    public List<Player> getPlayerList() {
        System.out.println("getPlayerList");
        return playerService.getAll();
    }

    @WebMethod
    public Game createGame(@WebParam(name = "category") Game.Category category, @WebParam(name = "word") String word, @WebParam(name = "playerId") Long playerId) {
        System.out.println("createGame with params: " + category + " " + word + " playerId: " + playerId + " }");
        return gameService.createGame(category, word, playerId);
    }

    @WebMethod
    public Long createPlayer(@WebParam(name = "name") String name) {
        System.out.println("createPlayer with params: " + name);
        return playerService.createPlayer(name).getId();
    }

    @WebMethod
    public Game addPlayerToGame(@WebParam(name = "gameId") Long gameId, @WebParam(name = "playerId") Long playerId) {
        System.out.println("addPlayerToGame with params: { gameId: " + gameId + " playerId: " + playerId + " }");
        return gameService.addPlayerToGame(playerService.findById(playerId), gameService.findById(gameId));
    }

    @WebMethod
    public List<Player> getPlayersAssignedToGame(@WebParam(name = "gameId") Long gameId) {
        System.out.println("getPlayersAssignedToGame with params: { gameId: " + gameId + " }");
        return playerService.getPlayersAssignedToGame(gameService.findById(gameId));
    }

    @WebMethod
    public Game checkLetter(@WebParam(name = "gameId") Long gameId, @WebParam(name = "playerId") Long playerId, @WebParam(name = "letter") String letter) {
        System.out.println("checkLetter with params: { gameId: " + gameId + " playerId: " + playerId + " letter: " + letter + " }");
        return gameplayService.checkLetter(gameId, playerId, new Character(letter.toCharArray()[0]));
    }

    @WebMethod
    public Game startGame(@WebParam(name = "gameId") Long gameId, @WebParam(name = "playerId") Long playerId) {
        System.out.println("startGame with params: { gameId: " + gameId + " playerId: " + playerId + " }");
        try {
            return gameplayService.startGame(gameId, playerId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

}
