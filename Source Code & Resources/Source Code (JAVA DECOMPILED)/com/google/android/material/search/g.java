package com.google.android.material.search;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f320a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f321b;

    public /* synthetic */ g(int i2, Object obj) {
        this.f320a = i2;
        this.f321b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f320a) {
            case 0:
                ((SearchViewAnimationHelper) this.f321b).hide();
                break;
            case 1:
                ((SearchViewAnimationHelper) this.f321b).lambda$startShowAnimationExpand$0();
                break;
            case 2:
                ((SearchViewAnimationHelper) this.f321b).lambda$startShowAnimationTranslate$1();
                break;
            default:
                ((SearchBar) this.f321b).lambda$startOnLoadAnimation$0();
                break;
        }
    }
}
