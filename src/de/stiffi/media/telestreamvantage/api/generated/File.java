
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for File complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="File">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Unique">
 *       &lt;sequence>
 *         &lt;element name="Location" type="{http://Telestream.Vantage.Sdk/2010/07}UriField" minOccurs="0"/>
 *         &lt;element name="Path" type="{http://Telestream.Vantage.Sdk/2010/07}UriField" minOccurs="0"/>
 *         &lt;element name="PathRelevantEnabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "File", propOrder = {
    "location",
    "path",
    "pathRelevantEnabled"
})
public class File
    extends Unique
{

    @XmlElementRef(name = "Location", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<UriField> location;
    @XmlElementRef(name = "Path", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<UriField> path;
    @XmlElementRef(name = "PathRelevantEnabled", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<String> pathRelevantEnabled;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UriField }{@code >}
     *     
     */
    public JAXBElement<UriField> getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UriField }{@code >}
     *     
     */
    public void setLocation(JAXBElement<UriField> value) {
        this.location = ((JAXBElement<UriField> ) value);
    }

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UriField }{@code >}
     *     
     */
    public JAXBElement<UriField> getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UriField }{@code >}
     *     
     */
    public void setPath(JAXBElement<UriField> value) {
        this.path = ((JAXBElement<UriField> ) value);
    }

    /**
     * Gets the value of the pathRelevantEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPathRelevantEnabled() {
        return pathRelevantEnabled;
    }

    /**
     * Sets the value of the pathRelevantEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPathRelevantEnabled(JAXBElement<String> value) {
        this.pathRelevantEnabled = ((JAXBElement<String> ) value);
    }

}
