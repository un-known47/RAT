package androidx.collection;

import java.util.Iterator;
import kotlin.jvm.internal.j;
import m0.t;
import y0.p;
import z0.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.collection.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00071<T> implements Iterator<T>, a {
        final /* synthetic */ SparseArrayCompat<T> $this_valueIterator;
        private int index;

        public C00071(SparseArrayCompat<T> sparseArrayCompat) {
            this.$this_valueIterator = sparseArrayCompat;
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
            SparseArrayCompat<T> sparseArrayCompat = this.$this_valueIterator;
            int i2 = this.index;
            this.index = i2 + 1;
            return sparseArrayCompat.valueAt(i2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int i2) {
            this.index = i2;
        }
    }

    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i2) {
        j.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.containsKey(i2);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, p action) {
        j.e(sparseArrayCompat, "<this>");
        j.e(action, "action");
        int size = sparseArrayCompat.size();
        for (int i2 = 0; i2 < size; i2++) {
            action.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i2)), sparseArrayCompat.valueAt(i2));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i2, T t2) {
        j.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.get(i2, t2);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i2, y0.a defaultValue) {
        j.e(sparseArrayCompat, "<this>");
        j.e(defaultValue, "defaultValue");
        T t2 = sparseArrayCompat.get(i2);
        return t2 == null ? (T) defaultValue.invoke() : t2;
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        j.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        j.e(sparseArrayCompat, "<this>");
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> t keyIterator(final SparseArrayCompat<T> sparseArrayCompat) {
        j.e(sparseArrayCompat, "<this>");
        return new t() { // from class: androidx.collection.SparseArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            @Override // m0.t
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseArrayCompat2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> other) {
        j.e(sparseArrayCompat, "<this>");
        j.e(other, "other");
        SparseArrayCompat<T> sparseArrayCompat2 = new SparseArrayCompat<>(other.size() + sparseArrayCompat.size());
        sparseArrayCompat2.putAll(sparseArrayCompat);
        sparseArrayCompat2.putAll(other);
        return sparseArrayCompat2;
    }

    public static final /* synthetic */ boolean remove(SparseArrayCompat sparseArrayCompat, int i2, Object obj) {
        j.e(sparseArrayCompat, "<this>");
        return sparseArrayCompat.remove(i2, obj);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i2, T t2) {
        j.e(sparseArrayCompat, "<this>");
        sparseArrayCompat.put(i2, t2);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        j.e(sparseArrayCompat, "<this>");
        return new C00071(sparseArrayCompat);
    }
}
