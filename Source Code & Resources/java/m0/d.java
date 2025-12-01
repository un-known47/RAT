package m0;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends e implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final e f860a;

    /* renamed from: b, reason: collision with root package name */
    public final int f861b;
    public final int c;

    public d(e eVar, int i2, int i3) {
        this.f860a = eVar;
        this.f861b = i2;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.c(i2, i3, size);
        this.c = i3 - i2;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        e.Companion.getClass();
        b.a(i2, this.c);
        return this.f860a.get(this.f861b + i2);
    }

    @Override // m0.a
    public final int getSize() {
        return this.c;
    }

    @Override // m0.e, java.util.List
    public final List subList(int i2, int i3) {
        e.Companion.getClass();
        b.c(i2, i3, this.c);
        int i4 = this.f861b;
        return new d(this.f860a, i2 + i4, i4 + i3);
    }
}
