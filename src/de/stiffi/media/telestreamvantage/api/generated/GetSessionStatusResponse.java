
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="GetSessionStatusResult" type="{http://Telestream.Vantage.Sdk/2010/07}History" minOccurs="0"/>
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
    "getSessionStatusResult"
})
@XmlRootElement(name = "GetSessionStatusResponse")
public class GetSessionStatusResponse {

    @XmlElementRef(name = "GetSessionStatusResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<History> getSessionStatusResult;

    /**
     * Gets the value of the getSessionStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link History }{@code >}
     *     
     */
    public JAXBElement<History> getGetSessionStatusResult() {
        return getSessionStatusResult;
    }

    /**
     * Sets the value of the getSessionStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link History }{@code >}
     *     
     */
    public void setGetSessionStatusResult(JAXBElement<History> value) {
        this.getSessionStatusResult = ((JAXBElement<History> ) value);
    }

}
