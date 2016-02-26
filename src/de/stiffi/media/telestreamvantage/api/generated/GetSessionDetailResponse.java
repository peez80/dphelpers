
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
 *         &lt;element name="GetSessionDetailResult" type="{http://Telestream.Vantage.Sdk/2010/07}Operation" minOccurs="0"/>
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
    "getSessionDetailResult"
})
@XmlRootElement(name = "GetSessionDetailResponse")
public class GetSessionDetailResponse {

    @XmlElementRef(name = "GetSessionDetailResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<Operation> getSessionDetailResult;

    /**
     * Gets the value of the getSessionDetailResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Operation }{@code >}
     *     
     */
    public JAXBElement<Operation> getGetSessionDetailResult() {
        return getSessionDetailResult;
    }

    /**
     * Sets the value of the getSessionDetailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Operation }{@code >}
     *     
     */
    public void setGetSessionDetailResult(JAXBElement<Operation> value) {
        this.getSessionDetailResult = ((JAXBElement<Operation> ) value);
    }

}
