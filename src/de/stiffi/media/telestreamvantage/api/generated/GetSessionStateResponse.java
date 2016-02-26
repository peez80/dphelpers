
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
 *         &lt;element name="GetSessionStateResult" type="{http://Telestream.Vantage.Sdk/2010/07}JobSessionState" minOccurs="0"/>
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
    "getSessionStateResult"
})
@XmlRootElement(name = "GetSessionStateResponse")
public class GetSessionStateResponse {

    @XmlElement(name = "GetSessionStateResult")
    protected JobSessionState getSessionStateResult;

    /**
     * Gets the value of the getSessionStateResult property.
     * 
     * @return
     *     possible object is
     *     {@link JobSessionState }
     *     
     */
    public JobSessionState getGetSessionStateResult() {
        return getSessionStateResult;
    }

    /**
     * Sets the value of the getSessionStateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobSessionState }
     *     
     */
    public void setGetSessionStateResult(JobSessionState value) {
        this.getSessionStateResult = value;
    }

}
