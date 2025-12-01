package c1;

import java.util.NoSuchElementException;
import m0.t;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends t {

    /* renamed from: a, reason: collision with root package name */
    public final int f207a;

    /* renamed from: b, reason: collision with root package name */
    public final int f208b;
    public boolean c;
    public int d;

    public c(int i2, int i3, int i4) {
        this.f207a = i4;
        this.f208b = i3;
        boolean z2 = false;
        if (i4 <= 0 ? i2 >= i3 : i2 <= i3) {
            z2 = true;
        }
        this.c = z2;
        this.d = z2 ? i2 : i3;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // m0.t
    public final int nextInt() {
        int i2 = this.d;
        if (i2 != this.f208b) {
            this.d = this.f207a + i2;
            return i2;
        }
        if (!this.c) {
            throw new NoSuchElementException();
        }
        this.c = false;
        return i2;
    }
}
