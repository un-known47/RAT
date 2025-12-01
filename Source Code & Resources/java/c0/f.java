package c0;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f implements GenericArrayType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f169a;

    public f(Type type) {
        Objects.requireNonNull(type);
        this.f169a = i.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && i.d(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f169a;
    }

    public final int hashCode() {
        return this.f169a.hashCode();
    }

    public final String toString() {
        return i.k(this.f169a) + _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
