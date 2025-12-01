package d0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class s0 implements a0.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f421a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f422b;
    public final /* synthetic */ a0.b0 c;

    public s0(Class cls, Class cls2, a0.b0 b0Var) {
        this.f421a = cls;
        this.f422b = cls2;
        this.c = b0Var;
    }

    @Override // a0.c0
    public final a0.b0 a(a0.m mVar, h0.a aVar) {
        Class cls = aVar.f525a;
        if (cls == this.f421a || cls == this.f422b) {
            return this.c;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f422b.getName() + "+" + this.f421a.getName() + ",adapter=" + this.c + "]";
    }
}
