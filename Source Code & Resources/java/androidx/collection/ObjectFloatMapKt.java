package androidx.collection;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ObjectFloatMapKt {
    private static final MutableObjectFloatMap<Object> EmptyObjectFloatMap = new MutableObjectFloatMap<>(0);

    public static final <K> ObjectFloatMap<K> emptyObjectFloatMap() {
        MutableObjectFloatMap<Object> mutableObjectFloatMap = EmptyObjectFloatMap;
        j.c(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.emptyObjectFloatMap>");
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf() {
        return new MutableObjectFloatMap<>(0, 1, null);
    }

    public static final <K> ObjectFloatMap<K> objectFloatMap() {
        MutableObjectFloatMap<Object> mutableObjectFloatMap = EmptyObjectFloatMap;
        j.c(mutableObjectFloatMap, "null cannot be cast to non-null type androidx.collection.ObjectFloatMap<K of androidx.collection.ObjectFloatMapKt.objectFloatMap>");
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k2, float f2) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k2, float f2) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k2, float f2, K k3, float f3) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k2, float f2, K k3, float f3) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k2, float f2, K k3, float f3, K k4, float f4) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k2, float f2, K k3, float f3, K k4, float f4) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k2, float f2, K k3, float f3, K k4, float f4, K k5, float f5) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        mutableObjectFloatMap.set(k5, f5);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k2, float f2, K k3, float f3, K k4, float f4, K k5, float f5) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        mutableObjectFloatMap.set(k5, f5);
        return mutableObjectFloatMap;
    }

    public static final <K> ObjectFloatMap<K> objectFloatMapOf(K k2, float f2, K k3, float f3, K k4, float f4, K k5, float f5, K k6, float f6) {
        MutableObjectFloatMap mutableObjectFloatMap = new MutableObjectFloatMap(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        mutableObjectFloatMap.set(k5, f5);
        mutableObjectFloatMap.set(k6, f6);
        return mutableObjectFloatMap;
    }

    public static final <K> MutableObjectFloatMap<K> mutableObjectFloatMapOf(K k2, float f2, K k3, float f3, K k4, float f4, K k5, float f5, K k6, float f6) {
        MutableObjectFloatMap<K> mutableObjectFloatMap = new MutableObjectFloatMap<>(0, 1, null);
        mutableObjectFloatMap.set(k2, f2);
        mutableObjectFloatMap.set(k3, f3);
        mutableObjectFloatMap.set(k4, f4);
        mutableObjectFloatMap.set(k5, f5);
        mutableObjectFloatMap.set(k6, f6);
        return mutableObjectFloatMap;
    }
}
