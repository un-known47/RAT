package p0;

import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a implements g {
    private final h key;

    public a(h hVar) {
        this.key = hVar;
    }

    @Override // p0.i
    public <R> R fold(R r2, p operation) {
        kotlin.jvm.internal.j.e(operation, "operation");
        return (R) operation.invoke(r2, this);
    }

    @Override // p0.i
    public g get(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        if (kotlin.jvm.internal.j.a(getKey(), key)) {
            return this;
        }
        return null;
    }

    @Override // p0.g
    public h getKey() {
        return this.key;
    }

    @Override // p0.i
    public i minusKey(h hVar) {
        return p.a.H(this, hVar);
    }

    @Override // p0.i
    public i plus(i context) {
        kotlin.jvm.internal.j.e(context, "context");
        return p.a.J(this, context);
    }
}
