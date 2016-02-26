package de.stiffi.media.telestreamvantage.api;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.AbstractQueuedSynchronizer.ConditionObject;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.stiffi.DPHelpers.XML;
import de.stiffi.DPHelpers.Timecode.Timecode;
import de.stiffi.DPHelpers.exceptions.NotFoundException;
import de.stiffi.media.telestreamvantage.api.generated.ArrayOfstring;
import de.stiffi.media.telestreamvantage.api.generated.BinderType;
import de.stiffi.media.telestreamvantage.api.generated.Condition;
import de.stiffi.media.telestreamvantage.api.generated.ConditionList;
import de.stiffi.media.telestreamvantage.api.generated.ConditionValue;
import de.stiffi.media.telestreamvantage.api.generated.Constraint;
import de.stiffi.media.telestreamvantage.api.generated.ContentType;
import de.stiffi.media.telestreamvantage.api.generated.Context;
import de.stiffi.media.telestreamvantage.api.generated.FolderType;
import de.stiffi.media.telestreamvantage.api.generated.IBinderGetContentFromBinderCatalogAccessExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IBinderGetContentFromBinderUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.ICatalogListBindersCatalogAccessExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.ICatalogListBindersUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IContentGetContentLabelsContentDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IContentGetContentLabelsUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IDomainGetCatalogCatalogAccessExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IDomainGetCatalogUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IDomainGetWorkflowWorkflowDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IDomainGetWorkflowsUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IJobSessionGetSessionProgressSessionDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IJobSessionGetSessionProgressUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowGetJobsForWorkflowUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowGetJobsForWorkflowWorkflowDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowGetWorkflowStateUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowGetWorkflowStateWorkflowDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetContentsForJobJobDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetContentsForJobUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetJobJobDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetJobStateJobDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetJobStateUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetJobUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetSessionsForJobJobDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobGetSessionsForJobUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobRemoveJobInvalidJobStateExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobRemoveJobJobDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowJobRemoveJobUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage;
import de.stiffi.media.telestreamvantage.api.generated.Item;
import de.stiffi.media.telestreamvantage.api.generated.ItemType;
import de.stiffi.media.telestreamvantage.api.generated.JobSessionState;
import de.stiffi.media.telestreamvantage.api.generated.JobType;
import de.stiffi.media.telestreamvantage.api.generated.Label;
import de.stiffi.media.telestreamvantage.api.generated.ObjectFactory;
import de.stiffi.media.telestreamvantage.api.generated.Parameter;
import de.stiffi.media.telestreamvantage.api.generated.Procedure;
import de.stiffi.media.telestreamvantage.api.generated.SdkService;
import de.stiffi.media.telestreamvantage.api.generated.SessionType;
import de.stiffi.media.telestreamvantage.api.generated.TypeCode;
import de.stiffi.media.telestreamvantage.api.generated.WorkflowDoesNotExistException;
import de.stiffi.media.telestreamvantage.api.generated.WorkflowJobQualifierType;
import de.stiffi.media.telestreamvantage.api.generated.WorkflowJobState;
import de.stiffi.media.telestreamvantage.api.generated.WorkflowState;

public class VantageClient {

	private static DateFormat df = DateFormat.getDateTimeInstance();

	private SdkService service;

	private URL wsdlUrl;

	public VantageClient( URL wsdlUrl ) {		
		
//		System.setProperty("proxyPort","8081");		
//		System.setProperty("proxyHost","localhost");
		
		this.wsdlUrl = wsdlUrl;
			
	}
	
	private SdkService getService() {
		if (service == null) {
			service = new SdkService( wsdlUrl, new QName( "http://tempuri.org/", "SdkService" ) );
		}
		return service;
	}

