/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.view;

import hangman.client.Category;
import hangman.client.Game;
import hangman.client.Player;
import hangman.client.Status;
import hangman.client.gameManager.GMException;
import hangman.client.gameManager.LocalGameManager;
import hangman.client.view.enums.CreateGameEnum;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    protected View() {}
    
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
        this.printLine("Podaj ilość graczy (0 = wyjscie)");
        do {
            try {
                players = console.nextInt();
                if (players < 1) {
                   throw new ExitException();
                }
            } catch(InputMismatchException stupidUserEntry) {
                console.nextLine();
            }
        } while (players < 1);
        console.nextLine();
        this.printLine("Ok! Liczba graczy z Twojego urzadzenia to: " + Integer.toString(players));
        List<Player> playersList = new ArrayList<>();
        
        for (int i=1; i<=players; i++) {
            String name = new String();
            do {
                this.printLine("Podaj imię (co najmniej 5 znakow) gracza nr: " + Integer.toString(i));
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

    public boolean joinGame() {

//        this.showMenu(, false);
        return false;
    }

    public Game prepareGameData() throws ExitException, GoBackException {
        Menu menu = Menu.createFromEnum(Category.values());
        Category category = (Category) this.getUserResponse(menu, true, true, true);
        String gameWord = this.getUserInput("Podaj slowo do zgadniecia", true);
        Game game = new Game();
        game.setCategory(category);
        game.setWord(gameWord);
        return game;
    }

    public Game chooseGame(List<Game> gameList) throws GoBackException, ExitException {
        List<Game> filteredGames = new ArrayList<>();
        for (Game game : gameList) {
            if (game.getStatus() == Status.PREPARAE) {
                filteredGames.add(game);
            }
        }
        gameList = filteredGames;
        if (gameList.isEmpty()) {
            this.printLine("Aktualnie nie ma na serwerze gier do ktorych mozna dolaczyc");
            throw new GoBackException();
        } else {
            List<String> gameNames = new ArrayList<>();
            for (Game game : gameList) {
                gameNames.add("Kategoria: " + game.getCategory() + " długość słowa: " + Integer.toString(game.getWord().length()) + " (" + game.getId().toString() + ")");
            }
            int choice = this.getUserResponse(gameNames, true, true);
            return gameList.get(choice-1);
        }
    }

    public SpecialEnum joinOrCreateGame() throws ExitException {
        Menu menu = Menu.createFromEnum(CreateGameEnum.values());
        try {
            return this.getUserResponse(menu, false, true, true);
        } catch (GoBackException ex) {} //NEVER happens
        return null;
    }

    public int getUserResponse(List<String> options) throws ExitException, GoBackException {
        return this.getUserResponse(options, true, true, true);
    }

    public int getUserResponse(List<String> options, boolean addGoBackOption, boolean addExitOption) throws ExitException, GoBackException {
        return this.getUserResponse(options, addGoBackOption, addExitOption, true);
    }

    public int getUserResponse(List<String> options, boolean addGoBackOption, boolean addExitOption, boolean clearOutput) throws ExitException, GoBackException {
        if (clearOutput) {
            this.clearOutput();
        }
        int i = 0;
        for (String option : options) {
            this.printLine(Integer.toString(++i) + ". " + option);
        }

        int goBack = -1;
        if (addGoBackOption) {
            this.printLine(Integer.toString(++i) + ". Wróć");
            goBack = i;
        }

        int exit = -1;
        if (addExitOption) {
            this.printLine(Integer.toString(++i) + ". Wyjdź");
            exit = i;
        }

        Scanner console = new Scanner(System.in);
        int choice = 0;
        do {
            try {
                choice = console.nextInt();
            } catch (InputMismatchException stupidUserFault) {
                choice = 0;
            }
        } while (choice < 1 && choice > i);

        if (choice == exit) {
            throw new ExitException();
        } else if (choice == goBack) {
            throw new GoBackException();
        } else {
            return choice;
        }
    }

    public SpecialEnum getUserResponse(Menu menu) throws ExitException, GoBackException {
        return this.getUserResponse(menu, true, true, true);
    }

    public SpecialEnum getUserResponse(Menu menu, boolean addGoBackOption, boolean addExitOption) throws ExitException, GoBackException {
        return this.getUserResponse(menu, addGoBackOption, addExitOption, true);
    }

    public SpecialEnum getUserResponse(Menu menu, boolean addGoBackOption, boolean addExitOption, boolean clearOutput) throws ExitException, GoBackException {
        if (clearOutput) {
            this.clearOutput();
        }
        int i = 0;
        for (MenuOption option : menu.getOptions()) {
            this.printLine(Integer.toString(++i) + ". " + option.getText());
        }
        
        int goBack = -1;
        if (addGoBackOption) {
            this.printLine(Integer.toString(++i) + ". Wróć");
            goBack = i;
        }

        int exit = -1;
        if (addExitOption) {
            this.printLine(Integer.toString(++i) + ". Wyjdź");
            exit = i;
        }
        
        Scanner console = new Scanner(System.in);
        int choice = 0;
        do {
            try {
                choice = console.nextInt();
            } catch (InputMismatchException stupidUserFault) {
                choice = 0;
            }
        } while (choice < 1 && choice > i);

        if (choice == exit) {
            throw new ExitException();
        } else if (choice == goBack) {
            throw new GoBackException();
        } else {
            return menu.getOptions().get(choice-1).getValue();
        }
    }

    public String getUserInput(String showUserText, boolean clearOutput) {
        Scanner console = new Scanner(System.in);
        if (clearOutput) {
            this.clearOutput();
        }
        this.printLine(showUserText);
        String response = null;
        do {
            response = console.nextLine();
        } while(response.isEmpty());
        return response;
    }

    protected void clearOutput() {
        //temporary solution (they like to stay that way...)
        for (int i=0; i<50; i++) {
                this.printLine("");
        }
    }

    protected void printLine(String text) {
        System.out.println(text);
    }

    public int getGameStep(Game ongoingGame, List<Player> players) throws ExitException {
        GamePrinter.getInstance().printGame(
                ongoingGame,
                players,
                LocalGameManager.getInstance().getAdmin(ongoingGame, players).getId(),
                LocalGameManager.getInstance().getActivePlayer(ongoingGame, players).getId()
        );
        return this.getUserInteractionOrSleep(ongoingGame, players);
    }

    public int adminStartGame(Game game, List<Player> players) {
        GamePrinter.getInstance().printPlayerList(
                players,
                LocalGameManager.getInstance().getAdmin(game, players).getId(),
                LocalGameManager.getInstance().getActivePlayer(game, players).getId()
        );
        List<String> options = new ArrayList<>();
        options.add("Rozpocznij grę");
        options.add("Odśwież listę graczy");
        try {
            return this.getUserResponse(options, false, false, false);
        } catch (ExitException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GoBackException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 2;
    }

    private int getUserInteractionOrSleep(Game ongoingGame, List<Player> players) throws ExitException {
        LocalGameManager gameManager = LocalGameManager.getInstance();
        Player activePlayer = gameManager.getActivePlayer(ongoingGame, players);
        try {
            if (gameManager.getLocalPlayers().contains(activePlayer)) {
                List<String> options = new ArrayList<>();
                options.add("Zgadnij literkę");
                options.add("Zgadnij słowo");
                try {
                    return this.getUserResponse(options, false, true, false);
                } catch (GoBackException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Thread.sleep(1000);
                return 0;
            }
        } catch (GMException | InterruptedException e){}
        return 0;
    }

    public void waitForStart(Game game, List<Player> players) {
        this.clearOutput();
        GamePrinter.getInstance().printPlayerList(
                players,
                LocalGameManager.getInstance().getAdmin(game, players).getId(),
                LocalGameManager.getInstance().getActivePlayer(game, players).getId()
        );
        this.printLine("Oczekiwanie na start...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cannotJoinToGame() {
        this.printLine("Nie udało się dołączyć do gry. Spróbuj ponownie za chwilę...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
