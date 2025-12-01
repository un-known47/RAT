package h1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f533a = new ThreadLocal();

    public static g0 a() {
        ThreadLocal threadLocal = f533a;
        g0 g0Var = (g0) threadLocal.get();
        if (g0Var != null) {
            return g0Var;
        }
        c cVar = new c(Thread.currentThread());
        threadLocal.set(cVar);
        return cVar;
    }
}