	private float getSessionWeight( String sessionName ) {
		Hashtable<String, Float> weights = new Hashtable<String, Float>();
		weights.put( "watch", 0f );
		weights.put( "copy", 8f );
		weights.put( "encode", 30f );
		weights.put( "identify", 2f );
		weights.put( "deploy", 2f );
		weights.put( "populate", 0f );
		weights.put( "notify", 1f );
		weights.put( "delete", 0f );

		// TODO: 1. Static machen, 2. mit Werten füllen!

		Float weight = weights.get( sessionName.toLowerCase() );

		if ( weight == null ) {
			return 0;
		} else {
			return weight.floatValue();
		}
	}

	public List<SessionType> getSessions( String jobGUID ) throws IWorkflowJobGetSessionsForJobJobDoesNotExistExceptionFaultFaultMessage,
			IWorkflowJobGetSessionsForJobUnlicensedSdkExceptionFaultFaultMessage {
		List<SessionType> sessions = getService().getJob().getSessionsForJob( jobGUID ).getSessionType();
		return sessions;
	}

	public float getProgress( String jobGUID ) throws IWorkflowJobGetSessionsForJobJobDoesNotExistExceptionFaultFaultMessage,
			IWorkflowJobGetSessionsForJobUnlicensedSdkExceptionFaultFaultMessage, IJobSessionGetSessionProgressSessionDoesNotExistExceptionFaultFaultMessage,
			IJobSessionGetSessionProgressUnlicensedSdkExceptionFaultFaultMessage, IWorkflowJobGetJobStateJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobGetJobStateUnlicensedSdkExceptionFaultFaultMessage {
		
		//Wenn Jobstate == Completed ist, dann einfach direkt 1 zurückgeben!
		if (getService().getJob().getJobState( jobGUID ) == WorkflowJobState.COMPLETE) {
			return 1.0f;
		}

		List<SessionType> sessions = getService().getJob().getSessionsForJob( jobGUID ).getSessionType();

		/*
		 * Hier werden alle Werte reingeschrieben und am Ende ein Durchschnittswert errechnet.
		 * Bei Elementen mit mehr Gewichtung wird x mal reingeschrieben
		 */
		List<Float> values = new ArrayList<Float>( sessions.size() * 3 );

		for ( SessionType session : sessions ) {
			// Gewichtung ermitteln
			float weight = getSessionWeight( session.getName().getValue() );
			if ( session.getState() == JobSessionState.COMPLETE || session.getState() == JobSessionState.IGNORED) {
				weight = weight == 0 ? 1 : weight;
				for ( int i = 0; i < weight; i++ ) {
					values.add( new Float( 1 ) );
				}
			} else if ( session.getState() == JobSessionState.IDLE ) {
				weight = weight == 0 ? 1 : weight;
				for ( int i = 0; i < weight; i++ ) {
					values.add( new Float( 0 ) );
				}
			} else {
				// Session ist in Arbeit, also Details holen und den tatsächlichen Progress in die
				// List schreiben
				int sessionProgress = getService().getSession().getSessionProgress( session.getIdentifier() );
				float sessionProgressFloat = ( sessionProgress / 100f );
				for ( int i = 0; i < weight; i++ ) {
					values.add( sessionProgressFloat );
				}
			}
		}

		float progressSum = 0;
		for ( Float f : values ) {
			progressSum += f.floatValue();
		}

		float progressOverall = progressSum / values.size();

		return progressOverall;
	}

	/**
	 * *
	 * GUID - JobName
	 * 
	 * @param workflowGUID
	 * @return
	 * @throws IWorkflowGetJobsForWorkflowUnlicensedSdkExceptionFaultFaultMessage
	 * @throws IWorkflowGetJobsForWorkflowWorkflowDoesNotExistExceptionFaultFaultMessage
	 */
	public Hashtable<String, String> getJobsOverview( String workflowGUID ) throws IWorkflowGetJobsForWorkflowUnlicensedSdkExceptionFaultFaultMessage,
			IWorkflowGetJobsForWorkflowWorkflowDoesNotExistExceptionFaultFaultMessage {
		Hashtable<String, String> jobList = new Hashtable<String, String>();

		List<JobType> jobs = getService().getWorkflow().getJobsForWorkflow( workflowGUID, WorkflowJobQualifierType.ALL ).getJobType();

		for ( JobType job : jobs ) {
			jobList.put( job.getIdentifier(), job.getName().getValue() );
		}

		return jobList;
	}

