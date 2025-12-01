package f0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends p.a {

    /* renamed from: g, reason: collision with root package name */
    public final Method f454g = Class.class.getMethod("isRecord", null);

    /* renamed from: h, reason: collision with root package name */
    public final Method f455h = Class.class.getMethod("getRecordComponents", null);

    /* renamed from: i, reason: collision with root package name */
    public final Method f456i;
    public final Method j;

    public b() throws ClassNotFoundException {
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.f456i = cls.getMethod("getName", null);
        this.j = cls.getMethod("getType", null);
    }

    @Override // p.a
    public final String[] B(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f455h.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                strArr[i2] = (String) this.f456i.invoke(objArr[i2], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }

    @Override // p.a
    public final boolean D(Class cls) {
        try {
            return ((Boolean) this.f454g.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }

    @Override // p.a
    public final Method x(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }

    @Override // p.a
    public final Constructor y(Class cls) {
        try {
            Object[] objArr = (Object[]) this.f455h.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = (Class) this.j.invoke(objArr[i2], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e2) {
            throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.13.2). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", e2);
        }
    }
}
