
package hangman.client;

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
public enum Category {

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

    public String value() {
        return name();
    }

    public static Category fromValue(String v) {
        return valueOf(v);
    }

}
