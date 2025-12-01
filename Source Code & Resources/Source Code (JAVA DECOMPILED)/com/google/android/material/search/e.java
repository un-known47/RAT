package com.google.android.material.search;

import android.view.View;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f316a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f317b;

    public /* synthetic */ e(SearchView searchView, int i2) {
        this.f316a = i2;
        this.f317b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f316a) {
            case 0:
                this.f317b.lambda$setUpBackButton$1(view);
                break;
            case 1:
                this.f317b.lambda$setUpClearButton$2(view);
                break;
            default:
                this.f317b.lambda$setupWithSearchBar$7(view);
                break;
        }
    }
}
