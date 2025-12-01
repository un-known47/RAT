package c1;

import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class b implements Iterable, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f205a;

    /* renamed from: b, reason: collision with root package name */
    public final int f206b;
    public final int c;

    public b(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f205a = i2;
        this.f206b = p.a.A(i2, i3, i4);
        this.c = i4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (isEmpty() && ((b) obj).isEmpty()) {
            return true;
        }
        b bVar = (b) obj;
        return this.f205a == bVar.f205a && this.f206b == bVar.f206b && this.c == bVar.c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f205a * 31) + this.f206b) * 31) + this.c;
    }

    public boolean isEmpty() {
        int i2 = this.c;
        int i3 = this.f206b;
        int i4 = this.f205a;
        return i2 > 0 ? i4 > i3 : i4 < i3;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c(this.f205a, this.f206b, this.c);
    }

    public String toString() {
        StringBuilder sb;
        int i2 = this.f206b;
        int i3 = this.f205a;
        int i4 = this.c;
        if (i4 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i2);
            sb.append(" step ");
            sb.append(i4);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i2);
            sb.append(" step ");
            sb.append(-i4);
        }
        return sb.toString();
    }
}
