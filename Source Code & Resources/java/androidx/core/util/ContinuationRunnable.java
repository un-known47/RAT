package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import l0.i;
import p0.d;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    private final d<i> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationRunnable(d<? super i> dVar) {
        super(false);
        this.continuation = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(i.f856a);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ')';
    }
}
