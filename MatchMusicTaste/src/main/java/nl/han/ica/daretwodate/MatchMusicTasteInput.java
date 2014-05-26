
package nl.han.ica.daretwodate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MatchMusicTasteInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MatchMusicTasteInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="lastfmApiKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastfmSecret" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mapsApiKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MatchMusicTasteInput", namespace = "http://www.han.nl/schemas/types", propOrder = {

})
public class MatchMusicTasteInput {

    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    protected String lastfmApiKey;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    protected String lastfmSecret;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    protected String mapsApiKey;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    protected String username;

    /**
     * Gets the value of the lastfmApiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastfmApiKey() {
        return lastfmApiKey;
    }

    /**
     * Sets the value of the lastfmApiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastfmApiKey(String value) {
        this.lastfmApiKey = value;
    }

    /**
     * Gets the value of the lastfmSecret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastfmSecret() {
        return lastfmSecret;
    }

    /**
     * Sets the value of the lastfmSecret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastfmSecret(String value) {
        this.lastfmSecret = value;
    }

    /**
     * Gets the value of the mapsApiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMapsApiKey() {
        return mapsApiKey;
    }

    /**
     * Sets the value of the mapsApiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMapsApiKey(String value) {
        this.mapsApiKey = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
