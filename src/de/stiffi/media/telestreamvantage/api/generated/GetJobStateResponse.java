
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetJobStateResult" type="{http://Telestream.Vantage.Sdk/2010/07}WorkflowJobState" minOccurs="0"/>
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
    "getJobStateResult"
})
@XmlRootElement(name = "GetJobStateResponse")
public class GetJobStateResponse {

    @XmlElement(name = "GetJobStateResult")
    protected WorkflowJobState getJobStateResult;

    /**
     * Gets the value of the getJobStateResult property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowJobState }
     *     
     */
    public WorkflowJobState getGetJobStateResult() {
        return getJobStateResult;
    }

    /**
     * Sets the value of the getJobStateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowJobState }
     *     
     */
    public void setGetJobStateResult(WorkflowJobState value) {
        this.getJobStateResult = value;
    }

}
