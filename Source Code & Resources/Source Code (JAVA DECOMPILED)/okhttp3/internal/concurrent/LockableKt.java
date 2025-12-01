package okhttp3.internal.concurrent;

import kotlin.jvm.internal.j;
import okhttp3.internal._UtilJvmKt;
import y0.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class LockableKt {
    public static final void assertLockHeld(Lockable lockable) {
        j.e(lockable, "<this>");
        if (!_UtilJvmKt.assertionsEnabled || Thread.holdsLock(lockable)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + lockable);
    }

    public static final void assertLockNotHeld(Lockable lockable) {
        j.e(lockable, "<this>");
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(lockable)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lockable);
        }
    }

    public static final void awaitNanos(Lockable lockable, long j) throws InterruptedException {
        j.e(lockable, "<this>");
        long j2 = j / 1000000;
        long j3 = j - (1000000 * j2);
        if (j2 > 0 || j > 0) {
            lockable.wait(j2, (int) j3);
        }
    }

    public static final void notify(Lockable lockable) {
        j.e(lockable, "<this>");
        lockable.notify();
    }

    public static final void notifyAll(Lockable lockable) {
        j.e(lockable, "<this>");
        lockable.notifyAll();
    }

    public static final void wait(Lockable lockable) throws InterruptedException {
        j.e(lockable, "<this>");
        lockable.wait();
    }

    public static final <T> T withLock(Lockable lockable, a action) {
        T t2;
        j.e(lockable, "<this>");
        j.e(action, "action");
        synchronized (lockable) {
            t2 = (T) action.invoke();
        }
        return t2;
    }
}
