package de.stiffi.DPHelpers.Examples;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;

import de.stiffi.DPHelpers.Files.DirSpider;

public class DirSpiderExample extends DirSpider {

	private int indent = 0;
	
	private double size = 0;
	
	private static File outputLog = null;

	private static StringBuffer logString = new StringBuffer(  );
	
	public static void main( String args[] ) {
		DirSpiderExample me = new DirSpiderExample( new File( args[0] ) );
		me.go();
		
		try {
			
			outputLog = new File(args[1] + File.separator + "SizeLog.txt" );
			if(!outputLog.exists()){
				outputLog.createNewFile();
			}
			
			
			FileOutputStream outputStream = new FileOutputStream(outputLog);
			
			PrintStream p = new PrintStream(outputStream);
			
			p.print( logString.toString() );			
			
			outputStream.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

	private static BufferedOutputStream BufferedOutputStream() {
		// TODO Auto-generated method stub
		return null;
	}

	public DirSpiderExample( File rootDirectory ) {
		super( rootDirectory );
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enterDir( File dir ) {
		

	}

	@Override
	public void handleDir( File dir ) {
		if(dir.getParent().equalsIgnoreCase( "Z:\\" )){
		printIndent();
		
		indent++;
		}

	}

	@Override
	public void handleFile( File file ) {
		size += file.length();
		//printIndent();
		//System.out.println( file.getName() );

	}

	public void printIndent() {
		for ( int i = 0; i < indent; i++ ) {
			System.out.print( "  " );
		}
	}

	public void leaveDir( File dir ) {
		indent--;
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String groesse = "";		
		if ( dir.getParent().equalsIgnoreCase( "Z:\\" ) ) {
			
			long checkSize = (long)( size / Math.pow( 1024, 3 ) );
			
			if ( checkSize == 0 ) {
				return;
			} else {

				size = (double)( size / Math.pow( 1024, 3 ) );				
				groesse = decimalFormat.format( size );
				
				if ( size >= 20 ) {
					logString.append( "!!!" + groesse + " GB \t " + dir.getName().toUpperCase() + "\n" );
					System.out.println( "!!!" + groesse + " GB \t " + dir.getName().toUpperCase() );
				} else {
					logString.append( groesse + " GB \t " + dir.getName().toUpperCase() + "\n" );
					System.out.println( groesse + " GB \t " + dir.getName().toUpperCase() );
				}
			}
			size = 0;
		}
	}

	@Override
	public void postRun() {
		// TODO Auto-generated method stub

	}

	@Override
	public void preRun() {
		// TODO Auto-generated method stub

	}
	
}
