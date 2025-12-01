package androidx.activity;

import androidx.activity.ComponentActivity;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f27a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f28b;

    public /* synthetic */ d(int i2, Object obj) {
        this.f27a = i2;
        this.f28b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f27a) {
            case 0:
                ((ComponentActivity.ReportFullyDrawnExecutorApi16Impl) this.f28b).lambda$execute$0();
                break;
            case 1:
                ((ComponentActivity) this.f28b).invalidateMenu();
                break;
            case 2:
                ComponentDialog.onBackPressedDispatcher$lambda$1((ComponentDialog) this.f28b);
                break;
            default:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) this.f28b);
                break;
        }
    }
}
