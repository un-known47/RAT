package kotlinx.coroutines.scheduling;

import h1.h0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class g extends h0 {

    /* renamed from: a, reason: collision with root package name */
    public b f837a;

    @Override // h1.p
    public final void dispatch(p0.i iVar, Runnable runnable) {
        b.E(this.f837a, runnable, 6);
    }

    @Override // h1.p
    public final void dispatchYield(p0.i iVar, Runnable runnable) {
        b.E(this.f837a, runnable, 2);
    }
}
