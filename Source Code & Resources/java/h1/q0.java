package h1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class q0 extends kotlinx.coroutines.internal.g implements c0, j0, y0.l {
    public u0 d;

    @Override // h1.j0
    public final boolean a() {
        return true;
    }

    @Override // h1.j0
    public final v0 c() {
        return null;
    }

    @Override // h1.c0
    public final void dispose() {
        u0 u0VarK = k();
        while (true) {
            Object objP = u0VarK.p();
            if (!(objP instanceof q0)) {
                if (!(objP instanceof j0) || ((j0) objP).c() == null) {
                    return;
                }
                j();
                return;
            }
            if (objP != this) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = u0.f577a;
            d0 d0Var = u.f576h;
            while (!atomicReferenceFieldUpdater.compareAndSet(u0VarK, objP, d0Var)) {
                if (atomicReferenceFieldUpdater.get(u0VarK) != objP) {
                    break;
                }
            }
            return;
        }
    }

    public final u0 k() {
        u0 u0Var = this.d;
        if (u0Var != null) {
            return u0Var;
        }
        kotlin.jvm.internal.j.i("job");
        throw null;
    }

    public abstract void l(Throwable th);

    @Override // kotlinx.coroutines.internal.g
    public final String toString() {
        return getClass().getSimpleName() + '@' + u.c(this) + "[job@" + u.c(k()) + ']';
    }
}
