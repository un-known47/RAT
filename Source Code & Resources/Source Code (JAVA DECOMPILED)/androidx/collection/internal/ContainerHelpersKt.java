package androidx.collection.internal;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ContainerHelpersKt {
    public static final int[] EMPTY_INTS = new int[0];
    public static final long[] EMPTY_LONGS = new long[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(int[] array, int i2, int i3) {
        j.e(array, "array");
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = array[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    public static final boolean equal(Object obj, Object obj2) {
        return j.a(obj, obj2);
    }

    public static final int idealByteArraySize(int i2) {
        for (int i3 = 4; i3 < 32; i3++) {
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                return i4;
            }
        }
        return i2;
    }

    public static final int idealIntArraySize(int i2) {
        return idealByteArraySize(i2 * 4) / 4;
    }

    public static final int idealLongArraySize(int i2) {
        return idealByteArraySize(i2 * 8) / 8;
    }

    public static final int binarySearch(long[] array, int i2, long j) {
        j.e(array, "array");
        int i3 = i2 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            long j2 = array[i5];
            if (j2 < j) {
                i4 = i5 + 1;
            } else {
                if (j2 <= j) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }
}
