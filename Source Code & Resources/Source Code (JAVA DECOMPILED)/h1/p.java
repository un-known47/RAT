package h1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class p extends p0.a implements p0.f {
    public static final o Key = new o(p0.e.f988a, n.f557a);

    public p() {
        super(p0.e.f988a);
    }

    public abstract void dispatch(p0.i iVar, Runnable runnable);

    public void dispatchYield(p0.i iVar, Runnable runnable) {
        dispatch(iVar, runnable);
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [kotlin.jvm.internal.k, y0.l] */
    @Override // p0.a, p0.i
    public <E extends p0.g> E get(p0.h key) {
        E e2;
        kotlin.jvm.internal.j.e(key, "key");
        if (!(key instanceof o)) {
            if (p0.e.f988a == key) {
                return this;
            }
            return null;
        }
        o oVar = (o) key;
        p0.h key2 = getKey();
        kotlin.jvm.internal.j.e(key2, "key");
        if ((key2 == oVar || oVar.f559b == key2) && (e2 = (E) oVar.f558a.invoke(this)) != null) {
            return e2;
        }
        return null;
    }

    @Override // p0.f
    public final <T> p0.d<T> interceptContinuation(p0.d<? super T> dVar) {
        return new kotlinx.coroutines.internal.d(this, dVar);
    }

    public boolean isDispatchNeeded(p0.i iVar) {
        return !(this instanceof d1);
    }

    public p limitedParallelism(int i2) {
        kotlinx.coroutines.internal.b.a(i2);
        return new kotlinx.coroutines.internal.e(this, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (((p0.g) r3.f558a.invoke(r2)) == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
    
        if (p0.e.f988a == r3) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        return p0.j.f989a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        return r2;
     */
    /* JADX WARN: Type inference failed for: r3v3, types: [kotlin.jvm.internal.k, y0.l] */
    @Override // p0.a, p0.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p0.i minusKey(p0.h r3) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.j.e(r3, r0)
            boolean r1 = r3 instanceof h1.o
            if (r1 == 0) goto L25
            h1.o r3 = (h1.o) r3
            p0.h r1 = r2.getKey()
            kotlin.jvm.internal.j.e(r1, r0)
            if (r1 == r3) goto L1a
            p0.h r0 = r3.f559b
            if (r0 != r1) goto L19
            goto L1a
        L19:
            return r2
        L1a:
            kotlin.jvm.internal.k r3 = r3.f558a
            java.lang.Object r3 = r3.invoke(r2)
            p0.g r3 = (p0.g) r3
            if (r3 == 0) goto L2c
            goto L29
        L25:
            p0.e r0 = p0.e.f988a
            if (r0 != r3) goto L2c
        L29:
            p0.j r3 = p0.j.f989a
            return r3
        L2c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.p.minusKey(p0.h):p0.i");
    }

    @Override // p0.f
    public final void releaseInterceptedContinuation(p0.d<?> dVar) {
        ((kotlinx.coroutines.internal.d) dVar).i();
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + u.c(this);
    }

    public final p plus(p pVar) {
        return pVar;
    }
}
