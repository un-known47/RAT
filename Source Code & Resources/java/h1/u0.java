package h1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class u0 implements n0, y0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f577a = AtomicReferenceFieldUpdater.newUpdater(u0.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    public u0(boolean z2) {
        this._state = z2 ? u.f576h : u.f575g;
        this._parentHandle = null;
    }

    public static i v(kotlinx.coroutines.internal.g gVar) {
        while (gVar.i()) {
            gVar = gVar.h();
        }
        while (true) {
            gVar = gVar.g();
            if (!gVar.i()) {
                if (gVar instanceof i) {
                    return (i) gVar;
                }
                if (gVar instanceof v0) {
                    return null;
                }
            }
        }
    }

    public static String z(Object obj) {
        if (!(obj instanceof s0)) {
            return obj instanceof j0 ? ((j0) obj).a() ? "Active" : "New" : obj instanceof k ? "Cancelled" : "Completed";
        }
        s0 s0Var = (s0) obj;
        return s0Var.e() ? "Cancelling" : s0Var.f() ? "Completing" : "Active";
    }

    public final Object A(Object obj, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!(obj instanceof j0)) {
            return u.f572b;
        }
        if (((obj instanceof d0) || (obj instanceof q0)) && !(obj instanceof i) && !(obj2 instanceof k)) {
            j0 j0Var = (j0) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f577a;
            Object k0Var = obj2 instanceof j0 ? new k0((j0) obj2) : obj2;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, j0Var, k0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != j0Var) {
                    return u.d;
                }
            }
            i(j0Var, obj2);
            return obj2;
        }
        j0 j0Var2 = (j0) obj;
        v0 v0VarN = n(j0Var2);
        if (v0VarN == null) {
            return u.d;
        }
        i iVarV = null;
        s0 s0Var = j0Var2 instanceof s0 ? (s0) j0Var2 : null;
        if (s0Var == null) {
            s0Var = new s0(v0VarN, null);
        }
        synchronized (s0Var) {
            if (s0Var.f()) {
                return u.f572b;
            }
            s0Var.i();
            if (s0Var != j0Var2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f577a;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, j0Var2, s0Var)) {
                    if (atomicReferenceFieldUpdater2.get(this) != j0Var2) {
                        return u.d;
                    }
                }
            }
            boolean zE = s0Var.e();
            k kVar = obj2 instanceof k ? (k) obj2 : null;
            if (kVar != null) {
                s0Var.b(kVar.f550a);
            }
            Throwable thD = s0Var.d();
            if (zE) {
                thD = null;
            }
            if (thD != null) {
                w(v0VarN, thD);
            }
            i iVar = j0Var2 instanceof i ? (i) j0Var2 : null;
            if (iVar == null) {
                v0 v0VarC = j0Var2.c();
                if (v0VarC != null) {
                    iVarV = v(v0VarC);
                }
            } else {
                iVarV = iVar;
            }
            if (iVarV != null) {
                while (u.e(iVarV.f544e, new r0(this, s0Var, iVarV, obj2), 1) == w0.f581a) {
                    iVarV = v(iVarV);
                    if (iVarV == null) {
                    }
                }
                return u.c;
            }
            return k(s0Var, obj2);
        }
    }

    @Override // h1.n0
    public boolean a() {
        Object objP = p();
        return (objP instanceof j0) && ((j0) objP).a();
    }

    public final boolean b(j0 j0Var, v0 v0Var, q0 q0Var) {
        kotlinx.coroutines.internal.g gVarH;
        t0 t0Var = new t0(q0Var, this, j0Var);
        loop0: while (true) {
            gVarH = v0Var.h();
            kotlinx.coroutines.internal.g.f805b.lazySet(q0Var, gVarH);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = kotlinx.coroutines.internal.g.f804a;
            atomicReferenceFieldUpdater.lazySet(q0Var, v0Var);
            t0Var.c = v0Var;
            while (!atomicReferenceFieldUpdater.compareAndSet(gVarH, v0Var, t0Var)) {
                if (atomicReferenceFieldUpdater.get(gVarH) != v0Var) {
                    break;
                }
            }
        }
        return t0Var.a(gVarH) == null;
    }

    public void d(Object obj) {
        c(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        r0 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[PHI: r0
  0x0038: PHI (r0v1 java.lang.Object) = (r0v0 java.lang.Object), (r0v12 java.lang.Object) binds: [B:3:0x0006, B:16:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.u0.e(java.lang.Object):boolean");
    }

    public final boolean f(Throwable th) {
        if (t()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        h hVar = (h) this._parentHandle;
        return (hVar == null || hVar == w0.f581a) ? z2 : hVar.b(th) || z2;
    }

    @Override // p0.i
    public final Object fold(Object obj, y0.p pVar) {
        return pVar.invoke(obj, this);
    }

    public String g() {
        return "Job was cancelled";
    }

    @Override // p0.i
    public final p0.g get(p0.h key) {
        kotlin.jvm.internal.j.e(key, "key");
        if (kotlin.jvm.internal.j.a(q.f562b, key)) {
            return this;
        }
        return null;
    }

    @Override // p0.g
    public final p0.h getKey() {
        return q.f562b;
    }

    public boolean h(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return e(th) && m();
    }

    public final void i(j0 j0Var, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        h hVar = (h) this._parentHandle;
        if (hVar != null) {
            hVar.dispose();
            this._parentHandle = w0.f581a;
        }
        a0.s sVar = null;
        k kVar = obj instanceof k ? (k) obj : null;
        Throwable th = kVar != null ? kVar.f550a : null;
        if (j0Var instanceof q0) {
            try {
                ((q0) j0Var).l(th);
                return;
            } catch (Throwable th2) {
                r(new a0.s("Exception in completion handler " + j0Var + " for " + this, th2));
                return;
            }
        }
        v0 v0VarC = j0Var.c();
        if (v0VarC != null) {
            for (kotlinx.coroutines.internal.g gVarG = (kotlinx.coroutines.internal.g) v0VarC.f(); !kotlin.jvm.internal.j.a(gVarG, v0VarC); gVarG = gVarG.g()) {
                if (gVarG instanceof q0) {
                    q0 q0Var = (q0) gVarG;
                    try {
                        q0Var.l(th);
                    } catch (Throwable th3) {
                        if (sVar != null) {
                            p.a.b(sVar, th3);
                        } else {
                            sVar = new a0.s("Exception in completion handler " + q0Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (sVar != null) {
                r(sVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public final Throwable j(Object obj) {
        CancellationException cancellationExceptionD;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        u0 u0Var = (u0) ((y0) obj);
        Object objP = u0Var.p();
        if (objP instanceof s0) {
            cancellationExceptionD = ((s0) objP).d();
        } else if (objP instanceof k) {
            cancellationExceptionD = ((k) objP).f550a;
        } else {
            if (objP instanceof j0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objP).toString());
            }
            cancellationExceptionD = null;
        }
        CancellationException cancellationException = cancellationExceptionD instanceof CancellationException ? cancellationExceptionD : null;
        return cancellationException == null ? new o0("Parent job is ".concat(z(objP)), cancellationExceptionD, u0Var) : cancellationException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object k(s0 s0Var, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Throwable o0Var = null;
        k kVar = obj instanceof k ? (k) obj : null;
        Throwable th = kVar != null ? kVar.f550a : null;
        synchronized (s0Var) {
            s0Var.e();
            ArrayList arrayListH = s0Var.h(th);
            if (!arrayListH.isEmpty()) {
                int size = arrayListH.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    Object obj2 = arrayListH.get(i2);
                    i2++;
                    if (!(((Throwable) obj2) instanceof CancellationException)) {
                        o0Var = obj2;
                        break;
                    }
                }
                o0Var = o0Var;
                if (o0Var == null) {
                    o0Var = (Throwable) arrayListH.get(0);
                }
            } else if (s0Var.e()) {
                o0Var = new o0(g(), null, this);
            }
            if (o0Var != null && arrayListH.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(arrayListH.size()));
                int size2 = arrayListH.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj3 = arrayListH.get(i3);
                    i3++;
                    Throwable th2 = (Throwable) obj3;
                    if (th2 != o0Var && th2 != o0Var && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        p.a.b(o0Var, th2);
                    }
                }
            }
        }
        if (o0Var != null && o0Var != th) {
            obj = new k(false, o0Var);
        }
        if (o0Var != null && (f(o0Var) || q(o0Var))) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            }
            k.f549b.compareAndSet((k) obj, 0, 1);
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f577a;
        Object k0Var = obj instanceof j0 ? new k0((j0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, s0Var, k0Var) && atomicReferenceFieldUpdater.get(this) == s0Var) {
        }
        i(s0Var, obj);
        return obj;
    }

    public final CancellationException l() {
        CancellationException cancellationException;
        Object objP = p();
        if (!(objP instanceof s0)) {
            if (objP instanceof j0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(objP instanceof k)) {
                return new o0(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((k) objP).f550a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new o0(g(), th, this) : cancellationException;
        }
        Throwable thD = ((s0) objP).d();
        if (thD == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String strConcat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = thD instanceof CancellationException ? (CancellationException) thD : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (strConcat == null) {
            strConcat = g();
        }
        return new o0(strConcat, thD, this);
    }

    public boolean m() {
        return true;
    }

    @Override // p0.i
    public final p0.i minusKey(p0.h hVar) {
        return p.a.H(this, hVar);
    }

    public final v0 n(j0 j0Var) {
        v0 v0VarC = j0Var.c();
        if (v0VarC != null) {
            return v0VarC;
        }
        if (j0Var instanceof d0) {
            return new v0();
        }
        if (j0Var instanceof q0) {
            y((q0) j0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + j0Var).toString());
    }

    public final h o() {
        return (h) this._parentHandle;
    }

    public final Object p() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.l)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.l) obj).a(this);
        }
    }

    @Override // p0.i
    public final p0.i plus(p0.i context) {
        kotlin.jvm.internal.j.e(context, "context");
        return p.a.J(this, context);
    }

    public boolean q(Throwable th) {
        return false;
    }

    public final void s(n0 n0Var) {
        w0 w0Var = w0.f581a;
        if (n0Var == null) {
            this._parentHandle = w0Var;
            return;
        }
        u0 u0Var = (u0) n0Var;
        loop0: while (true) {
            Object objP = u0Var.p();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f577a;
            if (!(objP instanceof d0)) {
                if (!(objP instanceof i0)) {
                    break;
                }
                v0 v0Var = ((i0) objP).f545a;
                while (!atomicReferenceFieldUpdater.compareAndSet(u0Var, objP, v0Var)) {
                    if (atomicReferenceFieldUpdater.get(u0Var) != objP) {
                        break;
                    }
                }
                u0Var.getClass();
                break loop0;
            }
            if (!((d0) objP).f534a) {
                d0 d0Var = u.f576h;
                while (!atomicReferenceFieldUpdater.compareAndSet(u0Var, objP, d0Var)) {
                    if (atomicReferenceFieldUpdater.get(u0Var) != objP) {
                        break;
                    }
                }
                u0Var.getClass();
                break loop0;
            }
            break;
        }
        h hVar = (h) u.e(u0Var, new i(this), 2);
        this._parentHandle = hVar;
        if (p() instanceof j0) {
            return;
        }
        hVar.dispose();
        this._parentHandle = w0Var;
    }

    public boolean t() {
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + z(p()) + '}');
        sb.append('@');
        sb.append(u.c(this));
        return sb.toString();
    }

    public final Object u(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objA;
        do {
            objA = A(p(), obj);
            if (objA == u.f572b) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                k kVar = obj instanceof k ? (k) obj : null;
                throw new IllegalStateException(str, kVar != null ? kVar.f550a : null);
            }
        } while (objA == u.d);
        return objA;
    }

    public final void w(v0 v0Var, Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a0.s sVar = null;
        for (kotlinx.coroutines.internal.g gVarG = (kotlinx.coroutines.internal.g) v0Var.f(); !kotlin.jvm.internal.j.a(gVarG, v0Var); gVarG = gVarG.g()) {
            if (gVarG instanceof p0) {
                q0 q0Var = (q0) gVarG;
                try {
                    q0Var.l(th);
                } catch (Throwable th2) {
                    if (sVar != null) {
                        p.a.b(sVar, th2);
                    } else {
                        sVar = new a0.s("Exception in completion handler " + q0Var + " for " + this, th2);
                    }
                }
            }
        }
        if (sVar != null) {
            r(sVar);
        }
        f(th);
    }

    public final void y(q0 q0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        v0 v0Var = new v0();
        q0Var.getClass();
        kotlinx.coroutines.internal.g.f805b.lazySet(v0Var, q0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = kotlinx.coroutines.internal.g.f804a;
        atomicReferenceFieldUpdater2.lazySet(v0Var, q0Var);
        loop0: while (true) {
            if (q0Var.f() == q0Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(q0Var, q0Var, v0Var)) {
                    if (atomicReferenceFieldUpdater2.get(q0Var) != q0Var) {
                        break;
                    }
                }
                v0Var.e(q0Var);
                break loop0;
            }
            break;
        }
        kotlinx.coroutines.internal.g gVarG = q0Var.g();
        do {
            atomicReferenceFieldUpdater = f577a;
            if (atomicReferenceFieldUpdater.compareAndSet(this, q0Var, gVarG)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == q0Var);
    }

    public void x() {
    }

    public void c(Object obj) {
    }

    public void r(a0.s sVar) {
        throw sVar;
    }
}
