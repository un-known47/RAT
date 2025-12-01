package o1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class w implements o0 {
    private final o0 delegate;

    public w(o0 delegate) {
        kotlin.jvm.internal.j.e(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: -deprecated_delegate, reason: not valid java name */
    public final o0 m84deprecated_delegate() {
        return this.delegate;
    }

    @Override // o1.o0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    public final o0 delegate() {
        return this.delegate;
    }

    @Override // o1.o0, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    @Override // o1.o0
    public s0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // o1.o0
    public void write(l source, long j) {
        kotlin.jvm.internal.j.e(source, "source");
        this.delegate.write(source, j);
    }
}
