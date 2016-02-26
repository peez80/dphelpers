package de.stiffi.DPHelpers;

public class DPTimer {

	@SuppressWarnings("unused")
	private final static int HHMMSS = 0x1;

	@SuppressWarnings("unused")
	private final static int SECONDS = 0x2;

	@SuppressWarnings("unused")
	private final static int MILLISECONDS = 0x3;

	private long start = 0;

	private long stop = 0;

	public DPTimer() {

	}

	public void start() {
		start = System.currentTimeMillis();
	}

	public void stop() {
		stop = System.currentTimeMillis();
	}

	public long getMillis() {
		return stop - start;
	}

}
