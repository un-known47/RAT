package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.jvm.internal.j;
import m0.t;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00121<T> implements Iterator<T>, z0.a {
        final /* synthetic */ SparseArray<T> $this_valueIterator;
        private int index;

        public C00121(SparseArray<T> sparseArray) {
            this.$this_valueIterator = sparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray<T> sparseArray = this.$this_valueIterator;
            int i2 = this.index;
            this.index = i2 + 1;
            return sparseArray.valueAt(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <T> boolean contains(SparseArray<T> sparseArray, int i2) {
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i2) {
        return sparseArray.indexOfKey(i2) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t2) {
        return sparseArray.indexOfValue(t2) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, p pVar) {
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i2)), sparseArray.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i2, T t2) {
        T t3 = sparseArray.get(i2);
        return t3 == null ? t2 : t3;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i2, y0.a aVar) {
        T t2 = sparseArray.get(i2);
        return t2 == null ? (T) aVar.invoke() : t2;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        return sparseArray.size() != 0;
    }

    public static final <T> t keyIterator(final SparseArray<T> sparseArray) {
        return new t() { // from class: androidx.core.util.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // m0.t
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseArray.put(sparseArray2.keyAt(i2), sparseArray2.valueAt(i2));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i2, T t2) {
        int iIndexOfKey = sparseArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || !j.a(t2, sparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        sparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i2, T t2) {
        sparseArray.put(i2, t2);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        return new C00121(sparseArray);
    }
}
