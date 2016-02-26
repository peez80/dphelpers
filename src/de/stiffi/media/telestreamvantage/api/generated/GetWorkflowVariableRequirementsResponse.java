
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
 *         &lt;element name="GetWorkflowVariableRequirementsResult" type="{http://Telestream.Vantage.Sdk/2010/07}Context" minOccurs="0"/>
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
    "getWorkflowVariableRequirementsResult"
})
@XmlRootElement(name = "GetWorkflowVariableRequirementsResponse")
public class GetWorkflowVariableRequirementsResponse {

    @XmlElementRef(name = "GetWorkflowVariableRequirementsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<Context> getWorkflowVariableRequirementsResult;

    /**
     * Gets the value of the getWorkflowVariableRequirementsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Context }{@code >}
     *     
     */
    public JAXBElement<Context> getGetWorkflowVariableRequirementsResult() {
        return getWorkflowVariableRequirementsResult;
    }

    /**
     * Sets the value of the getWorkflowVariableRequirementsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Context }{@code >}
     *     
     */
    public void setGetWorkflowVariableRequirementsResult(JAXBElement<Context> value) {
        this.getWorkflowVariableRequirementsResult = ((JAXBElement<Context> ) value);
    }

}
