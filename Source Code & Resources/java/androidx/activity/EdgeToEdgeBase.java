package androidx.activity;

import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class EdgeToEdgeBase implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean z2, boolean z3) {
        j.e(statusBarStyle, "statusBarStyle");
        j.e(navigationBarStyle, "navigationBarStyle");
        j.e(window, "window");
        j.e(view, "view");
    }
}
