package q1;

import okhttp3.Call;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class r extends t {
    public final f d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1131e;

    public r(r0 r0Var, Call.Factory factory, m mVar, f fVar, boolean z2) {
        super(r0Var, factory, mVar);
        this.d = fVar;
        this.f1131e = z2;
    }

    @Override // q1.t
    public final Object b(b0 b0Var, Object[] objArr) throws Throwable {
        d dVar = (d) this.d.c(b0Var);
        p0.d dVar2 = (p0.d) objArr[objArr.length - 1];
        try {
            if (!this.f1131e) {
                return b1.b(dVar, dVar2);
            }
            kotlin.jvm.internal.j.c(dVar, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
            return b1.c(dVar, dVar2);
        } catch (LinkageError e2) {
            throw e2;
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (VirtualMachineError e4) {
            throw e4;
        } catch (Throwable th) {
            b1.q(th, dVar2);
            return q0.a.f1043a;
        }
    }
}
