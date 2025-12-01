package okhttp3.internal.connection;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ boolean a(RoutePlanner routePlanner, RealConnection realConnection, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hasNext");
        }
        if ((i2 & 1) != 0) {
            realConnection = null;
        }
        return routePlanner.hasNext(realConnection);
    }
}
