package androidx.profileinstaller;

import android.content.Context;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f148a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f149b;

    public /* synthetic */ b(Context context, int i2) {
        this.f148a = i2;
        this.f149b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f148a) {
            case 0:
                ProfileInstallerInitializer.writeInBackground(this.f149b);
                break;
            default:
                ProfileInstaller.writeProfile(this.f149b);
                break;
        }
    }
}
