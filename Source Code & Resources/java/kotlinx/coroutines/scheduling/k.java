package kotlinx.coroutines.scheduling;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final long f841a = kotlinx.coroutines.internal.b.e(100000, 1, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.resolution.ns");

    /* renamed from: b, reason: collision with root package name */
    public static final int f842b;
    public static final int c;
    public static final long d;

    /* renamed from: e, reason: collision with root package name */
    public static final f f843e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f844f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f845g;

    static {
        int i2 = p.f815a;
        if (i2 < 2) {
            i2 = 2;
        }
        f842b = kotlinx.coroutines.internal.b.f("kotlinx.coroutines.scheduler.core.pool.size", i2, 8);
        c = kotlinx.coroutines.internal.b.f("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 4);
        d = TimeUnit.SECONDS.toNanos(kotlinx.coroutines.internal.b.e(60L, 1L, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f843e = f.f836a;
        f844f = new i(0);
        f845g = new i(1);
    }
}
