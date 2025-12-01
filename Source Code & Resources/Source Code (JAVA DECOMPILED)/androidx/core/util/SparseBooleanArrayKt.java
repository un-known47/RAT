package androidx.core.util;

import android.util.SparseBooleanArray;
import m0.j;
import m0.t;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(SparseBooleanArray sparseBooleanArray, int i2) {
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsKey(SparseBooleanArray sparseBooleanArray, int i2) {
        return sparseBooleanArray.indexOfKey(i2) >= 0;
    }

    public static final boolean containsValue(SparseBooleanArray sparseBooleanArray, boolean z2) {
        return sparseBooleanArray.indexOfValue(z2) >= 0;
    }

    public static final void forEach(SparseBooleanArray sparseBooleanArray, p pVar) {
        int size = sparseBooleanArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            pVar.invoke(Integer.valueOf(sparseBooleanArray.keyAt(i2)), Boolean.valueOf(sparseBooleanArray.valueAt(i2)));
        }
    }

    public static final boolean getOrDefault(SparseBooleanArray sparseBooleanArray, int i2, boolean z2) {
        return sparseBooleanArray.get(i2, z2);
    }

    public static final boolean getOrElse(SparseBooleanArray sparseBooleanArray, int i2, y0.a aVar) {
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i2);
        return iIndexOfKey >= 0 ? sparseBooleanArray.valueAt(iIndexOfKey) : ((Boolean) aVar.invoke()).booleanValue();
    }

    public static final int getSize(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size();
    }

    public static final boolean isEmpty(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() == 0;
    }

    public static final boolean isNotEmpty(SparseBooleanArray sparseBooleanArray) {
        return sparseBooleanArray.size() != 0;
    }

    public static final t keyIterator(final SparseBooleanArray sparseBooleanArray) {
        return new t() { // from class: androidx.core.util.SparseBooleanArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // m0.t
            public int nextInt() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.keyAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }

    public static final SparseBooleanArray plus(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        SparseBooleanArray sparseBooleanArray3 = new SparseBooleanArray(sparseBooleanArray2.size() + sparseBooleanArray.size());
        putAll(sparseBooleanArray3, sparseBooleanArray);
        putAll(sparseBooleanArray3, sparseBooleanArray2);
        return sparseBooleanArray3;
    }

    public static final void putAll(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
        int size = sparseBooleanArray2.size();
        for (int i2 = 0; i2 < size; i2++) {
            sparseBooleanArray.put(sparseBooleanArray2.keyAt(i2), sparseBooleanArray2.valueAt(i2));
        }
    }

    public static final boolean remove(SparseBooleanArray sparseBooleanArray, int i2, boolean z2) {
        int iIndexOfKey = sparseBooleanArray.indexOfKey(i2);
        if (iIndexOfKey < 0 || z2 != sparseBooleanArray.valueAt(iIndexOfKey)) {
            return false;
        }
        sparseBooleanArray.delete(i2);
        return true;
    }

    public static final void set(SparseBooleanArray sparseBooleanArray, int i2, boolean z2) {
        sparseBooleanArray.put(i2, z2);
    }

    public static final j valueIterator(final SparseBooleanArray sparseBooleanArray) {
        return new j() { // from class: androidx.core.util.SparseBooleanArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseBooleanArray.size();
            }

            @Override // m0.j
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray2 = sparseBooleanArray;
                int i2 = this.index;
                this.index = i2 + 1;
                return sparseBooleanArray2.valueAt(i2);
            }

            public final void setIndex(int i2) {
                this.index = i2;
            }
        };
    }
}
