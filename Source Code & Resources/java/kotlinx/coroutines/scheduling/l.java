package kotlinx.coroutines.scheduling;

import h1.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class l extends p {

    /* renamed from: a, reason: collision with root package name */
    public static final l f846a = new l();

    @Override // h1.p
    public final void dispatch(p0.i iVar, Runnable runnable) {
        d dVar = d.f835b;
        dVar.f837a.D(runnable, k.f845g, false);
    }

    @Override // h1.p
    public final void dispatchYield(p0.i iVar, Runnable runnable) {
        d dVar = d.f835b;
        dVar.f837a.D(runnable, k.f845g, true);
    }
}
