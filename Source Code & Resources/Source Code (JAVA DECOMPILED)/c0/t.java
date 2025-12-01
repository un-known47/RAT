package c0;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class t extends x {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f201b;
    public final /* synthetic */ Object c;

    public t(Method method, Object obj) {
        this.f201b = method;
        this.c = obj;
    }

    @Override // c0.x
    public final Object a(Class cls) {
        String strB = g.g.b(cls);
        if (strB == null) {
            return this.f201b.invoke(this.c, cls);
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strB));
    }
}
