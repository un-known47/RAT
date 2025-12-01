package o1;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b0 implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f889a;

    /* renamed from: b, reason: collision with root package name */
    public final Inflater f890b;
    public int c;
    public boolean d;

    public b0(k0 k0Var, Inflater inflater) {
        this.f889a = k0Var;
        this.f890b = inflater;
    }

    public final long a(l sink, long j) throws DataFormatException, IOException {
        Inflater inflater = this.f890b;
        kotlin.jvm.internal.j.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount < 0: ", j).toString());
        }
        if (this.d) {
            throw new IllegalStateException("closed");
        }
        if (j != 0) {
            try {
                l0 l0VarS = sink.S(1);
                int iMin = (int) Math.min(j, 8192 - l0VarS.c);
                boolean zNeedsInput = inflater.needsInput();
                k0 k0Var = this.f889a;
                if (zNeedsInput && !k0Var.q()) {
                    l0 l0Var = k0Var.f917b.f918a;
                    kotlin.jvm.internal.j.b(l0Var);
                    int i2 = l0Var.c;
                    int i3 = l0Var.f921b;
                    int i4 = i2 - i3;
                    this.c = i4;
                    inflater.setInput(l0Var.f920a, i3, i4);
                }
                int iInflate = inflater.inflate(l0VarS.f920a, l0VarS.c, iMin);
                int i5 = this.c;
                if (i5 != 0) {
                    int remaining = i5 - inflater.getRemaining();
                    this.c -= remaining;
                    k0Var.skip(remaining);
                }
                if (iInflate > 0) {
                    l0VarS.c += iInflate;
                    long j2 = iInflate;
                    sink.f919b += j2;
                    return j2;
                }
                if (l0VarS.f921b == l0VarS.c) {
                    sink.f918a = l0VarS.a();
                    m0.a(l0VarS);
                }
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        }
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.d) {
            return;
        }
        this.f890b.end();
        this.d = true;
        this.f889a.close();
    }

    @Override // o1.p0
    public final long read(l sink, long j) throws DataFormatException, IOException {
        kotlin.jvm.internal.j.e(sink, "sink");
        do {
            long jA = a(sink, j);
            if (jA > 0) {
                return jA;
            }
            Inflater inflater = this.f890b;
            if (inflater.finished() || inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.f889a.q());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // o1.p0
    public final s0 timeout() {
        return this.f889a.f916a.timeout();
    }
}
