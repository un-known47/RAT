package c0;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h implements WildcardType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f172a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f173b;

    public h(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            throw new IllegalArgumentException("At most one lower bound is supported");
        }
        if (typeArr.length != 1) {
            throw new IllegalArgumentException("Exactly one upper bound must be specified");
        }
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            i.b(typeArr[0]);
            this.f173b = null;
            this.f172a = i.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        i.b(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            throw new IllegalArgumentException("When lower bound is specified, upper bound must be Object");
        }
        this.f173b = i.a(typeArr2[0]);
        this.f172a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && i.d(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f173b;
        return type != null ? new Type[]{type} : i.f174a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f172a};
    }

    public final int hashCode() {
        Type type = this.f173b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f172a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f173b;
        if (type != null) {
            return "? super " + i.k(type);
        }
        Type type2 = this.f172a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + i.k(type2);
    }
}
