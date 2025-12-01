package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f80a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f81b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g(Object obj, Executor executor, Object obj2, int i2) {
        this.f80a = i2;
        this.c = obj;
        this.f81b = executor;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f80a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.c).lambda$onGnssMeasurementsReceived$0(this.f81b, (GnssMeasurementsEvent) this.d);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.c).lambda$onGpsStatusChanged$3(this.f81b, (GnssStatusCompat) this.d);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.c).lambda$onSatelliteStatusChanged$3(this.f81b, (GnssStatus) this.d);
                break;
        }
    }
}
