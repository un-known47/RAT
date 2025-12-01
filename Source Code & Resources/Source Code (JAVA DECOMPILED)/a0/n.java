package a0;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class n extends o implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16a = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof n) && ((n) obj).f16a.equals(this.f16a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f16a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f16a.iterator();
    }
}
