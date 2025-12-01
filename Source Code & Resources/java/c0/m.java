package c0;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class m implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public o f178a;

    /* renamed from: b, reason: collision with root package name */
    public o f179b = null;
    public int c;
    public final /* synthetic */ p d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f180e;

    public m(p pVar, int i2) {
        this.f180e = i2;
        this.d = pVar;
        this.f178a = pVar.f194f.d;
        this.c = pVar.f193e;
    }

    public final Object a() {
        return b();
    }

    public final o b() {
        o oVar = this.f178a;
        p pVar = this.d;
        if (oVar == pVar.f194f) {
            throw new NoSuchElementException();
        }
        if (pVar.f193e != this.c) {
            throw new ConcurrentModificationException();
        }
        this.f178a = oVar.d;
        this.f179b = oVar;
        return oVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f178a != this.d.f194f;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.f180e) {
            case 1:
                return b().f186f;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        o oVar = this.f179b;
        if (oVar == null) {
            throw new IllegalStateException();
        }
        p pVar = this.d;
        pVar.c(oVar, true);
        this.f179b = null;
        this.c = pVar.f193e;
    }
}
