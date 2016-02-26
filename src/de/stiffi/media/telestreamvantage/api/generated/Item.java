
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Item">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Component">
 *       &lt;sequence>
 *         &lt;element name="Files" type="{http://Telestream.Vantage.Sdk/2010/07}UniqueListOfFileuZpbrClh" minOccurs="0"/>
 *         &lt;element name="Location" type="{http://Telestream.Vantage.Sdk/2010/07}UriField" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item", propOrder = {
    "files",
    "location"
})
@XmlSeeAlso({
    Track.class,
    Label.class,
    Media.class,
    Store.class
})
public class Item
    extends Component
{

    @XmlElementRef(name = "Files", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<UniqueListOfFileuZpbrClh> files;
    @XmlElementRef(name = "Location", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<UriField> location;

    /**
     * Gets the value of the files property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link UniqueListOfFileuZpbrClh }{@code >}
     *     
     */
    public JAXBElement<UniqueListOfFileuZpbrClh> getFiles() {
        return files;
    }

    /**
     * Sets the value of the files property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link UniqueListOfFileuZpbrClh }{@code >}
     *     
     */
    public void setFiles(JAXBElement<UniqueListOfFileuZpbrClh> value) {
        this.files = ((JAXBElement<UniqueListOfFileuZpbrClh> ) value);
    }

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

}
