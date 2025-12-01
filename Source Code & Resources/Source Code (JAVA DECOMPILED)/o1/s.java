package o1;

import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f937a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f938b;
    public final h0 c;
    public final Long d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f939e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f940f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f941g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f942h;

    public s(boolean z2, boolean z3, h0 h0Var, Long l2, Long l3, Long l4, Long l5, Map extras) {
        kotlin.jvm.internal.j.e(extras, "extras");
        this.f937a = z2;
        this.f938b = z3;
        this.c = h0Var;
        this.d = l2;
        this.f939e = l3;
        this.f940f = l4;
        this.f941g = l5;
        this.f942h = m0.v.i0(extras);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f937a) {
            arrayList.add("isRegularFile");
        }
        if (this.f938b) {
            arrayList.add("isDirectory");
        }
        Long l2 = this.d;
        if (l2 != null) {
            arrayList.add("byteCount=" + l2);
        }
        Long l3 = this.f939e;
        if (l3 != null) {
            arrayList.add("createdAt=" + l3);
        }
        Long l4 = this.f940f;
        if (l4 != null) {
            arrayList.add("lastModifiedAt=" + l4);
        }
        Long l5 = this.f941g;
        if (l5 != null) {
            arrayList.add("lastAccessedAt=" + l5);
        }
        Map map = this.f942h;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return m0.k.s0(arrayList, "FileMetadata(", ")", null, 56);
    }

    public /* synthetic */ s(boolean z2, boolean z3, h0 h0Var, Long l2, Long l3, Long l4, Long l5) {
        this(z2, z3, h0Var, l2, l3, l4, l5, m0.r.f868a);
    }
}
