package f1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f468a;

    /* renamed from: b, reason: collision with root package name */
    public final c1.d f469b;

    public d(String str, c1.d dVar) {
        this.f468a = str;
        this.f469b = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return kotlin.jvm.internal.j.a(this.f468a, dVar.f468a) && kotlin.jvm.internal.j.a(this.f469b, dVar.f469b);
    }

    public final int hashCode() {
        return this.f469b.hashCode() + (this.f468a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f468a + ", range=" + this.f469b + ')';
    }
}
