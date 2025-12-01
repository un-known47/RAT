package g1;

import java.util.concurrent.TimeUnit;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f511b;
    public static final c c;
    public static final c d;

    /* renamed from: a, reason: collision with root package name */
    public final TimeUnit f512a;

    static {
        c cVar = new c("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
        f511b = cVar;
        c cVar2 = new c("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
        c cVar3 = new c("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
        c = cVar3;
        c cVar4 = new c("SECONDS", 3, TimeUnit.SECONDS);
        d = cVar4;
        p.a.v(new c[]{cVar, cVar2, cVar3, cVar4, new c("MINUTES", 4, TimeUnit.MINUTES), new c("HOURS", 5, TimeUnit.HOURS), new c("DAYS", 6, TimeUnit.DAYS)});
    }

    public c(String str, int i2, TimeUnit timeUnit) {
        this.f512a = timeUnit;
    }
}
