package de.stiffi.DPHelpers.Swing;

import java.awt.Component;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileDropDecorator implements DropTargetListener {

	private FileDropHandler handler;

	private Component c;

	private DropTarget dropTarget;

	public FileDropDecorator( Component c, FileDropHandler handler ) {
		this.c = c;
		this.handler = handler;
		dropTarget = new DropTarget( c, this );
	}

	@Override
	public void dragEnter( DropTargetDragEvent dtde ) {

	}

	@Override
	public void dragOver( DropTargetDragEvent dtde ) {

	}

	@Override
	public void dropActionChanged( DropTargetDragEvent dtde ) {

	}

	@Override
	public void dragExit( DropTargetEvent dte ) {

	}

	@Override
	public void drop( DropTargetDropEvent dtde ) {
		DataFlavor flavors[] = dtde.getCurrentDataFlavors();

		for ( DataFlavor flavor : flavors ) {
			if ( DataFlavor.javaFileListFlavor.equals( flavor ) ) {
				try {
					dtde.acceptDrop( DnDConstants.ACTION_COPY );
					handleFileDrop( dtde );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if ( DataFlavor.imageFlavor.equals( flavor ) ) {
				dtde.acceptDrop( DnDConstants.ACTION_COPY );
				handleImageDrop( dtde );
			}
		}
	}

	private void handleFileDrop( DropTargetDropEvent dtde ) throws UnsupportedFlavorException, IOException {
		List<Path> files = new ArrayList<>();
		Transferable transferable = dtde.getTransferable();
		List<File> droppedFiles = (List<File>)dtde.getTransferable().getTransferData( DataFlavor.javaFileListFlavor );

		for ( File f : droppedFiles ) {
			files.add( Paths.get( f.toURI() ) );
		}

		handler.handleFiles( files );
	}

	private void handleImageDrop( DropTargetEvent dtde ) {

	}
}
