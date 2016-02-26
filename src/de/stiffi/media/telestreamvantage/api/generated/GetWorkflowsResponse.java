
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
 *         &lt;element name="GetWorkflowsResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfProcedure" minOccurs="0"/>
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
    "getWorkflowsResult"
})
@XmlRootElement(name = "GetWorkflowsResponse")
public class GetWorkflowsResponse {

    @XmlElementRef(name = "GetWorkflowsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfProcedure> getWorkflowsResult;

    /**
     * Gets the value of the getWorkflowsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProcedure }{@code >}
     *     
     */
    public JAXBElement<ArrayOfProcedure> getGetWorkflowsResult() {
        return getWorkflowsResult;
    }

    /**
     * Sets the value of the getWorkflowsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfProcedure }{@code >}
     *     
     */
    public void setGetWorkflowsResult(JAXBElement<ArrayOfProcedure> value) {
        this.getWorkflowsResult = ((JAXBElement<ArrayOfProcedure> ) value);
    }

}
