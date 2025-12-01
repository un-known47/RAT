package androidx.collection;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class LongSetKt {
    private static final MutableLongSet EmptyLongSet = new MutableLongSet(0);
    private static final long[] EmptyLongArray = new long[0];

    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final int hash(long j) {
        int i2 = ((int) (j ^ (j >>> 32))) * ScatterMapKt.MurmurHashC1;
        return (i2 << 16) ^ i2;
    }

    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, null);
    }

    public static final LongSet longSetOf(long j) {
        return mutableLongSetOf(j);
    }

    public static final MutableLongSet mutableLongSetOf(long j) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        mutableLongSet.plusAssign(j);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long j, long j2) {
        return mutableLongSetOf(j, j2);
    }

    public static final LongSet longSetOf(long j, long j2, long j3) {
        return mutableLongSetOf(j, j2, j3);
    }

    public static final MutableLongSet mutableLongSetOf(long j, long j2) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j2);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long... elements) {
        j.e(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long j, long j2, long j3) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j2);
        mutableLongSet.plusAssign(j3);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long... elements) {
        j.e(elements, "elements");
        MutableLongSet mutableLongSet = new MutableLongSet(elements.length);
        mutableLongSet.plusAssign(elements);
        return mutableLongSet;
    }
}
