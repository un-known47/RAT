package androidx.core.util;

import java.util.concurrent.atomic.AtomicBoolean;
import p0.d;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class AndroidXContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    private final d<T> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidXContinuationConsumer(d<? super T> dVar) {
        super(false);
        this.continuation = dVar;
    }

    @Override // androidx.core.util.Consumer
    public void accept(T t2) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(t2);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ')';
    }
}
