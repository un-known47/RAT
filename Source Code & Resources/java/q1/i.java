package q1;

import java.lang.reflect.Type;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1084a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f1085b;

    public /* synthetic */ i(int i2, Type type) {
        this.f1084a = i2;
        this.f1085b = type;
    }

    @Override // q1.f
    public final Object c(b0 b0Var) {
        switch (this.f1084a) {
            case 0:
                j jVar = new j(b0Var);
                b0Var.D(new h(jVar, 0));
                return jVar;
            default:
                j jVar2 = new j(b0Var);
                b0Var.D(new h(jVar2, 1));
                return jVar2;
        }
    }

    @Override // q1.f
    public final Type d() {
        switch (this.f1084a) {
        }
        return this.f1085b;
    }
}
