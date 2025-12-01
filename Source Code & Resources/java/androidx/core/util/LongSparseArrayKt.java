package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.jvm.internal.j;
import m0.u;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00111<T> implements Iterator<T>, z0.a {
        final /* synthetic */ LongSparseArray<T> $this_valueIterator;
        private int index;

        public C00111(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
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
            LongSparseArray<T> longSparseArray = this.$this_valueIterator;
            int i2 = this.index;
            this.index = i2 + 1;
            return longSparseArray.valueAt(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        return longSparseArray.indexOfKey(j) >= 0;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> longSparseArray, long j) {
        return longSparseArray.indexOfKey(j) >= 0;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> longSparseArray, T t2) {
        return longSparseArray.indexOfValue(t2) >= 0;
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i2)), longSparseArray.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t2) {
        T t3 = longSparseArray.get(j);
        return t3 == null ? t2 : t3;
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, y0.a aVar) {
        T t2 = longSparseArray.get(j);
        return t2 == null ? (T) aVar.invoke() : t2;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        return longSparseArray.size() != 0;
    }

    public static final <T> u keyIterator(final LongSparseArray<T> longSparseArray) {
        return new u() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // m0.u
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return longSparseArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        putAll(longSparseArray3, longSparseArray);
        putAll(longSparseArray3, longSparseArray2);
        return longSparseArray3;
    }

    public static final <T> void putAll(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        int size = longSparseArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            longSparseArray.put(longSparseArray2.keyAt(i2), longSparseArray2.valueAt(i2));
        }
    }

    public static final <T> boolean remove(LongSparseArray<T> longSparseArray, long j, T t2) {
        int iIndexOfKey = longSparseArray.indexOfKey(j);
        if (iIndexOfKey < 0 || !j.a(t2, longSparseArray.valueAt(iIndexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t2) {
        longSparseArray.put(j, t2);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        return new C00111(longSparseArray);
    }
}
