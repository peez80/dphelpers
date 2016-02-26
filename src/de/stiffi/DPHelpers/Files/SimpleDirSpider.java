package de.stiffi.DPHelpers.Files;

import java.io.File;

/**
 * Diese Klasse ist nur daf�r da, um eine schnelle DirSpider zu implementieren. Die �berschriebenen Methoden sind leer. 
 * Es werden also ausschlie�lich angeschlossene Listener benachrichtigt, die dann daf�r verantwortlich sind, etwas zu tun.
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
