package i;

import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final a f634a;

    /* renamed from: b, reason: collision with root package name */
    public final g.c f635b;

    public /* synthetic */ q(a aVar, g.c cVar) {
        this.f634a = aVar;
        this.f635b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof q)) {
            q qVar = (q) obj;
            if (k.s.d(this.f634a, qVar.f634a) && k.s.d(this.f635b, qVar.f635b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f634a, this.f635b});
    }

    public final String toString() {
        h.c cVar = new h.c(this);
        cVar.f(this.f634a, "key");
        cVar.f(this.f635b, "feature");
        return cVar.toString();
    }
}
