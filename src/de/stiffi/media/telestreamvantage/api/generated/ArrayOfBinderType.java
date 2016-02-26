
package de.stiffi.media.telestreamvantage.api.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBinderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBinderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BinderType" type="{http://Telestream.Vantage.Sdk/2010/07}BinderType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBinderType", propOrder = {
    "binderType"
})
public class ArrayOfBinderType {

    @XmlElement(name = "BinderType", nillable = true)
    protected List<BinderType> binderType;

    /**
     * Gets the value of the binderType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the binderType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBinderType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BinderType }
     * 
     * 
     */
    public List<BinderType> getBinderType() {
        if (binderType == null) {
            binderType = new ArrayList<BinderType>();
        }
        return this.binderType;
    }

}
