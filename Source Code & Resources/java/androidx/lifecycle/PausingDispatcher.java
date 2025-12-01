package androidx.lifecycle;

import h1.b0;
import h1.p;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.k;
import p0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class PausingDispatcher extends p {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // h1.p
    public void dispatch(i context, Runnable block) {
        j.e(context, "context");
        j.e(block, "block");
        this.dispatchQueue.dispatchAndEnqueue(context, block);
    }

    @Override // h1.p
    public boolean isDispatchNeeded(i context) {
        j.e(context, "context");
        kotlinx.coroutines.scheduling.d dVar = b0.f530a;
        if (k.f813a.c.isDispatchNeeded(context)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}
