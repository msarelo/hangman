
package hangman.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Game complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Game">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.hangman.wi.msarelo.pl.com/}abstractEntity">
 *       &lt;sequence>
 *         &lt;element name="category" type="{http://server.hangman.wi.msarelo.pl.com/}category" minOccurs="0"/>
 *         &lt;element name="gameResult" type="{http://server.hangman.wi.msarelo.pl.com/}gameResult" minOccurs="0"/>
 *         &lt;element name="status" type="{http://server.hangman.wi.msarelo.pl.com/}status" minOccurs="0"/>
 *         &lt;element name="word" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Game", propOrder = {
    "category",
    "gameResult",
    "status",
    "word"
})
public class Game
    extends AbstractEntity
{

    protected Category category;
    protected GameResult gameResult;
    protected Status status;
    protected String word;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link Category }
     *     
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link Category }
     *     
     */
    public void setCategory(Category value) {
        this.category = value;
    }

    /**
     * Gets the value of the gameResult property.
     * 
     * @return
     *     possible object is
     *     {@link GameResult }
     *     
     */
    public GameResult getGameResult() {
        return gameResult;
    }

    /**
     * Sets the value of the gameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameResult }
     *     
     */
    public void setGameResult(GameResult value) {
        this.gameResult = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the word property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the value of the word property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWord(String value) {
        this.word = value;
    }

}
