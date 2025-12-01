package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f253a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f254b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f253a = i2;
        this.f254b = obj;
        this.c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f253a) {
            case 0:
                ((AppBarLayout) this.f254b).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) this.c, valueAnimator);
                break;
            case 1:
                ((ExpandCollapseAnimationHelper) this.f254b).lambda$getExpandCollapseAnimator$0((Rect) this.c, valueAnimator);
                break;
            default:
                ((DeterminateDrawable) this.f254b).lambda$new$0((BaseProgressIndicatorSpec) this.c, valueAnimator);
                break;
        }
    }
}
