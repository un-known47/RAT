package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f113a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewConfiguration f114b;

    public /* synthetic */ l(ViewConfiguration viewConfiguration, int i2) {
        this.f113a = i2;
        this.f114b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int scaledMaximumFlingVelocity;
        switch (this.f113a) {
            case 0:
                scaledMaximumFlingVelocity = this.f114b.getScaledMaximumFlingVelocity();
                break;
            default:
                scaledMaximumFlingVelocity = this.f114b.getScaledMinimumFlingVelocity();
                break;
        }
        return Integer.valueOf(scaledMaximumFlingVelocity);
    }
}
