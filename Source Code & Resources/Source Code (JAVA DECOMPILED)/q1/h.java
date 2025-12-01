package q1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1078a;

    /* renamed from: b, reason: collision with root package name */
    public final j f1079b;

    public /* synthetic */ h(j jVar, int i2) {
        this.f1078a = i2;
        this.f1079b = jVar;
    }

    @Override // q1.g
    public final void b(d dVar, s0 s0Var) {
        switch (this.f1078a) {
            case 0:
                boolean zIsSuccessful = s0Var.f1140a.isSuccessful();
                j jVar = this.f1079b;
                if (!zIsSuccessful) {
                    jVar.completeExceptionally(new a0.s(s0Var));
                    break;
                } else {
                    jVar.complete(s0Var.f1141b);
                    break;
                }
            default:
                this.f1079b.complete(s0Var);
                break;
        }
    }

    @Override // q1.g
    public final void e(d dVar, Throwable th) {
        switch (this.f1078a) {
            case 0:
                this.f1079b.completeExceptionally(th);
                break;
            default:
                this.f1079b.completeExceptionally(th);
                break;
        }
    }
}
