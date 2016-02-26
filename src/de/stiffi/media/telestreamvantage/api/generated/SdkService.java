
package de.stiffi.media.telestreamvantage.api.generated;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "SdkService", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://p-telestream01:8676/?wsdl")
public class SdkService
    extends Service
{

    private final static URL SDKSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(de.stiffi.media.telestreamvantage.api.generated.SdkService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = de.stiffi.media.telestreamvantage.api.generated.SdkService.class.getResource(".");
            url = new URL(baseUrl, "http://p-telestream01:8676/?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://p-telestream01:8676/?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        SDKSERVICE_WSDL_LOCATION = url;
    }

    public SdkService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SdkService() {
        super(SDKSERVICE_WSDL_LOCATION, new QName("http://tempuri.org/", "SdkService"));
    }

    /**
     * 
     * @return
     *     returns IDomain
     */
    @WebEndpoint(name = "Domain")
    public IDomain getDomain() {
        return super.getPort(new QName("http://tempuri.org/", "Domain"), IDomain.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IDomain
     */
    @WebEndpoint(name = "Domain")
    public IDomain getDomain(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Domain"), IDomain.class, features);
    }

    /**
     * 
     * @return
     *     returns ICatalog
     */
    @WebEndpoint(name = "Catalog")
    public ICatalog getCatalog() {
        return super.getPort(new QName("http://tempuri.org/", "Catalog"), ICatalog.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ICatalog
     */
    @WebEndpoint(name = "Catalog")
    public ICatalog getCatalog(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Catalog"), ICatalog.class, features);
    }

    /**
     * 
     * @return
     *     returns IBinder
     */
    @WebEndpoint(name = "Binder")
    public IBinder getBinder() {
        return super.getPort(new QName("http://tempuri.org/", "Binder"), IBinder.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IBinder
     */
    @WebEndpoint(name = "Binder")
    public IBinder getBinder(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Binder"), IBinder.class, features);
    }

    /**
     * 
     * @return
     *     returns IFolder
     */
    @WebEndpoint(name = "Folder")
    public IFolder getFolder() {
        return super.getPort(new QName("http://tempuri.org/", "Folder"), IFolder.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IFolder
     */
    @WebEndpoint(name = "Folder")
    public IFolder getFolder(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Folder"), IFolder.class, features);
    }

    /**
     * 
     * @return
     *     returns IItem
     */
    @WebEndpoint(name = "Item")
    public IItem getItem() {
        return super.getPort(new QName("http://tempuri.org/", "Item"), IItem.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IItem
     */
    @WebEndpoint(name = "Item")
    public IItem getItem(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Item"), IItem.class, features);
    }

    /**
     * 
     * @return
     *     returns IWorkflow
     */
    @WebEndpoint(name = "Workflow")
    public IWorkflow getWorkflow() {
        return super.getPort(new QName("http://tempuri.org/", "Workflow"), IWorkflow.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWorkflow
     */
    @WebEndpoint(name = "Workflow")
    public IWorkflow getWorkflow(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Workflow"), IWorkflow.class, features);
    }

    /**
     * 
     * @return
     *     returns IWorkflowSubmit
     */
    @WebEndpoint(name = "Submit")
    public IWorkflowSubmit getSubmit() {
        return super.getPort(new QName("http://tempuri.org/", "Submit"), IWorkflowSubmit.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWorkflowSubmit
     */
    @WebEndpoint(name = "Submit")
    public IWorkflowSubmit getSubmit(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Submit"), IWorkflowSubmit.class, features);
    }

    /**
     * 
     * @return
     *     returns IWorkflowJob
     */
    @WebEndpoint(name = "Job")
    public IWorkflowJob getJob() {
        return super.getPort(new QName("http://tempuri.org/", "Job"), IWorkflowJob.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWorkflowJob
     */
    @WebEndpoint(name = "Job")
    public IWorkflowJob getJob(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Job"), IWorkflowJob.class, features);
    }

    /**
     * 
     * @return
     *     returns IJobSession
     */
    @WebEndpoint(name = "Session")
    public IJobSession getSession() {
        return super.getPort(new QName("http://tempuri.org/", "Session"), IJobSession.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IJobSession
     */
    @WebEndpoint(name = "Session")
    public IJobSession getSession(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Session"), IJobSession.class, features);
    }

    /**
     * 
     * @return
     *     returns IContent
     */
    @WebEndpoint(name = "Content")
    public IContent getContent() {
        return super.getPort(new QName("http://tempuri.org/", "Content"), IContent.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IContent
     */
    @WebEndpoint(name = "Content")
    public IContent getContent(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "Content"), IContent.class, features);
    }

    /**
     * 
     * @return
     *     returns IFile
     */
    @WebEndpoint(name = "File")
    public IFile getFile() {
        return super.getPort(new QName("http://tempuri.org/", "File"), IFile.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IFile
     */
    @WebEndpoint(name = "File")
    public IFile getFile(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "File"), IFile.class, features);
    }

}
