package o1;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final r f933a;

    /* renamed from: b, reason: collision with root package name */
    public long f934b;
    public boolean c;

    public q(r rVar, long j) {
        this.f933a = rVar;
        this.f934b = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.c) {
            return;
        }
        this.c = true;
        r rVar = this.f933a;
        ReentrantLock reentrantLock = rVar.c;
        reentrantLock.lock();
        try {
            int i2 = rVar.f936b - 1;
            rVar.f936b = i2;
            if (i2 == 0) {
                if (rVar.f935a) {
                    reentrantLock.unlock();
                    rVar.a();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // o1.p0
    public final long read(l sink, long j) {
        long j2;
        long j3;
        kotlin.jvm.internal.j.e(sink, "sink");
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long j4 = this.f934b;
        if (j < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount < 0: ", j).toString());
        }
        long j5 = j + j4;
        long j6 = j4;
        while (true) {
            if (j6 >= j5) {
                j2 = -1;
                break;
            }
            l0 l0VarS = sink.S(1);
            j2 = -1;
            long j7 = j5;
            int iD = this.f933a.D(j6, l0VarS.f920a, l0VarS.c, (int) Math.min(j5 - j6, 8192 - r10));
            if (iD == -1) {
                if (l0VarS.f921b == l0VarS.c) {
                    sink.f918a = l0VarS.a();
                    m0.a(l0VarS);
                }
                if (j4 == j6) {
                    j3 = -1;
                }
            } else {
                l0VarS.c += iD;
                long j8 = iD;
                j6 += j8;
                sink.f919b += j8;
                j5 = j7;
            }
        }
        j3 = j6 - j4;
        if (j3 != j2) {
            this.f934b += j3;
        }
        return j3;
    }

    @Override // o1.p0
    public final s0 timeout() {
        return s0.NONE;
    }
}
