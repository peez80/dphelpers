
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
 *         &lt;element name="GetContentMediaResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfItemType" minOccurs="0"/>
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
    "getContentMediaResult"
})
@XmlRootElement(name = "GetContentMediaResponse")
public class GetContentMediaResponse {

    @XmlElementRef(name = "GetContentMediaResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfItemType> getContentMediaResult;

    /**
     * Gets the value of the getContentMediaResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfItemType> getGetContentMediaResult() {
        return getContentMediaResult;
    }

    /**
     * Sets the value of the getContentMediaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}
     *     
     */
    public void setGetContentMediaResult(JAXBElement<ArrayOfItemType> value) {
        this.getContentMediaResult = ((JAXBElement<ArrayOfItemType> ) value);
    }

}
