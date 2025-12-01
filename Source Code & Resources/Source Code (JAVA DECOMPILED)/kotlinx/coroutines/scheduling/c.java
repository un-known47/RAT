package kotlinx.coroutines.scheduling;

import h1.h0;
import h1.p;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends h0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final c f833a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final p f834b;

    static {
        l lVar = l.f846a;
        int i2 = kotlinx.coroutines.internal.p.f815a;
        if (64 >= i2) {
            i2 = 64;
        }
        f834b = lVar.limitedParallelism(kotlinx.coroutines.internal.b.f("kotlinx.coroutines.io.parallelism", i2, 12));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // h1.p
    public final void dispatch(p0.i iVar, Runnable runnable) {
        f834b.dispatch(iVar, runnable);
    }

    @Override // h1.p
    public final void dispatchYield(p0.i iVar, Runnable runnable) {
        f834b.dispatchYield(iVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(p0.j.f989a, runnable);
    }

    @Override // h1.p
    public final p limitedParallelism(int i2) {
        return l.f846a.limitedParallelism(i2);
    }

    @Override // h1.p
    public final String toString() {
        return "Dispatchers.IO";
    }
}
