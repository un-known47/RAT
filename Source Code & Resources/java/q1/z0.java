package q1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class z0 implements ParameterizedType {

    /* renamed from: a, reason: collision with root package name */
    public final Type f1163a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f1164b;
    public final Type[] c;

    public z0(Type type, Type type2, Type... typeArr) {
        if (type2 instanceof Class) {
            if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                throw new IllegalArgumentException();
            }
        }
        for (Type type3 : typeArr) {
            Objects.requireNonNull(type3, "typeArgument == null");
            b1.d(type3);
        }
        this.f1163a = type;
        this.f1164b = type2;
        this.c = (Type[]) typeArr.clone();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && b1.e(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.c.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f1163a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f1164b;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.c) ^ this.f1164b.hashCode();
        Type type = this.f1163a;
        return iHashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.c;
        int length = typeArr.length;
        Type type = this.f1164b;
        if (length == 0) {
            return b1.s(type);
        }
        StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
        sb.append(b1.s(type));
        sb.append("<");
        sb.append(b1.s(typeArr[0]));
        for (int i2 = 1; i2 < typeArr.length; i2++) {
            sb.append(", ");
            sb.append(b1.s(typeArr[i2]));
        }
        sb.append(">");
        return sb.toString();
    }
}
