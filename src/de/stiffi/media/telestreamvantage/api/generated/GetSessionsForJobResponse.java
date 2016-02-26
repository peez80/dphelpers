
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
 *         &lt;element name="GetSessionsForJobResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfSessionType" minOccurs="0"/>
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
    "getSessionsForJobResult"
})
@XmlRootElement(name = "GetSessionsForJobResponse")
public class GetSessionsForJobResponse {

    @XmlElementRef(name = "GetSessionsForJobResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfSessionType> getSessionsForJobResult;

    /**
     * Gets the value of the getSessionsForJobResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSessionType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSessionType> getGetSessionsForJobResult() {
        return getSessionsForJobResult;
    }

    /**
     * Sets the value of the getSessionsForJobResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSessionType }{@code >}
     *     
     */
    public void setGetSessionsForJobResult(JAXBElement<ArrayOfSessionType> value) {
        this.getSessionsForJobResult = ((JAXBElement<ArrayOfSessionType> ) value);
    }

}
