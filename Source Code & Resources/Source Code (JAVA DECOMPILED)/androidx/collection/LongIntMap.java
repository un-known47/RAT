package androidx.collection;

import androidx.appcompat.app.g;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import y0.a;
import y0.l;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class LongIntMap {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public int[] values;

    public /* synthetic */ LongIntMap(e eVar) {
        this();
    }

    public static /* synthetic */ String joinToString$default(LongIntMap longIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, int i3, Object obj) {
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
        return longIntMap.joinToString(charSequence, charSequence2, charSequence6, i2, charSequence5);
    }

    public final boolean all(p predicate) {
        j.e(predicate, "predicate");
        long[] jArr = this.keys;
        int[] iArr = this.values;
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
                        if (!((Boolean) predicate.invoke(Long.valueOf(jArr[i5]), Integer.valueOf(iArr[i5]))).booleanValue()) {
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

    public final boolean contains(long j) {
        return findKeyIndex(j) >= 0;
    }

    public final boolean containsKey(long j) {
        return findKeyIndex(j) >= 0;
    }

    public final boolean containsValue(int i2) {
        int[] iArr = this.values;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i3 = 0;
            while (true) {
                long j = jArr[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i4 = 8 - ((~(i3 - length)) >>> 31);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if ((255 & j) < 128 && i2 == iArr[(i3 << 3) + i5]) {
                            return true;
                        }
                        j >>= 8;
                    }
                    if (i4 != 8) {
                        break;
                    }
                }
                if (i3 == length) {
                    break;
                }
                i3++;
            }
        }
        return false;
    }

    public final int count() {
        return getSize();
    }

    public boolean equals(Object obj) {
        long[] jArr;
        boolean z2;
        long[] jArr2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LongIntMap)) {
            return false;
        }
        LongIntMap longIntMap = (LongIntMap) obj;
        if (longIntMap.getSize() != getSize()) {
            return false;
        }
        long[] jArr3 = this.keys;
        int[] iArr = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length < 0) {
            return true;
        }
        int i2 = 0;
        while (true) {
            long j = jArr4[i2];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i2 - length)) >>> 31);
                int i4 = 0;
                while (i4 < i3) {
                    if ((255 & j) < 128) {
                        int i5 = (i2 << 3) + i4;
                        jArr2 = jArr3;
                        if (iArr[i5] != longIntMap.get(jArr2[i5])) {
                            return false;
                        }
                    } else {
                        jArr2 = jArr3;
                    }
                    j >>= 8;
                    i4++;
                    jArr3 = jArr2;
                }
                jArr = jArr3;
                z2 = true;
                if (i3 != 8) {
                    return true;
                }
            } else {
                jArr = jArr3;
                z2 = true;
            }
            if (i2 == length) {
                return z2;
            }
            i2++;
            jArr3 = jArr;
        }
    }

    public final int findKeyIndex(long j) {
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
        int[] iArr = this.values;
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
                        block.invoke(Long.valueOf(jArr[i5]), Integer.valueOf(iArr[i5]));
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
        int[] iArr = this.values;
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
                        block.invoke(Integer.valueOf(iArr[(i2 << 3) + i4]));
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

    public final int get(long j) {
        int iFindKeyIndex = findKeyIndex(j);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException(g.f("Cannot find value for key ", j));
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final int getOrDefault(long j, int i2) {
        int iFindKeyIndex = findKeyIndex(j);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : i2;
    }

    public final int getOrElse(long j, a defaultValue) {
        j.e(defaultValue, "defaultValue");
        int iFindKeyIndex = findKeyIndex(j);
        return iFindKeyIndex < 0 ? ((Number) defaultValue.invoke()).intValue() : this.values[iFindKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.keys;
        int[] iArr = this.values;
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
                        long j2 = jArr[i6];
                        i3 += iArr[i6] ^ ((int) (j2 ^ (j2 >>> 32)));
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
        int[] iArr = this.values;
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
                            int i9 = iArr[i8];
                            sb.append(j2);
                            sb.append("=");
                            sb.append(i9);
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
                    int i10 = i4;
                    if (i6 != 8) {
                        break;
                    }
                    i2 = i10;
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

    private LongIntMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = IntSetKt.getEmptyIntArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
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
            int[] r3 = r0.values
            long[] r4 = r0.metadata
            int r5 = r4.length
            int r5 = r5 + (-2)
            r6 = 0
            if (r5 < 0) goto L63
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
            if (r14 == 0) goto L5e
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L30:
            if (r12 >= r10) goto L5c
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 >= 0) goto L58
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r2[r13]
            r13 = r3[r13]
            java.lang.Long r14 = java.lang.Long.valueOf(r14)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.Object r13 = r1.invoke(r14, r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L58
            r1 = 1
            return r1
        L58:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L30
        L5c:
            if (r10 != r11) goto L63
        L5e:
            if (r7 == r5) goto L63
            int r7 = r7 + 1
            goto L16
        L63:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.any(y0.p):boolean");
    }

    public final int count(p predicate) {
        j.e(predicate, "predicate");
        long[] jArr = this.keys;
        int[] iArr = this.values;
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
                        if (((Boolean) predicate.invoke(Long.valueOf(jArr[i6]), Integer.valueOf(iArr[i6]))).booleanValue()) {
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

    public static /* synthetic */ String joinToString$default(LongIntMap longIntMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, p pVar, int i3, Object obj) {
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
            long[] jArr3 = longIntMap.keys;
            int[] iArr = longIntMap.values;
            long[] jArr4 = longIntMap.metadata;
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
                                int i11 = iArr[i10];
                                if (i6 == i4) {
                                    sbO.append(charSequence5);
                                    break loop0;
                                }
                                if (i6 != 0) {
                                    sbO.append(separator);
                                }
                                c = '\b';
                                Long lValueOf = Long.valueOf(j2);
                                jArr2 = jArr4;
                                sbO.append((CharSequence) pVar.invoke(lValueOf, Integer.valueOf(i11)));
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
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        char c;
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        StringBuilder sbM = g.m(charSequence, "postfix", charSequence2, "truncated", prefix);
        long[] jArr3 = this.keys;
        int[] iArr3 = this.values;
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
                            iArr2 = iArr3;
                            jArr2 = jArr4;
                            long j2 = jArr3[i7];
                            c = '\b';
                            int i8 = iArr2[i7];
                            if (i4 == i2) {
                                sbM.append(charSequence2);
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbM.append(separator);
                            }
                            sbM.append(j2);
                            sbM.append('=');
                            sbM.append(i8);
                            i4++;
                        } else {
                            iArr2 = iArr3;
                            jArr2 = jArr4;
                            c = '\b';
                        }
                        j >>= c;
                        i6++;
                        iArr3 = iArr2;
                        jArr4 = jArr2;
                    }
                    iArr = iArr3;
                    jArr = jArr4;
                    if (i5 != 8) {
                        break;
                    }
                } else {
                    iArr = iArr3;
                    jArr = jArr4;
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                iArr3 = iArr;
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

    /* JADX WARN: Removed duplicated region for block: B:20:0x0091 A[PHI: r12
  0x0091: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0042, B:19:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String joinToString(java.lang.CharSequence r23, java.lang.CharSequence r24, java.lang.CharSequence r25, int r26, java.lang.CharSequence r27, y0.p r28) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r27
            r5 = r28
            java.lang.String r6 = "separator"
            kotlin.jvm.internal.j.e(r1, r6)
            java.lang.String r6 = "prefix"
            kotlin.jvm.internal.j.e(r2, r6)
            java.lang.String r6 = "postfix"
            kotlin.jvm.internal.j.e(r3, r6)
            java.lang.String r6 = "truncated"
            java.lang.String r7 = "transform"
            java.lang.StringBuilder r2 = androidx.appcompat.app.g.o(r4, r6, r5, r7, r2)
            long[] r6 = r0.keys
            int[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L9a
            r11 = 0
            r12 = 0
        L30:
            r13 = r8[r11]
            r15 = r11
            long r10 = ~r13
            r16 = 7
            long r10 = r10 << r16
            long r10 = r10 & r13
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r16
            int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r18 == 0) goto L91
            int r11 = r15 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r11 = 0
            r16 = 8
        L50:
            if (r11 >= r10) goto L8d
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r13 & r17
            r19 = 128(0x80, double:6.3E-322)
            int r21 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r21 >= 0) goto L84
            int r17 = r15 << 3
            int r17 = r17 + r11
            r18 = r6[r17]
            r17 = r7[r17]
            r0 = r26
            if (r12 != r0) goto L6c
            r2.append(r4)
            goto L9d
        L6c:
            if (r12 == 0) goto L71
            r2.append(r1)
        L71:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Object r0 = r5.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.append(r0)
            int r12 = r12 + 1
        L84:
            long r13 = r13 >> r16
            int r11 = r11 + 1
            r0 = r22
            r1 = r23
            goto L50
        L8d:
            r0 = 8
            if (r10 != r0) goto L9a
        L91:
            if (r15 == r9) goto L9a
            int r11 = r15 + 1
            r0 = r22
            r1 = r23
            goto L30
        L9a:
            r2.append(r3)
        L9d:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, y0.p):java.lang.String");
    }

    public final String joinToString(CharSequence charSequence, CharSequence prefix, CharSequence charSequence2, int i2, p pVar) {
        char c;
        CharSequence separator = charSequence;
        j.e(separator, "separator");
        j.e(prefix, "prefix");
        StringBuilder sbO = g.o(charSequence2, "postfix", pVar, "transform", prefix);
        long[] jArr = this.keys;
        int[] iArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i3 = 0;
            int i4 = 0;
            loop0: while (true) {
                long j = jArr2[i3];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i5 = 8 - ((~(i3 - length)) >>> 31);
                    int i6 = 0;
                    while (i6 < i5) {
                        if ((j & 255) < 128) {
                            int i7 = (i3 << 3) + i6;
                            long j2 = jArr[i7];
                            int i8 = iArr[i7];
                            c = '\b';
                            if (i4 == i2) {
                                sbO.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i4 != 0) {
                                sbO.append(separator);
                            }
                            sbO.append((CharSequence) pVar.invoke(Long.valueOf(j2), Integer.valueOf(i8)));
                            i4++;
                        } else {
                            c = '\b';
                        }
                        j >>= c;
                        i6++;
                        separator = charSequence;
                    }
                    if (i5 != 8) {
                        break;
                    }
                }
                if (i3 == length) {
                    break;
                }
                i3++;
                separator = charSequence;
            }
            sbO.append(charSequence2);
        } else {
            sbO.append(charSequence2);
        }
        String string = sbO.toString();
        j.d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008d A[PHI: r11
  0x008d: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x003a, B:20:0x008b] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L94
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
            if (r18 == 0) goto L8d
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L46:
            if (r9 >= r14) goto L89
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r12 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L7e
            int r16 = r10 << 3
            int r16 = r16 + r9
            r17 = r5[r16]
            r16 = r6[r16]
            r19 = 8
            r15 = -1
            if (r11 != r15) goto L65
            java.lang.String r1 = "..."
            r2.append(r1)
            goto L97
        L65:
            if (r11 == 0) goto L6a
            r2.append(r1)
        L6a:
            java.lang.Long r15 = java.lang.Long.valueOf(r17)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r16)
            java.lang.Object r0 = r4.invoke(r15, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.append(r0)
            int r11 = r11 + 1
            goto L80
        L7e:
            r19 = 8
        L80:
            long r12 = r12 >> r19
            int r9 = r9 + 1
            r0 = r21
            r15 = 8
            goto L46
        L89:
            r0 = 8
            if (r14 != r0) goto L94
        L8d:
            if (r10 == r8) goto L94
            int r10 = r10 + 1
            r0 = r21
            goto L29
        L94:
            r2.append(r3)
        L97:
            java.lang.String r0 = r2.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, y0.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0081 A[PHI: r10
  0x0081: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x0030, B:20:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L86
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
            if (r17 == 0) goto L81
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L3c:
            if (r15 >= r13) goto L7d
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L74
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r4[r16]
            r16 = r5[r16]
            r8 = -1
            if (r10 != r8) goto L59
            java.lang.String r1 = "..."
            r3.append(r1)
            goto L8b
        L59:
            if (r10 == 0) goto L5e
            r3.append(r1)
        L5e:
            java.lang.Long r8 = java.lang.Long.valueOf(r17)
            r17 = 8
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)
            java.lang.Object r8 = r2.invoke(r8, r14)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r3.append(r8)
            int r10 = r10 + 1
            goto L76
        L74:
            r17 = 8
        L76:
            long r11 = r11 >> r17
            int r15 = r15 + 1
            r14 = 8
            goto L3c
        L7d:
            r8 = 8
            if (r13 != r8) goto L86
        L81:
            if (r9 == r7) goto L86
            int r9 = r9 + 1
            goto L22
        L86:
            java.lang.String r1 = ""
            r3.append(r1)
        L8b:
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, y0.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[PHI: r11
  0x0088: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x0035, B:20:0x0086] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L8f
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
            if (r18 == 0) goto L88
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L41:
            if (r9 >= r14) goto L84
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r12 & r17
            r19 = 128(0x80, double:6.3E-322)
            int r21 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r21 >= 0) goto L79
            int r17 = r10 << 3
            int r17 = r17 + r9
            r18 = r5[r17]
            r17 = r6[r17]
            r20 = 8
            r15 = -1
            if (r11 != r15) goto L60
            java.lang.String r1 = "..."
            r3.append(r1)
            goto L92
        L60:
            if (r11 == 0) goto L65
            r3.append(r1)
        L65:
            java.lang.Long r15 = java.lang.Long.valueOf(r18)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.Object r0 = r2.invoke(r15, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.append(r0)
            int r11 = r11 + 1
            goto L7b
        L79:
            r20 = 8
        L7b:
            long r12 = r12 >> r20
            int r9 = r9 + 1
            r0 = r22
            r15 = 8
            goto L41
        L84:
            r0 = 8
            if (r14 != r0) goto L8f
        L88:
            if (r10 == r8) goto L8f
            int r10 = r10 + 1
            r0 = r22
            goto L24
        L8f:
            r3.append(r4)
        L92:
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(java.lang.CharSequence, y0.p):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[PHI: r10
  0x007e: PHI (r10v2 int) = (r10v1 int), (r10v3 int) binds: [B:6:0x002b, B:20:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
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
            int[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L83
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
            if (r17 == 0) goto L7e
            int r13 = r9 - r7
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = 0
        L37:
            if (r15 >= r13) goto L7a
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L71
            int r16 = r9 << 3
            int r16 = r16 + r15
            r17 = r4[r16]
            r16 = r5[r16]
            r8 = -1
            if (r10 != r8) goto L54
            java.lang.String r1 = "..."
            r2.append(r1)
            goto L86
        L54:
            if (r10 == 0) goto L5b
            java.lang.String r8 = ", "
            r2.append(r8)
        L5b:
            java.lang.Long r8 = java.lang.Long.valueOf(r17)
            r17 = 8
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)
            java.lang.Object r8 = r1.invoke(r8, r14)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.append(r8)
            int r10 = r10 + 1
            goto L73
        L71:
            r17 = 8
        L73:
            long r11 = r11 >> r17
            int r15 = r15 + 1
            r14 = 8
            goto L37
        L7a:
            r8 = 8
            if (r13 != r8) goto L83
        L7e:
            if (r9 == r7) goto L83
            int r9 = r9 + 1
            goto L1d
        L83:
            r2.append(r3)
        L86:
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.j.d(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongIntMap.joinToString(y0.p):java.lang.String");
    }
}
