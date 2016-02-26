
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AudioSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AudioSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Unique">
 *       &lt;sequence>
 *         &lt;element name="Ancillary" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Bitrate" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="BitsPerSample" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="Channels" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="Codec" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Samplerate" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AudioSummary", propOrder = {
    "ancillary",
    "bitrate",
    "bitsPerSample",
    "channels",
    "codec",
    "samplerate"
})
public class AudioSummary
    extends Unique
{

    @XmlElementRef(name = "Ancillary", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> ancillary;
    @XmlElementRef(name = "Bitrate", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> bitrate;
    @XmlElementRef(name = "BitsPerSample", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> bitsPerSample;
    @XmlElementRef(name = "Channels", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> channels;
    @XmlElementRef(name = "Codec", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> codec;
    @XmlElementRef(name = "Samplerate", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> samplerate;

    /**
     * Gets the value of the ancillary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getAncillary() {
        return ancillary;
    }

    /**
     * Sets the value of the ancillary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setAncillary(JAXBElement<FieldOfstring> value) {
        this.ancillary = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the bitrate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getBitrate() {
        return bitrate;
    }

    /**
     * Sets the value of the bitrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setBitrate(JAXBElement<FieldOfint> value) {
        this.bitrate = ((JAXBElement<FieldOfint> ) value);
    }

    /**
     * Gets the value of the bitsPerSample property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getBitsPerSample() {
        return bitsPerSample;
    }

    /**
     * Sets the value of the bitsPerSample property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setBitsPerSample(JAXBElement<FieldOfint> value) {
        this.bitsPerSample = ((JAXBElement<FieldOfint> ) value);
    }

    /**
     * Gets the value of the channels property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getChannels() {
        return channels;
    }

    /**
     * Sets the value of the channels property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setChannels(JAXBElement<FieldOfint> value) {
        this.channels = ((JAXBElement<FieldOfint> ) value);
    }

    /**
     * Gets the value of the codec property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getCodec() {
        return codec;
    }

    /**
     * Sets the value of the codec property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setCodec(JAXBElement<FieldOfstring> value) {
        this.codec = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the samplerate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getSamplerate() {
        return samplerate;
    }

    /**
     * Sets the value of the samplerate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setSamplerate(JAXBElement<FieldOfint> value) {
        this.samplerate = ((JAXBElement<FieldOfint> ) value);
    }

}
