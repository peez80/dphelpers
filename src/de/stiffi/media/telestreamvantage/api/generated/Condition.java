
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Condition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Condition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Component">
 *       &lt;sequence>
 *         &lt;element name="ConditionValue" type="{http://Telestream.Vantage.Sdk/2010/07}ConditionValue" minOccurs="0"/>
 *         &lt;element name="TypeCode" type="{http://Telestream.Vantage.Sdk/2010/07}TypeCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Condition", propOrder = {
    "conditionValue",
    "typeCode"
})
public class Condition
    extends Component
{

    @XmlElementRef(name = "ConditionValue", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ConditionValue> conditionValue;
    @XmlElement(name = "TypeCode")
    protected TypeCode typeCode;

    /**
     * Gets the value of the conditionValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionValue }{@code >}
     *     
     */
    public JAXBElement<ConditionValue> getConditionValue() {
        return conditionValue;
    }

    /**
     * Sets the value of the conditionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionValue }{@code >}
     *     
     */
    public void setConditionValue(JAXBElement<ConditionValue> value) {
        this.conditionValue = ((JAXBElement<ConditionValue> ) value);
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

}
