/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hangman.client.view.enums;

import hangman.client.view.SpecialEnum;

/**
 *
 * @author Deathek
 */
public enum CreateGameEnum implements SpecialEnum {
    CREATE_GAME,
    CHOOSE_GAME;

    @Override
    public String toString() {
        switch (this) {
            case CREATE_GAME:
                return "Stworz nowa gre";
            case CHOOSE_GAME:
                return "Wybierz gre";
        }
        return "";
    }
}
