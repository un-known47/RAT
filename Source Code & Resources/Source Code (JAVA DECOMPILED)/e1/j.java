package e1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends k implements Iterator, p0.d, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public int f443a;

    /* renamed from: b, reason: collision with root package name */
    public Object f444b;
    public Iterator c;
    public p0.d d;

    @Override // e1.k
    public final void a(Object obj, r0.a aVar) {
        this.f444b = obj;
        this.f443a = 3;
        this.d = aVar;
        q0.a aVar2 = q0.a.f1043a;
    }

    public final RuntimeException b() {
        int i2 = this.f443a;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f443a);
    }

    @Override // p0.d
    public final p0.i getContext() {
        return p0.j.f989a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i2 = this.f443a;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return true;
                    }
                    if (i2 == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator it = this.c;
                kotlin.jvm.internal.j.b(it);
                if (it.hasNext()) {
                    this.f443a = 2;
                    return true;
                }
                this.c = null;
            }
            this.f443a = 5;
            p0.d dVar = this.d;
            kotlin.jvm.internal.j.b(dVar);
            this.d = null;
            dVar.resumeWith(l0.i.f856a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f443a;
        if (i2 == 0 || i2 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i2 == 2) {
            this.f443a = 1;
            Iterator it = this.c;
            kotlin.jvm.internal.j.b(it);
            return it.next();
        }
        if (i2 != 3) {
            throw b();
        }
        this.f443a = 0;
        Object obj = this.f444b;
        this.f444b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // p0.d
    public final void resumeWith(Object obj) throws Throwable {
        p.a.S(obj);
        this.f443a = 4;
    }
}
