
package de.stiffi.media.telestreamvantage.api.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileProperties">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Telestream.Vantage.Sdk/2010/07}Manifest">
 *       &lt;sequence>
 *         &lt;element name="FileExtension" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="FileName" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfstring" minOccurs="0"/>
 *         &lt;element name="FilePath" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOfanyURI" minOccurs="0"/>
 *         &lt;element name="FileSize" type="{http://Telestream.Vantage.Sdk/2010/07}FieldOflong" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileProperties", propOrder = {
    "fileExtension",
    "fileName",
    "filePath",
    "fileSize"
})
public class FileProperties
    extends Manifest
{

    @XmlElementRef(name = "FileExtension", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> fileExtension;
    @XmlElementRef(name = "FileName", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfstring> fileName;
    @XmlElementRef(name = "FilePath", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOfanyURI> filePath;
    @XmlElementRef(name = "FileSize", namespace = "http://Telestream.Vantage.Sdk/2010/07", type = JAXBElement.class)
    protected JAXBElement<FieldOflong> fileSize;

    /**
     * Gets the value of the fileExtension property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getFileExtension() {
        return fileExtension;
    }

    /**
     * Sets the value of the fileExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setFileExtension(JAXBElement<FieldOfstring> value) {
        this.fileExtension = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public JAXBElement<FieldOfstring> getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfstring }{@code >}
     *     
     */
    public void setFileName(JAXBElement<FieldOfstring> value) {
        this.fileName = ((JAXBElement<FieldOfstring> ) value);
    }

    /**
     * Gets the value of the filePath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOfanyURI }{@code >}
     *     
     */
    public JAXBElement<FieldOfanyURI> getFilePath() {
        return filePath;
    }

    /**
     * Sets the value of the filePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOfanyURI }{@code >}
     *     
     */
    public void setFilePath(JAXBElement<FieldOfanyURI> value) {
        this.filePath = ((JAXBElement<FieldOfanyURI> ) value);
    }

    /**
     * Gets the value of the fileSize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FieldOflong }{@code >}
     *     
     */
    public JAXBElement<FieldOflong> getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FieldOflong }{@code >}
     *     
     */
    public void setFileSize(JAXBElement<FieldOflong> value) {
        this.fileSize = ((JAXBElement<FieldOflong> ) value);
    }

}
