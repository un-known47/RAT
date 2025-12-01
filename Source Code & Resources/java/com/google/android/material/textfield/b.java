package com.google.android.material.textfield;

import android.view.View;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f344a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f345b;

    public /* synthetic */ b(EndIconDelegate endIconDelegate, int i2) {
        this.f344a = i2;
        this.f345b = endIconDelegate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        switch (this.f344a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f345b).lambda$new$1(view, z2);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.f345b).lambda$new$1(view, z2);
                break;
        }
    }
}
