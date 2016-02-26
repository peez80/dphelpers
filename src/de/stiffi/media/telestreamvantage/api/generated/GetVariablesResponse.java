
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
 *         &lt;element name="GetVariablesResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfCondition" minOccurs="0"/>
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
    "getVariablesResult"
})
@XmlRootElement(name = "GetVariablesResponse")
public class GetVariablesResponse {

    @XmlElementRef(name = "GetVariablesResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfCondition> getVariablesResult;

    /**
     * Gets the value of the getVariablesResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCondition }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCondition> getGetVariablesResult() {
        return getVariablesResult;
    }

    /**
     * Sets the value of the getVariablesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCondition }{@code >}
     *     
     */
    public void setGetVariablesResult(JAXBElement<ArrayOfCondition> value) {
        this.getVariablesResult = ((JAXBElement<ArrayOfCondition> ) value);
    }

}
