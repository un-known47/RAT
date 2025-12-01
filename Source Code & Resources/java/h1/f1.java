package h1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f1 implements p0.g, p0.h {

    /* renamed from: a, reason: collision with root package name */
    public static final f1 f540a = new f1();

    @Override // p0.i
    public final Object fold(Object obj, y0.p pVar) {
        return pVar.invoke(obj, this);
    }

    @Override // p0.i
    public final p0.g get(p0.h key) {
        kotlin.jvm.internal.j.e(key, "key");
        if (kotlin.jvm.internal.j.a(this, key)) {
            return this;
        }
        return null;
    }

    @Override // p0.i
    public final p0.i minusKey(p0.h hVar) {
        return p.a.H(this, hVar);
    }

    @Override // p0.i
    public final p0.i plus(p0.i context) {
        kotlin.jvm.internal.j.e(context, "context");
        return p.a.J(this, context);
    }

    @Override // p0.g
    public final p0.h getKey() {
        return this;
    }
}
