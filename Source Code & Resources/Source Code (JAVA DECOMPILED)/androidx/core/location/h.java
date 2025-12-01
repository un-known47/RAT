package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f82a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f83b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ h(Object obj, Executor executor, int i2, int i3) {
        this.f82a = i3;
        this.d = obj;
        this.f83b = executor;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f82a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.d).lambda$onStatusChanged$1(this.f83b, this.c);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.d).lambda$onGpsStatusChanged$2(this.f83b, this.c);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.d).lambda$onFirstFix$2(this.f83b, this.c);
                break;
        }
    }
}
