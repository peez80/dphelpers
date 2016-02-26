
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
 *         &lt;element name="GetCatalogsResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfFolderType" minOccurs="0"/>
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
    "getCatalogsResult"
})
@XmlRootElement(name = "GetCatalogsResponse")
public class GetCatalogsResponse {

    @XmlElementRef(name = "GetCatalogsResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfFolderType> getCatalogsResult;

    /**
     * Gets the value of the getCatalogsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFolderType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFolderType> getGetCatalogsResult() {
        return getCatalogsResult;
    }

    /**
     * Sets the value of the getCatalogsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFolderType }{@code >}
     *     
     */
    public void setGetCatalogsResult(JAXBElement<ArrayOfFolderType> value) {
        this.getCatalogsResult = ((JAXBElement<ArrayOfFolderType> ) value);
    }

}
