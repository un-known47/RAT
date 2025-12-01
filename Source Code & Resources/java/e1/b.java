package e1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class b implements Iterator, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f432a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f433b;
    public final Object c;

    public b(Object[] array) {
        kotlin.jvm.internal.j.e(array, "array");
        this.c = array;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f432a) {
            case 0:
                Iterator it = (Iterator) this.c;
                while (this.f433b > 0 && it.hasNext()) {
                    it.next();
                    this.f433b--;
                }
                return it.hasNext();
            case 1:
                return this.f433b < ((Object[]) this.c).length;
            default:
                return this.f433b < ((m0.e) this.c).size();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f432a) {
            case 0:
                Iterator it = (Iterator) this.c;
                while (this.f433b > 0 && it.hasNext()) {
                    it.next();
                    this.f433b--;
                }
                return it.next();
            case 1:
                try {
                    Object[] objArr = (Object[]) this.c;
                    int i2 = this.f433b;
                    this.f433b = i2 + 1;
                    return objArr[i2];
                } catch (ArrayIndexOutOfBoundsException e2) {
                    this.f433b--;
                    throw new NoSuchElementException(e2.getMessage());
                }
            default:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                m0.e eVar = (m0.e) this.c;
                int i3 = this.f433b;
                this.f433b = i3 + 1;
                return eVar.get(i3);
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f432a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public b(m0.e eVar) {
        this.c = eVar;
    }

    public b(c cVar) {
        this.c = cVar.f434a.iterator();
        this.f433b = cVar.f435b;
    }
}
