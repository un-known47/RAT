package com.google.android.material.search;

import android.animation.Animator;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements ViewUtils.OnApplyWindowInsetsListener, OnApplyWindowInsetsListener, AnimatableView.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f324a;

    public /* synthetic */ i(Object obj) {
        this.f324a = obj;
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.f324a).start();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return ((SearchView) this.f324a).lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return ((SearchView) this.f324a).lambda$setUpToolbarInsetListener$4(view, windowInsetsCompat, relativePadding);
    }
}
