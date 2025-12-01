package o1;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class y extends s0 {

    /* renamed from: a, reason: collision with root package name */
    public s0 f945a;

    public y(s0 delegate) {
        kotlin.jvm.internal.j.e(delegate, "delegate");
        this.f945a = delegate;
    }

    @Override // o1.s0
    public final void awaitSignal(Condition condition) throws InterruptedException, InterruptedIOException {
        kotlin.jvm.internal.j.e(condition, "condition");
        this.f945a.awaitSignal(condition);
    }

    @Override // o1.s0
    public final s0 clearDeadline() {
        return this.f945a.clearDeadline();
    }

    @Override // o1.s0
    public final s0 clearTimeout() {
        return this.f945a.clearTimeout();
    }

    @Override // o1.s0
    public final long deadlineNanoTime() {
        return this.f945a.deadlineNanoTime();
    }

    @Override // o1.s0
    public final boolean hasDeadline() {
        return this.f945a.hasDeadline();
    }

    @Override // o1.s0
    public final void throwIfReached() throws InterruptedIOException {
        this.f945a.throwIfReached();
    }

    @Override // o1.s0
    public final s0 timeout(long j, TimeUnit unit) {
        kotlin.jvm.internal.j.e(unit, "unit");
        return this.f945a.timeout(j, unit);
    }

    @Override // o1.s0
    public final long timeoutNanos() {
        return this.f945a.timeoutNanos();
    }

    @Override // o1.s0
    public final void waitUntilNotified(Object monitor) throws InterruptedException, InterruptedIOException {
        kotlin.jvm.internal.j.e(monitor, "monitor");
        this.f945a.waitUntilNotified(monitor);
    }

    @Override // o1.s0
    public final s0 deadlineNanoTime(long j) {
        return this.f945a.deadlineNanoTime(j);
    }
}
