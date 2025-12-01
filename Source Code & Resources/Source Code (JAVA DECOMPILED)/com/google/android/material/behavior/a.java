package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f255a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f256b;
    public final /* synthetic */ CoordinatorLayout.Behavior c;

    public /* synthetic */ a(CoordinatorLayout.Behavior behavior, View view, int i2) {
        this.f255a = i2;
        this.c = behavior;
        this.f256b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z2) {
        switch (this.f255a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.c).lambda$disableIfTouchExplorationEnabled$0(this.f256b, z2);
                break;
            default:
                ((HideViewOnScrollBehavior) this.c).lambda$disableIfTouchExplorationEnabled$0(this.f256b, z2);
                break;
        }
    }
}
