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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="input" type="{http://www.han.nl/schemas/types}MatchMusicTasteInput"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "input"
})
@XmlRootElement(name = "MatchMusicTasteRequest", namespace = "http://www.han.nl/schemas/messages")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
public class MatchMusicTasteRequest {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    protected MatchMusicTasteInput input;

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link MatchMusicTasteInput }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    public MatchMusicTasteInput getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchMusicTasteInput }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-05-27T01:57:39+02:00", comments = "JAXB RI v2.2.4-2")
    public void setInput(MatchMusicTasteInput value) {
        this.input = value;
    }

}
