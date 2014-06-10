
package nl.han.dare2date;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


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
 *         &lt;element name="registration" type="{http://www.han.nl/schemas/types}Registration"/>
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
    "registration"
})
@XmlRootElement(name = "ApplyRegistrationRequest", namespace = "http://www.han.nl/schemas/messages")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
public class ApplyRegistrationRequest implements Serializable {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    protected Registration registration;

    /**
     * Gets the value of the registration property.
     * 
     * @return
     *     possible object is
     *     {@link Registration }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public Registration getRegistration() {
        return registration;
    }

    /**
     * Sets the value of the registration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Registration }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2014-06-04T05:23:01+02:00", comments = "JAXB RI v2.2.4-2")
    public void setRegistration(Registration value) {
        this.registration = value;
    }

}
