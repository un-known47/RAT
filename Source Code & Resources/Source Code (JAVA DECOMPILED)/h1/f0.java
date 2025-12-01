package h1;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class f0 extends g0 implements x {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(f0.class, Object.class, "_queue");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    static {
        AtomicReferenceFieldUpdater.newUpdater(f0.class, Object.class, "_delayed");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
    
        h1.v.f578e.I(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void I(java.lang.Runnable r5) {
        /*
            r4 = this;
        L0:
            java.lang.Object r0 = r4._queue
            int r1 = r4._isCompleted
            if (r1 == 0) goto L7
            goto L46
        L7:
            if (r0 != 0) goto L1a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = h1.f0.d
        Lb:
            r0 = 0
            boolean r0 = r1.compareAndSet(r4, r0, r5)
            if (r0 == 0) goto L13
            goto L64
        L13:
            java.lang.Object r0 = r1.get(r4)
            if (r0 == 0) goto Lb
            goto L0
        L1a:
            boolean r1 = r0 instanceof kotlinx.coroutines.internal.j
            r2 = 1
            if (r1 == 0) goto L42
            r1 = r0
            kotlinx.coroutines.internal.j r1 = (kotlinx.coroutines.internal.j) r1
            int r3 = r1.a(r5)
            if (r3 == 0) goto L64
            if (r3 == r2) goto L2e
            r0 = 2
            if (r3 == r0) goto L46
            goto L0
        L2e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = h1.f0.d
            kotlinx.coroutines.internal.j r1 = r1.e()
        L34:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L3b
            goto L0
        L3b:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L34
            goto L0
        L42:
            i.o r1 = h1.u.f571a
            if (r0 != r1) goto L4c
        L46:
            h1.v r0 = h1.v.f578e
            r0.I(r5)
            return
        L4c:
            kotlinx.coroutines.internal.j r1 = new kotlinx.coroutines.internal.j
            r3 = 8
            r1.<init>(r3, r2)
            r2 = r0
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r1.a(r2)
            r1.a(r5)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = h1.f0.d
        L5e:
            boolean r3 = r2.compareAndSet(r4, r0, r1)
            if (r3 == 0) goto L72
        L64:
            java.lang.Thread r5 = r4.F()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r5) goto L71
            java.util.concurrent.locks.LockSupport.unpark(r5)
        L71:
            return
        L72:
            java.lang.Object r3 = r2.get(r4)
            if (r3 == r0) goto L5e
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.f0.I(java.lang.Runnable):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (((kotlinx.coroutines.internal.j) r0).d() == false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long J() {
        /*
            r7 = this;
            kotlinx.coroutines.internal.a r0 = r7.c
            r1 = 0
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r0 != 0) goto Ld
        Lb:
            r5 = r3
            goto L15
        Ld:
            int r5 = r0.f792b
            int r0 = r0.c
            if (r5 != r0) goto L14
            goto Lb
        L14:
            r5 = r1
        L15:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 != 0) goto L1a
            goto L30
        L1a:
            java.lang.Object r0 = r7._queue
            if (r0 == 0) goto L31
            boolean r5 = r0 instanceof kotlinx.coroutines.internal.j
            if (r5 == 0) goto L2b
            kotlinx.coroutines.internal.j r0 = (kotlinx.coroutines.internal.j) r0
            boolean r0 = r0.d()
            if (r0 != 0) goto L31
            goto L30
        L2b:
            i.o r5 = h1.u.f571a
            if (r0 != r5) goto L30
            goto L35
        L30:
            return r1
        L31:
            java.lang.Object r0 = r7._delayed
            h1.e0 r0 = (h1.e0) r0
        L35:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.f0.J():long");
    }

    public final boolean K() {
        kotlinx.coroutines.internal.a aVar = this.c;
        if (aVar != null && aVar.f792b != aVar.c) {
            return false;
        }
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        return obj instanceof kotlinx.coroutines.internal.j ? ((kotlinx.coroutines.internal.j) obj).d() : obj == u.f571a;
    }

    public final long L() {
        Runnable runnable;
        if (H()) {
            return 0L;
        }
        loop0: while (true) {
            Object obj = this._queue;
            runnable = null;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof kotlinx.coroutines.internal.j)) {
                if (obj != u.f571a) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
                break;
            }
            kotlinx.coroutines.internal.j jVar = (kotlinx.coroutines.internal.j) obj;
            Object objF = jVar.f();
            if (objF != kotlinx.coroutines.internal.j.f810g) {
                runnable = (Runnable) objF;
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = d;
            kotlinx.coroutines.internal.j jVarE = jVar.e();
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, jVarE) && atomicReferenceFieldUpdater2.get(this) == obj) {
            }
        }
        if (runnable == null) {
            return J();
        }
        runnable.run();
        return 0L;
    }

    public final void M() {
        this._queue = null;
        this._delayed = null;
    }

    @Override // h1.p
    public final void dispatch(p0.i iVar, Runnable runnable) {
        I(runnable);
    }

    @Override // h1.g0
    public void shutdown() {
        c1.f533a.set(null);
        this._isCompleted = 1;
        i.o oVar = u.f571a;
        loop0: while (true) {
            Object obj = this._queue;
            if (obj != null) {
                if (!(obj instanceof kotlinx.coroutines.internal.j)) {
                    if (obj != oVar) {
                        kotlinx.coroutines.internal.j jVar = new kotlinx.coroutines.internal.j(8, true);
                        jVar.a((Runnable) obj);
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, jVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((kotlinx.coroutines.internal.j) obj).b();
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = d;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, null, oVar)) {
                if (atomicReferenceFieldUpdater2.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (L() <= 0) {
        }
        System.nanoTime();
    }
}
