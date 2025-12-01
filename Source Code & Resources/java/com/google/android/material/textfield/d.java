package com.google.android.material.textfield;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f348a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f349b;

    public /* synthetic */ d(int i2, Object obj) {
        this.f348a = i2;
        this.f349b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f348a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f349b).lambda$tearDown$2();
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) this.f349b).lambda$afterEditTextChanged$3();
                break;
            default:
                ((TextInputLayout) this.f349b).lambda$onGlobalLayout$1();
                break;
        }
    }
}
