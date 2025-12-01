package o1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i0 implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final n f906a;

    /* renamed from: b, reason: collision with root package name */
    public final l f907b;
    public l0 c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f908e;

    /* renamed from: f, reason: collision with root package name */
    public long f909f;

    public i0(n nVar) {
        this.f906a = nVar;
        l lVarB = nVar.b();
        this.f907b = lVarB;
        l0 l0Var = lVarB.f918a;
        this.c = l0Var;
        this.d = l0Var != null ? l0Var.f921b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f908e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r5.f921b) goto L15;
     */
    @Override // o1.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long read(o1.l r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.j.e(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6b
            boolean r3 = r8.f908e
            if (r3 != 0) goto L63
            o1.l0 r3 = r8.c
            o1.l r4 = r8.f907b
            if (r3 == 0) goto L2b
            o1.l0 r5 = r4.f918a
            if (r3 != r5) goto L23
            int r3 = r8.d
            kotlin.jvm.internal.j.b(r5)
            int r5 = r5.f921b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f909f
            r2 = 1
            long r0 = r0 + r2
            o1.n r2 = r8.f906a
            boolean r0 = r2.k(r0)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            o1.l0 r0 = r8.c
            if (r0 != 0) goto L4c
            o1.l0 r0 = r4.f918a
            if (r0 == 0) goto L4c
            r8.c = r0
            int r0 = r0.f921b
            r8.d = r0
        L4c:
            long r0 = r4.f919b
            long r2 = r8.f909f
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            o1.l r2 = r8.f907b
            long r3 = r8.f909f
            r5 = r9
            r2.G(r3, r5, r6)
            long r9 = r8.f909f
            long r9 = r9 + r6
            r8.f909f = r9
            return r6
        L63:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L6b:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = androidx.appcompat.app.g.f(r9, r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.i0.read(o1.l, long):long");
    }

    @Override // o1.p0
    public final s0 timeout() {
        return this.f906a.timeout();
    }
}
