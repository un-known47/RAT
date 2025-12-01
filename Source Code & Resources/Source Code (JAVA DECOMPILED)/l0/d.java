package l0;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f850a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f851b;

    public d(Object obj, Object obj2) {
        this.f850a = obj;
        this.f851b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return j.a(this.f850a, dVar.f850a) && j.a(this.f851b, dVar.f851b);
    }

    public final int hashCode() {
        Object obj = this.f850a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f851b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f850a + ", " + this.f851b + ')';
    }
}
