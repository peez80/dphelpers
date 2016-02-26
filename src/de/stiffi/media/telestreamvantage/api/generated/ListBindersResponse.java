
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
 *         &lt;element name="ListBindersResult" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfBinderType" minOccurs="0"/>
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
    "listBindersResult"
})
@XmlRootElement(name = "ListBindersResponse")
public class ListBindersResponse {

    @XmlElementRef(name = "ListBindersResult", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfBinderType> listBindersResult;

    /**
     * Gets the value of the listBindersResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBinderType }{@code >}
     *     
     */
    public JAXBElement<ArrayOfBinderType> getListBindersResult() {
        return listBindersResult;
    }

    /**
     * Sets the value of the listBindersResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfBinderType }{@code >}
     *     
     */
    public void setListBindersResult(JAXBElement<ArrayOfBinderType> value) {
        this.listBindersResult = ((JAXBElement<ArrayOfBinderType> ) value);
    }

}
