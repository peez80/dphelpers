
package de.stiffi.media.telestreamvantage.api.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTrack.TrackValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTrack.TrackValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Track.TrackValue" type="{http://Telestream.Vantage.Sdk/2010/07}Track.TrackValue" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTrack.TrackValue", propOrder = {
    "trackTrackValue"
})
public class ArrayOfTrackTrackValue {

    @XmlElement(name = "Track.TrackValue", nillable = true)
    protected List<TrackTrackValue> trackTrackValue;

    /**
     * Gets the value of the trackTrackValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trackTrackValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrackTrackValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrackTrackValue }
     * 
     * 
     */
    public List<TrackTrackValue> getTrackTrackValue() {
        if (trackTrackValue == null) {
            trackTrackValue = new ArrayList<TrackTrackValue>();
        }
        return this.trackTrackValue;
    }

}
