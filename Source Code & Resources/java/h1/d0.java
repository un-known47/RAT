package h1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f534a;

    public d0(boolean z2) {
        this.f534a = z2;
    }

    @Override // h1.j0
    public final boolean a() {
        return this.f534a;
    }

    @Override // h1.j0
    public final v0 c() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f534a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
