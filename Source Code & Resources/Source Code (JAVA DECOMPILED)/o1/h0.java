package o1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h0 implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final String f899b;

    /* renamed from: a, reason: collision with root package name */
    public final o f900a;

    static {
        String separator = File.separator;
        kotlin.jvm.internal.j.d(separator, "separator");
        f899b = separator;
    }

    public h0(o bytes) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        this.f900a = bytes;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = p1.f.a(this);
        o oVar = this.f900a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < oVar.d() && oVar.i(iA) == 92) {
            iA++;
        }
        int iD = oVar.d();
        int i2 = iA;
        while (iA < iD) {
            if (oVar.i(iA) == 47 || oVar.i(iA) == 92) {
                arrayList.add(oVar.o(i2, iA));
                i2 = iA + 1;
            }
            iA++;
        }
        if (i2 < oVar.d()) {
            arrayList.add(oVar.o(i2, oVar.d()));
        }
        return arrayList;
    }

    public final h0 b() {
        o oVar = p1.f.d;
        o oVar2 = this.f900a;
        if (kotlin.jvm.internal.j.a(oVar2, oVar)) {
            return null;
        }
        o oVar3 = p1.f.f1008a;
        if (kotlin.jvm.internal.j.a(oVar2, oVar3)) {
            return null;
        }
        o prefix = p1.f.f1009b;
        if (kotlin.jvm.internal.j.a(oVar2, prefix)) {
            return null;
        }
        o suffix = p1.f.f1010e;
        oVar2.getClass();
        kotlin.jvm.internal.j.e(suffix, "suffix");
        int iD = oVar2.d();
        byte[] bArr = suffix.f929a;
        if (oVar2.l(iD - bArr.length, suffix, bArr.length) && (oVar2.d() == 2 || oVar2.l(oVar2.d() - 3, oVar3, 1) || oVar2.l(oVar2.d() - 3, prefix, 1))) {
            return null;
        }
        int iK = o.k(oVar2, oVar3);
        if (iK == -1) {
            iK = o.k(oVar2, prefix);
        }
        if (iK == 2 && g() != null) {
            if (oVar2.d() == 3) {
                return null;
            }
            return new h0(o.p(oVar2, 0, 3, 1));
        }
        if (iK == 1) {
            kotlin.jvm.internal.j.e(prefix, "prefix");
            if (oVar2.l(0, prefix, prefix.d())) {
                return null;
            }
        }
        if (iK != -1 || g() == null) {
            return iK == -1 ? new h0(oVar) : iK == 0 ? new h0(o.p(oVar2, 0, 1, 1)) : new h0(o.p(oVar2, 0, iK, 1));
        }
        if (oVar2.d() == 2) {
            return null;
        }
        return new h0(o.p(oVar2, 0, 2, 1));
    }

    public final h0 c(h0 other) {
        kotlin.jvm.internal.j.e(other, "other");
        o oVar = other.f900a;
        int iA = p1.f.a(this);
        o oVar2 = this.f900a;
        h0 h0Var = iA == -1 ? null : new h0(oVar2.o(0, iA));
        int iA2 = p1.f.a(other);
        if (!kotlin.jvm.internal.j.a(h0Var, iA2 != -1 ? new h0(oVar.o(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = other.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i2 = 0;
        while (i2 < iMin && kotlin.jvm.internal.j.a(arrayListA.get(i2), arrayListA2.get(i2))) {
            i2++;
        }
        if (i2 == iMin && oVar2.d() == oVar.d()) {
            return g.g.g(".");
        }
        if (arrayListA2.subList(i2, arrayListA2.size()).indexOf(p1.f.f1010e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        if (kotlin.jvm.internal.j.a(oVar, p1.f.d)) {
            return this;
        }
        l lVar = new l();
        o oVarC = p1.f.c(other);
        if (oVarC == null && (oVarC = p1.f.c(this)) == null) {
            oVarC = p1.f.f(f899b);
        }
        int size = arrayListA2.size();
        for (int i3 = i2; i3 < size; i3++) {
            lVar.T(p1.f.f1010e);
            lVar.T(oVarC);
        }
        int size2 = arrayListA.size();
        while (i2 < size2) {
            lVar.T((o) arrayListA.get(i2));
            lVar.T(oVarC);
            i2++;
        }
        return p1.f.d(lVar, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        h0 other = (h0) obj;
        kotlin.jvm.internal.j.e(other, "other");
        return this.f900a.compareTo(other.f900a);
    }

    public final h0 d(String child) {
        kotlin.jvm.internal.j.e(child, "child");
        l lVar = new l();
        lVar.b0(child);
        return p1.f.b(this, p1.f.d(lVar, false), false);
    }

    public final h0 e(h0 child, boolean z2) {
        kotlin.jvm.internal.j.e(child, "child");
        return p1.f.b(this, child, z2);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof h0) && kotlin.jvm.internal.j.a(((h0) obj).f900a, this.f900a);
    }

    public final Path f() {
        Path path = Paths.get(this.f900a.r(), new String[0]);
        kotlin.jvm.internal.j.d(path, "get(...)");
        return path;
    }

    public final Character g() {
        o oVar = p1.f.f1008a;
        o oVar2 = this.f900a;
        if (o.g(oVar2, oVar) != -1 || oVar2.d() < 2 || oVar2.i(1) != 58) {
            return null;
        }
        char cI = (char) oVar2.i(0);
        if (('a' > cI || cI >= '{') && ('A' > cI || cI >= '[')) {
            return null;
        }
        return Character.valueOf(cI);
    }

    public final int hashCode() {
        return this.f900a.hashCode();
    }

    public final File toFile() {
        return new File(this.f900a.r());
    }

    public final String toString() {
        return this.f900a.r();
    }
}
