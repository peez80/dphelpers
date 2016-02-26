
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
 *         &lt;element name="GetLabelsResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfLabel" minOccurs="0"/>
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
    "getLabelsResult"
})
@XmlRootElement(name = "GetLabelsResponse")
public class GetLabelsResponse {

    @XmlElementRef(name = "GetLabelsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfLabel> getLabelsResult;

    /**
     * Gets the value of the getLabelsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLabel }{@code >}
     *     
     */
    public JAXBElement<ArrayOfLabel> getGetLabelsResult() {
        return getLabelsResult;
    }

    /**
     * Sets the value of the getLabelsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfLabel }{@code >}
     *     
     */
    public void setGetLabelsResult(JAXBElement<ArrayOfLabel> value) {
        this.getLabelsResult = ((JAXBElement<ArrayOfLabel> ) value);
    }

}