	/**
	 * GUID - WorkflowName
	 * 
	 * @return
	 * @throws IDomainGetWorkflowsUnlicensedSdkExceptionFaultFaultMessage
	 */
	public Hashtable<String, String> getAllWorkflows() throws IDomainGetWorkflowsUnlicensedSdkExceptionFaultFaultMessage {

		Hashtable<String, String> workflowList = new Hashtable<String, String>();

		List<Procedure> workflows = getService().getDomain().getWorkflows().getProcedure();

		for ( Procedure p : workflows ) {
			workflowList.put( p.getIdentifier(), p.getName().getValue() );
		}

		return workflowList;
	}
	
	public Hashtable<String, String> getAllWorkflows(WorkflowState state) throws IDomainGetWorkflowsUnlicensedSdkExceptionFaultFaultMessage, IWorkflowGetWorkflowStateUnlicensedSdkExceptionFaultFaultMessage, IWorkflowGetWorkflowStateWorkflowDoesNotExistExceptionFaultFaultMessage {
		Hashtable<String, String> workflowList = new Hashtable<String, String>();
		
		List<Procedure> workflows = getService().getDomain().getWorkflows().getProcedure();		
		
		for (Procedure p : workflows) {
			if (getService().getWorkflow().getWorkflowState( p.getIdentifier() ) == WorkflowState.ACTIVE) {
				workflowList.put( p.getIdentifier(), p.getName().getValue() );
			}
		}
		return workflowList;
	}

	public WorkflowJobState getJobState( String jobGUID ) throws IWorkflowJobGetJobStateJobDoesNotExistExceptionFaultFaultMessage,
			IWorkflowJobGetJobStateUnlicensedSdkExceptionFaultFaultMessage {
		WorkflowJobState state = getService().getJob().getJobState( jobGUID );
		return state;
	}
	
	public String getJobName(String jobGUID) throws IWorkflowJobGetJobJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobGetJobUnlicensedSdkExceptionFaultFaultMessage {
		return getService().getJob().getJob( jobGUID ).getName().getValue();
	}

	public String submitFile( File sourceFile, String workflowGUID ) throws IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage,
			IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage, IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage, IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage, IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage, NotFoundException {

		return submitFile( sourceFile.toURI(), workflowGUID );

	}

	public String submitFile( URI fileUri, String workflowGUID ) throws IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage,
			IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage, IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage, IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage, IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage, NotFoundException {
		
		return submitFile( fileUri, workflowGUID, null );		
	}
	
	/**
	 * Gibt die GUID des Workflows mit dem übergebenen Namen zurück.
	 * 
	 * Hierbei ist wichtig zu beachten, dass es rein technisch mehrere Workflows mit dem selben Namen geben kann.
	 * Auf Webservice-Seite werden Workflows nur mit ihren GUIDs unterschieden. Da man die GUIDs aber nicht selbst vergeben kann
	 * ist es u.U. schwierig, einen Workflow neu aufzubauen, der bereits irgendwo referenziert ist.
	 * Deshalb kann diese Methode verwendet werden, um einen Workflow anhand seines Namens zu erkennen.
	 * <p>
	 * <b>WICHTIG: Per Definition dürfen deshalb NIEMALS zwei Workflows mit dem selben Namen existieren!</b>
	 * 
	 * @param workflowname
	 * @return
	 * @throws IDomainGetWorkflowsUnlicensedSdkExceptionFaultFaultMessage 
	 * @throws IDomainGetWorkflowWorkflowDoesNotExistExceptionFaultFaultMessage 
	 */	
	public String getWorkflowGUID(String workflowname) throws IDomainGetWorkflowsUnlicensedSdkExceptionFaultFaultMessage, IDomainGetWorkflowWorkflowDoesNotExistExceptionFaultFaultMessage {
		List<Procedure> procedures = getService().getDomain().getWorkflows().getProcedure();
		for (Procedure p : procedures) {
			if (p.getName().getValue().equals( workflowname )) {
				return p.getIdentifier();
			}
		}
		
		//Wenn ich den Workflow nicht gefunden habe, eine Exception werfen
		throw new IDomainGetWorkflowWorkflowDoesNotExistExceptionFaultFaultMessage( "No Workflow with Name " + workflowname + " found.", new WorkflowDoesNotExistException() );
	}
	
