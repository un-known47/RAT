package androidx.collection;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ObjectLongMapKt {
    private static final MutableObjectLongMap<Object> EmptyObjectLongMap = new MutableObjectLongMap<>(0);

    public static final <K> ObjectLongMap<K> emptyObjectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        j.c(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.emptyObjectLongMap>");
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf() {
        return new MutableObjectLongMap<>(0, 1, null);
    }

    public static final <K> ObjectLongMap<K> objectLongMap() {
        MutableObjectLongMap<Object> mutableObjectLongMap = EmptyObjectLongMap;
        j.c(mutableObjectLongMap, "null cannot be cast to non-null type androidx.collection.ObjectLongMap<K of androidx.collection.ObjectLongMapKt.objectLongMap>");
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k2, long j) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k2, long j) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k2, long j, K k3, long j2) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k2, long j, K k3, long j2) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k2, long j, K k3, long j2, K k4, long j3) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        mutableObjectLongMap.set(k4, j3);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k2, long j, K k3, long j2, K k4, long j3) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        mutableObjectLongMap.set(k4, j3);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k2, long j, K k3, long j2, K k4, long j3, K k5, long j4) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        mutableObjectLongMap.set(k4, j3);
        mutableObjectLongMap.set(k5, j4);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k2, long j, K k3, long j2, K k4, long j3, K k5, long j4) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        mutableObjectLongMap.set(k4, j3);
        mutableObjectLongMap.set(k5, j4);
        return mutableObjectLongMap;
    }

    public static final <K> ObjectLongMap<K> objectLongMapOf(K k2, long j, K k3, long j2, K k4, long j3, K k5, long j4, K k6, long j5) {
        MutableObjectLongMap mutableObjectLongMap = new MutableObjectLongMap(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        mutableObjectLongMap.set(k4, j3);
        mutableObjectLongMap.set(k5, j4);
        mutableObjectLongMap.set(k6, j5);
        return mutableObjectLongMap;
    }

    public static final <K> MutableObjectLongMap<K> mutableObjectLongMapOf(K k2, long j, K k3, long j2, K k4, long j3, K k5, long j4, K k6, long j5) {
        MutableObjectLongMap<K> mutableObjectLongMap = new MutableObjectLongMap<>(0, 1, null);
        mutableObjectLongMap.set(k2, j);
        mutableObjectLongMap.set(k3, j2);
        mutableObjectLongMap.set(k4, j3);
        mutableObjectLongMap.set(k5, j4);
        mutableObjectLongMap.set(k6, j5);
        return mutableObjectLongMap;
    }
}
