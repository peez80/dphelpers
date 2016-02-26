
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MetaSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MetaSummary">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Unique">
 *       &lt;sequence>
 *         &lt;element name="Abstract" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Ancillary" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Author" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Copyright" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Rating" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetaSummary", propOrder = {
    "_abstract",
    "ancillary",
    "author",
    "copyright",
    "rating",
    "title"
})
public class MetaSummary
    extends Unique
{

    @XmlElementRef(name = "Abstract", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> _abstract;
    @XmlElementRef(name = "Ancillary", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> ancillary;
    @XmlElementRef(name = "Author", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> author;
    @XmlElementRef(name = "Copyright", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> copyright;
    @XmlElementRef(name = "Rating", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> rating;
    @XmlElementRef(name = "Title", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> title;

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setAbstract(JAXBElement<FieldOfstring> value) {
        this._abstract = ((JAXBElement<FieldOfstring> ) value);
    }

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
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setAuthor(JAXBElement<FieldOfstring> value) {
        this.author = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the copyright property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getCopyright() {
        return copyright;
    }

    /**
     * Sets the value of the copyright property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setCopyright(JAXBElement<FieldOfstring> value) {
        this.copyright = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setRating(JAXBElement<FieldOfstring> value) {
        this.rating = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setTitle(JAXBElement<FieldOfstring> value) {
        this.title = ((JAXBElement<FieldOfstring> ) value);
    }

}
