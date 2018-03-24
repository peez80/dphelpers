package de.stiffi.DPHelpers;

import java.util.concurrent.atomic.AtomicLong;

public class StopWatch {

    private long totalCount;
    private final AtomicLong processed = new AtomicLong(0);
    private long startTime;

    public StopWatch(long totalCount) {
        this.totalCount = totalCount;
        this.startTime = System.currentTimeMillis();
    }

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void increment() {
        processed.incrementAndGet();
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void increment(long amount) {
        processed.addAndGet(amount);
    }

    public long getProcessed() {
        return processed.get();
    }

    public long getElapsedTimeMillis() {
        return System.currentTimeMillis() - startTime;
    }

    public long getEstimatedRemainingTimeMillis() {
        return getEstimatedTotalTimeMillis() - getElapsedTimeMillis();
    }

    public long getEstimatedTotalTimeMillis() {
        double totalTime = ((double)totalCount * (double)getElapsedTimeMillis()) / processed.get();
        return (long)totalTime;
    }
}
