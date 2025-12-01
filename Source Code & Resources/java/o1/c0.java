package o1;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c0 extends r {
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final Closeable f891e;

    public /* synthetic */ c0(Closeable closeable, int i2) {
        this.d = i2;
        this.f891e = closeable;
    }

    private final synchronized void G() {
        ((RandomAccessFile) this.f891e).close();
    }

    private final synchronized void H() {
        ((FileChannel) this.f891e).close();
    }

    private final synchronized int I(long j, byte[] array, int i2, int i3) {
        kotlin.jvm.internal.j.e(array, "array");
        ((RandomAccessFile) this.f891e).seek(j);
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i5 = ((RandomAccessFile) this.f891e).read(array, i2, i3 - i4);
            if (i5 != -1) {
                i4 += i5;
            } else if (i4 == 0) {
                return -1;
            }
        }
        return i4;
    }

    private final synchronized int J(long j, byte[] array, int i2, int i3) {
        kotlin.jvm.internal.j.e(array, "array");
        ((FileChannel) this.f891e).position(j);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i2, i3);
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            int i5 = ((FileChannel) this.f891e).read(byteBufferWrap);
            if (i5 != -1) {
                i4 += i5;
            } else if (i4 == 0) {
                return -1;
            }
        }
        return i4;
    }

    private final synchronized long K() {
        return ((RandomAccessFile) this.f891e).length();
    }

    private final synchronized long L() {
        return ((FileChannel) this.f891e).size();
    }

    @Override // o1.r
    public final synchronized int D(long j, byte[] bArr, int i2, int i3) {
        switch (this.d) {
            case 0:
                return I(j, bArr, i2, i3);
            default:
                return J(j, bArr, i2, i3);
        }
    }

    @Override // o1.r
    public final synchronized long E() {
        switch (this.d) {
            case 0:
                return K();
            default:
                return L();
        }
    }

    @Override // o1.r
    public final synchronized void a() {
        switch (this.d) {
            case 0:
                G();
                break;
            default:
                H();
                break;
        }
    }
}
