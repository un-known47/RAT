package okhttp3.internal.cache;

import java.io.EOFException;
import java.io.IOException;
import kotlin.jvm.internal.j;
import o1.o0;
import o1.w;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class FaultHidingSink extends w {
    private boolean hasErrors;
    private final l onException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaultHidingSink(o0 delegate, l onException) {
        super(delegate);
        j.e(delegate, "delegate");
        j.e(onException, "onException");
        this.onException = onException;
    }

    @Override // o1.w, o1.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    @Override // o1.w, o1.o0, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    public final l getOnException() {
        return this.onException;
    }

    @Override // o1.w, o1.o0
    public void write(o1.l source, long j) throws EOFException {
        j.e(source, "source");
        if (this.hasErrors) {
            source.skip(j);
            return;
        }
        try {
            super.write(source, j);
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }
}
