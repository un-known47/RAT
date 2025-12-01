package com.google.android.material.search;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f319b;

    public /* synthetic */ f(SearchView searchView, int i2) {
        this.f318a = i2;
        this.f319b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f318a) {
            case 0:
                this.f319b.lambda$clearFocusAndHideKeyboard$9();
                break;
            case 1:
                this.f319b.lambda$requestFocusAndShowKeyboard$8();
                break;
            case 2:
                this.f319b.show();
                break;
            default:
                this.f319b.requestFocusAndShowKeyboardIfNeeded();
                break;
        }
    }
}
