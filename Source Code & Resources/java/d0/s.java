package d0;

import java.lang.reflect.Field;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class s extends r {

    /* renamed from: b, reason: collision with root package name */
    public final c0.q f420b;

    public s(c0.q qVar, t tVar) {
        super(tVar);
        this.f420b = qVar;
    }

    @Override // d0.r
    public final Object d() {
        return this.f420b.a();
    }

    @Override // d0.r
    public final void f(Object obj, i0.a aVar, q qVar) throws IllegalAccessException, IllegalArgumentException {
        Field field = qVar.f412b;
        Object objB = qVar.f414f.b(aVar);
        if (objB == null && qVar.f415g) {
            return;
        }
        if (qVar.f416h) {
            throw new a0.p(androidx.appcompat.app.g.v("Cannot set value of 'static final' ", f0.c.d(field, false)));
        }
        field.set(obj, objB);
    }

    @Override // d0.r
    public final Object e(Object obj) {
        return obj;
    }
}
