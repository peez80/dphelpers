
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
 *         &lt;element name="GetContentsForJobResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfContentType" minOccurs="0"/>
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
    "getContentsForJobResult"
})
@XmlRootElement(name = "GetContentsForJobResponse")
public class GetContentsForJobResponse {

    @XmlElementRef(name = "GetContentsForJobResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfContentType> getContentsForJobResult;

    /**
     * Gets the value of the getContentsForJobResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfContentType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfContentType> getGetContentsForJobResult() {
        return getContentsForJobResult;
    }

    /**
     * Sets the value of the getContentsForJobResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfContentType }{@code >}
     *     
     */
    public void setGetContentsForJobResult(JAXBElement<ArrayOfContentType> value) {
        this.getContentsForJobResult = ((JAXBElement<ArrayOfContentType> ) value);
    }

}
