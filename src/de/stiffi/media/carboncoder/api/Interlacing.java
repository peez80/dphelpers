package de.stiffi.media.carboncoder.api;

public enum Interlacing {

	PROGRESSIVE("PROGRESSIVE"), BOTTOM_FIELD_FIRST("BOTTOM_FIELD_FIRST"), TOP_FIELD_FIRST("TOP_FIELD_FIRST");

	private String name;

	private Interlacing( String name ) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
