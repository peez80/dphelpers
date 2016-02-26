
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Media complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Media">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Item">
 *       &lt;sequence>
 *         &lt;element name="Manifests" type="{http://Telestream.Vantage.Sdk/2010/07}ManifestList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Media", propOrder = {
    "manifests"
})
public class Media
    extends Item
{

    @XmlElementRef(name = "Manifests", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ManifestList> manifests;

    /**
     * Gets the value of the manifests property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ManifestList }{@code >}
     *     
     */
    public JAXBElement<ManifestList> getManifests() {
        return manifests;
    }

    /**
     * Sets the value of the manifests property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ManifestList }{@code >}
     *     
     */
    public void setManifests(JAXBElement<ManifestList> value) {
        this.manifests = ((JAXBElement<ManifestList> ) value);
    }

}
