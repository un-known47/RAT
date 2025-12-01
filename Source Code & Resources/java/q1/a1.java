package q1;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a1 implements WildcardType {

    /* renamed from: a, reason: collision with root package name */
    public final Type f1055a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f1056b;

    public a1(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr.length != 1) {
            throw new IllegalArgumentException();
        }
        if (typeArr2.length != 1) {
            typeArr[0].getClass();
            b1.d(typeArr[0]);
            this.f1056b = null;
            this.f1055a = typeArr[0];
            return;
        }
        typeArr2[0].getClass();
        b1.d(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            throw new IllegalArgumentException();
        }
        this.f1056b = typeArr2[0];
        this.f1055a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && b1.e(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f1056b;
        return type != null ? new Type[]{type} : b1.f1065a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f1055a};
    }

    public final int hashCode() {
        Type type = this.f1056b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f1055a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f1056b;
        if (type != null) {
            return "? super " + b1.s(type);
        }
        Type type2 = this.f1055a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + b1.s(type2);
    }
}
