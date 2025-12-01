package com.google.android.material.textfield;

import android.view.View;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f342a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f343b;

    public /* synthetic */ a(EndIconDelegate endIconDelegate, int i2) {
        this.f342a = i2;
        this.f343b = endIconDelegate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f342a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f343b).lambda$new$0(view);
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f343b).lambda$new$0(view);
                break;
            default:
                ((PasswordToggleEndIconDelegate) this.f343b).lambda$new$0(view);
                break;
        }
    }
}
