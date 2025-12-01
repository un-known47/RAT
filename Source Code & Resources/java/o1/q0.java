package o1;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q0 extends s0 {
    @Override // o1.s0
    public final s0 timeout(long j, TimeUnit unit) {
        kotlin.jvm.internal.j.e(unit, "unit");
        return this;
    }

    @Override // o1.s0
    public final void throwIfReached() {
    }

    @Override // o1.s0
    public final s0 deadlineNanoTime(long j) {
        return this;
    }
}
