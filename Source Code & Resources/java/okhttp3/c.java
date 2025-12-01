package okhttp3;

import java.util.List;
import okhttp3.Handshake;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements y0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f958a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f959b;

    public /* synthetic */ c(List list, int i2) {
        this.f958a = i2;
        this.f959b = list;
    }

    @Override // y0.a
    public final Object invoke() {
        switch (this.f958a) {
            case 0:
                return Handshake.Companion.get$lambda$3(this.f959b);
            default:
                return Handshake.Companion.handshake$lambda$2(this.f959b);
        }
    }
}
