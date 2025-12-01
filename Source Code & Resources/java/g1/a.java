package g1;

import androidx.core.location.LocationRequestCompat;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public static final long f508a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f509b;
    public static final /* synthetic */ int c = 0;

    static {
        int i2 = b.f510a;
        f508a = LocationRequestCompat.PASSIVE_INTERVAL;
        f509b = -9223372036854775805L;
    }

    public static final long a(long j, c unit) {
        j.e(unit, "unit");
        if (j == f508a) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j == f509b) {
            return Long.MIN_VALUE;
        }
        long j2 = j >> 1;
        c sourceUnit = (((int) j) & 1) == 0 ? c.f511b : c.c;
        j.e(sourceUnit, "sourceUnit");
        return unit.f512a.convert(j2, sourceUnit.f512a);
    }
}
