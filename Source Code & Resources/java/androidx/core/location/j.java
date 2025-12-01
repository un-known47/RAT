package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f86a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f87b;
    public final /* synthetic */ String c;

    public /* synthetic */ j(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i2) {
        this.f86a = i2;
        this.f87b = locationListenerTransport;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f86a) {
            case 0:
                this.f87b.lambda$onProviderEnabled$4(this.c);
                break;
            default:
                this.f87b.lambda$onProviderDisabled$5(this.c);
                break;
        }
    }
}
