package a0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class l extends d0.w {

    /* renamed from: a, reason: collision with root package name */
    public b0 f7a = null;

    @Override // a0.b0
    public final Object b(i0.a aVar) {
        b0 b0Var = this.f7a;
        if (b0Var != null) {
            return b0Var.b(aVar);
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) {
        b0 b0Var = this.f7a;
        if (b0Var == null) {
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
        b0Var.c(bVar, obj);
    }

    @Override // d0.w
    public final b0 d() {
        b0 b0Var = this.f7a;
        if (b0Var != null) {
            return b0Var;
        }
        throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
    }
}
