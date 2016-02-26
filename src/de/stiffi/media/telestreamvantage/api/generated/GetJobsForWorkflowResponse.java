
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
 *         &lt;element name="GetJobsForWorkflowResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfJobType" minOccurs="0"/>
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
    "getJobsForWorkflowResult"
})
@XmlRootElement(name = "GetJobsForWorkflowResponse")
public class GetJobsForWorkflowResponse {

    @XmlElementRef(name = "GetJobsForWorkflowResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfJobType> getJobsForWorkflowResult;

    /**
     * Gets the value of the getJobsForWorkflowResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfJobType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfJobType> getGetJobsForWorkflowResult() {
        return getJobsForWorkflowResult;
    }

    /**
     * Sets the value of the getJobsForWorkflowResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfJobType }{@code >}
     *     
     */
    public void setGetJobsForWorkflowResult(JAXBElement<ArrayOfJobType> value) {
        this.getJobsForWorkflowResult = ((JAXBElement<ArrayOfJobType> ) value);
    }

}
