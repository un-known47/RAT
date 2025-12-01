package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import com.google.android.material.internal.FadeThroughDrawable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f308a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f309b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f308a = i2;
        this.f309b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f308a) {
            case 0:
                ((View) this.f309b).setAlpha(0.0f);
                break;
            case 1:
                SearchViewAnimationHelper.lambda$addBackButtonAnimatorIfNeeded$3((ImageButton) this.f309b, valueAnimator);
                break;
            case 2:
                SearchViewAnimationHelper.lambda$addDrawerArrowDrawableAnimatorIfNeeded$4((DrawerArrowDrawable) this.f309b, valueAnimator);
                break;
            case 3:
                SearchViewAnimationHelper.lambda$addFadeThroughDrawableAnimatorIfNeeded$5((FadeThroughDrawable) this.f309b, valueAnimator);
                break;
            default:
                ((SearchViewAnimationHelper) this.f309b).lambda$addTextFadeAnimatorIfNeeded$7(valueAnimator);
                break;
        }
    }
}
