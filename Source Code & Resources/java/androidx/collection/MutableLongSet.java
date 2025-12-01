package androidx.collection;

import androidx.annotation.IntRange;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import m0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MutableLongSet extends LongSet {
    private int growthLimit;

    public MutableLongSet() {
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

    private final int findAbsoluteInsertIndex(long j) {
        int i2 = ((int) (j ^ (j >>> 32))) * ScatterMapKt.MurmurHashC1;
        int i3 = (i2 << 16) ^ i2;
        int i4 = i3 >>> 7;
        int i5 = i3 & 127;
        int i6 = this._capacity;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j2 = ((jArr[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr[i9] >>> i10);
            long j3 = i5;
            int i11 = i8;
            long j4 = j2 ^ (j3 * ScatterMapKt.BitmaskLsb);
            for (long j5 = (~j4) & (j4 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i7) & i6;
                if (this.elements[iNumberOfTrailingZeros] == j) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j2) << 6) & j2 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i4);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i4);
                }
                this._size++;
                int i12 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i13 = iFindFirstAvailableSlot >> 3;
                long j6 = jArr2[i13];
                int i14 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i12 - (((j6 >> i14) & 255) == 128 ? 1 : 0);
                jArr2[i13] = (j6 & (~(255 << i14))) | (j3 << i14);
                int i15 = this._capacity;
                int i16 = ((iFindFirstAvailableSlot - 7) & i15) + (i15 & 7);
                int i17 = i16 >> 3;
                int i18 = (i16 & 7) << 3;
                jArr2[i17] = ((~(255 << i18)) & jArr2[i17]) | (j3 << i18);
                return iFindFirstAvailableSlot;
            }
            i8 = i11 + 8;
            i7 = (i7 + i8) & i6;
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
        this.elements = new long[iMax];
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

    private final void removeElementAt(int i2) {
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

    private final void resizeStorage(int i2) {
        long[] jArr;
        MutableLongSet mutableLongSet = this;
        long[] jArr2 = mutableLongSet.metadata;
        long[] jArr3 = mutableLongSet.elements;
        int i3 = mutableLongSet._capacity;
        initializeStorage(i2);
        long[] jArr4 = mutableLongSet.elements;
        int i4 = 0;
        while (i4 < i3) {
            if (((jArr2[i4 >> 3] >> ((i4 & 7) << 3)) & 255) < 128) {
                long j = jArr3[i4];
                int i5 = ((int) ((j >>> 32) ^ j)) * ScatterMapKt.MurmurHashC1;
                int i6 = (i5 << 16) ^ i5;
                int iFindFirstAvailableSlot = mutableLongSet.findFirstAvailableSlot(i6 >>> 7);
                long j2 = i6 & 127;
                long[] jArr5 = mutableLongSet.metadata;
                int i7 = iFindFirstAvailableSlot >> 3;
                int i8 = (iFindFirstAvailableSlot & 7) << 3;
                jArr5[i7] = (jArr5[i7] & (~(255 << i8))) | (j2 << i8);
                int i9 = mutableLongSet._capacity;
                int i10 = ((iFindFirstAvailableSlot - 7) & i9) + (i9 & 7);
                int i11 = i10 >> 3;
                int i12 = (i10 & 7) << 3;
                jArr = jArr2;
                jArr5[i11] = ((~(255 << i12)) & jArr5[i11]) | (j2 << i12);
                jArr4[iFindFirstAvailableSlot] = j;
            } else {
                jArr = jArr2;
            }
            i4++;
            mutableLongSet = this;
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

    public final boolean add(long j) {
        int i2 = this._size;
        this.elements[findAbsoluteInsertIndex(j)] = j;
        return this._size != i2;
    }

    public final boolean addAll(long[] elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        plusAssign(elements);
        return i2 != this._size;
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0069, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void minusAssign(long r15) {
        /*
            r14 = this;
            r0 = 32
            long r0 = r15 >>> r0
            long r0 = r0 ^ r15
            int r1 = (int) r0
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r0
            int r0 = r1 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r14._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        L16:
            long[] r4 = r14.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L43:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L60
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            long[] r11 = r14.elements
            r12 = r11[r10]
            int r11 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r11 != 0) goto L5a
            goto L6a
        L5a:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L43
        L60:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r6 == 0) goto L70
            r10 = -1
        L6a:
            if (r10 < 0) goto L6f
            r14.removeElementAt(r10)
        L6f:
            return
        L70:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.minusAssign(long):void");
    }

    public final void plusAssign(long j) {
        this.elements[findAbsoluteInsertIndex(j)] = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006b, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean remove(long r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = 32
            long r1 = r18 >>> r1
            long r1 = r18 ^ r1
            int r2 = (int) r1
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r2 = r2 * r1
            int r1 = r2 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
            r5 = 0
        L1a:
            long[] r6 = r0.metadata
            int r7 = r1 >> 3
            r8 = r1 & 7
            int r8 = r8 << 3
            r9 = r6[r7]
            long r9 = r9 >>> r8
            r11 = 1
            int r7 = r7 + r11
            r12 = r6[r7]
            int r6 = 64 - r8
            long r6 = r12 << r6
            long r12 = (long) r8
            long r12 = -r12
            r8 = 63
            long r12 = r12 >> r8
            long r6 = r6 & r12
            long r6 = r6 | r9
            long r8 = (long) r2
            r12 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r8 = r8 * r12
            long r8 = r8 ^ r6
            long r12 = r8 - r12
            long r8 = ~r8
            long r8 = r8 & r12
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r12
        L47:
            r14 = 0
            int r10 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r10 == 0) goto L64
            int r10 = java.lang.Long.numberOfTrailingZeros(r8)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            long[] r14 = r0.elements
            r15 = r14[r10]
            int r14 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r14 != 0) goto L5e
            goto L6e
        L5e:
            r14 = 1
            long r14 = r8 - r14
            long r8 = r8 & r14
            goto L47
        L64:
            long r8 = ~r6
            r10 = 6
            long r8 = r8 << r10
            long r6 = r6 & r8
            long r6 = r6 & r12
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 == 0) goto L77
            r10 = -1
        L6e:
            if (r10 < 0) goto L71
            r4 = 1
        L71:
            if (r4 == 0) goto L76
            r0.removeElementAt(r10)
        L76:
            return r4
        L77:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableLongSet.remove(long):boolean");
    }

    public final boolean removeAll(long[] elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        minusAssign(elements);
        return i2 != this._size;
    }

    @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY)
    public final int trim() {
        int i2 = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i2) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i2 - this._capacity;
    }

    public /* synthetic */ MutableLongSet(int i2, int i3, e eVar) {
        this((i3 & 1) != 0 ? 6 : i2);
    }

    public MutableLongSet(int i2) {
        super(null);
        if (i2 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i2));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.");
    }

    public final void plusAssign(long[] elements) {
        j.e(elements, "elements");
        for (long j : elements) {
            plusAssign(j);
        }
    }

    public final boolean addAll(LongSet elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        plusAssign(elements);
        return i2 != this._size;
    }

    public final boolean removeAll(LongSet elements) {
        j.e(elements, "elements");
        int i2 = this._size;
        minusAssign(elements);
        return i2 != this._size;
    }

    public final void plusAssign(LongSet elements) {
        j.e(elements, "elements");
        long[] jArr = elements.elements;
        long[] jArr2 = elements.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        plusAssign(jArr[(i2 << 3) + i4]);
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

    public final void minusAssign(long[] elements) {
        j.e(elements, "elements");
        for (long j : elements) {
            minusAssign(j);
        }
    }

    public final void minusAssign(LongSet elements) {
        j.e(elements, "elements");
        long[] jArr = elements.elements;
        long[] jArr2 = elements.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        minusAssign(jArr[(i2 << 3) + i4]);
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
}
