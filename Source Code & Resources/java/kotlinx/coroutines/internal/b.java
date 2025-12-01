package kotlinx.coroutines.internal;

import h1.b1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final i.o f793a;

    /* renamed from: b, reason: collision with root package name */
    public static final i.o f794b;
    public static final i.o c;
    public static final i.o d;

    /* renamed from: e, reason: collision with root package name */
    public static final i.o f795e;

    static {
        int i2 = 2;
        f793a = new i.o(i2, "NO_DECISION");
        f794b = new i.o(i2, "UNDEFINED");
        c = new i.o(i2, "REUSABLE_CLAIMED");
        d = new i.o(i2, "CONDITION_FALSE");
        f795e = new i.o(i2, "NO_THREAD_ELEMENTS");
    }

    public static final void a(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.c(i2, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final void b(p0.i iVar, Object obj) {
        if (obj == f795e) {
            return;
        }
        if (!(obj instanceof r)) {
            Object objFold = iVar.fold(null, q.c);
            if (objFold == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            }
            androidx.appcompat.app.g.u(objFold);
            throw null;
        }
        r rVar = (r) obj;
        b1[] b1VarArr = rVar.f819b;
        int length = b1VarArr.length - 1;
        if (length < 0) {
            return;
        }
        b1 b1Var = b1VarArr[length];
        kotlin.jvm.internal.j.b(null);
        Object obj2 = rVar.f818a[length];
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0090 A[Catch: all -> 0x006f, DONT_GENERATE, TryCatch #2 {all -> 0x006f, blocks: (B:16:0x004a, B:18:0x0058, B:20:0x005e, B:33:0x0093, B:23:0x0071, B:25:0x007f, B:30:0x008a, B:32:0x0090, B:38:0x00a0, B:41:0x00a9, B:40:0x00a6, B:28:0x0085), top: B:54:0x004a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(java.lang.Object r9, p0.d r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.internal.d
            if (r0 == 0) goto Lb4
            kotlinx.coroutines.internal.d r10 = (kotlinx.coroutines.internal.d) r10
            h1.p r0 = r10.d
            p0.d r1 = r10.f798e
            java.lang.Throwable r2 = l0.f.a(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            h1.k r3 = new h1.k
            r4 = 0
            r3.<init>(r4, r2)
        L18:
            p0.i r2 = r1.getContext()
            boolean r2 = r0.isDispatchNeeded(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.f799f = r3
            r10.c = r4
            p0.i r9 = r1.getContext()
            r0.dispatch(r9, r10)
            return
        L2f:
            h1.g0 r0 = h1.c1.a()
            long r5 = r0.f542a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r10.f799f = r3
            r10.c = r4
            r0.E(r10)
            goto Lae
        L46:
            r0.G(r4)
            r2 = 0
            p0.i r4 = r1.getContext()     // Catch: java.lang.Throwable -> L6f
            h1.q r5 = h1.q.f562b     // Catch: java.lang.Throwable -> L6f
            p0.g r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L6f
            h1.n0 r4 = (h1.n0) r4     // Catch: java.lang.Throwable -> L6f
            if (r4 == 0) goto L71
            boolean r5 = r4.a()     // Catch: java.lang.Throwable -> L6f
            if (r5 != 0) goto L71
            h1.u0 r4 = (h1.u0) r4     // Catch: java.lang.Throwable -> L6f
            java.util.concurrent.CancellationException r9 = r4.l()     // Catch: java.lang.Throwable -> L6f
            r10.a(r3, r9)     // Catch: java.lang.Throwable -> L6f
            l0.e r9 = p.a.p(r9)     // Catch: java.lang.Throwable -> L6f
            r10.resumeWith(r9)     // Catch: java.lang.Throwable -> L6f
            goto L93
        L6f:
            r9 = move-exception
            goto Laa
        L71:
            java.lang.Object r3 = r10.f800g     // Catch: java.lang.Throwable -> L6f
            p0.i r4 = r1.getContext()     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r3 = g(r4, r3)     // Catch: java.lang.Throwable -> L6f
            i.o r5 = kotlinx.coroutines.internal.b.f795e     // Catch: java.lang.Throwable -> L6f
            if (r3 == r5) goto L84
            h1.e1 r5 = h1.u.j(r1, r4, r3)     // Catch: java.lang.Throwable -> L6f
            goto L85
        L84:
            r5 = r2
        L85:
            r1.resumeWith(r9)     // Catch: java.lang.Throwable -> L9d
            if (r5 == 0) goto L90
            boolean r9 = r5.B()     // Catch: java.lang.Throwable -> L6f
            if (r9 == 0) goto L93
        L90:
            b(r4, r3)     // Catch: java.lang.Throwable -> L6f
        L93:
            boolean r9 = r0.H()     // Catch: java.lang.Throwable -> L6f
            if (r9 != 0) goto L93
        L99:
            r0.D()
            goto Lae
        L9d:
            r9 = move-exception
            if (r5 == 0) goto La6
            boolean r1 = r5.B()     // Catch: java.lang.Throwable -> L6f
            if (r1 == 0) goto La9
        La6:
            b(r4, r3)     // Catch: java.lang.Throwable -> L6f
        La9:
            throw r9     // Catch: java.lang.Throwable -> L6f
        Laa:
            r10.e(r9, r2)     // Catch: java.lang.Throwable -> Laf
            goto L99
        Lae:
            return
        Laf:
            r9 = move-exception
            r0.D()
            throw r9
        Lb4:
            r10.resumeWith(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.b.c(java.lang.Object, p0.d):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long e(long r22, long r24, long r26, java.lang.String r28) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.b.e(long, long, long, java.lang.String):long");
    }

    public static int f(String str, int i2, int i3) {
        return (int) e(i2, 1, (i3 & 8) != 0 ? Integer.MAX_VALUE : 2097150, str);
    }

    public static final Object g(p0.i iVar, Object obj) {
        if (obj == null) {
            obj = iVar.fold(0, q.f816b);
            kotlin.jvm.internal.j.b(obj);
        }
        if (obj == 0) {
            return f795e;
        }
        if (obj instanceof Integer) {
            return iVar.fold(new r(iVar, ((Number) obj).intValue()), q.d);
        }
        androidx.appcompat.app.g.u(obj);
        throw null;
    }
}
