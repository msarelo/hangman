package com.pl.msarelo.wi.hangman.server;

import com.pl.msarelo.wi.hangman.server.domain.Game;
import com.pl.msarelo.wi.hangman.server.service.GameService;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.xml.ws.Endpoint;


public class App {
   
 
    public static void main(String[] args) {
       
         HashMap<Game.Category, List<String>>  words =init();
                
        GameService gameService = new GameService(words);
        List<Game> games = gameService.getAll();
        GameManager gameManager = new GameManager(words);

        String url = "http://localhost:8080/hangman";

        Endpoint.publish(url, gameManager);
        System.out.println(games.size());
        for (Game game : games) {
            System.out.println(game.getId());
        }

    }

     public static HashMap<Game.Category, List<String>> init() {
       HashMap<Game.Category, List<String>>  words = new HashMap<Game.Category, List<String>>();
       
      
        LinkedList<String> BABY_ROOM = new LinkedList<String>();
        BABY_ROOM.add("baby clothes");
        BABY_ROOM.add("baby shampoo");
        BABY_ROOM.add("diaper");
        BABY_ROOM.add("nappy");
        BABY_ROOM.add("ointment");
        BABY_ROOM.add("baby bottle");
        BABY_ROOM.add("bottle");
        BABY_ROOM.add("cradle");
        
        words.put(Game.Category.BABY_ROOM, BABY_ROOM);

        LinkedList<String> BATHROOM = new LinkedList<String>();
        BATHROOM.add("shower ");
        BATHROOM.add("soap");
        BATHROOM.add("shower gel");
        BATHROOM.add("shampoo ");
        BATHROOM.add("towel");
        BATHROOM.add("water");
         words.put(Game.Category.BATHROOM, BATHROOM);

        LinkedList<String> BEDROOM = new LinkedList<String>();
        BEDROOM.add("night table");
        BEDROOM.add("lamp");
        BEDROOM.add("alarm clock");
        BEDROOM.add("bed");
        BEDROOM.add("rugs");
        BEDROOM.add("cot");
         words.put(Game.Category.BEDROOM, BEDROOM);

        LinkedList<String> CAR_PARTS = new LinkedList<String>();
        CAR_PARTS.add("Accelerator");
        CAR_PARTS.add("Battery");
        CAR_PARTS.add("Brake");
        CAR_PARTS.add("Door");
        CAR_PARTS.add("Dashboard");
        CAR_PARTS.add("Ignition");
        CAR_PARTS.add("Wheel");
        CAR_PARTS.add("Windscreen wiper");
        CAR_PARTS.add("Speedometer");
         words.put(Game.Category.CAR_PARTS, CAR_PARTS);

        
        LinkedList<String> CLOTHES = new LinkedList<String>();
        CLOTHES.add("Boots");
        CLOTHES.add("skirt");
        CLOTHES.add("shirt");
        CLOTHES.add("socks");
        CLOTHES.add("trousers");
        CLOTHES.add("gloves");
        CLOTHES.add("jacket");
         words.put(Game.Category.CLOTHES, CLOTHES);

        
        LinkedList<String> CONSTRUCTION_SITE = new LinkedList<String>();
        CONSTRUCTION_SITE.add("shovel");
        CONSTRUCTION_SITE.add("lumber");
        CONSTRUCTION_SITE.add("wire");
        CONSTRUCTION_SITE.add("wheelbarrow");
        CONSTRUCTION_SITE.add("scaffolding");
        CONSTRUCTION_SITE.add("digger");
        CONSTRUCTION_SITE.add("hammer");
         words.put(Game.Category.CONSTRUCTION_SITE, CONSTRUCTION_SITE);

        
        LinkedList<String> COUNTRIES = new LinkedList<String>();
        COUNTRIES.add("Afghanistan");
        COUNTRIES.add("Argentina");
        COUNTRIES.add("Australia");
        COUNTRIES.add("Belgium");
        COUNTRIES.add("Bolivia");
        COUNTRIES.add("Brazil");
        COUNTRIES.add("Cambodia");
        COUNTRIES.add("Cameroon");
        COUNTRIES.add("Canada");
        COUNTRIES.add("Chile");
        COUNTRIES.add("China");
        COUNTRIES.add("Colombia");
        COUNTRIES.add("Costa Rica");
        COUNTRIES.add("Cuba");
        COUNTRIES.add("Denmark");
        COUNTRIES.add("Dominican Republic");
        COUNTRIES.add("Ecuador");
        COUNTRIES.add("Egypt");
        COUNTRIES.add("El Salvador");
        COUNTRIES.add("England");
        COUNTRIES.add("Estonia");
        COUNTRIES.add("Ethiopia");
        COUNTRIES.add("Finland");
        COUNTRIES.add("France");
        COUNTRIES.add("Germany");
        COUNTRIES.add("Ghana");
        COUNTRIES.add("Greece");
        COUNTRIES.add("Guatemala");
        COUNTRIES.add("Haiti");
        COUNTRIES.add("Honduras");
        COUNTRIES.add("Indonesia");
        COUNTRIES.add("Iran");
        COUNTRIES.add("Ireland");
        COUNTRIES.add("Israel");
        COUNTRIES.add("Italy");
        COUNTRIES.add("Japan");
        COUNTRIES.add("Jordan");
        COUNTRIES.add("Kenya");
        COUNTRIES.add("Korea");
        COUNTRIES.add("Laos");
        COUNTRIES.add("Latvia");
        COUNTRIES.add("Lithuania");
        COUNTRIES.add("Malaysia");
        COUNTRIES.add("Mexico");
        COUNTRIES.add("Morocco");
        COUNTRIES.add("Netherlands");
        COUNTRIES.add("New Zealand");
        COUNTRIES.add("Nicaragua");
        COUNTRIES.add("Norway");
        COUNTRIES.add("Panama");
        COUNTRIES.add("Paraguay");
        COUNTRIES.add("Peru");
        COUNTRIES.add("Philippines");
        COUNTRIES.add("Poland");
        COUNTRIES.add("Portugal");
        COUNTRIES.add("Puerto Rico");
        COUNTRIES.add("Romania");
        COUNTRIES.add("Russia");
        COUNTRIES.add("Saudi Arabia");
        COUNTRIES.add("Spain");
        COUNTRIES.add("Sweden");
        COUNTRIES.add("Switzerland");
        COUNTRIES.add("Taiwan");
        COUNTRIES.add("Tajikistan");
        COUNTRIES.add("Thailand");
        COUNTRIES.add("Turkey");
        COUNTRIES.add("Ukraine");
        COUNTRIES.add("United States");
        COUNTRIES.add("Uruguay");
        COUNTRIES.add("Venezuela");
        COUNTRIES.add("Vietnam");
        COUNTRIES.add("Wales");
        words.put(Game.Category.COUNTRIES, COUNTRIES);

        return words;
    }
   
}
