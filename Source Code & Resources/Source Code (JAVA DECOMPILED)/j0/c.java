package j0;

import com.google.android.gms.common.api.Status;
import com.service.downloadapp.AppMainActivity;
import k.d0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c implements y.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f686a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMainActivity f687b;

    public /* synthetic */ c(AppMainActivity appMainActivity, int i2) {
        this.f686a = i2;
        this.f687b = appMainActivity;
    }

    @Override // y.b
    public final void a(y.g gVar) {
        switch (this.f686a) {
            case 0:
                try {
                    boolean zC = gVar.c();
                    AppMainActivity appMainActivity = this.f687b;
                    if (zC) {
                        d0 d0Var = ((v.d) gVar.b()).f1191a;
                        Status status = (Status) d0Var.f719b;
                        if ((status == null || status.f223a > 0) ? false : d0Var.f718a) {
                            appMainActivity.runOnUiThread(new b(this, 0));
                            break;
                        }
                    }
                    appMainActivity.runOnUiThread(new b(this, 1));
                    break;
                } catch (Exception e2) {
                    e2.getStackTrace();
                    return;
                }
            default:
                try {
                    boolean zC2 = gVar.c();
                    AppMainActivity appMainActivity2 = this.f687b;
                    if (zC2) {
                        d0 d0Var2 = ((v.d) gVar.b()).f1191a;
                        Status status2 = (Status) d0Var2.f719b;
                        if ((status2 == null || status2.f223a > 0) ? false : d0Var2.f718a) {
                            appMainActivity2.runOnUiThread(new d(this, 0));
                            break;
                        }
                    }
                    appMainActivity2.runOnUiThread(new d(this, 1));
                    break;
                } catch (Exception e3) {
                    e3.getStackTrace();
                }
                break;
        }
    }
}
