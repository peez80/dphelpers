
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
 *         &lt;element name="GetWorkflowStateResult" type="{http://Telestream.Vantage.Sdk/2010/07}WorkflowState" minOccurs="0"/>
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
    "getWorkflowStateResult"
})
@XmlRootElement(name = "GetWorkflowStateResponse")
public class GetWorkflowStateResponse {

    @XmlElement(name = "GetWorkflowStateResult")
    protected WorkflowState getWorkflowStateResult;

    /**
     * Gets the value of the getWorkflowStateResult property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowState }
     *     
     */
    public WorkflowState getGetWorkflowStateResult() {
        return getWorkflowStateResult;
    }

    /**
     * Sets the value of the getWorkflowStateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowState }
     *     
     */
    public void setGetWorkflowStateResult(WorkflowState value) {
        this.getWorkflowStateResult = value;
    }

}
