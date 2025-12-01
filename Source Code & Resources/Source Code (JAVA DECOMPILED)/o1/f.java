package o1;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f895a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f896b;
    public final Object c;

    public f(InputStream inputStream, s0 timeout) {
        kotlin.jvm.internal.j.e(timeout, "timeout");
        this.f896b = inputStream;
        this.c = timeout;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f895a) {
            case 0:
                g gVar = (g) this.f896b;
                p0 p0Var = (p0) this.c;
                gVar.enter();
                try {
                    p0Var.close();
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(null);
                    }
                    return;
                } catch (IOException e2) {
                    if (!gVar.exit()) {
                        throw e2;
                    }
                    throw gVar.access$newTimeoutException(e2);
                } finally {
                    gVar.exit();
                }
            default:
                ((InputStream) this.f896b).close();
                return;
        }
    }

    @Override // o1.p0
    public final long read(l sink, long j) throws IOException {
        switch (this.f895a) {
            case 0:
                kotlin.jvm.internal.j.e(sink, "sink");
                g gVar = (g) this.f896b;
                p0 p0Var = (p0) this.c;
                gVar.enter();
                try {
                    long j2 = p0Var.read(sink, j);
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(null);
                    }
                    return j2;
                } catch (IOException e2) {
                    if (gVar.exit()) {
                        throw gVar.access$newTimeoutException(e2);
                    }
                    throw e2;
                } finally {
                    gVar.exit();
                }
            default:
                kotlin.jvm.internal.j.e(sink, "sink");
                if (j == 0) {
                    return 0L;
                }
                if (j < 0) {
                    throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount < 0: ", j).toString());
                }
                try {
                    ((s0) this.c).throwIfReached();
                    l0 l0VarS = sink.S(1);
                    int i2 = ((InputStream) this.f896b).read(l0VarS.f920a, l0VarS.c, (int) Math.min(j, 8192 - l0VarS.c));
                    if (i2 == -1) {
                        if (l0VarS.f921b == l0VarS.c) {
                            sink.f918a = l0VarS.a();
                            m0.a(l0VarS);
                        }
                        return -1L;
                    }
                    l0VarS.c += i2;
                    long j3 = i2;
                    sink.f919b += j3;
                    return j3;
                } catch (AssertionError e3) {
                    if (p1.n.a(e3)) {
                        throw new IOException(e3);
                    }
                    throw e3;
                }
        }
    }

    @Override // o1.p0
    public final s0 timeout() {
        switch (this.f895a) {
            case 0:
                return (g) this.f896b;
            default:
                return (s0) this.c;
        }
    }

    public final String toString() {
        switch (this.f895a) {
            case 0:
                return "AsyncTimeout.source(" + ((p0) this.c) + ')';
            default:
                return "source(" + ((InputStream) this.f896b) + ')';
        }
    }

    public f(g gVar, p0 p0Var) {
        this.f896b = gVar;
        this.c = p0Var;
    }
}
