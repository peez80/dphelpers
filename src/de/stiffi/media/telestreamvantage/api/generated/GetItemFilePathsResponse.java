
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
 *         &lt;element name="GetItemFilePathsResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
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
    "getItemFilePathsResult"
})
@XmlRootElement(name = "GetItemFilePathsResponse")
public class GetItemFilePathsResponse {

    @XmlElementRef(name = "GetItemFilePathsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> getItemFilePathsResult;

    /**
     * Gets the value of the getItemFilePathsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getGetItemFilePathsResult() {
        return getItemFilePathsResult;
    }

    /**
     * Sets the value of the getItemFilePathsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setGetItemFilePathsResult(JAXBElement<ArrayOfstring> value) {
        this.getItemFilePathsResult = ((JAXBElement<ArrayOfstring> ) value);
    }

}
