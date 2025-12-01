package androidx.collection;

import java.util.Map;
import z0.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class MapEntry<K, V> implements Map.Entry<K, V>, a {
    private final K key;
    private final V value;

    public MapEntry(K k2, V v2) {
        this.key = k2;
        this.value = v2;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