	/**
	 * 
	 * @param fileUri
	 * @param workflowGUID
	 * @param variables
	 * @return
	 * @throws IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage
	 * @throws IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage
	 * @throws IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage
	 * @throws NotFoundException
	 * @throws IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage
	 * @throws IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage
	 * @throws IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage
	 */
	public String submitFile(URI fileUri, String workflowGUID, Hashtable<String, Object> variables) throws IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage, IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage, IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage, NotFoundException, IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage {
		return submitFile( fileUri, workflowGUID, variables, null );
	}
	
	/**
	 * 
	 * @param fileUri
	 * @param workflowGUID
	 * @param variables
	 * @param jobName
	 * @return
	 * @throws IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage
	 * @throws IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage
	 * @throws IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage
	 * @throws NotFoundException
	 * @throws IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage
	 * @throws IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage
	 * @throws IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage
	 */
	public String submitFile(URI fileUri, String workflowGUID, Hashtable<String, Object> variables, String jobName) throws IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage, IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage, IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage, NotFoundException, IWorkflowSubmitSubmitFileUnlicensedSdkExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowDoesNotExistExceptionFaultFaultMessage, IWorkflowSubmitSubmitFileWorkflowInvalidStateExceptionFaultFaultMessage {
				
		Context context = null;
		
		if (variables != null) {
			ObjectFactory of = new ObjectFactory();
			variables = new Hashtable<String, Object>();
			variables.put( "BobySourceAspectRatio", "4:3" );
			
			
			//Liste der Variablen aufbauen
//			List<Condition> conditions = new ArrayList<Condition>();
			context = of.createContext();		
			context.setConditions( of.createConditionList( of.createConditionList() ));		
			
			Enumeration<String> keys = variables.keys();
			while (keys.hasMoreElements()) {
				String variableName = keys.nextElement();
				Object variableContent = variables.get( variableName );
				
				Condition variableTempl = getVariable( variableName );
				Condition cond = of.createCondition();			
				cond.setName( of.createString( variableName ) );
				cond.setIdentifier( variableTempl.getIdentifier() );
				cond.setTypeCode( TypeCode.STRING ); //TODO: Später typ unterscheiden!
				
				cond.setConditionValue( of.createConditionConditionValue( of.createConditionValue() ) );
				cond.getConditionValue().getValue().setText( of.createArrayOfstring( of.createArrayOfstring() ) );
				
				ArrayOfstring arrayOfString = of.createArrayOfstring();
				arrayOfString.getString().add( (String)variableContent );
				
				cond.getConditionValue().getValue().getText().setValue( arrayOfString );
				
				//Default setzen - muss sein!
				cond.getConditionValue().getValue().setDefault( of.createConstraint( of.createConstraint() ) );
				
				Constraint defaultConstraint = of.createConstraint();
				defaultConstraint.setText( of.createArrayOfstring( arrayOfString ) );
				
				cond.getConditionValue().getValue().getDefault().setValue( defaultConstraint);
				
				
				//Complex - evt. das auch noch standardmäßig mit reinmachen?
				cond.getConditionValue().getValue().setComplexValue( of.createComplex( of.createComplex() ) );
				
				//Parameters
//				cond.setParameters( of.createArrayOfParameter( of.createArrayOfParameter() ) );
//				cond.getParameters().getValue().getParameter().add( of.createParameter() );
				
//				cond.setDescription( of.createString( "" ) );
//				cond.setSummary( of.createString( "" ) );

				
				
				//Jetzt die Condition in die Conditionlist adden
				context.getConditions().getValue().getCondition().add( cond );
				
				System.out.println(cond.toString());
			}
		}
				
		if (jobName == null) {
			jobName = fileUri.getScheme() + ":" + fileUri.getHost() + ":" + fileUri.getPath() + "_" + df.format( new Date() );
		}		
		return getService().getSubmit().submitFile( workflowGUID, fileUri.toString(), context, jobName );
	}
	
	
	private Condition getVariable(String variableName) throws IDomainGetVariablesUnlicensedSdkExceptionFaultFaultMessage, IDomainGetVariableTemplateDoesNotExistExceptionFaultFaultMessage, IDomainGetVariableUnlicensedSdkExceptionFaultFaultMessage, NotFoundException {
		List<Condition> conditions = getService().getDomain().getVariables().getCondition();
		
		for (Condition cond : conditions) {
			if (cond.getName().getValue().equalsIgnoreCase( variableName )) {
				return getService().getDomain().getVariable( cond.getIdentifier() );
			}
		}
		throw new NotFoundException("No condition with name " + variableName + " found.");
	}
	
	
	public void deleteJob(String jobGUID) throws IWorkflowJobRemoveJobInvalidJobStateExceptionFaultFaultMessage, IWorkflowJobRemoveJobJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobRemoveJobUnlicensedSdkExceptionFaultFaultMessage, IWorkflowJobGetJobStateJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobGetJobStateUnlicensedSdkExceptionFaultFaultMessage {
		getService().getJob().removeJob( jobGUID);
	}
	
	
	/**
	 * Gibt zum übergebenen Job den Wert des Label-Values mit dem übergebenen Namen zurück.
	 * 
	 * Achtung Besonderheit:<br>
	 * Bei Vantage hat ein Label mehrere Values. Hier geht es um die Value an sich, also innerhalb eines Labels.<br>
	 * Um um unzählige IDs rumzukommen, wird hier der einfachheit halber der erste Value gesucht,
	 * der zum übergebenen Job gehört und den entsprechenden Namen besitzt.<br>
	 * Das ist nicht ganz 100 prozentig sicher, allerdings _wesentlich_ einfacher anzusprechen.
	 * <br>
	 * Die entsprechenden Label-Werte müssen dementsprechend möglichst einzigartig benannt sein, damit sie nicht zufällig
	 * zwei mal vorkommen können.
	 * <br>
	 * Als Beispiel der MD5-Wert innerhalb des RTL2Now Workflows: SDK_RTL2NOW_MOV_MD5_FOR_BOBY
	 * 
	 * 
	 * @param jobGUID
	 * @param labelValueName
	 * @return
	 * @throws IWorkflowJobGetContentsForJobUnlicensedSdkExceptionFaultFaultMessage 
	 * @throws IWorkflowJobGetContentsForJobJobDoesNotExistExceptionFaultFaultMessage 
	 * @throws IContentGetContentLabelsUnlicensedSdkExceptionFaultFaultMessage 
	 * @throws IContentGetContentLabelsContentDoesNotExistExceptionFaultFaultMessage 
	 * @throws NotFoundException 
	 */
	public String getLabelString(String jobGUID, String labelValueName) throws IWorkflowJobGetContentsForJobJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobGetContentsForJobUnlicensedSdkExceptionFaultFaultMessage, IContentGetContentLabelsContentDoesNotExistExceptionFaultFaultMessage, IContentGetContentLabelsUnlicensedSdkExceptionFaultFaultMessage, NotFoundException {
		/*
		 * Alle Labels zum Job suchen und innerhalb dieser Labels dann den Value mit dem üebrgebenen Namen
		 */
		List<Item> labels = getLabels(jobGUID);
		
		boolean foundButWithWrongType = false;
		
		for (Item item : labels) {
			List<Parameter> parameters = item.getParameters().getValue().getParameter();
			for (Parameter parameter : parameters) {
				if (parameter.getName().getValue().equalsIgnoreCase( labelValueName )) {
					//TODO: typeCode auslesen! Vorerst mal ausschließlich Strings.
					TypeCode typeCode = parameter.getTypeCode();
					if (typeCode == TypeCode.STRING) {
						//Kann auch Array geben - also einfach alle Elemente zusammenkleben!
						String labelString = "";
						List<String> strings = parameter.getText().getValue().getString();
						for (String s : strings ) {
							labelString += s;
						}
						return labelString;
					}else{
						foundButWithWrongType = true;
					}
				}
			}
		}
		
		if (foundButWithWrongType) {
			throw new IllegalArgumentException( "Passed LabelValueName exists but is not a String!" );
		}else{
			throw new NotFoundException( "Label not found!" );
		}
	}
	
