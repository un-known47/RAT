package okhttp3.internal.connection;

import kotlin.jvm.internal.e;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class AddressPolicy {
    public final long backoffDelayMillis;
    public final int backoffJitterMillis;
    public final int minimumConcurrentCalls;

    public AddressPolicy() {
        this(0, 0L, 0, 7, null);
    }

    public AddressPolicy(int i2, long j, int i3) {
        this.minimumConcurrentCalls = i2;
        this.backoffDelayMillis = j;
        this.backoffJitterMillis = i3;
    }

    public /* synthetic */ AddressPolicy(int i2, long j, int i3, int i4, e eVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS : j, (i4 & 4) != 0 ? 100 : i3);
    }
}
