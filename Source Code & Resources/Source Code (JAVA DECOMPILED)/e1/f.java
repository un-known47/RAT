package e1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f implements Iterator, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f437a;

    /* renamed from: b, reason: collision with root package name */
    public int f438b = -1;
    public Object c;
    public final /* synthetic */ g d;

    public f(g gVar) {
        this.d = gVar;
        this.f437a = new q((g) gVar.f440b);
    }

    public final void a() {
        Object next;
        do {
            Iterator it = this.f437a;
            if (!it.hasNext()) {
                this.f438b = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) ((o) this.d.c).invoke(next)).booleanValue());
        this.c = next;
        this.f438b = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f438b == -1) {
            a();
        }
        return this.f438b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f438b == -1) {
            a();
        }
        if (this.f438b == 0) {
            throw new NoSuchElementException();
        }
        Object obj = this.c;
        this.c = null;
        this.f438b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
