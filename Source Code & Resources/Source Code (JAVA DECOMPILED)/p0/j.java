package p0;

import java.io.Serializable;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final j f989a = new j();

    @Override // p0.i
    public final g get(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    @Override // p0.i
    public final i minusKey(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        return this;
    }

    @Override // p0.i
    public final i plus(i context) {
        kotlin.jvm.internal.j.e(context, "context");
        return context;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // p0.i
    public final Object fold(Object obj, p pVar) {
        return obj;
    }
}
