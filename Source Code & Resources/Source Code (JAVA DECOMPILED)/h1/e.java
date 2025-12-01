package h1;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e extends a0 implements d, r0.d {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f536g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_decision");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f537h = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;
    public final p0.d d;

    /* renamed from: e, reason: collision with root package name */
    public final p0.i f538e;

    /* renamed from: f, reason: collision with root package name */
    public c0 f539f;

    public e(p0.d dVar) {
        super(1);
        this.d = dVar;
        this.f538e = dVar.getContext();
        this._decision = 0;
        this._state = b.f529a;
    }

    public static void p(Object obj, y0.l lVar) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    @Override // h1.a0
    public final void a(Object obj, CancellationException cancellationException) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof x0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof k) {
                return;
            }
            if (!(obj2 instanceof j)) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f537h;
                j jVar = new j(obj2, null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, jVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            j jVar2 = (j) obj2;
            if (jVar2.f548e != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            j jVarA = j.a(jVar2, null, cancellationException, 15);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f537h;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj2, jVarA)) {
                if (atomicReferenceFieldUpdater2.get(this) != obj2) {
                    break;
                }
            }
            l0 l0Var = jVar2.f547b;
            if (l0Var != null) {
                g(l0Var, cancellationException);
            }
            y0.l lVar = jVar2.c;
            if (lVar != null) {
                try {
                    lVar.invoke(cancellationException);
                    return;
                } catch (Throwable th) {
                    u.d(this.f538e, new a0.s("Exception in resume onCancellation handler for " + this, th));
                    return;
                }
            }
            return;
        }
    }

    @Override // h1.a0
    public final p0.d b() {
        return this.d;
    }

    @Override // h1.a0
    public final Throwable c(Object obj) {
        Throwable thC = super.c(obj);
        if (thC != null) {
            return thC;
        }
        return null;
    }

    @Override // h1.a0
    public final Object d(Object obj) {
        return obj instanceof j ? ((j) obj).f546a : obj;
    }

    @Override // h1.a0
    public final Object f() {
        return this._state;
    }

    public final void g(l0 l0Var, Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            l0Var.f552a.invoke(th);
        } catch (Throwable th2) {
            u.d(this.f538e, new a0.s("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // r0.d
    public final r0.d getCallerFrame() {
        p0.d dVar = this.d;
        if (dVar instanceof r0.d) {
            return (r0.d) dVar;
        }
        return null;
    }

    @Override // p0.d
    public final p0.i getContext() {
        return this.f538e;
    }

    public final void h(y0.l lVar, Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            u.d(this.f538e, new a0.s("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void i(Throwable th) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c0 c0Var;
        while (true) {
            Object obj = this._state;
            if (obj instanceof x0) {
                boolean z2 = obj instanceof l0;
                f fVar = new f(this, th, z2);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f537h;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, fVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                l0 l0Var = z2 ? (l0) obj : null;
                if (l0Var != null) {
                    g(l0Var, th);
                }
                if (!o() && (c0Var = this.f539f) != null) {
                    c0Var.dispose();
                    this.f539f = w0.f581a;
                }
                j(this.c);
                return;
            }
            return;
        }
    }

    public final void j(int i2) {
        do {
            int i3 = this._decision;
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                p0.d dVar = this.d;
                boolean z2 = i2 == 4;
                if (!z2 && (dVar instanceof kotlinx.coroutines.internal.d)) {
                    boolean z3 = i2 == 1 || i2 == 2;
                    int i4 = this.c;
                    if (z3 == (i4 == 1 || i4 == 2)) {
                        kotlinx.coroutines.internal.d dVar2 = (kotlinx.coroutines.internal.d) dVar;
                        p pVar = dVar2.d;
                        p0.i context = dVar2.f798e.getContext();
                        if (pVar.isDispatchNeeded(context)) {
                            pVar.dispatch(context, this);
                            return;
                        }
                        g0 g0VarA = c1.a();
                        if (g0VarA.f542a >= 4294967296L) {
                            g0VarA.E(this);
                            return;
                        }
                        g0VarA.G(true);
                        try {
                            u.h(this, this.d, true);
                            do {
                            } while (g0VarA.H());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                u.h(this, dVar, z2);
                return;
            }
        } while (!f536g.compareAndSet(this, 0, 2));
    }

    public final Object k() throws Throwable {
        n0 n0Var;
        kotlinx.coroutines.internal.d dVar;
        Throwable thJ;
        Throwable thJ2;
        w0 w0Var = w0.f581a;
        boolean zO = o();
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (zO) {
                    p0.d dVar2 = this.d;
                    dVar = dVar2 instanceof kotlinx.coroutines.internal.d ? (kotlinx.coroutines.internal.d) dVar2 : null;
                    if (dVar != null && (thJ = dVar.j(this)) != null) {
                        c0 c0Var = this.f539f;
                        if (c0Var != null) {
                            c0Var.dispose();
                            this.f539f = w0Var;
                        }
                        i(thJ);
                    }
                }
                Object obj = this._state;
                if (obj instanceof k) {
                    throw ((k) obj).f550a;
                }
                int i3 = this.c;
                if ((i3 != 1 && i3 != 2) || (n0Var = (n0) this.f538e.get(q.f562b)) == null || n0Var.a()) {
                    return d(obj);
                }
                CancellationException cancellationExceptionL = ((u0) n0Var).l();
                a(obj, cancellationExceptionL);
                throw cancellationExceptionL;
            }
        } while (!f536g.compareAndSet(this, 0, 1));
        if (this.f539f == null) {
            m();
        }
        if (zO) {
            p0.d dVar3 = this.d;
            dVar = dVar3 instanceof kotlinx.coroutines.internal.d ? (kotlinx.coroutines.internal.d) dVar3 : null;
            if (dVar != null && (thJ2 = dVar.j(this)) != null) {
                c0 c0Var2 = this.f539f;
                if (c0Var2 != null) {
                    c0Var2.dispose();
                    this.f539f = w0Var;
                }
                i(thJ2);
            }
        }
        return q0.a.f1043a;
    }

    public final void l() {
        c0 c0VarM = m();
        if (c0VarM == null || (this._state instanceof x0)) {
            return;
        }
        c0VarM.dispose();
        this.f539f = w0.f581a;
    }

    public final c0 m() {
        n0 n0Var = (n0) this.f538e.get(q.f562b);
        if (n0Var == null) {
            return null;
        }
        c0 c0VarE = u.e(n0Var, new g(this), 2);
        this.f539f = c0VarE;
        return c0VarE;
    }

    public final void n(y0.l lVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        l0 l0Var = lVar instanceof l0 ? (l0) lVar : new l0(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof b) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f537h;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, l0Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (obj instanceof l0) {
                p(obj, lVar);
                throw null;
            }
            if (obj instanceof k) {
                k kVar = (k) obj;
                if (!k.f549b.compareAndSet(kVar, 0, 1)) {
                    p(obj, lVar);
                    throw null;
                }
                if (obj instanceof f) {
                    h(lVar, kVar.f550a);
                    return;
                }
                return;
            }
            if (!(obj instanceof j)) {
                j jVar = new j(obj, l0Var, null, 28);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f537h;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, jVar)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            j jVar2 = (j) obj;
            if (jVar2.f547b != null) {
                p(obj, lVar);
                throw null;
            }
            Throwable th = jVar2.f548e;
            if (th != null) {
                h(lVar, th);
                return;
            }
            j jVarA = j.a(jVar2, l0Var, null, 29);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = f537h;
            while (!atomicReferenceFieldUpdater3.compareAndSet(this, obj, jVarA)) {
                if (atomicReferenceFieldUpdater3.get(this) != obj) {
                    break;
                }
            }
            return;
        }
    }

    public final boolean o() {
        return this.c == 2 && ((kotlinx.coroutines.internal.d) this.d).g();
    }

    @Override // p0.d
    public final void resumeWith(Object obj) {
        c0 c0Var;
        Throwable thA = l0.f.a(obj);
        if (thA != null) {
            obj = new k(false, thA);
        }
        int i2 = this.c;
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof x0)) {
                if (obj2 instanceof f) {
                    if (f.c.compareAndSet((f) obj2, 0, 1)) {
                        return;
                    }
                }
                throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
            }
            x0 x0Var = (x0) obj2;
            Object jVar = (!(obj instanceof k) && (i2 == 1 || i2 == 2) && (x0Var instanceof l0)) ? new j(obj, (l0) x0Var, null, 16) : obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f537h;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, jVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!o() && (c0Var = this.f539f) != null) {
                c0Var.dispose();
                this.f539f = w0.f581a;
            }
            j(i2);
            return;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(u.i(this.d));
        sb.append("){");
        Object obj = this._state;
        sb.append(obj instanceof x0 ? "Active" : obj instanceof f ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(u.c(this));
        return sb.toString();
    }
}
