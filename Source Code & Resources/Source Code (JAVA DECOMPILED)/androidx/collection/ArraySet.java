package androidx.collection;

import androidx.appcompat.app.g;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import m0.i;
import m0.k;
import z0.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, a {
    private int _size;
    private Object[] array;
    private int[] hashes;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int i2) {
            return ArraySet.this.valueAt(i2);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int i2) {
            ArraySet.this.removeAt(i2);
        }
    }

    public ArraySet() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int iIndexOf;
        int i3 = get_size$collection();
        if (e2 == null) {
            iIndexOf = ArraySetKt.indexOfNull(this);
            i2 = 0;
        } else {
            int iHashCode = e2.hashCode();
            i2 = iHashCode;
            iIndexOf = ArraySetKt.indexOf(this, e2, iHashCode);
        }
        if (iIndexOf >= 0) {
            return false;
        }
        int i4 = ~iIndexOf;
        if (i3 >= getHashes$collection().length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i5);
            if (i3 != get_size$collection()) {
                throw new ConcurrentModificationException();
            }
            if (getHashes$collection().length != 0) {
                i.m0(0, hashes$collection.length, hashes$collection, getHashes$collection(), 6);
                i.n0(array$collection, getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i4 < i3) {
            int i6 = i4 + 1;
            i.i0(i6, i4, getHashes$collection(), getHashes$collection(), i3);
            i.l0(getArray$collection(), getArray$collection(), i6, i4, i3);
        }
        if (i3 != get_size$collection() || i4 >= getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        getHashes$collection()[i4] = i2;
        getArray$collection()[i4] = e2;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    public final void addAll(ArraySet<? extends E> array) {
        j.e(array, "array");
        int i2 = array.get_size$collection();
        ensureCapacity(get_size$collection() + i2);
        if (get_size$collection() != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                add(array.valueAt(i3));
            }
        } else if (i2 > 0) {
            i.m0(0, i2, array.getHashes$collection(), getHashes$collection(), 6);
            i.n0(array.getArray$collection(), getArray$collection(), 0, 0, i2, 6);
            if (get_size$collection() != 0) {
                throw new ConcurrentModificationException();
            }
            set_size$collection(i2);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        j.e(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int i2) {
        int i3 = get_size$collection();
        if (getHashes$collection().length < i2) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i2);
            if (get_size$collection() > 0) {
                i.m0(0, get_size$collection(), hashes$collection, getHashes$collection(), 6);
                i.n0(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6);
            }
        }
        if (get_size$collection() != i3) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i2 = get_size$collection();
            for (int i3 = 0; i3 < i2; i3++) {
                if (!((Set) obj).contains(valueAt(i3))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i2 = get_size$collection();
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += hashes$collection[i4];
        }
        return i3;
    }

    public final int indexOf(Object obj) {
        return obj == null ? ArraySetKt.indexOfNull(this) : ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return get_size$collection() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(ArraySet<? extends E> array) {
        j.e(array, "array");
        int i2 = array.get_size$collection();
        int i3 = get_size$collection();
        for (int i4 = 0; i4 < i2; i4++) {
            remove(array.valueAt(i4));
        }
        return i3 != get_size$collection();
    }

    public final E removeAt(int i2) {
        int i3;
        int i4 = get_size$collection();
        E e2 = (E) getArray$collection()[i2];
        if (i4 <= 1) {
            clear();
            return e2;
        }
        int i5 = i4 - 1;
        if (getHashes$collection().length <= 8 || get_size$collection() >= getHashes$collection().length / 3) {
            if (i2 < i5) {
                int i6 = i2 + 1;
                i.i0(i2, i6, getHashes$collection(), getHashes$collection(), i4);
                i.l0(getArray$collection(), getArray$collection(), i2, i6, i4);
            }
            getArray$collection()[i5] = null;
        } else {
            int i7 = get_size$collection() > 8 ? get_size$collection() + (get_size$collection() >> 1) : 8;
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i7);
            if (i2 > 0) {
                i.m0(0, i2, hashes$collection, getHashes$collection(), 6);
                i3 = i2;
                i.n0(array$collection, getArray$collection(), 0, 0, i3, 6);
            } else {
                i3 = i2;
            }
            if (i3 < i5) {
                int i8 = i3 + 1;
                i.i0(i3, i8, hashes$collection, getHashes$collection(), i4);
                i.l0(array$collection, getArray$collection(), i3, i8, i4);
            }
        }
        if (i4 != get_size$collection()) {
            throw new ConcurrentModificationException();
        }
        set_size$collection(i5);
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        j.e(elements, "elements");
        boolean z2 = false;
        for (int i2 = get_size$collection() - 1; -1 < i2; i2--) {
            if (!k.n0(elements, getArray$collection()[i2])) {
                removeAt(i2);
                z2 = true;
            }
        }
        return z2;
    }

    public final void setArray$collection(Object[] objArr) {
        j.e(objArr, "<set-?>");
        this.array = objArr;
    }

    public final void setHashes$collection(int[] iArr) {
        j.e(iArr, "<set-?>");
        this.hashes = iArr;
    }

    public final void set_size$collection(int i2) {
        this._size = i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return i.p0(this.array, 0, this._size);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i2 = get_size$collection();
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            E eValueAt = valueAt(i3);
            if (eValueAt != this) {
                sb.append(eValueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        return g.j(sb, '}', "StringBuilder(capacity).…builderAction).toString()");
    }

    public final E valueAt(int i2) {
        return (E) getArray$collection()[i2];
    }

    public ArraySet(int i2) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i2 > 0) {
            ArraySetKt.allocArrays(this, i2);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] array) {
        j.e(array, "array");
        T[] tArr = (T[]) ArraySetJvmUtil.resizeForToArray(array, this._size);
        i.l0(this.array, tArr, 0, 0, this._size);
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        j.e(elements, "elements");
        Iterator<? extends Object> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    public /* synthetic */ ArraySet(int i2, int i3, e eVar) {
        this((i3 & 1) != 0 ? 0 : i2);
    }

    public ArraySet(ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> elements) {
        j.e(elements, "elements");
        ensureCapacity(elements.size() + get_size$collection());
        Iterator<? extends E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public ArraySet(E[] eArr) {
        this(0);
        if (eArr == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (!(i2 < eArr.length)) {
                return;
            }
            int i3 = i2 + 1;
            try {
                add(eArr[i2]);
                i2 = i3;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new NoSuchElementException(e2.getMessage());
            }
        }
    }
}
