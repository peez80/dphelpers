package de.stiffi.DPHelpers.Files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class SourceToTargetFileVisitor implements FileVisitor<Path> {

	public enum Mode {
		COPY, MOVE;
	}

	private Path sourceRoot;

	private Path destinationRoot;

	private boolean skipOnFailed;

	private Mode mode;

	public SourceToTargetFileVisitor( Path sourceRoot, Path destinationRoot, boolean skipOnFailed, Mode mode ) {
		this.sourceRoot = sourceRoot.toAbsolutePath();
		this.destinationRoot = destinationRoot.toAbsolutePath();
		this.skipOnFailed = skipOnFailed;
		this.mode = mode;
	}

	@Override
	public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs ) throws IOException {
		// Verzeichnis im Ziel anlegen, falls noch nicht vorhanden
		Path targetPath = getTargetPath( dir );
		if ( !Files.exists( targetPath ) ) {
			Files.createDirectories( targetPath );
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) throws IOException {
		if ( !Files.isRegularFile( file ) ) {
			return FileVisitResult.CONTINUE;
		}

		Path targetFile = getTargetPath( file );
		if ( mode == Mode.COPY ) {
			Files.copy( file, targetFile, StandardCopyOption.REPLACE_EXISTING );
		} else if ( mode == Mode.MOVE ) {
			Files.move( file, targetFile, StandardCopyOption.REPLACE_EXISTING );
		}

		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed( Path file, IOException exc ) throws IOException {
		if ( skipOnFailed ) {
			return FileVisitResult.TERMINATE;
		} else {
			return FileVisitResult.CONTINUE;
		}
	}

	@Override
	public FileVisitResult postVisitDirectory( Path dir, IOException exc ) throws IOException {
		Files.delete( dir );
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Berechnet aus dem übergebenen Quell-Pfad den entsprechenden Pfad im Ziel
	 * 
	 * @param absoluteSourcePath
	 * @return
	 */
	private Path getTargetPath( Path sourcePath ) {
		sourcePath = sourcePath.toAbsolutePath();

		// Zuerst die root-Elemente abschneiten
		if ( !sourcePath.startsWith( sourceRoot ) ) {
			throw new IllegalArgumentException( "Only Strings within SourceRootPath allowed!" );
		}

		if ( sourcePath.equals( sourceRoot ) ) {
			// Wir sind am Hauptverzeichnis, also targetRoot zurückgeben
			return destinationRoot;
		}

		Path relativePath = sourcePath.subpath( sourceRoot.getNameCount(), sourcePath.getNameCount() );

		Path targetPath = destinationRoot.resolve( relativePath );
		return targetPath;
	}

}
