package okhttp3;

import java.util.List;
import okhttp3.internal.connection.ConnectPlan;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements y0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f949a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CertificatePinner f950b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(CertificatePinner certificatePinner, Object obj, Object obj2, int i2) {
        this.f949a = i2;
        this.f950b = certificatePinner;
        this.c = obj;
        this.d = obj2;
    }

    @Override // y0.a
    public final Object invoke() {
        switch (this.f949a) {
            case 0:
                return CertificatePinner.check$lambda$1(this.f950b, (List) this.c, (String) this.d);
            default:
                return ConnectPlan.connectTls$lambda$4(this.f950b, (Handshake) this.c, (Address) this.d);
        }
    }
}
