/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.view;

/**
 *
 * @author Deathek
 */
public class MenuOption {
    private String text;
    private SpecialEnum value;

    public MenuOption(SpecialEnum optionInfo) {
        this.text = optionInfo.toString();
        this.value = optionInfo;
    }

    public String getText() {
        return this.text;
    }

    public SpecialEnum getValue() {
        return this.value;
    }
}
