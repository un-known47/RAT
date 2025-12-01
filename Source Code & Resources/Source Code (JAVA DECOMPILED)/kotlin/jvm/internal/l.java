package kotlin.jvm.internal;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class l implements c {

    /* renamed from: a, reason: collision with root package name */
    public final Class f786a;

    public l(Class jClass) {
        j.e(jClass, "jClass");
        this.f786a = jClass;
    }

    @Override // kotlin.jvm.internal.c
    public final Class a() {
        return this.f786a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            return j.a(this.f786a, ((l) obj).f786a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f786a.hashCode();
    }

    public final String toString() {
        return this.f786a + " (Kotlin reflection is not available)";
    }
}
