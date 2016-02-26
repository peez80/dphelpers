
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
 *         &lt;element name="GetCatalogResult" type="{http://Telestream.Vantage.Sdk/2010/07}FolderType" minOccurs="0"/>
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
    "getCatalogResult"
})
@XmlRootElement(name = "GetCatalogResponse")
public class GetCatalogResponse {

    @XmlElementRef(name = "GetCatalogResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FolderType> getCatalogResult;

    /**
     * Gets the value of the getCatalogResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FolderType }{@code >}
     *     
     */
    public JAXBElement<FolderType> getGetCatalogResult() {
        return getCatalogResult;
    }

    /**
     * Sets the value of the getCatalogResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FolderType }{@code >}
     *     
     */
    public void setGetCatalogResult(JAXBElement<FolderType> value) {
        this.getCatalogResult = ((JAXBElement<FolderType> ) value);
    }

}
