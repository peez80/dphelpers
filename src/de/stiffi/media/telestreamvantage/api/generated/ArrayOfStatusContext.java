
package de.stiffi.media.telestreamvantage.api.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfStatusContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfStatusContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusContext" type="{http://Telestream.Vantage.Sdk/2010/07}StatusContext" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfStatusContext", propOrder = {
    "statusContext"
})
public class ArrayOfStatusContext {

    @XmlElement(name = "StatusContext", nillable = true)
    protected List<StatusContext> statusContext;

    /**
     * Gets the value of the statusContext property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statusContext property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatusContext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusContext }
     * 
     * 
     */
    public List<StatusContext> getStatusContext() {
        if (statusContext == null) {
            statusContext = new ArrayList<StatusContext>();
        }
        return this.statusContext;
    }

}
