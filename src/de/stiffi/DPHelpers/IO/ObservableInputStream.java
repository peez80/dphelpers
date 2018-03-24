package de.stiffi.DPHelpers.IO;

import de.stiffi.DPHelpers.Handler;
import de.stiffi.DPHelpers.StopWatch;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Inputstream that informs a handler about the processed bytes during read.
 */
public class ObservableInputStream extends FilterInputStream {

    private final Handler<Long> handler;
    private final long informIntervalMillis;
    private AtomicLong processedBytes = new AtomicLong(0);

    private long lastListenerInform = 0;

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    public ObservableInputStream(InputStream in, Handler<Long> processedBytesHandler, long informIntervalMillis) {
        super(in);
        this.handler = processedBytesHandler;
        this.informIntervalMillis = informIntervalMillis;
    }

    @Override
    public int read() throws IOException {
        int result =  super.read();

        if(result != -1) {
            processedBytes.incrementAndGet();
            informListener(false);
        }else{
            informListener(true);
        }

        return result;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int result =  super.read(b, off, len);

        if(result != -1) {
            processedBytes.addAndGet(result);
            informListener(false);
        }else{
            informListener(true);
        }

        return result;
    }

    private void informListener(boolean force) {
        if (force || System.currentTimeMillis() - lastListenerInform > informIntervalMillis ) {
            handler.handle(Long.valueOf(processedBytes.longValue()));
            lastListenerInform = System.currentTimeMillis();
        }
    }


}
