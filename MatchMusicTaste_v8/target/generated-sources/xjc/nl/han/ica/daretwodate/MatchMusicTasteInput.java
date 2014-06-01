
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
 *         &lt;element name="ipaddress" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="username2" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    protected String ipaddress;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    protected String username1;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    protected String username2;

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
     * Gets the value of the ipaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIpaddress() {
        return ipaddress;
    }

    /**
     * Sets the value of the ipaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIpaddress(String value) {
        this.ipaddress = value;
    }

    /**
     * Gets the value of the username1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername1() {
        return username1;
    }

    /**
     * Sets the value of the username1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername1(String value) {
        this.username1 = value;
    }

    /**
     * Gets the value of the username2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername2() {
        return username2;
    }

    /**
     * Sets the value of the username2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername2(String value) {
        this.username2 = value;
    }

}
