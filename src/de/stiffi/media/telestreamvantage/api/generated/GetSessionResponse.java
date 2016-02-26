
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
 *         &lt;element name="GetSessionResult" type="{http://Telestream.Vantage.Sdk/2010/07}SessionType" minOccurs="0"/>
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
    "getSessionResult"
})
@XmlRootElement(name = "GetSessionResponse")
public class GetSessionResponse {

    @XmlElementRef(name = "GetSessionResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<SessionType> getSessionResult;

    /**
     * Gets the value of the getSessionResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SessionType }{@code >}
     *     
     */
    public JAXBElement<SessionType> getGetSessionResult() {
        return getSessionResult;
    }

    /**
     * Sets the value of the getSessionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SessionType }{@code >}
     *     
     */
    public void setGetSessionResult(JAXBElement<SessionType> value) {
        this.getSessionResult = ((JAXBElement<SessionType> ) value);
    }

}
