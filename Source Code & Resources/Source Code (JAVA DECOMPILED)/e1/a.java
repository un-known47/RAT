package e1;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a implements i {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f431a;

    public a(m mVar) {
        this.f431a = new AtomicReference(mVar);
    }

    @Override // e1.i
    public final Iterator iterator() {
        i iVar = (i) this.f431a.getAndSet(null);
        if (iVar != null) {
            return iVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
