package androidx.collection;

import java.util.Map;
import kotlin.jvm.internal.j;
import z0.c;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class MutableMapEntry<K, V> implements Map.Entry<K, V>, c {
    private final int index;
    private final Object[] keys;
    private final Object[] values;

    public MutableMapEntry(Object[] keys, Object[] values, int i2) {
        j.e(keys, "keys");
        j.e(values, "values");
        this.keys = keys;
        this.values = values;
        this.index = i2;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return (K) this.keys[this.index];
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return (V) this.values[this.index];
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v2) {
        Object[] objArr = this.values;
        int i2 = this.index;
        V v3 = (V) objArr[i2];
        objArr[i2] = v2;
        return v3;
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }
}
