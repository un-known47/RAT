package androidx.core.widget;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f119a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f120b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i2) {
        this.f119a = i2;
        this.f120b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f119a) {
            case 0:
                this.f120b.lambda$new$0();
                break;
            case 1:
                this.f120b.lambda$new$1();
                break;
            case 2:
                this.f120b.showOnUiThread();
                break;
            default:
                this.f120b.hideOnUiThread();
                break;
        }
    }
}
