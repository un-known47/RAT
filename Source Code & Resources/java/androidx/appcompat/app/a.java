package androidx.appcompat.app;

import android.content.Context;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f32a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f33b;

    public /* synthetic */ a(Context context, int i2) {
        this.f32a = i2;
        this.f33b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f32a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1(this.f33b);
                break;
            default:
                AppCompatDelegate.syncRequestedAndStoredLocales(this.f33b);
                break;
        }
    }
}
