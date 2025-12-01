package androidx.appcompat.widget;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f38a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f39b;

    public /* synthetic */ c(Toolbar toolbar, int i2) {
        this.f38a = i2;
        this.f39b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f38a) {
            case 0:
                this.f39b.collapseActionView();
                break;
            default:
                this.f39b.invalidateMenu();
                break;
        }
    }
}
