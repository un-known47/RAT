package r0;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class i extends c implements kotlin.jvm.internal.g {
    private final int arity;

    public i(p0.d dVar) {
        super(dVar);
        this.arity = 2;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    @Override // r0.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        p.f790a.getClass();
        String strA = q.a(this);
        j.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
