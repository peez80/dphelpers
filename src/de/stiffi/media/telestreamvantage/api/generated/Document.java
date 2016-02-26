
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Document complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Document">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary}Element">
 *       &lt;sequence>
 *         &lt;element name="xmlns" type="{http://schemas.datacontract.org/2004/07/System.Xml.Serialization}XmlSerializerNamespaces"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", namespace = "http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary", propOrder = {
    "xmlns"
})
@XmlSeeAlso({
    Context.class,
    History.class,
    Unique.class
})
public class Document
    extends Element
{

    @XmlElement(required = true, nillable = true)
    protected XmlSerializerNamespaces xmlns;

    /**
     * Gets the value of the xmlns property.
     * 
     * @return
     *     possible object is
     *     {@link XmlSerializerNamespaces }
     *     
     */
    public XmlSerializerNamespaces getXmlns() {
        return xmlns;
    }

    /**
     * Sets the value of the xmlns property.
     * 
     * @param value
     *     allowed object is
     *     {@link XmlSerializerNamespaces }
     *     
     */
    public void setXmlns(XmlSerializerNamespaces value) {
        this.xmlns = value;
    }

}
