package e1;

import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class p implements Iterable, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f449a;

    public p(g gVar) {
        this.f449a = gVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new f1.b(this.f449a);
    }
}
