package d0;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class u extends r {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f425e;

    /* renamed from: b, reason: collision with root package name */
    public final Constructor f426b;
    public final Object[] c;
    public final HashMap d;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(0.0f));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        f425e = map;
    }

    public u(Class cls, t tVar) throws SecurityException {
        super(tVar);
        this.d = new HashMap();
        p.a aVar = f0.c.f457a;
        Constructor constructorY = aVar.y(cls);
        this.f426b = constructorY;
        f0.c.f(constructorY);
        String[] strArrB = aVar.B(cls);
        for (int i2 = 0; i2 < strArrB.length; i2++) {
            this.d.put(strArrB[i2], Integer.valueOf(i2));
        }
        Class<?>[] parameterTypes = this.f426b.getParameterTypes();
        this.c = new Object[parameterTypes.length];
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            this.c[i3] = f425e.get(parameterTypes[i3]);
        }
    }

    @Override // d0.r
    public final Object d() {
        return (Object[]) this.c.clone();
    }

    @Override // d0.r
    public final Object e(Object obj) {
        Object[] objArr = (Object[]) obj;
        Constructor constructor = this.f426b;
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException e2) {
            p.a aVar = f0.c.f457a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new RuntimeException("Failed to invoke constructor '" + f0.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new RuntimeException("Failed to invoke constructor '" + f0.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("Failed to invoke constructor '" + f0.c.b(constructor) + "' with args " + Arrays.toString(objArr), e5.getCause());
        }
    }

    @Override // d0.r
    public final void f(Object obj, i0.a aVar, q qVar) {
        Object[] objArr = (Object[]) obj;
        String str = qVar.c;
        Integer num = (Integer) this.d.get(str);
        if (num == null) {
            throw new IllegalStateException("Could not find the index in the constructor '" + f0.c.b(this.f426b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
        int iIntValue = num.intValue();
        Object objB = qVar.f414f.b(aVar);
        if (objB != null || !qVar.f415g) {
            objArr[iIntValue] = objB;
        } else {
            StringBuilder sbS = androidx.appcompat.app.g.s("null is not allowed as value for record component '", str, "' of primitive type; at path ");
            sbS.append(aVar.J(false));
            throw new a0.s(sbS.toString());
        }
    }
}
