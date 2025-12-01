package o1;

import java.io.EOFException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h implements o0 {
    @Override // o1.o0
    public final s0 timeout() {
        return s0.NONE;
    }

    @Override // o1.o0
    public final void write(l source, long j) throws EOFException {
        kotlin.jvm.internal.j.e(source, "source");
        source.skip(j);
    }

    @Override // o1.o0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // o1.o0, java.io.Flushable
    public final void flush() {
    }
}
