package e1;

import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c implements i, d {

    /* renamed from: a, reason: collision with root package name */
    public final i f434a;

    /* renamed from: b, reason: collision with root package name */
    public final int f435b;

    public c(i sequence, int i2) {
        kotlin.jvm.internal.j.e(sequence, "sequence");
        this.f434a = sequence;
        this.f435b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // e1.d
    public final i a(int i2) {
        int i3 = this.f435b + i2;
        return i3 < 0 ? new c(this, i2) : new c(this.f434a, i3);
    }

    @Override // e1.i
    public final Iterator iterator() {
        return new b(this);
    }
}
