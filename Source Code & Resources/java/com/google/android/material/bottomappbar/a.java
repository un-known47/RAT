package com.google.android.material.bottomappbar;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f257a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f258b;

    public /* synthetic */ a(View view, int i2) {
        this.f257a = i2;
        this.f258b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f257a) {
            case 0:
                this.f258b.requestLayout();
                break;
            default:
                ViewUtils.requestFocusAndShowKeyboard(this.f258b, false);
                break;
        }
    }
}
