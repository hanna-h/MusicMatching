
package nl.han.dare2date;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>Java class for User complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="User">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="card" type="{http://www.han.nl/schemas/types}Creditcard"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "User", namespace = "http://www.han.nl/schemas/types", propOrder = {
    "firstname",
    "lastname",
    "card"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
public class User implements Serializable {

    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected String firstname;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected String lastname;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected Creditcard card;

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the card property.
     * 
     * @return
     *     possible object is
     *     {@link Creditcard }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public Creditcard getCard() {
        return card;
    }

    /**
     * Sets the value of the card property.
     * 
     * @param value
     *     allowed object is
     *     {@link Creditcard }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setCard(Creditcard value) {
        this.card = value;
    }

}
