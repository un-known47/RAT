package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z2);

    boolean onNestedPreFling(@NonNull View view, float f2, float f3);

    void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2);

    void onStopNestedScroll(@NonNull View view);
}
