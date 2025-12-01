package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f2, float f3, boolean z2);

    boolean dispatchNestedPreFling(float f2, float f3);

    boolean dispatchNestedPreScroll(int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z2);

    boolean startNestedScroll(int i2);

    void stopNestedScroll();
}
