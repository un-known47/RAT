package i;

import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f583a;

    /* renamed from: b, reason: collision with root package name */
    public final h.c f584b;
    public final h.a c;
    public final String d;

    public a(h.c cVar, h.a aVar, String str) {
        this.f584b = cVar;
        this.c = aVar;
        this.d = str;
        this.f583a = Arrays.hashCode(new Object[]{cVar, aVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.s.d(this.f584b, aVar.f584b) && k.s.d(this.c, aVar.c) && k.s.d(this.d, aVar.d);
    }

    public final int hashCode() {
        return this.f583a;
    }
}
