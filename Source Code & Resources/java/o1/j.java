package o1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f910a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f911b;

    public /* synthetic */ j(n nVar, int i2) {
        this.f910a = i2;
        this.f911b = nVar;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        long jMin;
        switch (this.f910a) {
            case 0:
                jMin = Math.min(((l) this.f911b).f919b, Integer.MAX_VALUE);
                break;
            default:
                k0 k0Var = (k0) this.f911b;
                if (!k0Var.c) {
                    jMin = Math.min(k0Var.f917b.f919b, Integer.MAX_VALUE);
                    break;
                } else {
                    throw new IOException("closed");
                }
        }
        return (int) jMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f910a) {
            case 0:
                break;
            default:
                ((k0) this.f911b).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        switch (this.f910a) {
            case 0:
                l lVar = (l) this.f911b;
                if (lVar.f919b > 0) {
                    return lVar.readByte() & 255;
                }
                return -1;
            default:
                k0 k0Var = (k0) this.f911b;
                l lVar2 = k0Var.f917b;
                if (k0Var.c) {
                    throw new IOException("closed");
                }
                if (lVar2.f919b == 0 && k0Var.f916a.read(lVar2, 8192L) == -1) {
                    return -1;
                }
                return lVar2.readByte() & 255;
        }
    }

    public final String toString() {
        switch (this.f910a) {
            case 0:
                return ((l) this.f911b) + ".inputStream()";
            default:
                return ((k0) this.f911b) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public long transferTo(OutputStream out) throws IOException {
        switch (this.f910a) {
            case 1:
                kotlin.jvm.internal.j.e(out, "out");
                k0 k0Var = (k0) this.f911b;
                l lVar = k0Var.f917b;
                if (k0Var.c) {
                    throw new IOException("closed");
                }
                long j = 0;
                long j2 = 0;
                while (true) {
                    if (lVar.f919b == j && k0Var.f916a.read(lVar, 8192L) == -1) {
                        return j2;
                    }
                    long j3 = lVar.f919b;
                    j2 += j3;
                    b.e(j3, 0L, j3);
                    l0 l0Var = lVar.f918a;
                    while (j3 > j) {
                        kotlin.jvm.internal.j.b(l0Var);
                        int iMin = (int) Math.min(j3, l0Var.c - l0Var.f921b);
                        out.write(l0Var.f920a, l0Var.f921b, iMin);
                        int i2 = l0Var.f921b + iMin;
                        l0Var.f921b = i2;
                        long j4 = iMin;
                        lVar.f919b -= j4;
                        j3 -= j4;
                        if (i2 == l0Var.c) {
                            l0 l0VarA = l0Var.a();
                            lVar.f918a = l0VarA;
                            m0.a(l0Var);
                            l0Var = l0VarA;
                        }
                        j = 0;
                    }
                }
                break;
            default:
                return super.transferTo(out);
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] sink, int i2, int i3) throws IOException {
        switch (this.f910a) {
            case 0:
                kotlin.jvm.internal.j.e(sink, "sink");
                return ((l) this.f911b).read(sink, i2, i3);
            default:
                kotlin.jvm.internal.j.e(sink, "data");
                k0 k0Var = (k0) this.f911b;
                l lVar = k0Var.f917b;
                if (!k0Var.c) {
                    b.e(sink.length, i2, i3);
                    if (lVar.f919b == 0 && k0Var.f916a.read(lVar, 8192L) == -1) {
                        return -1;
                    }
                    return lVar.read(sink, i2, i3);
                }
                throw new IOException("closed");
        }
    }

    private final void a() {
    }
}
