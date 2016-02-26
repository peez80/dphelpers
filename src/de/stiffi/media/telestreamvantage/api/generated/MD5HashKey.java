
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MD5HashKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MD5HashKey">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Manifest">
 *       &lt;sequence>
 *         &lt;element name="Key" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MD5HashKey", propOrder = {
    "key"
})
public class MD5HashKey
    extends Manifest
{

    @XmlElementRef(name = "Key", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> key;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setKey(JAXBElement<FieldOfstring> value) {
        this.key = ((JAXBElement<FieldOfstring> ) value);
    }

}
