package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class k implements g, Serializable {
    private final int arity;

    public k(int i2) {
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        p.f790a.getClass();
        String strA = q.a(this);
        j.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
