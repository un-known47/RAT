package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.internal.MultiViewUpdateListener;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements MultiViewUpdateListener.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f301a;

    public /* synthetic */ a(int i2) {
        this.f301a = i2;
    }

    @Override // com.google.android.material.internal.MultiViewUpdateListener.Listener
    public final void onAnimationUpdate(ValueAnimator valueAnimator, View view) {
        switch (this.f301a) {
            case 0:
                MultiViewUpdateListener.setTranslationX(valueAnimator, view);
                break;
            case 1:
                MultiViewUpdateListener.setScale(valueAnimator, view);
                break;
            case 2:
                MultiViewUpdateListener.setTranslationY(valueAnimator, view);
                break;
            default:
                MultiViewUpdateListener.setAlpha(valueAnimator, view);
                break;
        }
    }
}
