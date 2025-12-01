package o1;

import java.io.IOException;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class p implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final j0 f931a;

    /* renamed from: b, reason: collision with root package name */
    public final Deflater f932b;
    public boolean c;

    public p(j0 j0Var, Deflater deflater) {
        this.f931a = j0Var;
        this.f932b = deflater;
    }

    public final void a(boolean z2) throws IOException {
        l0 l0VarS;
        int iDeflate;
        j0 j0Var = this.f931a;
        l lVar = j0Var.f913b;
        while (true) {
            l0VarS = lVar.S(1);
            byte[] bArr = l0VarS.f920a;
            Deflater deflater = this.f932b;
            if (z2) {
                try {
                    int i2 = l0VarS.c;
                    iDeflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
                } catch (NullPointerException e2) {
                    throw new IOException("Deflater already closed", e2);
                }
            } else {
                int i3 = l0VarS.c;
                iDeflate = deflater.deflate(bArr, i3, 8192 - i3);
            }
            if (iDeflate > 0) {
                l0VarS.c += iDeflate;
                lVar.f919b += iDeflate;
                j0Var.r();
            } else if (deflater.needsInput()) {
                break;
            }
        }
        if (l0VarS.f921b == l0VarS.c) {
            lVar.f918a = l0VarS.a();
            m0.a(l0VarS);
        }
    }

    @Override // o1.o0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Deflater deflater = this.f932b;
        if (this.c) {
            return;
        }
        try {
            deflater.finish();
            a(false);
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.f931a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // o1.o0, java.io.Flushable
    public final void flush() throws IOException {
        a(true);
        this.f931a.flush();
    }

    @Override // o1.o0
    public final s0 timeout() {
        return this.f931a.f912a.timeout();
    }

    public final String toString() {
        return "DeflaterSink(" + this.f931a + ')';
    }

    @Override // o1.o0
    public final void write(l source, long j) throws IOException {
        kotlin.jvm.internal.j.e(source, "source");
        b.e(source.f919b, 0L, j);
        while (true) {
            Deflater deflater = this.f932b;
            if (j <= 0) {
                deflater.setInput(p1.b.f993b, 0, 0);
                return;
            }
            l0 l0Var = source.f918a;
            kotlin.jvm.internal.j.b(l0Var);
            int iMin = (int) Math.min(j, l0Var.c - l0Var.f921b);
            deflater.setInput(l0Var.f920a, l0Var.f921b, iMin);
            a(false);
            long j2 = iMin;
            source.f919b -= j2;
            int i2 = l0Var.f921b + iMin;
            l0Var.f921b = i2;
            if (i2 == l0Var.c) {
                source.f918a = l0Var.a();
                m0.a(l0Var);
            }
            j -= j2;
        }
    }
}
