package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f314a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f315b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(int i2, Object obj, Object obj2) {
        this.f314a = i2;
        this.f315b = obj;
        this.c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f314a) {
            case 0:
                SearchBarAnimationHelper.lambda$getExpandedViewBackgroundUpdateListener$1((MaterialShapeDrawable) this.f315b, (View) this.c, valueAnimator);
                break;
            default:
                ((SearchViewAnimationHelper) this.f315b).lambda$addEditTextClipAnimator$6((Rect) this.c, valueAnimator);
                break;
        }
    }
}
