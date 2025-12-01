package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static void b(LocationListenerCompat locationListenerCompat, List list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i2));
        }
    }

    public static void a(LocationListenerCompat locationListenerCompat, int i2) {
    }

    public static void c(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, String str, int i2, Bundle bundle) {
    }
}
