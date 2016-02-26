
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Track complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Track">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Item">
 *       &lt;sequence>
 *         &lt;element name="TimeScale" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{http://Telestream.Vantage.Sdk/2010/07}TypeCode" minOccurs="0"/>
 *         &lt;element name="Values" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfTrack.TrackValue" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Track", propOrder = {
    "timeScale",
    "typeCode",
    "values"
})
public class Track
    extends Item
{

    @XmlElement(name = "TimeScale")
    protected Long timeScale;
    @XmlElement(name = "TypeCode")
    protected TypeCode typeCode;
    @XmlElementRef(name = "Values", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfTrackTrackValue> values;

    /**
     * Gets the value of the timeScale property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeScale() {
        return timeScale;
    }

    /**
     * Sets the value of the timeScale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeScale(Long value) {
        this.timeScale = value;
    }

    /**
     * Gets the value of the typeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TypeCode }
     *     
     */
    public TypeCode getTypeCode() {
        return typeCode;
    }

    /**
     * Sets the value of the typeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeCode }
     *     
     */
    public void setTypeCode(TypeCode value) {
        this.typeCode = value;
    }

    /**
     * Gets the value of the values property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTrackTrackValue }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTrackTrackValue> getValues() {
        return values;
    }

    /**
     * Sets the value of the values property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTrackTrackValue }{@code >}
     *     
     */
    public void setValues(JAXBElement<ArrayOfTrackTrackValue> value) {
        this.values = ((JAXBElement<ArrayOfTrackTrackValue> ) value);
    }

}
