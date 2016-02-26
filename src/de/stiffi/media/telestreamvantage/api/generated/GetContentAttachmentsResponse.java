
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
 *         &lt;element name="GetContentAttachmentsResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfItemType" minOccurs="0"/>
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
    "getContentAttachmentsResult"
})
@XmlRootElement(name = "GetContentAttachmentsResponse")
public class GetContentAttachmentsResponse {

    @XmlElementRef(name = "GetContentAttachmentsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfItemType> getContentAttachmentsResult;

    /**
     * Gets the value of the getContentAttachmentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfItemType> getGetContentAttachmentsResult() {
        return getContentAttachmentsResult;
    }

    /**
     * Sets the value of the getContentAttachmentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}
     *     
     */
    public void setGetContentAttachmentsResult(JAXBElement<ArrayOfItemType> value) {
        this.getContentAttachmentsResult = ((JAXBElement<ArrayOfItemType> ) value);
    }

}
