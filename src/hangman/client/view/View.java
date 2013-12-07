/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.view;

import hangman.client.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deathek
 */
public class View {
    private static View instance = null;

    public static void sayGoodBye() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private View() {}
    
    public static View getInstance() {
        if (View.instance == null) {
            View.instance = new View();
        }
        return View.instance;
    }
    
    @SuppressWarnings("SleepWhileInLoop")
    public List<Player> getLocalPlayersList() throws ExitException {
        Scanner console = new Scanner(System.in);
        
        int players = 0;
        do {
            System.out.println("Podaj ilość graczy (0 = wyjscie)");
            players = console.nextInt();
            if (players < 1) {
               throw new ExitException();
            }
        } while (players < 1);
        console.nextLine();
        System.out.println("Ok! Liczba graczy z Twojego urzadzenia to: " + Integer.toString(players));
        List<Player> playersList = new ArrayList<Player>();
        
        for (int i=1; i<=players; i++) {
            String name = new String();
            do {
                System.out.println("Podaj imię (co najmniej 5 znakow) gracza nr: " + Integer.toString(i));
                name = console.nextLine();
            } while(name.length() < 5);
            Player p = new Player();
            p.setName(name);
            playersList.add(p);
        }
        return playersList;
    }
    
    public static void notify(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean wannaPlayAgain() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
