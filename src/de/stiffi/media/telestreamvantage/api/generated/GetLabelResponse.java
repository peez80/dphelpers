
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
 *         &lt;element name="GetLabelResult" type="{http://Telestream.Vantage.Sdk/2010/07}Label" minOccurs="0"/>
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
    "getLabelResult"
})
@XmlRootElement(name = "GetLabelResponse")
public class GetLabelResponse {

    @XmlElementRef(name = "GetLabelResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<Label> getLabelResult;

    /**
     * Gets the value of the getLabelResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Label }{@code >}
     *     
     */
    public JAXBElement<Label> getGetLabelResult() {
        return getLabelResult;
    }

    /**
     * Sets the value of the getLabelResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Label }{@code >}
     *     
     */
    public void setGetLabelResult(JAXBElement<Label> value) {
        this.getLabelResult = ((JAXBElement<Label> ) value);
    }

}
