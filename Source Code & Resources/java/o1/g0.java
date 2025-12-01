package o1;

import java.util.RandomAccess;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g0 extends m0.e implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final o[] f897a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f898b;

    public g0(o[] oVarArr, int[] iArr) {
        this.f897a = oVarArr;
        this.f898b = iArr;
    }

    @Override // m0.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof o) {
            return super.contains((o) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        return this.f897a[i2];
    }

    @Override // m0.a
    public final int getSize() {
        return this.f897a.length;
    }

    @Override // m0.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof o) {
            return super.indexOf((o) obj);
        }
        return -1;
    }

    @Override // m0.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof o) {
            return super.lastIndexOf((o) obj);
        }
        return -1;
    }
}
