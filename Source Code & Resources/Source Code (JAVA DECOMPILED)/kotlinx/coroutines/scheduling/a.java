package kotlinx.coroutines.scheduling;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f820h = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");

    /* renamed from: a, reason: collision with root package name */
    public final m f821a;

    /* renamed from: b, reason: collision with root package name */
    public int f822b;
    public long c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public int f823e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f824f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f825g;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    volatile /* synthetic */ int workerCtl;

    public a(b bVar, int i2) {
        this.f825g = bVar;
        setDaemon(true);
        this.f821a = new m();
        this.f822b = 4;
        this.workerCtl = 0;
        this.nextParkedWorker = b.j;
        a1.a aVar = a1.e.f23a;
        this.f823e = a1.e.f23a.a().nextInt();
        f(i2);
    }

    public final h a(boolean z2) {
        h hVarE;
        h hVarE2;
        long j;
        h hVarC;
        if (this.f822b != 1) {
            b bVar = this.f825g;
            do {
                j = bVar.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    if (z2) {
                        m mVar = this.f821a;
                        mVar.getClass();
                        hVarC = (h) m.f847b.getAndSet(mVar, null);
                        if (hVarC == null) {
                            hVarC = mVar.c();
                        }
                        if (hVarC == null) {
                            hVarC = (h) this.f825g.f831e.d();
                        }
                    } else {
                        hVarC = (h) this.f825g.f831e.d();
                    }
                    return hVarC == null ? i(true) : hVarC;
                }
            } while (!b.f827h.compareAndSet(bVar, j, j - 4398046511104L));
            this.f822b = 1;
        }
        if (z2) {
            boolean z3 = d(this.f825g.f829a * 2) == 0;
            if (z3 && (hVarE2 = e()) != null) {
                return hVarE2;
            }
            m mVar2 = this.f821a;
            mVar2.getClass();
            h hVarC2 = (h) m.f847b.getAndSet(mVar2, null);
            if (hVarC2 == null) {
                hVarC2 = mVar2.c();
            }
            if (hVarC2 != null) {
                return hVarC2;
            }
            if (!z3 && (hVarE = e()) != null) {
                return hVarE;
            }
        } else {
            h hVarE3 = e();
            if (hVarE3 != null) {
                return hVarE3;
            }
        }
        return i(false);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i2) {
        int i3 = this.f823e;
        int i4 = i3 ^ (i3 << 13);
        int i5 = i4 ^ (i4 >> 17);
        int i6 = i5 ^ (i5 << 5);
        this.f823e = i6;
        int i7 = i2 - 1;
        return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
    }

    public final h e() {
        int iD = d(2);
        b bVar = this.f825g;
        if (iD == 0) {
            h hVar = (h) bVar.d.d();
            return hVar != null ? hVar : (h) bVar.f831e.d();
        }
        h hVar2 = (h) bVar.f831e.d();
        return hVar2 != null ? hVar2 : (h) bVar.d.d();
    }

    public final void f(int i2) {
        StringBuilder sb = new StringBuilder("DefaultDispatcher-worker-");
        sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
        setName(sb.toString());
        this.indexInArray = i2;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i2) {
        int i3 = this.f822b;
        boolean z2 = i3 == 1;
        if (z2) {
            b.f827h.addAndGet(this.f825g, 4398046511104L);
        }
        if (i3 != i2) {
            this.f822b = i2;
        }
        return z2;
    }

    public final h i(boolean z2) {
        long jE;
        int i2 = (int) (this.f825g.controlState & 2097151);
        if (i2 < 2) {
            return null;
        }
        int iD = d(i2);
        b bVar = this.f825g;
        long jMin = LocationRequestCompat.PASSIVE_INTERVAL;
        for (int i3 = 0; i3 < i2; i3++) {
            iD++;
            if (iD > i2) {
                iD = 1;
            }
            a aVar = (a) bVar.f832f.b(iD);
            if (aVar != null && aVar != this) {
                if (z2) {
                    jE = this.f821a.d(aVar.f821a);
                } else {
                    m mVar = this.f821a;
                    m mVar2 = aVar.f821a;
                    mVar.getClass();
                    h hVarC = mVar2.c();
                    if (hVarC != null) {
                        h hVar = (h) m.f847b.getAndSet(mVar, hVarC);
                        if (hVar != null) {
                            mVar.a(hVar);
                        }
                        jE = -1;
                    } else {
                        jE = mVar.e(mVar2, false);
                    }
                }
                if (jE == -1) {
                    m mVar3 = this.f821a;
                    mVar3.getClass();
                    h hVar2 = (h) m.f847b.getAndSet(mVar3, null);
                    return hVar2 == null ? mVar3.c() : hVar2;
                }
                if (jE > 0) {
                    jMin = Math.min(jMin, jE);
                }
            }
        }
        if (jMin == LocationRequestCompat.PASSIVE_INTERVAL) {
            jMin = 0;
        }
        this.d = jMin;
        return null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        loop0: while (true) {
            boolean z2 = false;
            while (!this.f825g.isTerminated() && this.f822b != 5) {
                h hVarA = a(this.f824f);
                if (hVarA != null) {
                    this.d = 0L;
                    b bVar = this.f825g;
                    int i2 = hVarA.f839b.f840a;
                    this.c = 0L;
                    if (this.f822b == 3) {
                        this.f822b = 2;
                    }
                    if (i2 != 0 && h(2) && !bVar.I() && !bVar.H(bVar.controlState)) {
                        bVar.I();
                    }
                    try {
                        hVarA.run();
                    } catch (Throwable th) {
                        Thread threadCurrentThread = Thread.currentThread();
                        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                    }
                    if (i2 != 0) {
                        b.f827h.addAndGet(bVar, -2097152L);
                        if (this.f822b != 5) {
                            this.f822b = 4;
                        }
                    }
                } else {
                    this.f824f = false;
                    if (this.d != 0) {
                        if (z2) {
                            h(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.d);
                            this.d = 0L;
                        } else {
                            z2 = true;
                        }
                    } else if (this.nextParkedWorker != b.j) {
                        this.workerCtl = -1;
                        while (this.nextParkedWorker != b.j && this.workerCtl == -1 && !this.f825g.isTerminated() && this.f822b != 5) {
                            h(3);
                            Thread.interrupted();
                            if (this.c == 0) {
                                this.c = System.nanoTime() + this.f825g.c;
                            }
                            LockSupport.parkNanos(this.f825g.c);
                            if (System.nanoTime() - this.c >= 0) {
                                this.c = 0L;
                                b bVar2 = this.f825g;
                                synchronized (bVar2.f832f) {
                                    try {
                                        if (!bVar2.isTerminated()) {
                                            if (((int) (bVar2.controlState & 2097151)) > bVar2.f829a) {
                                                if (f820h.compareAndSet(this, -1, 1)) {
                                                    int i3 = this.indexInArray;
                                                    f(0);
                                                    bVar2.G(this, i3, 0);
                                                    int andDecrement = (int) (2097151 & b.f827h.getAndDecrement(bVar2));
                                                    if (andDecrement != i3) {
                                                        Object objB = bVar2.f832f.b(andDecrement);
                                                        kotlin.jvm.internal.j.b(objB);
                                                        a aVar = (a) objB;
                                                        bVar2.f832f.c(i3, aVar);
                                                        aVar.f(i3);
                                                        bVar2.G(aVar, andDecrement, i3);
                                                    }
                                                    bVar2.f832f.c(andDecrement, null);
                                                    this.f822b = 5;
                                                }
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } else {
                        this.f825g.F(this);
                    }
                }
            }
            break loop0;
        }
        h(5);
    }
}
