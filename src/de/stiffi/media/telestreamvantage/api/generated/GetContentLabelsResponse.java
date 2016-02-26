
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
 *         &lt;element name="GetContentLabelsResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfItemType" minOccurs="0"/>
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
    "getContentLabelsResult"
})
@XmlRootElement(name = "GetContentLabelsResponse")
public class GetContentLabelsResponse {

    @XmlElementRef(name = "GetContentLabelsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfItemType> getContentLabelsResult;

    /**
     * Gets the value of the getContentLabelsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfItemType> getGetContentLabelsResult() {
        return getContentLabelsResult;
    }

    /**
     * Sets the value of the getContentLabelsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfItemType }{@code >}
     *     
     */
    public void setGetContentLabelsResult(JAXBElement<ArrayOfItemType> value) {
        this.getContentLabelsResult = ((JAXBElement<ArrayOfItemType> ) value);
    }

}
