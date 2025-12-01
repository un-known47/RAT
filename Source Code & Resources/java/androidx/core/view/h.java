package androidx.core.view;

import android.view.View;
import androidx.core.view.SoftwareKeyboardControllerCompat;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f107a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f108b;

    public /* synthetic */ h(int i2, Object obj) {
        this.f107a = i2;
        this.f108b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f107a) {
            case 0:
                SoftwareKeyboardControllerCompat.Impl20.lambda$show$0((View) this.f108b);
                break;
            default:
                ((y0.a) this.f108b).invoke();
                break;
        }
    }
}
