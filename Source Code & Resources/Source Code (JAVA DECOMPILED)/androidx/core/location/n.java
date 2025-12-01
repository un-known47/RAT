package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f94a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f95b;
    public final /* synthetic */ Executor c;

    public /* synthetic */ n(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i2) {
        this.f94a = i2;
        this.f95b = preRGnssStatusTransport;
        this.c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f94a) {
            case 0:
                this.f95b.lambda$onStopped$1(this.c);
                break;
            default:
                this.f95b.lambda$onStarted$0(this.c);
                break;
        }
    }
}
