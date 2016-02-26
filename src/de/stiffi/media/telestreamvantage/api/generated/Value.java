
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Value complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Value">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary}Element">
 *       &lt;sequence>
 *         &lt;element name="ComplexValue" type="{http://Telestream.Vantage.Sdk/2010/07}Complex" minOccurs="0"/>
 *         &lt;element name="Text" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Value", propOrder = {
    "complexValue",
    "text"
})
@XmlSeeAlso({
    TrackTrackValue.class,
    Constraint.class,
    FieldOfstring.class,
    FieldOfanyURI.class,
    Complex.class,
    Property.class,
    FieldOflong.class,
    FieldOfint.class,
    FieldOfboolean.class,
    BindableFieldOfanyURI.class,
    ConditionValue.class,
    FieldOfdouble.class,
    FieldOfguid.class
})
public class Value
    extends Element
{

    @XmlElementRef(name = "ComplexValue", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<Complex> complexValue;
    @XmlElementRef(name = "Text", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfstring> text;

    /**
     * Gets the value of the complexValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Complex }{@code >}
     *     
     */
    public JAXBElement<Complex> getComplexValue() {
        return complexValue;
    }

    /**
     * Sets the value of the complexValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Complex }{@code >}
     *     
     */
    public void setComplexValue(JAXBElement<Complex> value) {
        this.complexValue = ((JAXBElement<Complex> ) value);
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setText(JAXBElement<ArrayOfstring> value) {
        this.text = ((JAXBElement<ArrayOfstring> ) value);
    }

}
