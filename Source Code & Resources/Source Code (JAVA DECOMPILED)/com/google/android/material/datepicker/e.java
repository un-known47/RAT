package com.google.android.material.datepicker;

import android.view.View;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialDatePicker f293b;

    public /* synthetic */ e(MaterialDatePicker materialDatePicker, int i2) {
        this.f292a = i2;
        this.f293b = materialDatePicker;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f292a) {
            case 0:
                this.f293b.lambda$initHeaderToggle$0(view);
                break;
            case 1:
                this.f293b.onPositiveButtonClick(view);
                break;
            default:
                this.f293b.onNegativeButtonClick(view);
                break;
        }
    }
}
