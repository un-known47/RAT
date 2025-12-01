package o1;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f892a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f893b;
    public final Object c;

    public /* synthetic */ e(int i2, Object obj, Object obj2) {
        this.f892a = i2;
        this.f893b = obj;
        this.c = obj2;
    }

    @Override // o1.o0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f892a) {
            case 0:
                g gVar = (g) this.f893b;
                o0 o0Var = (o0) this.c;
                gVar.enter();
                try {
                    o0Var.close();
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
                ((OutputStream) this.f893b).close();
                return;
        }
    }

    @Override // o1.o0, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f892a) {
            case 0:
                g gVar = (g) this.f893b;
                o0 o0Var = (o0) this.c;
                gVar.enter();
                try {
                    o0Var.flush();
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
                ((OutputStream) this.f893b).flush();
                return;
        }
    }

    @Override // o1.o0
    public final s0 timeout() {
        switch (this.f892a) {
            case 0:
                return (g) this.f893b;
            default:
                return (s0) this.c;
        }
    }

    public final String toString() {
        switch (this.f892a) {
            case 0:
                return "AsyncTimeout.sink(" + ((o0) this.c) + ')';
            default:
                return "sink(" + ((OutputStream) this.f893b) + ')';
        }
    }

    @Override // o1.o0
    public final void write(l source, long j) throws IOException {
        switch (this.f892a) {
            case 0:
                kotlin.jvm.internal.j.e(source, "source");
                b.e(source.f919b, 0L, j);
                long j2 = j;
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    l0 l0Var = source.f918a;
                    kotlin.jvm.internal.j.b(l0Var);
                    while (true) {
                        if (j3 < 65536) {
                            j3 += l0Var.c - l0Var.f921b;
                            if (j3 >= j2) {
                                j3 = j2;
                            } else {
                                l0Var = l0Var.f923f;
                                kotlin.jvm.internal.j.b(l0Var);
                            }
                        }
                    }
                    g gVar = (g) this.f893b;
                    o0 o0Var = (o0) this.c;
                    gVar.enter();
                    try {
                        try {
                            o0Var.write(source, j3);
                            if (gVar.exit()) {
                                throw gVar.access$newTimeoutException(null);
                            }
                            j2 -= j3;
                        } catch (IOException e2) {
                            if (!gVar.exit()) {
                                throw e2;
                            }
                            throw gVar.access$newTimeoutException(e2);
                        }
                    } catch (Throwable th) {
                        gVar.exit();
                        throw th;
                    }
                }
            default:
                kotlin.jvm.internal.j.e(source, "source");
                b.e(source.f919b, 0L, j);
                while (j > 0) {
                    ((s0) this.c).throwIfReached();
                    l0 l0Var2 = source.f918a;
                    kotlin.jvm.internal.j.b(l0Var2);
                    int iMin = (int) Math.min(j, l0Var2.c - l0Var2.f921b);
                    ((OutputStream) this.f893b).write(l0Var2.f920a, l0Var2.f921b, iMin);
                    int i2 = l0Var2.f921b + iMin;
                    l0Var2.f921b = i2;
                    long j4 = iMin;
                    j -= j4;
                    source.f919b -= j4;
                    if (i2 == l0Var2.c) {
                        source.f918a = l0Var2.a();
                        m0.a(l0Var2);
                    }
                }
                return;
        }
    }
}
