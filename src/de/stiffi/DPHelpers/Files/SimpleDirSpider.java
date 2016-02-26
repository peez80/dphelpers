package de.stiffi.DPHelpers.Files;

import java.io.File;

/**
 * Diese Klasse ist nur dafür da, um eine schnelle DirSpider zu implementieren. Die überschriebenen Methoden sind leer. 
 * Es werden also ausschließlich angeschlossene Listener benachrichtigt, die dann dafür verantwortlich sind, etwas zu tun.
 * 
 * @author HD-Authoring
 * 
 */
public class SimpleDirSpider extends DirSpider {

	public SimpleDirSpider( File rootDirectory ) {
		super( rootDirectory );
	}

	@Override
	public void enterDir( File dir ) {
	}

	@Override
	public void handleDir( File dir ) {
	}

	@Override
	public void handleFile( File file ) {
	}

	@Override
	public void leaveDir( File dir ) {
	}

	@Override
	public void postRun() {
	}

	@Override
	public void preRun() {
	}

}
