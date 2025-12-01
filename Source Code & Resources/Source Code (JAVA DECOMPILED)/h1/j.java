package h1;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f546a;

    /* renamed from: b, reason: collision with root package name */
    public final l0 f547b;
    public final y0.l c;
    public final Object d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f548e;

    public /* synthetic */ j(Object obj, l0 l0Var, CancellationException cancellationException, int i2) {
        this(obj, (i2 & 2) != 0 ? null : l0Var, null, null, (i2 & 16) != 0 ? null : cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static j a(j jVar, l0 l0Var, CancellationException cancellationException, int i2) {
        Object obj = jVar.f546a;
        if ((i2 & 2) != 0) {
            l0Var = jVar.f547b;
        }
        l0 l0Var2 = l0Var;
        y0.l lVar = jVar.c;
        Object obj2 = jVar.d;
        CancellationException cancellationException2 = cancellationException;
        if ((i2 & 16) != 0) {
            cancellationException2 = jVar.f548e;
        }
        jVar.getClass();
        return new j(obj, l0Var2, lVar, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return kotlin.jvm.internal.j.a(this.f546a, jVar.f546a) && kotlin.jvm.internal.j.a(this.f547b, jVar.f547b) && kotlin.jvm.internal.j.a(this.c, jVar.c) && kotlin.jvm.internal.j.a(this.d, jVar.d) && kotlin.jvm.internal.j.a(this.f548e, jVar.f548e);
    }

    public final int hashCode() {
        Object obj = this.f546a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        l0 l0Var = this.f547b;
        int iHashCode2 = (iHashCode + (l0Var == null ? 0 : l0Var.hashCode())) * 31;
        y0.l lVar = this.c;
        int iHashCode3 = (iHashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.d;
        int iHashCode4 = (iHashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f548e;
        return iHashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f546a + ", cancelHandler=" + this.f547b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.f548e + ')';
    }

    public j(Object obj, l0 l0Var, y0.l lVar, Object obj2, Throwable th) {
        this.f546a = obj;
        this.f547b = l0Var;
        this.c = lVar;
        this.d = obj2;
        this.f548e = th;
    }
}
