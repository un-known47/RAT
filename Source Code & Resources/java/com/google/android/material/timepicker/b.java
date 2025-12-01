package com.google.android.material.timepicker;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f356b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f355a = i2;
        this.f356b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f355a) {
            case 0:
                ((RadialViewGroup) this.f356b).updateLayoutParams();
                break;
            default:
                ((MaterialTimePicker) this.f356b).lambda$onViewCreated$0();
                break;
        }
    }
}
