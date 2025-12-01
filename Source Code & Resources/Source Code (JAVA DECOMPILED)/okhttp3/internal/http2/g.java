package okhttp3.internal.http2;

import kotlin.jvm.internal.o;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements y0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f975a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f976b;
    public final /* synthetic */ Object c;

    public /* synthetic */ g(int i2, Object obj, Object obj2) {
        this.f975a = i2;
        this.f976b = obj;
        this.c = obj2;
    }

    @Override // y0.a
    public final Object invoke() {
        switch (this.f975a) {
            case 0:
                return Http2Connection.ReaderRunnable.headers$lambda$2$lambda$1((Http2Connection) this.f976b, (Http2Stream) this.c);
            case 1:
                return Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$7$lambda$6$lambda$5((Http2Connection) this.f976b, (o) this.c);
            default:
                return RealWebSocket.failWebSocket$lambda$14$lambda$13((o) this.f976b, (o) this.c);
        }
    }
}
