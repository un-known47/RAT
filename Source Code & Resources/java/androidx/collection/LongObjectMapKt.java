package androidx.collection;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class LongObjectMapKt {
    private static final MutableLongObjectMap EmptyLongObjectMap = new MutableLongObjectMap(0);

    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        j.c(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.emptyLongObjectMap>");
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        j.c(mutableLongObjectMap, "null cannot be cast to non-null type androidx.collection.LongObjectMap<V of androidx.collection.LongObjectMapKt.longObjectMapOf>");
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap<>(0, 1, null);
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j2, V v3) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j2, V v3) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j2, V v3, long j3, V v4) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        mutableLongObjectMap.set(j3, v4);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j2, V v3, long j3, V v4) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        mutableLongObjectMap.set(j3, v4);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j2, V v3, long j3, V v4, long j4, V v5) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        mutableLongObjectMap.set(j3, v4);
        mutableLongObjectMap.set(j4, v5);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j2, V v3, long j3, V v4, long j4, V v5) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        mutableLongObjectMap.set(j3, v4);
        mutableLongObjectMap.set(j4, v5);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v2, long j2, V v3, long j3, V v4, long j4, V v5, long j5, V v6) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        mutableLongObjectMap.set(j3, v4);
        mutableLongObjectMap.set(j4, v5);
        mutableLongObjectMap.set(j5, v6);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v2, long j2, V v3, long j3, V v4, long j4, V v5, long j5, V v6) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v2);
        mutableLongObjectMap.set(j2, v3);
        mutableLongObjectMap.set(j3, v4);
        mutableLongObjectMap.set(j4, v5);
        mutableLongObjectMap.set(j5, v6);
        return mutableLongObjectMap;
    }
}
