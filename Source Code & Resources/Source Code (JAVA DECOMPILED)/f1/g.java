package f1;

import java.util.Iterator;
import java.util.regex.Matcher;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g extends m0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f473a;

    public g(h hVar) {
        this.f473a = hVar;
    }

    public final d a(int i2) {
        Matcher matcher = (Matcher) this.f473a.f474a;
        c1.d dVarV = p.a.V(matcher.start(i2), matcher.end(i2));
        if (dVarV.f205a < 0) {
            return null;
        }
        String strGroup = matcher.group(i2);
        kotlin.jvm.internal.j.d(strGroup, "group(...)");
        return new d(strGroup, dVarV);
    }

    @Override // m0.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof d) {
            return super.contains((d) obj);
        }
        return false;
    }

    @Override // m0.a
    public final int getSize() {
        return ((Matcher) this.f473a.f474a).groupCount() + 1;
    }

    @Override // m0.a, java.util.Collection
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new e1.q(new e1.g(new e1.m(2, new c1.d(0, size() - 1, 1)), new f(0, this)));
    }
}
