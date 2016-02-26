
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
 *         &lt;element name="GetWorkflowResult" type="{http://Telestream.Vantage.Sdk/2010/07}Procedure" minOccurs="0"/>
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
    "getWorkflowResult"
})
@XmlRootElement(name = "GetWorkflowResponse")
public class GetWorkflowResponse {

    @XmlElementRef(name = "GetWorkflowResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<Procedure> getWorkflowResult;

    /**
     * Gets the value of the getWorkflowResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Procedure }{@code >}
     *     
     */
    public JAXBElement<Procedure> getGetWorkflowResult() {
        return getWorkflowResult;
    }

    /**
     * Sets the value of the getWorkflowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Procedure }{@code >}
     *     
     */
    public void setGetWorkflowResult(JAXBElement<Procedure> value) {
        this.getWorkflowResult = ((JAXBElement<Procedure> ) value);
    }

}
