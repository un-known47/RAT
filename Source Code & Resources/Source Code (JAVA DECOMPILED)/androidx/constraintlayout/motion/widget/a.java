package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.DispatchQueue;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f58a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f59b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f58a = i2;
        this.f59b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f58a) {
            case 0:
                ((ViewTransition) this.f59b).lambda$applyTransition$0((View[]) this.c);
                break;
            case 1:
                ((ResourcesCompat.FontCallback) this.f59b).lambda$callbackSuccessAsync$0((Typeface) this.c);
                break;
            case 2:
                DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1((DispatchQueue) this.f59b, (Runnable) this.c);
                break;
            case 3:
                ((ProfileInstallerInitializer) this.f59b).lambda$delayAfterFirstFrame$0((Context) this.c);
                break;
            case 4:
                FragmentStrictMode.m37handlePolicyViolation$lambda0((FragmentStrictMode.Policy) this.f59b, (Violation) this.c);
                break;
            default:
                FragmentStrictMode.m38handlePolicyViolation$lambda1((String) this.f59b, (Violation) this.c);
                break;
        }
    }
}
