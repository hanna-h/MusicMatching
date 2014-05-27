
package webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MatchMusicTasteResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchMusicTasteResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="loginSucceeded" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="percentage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="events" type="{http://www.han.nl/schemas/types}Event"/>
 *         &lt;element name="sendInviteSucceeded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="joinEventSucceeded" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchMusicTasteResult", namespace = "http://www.han.nl/schemas/types", propOrder = {

})
public class MatchMusicTasteResult {

    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    protected int loginSucceeded;
    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    protected int percentage;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    protected Event events;
    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    protected boolean sendInviteSucceeded;
    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    protected int joinEventSucceeded;

    /**
     * Gets the value of the loginSucceeded property.
     * 
     */
    public int getLoginSucceeded() {
        return loginSucceeded;
    }

    /**
     * Sets the value of the loginSucceeded property.
     * 
     */
    public void setLoginSucceeded(int value) {
        this.loginSucceeded = value;
    }

    /**
     * Gets the value of the percentage property.
     * 
     */
    public int getPercentage() {
        return percentage;
    }

    /**
     * Sets the value of the percentage property.
     * 
     */
    public void setPercentage(int value) {
        this.percentage = value;
    }

    /**
     * Gets the value of the events property.
     * 
     * @return
     *     possible object is
     *     {@link Event }
     *     
     */
    public Event getEvents() {
        return events;
    }

    /**
     * Sets the value of the events property.
     * 
     * @param value
     *     allowed object is
     *     {@link Event }
     *     
     */
    public void setEvents(Event value) {
        this.events = value;
    }

    /**
     * Gets the value of the sendInviteSucceeded property.
     * 
     */
    public boolean isSendInviteSucceeded() {
        return sendInviteSucceeded;
    }

    /**
     * Sets the value of the sendInviteSucceeded property.
     * 
     */
    public void setSendInviteSucceeded(boolean value) {
        this.sendInviteSucceeded = value;
    }

    /**
     * Gets the value of the joinEventSucceeded property.
     * 
     */
    public int getJoinEventSucceeded() {
        return joinEventSucceeded;
    }

    /**
     * Sets the value of the joinEventSucceeded property.
     * 
     */
    public void setJoinEventSucceeded(int value) {
        this.joinEventSucceeded = value;
    }

}
