package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class TreeIterator<T> implements Iterator<T>, z0.a {
    private final y0.l getChildIterator;
    private Iterator<? extends T> iterator;
    private final List<Iterator<T>> stack = new ArrayList();

    public TreeIterator(Iterator<? extends T> it, y0.l lVar) {
        this.getChildIterator = lVar;
        this.iterator = it;
    }

    private final void prepareNextIterator(T t2) {
        Iterator<? extends T> it = (Iterator) this.getChildIterator.invoke(t2);
        if (it != null && it.hasNext()) {
            this.stack.add(this.iterator);
            this.iterator = it;
            return;
        }
        while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
            this.iterator = (Iterator) m0.k.t0(this.stack);
            List<Iterator<T>> list = this.stack;
            kotlin.jvm.internal.j.e(list, "<this>");
            if (list.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            list.remove(m0.l.g0(list));
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
