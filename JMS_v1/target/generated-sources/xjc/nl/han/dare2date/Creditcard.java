
package nl.han.dare2date;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Creditcard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Creditcard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cvc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="validThrough" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Creditcard", namespace = "http://www.han.nl/schemas/types", propOrder = {
    "number",
    "cvc",
    "validThrough"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
public class Creditcard {

    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected int number;
    @XmlElement(namespace = "http://www.han.nl/schemas/types")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected int cvc;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @XmlSchemaType(name = "dateTime")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected XMLGregorianCalendar validThrough;

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
     * Gets the value of the cvc property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public int getCvc() {
        return cvc;
    }

    /**
     * Sets the value of the cvc property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setCvc(int value) {
        this.cvc = value;
    }

    /**
     * Gets the value of the validThrough property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public XMLGregorianCalendar getValidThrough() {
        return validThrough;
    }

    /**
     * Sets the value of the validThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setValidThrough(XMLGregorianCalendar value) {
        this.validThrough = value;
    }

}
