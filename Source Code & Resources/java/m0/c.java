package m0;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends e1.b implements ListIterator {
    public final /* synthetic */ e d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, int i2) {
        super(eVar);
        this.d = eVar;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.b(i2, size);
        this.f433b = i2;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f433b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f433b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i2 = this.f433b - 1;
        this.f433b = i2;
        return this.d.get(i2);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f433b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
