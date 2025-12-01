package s;

import android.os.Build;
import androidx.core.view.accessibility.AccessibilityEventCompat;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1179a;

    static {
        f1179a = Build.VERSION.SDK_INT >= 23 ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 0;
    }
}
