
package de.stiffi.media.telestreamvantage.api.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IFile", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IFile {


    /**
     * 
     * @param identifier
     * @return
     *     returns de.stiffi.media.telestreamvantage.api.generated.FileType
     * @throws IFileGetFileUnlicensedSdkExceptionFaultFaultMessage
     * @throws IFileGetFileContentDoesNotExistExceptionFaultFaultMessage
     */
    @WebMethod(operationName = "GetFile", action = "http://Telestream.Vantage.Sdk/2010/07/IFile/GetFile")
    @WebResult(name = "GetFileResult", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
    @RequestWrapper(localName = "GetFile", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetFile")
    @ResponseWrapper(localName = "GetFileResponse", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07", className = "de.stiffi.media.telestreamvantage.api.generated.GetFileResponse")
    public FileType getFile(
        @WebParam(name = "identifier", targetNamespace = "http://Telestream.Vantage.Sdk/2010/07")
        String identifier)
        throws IFileGetFileContentDoesNotExistExceptionFaultFaultMessage, IFileGetFileUnlicensedSdkExceptionFaultFaultMessage
    ;

}
