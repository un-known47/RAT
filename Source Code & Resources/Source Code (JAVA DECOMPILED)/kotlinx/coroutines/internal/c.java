package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class c extends l {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f796a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = b.f793a;

    @Override // kotlinx.coroutines.internal.l
    public final Object a(Object obj) {
        Object obj2 = this._consensus;
        i.o oVar = b.f793a;
        if (obj2 == oVar) {
            i.o oVarC = c(obj);
            obj2 = this._consensus;
            if (obj2 == oVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f796a;
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, oVar, oVarC)) {
                        obj2 = oVarC;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != oVar) {
                        obj2 = this._consensus;
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract i.o c(Object obj);
}
