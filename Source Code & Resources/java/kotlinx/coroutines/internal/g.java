package kotlinx.coroutines.internal;

import h1.u;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f804a = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f805b = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_prev");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        r5 = kotlinx.coroutines.internal.g.f804a;
        r4 = ((kotlinx.coroutines.internal.m) r4).f814a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0042, code lost:
    
        if (r5.compareAndSet(r3, r2, r4) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004a, code lost:
    
        if (r5.get(r3) == r2) goto L52;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.coroutines.internal.g d() {
        /*
            r8 = this;
        L0:
            java.lang.Object r0 = r8._prev
            kotlinx.coroutines.internal.g r0 = (kotlinx.coroutines.internal.g) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r8) goto L1e
            if (r0 != r2) goto Le
            goto L27
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.g.f805b
        L10:
            boolean r1 = r5.compareAndSet(r8, r0, r2)
            if (r1 == 0) goto L17
            goto L27
        L17:
            java.lang.Object r1 = r5.get(r8)
            if (r1 == r0) goto L10
            goto L0
        L1e:
            boolean r5 = r8.i()
            if (r5 == 0) goto L25
            return r1
        L25:
            if (r4 != 0) goto L28
        L27:
            return r2
        L28:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.l
            if (r5 == 0) goto L32
            kotlinx.coroutines.internal.l r4 = (kotlinx.coroutines.internal.l) r4
            r4.a(r2)
            goto L0
        L32:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.m
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.g.f804a
            kotlinx.coroutines.internal.m r4 = (kotlinx.coroutines.internal.m) r4
            kotlinx.coroutines.internal.g r4 = r4.f814a
        L3e:
            boolean r6 = r5.compareAndSet(r3, r2, r4)
            if (r6 == 0) goto L46
            r2 = r3
            goto L6
        L46:
            java.lang.Object r6 = r5.get(r3)
            if (r6 == r2) goto L3e
            goto L0
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.g r2 = (kotlinx.coroutines.internal.g) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.g r3 = (kotlinx.coroutines.internal.g) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.g.d():kotlinx.coroutines.internal.g");
    }

    public final void e(g gVar) {
        while (true) {
            g gVar2 = (g) gVar._prev;
            if (f() != gVar) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f805b;
            while (!atomicReferenceFieldUpdater.compareAndSet(gVar, gVar2, this)) {
                if (atomicReferenceFieldUpdater.get(gVar) != gVar2) {
                    break;
                }
            }
            if (i()) {
                gVar.d();
                return;
            }
            return;
        }
    }

    public final Object f() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof l)) {
                return obj;
            }
            ((l) obj).a(this);
        }
    }

    public final g g() {
        g gVar;
        Object objF = f();
        m mVar = objF instanceof m ? (m) objF : null;
        return (mVar == null || (gVar = mVar.f814a) == null) ? (g) objF : gVar;
    }

    public final g h() {
        g gVarD = d();
        if (gVarD != null) {
            return gVarD;
        }
        Object obj = this._prev;
        while (true) {
            g gVar = (g) obj;
            if (!gVar.i()) {
                return gVar;
            }
            obj = gVar._prev;
        }
    }

    public boolean i() {
        return f() instanceof m;
    }

    public final void j() {
        while (true) {
            Object objF = f();
            if (objF instanceof m) {
                return;
            }
            if (objF == this) {
                return;
            }
            g gVar = (g) objF;
            m mVar = (m) gVar._removedRef;
            if (mVar == null) {
                mVar = new m(gVar);
                c.lazySet(gVar, mVar);
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f804a;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, objF, mVar)) {
                if (atomicReferenceFieldUpdater.get(this) != objF) {
                    break;
                }
            }
            gVar.d();
            return;
        }
    }

    public String toString() {
        return new f(this) + '@' + u.c(this);
    }
}
