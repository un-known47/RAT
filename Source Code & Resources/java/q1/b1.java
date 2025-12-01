package q1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class b1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Type[] f1065a = new Type[0];

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1066b = true;
    public static Constructor c;

    public static final Object b(d dVar, p0.d dVar2) throws Throwable {
        h1.e eVar = new h1.e(p.a.C(dVar2));
        eVar.l();
        eVar.n(new v(dVar, 0));
        dVar.D(new w(eVar, 0));
        Object objK = eVar.k();
        q0.a aVar = q0.a.f1043a;
        return objK;
    }

    public static final Object c(d dVar, p0.d dVar2) throws Throwable {
        h1.e eVar = new h1.e(p.a.C(dVar2));
        eVar.l();
        eVar.n(new v(dVar, 1));
        dVar.D(new w(eVar, 1));
        Object objK = eVar.k();
        q0.a aVar = q0.a.f1043a;
        return objK;
    }

    public static void d(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean e(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return e(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type f(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                Class<?> cls3 = interfaces[i2];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return f(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return f(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type g(int i2, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i2 >= 0 && i2 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i2];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        StringBuilder sbQ = androidx.appcompat.app.g.q("Index ", i2, " not in range [0,");
        sbQ.append(actualTypeArguments.length);
        sbQ.append(") for ");
        sbQ.append(parameterizedType);
        throw new IllegalArgumentException(sbQ.toString());
    }

    public static Class h(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) h(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return h(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    public static Type i(Type type, Class cls) {
        if (Map.class.isAssignableFrom(cls)) {
            return p(type, cls, f(type, cls, Map.class));
        }
        throw new IllegalArgumentException();
    }

    public static boolean j(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (j(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return j(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static Object k(Object obj, Method method, Object[] objArr) throws NoSuchMethodException, SecurityException {
        Constructor declaredConstructor = c;
        if (declaredConstructor == null) {
            declaredConstructor = com.google.android.material.textfield.h.g().getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            c = declaredConstructor;
        }
        return com.google.android.material.textfield.h.l(declaredConstructor.newInstance(k0.c.class, -1)).unreflectSpecial(method, k0.c.class).bindTo(obj).invokeWithArguments(objArr);
    }

    public static boolean l(Annotation[] annotationArr, Class cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static IllegalArgumentException m(Method method, Exception exc, String str, Object... objArr) {
        StringBuilder sbR = androidx.appcompat.app.g.r(String.format(str, objArr), "\n    for method ");
        sbR.append(method.getDeclaringClass().getSimpleName());
        sbR.append(".");
        sbR.append(method.getName());
        return new IllegalArgumentException(sbR.toString(), exc);
    }

    public static IllegalArgumentException n(Method method, int i2, String str, Object... objArr) {
        return m(method, null, str + " (" + m0.f1092b.d(method, i2) + ")", objArr);
    }

    public static IllegalArgumentException o(Method method, Exception exc, int i2, String str, Object... objArr) {
        return m(method, exc, str + " (" + m0.f1092b.d(method, i2) + ")", objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Type p(java.lang.reflect.Type r8, java.lang.Class r9, java.lang.reflect.Type r10) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.b1.p(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q(java.lang.Throwable r4, p0.d r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof q1.x
            if (r0 == 0) goto L13
            r0 = r5
            q1.x r0 = (q1.x) r0
            int r1 = r0.f1157b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1157b = r1
            goto L18
        L13:
            q1.x r0 = new q1.x
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f1156a
            q0.a r1 = q0.a.f1043a
            int r1 = r0.f1157b
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 == r2) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            p.a.S(r5)
            a0.s r4 = new a0.s
            r4.<init>()
            throw r4
        L34:
            p.a.S(r5)
            r0.f1157b = r2
            kotlinx.coroutines.scheduling.d r5 = h1.b0.f530a
            p0.i r1 = r0.getContext()
            i.r r2 = new i.r
            r3 = 7
            r2.<init>(r0, r4, r3)
            r5.dispatch(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.b1.q(java.lang.Throwable, p0.d):void");
    }

    public static void r(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static String s(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public abstract void a(p0 p0Var, Object obj);
}
