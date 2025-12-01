package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f806a = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur = new j(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            j jVar = (j) this._cur;
            int iA = jVar.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f806a;
                j jVarE = jVar.e();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, jVar, jVarE) && atomicReferenceFieldUpdater.get(this) == jVar) {
                }
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            j jVar = (j) this._cur;
            if (jVar.b()) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f806a;
            j jVarE = jVar.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, jVar, jVarE) && atomicReferenceFieldUpdater.get(this) == jVar) {
            }
        }
    }

    public final int c() {
        return ((j) this._cur).c();
    }

    public final Object d() {
        while (true) {
            j jVar = (j) this._cur;
            Object objF = jVar.f();
            if (objF != j.f810g) {
                return objF;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f806a;
            j jVarE = jVar.e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, jVar, jVarE) && atomicReferenceFieldUpdater.get(this) == jVar) {
            }
        }
    }
}
