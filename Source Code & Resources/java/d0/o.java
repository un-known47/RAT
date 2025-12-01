package d0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class o extends a0.b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final n f407b = new n(0, new o(a0.z.f21b));

    /* renamed from: a, reason: collision with root package name */
    public final a0.z f408a;

    public o(a0.z zVar) {
        this.f408a = zVar;
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        int iX = aVar.X();
        int iA = a0.u.a(iX);
        if (iA == 5 || iA == 6) {
            return this.f408a.a(aVar);
        }
        if (iA == 8) {
            aVar.T();
            return null;
        }
        throw new a0.p("Expecting number, got: " + androidx.appcompat.app.g.w(iX) + "; at path " + aVar.J(false));
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        bVar.Q((Number) obj);
    }
}
