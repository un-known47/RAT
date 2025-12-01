package kotlinx.coroutines.scheduling;

import a0.u;
import i.o;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.n;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    public final int f829a;

    /* renamed from: b, reason: collision with root package name */
    public final int f830b;
    public final long c;
    volatile /* synthetic */ long controlState;
    public final e d;

    /* renamed from: e, reason: collision with root package name */
    public final e f831e;

    /* renamed from: f, reason: collision with root package name */
    public final n f832f;
    private volatile /* synthetic */ long parkedWorkersStack;
    public static final o j = new o(2, "NOT_IN_STACK");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f826g = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f827h = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f828i = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    public b(int i2, long j2, int i3) {
        this.f829a = i2;
        this.f830b = i3;
        this.c = j2;
        if (i2 < 1) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.e("Core pool size ", i2, " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.e("Max pool size ", i3, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.d = new e();
        this.f831e = new e();
        this.parkedWorkersStack = 0L;
        this.f832f = new n(i2 + 1);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void E(b bVar, Runnable runnable, int i2) {
        bVar.D(runnable, k.f844f, (i2 & 4) == 0);
    }

    public final void D(Runnable runnable, i iVar, boolean z2) {
        h jVar;
        int i2;
        k.f843e.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            jVar = (h) runnable;
            jVar.f838a = jNanoTime;
            jVar.f839b = iVar;
        } else {
            jVar = new j(runnable, jNanoTime, iVar);
        }
        Thread threadCurrentThread = Thread.currentThread();
        h hVarA = null;
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !kotlin.jvm.internal.j.a(aVar.f825g, this)) {
            aVar = null;
        }
        if (aVar == null || (i2 = aVar.f822b) == 5 || (jVar.f839b.f840a == 0 && i2 == 2)) {
            hVarA = jVar;
        } else {
            aVar.f824f = true;
            m mVar = aVar.f821a;
            if (z2) {
                hVarA = mVar.a(jVar);
            } else {
                mVar.getClass();
                h hVar = (h) m.f847b.getAndSet(mVar, jVar);
                if (hVar != null) {
                    hVarA = mVar.a(hVar);
                }
            }
        }
        if (hVarA != null) {
            if (!(hVarA.f839b.f840a == 1 ? this.f831e.a(hVarA) : this.d.a(hVarA))) {
                throw new RejectedExecutionException("DefaultDispatcher was terminated");
            }
        }
        boolean z3 = z2 && aVar != null;
        if (jVar.f839b.f840a == 0) {
            if (z3 || I() || H(this.controlState)) {
                return;
            }
            I();
            return;
        }
        long jAddAndGet = f827h.addAndGet(this, 2097152L);
        if (z3 || I() || H(jAddAndGet)) {
            return;
        }
        I();
    }

    public final void F(a aVar) {
        long j2;
        long j3;
        int iB;
        if (aVar.c() != j) {
            return;
        }
        do {
            j2 = this.parkedWorkersStack;
            j3 = (2097152 + j2) & (-2097152);
            iB = aVar.b();
            aVar.g(this.f832f.b((int) (2097151 & j2)));
        } while (!f826g.compareAndSet(this, j2, j3 | iB));
    }

    public final void G(a aVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iB = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (iB == i2) {
                if (i3 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == j) {
                            iB = -1;
                            break;
                        }
                        if (objC == null) {
                            iB = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        iB = aVar2.b();
                        if (iB != 0) {
                            break;
                        } else {
                            objC = aVar2.c();
                        }
                    }
                } else {
                    iB = i3;
                }
            }
            if (iB >= 0 && f826g.compareAndSet(this, j2, j3 | iB)) {
                return;
            }
        }
    }

    public final boolean H(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.f829a;
        if (i2 < i3) {
            int iA = a();
            if (iA == 1 && i3 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean I() {
        o oVar;
        int iB;
        while (true) {
            long j2 = this.parkedWorkersStack;
            a aVar = (a) this.f832f.b((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    oVar = j;
                    if (objC == oVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                }
                if (iB >= 0 && f826g.compareAndSet(this, j2, iB | j3)) {
                    aVar.g(oVar);
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f820h.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final int a() {
        synchronized (this.f832f) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
            if (i3 < 0) {
                i3 = 0;
            }
            if (i3 >= this.f829a) {
                return 0;
            }
            if (i2 >= this.f830b) {
                return 0;
            }
            int i4 = ((int) (this.controlState & 2097151)) + 1;
            if (i4 <= 0 || this.f832f.b(i4) != null) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            a aVar = new a(this, i4);
            this.f832f.c(i4, aVar);
            if (i4 != ((int) (2097151 & f827h.incrementAndGet(this)))) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            aVar.start();
            return i3 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.b.f828i
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof kotlinx.coroutines.scheduling.a
            r3 = 0
            if (r1 == 0) goto L17
            kotlinx.coroutines.scheduling.a r0 = (kotlinx.coroutines.scheduling.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            kotlinx.coroutines.scheduling.b r1 = r0.f825g
            boolean r1 = kotlin.jvm.internal.j.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            kotlinx.coroutines.internal.n r1 = r8.f832f
            monitor-enter(r1)
            long r4 = r8.controlState     // Catch: java.lang.Throwable -> Lb6
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r1)
            if (r2 > r5) goto L72
            r1 = 1
        L32:
            kotlinx.coroutines.internal.n r4 = r8.f832f
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.j.b(r4)
            kotlinx.coroutines.scheduling.a r4 = (kotlinx.coroutines.scheduling.a) r4
            if (r4 == r0) goto L6d
        L3f:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L4e
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r6 = 10000(0x2710, double:4.9407E-320)
            r4.join(r6)
            goto L3f
        L4e:
            kotlinx.coroutines.scheduling.m r4 = r4.f821a
            kotlinx.coroutines.scheduling.e r6 = r8.f831e
            r4.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = kotlinx.coroutines.scheduling.m.f847b
            java.lang.Object r7 = r7.getAndSet(r4, r3)
            kotlinx.coroutines.scheduling.h r7 = (kotlinx.coroutines.scheduling.h) r7
            if (r7 == 0) goto L62
            r6.a(r7)
        L62:
            kotlinx.coroutines.scheduling.h r7 = r4.c()
            if (r7 != 0) goto L69
            goto L6d
        L69:
            r6.a(r7)
            goto L62
        L6d:
            if (r1 == r5) goto L72
            int r1 = r1 + 1
            goto L32
        L72:
            kotlinx.coroutines.scheduling.e r1 = r8.f831e
            r1.b()
            kotlinx.coroutines.scheduling.e r1 = r8.d
            r1.b()
        L7c:
            if (r0 == 0) goto L84
            kotlinx.coroutines.scheduling.h r1 = r0.a(r2)
            if (r1 != 0) goto La5
        L84:
            kotlinx.coroutines.scheduling.e r1 = r8.d
            java.lang.Object r1 = r1.d()
            kotlinx.coroutines.scheduling.h r1 = (kotlinx.coroutines.scheduling.h) r1
            if (r1 != 0) goto La5
            kotlinx.coroutines.scheduling.e r1 = r8.f831e
            java.lang.Object r1 = r1.d()
            kotlinx.coroutines.scheduling.h r1 = (kotlinx.coroutines.scheduling.h) r1
            if (r1 != 0) goto La5
            if (r0 == 0) goto L9e
            r1 = 5
            r0.h(r1)
        L9e:
            r0 = 0
            r8.parkedWorkersStack = r0
            r8.controlState = r0
            return
        La5:
            r1.run()     // Catch: java.lang.Throwable -> La9
            goto L7c
        La9:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L7c
        Lb6:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.b.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        E(this, runnable, 6);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f832f.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            a aVar = (a) this.f832f.b(i7);
            if (aVar != null) {
                int iB = aVar.f821a.b();
                int iA2 = u.a(aVar.f822b);
                if (iA2 == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iB);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iA2 == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iB);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iA2 == 2) {
                    i4++;
                } else if (iA2 == 3) {
                    i5++;
                    if (iB > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iB);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iA2 == 4) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return "DefaultDispatcher@" + h1.u.c(this) + "[Pool Size {core = " + this.f829a + ", max = " + this.f830b + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.d.c() + ", global blocking queue size = " + this.f831e.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f829a - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
