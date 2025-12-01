package c0;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g implements ParameterizedType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f170a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f171b;
    public final Type[] c;

    public g(Type type, Class cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            throw new IllegalArgumentException("Must specify owner type for " + cls);
        }
        this.f170a = type == null ? null : i.a(type);
        this.f171b = i.a(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.c = typeArr2;
        int length = typeArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            Objects.requireNonNull(this.c[i2]);
            i.b(this.c[i2]);
            Type[] typeArr3 = this.c;
            typeArr3[i2] = i.a(typeArr3[i2]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && i.d(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f170a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f171b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.c) ^ this.f171b.hashCode();
        Type type = this.f170a;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.c;
        int length = typeArr.length;
        Type type = this.f171b;
        if (length == 0) {
            return i.k(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(i.k(type));
        sb.append("<");
        sb.append(i.k(typeArr[0]));
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(", ");
            sb.append(i.k(typeArr[i2]));
        }
        sb.append(">");
        return sb.toString();
    }
}
