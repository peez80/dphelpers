
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
 *         &lt;element name="GetWorkflowItemRequirementsResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfItem" minOccurs="0"/>
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
    "getWorkflowItemRequirementsResult"
})
@XmlRootElement(name = "GetWorkflowItemRequirementsResponse")
public class GetWorkflowItemRequirementsResponse {

    @XmlElementRef(name = "GetWorkflowItemRequirementsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfItem> getWorkflowItemRequirementsResult;

    /**
     * Gets the value of the getWorkflowItemRequirementsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}
     *     
     */
    public JAXBElement<ArrayOfItem> getGetWorkflowItemRequirementsResult() {
        return getWorkflowItemRequirementsResult;
    }

    /**
     * Sets the value of the getWorkflowItemRequirementsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItem }{@code >}
     *     
     */
    public void setGetWorkflowItemRequirementsResult(JAXBElement<ArrayOfItem> value) {
        this.getWorkflowItemRequirementsResult = ((JAXBElement<ArrayOfItem> ) value);
    }

}
