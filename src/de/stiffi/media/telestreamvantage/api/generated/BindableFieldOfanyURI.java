
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BindableFieldOfanyURI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BindableFieldOfanyURI">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Value">
 *       &lt;sequence>
 *         &lt;element name="Condition" type="{http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary}GuidField" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BindableFieldOfanyURI", propOrder = {
    "condition"
})
@XmlSeeAlso({
    UriField.class
})
public class BindableFieldOfanyURI
    extends Value
{

    @XmlElementRef(name = "Condition", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<GuidField> condition;

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GuidField }{@code >}
     *     
     */
    public JAXBElement<GuidField> getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GuidField }{@code >}
     *     
     */
    public void setCondition(JAXBElement<GuidField> value) {
        this.condition = ((JAXBElement<GuidField> ) value);
    }

}
