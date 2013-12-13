/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.view;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deathek
 */
public class Menu {

    private List<MenuOption> options;

    private Menu(List<MenuOption> options) {
        this.options = options;
    }

    public List<MenuOption> getOptions() {
        return this.options;
    }

    public int addOption(MenuOption option) {
        this.options.add(option);
        return this.options.size();
    }

    public int addOptions(List<MenuOption> options) {
        this.options.addAll(options);
        return this.options.size();
    }

    public static Menu createFromEnum(SpecialEnum options[]) {
        List<MenuOption> menuOptionsList = new ArrayList<>();
        for (SpecialEnum option : options) {
            menuOptionsList.add(new MenuOption(option));
        }
        return new Menu(menuOptionsList);
    }
}
