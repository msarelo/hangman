
package hangman.client;

import hangman.client.view.SpecialEnum;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for category.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="category">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BABY_ROOM"/>
 *     &lt;enumeration value="BATHROOM"/>
 *     &lt;enumeration value="BEDROOM"/>
 *     &lt;enumeration value="CAR_PARTS"/>
 *     &lt;enumeration value="CLOTHES"/>
 *     &lt;enumeration value="CONSTRUCTION_SITE"/>
 *     &lt;enumeration value="COOKING_INSTRUCTIONS"/>
 *     &lt;enumeration value="COUNTRIES"/>
 *     &lt;enumeration value="DINING_ROOM"/>
 *     &lt;enumeration value="FAMILY_MEMBERS"/>
 *     &lt;enumeration value="FRUIT_VEGETABLES"/>
 *     &lt;enumeration value="JOBS"/>
 *     &lt;enumeration value="KITCHEN"/>
 *     &lt;enumeration value="LIVING_ROOM"/>
 *     &lt;enumeration value="OFFICE_EQUIPMENT"/>
 *     &lt;enumeration value="PARTS_OF_THE_BODY"/>
 *     &lt;enumeration value="UNIVERSE_SPACE"/>
 *     &lt;enumeration value="WILD_ANIMALS_PETS"/>
 *     &lt;enumeration value="WORKSHOP_TOOLS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "category")
@XmlEnum
public enum Category implements SpecialEnum {
    BABY_ROOM,
    BATHROOM,
    BEDROOM,
    CAR_PARTS,
    CLOTHES,
    CONSTRUCTION_SITE,
    COOKING_INSTRUCTIONS,
    COUNTRIES,
    DINING_ROOM,
    FAMILY_MEMBERS,
    FRUIT_VEGETABLES,
    JOBS,
    KITCHEN,
    LIVING_ROOM,
    OFFICE_EQUIPMENT,
    PARTS_OF_THE_BODY,
    UNIVERSE_SPACE,
    WILD_ANIMALS_PETS,
    WORKSHOP_TOOLS;


    @Override
    public String toString() {
        switch (this) {
            case BABY_ROOM:
                return "Pokój dziecięcy";
            case BATHROOM:
                return "Łazienka";
            case BEDROOM:
                return "Sypialnia";
            case CAR_PARTS:
                return "Części samochodowe";
            case CLOTHES:
                return "Ubrania";
            case CONSTRUCTION_SITE:
                return "Budowa";
            case COOKING_INSTRUCTIONS:
                return "Przepisy kucharskie";
            case COUNTRIES:
                return "Kraje";
            case DINING_ROOM:
                return "Jadalnia";
            case FAMILY_MEMBERS:
                return "Rodzina";
            case FRUIT_VEGETABLES:
                return "Owoce, warzywa";
            case JOBS:
                return "Praca";
            case KITCHEN:
                return "Kuchnia";
            case LIVING_ROOM:
                return "Salon";
            case OFFICE_EQUIPMENT:
                return "Wyposażenie biurowe";
            case PARTS_OF_THE_BODY:
                return "Części ciała";
            case UNIVERSE_SPACE:
                return "Przestrzeń kosmiczna";
            case WILD_ANIMALS_PETS:
                return "Zwierzęta";
            case WORKSHOP_TOOLS:
                return "Narzędzia";
        }
        return "";
    }

    public String value() {
        return name();
    }

    public static Category fromValue(String v) {
        return valueOf(v);
    }

}
