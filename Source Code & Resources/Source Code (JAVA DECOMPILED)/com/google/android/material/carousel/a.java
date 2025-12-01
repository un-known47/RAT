package com.google.android.material.carousel;

import android.view.View;
import com.google.android.material.navigation.NavigationBarItemView;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f262a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f263b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f262a = i2;
        this.f263b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        switch (this.f262a) {
            case 0:
                ((CarouselLayoutManager) this.f263b).lambda$new$0(view, i2, i3, i4, i5, i6, i7, i8, i9);
                break;
            default:
                ((NavigationBarItemView) this.f263b).lambda$new$0(view, i2, i3, i4, i5, i6, i7, i8, i9);
                break;
        }
    }
}
