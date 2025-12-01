package androidx.collection;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import m0.i;
import y0.a;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MutableIntIntMap extends IntIntMap {
    private int growthLimit;

    public MutableIntIntMap() {
        this(0, 1, null);
    }

    private final void adjustStorage() {
        int i2 = this._capacity;
        if (i2 <= 8 || Long.compare((this._size * 32) ^ Long.MIN_VALUE, (i2 * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findFirstAvailableSlot(int i2) {
        int i3 = this._capacity;
        int i4 = i2 & i3;
        int i5 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-i7) >> 63)) | (jArr[i6] >>> i7);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i4 + (Long.numberOfTrailingZeros(j2) >> 3)) & i3;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
    }

    private final int findInsertIndex(int i2) {
        int i3 = ScatterMapKt.MurmurHashC1 * i2;
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 >>> 7;
        int i6 = i4 & 127;
        int i7 = this._capacity;
        int i8 = i5 & i7;
        int i9 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            long j = ((jArr[i10 + 1] << (64 - i11)) & ((-i11) >> 63)) | (jArr[i10] >>> i11);
            long j2 = i6;
            int i12 = i9;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = (i8 + (Long.numberOfTrailingZeros(j4) >> 3)) & i7;
                if (this.keys[iNumberOfTrailingZeros] == i2) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i5);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i5);
                }
                this._size++;
                int i13 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i14 = iFindFirstAvailableSlot >> 3;
                long j5 = jArr2[i14];
                int i15 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i13 - (((j5 >> i15) & 255) == 128 ? 1 : 0);
                jArr2[i14] = (j5 & (~(255 << i15))) | (j2 << i15);
                int i16 = this._capacity;
                int i17 = ((iFindFirstAvailableSlot - 7) & i16) + (i16 & 7);
                int i18 = i17 >> 3;
                int i19 = (i17 & 7) << 3;
                jArr2[i18] = ((~(255 << i19)) & jArr2[i18]) | (j2 << i19);
                return ~iFindFirstAvailableSlot;
            }
            i9 = i12 + 8;
            i8 = (i8 + i9) & i7;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    private final void initializeMetadata(int i2) {
        long[] jArr;
        if (i2 == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((i2 + 15) & (-8)) >> 3];
            i.r0(jArr);
        }
        this.metadata = jArr;
        int i3 = i2 >> 3;
        long j = 255 << ((i2 & 7) << 3);
        jArr[i3] = (jArr[i3] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeStorage(int i2) {
        int iMax = i2 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i2)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.keys = new int[iMax];
        this.values = new int[iMax];
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i2 = this._capacity;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 >> 3;
            int i6 = (i4 & 7) << 3;
            if (((jArr[i5] >> i6) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i5] = (128 << i6) | (jArr2[i5] & (~(255 << i6)));
                int i7 = this._capacity;
                int i8 = ((i4 - 7) & i7) + (i7 & 7);
                int i9 = i8 >> 3;
                int i10 = (i8 & 7) << 3;
                jArr2[i9] = ((~(255 << i10)) & jArr2[i9]) | (128 << i10);
                i3++;
            }
        }
        this.growthLimit += i3;
    }

    private final void resizeStorage(int i2) {
        long[] jArr;
        MutableIntIntMap mutableIntIntMap = this;
        long[] jArr2 = mutableIntIntMap.metadata;
        int[] iArr = mutableIntIntMap.keys;
        int[] iArr2 = mutableIntIntMap.values;
        int i3 = mutableIntIntMap._capacity;
        initializeStorage(i2);
        int[] iArr3 = mutableIntIntMap.keys;
        int[] iArr4 = mutableIntIntMap.values;
        int i4 = 0;
        while (i4 < i3) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                int i5 = iArr[i4];
                int i6 = ScatterMapKt.MurmurHashC1 * i5;
                int i7 = i6 ^ (i6 << 16);
                int iFindFirstAvailableSlot = mutableIntIntMap.findFirstAvailableSlot(i7 >>> 7);
                long j = i7 & 127;
                long[] jArr3 = mutableIntIntMap.metadata;
                int i8 = iFindFirstAvailableSlot >> 3;
                int i9 = (iFindFirstAvailableSlot & 7) << 3;
                jArr3[i8] = (jArr3[i8] & (~(255 << i9))) | (j << i9);
                int i10 = mutableIntIntMap._capacity;
                int i11 = ((iFindFirstAvailableSlot - 7) & i10) + (i10 & 7);
                int i12 = i11 >> 3;
                int i13 = (i11 & 7) << 3;
                jArr = jArr2;
                jArr3[i12] = ((~(255 << i13)) & jArr3[i12]) | (j << i13);
                iArr3[iFindFirstAvailableSlot] = i5;
                iArr4[iFindFirstAvailableSlot] = iArr2[i4];
            } else {
                jArr = jArr2;
            }
            i4++;
            mutableIntIntMap = this;
            jArr2 = jArr;
        }
    }

    private final void writeMetadata(int i2, long j) {
        long[] jArr = this.metadata;
        int i3 = i2 >> 3;
        int i4 = (i2 & 7) << 3;
        jArr[i3] = (jArr[i3] & (~(255 << i4))) | (j << i4);
        int i5 = this._capacity;
        int i6 = ((i2 - 7) & i5) + (i5 & 7);
        int i7 = i6 >> 3;
        int i8 = (i6 & 7) << 3;
        jArr[i7] = (j << i8) | (jArr[i7] & (~(255 << i8)));
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            i.r0(jArr);
            long[] jArr2 = this.metadata;
            int i2 = this._capacity;
            int i3 = i2 >> 3;
            long j = 255 << ((i2 & 7) << 3);
            jArr2[i3] = (jArr2[i3] & (~j)) | j;
        }
        initializeGrowth();
    }

    public final int getOrPut(int i2, a defaultValue) {
        j.e(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(i2);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        int iIntValue = ((Number) defaultValue.invoke()).intValue();
        put(i2, iIntValue);
        return iIntValue;
    }

    public final void minusAssign(int i2) {
        remove(i2);
    }

    public final void plusAssign(IntIntMap from) {
        j.e(from, "from");
        putAll(from);
    }

    public final void put(int i2, int i3) {
        set(i2, i3);
    }

    public final void putAll(IntIntMap from) {
        j.e(from, "from");
        int[] iArr = from.keys;
        int[] iArr2 = from.values;
        long[] jArr = from.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i2 << 3) + i4;
                        set(iArr[i5], iArr2[i5]);
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void remove(int i2) {
        int iFindKeyIndex = findKeyIndex(i2);
        if (iFindKeyIndex >= 0) {
            removeValueAt(iFindKeyIndex);
        }
    }

    public final void removeIf(p predicate) {
        j.e(predicate, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i2 << 3) + i4;
                        if (((Boolean) predicate.invoke(Integer.valueOf(this.keys[i5]), Integer.valueOf(this.values[i5]))).booleanValue()) {
                            removeValueAt(i5);
                        }
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void removeValueAt(int i2) {
        this._size--;
        long[] jArr = this.metadata;
        int i3 = i2 >> 3;
        int i4 = (i2 & 7) << 3;
        jArr[i3] = (jArr[i3] & (~(255 << i4))) | (254 << i4);
        int i5 = this._capacity;
        int i6 = ((i2 - 7) & i5) + (i5 & 7);
        int i7 = i6 >> 3;
        int i8 = (i6 & 7) << 3;
        jArr[i7] = (jArr[i7] & (~(255 << i8))) | (254 << i8);
    }

    public final void set(int i2, int i3) {
        int iFindInsertIndex = findInsertIndex(i2);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        }
        this.keys[iFindInsertIndex] = i2;
        this.values[iFindInsertIndex] = i3;
    }

    public final int trim() {
        int i2 = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i2) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i2 - this._capacity;
    }

    public /* synthetic */ MutableIntIntMap(int i2, int i3, e eVar) {
        this((i3 & 1) != 0 ? 6 : i2);
    }

    public final void minusAssign(int[] keys) {
        j.e(keys, "keys");
        for (int i2 : keys) {
            remove(i2);
        }
    }

    public final int put(int i2, int i3, int i4) {
        int iFindInsertIndex = findInsertIndex(i2);
        if (iFindInsertIndex < 0) {
            iFindInsertIndex = ~iFindInsertIndex;
        } else {
            i4 = this.values[iFindInsertIndex];
        }
        this.keys[iFindInsertIndex] = i2;
        this.values[iFindInsertIndex] = i3;
        return i4;
    }

    public MutableIntIntMap(int i2) {
        super(null);
        if (i2 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i2));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final boolean remove(int i2, int i3) {
        int iFindKeyIndex = findKeyIndex(i2);
        if (iFindKeyIndex < 0 || this.values[iFindKeyIndex] != i3) {
            return false;
        }
        removeValueAt(iFindKeyIndex);
        return true;
    }

    public final void minusAssign(IntSet keys) {
        j.e(keys, "keys");
        int[] iArr = keys.elements;
        long[] jArr = keys.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        remove(iArr[(i2 << 3) + i4]);
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final void minusAssign(IntList keys) {
        j.e(keys, "keys");
        int[] iArr = keys.content;
        int i2 = keys._size;
        for (int i3 = 0; i3 < i2; i3++) {
            remove(iArr[i3]);
        }
    }
}
