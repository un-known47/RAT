package n0;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import m0.f;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a implements ListIterator, z0.a {

    /* renamed from: b, reason: collision with root package name */
    public int f875b;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public final f f876e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f874a = 0;
    public int c = -1;

    public a(c cVar, int i2) {
        this.f876e = cVar;
        this.f875b = i2;
        this.d = ((AbstractList) cVar).modCount;
    }

    public void a() {
        if (((AbstractList) ((b) this.f876e).f879e).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        switch (this.f874a) {
            case 0:
                a();
                b bVar = (b) this.f876e;
                int i2 = this.f875b;
                this.f875b = i2 + 1;
                bVar.add(i2, obj);
                this.c = -1;
                this.d = ((AbstractList) bVar).modCount;
                break;
            default:
                b();
                c cVar = (c) this.f876e;
                int i3 = this.f875b;
                this.f875b = i3 + 1;
                cVar.add(i3, obj);
                this.c = -1;
                this.d = ((AbstractList) cVar).modCount;
                break;
        }
    }

    public void b() {
        if (((AbstractList) ((c) this.f876e)).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        switch (this.f874a) {
            case 0:
                if (this.f875b < ((b) this.f876e).c) {
                }
                break;
            default:
                if (this.f875b < ((c) this.f876e).f881b) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        switch (this.f874a) {
            case 0:
                if (this.f875b > 0) {
                }
                break;
            default:
                if (this.f875b > 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        switch (this.f874a) {
            case 0:
                a();
                int i2 = this.f875b;
                b bVar = (b) this.f876e;
                if (i2 >= bVar.c) {
                    throw new NoSuchElementException();
                }
                this.f875b = i2 + 1;
                this.c = i2;
                return bVar.f877a[bVar.f878b + i2];
            default:
                b();
                int i3 = this.f875b;
                c cVar = (c) this.f876e;
                if (i3 >= cVar.f881b) {
                    throw new NoSuchElementException();
                }
                this.f875b = i3 + 1;
                this.c = i3;
                return cVar.f880a[i3];
        }
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        switch (this.f874a) {
        }
        return this.f875b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        switch (this.f874a) {
            case 0:
                a();
                int i2 = this.f875b;
                if (i2 <= 0) {
                    throw new NoSuchElementException();
                }
                int i3 = i2 - 1;
                this.f875b = i3;
                this.c = i3;
                b bVar = (b) this.f876e;
                return bVar.f877a[bVar.f878b + i3];
            default:
                b();
                int i4 = this.f875b;
                if (i4 <= 0) {
                    throw new NoSuchElementException();
                }
                int i5 = i4 - 1;
                this.f875b = i5;
                this.c = i5;
                return ((c) this.f876e).f880a[i5];
        }
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        int i2;
        switch (this.f874a) {
            case 0:
                i2 = this.f875b;
                break;
            default:
                i2 = this.f875b;
                break;
        }
        return i2 - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        switch (this.f874a) {
            case 0:
                b bVar = (b) this.f876e;
                a();
                int i2 = this.c;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                bVar.b(i2);
                this.f875b = this.c;
                this.c = -1;
                this.d = ((AbstractList) bVar).modCount;
                return;
            default:
                c cVar = (c) this.f876e;
                b();
                int i3 = this.c;
                if (i3 == -1) {
                    throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
                }
                cVar.b(i3);
                this.f875b = this.c;
                this.c = -1;
                this.d = ((AbstractList) cVar).modCount;
                return;
        }
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        switch (this.f874a) {
            case 0:
                a();
                int i2 = this.c;
                if (i2 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((b) this.f876e).set(i2, obj);
                return;
            default:
                b();
                int i3 = this.c;
                if (i3 == -1) {
                    throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
                }
                ((c) this.f876e).set(i3, obj);
                return;
        }
    }

    public a(b bVar, int i2) {
        this.f876e = bVar;
        this.f875b = i2;
        this.d = ((AbstractList) bVar).modCount;
    }
}
