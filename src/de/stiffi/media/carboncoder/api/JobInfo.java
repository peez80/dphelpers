package de.stiffi.media.carboncoder.api;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Element;

import de.stiffi.DPHelpers.PCalendar;
import de.stiffi.DPHelpers.XML;
import de.stiffi.DPHelpers.exceptions.ElementNotFoundException;

public class JobInfo {

	public enum JobStatus {
		PREPARING("PREPARING"), QUEUED("QUEUED"), STARTING("STARTING"), STARTED("STARTED"), STOPPING("STOPPING"), STOPPED("STOPPED"), PAUSING("PAUSING"), PAUSED("PAUSED"), RESUMING(
				"RESUMING"), COMPLETED("COMPLETED"), ERROR("ERROR"), INVALID("INVALID");

		private String name;

		private JobStatus( String name ) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	private String name;

	private String GUID;

	private JobStatus status;

	/**
	 * 0-100
	 */
	private int progress;

	private String description;

	private String user;

	private String sourceDescription;

	private String agentIP;

	private String agentGUID;

	/**
	 * 0-255
	 */
	private int priority;

	/**
	 * Wird Source nach Transcoding gelöscht?
	 */
	private boolean deleteProcessedSource;

	private Calendar checkInTime;

	private Calendar startTime;

	private Calendar completedTime;

	private List<String> warnings = new ArrayList<String>();

	private List<String> errors = new ArrayList<String>();

	/**
	 * Hier wird das InfoXML gespeichert.
	 */
	private String jobInfoXml = "";

	protected JobInfo( Element jobInfoElement ) throws ElementNotFoundException {
		readDocument( jobInfoElement );
	}

	private void readDocument( Element jobInfoElement ) throws ElementNotFoundException {
		Element e = jobInfoElement;

		name = e.getAttribute( "Name" );
		GUID = e.getAttribute( "GUID" );

		String sStatus = e.getAttribute( "Status" ).toLowerCase();
		if ( sStatus.equals( "preparing" ) ) {
			status = JobStatus.PREPARING;
		} else if ( sStatus.equals( "queued" ) ) {
			status = JobStatus.QUEUED;
		} else if ( sStatus.equals( "starting" ) ) {
			status = JobStatus.STARTING;
		} else if ( sStatus.equals( "started" ) ) {
			status = JobStatus.STARTED;
		} else if ( sStatus.equals( "stopping" ) ) {
			status = JobStatus.STOPPING;
		} else if ( sStatus.equals( "stopped" ) ) {
			status = JobStatus.STOPPED;
		} else if ( sStatus.equals( "pausing" ) ) {
			status = JobStatus.PAUSING;
		} else if ( sStatus.equals( "paused" ) ) {
			status = JobStatus.PAUSED;
		} else if ( sStatus.equals( "resuming" ) ) {
			status = JobStatus.RESUMING;
		} else if ( sStatus.equals( "completed" ) ) {
			status = JobStatus.COMPLETED;
		} else if ( sStatus.equals( "error" ) ) {
			status = JobStatus.ERROR;
		} else {
			status = JobStatus.INVALID;
		}

		progress = Integer.parseInt( e.getAttribute( "Progress.DWD" ) );
		description = e.getAttribute( "description" );
		user = e.getAttribute( "user" );
		sourceDescription = e.getAttribute( "SourceDescription" );
		agentIP = e.getAttribute( "AgentIP" );
		agentGUID = e.getAttribute( "Guid" );
		priority = Integer.parseInt( e.getAttribute( "Priority.DWD" ) );
		deleteProcessedSource = e.getAttribute( "DeleteProcessedSource.DWD" ).equals( "1" ) ? true : false;

		SimpleDateFormat df = CarbonCoderConnector.dateformat_CNLT;

		try {
			checkInTime = new PCalendar( df.parse( e.getAttribute( "CheckInTime_CNLT" ) ) );
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		if ( e.hasAttribute( "StartTime_CNLT" ) ) {
			try {
				startTime = new PCalendar( df.parse( e.getAttribute( "StartTime_CNLT" ) ) );
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		if ( e.hasAttribute( "CompletedTime_CNLT" ) ) {
			try {
				completedTime = new PCalendar( df.parse( e.getAttribute( "CompletedTime_CNLT" ) ) );
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}

		Element eFailures = XML.getChild( e, "Failures" );

		Element eErrors = XML.getChild( eFailures, "Errors" );
		Element[] errs = XML.getChildren( eErrors );
		for ( Element err : errs ) {
			if ( err.hasAttribute( "Error" ) ) {
				errors.add( err.getAttribute( "Error" ) );
			}
		}

		Element eWarnings = XML.getChild( eFailures, "Warnings" );
		Element[] warns = XML.getChildren( eWarnings );
		for ( Element warn : warns ) {
			if ( warn.hasAttribute( "Warning" ) ) {
				warnings.add( warn.getAttribute( "Warning" ) );
			}
		}

		try {
			jobInfoXml = XML.getAsString( e, true );
		} catch (TransformerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	public String getName() {
		return name;
	}

	public String getGUID() {
		return GUID;
	}

	public JobStatus getStatus() {
		return status;
	}

	/**
	 * 0-100
	 * 
	 * @return
	 */
	public int getProgress() {
		return progress;
	}

	public String getDescription() {
		return description;
	}

	public String getUser() {
		return user;
	}

	public String getSourceDescription() {
		return sourceDescription;
	}

	public String getAgentIP() {
		return agentIP;
	}

	public String getAgentGUID() {
		return agentGUID;
	}

	public int getPriority() {
		return priority;
	}

	public boolean isDeleteProcessedSource() {
		return deleteProcessedSource;
	}

	public Calendar getCheckInTime() {
		return checkInTime;
	}

	public Calendar getCompletedTime() {
		return completedTime;
	}

	public List<String> getWarnings() {
		return warnings;
	}

	public List<String> getErrors() {
		return errors;
	}

	public String getJobInfoXml() {
		return jobInfoXml;
	}
}
