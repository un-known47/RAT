package h1;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a extends u0 implements p0.d, s {

    /* renamed from: b, reason: collision with root package name */
    public final p0.i f527b;

    public a(p0.i iVar, boolean z2) {
        super(z2);
        s((n0) iVar.get(q.f562b));
        this.f527b = iVar.plus(this);
    }

    @Override // h1.u0
    public final String g() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // p0.d
    public final p0.i getContext() {
        return this.f527b;
    }

    @Override // h1.s
    public final p0.i getCoroutineContext() {
        return this.f527b;
    }

    @Override // h1.u0
    public final void r(a0.s sVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        u.d(this.f527b, sVar);
    }

    @Override // p0.d
    public final void resumeWith(Object obj) {
        Throwable thA = l0.f.a(obj);
        if (thA != null) {
            obj = new k(false, thA);
        }
        Object objU = u(obj);
        if (objU == u.c) {
            return;
        }
        d(objU);
    }
}
