package o1;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class k0 implements n {

    /* renamed from: a, reason: collision with root package name */
    public final p0 f916a;

    /* renamed from: b, reason: collision with root package name */
    public final l f917b;
    public boolean c;

    public k0(p0 source) {
        kotlin.jvm.internal.j.e(source, "source");
        this.f916a = source;
        this.f917b = new l();
    }

    @Override // o1.n
    public final long A() {
        l lVar;
        byte bH;
        w(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            boolean zK = k(i3);
            lVar = this.f917b;
            if (!zK) {
                break;
            }
            bH = lVar.H(i2);
            if ((bH < 48 || bH > 57) && ((bH < 97 || bH > 102) && (bH < 65 || bH > 70))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            p.a.j(16);
            String string = Integer.toString(bH, 16);
            kotlin.jvm.internal.j.d(string, "toString(...)");
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(string));
        }
        return lVar.A();
    }

    @Override // o1.n
    public final String B(Charset charset) {
        kotlin.jvm.internal.j.e(charset, "charset");
        p0 p0Var = this.f916a;
        l lVar = this.f917b;
        lVar.f(p0Var);
        return lVar.B(charset);
    }

    @Override // o1.n
    public final InputStream C() {
        return new j(this, 1);
    }

    public final int D() {
        w(4L);
        return b.g(this.f917b.readInt());
    }

    public final long E() throws EOFException {
        w(8L);
        long j = this.f917b.readLong();
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    public final short F() {
        w(2L);
        return this.f917b.N();
    }

    public final String G(long j) {
        w(j);
        l lVar = this.f917b;
        lVar.getClass();
        return lVar.O(j, f1.a.f458a);
    }

    public final long a(byte b2, long j, long j2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (0 > j2) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("fromIndex=0 toIndex=", j2).toString());
        }
        long jMax = 0;
        while (jMax < j2) {
            l lVar = this.f917b;
            byte b3 = b2;
            long j3 = j2;
            long jI = lVar.I(b3, jMax, j3);
            if (jI != -1) {
                return jI;
            }
            long j4 = lVar.f919b;
            if (j4 >= j3 || this.f916a.read(lVar, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, j4);
            b2 = b3;
            j2 = j3;
        }
        return -1L;
    }

    @Override // o1.n
    public final l b() {
        return this.f917b;
    }

    @Override // o1.n
    public final int c(g0 options) throws EOFException {
        kotlin.jvm.internal.j.e(options, "options");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            l lVar = this.f917b;
            int iD = p1.a.d(lVar, options, true);
            if (iD != -2) {
                if (iD != -1) {
                    lVar.skip(options.f897a[iD].d());
                    return iD;
                }
            } else if (this.f916a.read(lVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() throws IOException {
        if (this.c) {
            return;
        }
        this.c = true;
        this.f916a.close();
        this.f917b.a();
    }

    @Override // o1.n
    public final o g() {
        p0 p0Var = this.f916a;
        l lVar = this.f917b;
        lVar.f(p0Var);
        return lVar.h(lVar.f919b);
    }

    @Override // o1.n
    public final o h(long j) {
        w(j);
        return this.f917b.h(j);
    }

    @Override // o1.n
    public final long i(l lVar) {
        l lVar2;
        long j = 0;
        while (true) {
            p0 p0Var = this.f916a;
            lVar2 = this.f917b;
            if (p0Var.read(lVar2, 8192L) == -1) {
                break;
            }
            long jF = lVar2.F();
            if (jF > 0) {
                j += jF;
                lVar.write(lVar2, jF);
            }
        }
        long j2 = lVar2.f919b;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        lVar.write(lVar2, j2);
        return j3;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // o1.n
    public final boolean k(long j) {
        l lVar;
        if (j < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount < 0: ", j).toString());
        }
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        do {
            lVar = this.f917b;
            if (lVar.f919b >= j) {
                return true;
            }
        } while (this.f916a.read(lVar, 8192L) != -1);
        return false;
    }

    @Override // o1.n
    public final boolean m(long j, o bytes) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        int iD = bytes.d();
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (iD >= 0 && iD <= bytes.d()) {
            return iD == 0 || p1.b.d(this, bytes, iD, 1L) != -1;
        }
        return false;
    }

    @Override // o1.n
    public final String n() {
        return t(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // o1.n
    public final byte[] o() {
        p0 p0Var = this.f916a;
        l lVar = this.f917b;
        lVar.f(p0Var);
        return lVar.M(lVar.f919b);
    }

    @Override // o1.n
    public final void p(l sink, long j) throws EOFException {
        l lVar = this.f917b;
        kotlin.jvm.internal.j.e(sink, "sink");
        try {
            w(j);
            lVar.p(sink, j);
        } catch (EOFException e2) {
            sink.f(lVar);
            throw e2;
        }
    }

    @Override // o1.n
    public final k0 peek() {
        return b.c(new i0(this));
    }

    @Override // o1.n
    public final boolean q() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        l lVar = this.f917b;
        return lVar.q() && this.f916a.read(lVar, 8192L) == -1;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        l lVar = this.f917b;
        if (lVar.f919b == 0 && this.f916a.read(lVar, 8192L) == -1) {
            return -1;
        }
        return lVar.read(sink);
    }

    @Override // o1.n
    public final byte readByte() {
        w(1L);
        return this.f917b.readByte();
    }

    @Override // o1.n
    public final void readFully(byte[] sink) throws EOFException {
        l lVar = this.f917b;
        kotlin.jvm.internal.j.e(sink, "sink");
        try {
            w(sink.length);
            lVar.readFully(sink);
        } catch (EOFException e2) {
            int i2 = 0;
            while (true) {
                long j = lVar.f919b;
                if (j <= 0) {
                    throw e2;
                }
                int i3 = lVar.read(sink, i2, (int) j);
                if (i3 == -1) {
                    throw new AssertionError();
                }
                i2 += i3;
            }
        }
    }

    @Override // o1.n
    public final int readInt() {
        w(4L);
        return this.f917b.readInt();
    }

    @Override // o1.n
    public final long readLong() {
        w(8L);
        return this.f917b.readLong();
    }

    @Override // o1.n
    public final short readShort() {
        w(2L);
        return this.f917b.readShort();
    }

    @Override // o1.n
    public final long s() {
        l lVar;
        byte bH;
        w(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            boolean zK = k(j2);
            lVar = this.f917b;
            if (!zK) {
                break;
            }
            bH = lVar.H(j);
            if ((bH < 48 || bH > 57) && !(j == 0 && bH == 45)) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            p.a.j(16);
            String string = Integer.toString(bH, 16);
            kotlin.jvm.internal.j.d(string, "toString(...)");
            throw new NumberFormatException("Expected a digit or '-' but was 0x".concat(string));
        }
        return lVar.s();
    }

    @Override // o1.n
    public final void skip(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            l lVar = this.f917b;
            if (lVar.f919b == 0 && this.f916a.read(lVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, lVar.f919b);
            lVar.skip(jMin);
            j -= jMin;
        }
    }

    @Override // o1.n
    public final String t(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("limit < 0: ", j).toString());
        }
        long j2 = j == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j + 1;
        long jA = a((byte) 10, 0L, j2);
        l lVar = this.f917b;
        if (jA != -1) {
            return p1.a.c(lVar, jA);
        }
        if (j2 < LocationRequestCompat.PASSIVE_INTERVAL && k(j2) && lVar.H(j2 - 1) == 13 && k(j2 + 1) && lVar.H(j2) == 10) {
            return p1.a.c(lVar, j2);
        }
        l lVar2 = new l();
        lVar.G(0L, lVar2, Math.min(32, lVar.f919b));
        throw new EOFException("\\n not found: limit=" + Math.min(lVar.f919b, j) + " content=" + lVar2.h(lVar2.f919b).e() + (char) 8230);
    }

    @Override // o1.p0
    public final s0 timeout() {
        return this.f916a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f916a + ')';
    }

    @Override // o1.n
    public final long v(long j, o bytes) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        return p1.b.d(this, bytes, bytes.d(), j);
    }

    @Override // o1.n
    public final void w(long j) {
        if (!k(j)) {
            throw new EOFException();
        }
    }

    @Override // o1.p0
    public final long read(l sink, long j) {
        kotlin.jvm.internal.j.e(sink, "sink");
        if (j >= 0) {
            if (!this.c) {
                l lVar = this.f917b;
                if (lVar.f919b == 0) {
                    if (j == 0) {
                        return 0L;
                    }
                    if (this.f916a.read(lVar, 8192L) == -1) {
                        return -1L;
                    }
                }
                return lVar.read(sink, Math.min(j, lVar.f919b));
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount < 0: ", j).toString());
    }
}
