
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FormatSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FormatSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Unique">
 *       &lt;sequence>
 *         &lt;element name="Ancillary" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Bitrate" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfint" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Duration" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="FileSize" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOflong" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormatSummary", propOrder = {
    "ancillary",
    "bitrate",
    "description",
    "duration",
    "fileName",
    "fileSize"
})
public class FormatSummary
    extends Unique
{

    @XmlElementRef(name = "Ancillary", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> ancillary;
    @XmlElementRef(name = "Bitrate", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfint> bitrate;
    @XmlElementRef(name = "Description", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> description;
    @XmlElementRef(name = "Duration", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> duration;
    @XmlElementRef(name = "FileName", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> fileName;
    @XmlElementRef(name = "FileSize", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOflong> fileSize;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setDescription(JAXBElement<FieldOfstring> value) {
        this.description = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setDuration(JAXBElement<FieldOfstring> value) {
        this.duration = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setFileName(JAXBElement<FieldOfstring> value) {
        this.fileName = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOflong }{@code >}
     *     
     */
    public JAXBElement<FieldOflong> getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOflong }{@code >}
     *     
     */
    public void setFileSize(JAXBElement<FieldOflong> value) {
        this.fileSize = ((JAXBElement<FieldOflong> ) value);
    }

}
