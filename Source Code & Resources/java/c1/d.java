package c1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends b implements a {
    public static final d d = new d(1, 0, 1);

    @Override // c1.b
    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        if (isEmpty() && ((d) obj).isEmpty()) {
            return true;
        }
        d dVar = (d) obj;
        return this.f205a == dVar.f205a && this.f206b == dVar.f206b;
    }

    @Override // c1.a
    public final Comparable getEndInclusive() {
        return Integer.valueOf(this.f206b);
    }

    @Override // c1.a
    public final Comparable getStart() {
        return Integer.valueOf(this.f205a);
    }

    @Override // c1.b
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f205a * 31) + this.f206b;
    }

    @Override // c1.b
    public final boolean isEmpty() {
        return this.f205a > this.f206b;
    }

    @Override // c1.b
    public final String toString() {
        return this.f205a + ".." + this.f206b;
    }
}
