package q1;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class y0 implements GenericArrayType {

    /* renamed from: a, reason: collision with root package name */
    public final Type f1160a;

    public y0(Type type) {
        this.f1160a = type;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && b1.e(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f1160a;
    }

    public final int hashCode() {
        return this.f1160a.hashCode();
    }

    public final String toString() {
        return b1.s(this.f1160a) + _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
    }
}
