package okhttp3.internal.http2.flowcontrol;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class WindowCounter {
    private long acknowledged;
    private final int streamId;
    private long total;

    public WindowCounter(int i2) {
        this.streamId = i2;
    }

    public static /* synthetic */ void update$default(WindowCounter windowCounter, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = 0;
        }
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        windowCounter.update(j, j2);
    }

    public final long getAcknowledged() {
        return this.acknowledged;
    }

    public final int getStreamId() {
        return this.streamId;
    }

    public final long getTotal() {
        return this.total;
    }

    public final synchronized long getUnacknowledged() {
        return this.total - this.acknowledged;
    }

    public String toString() {
        return "WindowCounter(streamId=" + this.streamId + ", total=" + this.total + ", acknowledged=" + this.acknowledged + ", unacknowledged=" + getUnacknowledged() + ')';
    }

    public final synchronized void update(long j, long j2) {
        try {
            if (j < 0) {
                throw new IllegalStateException("Check failed.");
            }
            if (j2 < 0) {
                throw new IllegalStateException("Check failed.");
            }
            long j3 = this.total + j;
            this.total = j3;
            long j4 = this.acknowledged + j2;
            this.acknowledged = j4;
            if (j4 > j3) {
                throw new IllegalStateException("Check failed.");
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
