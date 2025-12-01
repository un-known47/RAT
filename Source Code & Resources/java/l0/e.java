package l0;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f852a;

    public e(Throwable exception) {
        j.e(exception, "exception");
        this.f852a = exception;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            return j.a(this.f852a, ((e) obj).f852a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f852a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f852a + ')';
    }
}
