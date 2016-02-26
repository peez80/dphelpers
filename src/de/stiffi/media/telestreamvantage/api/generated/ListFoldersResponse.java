
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
 *         &lt;element name="ListFoldersResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfFolderType" minOccurs="0"/>
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
    "listFoldersResult"
})
@XmlRootElement(name = "ListFoldersResponse")
public class ListFoldersResponse {

    @XmlElementRef(name = "ListFoldersResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfFolderType> listFoldersResult;

    /**
     * Gets the value of the listFoldersResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFolderType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfFolderType> getListFoldersResult() {
        return listFoldersResult;
    }

    /**
     * Sets the value of the listFoldersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfFolderType }{@code >}
     *     
     */
    public void setListFoldersResult(JAXBElement<ArrayOfFolderType> value) {
        this.listFoldersResult = ((JAXBElement<ArrayOfFolderType> ) value);
    }

}
