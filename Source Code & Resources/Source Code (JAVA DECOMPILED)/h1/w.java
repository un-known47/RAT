package h1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f580a = 0;

    static {
        String property;
        int i2 = kotlinx.coroutines.internal.p.f815a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property != null ? Boolean.parseBoolean(property) : false)) {
            v vVar = v.f578e;
            return;
        }
        kotlinx.coroutines.scheduling.d dVar = b0.f530a;
        i1.c cVar = kotlinx.coroutines.internal.k.f813a;
        i1.c cVar2 = cVar.c;
        if (cVar != null) {
            return;
        }
        v vVar2 = v.f578e;
    }
}
