package m0;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h extends f {
    public static final Object[] d = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f864a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f865b = d;
    public int c;

    @Override // m0.f
    public final int a() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        i();
        d(elements.size() + a());
        c(h(a() + this.f864a), elements);
        return true;
    }

    public final void addFirst(Object obj) {
        i();
        d(this.c + 1);
        int length = this.f864a;
        if (length == 0) {
            Object[] objArr = this.f865b;
            kotlin.jvm.internal.j.e(objArr, "<this>");
            length = objArr.length;
        }
        int i2 = length - 1;
        this.f864a = i2;
        this.f865b[i2] = obj;
        this.c++;
    }

    public final void addLast(Object obj) {
        i();
        d(a() + 1);
        this.f865b[h(a() + this.f864a)] = obj;
        this.c = a() + 1;
    }

    @Override // m0.f
    public final Object b(int i2) {
        b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        b.a(i2, i3);
        if (i2 == l.g0(this)) {
            return removeLast();
        }
        if (i2 == 0) {
            return removeFirst();
        }
        i();
        int iH = h(this.f864a + i2);
        Object[] objArr = this.f865b;
        Object obj = objArr[iH];
        if (i2 < (this.c >> 1)) {
            int i4 = this.f864a;
            if (iH >= i4) {
                i.l0(objArr, objArr, i4 + 1, i4, iH);
            } else {
                i.l0(objArr, objArr, 1, 0, iH);
                Object[] objArr2 = this.f865b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i5 = this.f864a;
                i.l0(objArr2, objArr2, i5 + 1, i5, objArr2.length - 1);
            }
            Object[] objArr3 = this.f865b;
            int i6 = this.f864a;
            objArr3[i6] = null;
            this.f864a = e(i6);
        } else {
            int iH2 = h(l.g0(this) + this.f864a);
            if (iH <= iH2) {
                Object[] objArr4 = this.f865b;
                i.l0(objArr4, objArr4, iH, iH + 1, iH2 + 1);
            } else {
                Object[] objArr5 = this.f865b;
                i.l0(objArr5, objArr5, iH, iH + 1, objArr5.length);
                Object[] objArr6 = this.f865b;
                objArr6[objArr6.length - 1] = objArr6[0];
                i.l0(objArr6, objArr6, 0, 1, iH2 + 1);
            }
            this.f865b[iH2] = null;
        }
        this.c--;
        return obj;
    }

    public final void c(int i2, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f865b.length;
        while (i2 < length && it.hasNext()) {
            this.f865b[i2] = it.next();
            i2++;
        }
        int i3 = this.f864a;
        for (int i4 = 0; i4 < i3 && it.hasNext(); i4++) {
            this.f865b[i4] = it.next();
        }
        this.c = collection.size() + this.c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            i();
            g(this.f864a, h(a() + this.f864a));
        }
        this.f864a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(int i2) {
        if (i2 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f865b;
        if (i2 <= objArr.length) {
            return;
        }
        if (objArr == d) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f865b = new Object[i2];
            return;
        }
        b bVar = e.Companion;
        int length = objArr.length;
        bVar.getClass();
        int i3 = length + (length >> 1);
        if (i3 - i2 < 0) {
            i3 = i2;
        }
        if (i3 - 2147483639 > 0) {
            i3 = i2 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
        }
        Object[] objArr2 = new Object[i3];
        Object[] objArr3 = this.f865b;
        i.l0(objArr3, objArr2, 0, this.f864a, objArr3.length);
        Object[] objArr4 = this.f865b;
        int length2 = objArr4.length;
        int i4 = this.f864a;
        i.l0(objArr4, objArr2, length2 - i4, 0, i4);
        this.f864a = 0;
        this.f865b = objArr2;
    }

    public final int e(int i2) {
        kotlin.jvm.internal.j.e(this.f865b, "<this>");
        if (i2 == r0.length - 1) {
            return 0;
        }
        return i2 + 1;
    }

    public final int f(int i2) {
        return i2 < 0 ? i2 + this.f865b.length : i2;
    }

    public final void g(int i2, int i3) {
        if (i2 < i3) {
            i.q0(this.f865b, i2, i3);
            return;
        }
        Object[] objArr = this.f865b;
        i.q0(objArr, i2, objArr.length);
        i.q0(this.f865b, 0, i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i2) {
        b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        b.a(i2, i3);
        return this.f865b[h(this.f864a + i2)];
    }

    public final int h(int i2) {
        Object[] objArr = this.f865b;
        return i2 >= objArr.length ? i2 - objArr.length : i2;
    }

    public final void i() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i2;
        int iH = h(a() + this.f864a);
        int length = this.f864a;
        if (length < iH) {
            while (length < iH) {
                if (kotlin.jvm.internal.j.a(obj, this.f865b[length])) {
                    i2 = this.f864a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iH) {
            return -1;
        }
        int length2 = this.f865b.length;
        while (true) {
            if (length >= length2) {
                for (int i3 = 0; i3 < iH; i3++) {
                    if (kotlin.jvm.internal.j.a(obj, this.f865b[i3])) {
                        length = i3 + this.f865b.length;
                        i2 = this.f864a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.j.a(obj, this.f865b[length])) {
                i2 = this.f864a;
                break;
            }
            length++;
        }
        return length - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return a() == 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i2;
        int iH = h(this.c + this.f864a);
        int i3 = this.f864a;
        if (i3 < iH) {
            length = iH - 1;
            if (i3 <= length) {
                while (!kotlin.jvm.internal.j.a(obj, this.f865b[length])) {
                    if (length != i3) {
                        length--;
                    }
                }
                i2 = this.f864a;
                return length - i2;
            }
            return -1;
        }
        if (i3 > iH) {
            int i4 = iH - 1;
            while (true) {
                if (-1 >= i4) {
                    Object[] objArr = this.f865b;
                    kotlin.jvm.internal.j.e(objArr, "<this>");
                    length = objArr.length - 1;
                    int i5 = this.f864a;
                    if (i5 <= length) {
                        while (!kotlin.jvm.internal.j.a(obj, this.f865b[length])) {
                            if (length != i5) {
                                length--;
                            }
                        }
                        i2 = this.f864a;
                    }
                } else {
                    if (kotlin.jvm.internal.j.a(obj, this.f865b[i4])) {
                        length = i4 + this.f865b.length;
                        i2 = this.f864a;
                        break;
                    }
                    i4--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        b(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int iH;
        kotlin.jvm.internal.j.e(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f865b.length != 0) {
            int iH2 = h(this.c + this.f864a);
            int i2 = this.f864a;
            if (i2 < iH2) {
                iH = i2;
                while (i2 < iH2) {
                    Object obj = this.f865b[i2];
                    if (elements.contains(obj)) {
                        z2 = true;
                    } else {
                        this.f865b[iH] = obj;
                        iH++;
                    }
                    i2++;
                }
                i.q0(this.f865b, iH, iH2);
            } else {
                int length = this.f865b.length;
                int i3 = i2;
                boolean z3 = false;
                while (i2 < length) {
                    Object[] objArr = this.f865b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (elements.contains(obj2)) {
                        z3 = true;
                    } else {
                        this.f865b[i3] = obj2;
                        i3++;
                    }
                    i2++;
                }
                iH = h(i3);
                for (int i4 = 0; i4 < iH2; i4++) {
                    Object[] objArr2 = this.f865b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj3)) {
                        z3 = true;
                    } else {
                        this.f865b[iH] = obj3;
                        iH = e(iH);
                    }
                }
                z2 = z3;
            }
            if (z2) {
                i();
                this.c = f(iH - this.f864a);
            }
        }
        return z2;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        i();
        Object[] objArr = this.f865b;
        int i2 = this.f864a;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.f864a = e(i2);
        this.c = a() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        i();
        int iH = h(l.g0(this) + this.f864a);
        Object[] objArr = this.f865b;
        Object obj = objArr[iH];
        objArr[iH] = null;
        this.c = a() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        b bVar = e.Companion;
        int i4 = this.c;
        bVar.getClass();
        b.c(i2, i3, i4);
        int i5 = i3 - i2;
        if (i5 == 0) {
            return;
        }
        if (i5 == this.c) {
            clear();
            return;
        }
        if (i5 == 1) {
            b(i2);
            return;
        }
        i();
        if (i2 < this.c - i3) {
            int iH = h(this.f864a + (i2 - 1));
            int iH2 = h(this.f864a + (i3 - 1));
            while (i2 > 0) {
                int i6 = iH + 1;
                int iMin = Math.min(i2, Math.min(i6, iH2 + 1));
                Object[] objArr = this.f865b;
                int i7 = iH2 - iMin;
                int i8 = iH - iMin;
                i.l0(objArr, objArr, i7 + 1, i8 + 1, i6);
                iH = f(i8);
                iH2 = f(i7);
                i2 -= iMin;
            }
            int iH3 = h(this.f864a + i5);
            g(this.f864a, iH3);
            this.f864a = iH3;
        } else {
            int iH4 = h(this.f864a + i3);
            int iH5 = h(this.f864a + i2);
            int i9 = this.c;
            while (true) {
                i9 -= i3;
                if (i9 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f865b;
                i3 = Math.min(i9, Math.min(objArr2.length - iH4, objArr2.length - iH5));
                Object[] objArr3 = this.f865b;
                int i10 = iH4 + i3;
                i.l0(objArr3, objArr3, iH5, iH4, i10);
                iH4 = h(i10);
                iH5 = h(iH5 + i3);
            }
            int iH6 = h(this.c + this.f864a);
            g(f(iH6 - i5), iH6);
        }
        this.c -= i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int iH;
        kotlin.jvm.internal.j.e(elements, "elements");
        boolean z2 = false;
        z2 = false;
        z2 = false;
        if (!isEmpty() && this.f865b.length != 0) {
            int iH2 = h(this.c + this.f864a);
            int i2 = this.f864a;
            if (i2 < iH2) {
                iH = i2;
                while (i2 < iH2) {
                    Object obj = this.f865b[i2];
                    if (elements.contains(obj)) {
                        this.f865b[iH] = obj;
                        iH++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                i.q0(this.f865b, iH, iH2);
            } else {
                int length = this.f865b.length;
                int i3 = i2;
                boolean z3 = false;
                while (i2 < length) {
                    Object[] objArr = this.f865b;
                    Object obj2 = objArr[i2];
                    objArr[i2] = null;
                    if (elements.contains(obj2)) {
                        this.f865b[i3] = obj2;
                        i3++;
                    } else {
                        z3 = true;
                    }
                    i2++;
                }
                iH = h(i3);
                for (int i4 = 0; i4 < iH2; i4++) {
                    Object[] objArr2 = this.f865b;
                    Object obj3 = objArr2[i4];
                    objArr2[i4] = null;
                    if (elements.contains(obj3)) {
                        this.f865b[iH] = obj3;
                        iH = e(iH);
                    } else {
                        z3 = true;
                    }
                }
                z2 = z3;
            }
            if (z2) {
                i();
                this.c = f(iH - this.f864a);
            }
        }
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i2, Object obj) {
        b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        b.a(i2, i3);
        int iH = h(this.f864a + i2);
        Object[] objArr = this.f865b;
        Object obj2 = objArr[iH];
        objArr[iH] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, Object obj) {
        int length;
        b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        b.b(i2, i3);
        if (i2 == this.c) {
            addLast(obj);
            return;
        }
        if (i2 == 0) {
            addFirst(obj);
            return;
        }
        i();
        d(this.c + 1);
        int iH = h(this.f864a + i2);
        int i4 = this.c;
        if (i2 < ((i4 + 1) >> 1)) {
            if (iH == 0) {
                Object[] objArr = this.f865b;
                kotlin.jvm.internal.j.e(objArr, "<this>");
                iH = objArr.length;
            }
            int i5 = iH - 1;
            int i6 = this.f864a;
            if (i6 == 0) {
                Object[] objArr2 = this.f865b;
                kotlin.jvm.internal.j.e(objArr2, "<this>");
                length = objArr2.length - 1;
            } else {
                length = i6 - 1;
            }
            int i7 = this.f864a;
            if (i5 >= i7) {
                Object[] objArr3 = this.f865b;
                objArr3[length] = objArr3[i7];
                i.l0(objArr3, objArr3, i7, i7 + 1, i5 + 1);
            } else {
                Object[] objArr4 = this.f865b;
                i.l0(objArr4, objArr4, i7 - 1, i7, objArr4.length);
                Object[] objArr5 = this.f865b;
                objArr5[objArr5.length - 1] = objArr5[0];
                i.l0(objArr5, objArr5, 0, 1, i5 + 1);
            }
            this.f865b[i5] = obj;
            this.f864a = length;
        } else {
            int iH2 = h(i4 + this.f864a);
            if (iH < iH2) {
                Object[] objArr6 = this.f865b;
                i.l0(objArr6, objArr6, iH + 1, iH, iH2);
            } else {
                Object[] objArr7 = this.f865b;
                i.l0(objArr7, objArr7, 1, 0, iH2);
                Object[] objArr8 = this.f865b;
                objArr8[0] = objArr8[objArr8.length - 1];
                i.l0(objArr8, objArr8, iH + 1, iH, objArr8.length - 1);
            }
            this.f865b[iH] = obj;
        }
        this.c++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) throws NegativeArraySizeException {
        kotlin.jvm.internal.j.e(array, "array");
        int length = array.length;
        int i2 = this.c;
        if (length < i2) {
            Object objNewInstance = Array.newInstance(array.getClass().getComponentType(), i2);
            kotlin.jvm.internal.j.c(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) objNewInstance;
        }
        Object[] objArr = array;
        int iH = h(this.c + this.f864a);
        int i3 = this.f864a;
        if (i3 < iH) {
            i.n0(this.f865b, objArr, 0, i3, iH, 2);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f865b;
            i.l0(objArr2, objArr, 0, this.f864a, objArr2.length);
            Object[] objArr3 = this.f865b;
            i.l0(objArr3, objArr, objArr3.length - this.f864a, 0, iH);
        }
        int i4 = this.c;
        if (i4 < objArr.length) {
            objArr[i4] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection elements) {
        kotlin.jvm.internal.j.e(elements, "elements");
        b bVar = e.Companion;
        int i3 = this.c;
        bVar.getClass();
        b.b(i2, i3);
        if (elements.isEmpty()) {
            return false;
        }
        if (i2 == this.c) {
            return addAll(elements);
        }
        i();
        d(elements.size() + this.c);
        int iH = h(this.c + this.f864a);
        int iH2 = h(this.f864a + i2);
        int size = elements.size();
        if (i2 < ((this.c + 1) >> 1)) {
            int i4 = this.f864a;
            int length = i4 - size;
            if (iH2 < i4) {
                Object[] objArr = this.f865b;
                i.l0(objArr, objArr, length, i4, objArr.length);
                if (size >= iH2) {
                    Object[] objArr2 = this.f865b;
                    i.l0(objArr2, objArr2, objArr2.length - size, 0, iH2);
                } else {
                    Object[] objArr3 = this.f865b;
                    i.l0(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f865b;
                    i.l0(objArr4, objArr4, 0, size, iH2);
                }
            } else if (length >= 0) {
                Object[] objArr5 = this.f865b;
                i.l0(objArr5, objArr5, length, i4, iH2);
            } else {
                Object[] objArr6 = this.f865b;
                length += objArr6.length;
                int i5 = iH2 - i4;
                int length2 = objArr6.length - length;
                if (length2 >= i5) {
                    i.l0(objArr6, objArr6, length, i4, iH2);
                } else {
                    i.l0(objArr6, objArr6, length, i4, i4 + length2);
                    Object[] objArr7 = this.f865b;
                    i.l0(objArr7, objArr7, 0, this.f864a + length2, iH2);
                }
            }
            this.f864a = length;
            c(f(iH2 - size), elements);
            return true;
        }
        int i6 = iH2 + size;
        if (iH2 < iH) {
            int i7 = size + iH;
            Object[] objArr8 = this.f865b;
            if (i7 <= objArr8.length) {
                i.l0(objArr8, objArr8, i6, iH2, iH);
            } else if (i6 >= objArr8.length) {
                i.l0(objArr8, objArr8, i6 - objArr8.length, iH2, iH);
            } else {
                int length3 = iH - (i7 - objArr8.length);
                i.l0(objArr8, objArr8, 0, length3, iH);
                Object[] objArr9 = this.f865b;
                i.l0(objArr9, objArr9, i6, iH2, length3);
            }
        } else {
            Object[] objArr10 = this.f865b;
            i.l0(objArr10, objArr10, size, 0, iH);
            Object[] objArr11 = this.f865b;
            if (i6 >= objArr11.length) {
                i.l0(objArr11, objArr11, i6 - objArr11.length, iH2, objArr11.length);
            } else {
                i.l0(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                Object[] objArr12 = this.f865b;
                i.l0(objArr12, objArr12, i6, iH2, objArr12.length - size);
            }
        }
        c(iH2, elements);
        return true;
    }
}
