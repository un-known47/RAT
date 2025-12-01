package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f88a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f89b;
    public final /* synthetic */ Object c;

    public /* synthetic */ k(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Object obj, int i2) {
        this.f88a = i2;
        this.f89b = locationListenerTransport;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f88a) {
            case 0:
                this.f89b.lambda$onLocationChanged$1((List) this.c);
                break;
            default:
                this.f89b.lambda$onLocationChanged$0((Location) this.c);
                break;
        }
    }
}
