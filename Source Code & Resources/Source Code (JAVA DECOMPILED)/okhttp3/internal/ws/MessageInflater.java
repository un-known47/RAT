package okhttp3.internal.ws;

import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.j;
import o1.b;
import o1.b0;
import o1.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MessageInflater implements Closeable {
    private final l deflatedBytes;
    private final Inflater inflater;
    private final b0 inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean z2) {
        this.noContextTakeover = z2;
        l lVar = new l();
        this.deflatedBytes = lVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new b0(b.c(lVar), inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(l buffer) throws DataFormatException, IOException {
        j.e(buffer, "buffer");
        if (this.deflatedBytes.f919b != 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.f(buffer);
        this.deflatedBytes.X(65535);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.f919b;
        do {
            this.inflaterSource.a(buffer, LocationRequestCompat.PASSIVE_INTERVAL);
            if (this.inflater.getBytesRead() >= bytesRead) {
                return;
            }
        } while (!this.inflater.finished());
    }
}
