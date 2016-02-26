
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Store complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Store">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Item">
 *       &lt;sequence>
 *         &lt;element name="Data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="EncodingFallback" type="{http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary}TextEncoderFallback" minOccurs="0"/>
 *         &lt;element name="Manifests" type="{http://Telestream.Vantage.Sdk/2010/07}ManifestList" minOccurs="0"/>
 *         &lt;element name="OutputEncoding" type="{http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary}TextEncoding" minOccurs="0"/>
 *         &lt;element name="Position" type="{http://Telestream.Vantage.Sdk/2010/07}StorePosition" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Store", propOrder = {
    "data",
    "encodingFallback",
    "manifests",
    "outputEncoding",
    "position"
})
public class Store
    extends Item
{

    @XmlElementRef(name = "Data", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<byte[]> data;
    @XmlElement(name = "EncodingFallback")
    protected TextEncoderFallback encodingFallback;
    @XmlElementRef(name = "Manifests", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ManifestList> manifests;
    @XmlElement(name = "OutputEncoding")
    protected TextEncoding outputEncoding;
    @XmlElement(name = "Position")
    protected StorePosition position;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public JAXBElement<byte[]> getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     *     
     */
    public void setData(JAXBElement<byte[]> value) {
        this.data = ((JAXBElement<byte[]> ) value);
    }

    /**
     * Gets the value of the encodingFallback property.
     * 
     * @return
     *     possible object is
     *     {@link TextEncoderFallback }
     *     
     */
    public TextEncoderFallback getEncodingFallback() {
        return encodingFallback;
    }

    /**
     * Sets the value of the encodingFallback property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextEncoderFallback }
     *     
     */
    public void setEncodingFallback(TextEncoderFallback value) {
        this.encodingFallback = value;
    }

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

    /**
     * Gets the value of the outputEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link TextEncoding }
     *     
     */
    public TextEncoding getOutputEncoding() {
        return outputEncoding;
    }

    /**
     * Sets the value of the outputEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextEncoding }
     *     
     */
    public void setOutputEncoding(TextEncoding value) {
        this.outputEncoding = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link StorePosition }
     *     
     */
    public StorePosition getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorePosition }
     *     
     */
    public void setPosition(StorePosition value) {
        this.position = value;
    }

}
