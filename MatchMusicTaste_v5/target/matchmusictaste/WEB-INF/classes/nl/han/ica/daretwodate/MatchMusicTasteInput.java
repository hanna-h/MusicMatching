//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.27 at 01:57:39 PM CEST 
//


package nl.han.ica.daretwodate;

import javax.annotation.Generated;
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
@XmlType(name = "MatchMusicTasteInput", propOrder = {

})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
public class MatchMusicTasteInput {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    protected String lastfmApiKey;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    protected String lastfmSecret;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    protected String mapsApiKey;
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    protected String username;

    /**
     * Gets the value of the lastfmApiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    public void setUsername(String value) {
        this.username = value;
    }

}
