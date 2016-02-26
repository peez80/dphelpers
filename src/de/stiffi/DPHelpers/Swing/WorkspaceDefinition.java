package de.stiffi.DPHelpers.Swing;

import java.io.Serializable;
import java.util.Hashtable;


public class WorkspaceDefinition implements Serializable {
	private String title;
	
	private Hashtable<String, WindowState> windowStates;
	
	public WorkspaceDefinition() {
		windowStates = new Hashtable<String, WindowState>();
	}
	
	public void readFromWindowManager(DPWindowManager wm) {
		DPInternalFrame windows[] = wm.getWindows();
		
		for (DPInternalFrame window : windows) {
			WindowState state = new WindowState(window);
			windowStates.put( window.getWindowIdentifier(), state );
		}
	}
	
	public void apply(DPWindowManager wm) {
		DPInternalFrame windows[] = wm.getWindows();
		for (DPInternalFrame window : windows) {
			if (windowStates.containsKey( window.getWindowIdentifier() )) {
				WindowState state = windowStates.get( window.getWindowIdentifier() );
				state.applyToComponent( window );
			}
		}
	}

	
	public String getTitle() {
		return title;
	}

	
	public void setTitle( String title ) {
		this.title = title;
	}
	
}
