package n0;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
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
public final class c extends f implements RandomAccess, Serializable {
    public static final c d;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f880a;

    /* renamed from: b, reason: collision with root package name */
    public int f881b;
    public boolean c;

    static {
        c cVar = new c(0);
        cVar.c = true;
        d = cVar;
    }

    public c(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        this.f880a = new Object[i2];
    }

    @Override // m0.f
    public final int a() {
        return this.f881b;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        f();
        int i2 = this.f881b;
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f880a[i2] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        j.e(elements, "elements");
        f();
        int size = elements.size();
        d(this.f881b, elements, size);
        return size > 0;
    }

    @Override // m0.f
    public final Object b(int i2) {
        f();
        m0.b bVar = e.Companion;
        int i3 = this.f881b;
        bVar.getClass();
        m0.b.a(i2, i3);
        return h(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        i(0, this.f881b);
    }

    public final void d(int i2, Collection collection, int i3) {
        ((AbstractList) this).modCount++;
        g(i2, i3);
        Iterator it = collection.iterator();
        for (int i4 = 0; i4 < i3; i4++) {
            this.f880a[i2 + i4] = it.next();
        }
    }

    public final void e(int i2, Object obj) {
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f880a[i2] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f880a;
            int i2 = this.f881b;
            if (i2 == list.size()) {
                for (int i3 = 0; i3 < i2; i3++) {
                    if (j.a(objArr[i3], list.get(i3))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void f() {
        if (this.c) {
            throw new UnsupportedOperationException();
        }
    }

    public final void g(int i2, int i3) {
        int i4 = this.f881b + i3;
        if (i4 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f880a;
        if (i4 > objArr.length) {
            m0.b bVar = e.Companion;
            int length = objArr.length;
            bVar.getClass();
            int i5 = length + (length >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            if (i5 - 2147483639 > 0) {
                i5 = i4 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            Object[] objArr2 = this.f880a;
            j.e(objArr2, "<this>");
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, i5);
            j.d(objArrCopyOf, "copyOf(...)");
            this.f880a = objArrCopyOf;
        }
        Object[] objArr3 = this.f880a;
        i.l0(objArr3, objArr3, i2 + i3, i2, this.f881b);
        this.f881b += i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        m0.b bVar = e.Companion;
        int i3 = this.f881b;
        bVar.getClass();
        m0.b.a(i2, i3);
        return this.f880a[i2];
    }

    public final Object h(int i2) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f880a;
        Object obj = objArr[i2];
        i.l0(objArr, objArr, i2, i2 + 1, this.f881b);
        Object[] objArr2 = this.f880a;
        int i3 = this.f881b - 1;
        j.e(objArr2, "<this>");
        objArr2[i3] = null;
        this.f881b--;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f880a;
        int i2 = this.f881b;
        int iHashCode = 1;
        for (int i3 = 0; i3 < i2; i3++) {
            Object obj = objArr[i3];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i(int i2, int i3) {
        if (i3 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f880a;
        i.l0(objArr, objArr, i2, i2 + i3, this.f881b);
        Object[] objArr2 = this.f880a;
        int i4 = this.f881b;
        j.e(objArr2, "<this>");
        for (int i5 = i4 - i3; i5 < i4; i5++) {
            objArr2[i5] = null;
        }
        this.f881b -= i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i2 = 0; i2 < this.f881b; i2++) {
            if (j.a(this.f880a[i2], obj)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f881b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final int j(int i2, int i3, Collection collection, boolean z2) {
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.f880a[i6]) == z2) {
                Object[] objArr = this.f880a;
                i4++;
                objArr[i5 + i2] = objArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        Object[] objArr2 = this.f880a;
        i.l0(objArr2, objArr2, i2 + i5, i3 + i2, this.f881b);
        Object[] objArr3 = this.f880a;
        int i8 = this.f881b;
        j.e(objArr3, "<this>");
        for (int i9 = i8 - i7; i9 < i8; i9++) {
            objArr3[i9] = null;
        }
        if (i7 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f881b -= i7;
        return i7;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i2 = this.f881b - 1; i2 >= 0; i2--) {
            if (j.a(this.f880a[i2], obj)) {
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
        f();
        return j(0, this.f881b, elements, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        j.e(elements, "elements");
        f();
        return j(0, this.f881b, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        f();
        m0.b bVar = e.Companion;
        int i3 = this.f881b;
        bVar.getClass();
        m0.b.a(i2, i3);
        Object[] objArr = this.f880a;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i3) {
        m0.b bVar = e.Companion;
        int i4 = this.f881b;
        bVar.getClass();
        m0.b.c(i2, i3, i4);
        return new b(this.f880a, i2, i3 - i2, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        j.e(array, "array");
        int length = array.length;
        int i2 = this.f881b;
        if (length < i2) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(this.f880a, 0, i2, array.getClass());
            j.d(objArrCopyOfRange, "copyOfRange(...)");
            return objArrCopyOfRange;
        }
        i.l0(this.f880a, array, 0, 0, i2);
        int i3 = this.f881b;
        if (i3 < array.length) {
            array[i3] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return p.a.a(this.f880a, 0, this.f881b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        m0.b bVar = e.Companion;
        int i3 = this.f881b;
        bVar.getClass();
        m0.b.b(i2, i3);
        return new a(this, i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        j.e(elements, "elements");
        f();
        m0.b bVar = e.Companion;
        int i3 = this.f881b;
        bVar.getClass();
        m0.b.b(i2, i3);
        int size = elements.size();
        d(i2, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        f();
        m0.b bVar = e.Companion;
        int i3 = this.f881b;
        bVar.getClass();
        m0.b.b(i2, i3);
        ((AbstractList) this).modCount++;
        g(i2, 1);
        this.f880a[i2] = obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return i.p0(this.f880a, 0, this.f881b);
    }
}
