package o1;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class k extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f914a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f915b;

    public /* synthetic */ k(m mVar, int i2) {
        this.f914a = i2;
        this.f915b = mVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f914a) {
            case 0:
                break;
            default:
                ((j0) this.f915b).close();
                break;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        switch (this.f914a) {
            case 0:
                break;
            default:
                j0 j0Var = (j0) this.f915b;
                if (!j0Var.c) {
                    j0Var.flush();
                    break;
                }
                break;
        }
    }

    public final String toString() {
        switch (this.f914a) {
            case 0:
                return ((l) this.f915b) + ".outputStream()";
            default:
                return ((j0) this.f915b) + ".outputStream()";
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i2) throws IOException {
        switch (this.f914a) {
            case 0:
                ((l) this.f915b).U(i2);
                return;
            default:
                j0 j0Var = (j0) this.f915b;
                if (j0Var.c) {
                    throw new IOException("closed");
                }
                j0Var.f913b.U((byte) i2);
                j0Var.r();
                return;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i2, int i3) throws IOException {
        switch (this.f914a) {
            case 0:
                kotlin.jvm.internal.j.e(data, "data");
                ((l) this.f915b).m80write(data, i2, i3);
                return;
            default:
                kotlin.jvm.internal.j.e(data, "data");
                j0 j0Var = (j0) this.f915b;
                if (!j0Var.c) {
                    j0Var.f913b.m80write(data, i2, i3);
                    j0Var.r();
                    return;
                }
                throw new IOException("closed");
        }
    }

    private final void D() {
    }

    private final void a() {
    }
}
