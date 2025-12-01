package androidx.collection;

import java.util.Iterator;
import z0.a;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$values$1$iterator$1<V> implements Iterator<V>, a {
    private int current = -1;
    private final Iterator<Integer> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$values$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = p.a.F(new MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1(mutableScatterMap, null));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        int iIntValue = this.iterator.next().intValue();
        this.current = iIntValue;
        return (V) this.this$0.values[iIntValue];
    }

    @Override // java.util.Iterator
    public void remove() {
        int i2 = this.current;
        if (i2 >= 0) {
            this.this$0.removeValueAt(i2);
            this.current = -1;
        }
    }
}
