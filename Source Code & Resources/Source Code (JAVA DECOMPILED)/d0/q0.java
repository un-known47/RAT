package d0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q0 implements a0.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f417a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f418b;
    public final /* synthetic */ a0.b0 c;

    public /* synthetic */ q0(Class cls, a0.b0 b0Var, int i2) {
        this.f417a = i2;
        this.f418b = cls;
        this.c = b0Var;
    }

    @Override // a0.c0
    public final a0.b0 a(a0.m mVar, h0.a aVar) {
        switch (this.f417a) {
            case 0:
                if (aVar.f525a == this.f418b) {
                    return this.c;
                }
                return null;
            default:
                Class<?> cls = aVar.f525a;
                if (this.f418b.isAssignableFrom(cls)) {
                    return new c(this, cls);
                }
                return null;
        }
    }

    public final String toString() {
        switch (this.f417a) {
            case 0:
                return "Factory[type=" + this.f418b.getName() + ",adapter=" + this.c + "]";
            default:
                return "Factory[typeHierarchy=" + this.f418b.getName() + ",adapter=" + this.c + "]";
        }
    }
}
