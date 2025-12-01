package okhttp3.internal.ws;

import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.jvm.internal.j;
import o1.b;
import o1.i;
import o1.l;
import o1.o;
import o1.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MessageDeflater implements Closeable {
    private final l deflatedBytes;
    private final Deflater deflater;
    private final p deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z2) {
        this.noContextTakeover = z2;
        l lVar = new l();
        this.deflatedBytes = lVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new p(b.b(lVar), deflater);
    }

    private final boolean endsWith(l lVar, o oVar) {
        return lVar.m(lVar.f919b - oVar.d(), oVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.deflaterSink.close();
    }

    public final void deflate(l buffer) {
        j.e(buffer, "buffer");
        if (this.deflatedBytes.f919b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.write(buffer, buffer.f919b);
        this.deflaterSink.flush();
        if (endsWith(this.deflatedBytes, MessageDeflaterKt.EMPTY_DEFLATE_BLOCK)) {
            l lVar = this.deflatedBytes;
            long j = lVar.f919b - 4;
            i iVarL = lVar.L(b.f888a);
            try {
                iVarL.a(j);
                iVarL.close();
            } finally {
            }
        } else {
            this.deflatedBytes.U(0);
        }
        l lVar2 = this.deflatedBytes;
        buffer.write(lVar2, lVar2.f919b);
    }
}
