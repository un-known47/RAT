package e1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h implements Iterator, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public Object f441a;

    /* renamed from: b, reason: collision with root package name */
    public int f442b = -2;
    public final /* synthetic */ g c;

    public h(g gVar) {
        this.c = gVar;
    }

    public final void a() {
        Object objInvoke;
        int i2 = this.f442b;
        g gVar = this.c;
        if (i2 == -2) {
            objInvoke = ((n) gVar.f440b).f448b;
        } else {
            y0.l lVar = (y0.l) gVar.c;
            Object obj = this.f441a;
            kotlin.jvm.internal.j.b(obj);
            objInvoke = lVar.invoke(obj);
        }
        this.f441a = objInvoke;
        this.f442b = objInvoke == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f442b < 0) {
            a();
        }
        return this.f442b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f442b < 0) {
            a();
        }
        if (this.f442b == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.f441a;
        kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
        this.f442b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
