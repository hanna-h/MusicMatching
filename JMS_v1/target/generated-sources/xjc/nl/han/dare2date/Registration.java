
package nl.han.dare2date;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Registration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Registration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="user" type="{http://www.han.nl/schemas/types}User"/>
 *         &lt;element name="succesFul" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Registration", namespace = "http://www.han.nl/schemas/types", propOrder = {
    "number",
    "date",
    "user",
    "succesFul"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
public class Registration {

    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected int number;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @XmlSchemaType(name = "dateTime")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected XMLGregorianCalendar date;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected User user;
    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected boolean succesFul;

    /**
     * Gets the value of the number property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the succesFul property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public boolean isSuccesFul() {
        return succesFul;
    }

    /**
     * Sets the value of the succesFul property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setSuccesFul(boolean value) {
        this.succesFul = value;
    }

}
