package o1;

import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface m extends o0, WritableByteChannel {
    l b();

    m d(String str, int i2, int i3);

    m e(long j);

    long f(p0 p0Var);

    @Override // o1.o0, java.io.Flushable
    void flush();

    m j();

    m l(int i2);

    m r();

    m u(o oVar);

    m write(byte[] bArr);

    m write(byte[] bArr, int i2, int i3);

    m writeByte(int i2);

    m writeInt(int i2);

    m writeShort(int i2);

    m x(String str);

    m y(long j);

    OutputStream z();
}
