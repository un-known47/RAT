package j0;

import android.content.res.Resources;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f688a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f689b;

    public /* synthetic */ d(c cVar, int i2) {
        this.f688a = i2;
        this.f689b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Resources.NotFoundException {
        switch (this.f688a) {
            case 0:
                this.f689b.f687b.f362a.setChecked(false);
                break;
            default:
                this.f689b.f687b.f362a.setChecked(true);
                break;
        }
    }
}