	/**
	 * Gibt alle vorhandenen Labels zum übergebenen Job zurück
	 * 
	 * @param jobGUID
	 * @return
	 * @throws IContentGetContentLabelsUnlicensedSdkExceptionFaultFaultMessage 
	 * @throws IContentGetContentLabelsContentDoesNotExistExceptionFaultFaultMessage 
	 * @throws IWorkflowJobGetContentsForJobUnlicensedSdkExceptionFaultFaultMessage 
	 * @throws IWorkflowJobGetContentsForJobJobDoesNotExistExceptionFaultFaultMessage 
	 */
	public List<Item> getLabels(String jobGUID) throws IContentGetContentLabelsContentDoesNotExistExceptionFaultFaultMessage, IContentGetContentLabelsUnlicensedSdkExceptionFaultFaultMessage, IWorkflowJobGetContentsForJobJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobGetContentsForJobUnlicensedSdkExceptionFaultFaultMessage {
		List<Item> allLabels = new ArrayList<Item>();
		
		//Content suchen anhand dem die Labels geholt werden
		List<ContentType> contents = getService().getJob().getContentsForJob( jobGUID ).getContentType();
		
		for (ContentType content : contents) {
			List<ItemType> items = getService().getContent().getContentLabels( content.getIdentifier() ).getItemType();
			for (ItemType item : items) {
				
				if (item.getItem().getValue() instanceof Label) {
					allLabels.add( item.getItem().getValue() );
				}			
			}
		}
		
		return allLabels;
	}
	
