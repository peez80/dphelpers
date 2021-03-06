
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
 *         &lt;element name="GetVariableResult" type="{http://Telestream.Vantage.Sdk/2010/07}Condition" minOccurs="0"/>
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
    "getVariableResult"
})
@XmlRootElement(name = "GetVariableResponse")
public class GetVariableResponse {

    @XmlElementRef(name = "GetVariableResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<Condition> getVariableResult;

    /**
     * Gets the value of the getVariableResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Condition }{@code >}
     *     
     */
    public JAXBElement<Condition> getGetVariableResult() {
        return getVariableResult;
    }

    /**
     * Sets the value of the getVariableResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Condition }{@code >}
     *     
     */
    public void setGetVariableResult(JAXBElement<Condition> value) {
        this.getVariableResult = ((JAXBElement<Condition> ) value);
    }

}
