package androidx.collection;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class IntSetKt {
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);
    private static final int[] EmptyIntArray = new int[0];

    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int i2) {
        int i3 = i2 * ScatterMapKt.MurmurHashC1;
        return i3 ^ (i3 << 16);
    }

    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    public static final IntSet intSetOf(int i2) {
        return mutableIntSetOf(i2);
    }

    public static final MutableIntSet mutableIntSetOf(int i2) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i2);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int i2, int i3) {
        return mutableIntSetOf(i2, i3);
    }

    public static final IntSet intSetOf(int i2, int i3, int i4) {
        return mutableIntSetOf(i2, i3, i4);
    }

    public static final MutableIntSet mutableIntSetOf(int i2, int i3) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i2);
        mutableIntSet.plusAssign(i3);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int... elements) {
        j.e(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i2, int i3, int i4) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i2);
        mutableIntSet.plusAssign(i3);
        mutableIntSet.plusAssign(i4);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int... elements) {
        j.e(elements, "elements");
        MutableIntSet mutableIntSet = new MutableIntSet(elements.length);
        mutableIntSet.plusAssign(elements);
        return mutableIntSet;
    }
}
