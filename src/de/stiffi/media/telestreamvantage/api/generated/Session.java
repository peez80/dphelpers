
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Session complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Session">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/Telestream.Soa.Vocabulary}Element">
 *       &lt;sequence>
 *         &lt;element name="Completed" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Detail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Log" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfRecord" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PausedTimeInTicks" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="QueuedTimeInTicks" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Relevant" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *         &lt;element name="Started" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="State" type="{http://Telestream.Vantage.Sdk/2010/07}JobSessionState" minOccurs="0"/>
 *         &lt;element name="Tasks" type="{http://Telestream.Vantage.Sdk/2010/07}ArrayOfTask" minOccurs="0"/>
 *         &lt;element name="TotalRunTimeInTicks" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Session", propOrder = {
    "completed",
    "detail",
    "log",
    "name",
    "pausedTimeInTicks",
    "queuedTimeInTicks",
    "relevant",
    "started",
    "state",
    "tasks",
    "totalRunTimeInTicks"
})
public class Session
    extends Element
{

    @XmlElement(name = "Completed")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar completed;
    @XmlElementRef(name = "Detail", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<String> detail;
    @XmlElementRef(name = "Log", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfRecord> log;
    @XmlElementRef(name = "Name", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<String> name;
    @XmlElement(name = "PausedTimeInTicks")
    protected Long pausedTimeInTicks;
    @XmlElement(name = "QueuedTimeInTicks")
    protected Long queuedTimeInTicks;
    @XmlElement(name = "Relevant")
    protected String relevant;
    @XmlElement(name = "Started")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar started;
    @XmlElement(name = "State")
    protected JobSessionState state;
    @XmlElementRef(name = "Tasks", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<ArrayOfTask> tasks;
    @XmlElement(name = "TotalRunTimeInTicks")
    protected Long totalRunTimeInTicks;

    /**
     * Gets the value of the completed property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCompleted() {
        return completed;
    }

    /**
     * Sets the value of the completed property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCompleted(XMLGregorianCalendar value) {
        this.completed = value;
    }

    /**
     * Gets the value of the detail property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDetail() {
        return detail;
    }

    /**
     * Sets the value of the detail property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDetail(JAXBElement<String> value) {
        this.detail = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the log property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRecord }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRecord> getLog() {
        return log;
    }

    /**
     * Sets the value of the log property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRecord }{@code >}
     *     
     */
    public void setLog(JAXBElement<ArrayOfRecord> value) {
        this.log = ((JAXBElement<ArrayOfRecord> ) value);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the pausedTimeInTicks property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPausedTimeInTicks() {
        return pausedTimeInTicks;
    }

    /**
     * Sets the value of the pausedTimeInTicks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPausedTimeInTicks(Long value) {
        this.pausedTimeInTicks = value;
    }

    /**
     * Gets the value of the queuedTimeInTicks property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getQueuedTimeInTicks() {
        return queuedTimeInTicks;
    }

    /**
     * Sets the value of the queuedTimeInTicks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setQueuedTimeInTicks(Long value) {
        this.queuedTimeInTicks = value;
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
     * Gets the value of the started property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStarted() {
        return started;
    }

    /**
     * Sets the value of the started property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStarted(XMLGregorianCalendar value) {
        this.started = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link JobSessionState }
     *     
     */
    public JobSessionState getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobSessionState }
     *     
     */
    public void setState(JobSessionState value) {
        this.state = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTask }{@code >}
     *     
     */
    public JAXBElement<ArrayOfTask> getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfTask }{@code >}
     *     
     */
    public void setTasks(JAXBElement<ArrayOfTask> value) {
        this.tasks = ((JAXBElement<ArrayOfTask> ) value);
    }

    /**
     * Gets the value of the totalRunTimeInTicks property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalRunTimeInTicks() {
        return totalRunTimeInTicks;
    }

    /**
     * Sets the value of the totalRunTimeInTicks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalRunTimeInTicks(Long value) {
        this.totalRunTimeInTicks = value;
    }

}
