
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VideoSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Unique">
 *       &lt;sequence>
 *         &lt;element name="Ancillary" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="AspectHeight" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="AspectWidth" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="Bitrate" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="Chroma" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Codec" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Framerate" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfdouble" minOccurs="0"/>
 *         &lt;element name="Height" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="IFrame" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfboolean" minOccurs="0"/>
 *         &lt;element name="Interlaced" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfboolean" minOccurs="0"/>
 *         &lt;element name="Order" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfboolean" minOccurs="0"/>
 *         &lt;element name="Vbr" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfboolean" minOccurs="0"/>
 *         &lt;element name="Width" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VideoSummary", propOrder = {
    "ancillary",
    "aspectHeight",
    "aspectWidth",
    "bitrate",
    "chroma",
    "codec",
    "framerate",
    "height",
    "iFrame",
    "interlaced",
    "order",
    "vbr",
    "width"
})
public class VideoSummary
    extends Unique
{

    @XmlElementRef(name = "Ancillary", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> ancillary;
    @XmlElementRef(name = "AspectHeight", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> aspectHeight;
    @XmlElementRef(name = "AspectWidth", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> aspectWidth;
    @XmlElementRef(name = "Bitrate", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> bitrate;
    @XmlElementRef(name = "Chroma", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> chroma;
    @XmlElementRef(name = "Codec", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> codec;
    @XmlElementRef(name = "Framerate", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfdouble> framerate;
    @XmlElementRef(name = "Height", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> height;
    @XmlElementRef(name = "IFrame", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfboolean> iFrame;
    @XmlElementRef(name = "Interlaced", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfboolean> interlaced;
    @XmlElementRef(name = "Order", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfboolean> order;
    @XmlElementRef(name = "Vbr", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfboolean> vbr;
    @XmlElementRef(name = "Width", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> width;

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
     * Gets the value of the aspectHeight property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getAspectHeight() {
        return aspectHeight;
    }

    /**
     * Sets the value of the aspectHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setAspectHeight(JAXBElement<FieldOfint> value) {
        this.aspectHeight = ((JAXBElement<FieldOfint> ) value);
    }

    /**
     * Gets the value of the aspectWidth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getAspectWidth() {
        return aspectWidth;
    }

    /**
     * Sets the value of the aspectWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setAspectWidth(JAXBElement<FieldOfint> value) {
        this.aspectWidth = ((JAXBElement<FieldOfint> ) value);
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
     * Gets the value of the chroma property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getChroma() {
        return chroma;
    }

    /**
     * Sets the value of the chroma property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setChroma(JAXBElement<FieldOfstring> value) {
        this.chroma = ((JAXBElement<FieldOfstring> ) value);
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
     * Gets the value of the framerate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfdouble }{@code >}
     *     
     */
    public JAXBElement<FieldOfdouble> getFramerate() {
        return framerate;
    }

    /**
     * Sets the value of the framerate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfdouble }{@code >}
     *     
     */
    public void setFramerate(JAXBElement<FieldOfdouble> value) {
        this.framerate = ((JAXBElement<FieldOfdouble> ) value);
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setHeight(JAXBElement<FieldOfint> value) {
        this.height = ((JAXBElement<FieldOfint> ) value);
    }

    /**
     * Gets the value of the iFrame property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public JAXBElement<FieldOfboolean> getIFrame() {
        return iFrame;
    }

    /**
     * Sets the value of the iFrame property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public void setIFrame(JAXBElement<FieldOfboolean> value) {
        this.iFrame = ((JAXBElement<FieldOfboolean> ) value);
    }

    /**
     * Gets the value of the interlaced property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public JAXBElement<FieldOfboolean> getInterlaced() {
        return interlaced;
    }

    /**
     * Sets the value of the interlaced property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public void setInterlaced(JAXBElement<FieldOfboolean> value) {
        this.interlaced = ((JAXBElement<FieldOfboolean> ) value);
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public JAXBElement<FieldOfboolean> getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public void setOrder(JAXBElement<FieldOfboolean> value) {
        this.order = ((JAXBElement<FieldOfboolean> ) value);
    }

    /**
     * Gets the value of the vbr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public JAXBElement<FieldOfboolean> getVbr() {
        return vbr;
    }

    /**
     * Sets the value of the vbr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfboolean }{@code >}
     *     
     */
    public void setVbr(JAXBElement<FieldOfboolean> value) {
        this.vbr = ((JAXBElement<FieldOfboolean> ) value);
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public JAXBElement<FieldOfint> getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfint }{@code >}
     *     
     */
    public void setWidth(JAXBElement<FieldOfint> value) {
        this.width = ((JAXBElement<FieldOfint> ) value);
    }

}
