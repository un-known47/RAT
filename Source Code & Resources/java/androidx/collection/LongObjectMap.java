package androidx.collection;

import androidx.appcompat.app.g;
import androidx.collection.internal.ContainerHelpersKt;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import y0.a;
import y0.l;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class LongObjectMap<V> {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public Object[] values;

    public /* synthetic */ LongObjectMap(e eVar) {
        this();
    }

    public static /* synthetic */ String joinToString$default(LongObjectMap longObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i3 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i3 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i3 & 8) != 0) {
            i2 = -1;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return longObjectMap.joinToString(charSequence, charSequence2, charSequence6, i2, charSequence5);
    }

    public final boolean all(p predicate) {
        j.e(predicate, "predicate");
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i2 << 3) + i4;
                        if (!((Boolean) predicate.invoke(Long.valueOf(jArr[i5]), objArr[i5])).booleanValue()) {
                            return false;
                        }
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return true;
                }
            }
            if (i2 == length) {
                return true;
            }
            i2++;
        }
    }

    public final boolean any() {
        return this._size != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006b, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean contains(long r18) {
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
            long[] r14 = r0.keys
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
            if (r8 == 0) goto L72
            r10 = -1
        L6e:
            if (r10 < 0) goto L71
            return r11
        L71:
            return r4
        L72:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.contains(long):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x006b, code lost:
    
        if (((r6 & ((~r6) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x006d, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean containsKey(long r18) {
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
            long[] r14 = r0.keys
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
            if (r8 == 0) goto L72
            r10 = -1
        L6e:
            if (r10 < 0) goto L71
            return r11
        L71:
            return r4
        L72:
            int r5 = r5 + 8
            int r1 = r1 + r5
            r1 = r1 & r3
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.containsKey(long):boolean");
    }

    public final boolean containsValue(V v2) {
        Object[] objArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = 0; i4 < i3; i4++) {
                        if ((255 & j) < 128 && j.a(v2, objArr[(i2 << 3) + i4])) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int count() {
        return getSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof androidx.collection.LongObjectMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.LongObjectMap r1 = (androidx.collection.LongObjectMap) r1
            int r3 = r1.getSize()
            int r5 = r0.getSize()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            long[] r3 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L8b
            r8 = 0
        L27:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 == 0) goto L80
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = 0
        L41:
            if (r13 >= r11) goto L7a
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 >= 0) goto L70
            int r14 = r8 << 3
            int r14 = r14 + r13
            r16 = r3
            r15 = 1
            r2 = r16[r14]
            r14 = r5[r14]
            if (r14 != 0) goto L65
            java.lang.Object r14 = r1.get(r2)
            if (r14 != 0) goto L64
            boolean r2 = r1.containsKey(r2)
            if (r2 != 0) goto L73
        L64:
            return r4
        L65:
            java.lang.Object r2 = r1.get(r2)
            boolean r2 = r14.equals(r2)
            if (r2 != 0) goto L73
            return r4
        L70:
            r16 = r3
            r15 = 1
        L73:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            r3 = r16
            r2 = 1
            goto L41
        L7a:
            r16 = r3
            r15 = 1
            if (r11 != r12) goto L8c
            goto L83
        L80:
            r16 = r3
            r15 = 1
        L83:
            if (r8 == r7) goto L8c
            int r8 = r8 + 1
            r3 = r16
            r2 = 1
            goto L27
        L8b:
            r15 = 1
        L8c:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex$collection(long j) {
        int i2 = ((int) ((j >>> 32) ^ j)) * ScatterMapKt.MurmurHashC1;
        int i3 = (i2 << 16) ^ i2;
        int i4 = i3 & 127;
        int i5 = this._capacity;
        int i6 = (i3 >>> 7) & i5;
        int i7 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i8 = i6 >> 3;
            int i9 = (i6 & 7) << 3;
            long j2 = ((jArr[i8 + 1] << (64 - i9)) & ((-i9) >> 63)) | (jArr[i8] >>> i9);
            long j3 = (i4 * ScatterMapKt.BitmaskLsb) ^ j2;
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i6) & i5;
                if (this.keys[iNumberOfTrailingZeros] == j) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j2 & ((~j2) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i7 += 8;
            i6 = (i6 + i7) & i5;
        }
    }

    public final void forEach(p block) {
        j.e(block, "block");
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
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
                        int i5 = (i2 << 3) + i4;
                        block.invoke(Long.valueOf(jArr[i5]), objArr[i5]);
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

    public final void forEachIndexed(l block) {
        j.e(block, "block");
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
                        g.t(i2 << 3, i4, block);
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

    public final void forEachKey(l block) {
        j.e(block, "block");
        long[] jArr = this.keys;
        long[] jArr2 = this.metadata;
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
                        block.invoke(Long.valueOf(jArr[(i2 << 3) + i4]));
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

    public final void forEachValue(l block) {
        j.e(block, "block");
        Object[] objArr = this.values;
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
                        block.invoke(objArr[(i2 << 3) + i4]);
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0069, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V get(long r15) {
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
            long[] r11 = r14.keys
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
            if (r6 == 0) goto L73
            r10 = -1
        L6a:
            if (r10 < 0) goto L71
            java.lang.Object[] r0 = r14.values
            r0 = r0[r10]
            return r0
        L71:
            r0 = 0
            return r0
        L73:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.get(long):java.lang.Object");
    }

    public final int getCapacity() {
        return this._capacity;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0067, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0069, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final V getOrDefault(long r15, V r17) {
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
            long[] r11 = r14.keys
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
            if (r6 == 0) goto L72
            r10 = -1
        L6a:
            if (r10 < 0) goto L71
            java.lang.Object[] r0 = r14.values
            r0 = r0[r10]
            return r0
        L71:
            return r17
        L72:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.getOrDefault(long, java.lang.Object):java.lang.Object");
    }

    public final V getOrElse(long j, a defaultValue) {
        j.e(defaultValue, "defaultValue");
        V v2 = get(j);
        return v2 == null ? (V) defaultValue.invoke() : v2;
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                for (int i4 = 0; i4 < i3; i4++) {
                    if ((255 & j) < 128) {
                        int i5 = (i2 << 3) + i4;
                        long j2 = jArr[i5];
                        Object obj = objArr[i5];
                        iHashCode += (obj != null ? obj.hashCode() : 0) ^ ((int) (j2 ^ (j2 >>> 32)));
                    }
                    j >>= 8;
                }
                if (i3 != 8) {
                    return iHashCode;
                }
            }
            if (i2 == length) {
                return iHashCode;
            }
            i2++;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        int i2;
        int i3;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i4 = 0;
            int i5 = 0;
            while (true) {
                long j = jArr2[i4];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i4 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((255 & j) < 128) {
                            int i8 = (i4 << 3) + i7;
                            i3 = i4;
                            long j2 = jArr[i8];
                            Object obj = objArr[i8];
                            sb.append(j2);
                            sb.append("=");
                            if (obj == this) {
                                obj = "(this)";
                            }
                            sb.append(obj);
                            i5++;
                            if (i5 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i3 = i4;
                        }
                        j >>= 8;
                        i7++;
                        i4 = i3;
                    }
                    int i9 = i4;
                    if (i6 != 8) {
                        break;
                    }
                    i2 = i9;
                } else {
                    i2 = i4;
                }
                if (i2 == length) {
                    break;
                }
                i4 = i2 + 1;
            }
        }
        return g.j(sb, '}', "s.append('}').toString()");
    }

    private LongObjectMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = ContainerHelpersKt.EMPTY_OBJECTS;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean any(y0.p r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "predicate"
            kotlin.jvm.internal.j.e(r1, r2)
            long[] r2 = r0.keys
            java.lang.Object[] r3 = r0.values
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L5f
            r7 = 0
        L16:
            r8 = r4[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 == 0) goto L5a
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L30:
            if (r12 >= r10) goto L58
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 >= 0) goto L54
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]
            r13 = r3[r13]
            java.lang.Long r14 = java.lang.Long.valueOf(r14)
            java.lang.Object r13 = r1.invoke(r14, r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L54
            r1 = 1
            return r1
        L54:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L58:
            if (r10 != r11) goto L5f
        L5a:
            if (r7 == r5) goto L5f
            int r7 = r7 + 1
            goto L16
        L5f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.any(y0.p):boolean");
    }

    public final int count(p predicate) {
        j.e(predicate, "predicate");
        long[] jArr = this.keys;
        Object[] objArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            long j = jArr2[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i2 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j) < 128) {
                        int i6 = (i2 << 3) + i5;
                        if (((Boolean) predicate.invoke(Long.valueOf(jArr[i6]), objArr[i6])).booleanValue()) {
                            i3++;
                        }
                    }
                    j >>= 8;
                }
                if (i4 != 8) {
                    return i3;
                }
            }
            if (i2 == length) {
                return i3;
            }
            i2++;
        }
    }

    public final String joinToString(CharSequence separator) {
        j.e(separator, "separator");
        return joinToString$default(this, separator, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        return joinToString$default(this, separator, prefix, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        j.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, 0, null, 24, null);
    }

    public static /* synthetic */ String joinToString$default(LongObjectMap longObjectMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, p pVar, int i3, Object obj) {
        long[] jArr;
        long[] jArr2;
        char c;
        if (obj == null) {
            CharSequence separator = (i3 & 1) != 0 ? ", " : charSequence;
            CharSequence prefix = (i3 & 2) != 0 ? "" : charSequence2;
            CharSequence postfix = (i3 & 4) == 0 ? charSequence3 : "";
            int i4 = (i3 & 8) != 0 ? -1 : i2;
            CharSequence charSequence5 = (i3 & 16) != 0 ? "..." : charSequence4;
            j.e(separator, "separator");
            j.e(prefix, "prefix");
            j.e(postfix, "postfix");
            StringBuilder sbO = g.o(charSequence5, "truncated", pVar, "transform", prefix);
            long[] jArr3 = longObjectMap.keys;
            Object[] objArr = longObjectMap.values;
            long[] jArr4 = longObjectMap.metadata;
            int length = jArr4.length - 2;
            if (length >= 0) {
                int i5 = 0;
                int i6 = 0;
                loop0: while (true) {
                    long j = jArr4[i5];
                    int i7 = i5;
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i8 = 8 - ((~(i7 - length)) >>> 31);
                        int i9 = 0;
                        while (i9 < i8) {
                            if ((j & 255) < 128) {
                                int i10 = (i7 << 3) + i9;
                                long j2 = jArr3[i10];
                                c = '\b';
                                Object obj2 = objArr[i10];
                                if (i6 == i4) {
                                    sbO.append(charSequence5);
                                    break loop0;
                                }
                                if (i6 != 0) {
                                    sbO.append(separator);
                                }
                                jArr2 = jArr4;
                                sbO.append((CharSequence) pVar.invoke(Long.valueOf(j2), obj2));
                                i6++;
                            } else {
                                jArr2 = jArr4;
                                c = '\b';
                            }
                            j >>= c;
                            i9++;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        if (i8 != 8) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                    }
                    if (i7 == length) {
                        break;
                    }
                    i5 = i7 + 1;
                    jArr4 = jArr;
                }
                sbO.append(postfix);
            } else {
                sbO.append(postfix);
            }
            String string = sbO.toString();
            j.d(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int i2) {
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        j.e(postfix, "postfix");
        return joinToString$default(this, separator, prefix, postfix, i2, null, 16, null);
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence charSequence, int i2, CharSequence charSequence2) {
        Object[] objArr;
        long[] jArr;
        Object[] objArr2;
        long[] jArr2;
        char c;
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        StringBuilder sbM = g.m(charSequence, "postfix", charSequence2, "truncated", prefix);
        long[] jArr3 = this.keys;
        Object[] objArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr4[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i3 << 3) + i6;
                            objArr2 = objArr3;
                            jArr2 = jArr4;
                            long j2 = jArr3[i7];
                            c = '\b';
                            Object obj = objArr2[i7];
                            if (i4 == i2) {
                                sbM.append(charSequence2);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM.append(separator);
                            }
                            sbM.append(j2);
                            sbM.append('=');
                            sbM.append(obj);
                            i4++;
                        } else {
                            objArr2 = objArr3;
                            jArr2 = jArr4;
                            c = '\b';
                        }
                        j >>= c;
                        i6++;
                        objArr3 = objArr2;
                        jArr4 = jArr2;
                    }
                    objArr = objArr3;
                    jArr = jArr4;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    objArr = objArr3;
                    jArr = jArr4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                objArr3 = objArr;
                jArr4 = jArr;
            }
            sbM.append(charSequence);
        } else {
            sbM.append(charSequence);
        }
        String string = sbM.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence postfix, int i2, CharSequence charSequence2, p pVar) {
        long[] jArr;
        long[] jArr2;
        CharSequence separator = charSequence;
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        j.e(postfix, "postfix");
        StringBuilder sbO = g.o(charSequence2, "truncated", pVar, "transform", prefix);
        long[] jArr3 = this.keys;
        Object[] objArr = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr4[i3];
                int i5 = i3;
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    int i7 = 0;
                    while (i7 < i6) {
                        if ((j & 255) < 128) {
                            int i8 = (i5 << 3) + i7;
                            long j2 = jArr3[i8];
                            Object obj = objArr[i8];
                            jArr2 = jArr3;
                            if (i4 == i2) {
                                sbO.append(charSequence2);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbO.append(separator);
                            }
                            sbO.append((CharSequence) pVar.invoke(Long.valueOf(j2), obj));
                            i4++;
                        } else {
                            jArr2 = jArr3;
                        }
                        j >>= 8;
                        i7++;
                        separator = charSequence;
                        jArr3 = jArr2;
                    }
                    jArr = jArr3;
                    if (i6 != 8) {
                        break;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i5 == length) {
                    break;
                }
                i3 = i5 + 1;
                separator = charSequence;
                jArr3 = jArr;
            }
            sbO.append(postfix);
        } else {
            sbO.append(postfix);
        }
        String string = sbO.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008a A[PHI: r11
  0x008a: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003a, B:20:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, int r25, y0.p r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r26
            java.lang.String r5 = "separator"
            kotlin.jvm.internal.j.e(r1, r5)
            java.lang.String r5 = "prefix"
            kotlin.jvm.internal.j.e(r2, r5)
            java.lang.String r5 = "postfix"
            java.lang.String r6 = "transform"
            java.lang.StringBuilder r2 = androidx.appcompat.app.g.o(r3, r5, r4, r6, r2)
            long[] r5 = r0.keys
            java.lang.Object[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L91
            r10 = 0
            r11 = 0
        L29:
            r12 = r7[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 == 0) goto L8a
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L46:
            if (r9 >= r14) goto L86
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r12 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L7b
            int r16 = r10 << 3
            int r16 = r16 + r9
            r17 = r5[r16]
            r19 = 8
            r15 = r6[r16]
            r0 = r25
            if (r11 != r0) goto L66
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L94
        L66:
            if (r11 == 0) goto L6b
            r2.append(r1)
        L6b:
            java.lang.Long r0 = java.lang.Long.valueOf(r17)
            java.lang.Object r0 = r4.invoke(r0, r15)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.append(r0)
            int r11 = r11 + 1
            goto L7d
        L7b:
            r19 = 8
        L7d:
            long r12 = r12 >> r19
            int r9 = r9 + 1
            r0 = r21
            r15 = 8
            goto L46
        L86:
            r0 = 8
            if (r14 != r0) goto L91
        L8a:
            if (r10 == r8) goto L91
            int r10 = r10 + 1
            r0 = r21
            goto L29
        L91:
            r2.append(r3)
        L94:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, y0.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0089 A[PHI: r11
  0x0089: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003a, B:20:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, y0.p r25) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            java.lang.String r5 = "separator"
            kotlin.jvm.internal.j.e(r1, r5)
            java.lang.String r5 = "prefix"
            kotlin.jvm.internal.j.e(r2, r5)
            java.lang.String r5 = "postfix"
            java.lang.String r6 = "transform"
            java.lang.StringBuilder r2 = androidx.appcompat.app.g.o(r3, r5, r4, r6, r2)
            long[] r5 = r0.keys
            java.lang.Object[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L90
            r10 = 0
            r11 = 0
        L29:
            r12 = r7[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 == 0) goto L89
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L46:
            if (r9 >= r14) goto L85
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r12 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L7a
            int r16 = r10 << 3
            int r16 = r16 + r9
            r17 = r5[r16]
            r19 = 8
            r15 = r6[r16]
            r0 = -1
            if (r11 != r0) goto L65
            java.lang.String r0 = "..."
            r2.append(r0)
            goto L93
        L65:
            if (r11 == 0) goto L6a
            r2.append(r1)
        L6a:
            java.lang.Long r0 = java.lang.Long.valueOf(r17)
            java.lang.Object r0 = r4.invoke(r0, r15)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.append(r0)
            int r11 = r11 + 1
            goto L7c
        L7a:
            r19 = 8
        L7c:
            long r12 = r12 >> r19
            int r9 = r9 + 1
            r0 = r21
            r15 = 8
            goto L46
        L85:
            r0 = 8
            if (r14 != r0) goto L90
        L89:
            if (r10 == r8) goto L90
            int r10 = r10 + 1
            r0 = r21
            goto L29
        L90:
            r2.append(r3)
        L93:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, y0.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[PHI: r10
  0x007d: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0030, B:20:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, y0.p r24) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.j.e(r1, r3)
            java.lang.String r3 = "prefix"
            java.lang.String r4 = "transform"
            r5 = r23
            java.lang.StringBuilder r3 = androidx.appcompat.app.g.o(r5, r3, r2, r4, r5)
            long[] r4 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L82
            r9 = 0
            r10 = 0
        L22:
            r11 = r6[r9]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 == 0) goto L7d
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L3c:
            if (r15 >= r13) goto L79
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L70
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r4[r16]
            r8 = r5[r16]
            r16 = 8
            r14 = -1
            if (r10 != r14) goto L5b
            java.lang.String r1 = "..."
            r3.append(r1)
            goto L87
        L5b:
            if (r10 == 0) goto L60
            r3.append(r1)
        L60:
            java.lang.Long r14 = java.lang.Long.valueOf(r17)
            java.lang.Object r8 = r2.invoke(r14, r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.append(r8)
            int r10 = r10 + 1
            goto L72
        L70:
            r16 = 8
        L72:
            long r11 = r11 >> r16
            int r15 = r15 + 1
            r14 = 8
            goto L3c
        L79:
            r8 = 8
            if (r13 != r8) goto L82
        L7d:
            if (r9 == r7) goto L82
            int r9 = r9 + 1
            goto L22
        L82:
            java.lang.String r1 = ""
            r3.append(r1)
        L87:
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, y0.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0084 A[PHI: r11
  0x0084: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0035, B:20:0x0082] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r23, y0.p r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            java.lang.String r3 = "separator"
            kotlin.jvm.internal.j.e(r1, r3)
            java.lang.String r3 = "transform"
            kotlin.jvm.internal.j.e(r2, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = ""
            r3.<init>(r4)
            long[] r5 = r0.keys
            java.lang.Object[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L8b
            r10 = 0
            r11 = 0
        L24:
            r12 = r7[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 == 0) goto L84
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L41:
            if (r9 >= r14) goto L80
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r12 & r17
            r19 = 128(0x80, double:6.3E-322)
            int r21 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r21 >= 0) goto L75
            int r17 = r10 << 3
            int r17 = r17 + r9
            r18 = r5[r17]
            r20 = 8
            r15 = r6[r17]
            r0 = -1
            if (r11 != r0) goto L60
            java.lang.String r0 = "..."
            r3.append(r0)
            goto L8e
        L60:
            if (r11 == 0) goto L65
            r3.append(r1)
        L65:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Object r0 = r2.invoke(r0, r15)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.append(r0)
            int r11 = r11 + 1
            goto L77
        L75:
            r20 = 8
        L77:
            long r12 = r12 >> r20
            int r9 = r9 + 1
            r0 = r22
            r15 = 8
            goto L41
        L80:
            r0 = 8
            if (r14 != r0) goto L8b
        L84:
            if (r10 == r8) goto L8b
            int r10 = r10 + 1
            r0 = r22
            goto L24
        L8b:
            r3.append(r4)
        L8e:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.joinToString(java.lang.CharSequence, y0.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a A[PHI: r10
  0x007a: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002b, B:20:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(y0.p r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            java.lang.String r2 = "transform"
            kotlin.jvm.internal.j.e(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ""
            r2.<init>(r3)
            long[] r4 = r0.keys
            java.lang.Object[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L7f
            r9 = 0
            r10 = 0
        L1d:
            r11 = r6[r9]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 == 0) goto L7a
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L37:
            if (r15 >= r13) goto L76
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L6d
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r4[r16]
            r8 = r5[r16]
            r16 = 8
            r14 = -1
            if (r10 != r14) goto L56
            java.lang.String r1 = "..."
            r2.append(r1)
            goto L82
        L56:
            if (r10 == 0) goto L5d
            java.lang.String r14 = ", "
            r2.append(r14)
        L5d:
            java.lang.Long r14 = java.lang.Long.valueOf(r17)
            java.lang.Object r8 = r1.invoke(r14, r8)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.append(r8)
            int r10 = r10 + 1
            goto L6f
        L6d:
            r16 = 8
        L6f:
            long r11 = r11 >> r16
            int r15 = r15 + 1
            r14 = 8
            goto L37
        L76:
            r8 = 8
            if (r13 != r8) goto L7f
        L7a:
            if (r9 == r7) goto L7f
            int r9 = r9 + 1
            goto L1d
        L7f:
            r2.append(r3)
        L82:
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongObjectMap.joinToString(y0.p):java.lang.String");
    }
}
