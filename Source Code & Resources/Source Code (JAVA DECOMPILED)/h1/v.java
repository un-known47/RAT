package h1;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class v extends f0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: e, reason: collision with root package name */
    public static final v f578e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f579f;

    static {
        Long l2;
        v vVar = new v();
        f578e = vVar;
        vVar.G(false);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        f579f = timeUnit.toNanos(l2.longValue());
    }

    @Override // h1.g0
    public final Thread F() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // h1.f0
    public final void I(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.I(runnable);
    }

    public final synchronized void N() {
        int i2 = debugStatus;
        if (i2 == 2 || i2 == 3) {
            debugStatus = 3;
            M();
            notifyAll();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zK;
        c1.f533a.set(this);
        try {
            synchronized (this) {
                int i2 = debugStatus;
                if (i2 == 2 || i2 == 3) {
                    if (zK) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long jL = L();
                    if (jL == LocationRequestCompat.PASSIVE_INTERVAL) {
                        long jNanoTime = System.nanoTime();
                        if (j == LocationRequestCompat.PASSIVE_INTERVAL) {
                            j = f579f + jNanoTime;
                        }
                        long j2 = j - jNanoTime;
                        if (j2 <= 0) {
                            _thread = null;
                            N();
                            if (K()) {
                                return;
                            }
                            F();
                            return;
                        }
                        if (jL > j2) {
                            jL = j2;
                        }
                    } else {
                        j = Long.MAX_VALUE;
                    }
                    if (jL > 0) {
                        int i3 = debugStatus;
                        if (i3 == 2 || i3 == 3) {
                            _thread = null;
                            N();
                            if (K()) {
                                return;
                            }
                            F();
                            return;
                        }
                        LockSupport.parkNanos(this, jL);
                    }
                }
            }
        } finally {
            _thread = null;
            N();
            if (!K()) {
                F();
            }
        }
    }

    @Override // h1.f0, h1.g0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }
}
