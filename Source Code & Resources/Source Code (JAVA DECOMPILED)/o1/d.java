package o1;

import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends Thread {
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        g gVarC;
        while (true) {
            try {
                g.Companion.getClass();
                reentrantLock = g.lock;
                reentrantLock.lock();
                try {
                    g.Companion.getClass();
                    gVarC = c.c();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused) {
            }
            if (gVarC == g.head) {
                c unused2 = g.Companion;
                g.head = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (gVarC != null) {
                    gVarC.timedOut();
                }
            }
        }
    }
}
