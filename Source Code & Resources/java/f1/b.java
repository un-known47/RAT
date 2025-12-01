package f1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b implements Iterator, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public int f462a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f463b;
    public int c;
    public c1.d d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ e1.g f464e;

    public b(e1.g gVar) {
        this.f464e = gVar;
        int length = ((CharSequence) gVar.f440b).length();
        if (length < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.e("Cannot coerce value to an empty range: maximum ", length, " is less than minimum 0."));
        }
        length = length >= 0 ? 0 : length;
        this.f463b = length;
        this.c = length;
    }

    public final void a() {
        l0.d dVar;
        e1.g gVar = this.f464e;
        CharSequence charSequence = (CharSequence) gVar.f440b;
        int i2 = this.c;
        if (i2 < 0) {
            this.f462a = 0;
            this.d = null;
            return;
        }
        if (i2 <= charSequence.length() && (dVar = (l0.d) ((r) gVar.c).invoke(charSequence, Integer.valueOf(this.c))) != null) {
            int iIntValue = ((Number) dVar.f850a).intValue();
            int iIntValue2 = ((Number) dVar.f851b).intValue();
            this.d = p.a.V(this.f463b, iIntValue);
            int i3 = iIntValue + iIntValue2;
            this.f463b = i3;
            this.c = i3 + (iIntValue2 == 0 ? 1 : 0);
        } else {
            this.d = new c1.d(this.f463b, j.s0(charSequence), 1);
            this.c = -1;
        }
        this.f462a = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f462a == -1) {
            a();
        }
        return this.f462a == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f462a == -1) {
            a();
        }
        if (this.f462a == 0) {
            throw new NoSuchElementException();
        }
        c1.d dVar = this.d;
        kotlin.jvm.internal.j.c(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.d = null;
        this.f462a = -1;
        return dVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
