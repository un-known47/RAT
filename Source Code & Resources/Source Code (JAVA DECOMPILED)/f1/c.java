package f1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c implements Iterator, z0.a {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f465a;

    /* renamed from: b, reason: collision with root package name */
    public int f466b;
    public int c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f467e;

    public c(CharSequence string) {
        kotlin.jvm.internal.j.e(string, "string");
        this.f465a = string;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2;
        int i3;
        int i4 = this.f466b;
        if (i4 != 0) {
            return i4 == 1;
        }
        if (this.f467e < 0) {
            this.f466b = 2;
            return false;
        }
        CharSequence charSequence = this.f465a;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i5 = this.c; i5 < length2; i5++) {
            char cCharAt = charSequence.charAt(i5);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i2 = (cCharAt == '\r' && (i3 = i5 + 1) < charSequence.length() && charSequence.charAt(i3) == '\n') ? 2 : 1;
                length = i5;
                this.f466b = 1;
                this.f467e = i2;
                this.d = length;
                return true;
            }
        }
        i2 = -1;
        this.f466b = 1;
        this.f467e = i2;
        this.d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f466b = 0;
        int i2 = this.d;
        int i3 = this.c;
        this.c = this.f467e + i2;
        return this.f465a.subSequence(i3, i2).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
