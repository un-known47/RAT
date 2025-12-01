package o1;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class x implements p0 {
    private final p0 delegate;

    public x(p0 delegate) {
        kotlin.jvm.internal.j.e(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final p0 m85deprecated_delegate() {
        return this.delegate;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    public final p0 delegate() {
        return this.delegate;
    }

    @Override // o1.p0
    public long read(l sink, long j) {
        kotlin.jvm.internal.j.e(sink, "sink");
        return this.delegate.read(sink, j);
    }

    @Override // o1.p0
    public s0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
