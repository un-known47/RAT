package com.google.android.material.motion;

import android.animation.ValueAnimator;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.google.android.material.progressindicator.DeterminateDrawable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f305a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f306b;

    public /* synthetic */ c(int i2, Object obj) {
        this.f305a = i2;
        this.f306b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f305a) {
            case 0:
                MaterialMainContainerBackHelper.lambda$createCornerAnimator$1((ClippableRoundedCornerLayout) this.f306b, valueAnimator);
                break;
            case 1:
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0((DrawerLayout) this.f306b, valueAnimator);
                break;
            default:
                ((DeterminateDrawable) this.f306b).lambda$maybeInitializeAmplitudeAnimator$1(valueAnimator);
                break;
        }
    }
}
