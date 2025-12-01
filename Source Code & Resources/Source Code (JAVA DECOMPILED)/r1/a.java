package r1;

import a0.m;
import i.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import q1.l;
import q1.u0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a extends l {

    /* renamed from: a, reason: collision with root package name */
    public final m f1174a;

    public a(m mVar) {
        this.f1174a = mVar;
    }

    @Override // q1.l
    public final q1.m a(Type type) {
        h0.a aVar = new h0.a(type);
        m mVar = this.f1174a;
        return new b(mVar, mVar.b(aVar));
    }

    @Override // q1.l
    public final q1.m b(Type type, Annotation[] annotationArr, u0 u0Var) {
        h0.a aVar = new h0.a(type);
        m mVar = this.f1174a;
        return new o(mVar, mVar.b(aVar));
    }
}
