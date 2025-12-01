package r0;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class c extends a {
    private final p0.i _context;
    private transient p0.d<Object> intercepted;

    public c(p0.d dVar, p0.i iVar) {
        super(dVar);
        this._context = iVar;
    }

    @Override // p0.d
    public p0.i getContext() {
        p0.i iVar = this._context;
        j.b(iVar);
        return iVar;
    }

    public final p0.d<Object> intercepted() {
        p0.d dVarInterceptContinuation = this.intercepted;
        if (dVarInterceptContinuation == null) {
            p0.f fVar = (p0.f) getContext().get(p0.e.f988a);
            if (fVar == null || (dVarInterceptContinuation = fVar.interceptContinuation(this)) == null) {
                dVarInterceptContinuation = this;
            }
            this.intercepted = dVarInterceptContinuation;
        }
        return dVarInterceptContinuation;
    }

    @Override // r0.a
    public void releaseIntercepted() {
        p0.d<Object> dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            p0.g gVar = getContext().get(p0.e.f988a);
            j.b(gVar);
            ((p0.f) gVar).releaseInterceptedContinuation(dVar);
        }
        this.intercepted = b.f1171a;
    }

    public c(p0.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
