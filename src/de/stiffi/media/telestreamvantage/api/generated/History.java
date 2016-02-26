
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for History complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="History">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary}Document">
 *       &lt;sequence>
 *         &lt;element name="Contexts" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfStatusContext" minOccurs="0"/>
 *         &lt;element name="Operations" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfOperation" minOccurs="0"/>
 *         &lt;element name="Relevant" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *         &lt;element name="Retries" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "History", propOrder = {
    "contexts",
    "operations",
    "relevant",
    "retries"
})
public class History
    extends Document
{

    @XmlElementRef(name = "Contexts", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfStatusContext> contexts;
    @XmlElementRef(name = "Operations", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfOperation> operations;
    @XmlElement(name = "Relevant")
    protected String relevant;
    @XmlElement(name = "Retries")
    protected Integer retries;

    /**
     * Gets the value of the contexts property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfStatusContext }{@code >}
     *     
     */
    public JAXBElement<ArrayOfStatusContext> getContexts() {
        return contexts;
    }

    /**
     * Sets the value of the contexts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfStatusContext }{@code >}
     *     
     */
    public void setContexts(JAXBElement<ArrayOfStatusContext> value) {
        this.contexts = ((JAXBElement<ArrayOfStatusContext> ) value);
    }

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOperation }{@code >}
     *     
     */
    public JAXBElement<ArrayOfOperation> getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfOperation }{@code >}
     *     
     */
    public void setOperations(JAXBElement<ArrayOfOperation> value) {
        this.operations = ((JAXBElement<ArrayOfOperation> ) value);
    }

    /**
     * Gets the value of the relevant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelevant() {
        return relevant;
    }

    /**
     * Sets the value of the relevant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelevant(String value) {
        this.relevant = value;
    }

    /**
     * Gets the value of the retries property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRetries() {
        return retries;
    }

    /**
     * Sets the value of the retries property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRetries(Integer value) {
        this.retries = value;
    }

}