	private Item getLabel(String jobGUID, String labelGUID) throws IWorkflowJobGetJobJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobGetJobUnlicensedSdkExceptionFaultFaultMessage, IDomainGetCatalogCatalogAccessExceptionFaultFaultMessage, IDomainGetCatalogUnlicensedSdkExceptionFaultFaultMessage, ICatalogListBindersCatalogAccessExceptionFaultFaultMessage, ICatalogListBindersUnlicensedSdkExceptionFaultFaultMessage, IBinderGetContentFromBinderCatalogAccessExceptionFaultFaultMessage, IBinderGetContentFromBinderUnlicensedSdkExceptionFaultFaultMessage, IWorkflowJobGetContentsForJobJobDoesNotExistExceptionFaultFaultMessage, IWorkflowJobGetContentsForJobUnlicensedSdkExceptionFaultFaultMessage, IContentGetContentLabelsContentDoesNotExistExceptionFaultFaultMessage, IContentGetContentLabelsUnlicensedSdkExceptionFaultFaultMessage {
		//Content-ID des Jobs raussuchen, damit ich die dann nachher aus dem Catalor rausholen kann
		List<ContentType> contents = getService().getJob().getContentsForJob( jobGUID ).getContentType();
		
		//Aus jedem Content jetzt die Labels rausholen
		for (ContentType content : contents) {
			List<ItemType> items = getService().getContent().getContentLabels( content.getIdentifier() ).getItemType();
			
			//Jeder Item ist jetzt ein Label, der mehrere Variablen besitzen kann
			for (ItemType item : items) {
				if (item.getItemTypeIdentifier().equals( "Label" )) {
					//Nur Labels betrachten - kein Plan was es sonst noch geben kann...
					if (item.getIdentifier().equalsIgnoreCase( labelGUID )) {
						//Richtigen Label gefunden, also Item zurückgeben!
						return item.getItem().getValue();
					}
				}
			}
		}
		throw new IllegalStateException( "TODO: No Item found!" );
	}

