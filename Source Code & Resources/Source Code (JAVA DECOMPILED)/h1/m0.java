package h1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class m0 extends p0 {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f555f = AtomicIntegerFieldUpdater.newUpdater(m0.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: e, reason: collision with root package name */
    public final q0 f556e;

    public m0(q0 q0Var) {
        this.f556e = q0Var;
    }

    @Override // y0.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return l0.i.f856a;
    }

    @Override // h1.q0
    public final void l(Throwable th) {
        if (f555f.compareAndSet(this, 0, 1)) {
            this.f556e.invoke(th);
        }
    }
}
