package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements y0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f965a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f966b;
    public final /* synthetic */ Lockable c;

    public /* synthetic */ b(Lockable lockable, long j, int i2) {
        this.f965a = i2;
        this.c = lockable;
        this.f966b = j;
    }

    @Override // y0.a
    public final Object invoke() throws IOException {
        long j_init_$lambda$2;
        switch (this.f965a) {
            case 0:
                j_init_$lambda$2 = Http2Connection._init_$lambda$2((Http2Connection) this.c, this.f966b);
                break;
            default:
                j_init_$lambda$2 = RealWebSocket.initReaderAndWriter$lambda$3$lambda$2((RealWebSocket) this.c, this.f966b);
                break;
        }
        return Long.valueOf(j_init_$lambda$2);
    }
}
