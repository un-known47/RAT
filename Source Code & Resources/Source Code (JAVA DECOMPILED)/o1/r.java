package o1;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class r implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f935a;

    /* renamed from: b, reason: collision with root package name */
    public int f936b;
    public final ReentrantLock c = new ReentrantLock();

    public abstract int D(long j, byte[] bArr, int i2, int i3);

    public abstract long E();

    public final q F(long j) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.f935a) {
                throw new IllegalStateException("closed");
            }
            this.f936b++;
            reentrantLock.unlock();
            return new q(this, j);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract void a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.f935a) {
                return;
            }
            this.f935a = true;
            if (this.f936b != 0) {
                return;
            }
            reentrantLock.unlock();
            a();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long size() {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            if (this.f935a) {
                throw new IllegalStateException("closed");
            }
            reentrantLock.unlock();
            return E();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
