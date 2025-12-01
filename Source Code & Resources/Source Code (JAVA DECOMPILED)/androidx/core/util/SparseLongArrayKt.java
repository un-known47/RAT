package androidx.core.util;

import android.util.SparseLongArray;
import m0.t;
import m0.u;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class SparseLongArrayKt {
    public static final boolean contains(SparseLongArray sparseLongArray, int i2) {
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(SparseLongArray sparseLongArray, int i2) {
        return sparseLongArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(SparseLongArray sparseLongArray, long j) {
        return sparseLongArray.indexOfValue(j) >= 0;
    }

    public static final void forEach(SparseLongArray sparseLongArray, p pVar) {
        int size = sparseLongArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseLongArray.keyAt(i2)), Long.valueOf(sparseLongArray.valueAt(i2)));
        }
    }

    public static final long getOrDefault(SparseLongArray sparseLongArray, int i2, long j) {
        return sparseLongArray.get(i2, j);
    }

    public static final long getOrElse(SparseLongArray sparseLongArray, int i2, y0.a aVar) {
        int iIndexOfKey = sparseLongArray.indexOfKey(i2);
        return iIndexOfKey >= 0 ? sparseLongArray.valueAt(iIndexOfKey) : ((Number) aVar.invoke()).longValue();
    }

    public static final int getSize(SparseLongArray sparseLongArray) {
        return sparseLongArray.size();
    }

    public static final boolean isEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseLongArray sparseLongArray) {
        return sparseLongArray.size() != 0;
    }

    public static final t keyIterator(final SparseLongArray sparseLongArray) {
        return new t() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // m0.t
            public int nextInt() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final SparseLongArray plus(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        SparseLongArray sparseLongArray3 = new SparseLongArray(sparseLongArray2.size() + sparseLongArray.size());
        putAll(sparseLongArray3, sparseLongArray);
        putAll(sparseLongArray3, sparseLongArray2);
        return sparseLongArray3;
    }

    public static final void putAll(SparseLongArray sparseLongArray, SparseLongArray sparseLongArray2) {
        int size = sparseLongArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseLongArray.put(sparseLongArray2.keyAt(i2), sparseLongArray2.valueAt(i2));
        }
    }

    public static final boolean remove(SparseLongArray sparseLongArray, int i2, long j) {
        int iIndexOfKey = sparseLongArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || j != sparseLongArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseLongArray.removeAt(iIndexOfKey);
        return true;
    }

    public static final void set(SparseLongArray sparseLongArray, int i2, long j) {
        sparseLongArray.put(i2, j);
    }

    public static final u valueIterator(final SparseLongArray sparseLongArray) {
        return new u() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseLongArray.size();
            }

            @Override // m0.u
            public long nextLong() {
                SparseLongArray sparseLongArray2 = sparseLongArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseLongArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