	/**
	 * 
	 * @param name
	 * @param startTimecode
	 * @param elements
	 * @return
	 * @throws ParserConfigurationException Falls mit der Erstellung des XML Documents was nicht
	 *             passt
	 */
	public static Document createStitchSource( String name, Timecode startTimecode, List<StitchElement> elements ) throws ParserConfigurationException {

		// UUIDs für die Files generieren
		Hashtable<String, UUID> uuids = new Hashtable<String, UUID>();
		for ( StitchElement e : elements ) {
			String filePath = e.getSourceFile();
			if ( !uuids.containsKey( filePath ) ) {
				// Files können auch mehrfach innerhalb elements vorkommen.
				// Die gleiche Datei immer nur einmal adden!

				// TODO: Sind das die richtigen UUIDs die hier gemacht werden? (Wir brauchen
				// "Windows-Style", wo der letzte Teil länger ist als der Rest)
				uuids.put( filePath, UUID.randomUUID() );
			}
		}

		Document doc = XML.newDocument();

		Element eRoot = doc.createElement( "VantagePlayList" );
		doc.appendChild( eRoot );

		Element eName = doc.createElement( "Name" );
		eName.setTextContent( name );
		eRoot.appendChild( eName );

		// Files auflisten
		Enumeration<String> eUUID = uuids.keys();
		while (eUUID.hasMoreElements()) {
			String filePath = eUUID.nextElement();
			UUID uuid = uuids.get( filePath );

			Element eFile = doc.createElement( "File" );
			eFile.setAttribute( "uuid", uuid.toString() );
			eFile.setAttribute( "path", filePath.toString() );

			eRoot.appendChild( eFile );
		}

		Element eEDL = doc.createElement( "EDL" );
		eRoot.appendChild( eEDL );

		Element eTimecode = doc.createElement( "Timecode" );
		eTimecode.setAttribute( "name", "Start Timecode Override" );
		eTimecode.setAttribute( "type", "time" );
		eTimecode.setTextContent( startTimecode.toString() );
		eEDL.appendChild( eTimecode );

		// Jetzt die einzelnen Cuts
		for ( int i = 0; i < elements.size(); i++ ) {
			StitchElement e = elements.get( i );
			Element eEdit = doc.createElement( "Edit" );
			eEdit.setAttribute( "type", "file" );
			eEdit.setAttribute( "sequence", "" + i );
			// TODO: Irgendwo habe ich gelesen, dass die Timecode-Felder nur zur Lesbarkeit da
			// sind?! Falls die Probleme machen - weglassen!
			eEdit.setAttribute( "timecode_in", e.getTcIn().toString() + "@" + e.getTcIn().getFPS() );
			eEdit.setAttribute( "timecode_out", e.getTcOut().toString() + "@" + e.getTcOut().getFPS() );
			eEdit.setAttribute( "markin", "" + e.getTcIn().getFrames() );
			eEdit.setAttribute( "markout", "" + e.getTcOut().getFrames() );
			eEdit.setAttribute( "file", uuids.get( e.getSourceFile() ).toString() );

			eEDL.appendChild( eEdit );

		}

		return doc;

	}
}
