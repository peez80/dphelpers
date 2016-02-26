
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Summary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Summary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Manifest">
 *       &lt;sequence>
 *         &lt;element name="Audio" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfAudioSummary" minOccurs="0"/>
 *         &lt;element name="Format" type="{http://Telestream.Vantage.Sdk/2010/07}FormatSummary" minOccurs="0"/>
 *         &lt;element name="Meta" type="{http://Telestream.Vantage.Sdk/2010/07}MetaSummary" minOccurs="0"/>
 *         &lt;element name="Video" type="{http://Telestream.Vantage.Sdk/2010/07}VideoSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Summary", propOrder = {
    "audio",
    "format",
    "meta",
    "video"
})
public class Summary
    extends Manifest
{

    @XmlElementRef(name = "Audio", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfAudioSummary> audio;
    @XmlElementRef(name = "Format", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FormatSummary> format;
    @XmlElementRef(name = "Meta", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<MetaSummary> meta;
    @XmlElementRef(name = "Video", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<VideoSummary> video;

    /**
     * Gets the value of the audio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAudioSummary }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAudioSummary> getAudio() {
        return audio;
    }

    /**
     * Sets the value of the audio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAudioSummary }{@code >}
     *     
     */
    public void setAudio(JAXBElement<ArrayOfAudioSummary> value) {
        this.audio = ((JAXBElement<ArrayOfAudioSummary> ) value);
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FormatSummary }{@code >}
     *     
     */
    public JAXBElement<FormatSummary> getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FormatSummary }{@code >}
     *     
     */
    public void setFormat(JAXBElement<FormatSummary> value) {
        this.format = ((JAXBElement<FormatSummary> ) value);
    }

    /**
     * Gets the value of the meta property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MetaSummary }{@code >}
     *     
     */
    public JAXBElement<MetaSummary> getMeta() {
        return meta;
    }

    /**
     * Sets the value of the meta property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MetaSummary }{@code >}
     *     
     */
    public void setMeta(JAXBElement<MetaSummary> value) {
        this.meta = ((JAXBElement<MetaSummary> ) value);
    }

    /**
     * Gets the value of the video property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VideoSummary }{@code >}
     *     
     */
    public JAXBElement<VideoSummary> getVideo() {
        return video;
    }

    /**
     * Sets the value of the video property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VideoSummary }{@code >}
     *     
     */
    public void setVideo(JAXBElement<VideoSummary> value) {
        this.video = ((JAXBElement<VideoSummary> ) value);
    }

}
