package c0;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class u extends x {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f202b;
    public final /* synthetic */ int c;

    public u(Method method, int i2) {
        this.f202b = method;
        this.c = i2;
    }

    @Override // c0.x
    public final Object a(Class cls) {
        String strB = g.g.b(cls);
        if (strB == null) {
            return this.f202b.invoke(null, cls, Integer.valueOf(this.c));
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strB));
    }
}
