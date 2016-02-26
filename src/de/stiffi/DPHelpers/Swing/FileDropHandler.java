package de.stiffi.DPHelpers.Swing;

import java.nio.file.Path;
import java.util.List;

public interface FileDropHandler {

	public void handleFiles( List<Path> paths );

}
