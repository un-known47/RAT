package o1;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface n extends p0, ReadableByteChannel {
    long A();

    String B(Charset charset);

    InputStream C();

    l b();

    int c(g0 g0Var);

    o g();

    o h(long j);

    long i(l lVar);

    boolean k(long j);

    boolean m(long j, o oVar);

    String n();

    byte[] o();

    void p(l lVar, long j);

    k0 peek();

    boolean q();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    long s();

    void skip(long j);

    String t(long j);

    long v(long j, o oVar);

    void w(long j);
}
