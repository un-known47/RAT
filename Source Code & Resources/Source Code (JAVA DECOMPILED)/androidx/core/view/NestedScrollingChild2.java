package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i2, int i3, @Nullable int[] iArr, @Nullable int[] iArr2, int i4);

    boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, @Nullable int[] iArr, int i6);

    boolean hasNestedScrollingParent(int i2);

    boolean startNestedScroll(int i2, int i3);

    void stopNestedScroll(int i2);
}
