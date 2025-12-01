package n0;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.j;
import m0.e;
import m0.f;
import m0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends f implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f877a;

    /* renamed from: b, reason: collision with root package name */
    public final int f878b;
    public int c;
    public final b d;

    /* renamed from: e, reason: collision with root package name */
    public final c f879e;

    public b(Object[] backing, int i2, int i3, b bVar, c root) {
        j.e(backing, "backing");
        j.e(root, "root");
        this.f877a = backing;
        this.f878b = i2;
        this.c = i3;
        this.d = bVar;
        this.f879e = root;
        ((AbstractList) this).modCount = ((AbstractList) root).modCount;
    }

    @Override // m0.f
    public final int a() {
        f();
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        g();
        f();
        e(this.f878b + this.c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        j.e(elements, "elements");
        g();
        f();
        int size = elements.size();
        d(this.f878b + this.c, elements, size);
        return size > 0;
    }

    @Override // m0.f
    public final Object b(int i2) {
        g();
        f();
        m0.b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        m0.b.a(i2, i3);
        return h(this.f878b + i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        g();
        f();
        i(this.f878b, this.c);
    }

    public final void d(int i2, Collection collection, int i3) {
        ((AbstractList) this).modCount++;
        c cVar = this.f879e;
        b bVar = this.d;
        if (bVar != null) {
            bVar.d(i2, collection, i3);
        } else {
            c cVar2 = c.d;
            cVar.d(i2, collection, i3);
        }
        this.f877a = cVar.f880a;
        this.c += i3;
    }

    public final void e(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.f879e;
        b bVar = this.d;
        if (bVar != null) {
            bVar.e(i2, obj);
        } else {
            c cVar2 = c.d;
            cVar.e(i2, obj);
        }
        this.f877a = cVar.f880a;
        this.c++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        f();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f877a;
            int i2 = this.c;
            if (i2 == list.size()) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (j.a(objArr[this.f878b + i3], list.get(i3))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (((AbstractList) this.f879e).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void g() {
        if (this.f879e.c) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        f();
        m0.b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        m0.b.a(i2, i3);
        return this.f877a[this.f878b + i2];
    }

    public final Object h(int i2) {
        Object objH;
        ((AbstractList) this).modCount++;
        b bVar = this.d;
        if (bVar != null) {
            objH = bVar.h(i2);
        } else {
            c cVar = c.d;
            objH = this.f879e.h(i2);
        }
        this.c--;
        return objH;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        f();
        Object[] objArr = this.f877a;
        int i2 = this.c;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[this.f878b + i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i2, int i3) {
        if (i3 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.i(i2, i3);
        } else {
            c cVar = c.d;
            this.f879e.i(i2, i3);
        }
        this.c -= i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        f();
        for (int i2 = 0; i2 < this.c; i2++) {
            if (j.a(this.f877a[this.f878b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        f();
        return this.c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i2, int i3, Collection collection, boolean z2) {
        int iJ;
        b bVar = this.d;
        if (bVar != null) {
            iJ = bVar.j(i2, i3, collection, z2);
        } else {
            c cVar = c.d;
            iJ = this.f879e.j(i2, i3, collection, z2);
        }
        if (iJ > 0) {
            ((AbstractList) this).modCount++;
        }
        this.c -= iJ;
        return iJ;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        f();
        for (int i2 = this.c - 1; i2 >= 0; i2--) {
            if (j.a(this.f877a[this.f878b + i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        g();
        f();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            b(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        j.e(elements, "elements");
        g();
        f();
        return j(this.f878b, this.c, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        j.e(elements, "elements");
        g();
        f();
        return j(this.f878b, this.c, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        g();
        f();
        m0.b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        m0.b.a(i2, i3);
        Object[] objArr = this.f877a;
        int i4 = this.f878b + i2;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i3) {
        m0.b bVar = e.Companion;
        int i4 = this.c;
        bVar.getClass();
        m0.b.c(i2, i3, i4);
        return new b(this.f877a, this.f878b + i2, i3 - i2, this, this.f879e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        j.e(array, "array");
        f();
        int length = array.length;
        int i2 = this.c;
        int i3 = this.f878b;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f877a, i3, i2 + i3, array.getClass());
            j.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        i.l0(this.f877a, array, 0, i3, i2 + i3);
        int i4 = this.c;
        if (i4 < array.length) {
            array[i4] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return p.a.a(this.f877a, this.f878b, this.c, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        f();
        m0.b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        m0.b.b(i2, i3);
        return new a(this, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        g();
        f();
        m0.b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        m0.b.b(i2, i3);
        e(this.f878b + i2, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        j.e(elements, "elements");
        g();
        f();
        m0.b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        m0.b.b(i2, i3);
        int size = elements.size();
        d(this.f878b + i2, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        f();
        Object[] objArr = this.f877a;
        int i2 = this.c;
        int i3 = this.f878b;
        return i.p0(objArr, i3, i2 + i3);
    }
}
