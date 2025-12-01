package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import p0.d;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RequiresApi(31)
/* loaded from: classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    private final d<R> continuation;

    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(d<? super R> dVar) {
        super(false);
        this.continuation = dVar;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(E e2) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(p.a.p(e2));
        }
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(R r2) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(r2);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
