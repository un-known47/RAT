package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f811a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f812b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;

    /* renamed from: g, reason: collision with root package name */
    public static final i.o f810g = new i.o(2, "REMOVE_FROZEN");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f808e = AtomicReferenceFieldUpdater.newUpdater(j.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f809f = AtomicLongFieldUpdater.newUpdater(j.class, "_state");

    public j(int i2, boolean z2) {
        this.f811a = i2;
        this.f812b = z2;
        int i3 = i2 - 1;
        this.c = i3;
        this.d = new AtomicReferenceArray(i2);
        if (i3 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i2 & i3) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Object obj) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i2 = (int) (1073741823 & j);
            int i3 = (int) ((1152921503533105152L & j) >> 30);
            int i4 = this.c;
            if (((i3 + 2) & i4) == (i2 & i4)) {
                return 1;
            }
            if (this.f812b || this.d.get(i3 & i4) == null) {
                if (f809f.compareAndSet(this, j, (((i3 + 1) & 1073741823) << 30) | ((-1152921503533105153L) & j))) {
                    this.d.set(i3 & i4, obj);
                    j jVarE = this;
                    while ((jVarE._state & 1152921504606846976L) != 0) {
                        jVarE = jVarE.e();
                        AtomicReferenceArray atomicReferenceArray = jVarE.d;
                        int i5 = jVarE.c & i3;
                        Object obj2 = atomicReferenceArray.get(i5);
                        if ((obj2 instanceof i) && ((i) obj2).f807a == i3) {
                            atomicReferenceArray.set(i5, obj);
                        } else {
                            jVarE = null;
                        }
                        if (jVarE == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i6 = this.f811a;
                if (i6 < 1024 || ((i3 - i2) & 1073741823) > (i6 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f809f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int c() {
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j)));
    }

    public final boolean d() {
        long j = this._state;
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final j e() {
        long j;
        j jVar;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                jVar = this;
                break;
            }
            long j2 = j | 1152921504606846976L;
            jVar = this;
            if (f809f.compareAndSet(jVar, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            j jVar2 = (j) jVar._next;
            if (jVar2 != null) {
                return jVar2;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f808e;
            j jVar3 = new j(jVar.f811a * 2, jVar.f812b);
            int i2 = (int) (1073741823 & j);
            int i3 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i4 = jVar.c;
                int i5 = i2 & i4;
                if (i5 == (i4 & i3)) {
                    break;
                }
                Object iVar = jVar.d.get(i5);
                if (iVar == null) {
                    iVar = new i(i2);
                }
                jVar3.d.set(jVar3.c & i2, iVar);
                i2++;
            }
            jVar3._state = (-1152921504606846977L) & j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, jVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f() {
        /*
            r27 = this;
            r1 = r27
        L2:
            long r2 = r1._state
            r6 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r6
            r8 = 0
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 == 0) goto L11
            i.o r0 = kotlinx.coroutines.internal.j.f810g
            return r0
        L11:
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r10
            int r12 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r0 = (int) r4
            int r4 = r1.c
            r0 = r0 & r4
            r4 = r4 & r12
            r13 = 0
            if (r0 != r4) goto L29
            goto L3a
        L29:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.d
            java.lang.Object r14 = r0.get(r4)
            if (r14 != 0) goto L36
            boolean r0 = r1.f812b
            if (r0 == 0) goto L2
            goto L3a
        L36:
            boolean r0 = r14 instanceof kotlinx.coroutines.internal.i
            if (r0 == 0) goto L3b
        L3a:
            return r13
        L3b:
            int r0 = r12 + 1
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.j.f809f
            r15 = -1073741824(0xffffffffc0000000, double:NaN)
            long r17 = r2 & r15
            r19 = r6
            long r6 = (long) r0
            long r17 = r17 | r6
            r0 = r4
            r4 = r17
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L5f
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.d
            int r2 = r1.c
            r2 = r2 & r12
            r0.set(r2, r13)
            return r14
        L5f:
            boolean r0 = r1.f812b
            if (r0 == 0) goto L2
            r0 = r1
        L64:
            long r2 = r0._state
            long r4 = r2 & r10
            int r5 = (int) r4
            long r17 = r2 & r19
            int r4 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r4 == 0) goto L74
            kotlinx.coroutines.internal.j r0 = r0.e()
            goto L8f
        L74:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r21 = kotlinx.coroutines.internal.j.f809f
            long r17 = r2 & r15
            long r25 = r17 | r6
            r22 = r0
            r23 = r2
            boolean r0 = r21.compareAndSet(r22, r23, r25)
            r2 = r22
            if (r0 == 0) goto L92
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r2.d
            int r2 = r2.c
            r2 = r2 & r5
            r0.set(r2, r13)
            r0 = r13
        L8f:
            if (r0 != 0) goto L64
            return r14
        L92:
            r0 = r2
            goto L64
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.j.f():java.lang.Object");
    }
}
