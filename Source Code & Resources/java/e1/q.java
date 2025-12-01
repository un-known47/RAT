package e1;

import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q implements Iterator, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f450a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f451b;

    public q(g gVar) {
        this.f451b = gVar;
        this.f450a = ((i) gVar.f440b).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f450a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((y0.l) this.f451b.c).invoke(this.f450a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
