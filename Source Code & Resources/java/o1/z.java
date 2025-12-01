package o1;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class z implements o0 {

    /* renamed from: a, reason: collision with root package name */
    public final j0 f946a;

    /* renamed from: b, reason: collision with root package name */
    public final Deflater f947b;
    public final p c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final CRC32 f948e;

    public z(m sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        j0 j0Var = new j0(sink);
        this.f946a = j0Var;
        Deflater deflater = new Deflater(-1, true);
        this.f947b = deflater;
        this.c = new p(j0Var, deflater);
        this.f948e = new CRC32();
        l lVar = j0Var.f913b;
        lVar.Z(8075);
        lVar.U(8);
        lVar.U(0);
        lVar.X(0);
        lVar.U(0);
        lVar.U(0);
    }

    @Override // o1.o0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        int value;
        boolean z2;
        l lVar;
        Deflater deflater = this.f947b;
        j0 j0Var = this.f946a;
        if (this.d) {
            return;
        }
        try {
            p pVar = this.c;
            pVar.f932b.finish();
            pVar.a(false);
            value = (int) this.f948e.getValue();
            z2 = j0Var.c;
            lVar = j0Var.f913b;
        } catch (Throwable th) {
            th = th;
        }
        if (z2) {
            throw new IllegalStateException("closed");
        }
        lVar.X(b.g(value));
        j0Var.r();
        int bytesRead = (int) deflater.getBytesRead();
        if (j0Var.c) {
            throw new IllegalStateException("closed");
        }
        lVar.X(b.g(bytesRead));
        j0Var.r();
        th = null;
        try {
            deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            j0Var.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // o1.o0, java.io.Flushable
    public final void flush() throws IOException {
        this.c.flush();
    }

    @Override // o1.o0
    public final s0 timeout() {
        return this.f946a.f912a.timeout();
    }

    @Override // o1.o0
    public final void write(l source, long j) throws IOException {
        kotlin.jvm.internal.j.e(source, "source");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount < 0: ", j).toString());
        }
        if (j == 0) {
            return;
        }
        l0 l0Var = source.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        long j2 = j;
        while (j2 > 0) {
            int iMin = (int) Math.min(j2, l0Var.c - l0Var.f921b);
            this.f948e.update(l0Var.f920a, l0Var.f921b, iMin);
            j2 -= iMin;
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
        }
        this.c.write(source, j);
    }
}
