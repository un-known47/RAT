package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.Random;
import kotlin.jvm.internal.j;
import o1.i;
import o1.l;
import o1.m;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final i maskCursor;
    private final byte[] maskKey;
    private final l messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final m sink;
    private final l sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z2, m sink, Random random, boolean z3, boolean z4, long j) {
        j.e(sink, "sink");
        j.e(random, "random");
        this.isClient = z2;
        this.sink = sink;
        this.random = random;
        this.perMessageDeflate = z3;
        this.noContextTakeover = z4;
        this.minimumDeflateSize = j;
        this.messageBuffer = new l();
        this.sinkBuffer = sink.b();
        this.maskKey = z2 ? new byte[4] : null;
        this.maskCursor = z2 ? new i() : null;
    }

    private final void writeControlFrame(int i2, o oVar) throws IOException {
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        int iD = oVar.d();
        if (iD > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.sinkBuffer.U(i2 | 128);
        if (this.isClient) {
            this.sinkBuffer.U(iD | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            j.b(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m79write(this.maskKey);
            if (iD > 0) {
                l lVar = this.sinkBuffer;
                long j = lVar.f919b;
                lVar.T(oVar);
                l lVar2 = this.sinkBuffer;
                i iVar = this.maskCursor;
                j.b(iVar);
                lVar2.L(iVar);
                this.maskCursor.D(j);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            this.sinkBuffer.U(iD);
            this.sinkBuffer.T(oVar);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            messageDeflater.close();
        }
    }

    public final Random getRandom() {
        return this.random;
    }

    public final m getSink() {
        return this.sink;
    }

    public final void writeClose(int i2, o oVar) throws EOFException {
        o oVarH = o.d;
        if (i2 != 0 || oVar != null) {
            if (i2 != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i2);
            }
            l lVar = new l();
            lVar.Z(i2);
            if (oVar != null) {
                lVar.T(oVar);
            }
            oVarH = lVar.h(lVar.f919b);
        }
        try {
            writeControlFrame(8, oVarH);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i2, o data) throws IOException {
        j.e(data, "data");
        if (this.writerClosed) {
            throw new IOException("closed");
        }
        this.messageBuffer.T(data);
        int i3 = i2 | 128;
        if (this.perMessageDeflate && data.d() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i3 = i2 | 192;
        }
        long j = this.messageBuffer.f919b;
        this.sinkBuffer.U(i3);
        int i4 = this.isClient ? 128 : 0;
        if (j <= 125) {
            this.sinkBuffer.U(i4 | ((int) j));
        } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            this.sinkBuffer.U(i4 | 126);
            this.sinkBuffer.Z((int) j);
        } else {
            this.sinkBuffer.U(i4 | 127);
            this.sinkBuffer.Y(j);
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            j.b(bArr);
            random.nextBytes(bArr);
            this.sinkBuffer.m79write(this.maskKey);
            if (j > 0) {
                l lVar = this.messageBuffer;
                i iVar = this.maskCursor;
                j.b(iVar);
                lVar.L(iVar);
                this.maskCursor.D(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, j);
        this.sink.j();
    }

    public final void writePing(o payload) {
        j.e(payload, "payload");
        writeControlFrame(9, payload);
    }

    public final void writePong(o payload) throws IOException {
        j.e(payload, "payload");
        writeControlFrame(10, payload);
    }
}
