package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f346a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f347b;

    public /* synthetic */ c(EndIconDelegate endIconDelegate, int i2) {
        this.f346a = i2;
        this.f347b = endIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f346a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f347b).lambda$getAlphaAnimator$3(valueAnimator);
                break;
            case 1:
                ((ClearTextEndIconDelegate) this.f347b).lambda$getScaleAnimator$4(valueAnimator);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.f347b).lambda$getAlphaAnimator$6(valueAnimator);
                break;
        }
    }
}
