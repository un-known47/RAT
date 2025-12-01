package o1;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j0 implements m {

    /* renamed from: a, reason: collision with root package name */
    public final o0 f912a;

    /* renamed from: b, reason: collision with root package name */
    public final l f913b;
    public boolean c;

    public j0(o0 sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        this.f912a = sink;
        this.f913b = new l();
    }

    @Override // o1.m
    public final l b() {
        return this.f913b;
    }

    @Override // o1.o0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        o0 o0Var = this.f912a;
        if (this.c) {
            return;
        }
        try {
            l lVar = this.f913b;
            long j = lVar.f919b;
            if (j > 0) {
                o0Var.write(lVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            o0Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // o1.m
    public final m d(String string, int i2, int i3) {
        kotlin.jvm.internal.j.e(string, "string");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.c0(string, i2, i3);
        r();
        return this;
    }

    @Override // o1.m
    public final m e(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.W(j);
        r();
        return this;
    }

    @Override // o1.m
    public final long f(p0 source) {
        kotlin.jvm.internal.j.e(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(this.f913b, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
            r();
        }
    }

    @Override // o1.m, o1.o0, java.io.Flushable
    public final void flush() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        l lVar = this.f913b;
        long j = lVar.f919b;
        o0 o0Var = this.f912a;
        if (j > 0) {
            o0Var.write(lVar, j);
        }
        o0Var.flush();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.c;
    }

    @Override // o1.m
    public final m j() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        l lVar = this.f913b;
        long j = lVar.f919b;
        if (j > 0) {
            this.f912a.write(lVar, j);
        }
        return this;
    }

    @Override // o1.m
    public final m l(int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.d0(i2);
        r();
        return this;
    }

    @Override // o1.m
    public final m r() {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        l lVar = this.f913b;
        long jF = lVar.F();
        if (jF > 0) {
            this.f912a.write(lVar, jF);
        }
        return this;
    }

    @Override // o1.o0
    public final s0 timeout() {
        return this.f912a.timeout();
    }

    public final String toString() {
        return "buffer(" + this.f912a + ')';
    }

    @Override // o1.m
    public final m u(o byteString) {
        kotlin.jvm.internal.j.e(byteString, "byteString");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.T(byteString);
        r();
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.j.e(source, "source");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f913b.write(source);
        r();
        return iWrite;
    }

    @Override // o1.m
    public final m writeByte(int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.U(i2);
        r();
        return this;
    }

    @Override // o1.m
    public final m writeInt(int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.X(i2);
        r();
        return this;
    }

    @Override // o1.m
    public final m writeShort(int i2) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.Z(i2);
        r();
        return this;
    }

    @Override // o1.m
    public final m x(String string) {
        kotlin.jvm.internal.j.e(string, "string");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.b0(string);
        r();
        return this;
    }

    @Override // o1.m
    public final m y(long j) {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.f913b.V(j);
        r();
        return this;
    }

    @Override // o1.m
    public final OutputStream z() {
        return new k(this, 1);
    }

    @Override // o1.o0
    public final void write(l source, long j) {
        kotlin.jvm.internal.j.e(source, "source");
        if (!this.c) {
            this.f913b.write(source, j);
            r();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // o1.m
    public final m write(byte[] source) {
        kotlin.jvm.internal.j.e(source, "source");
        if (!this.c) {
            this.f913b.m79write(source);
            r();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // o1.m
    public final m write(byte[] source, int i2, int i3) {
        kotlin.jvm.internal.j.e(source, "source");
        if (!this.c) {
            this.f913b.m80write(source, i2, i3);
            r();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
