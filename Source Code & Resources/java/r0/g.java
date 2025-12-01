package r0;

import p0.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class g extends a {
    public g(p0.d dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != j.f989a) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // p0.d
    public p0.i getContext() {
        return j.f989a;
    }
}
