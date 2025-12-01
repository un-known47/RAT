package okhttp3.internal.http2;

import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements y0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f969a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Http2Connection f970b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ d(Http2Connection http2Connection, int i2, Object obj, int i3) {
        this.f969a = i3;
        this.f970b = http2Connection;
        this.c = i2;
        this.d = obj;
    }

    @Override // y0.a
    public final Object invoke() {
        switch (this.f969a) {
            case 0:
                return Http2Connection.writeSynResetLater$lambda$12(this.f970b, this.c, (ErrorCode) this.d);
            case 1:
                return Http2Connection.pushResetLater$lambda$40(this.f970b, this.c, (ErrorCode) this.d);
            default:
                return Http2Connection.pushRequestLater$lambda$32(this.f970b, this.c, (List) this.d);
        }
    }
}
