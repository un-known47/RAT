package i1;

import h1.q;
import p0.g;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends p0.a implements g {
    private volatile Object _preHandler;

    public b() {
        super(q.f561a);
        this._preHandler = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void D(java.lang.Throwable r4) {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r1 > r0) goto L4a
            r1 = 28
            if (r0 >= r1) goto L4a
            java.lang.Object r0 = r3._preHandler
            r1 = 0
            if (r0 == r3) goto L12
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0
            goto L32
        L12:
            java.lang.Class<java.lang.Thread> r0 = java.lang.Thread.class
            java.lang.String r2 = "getUncaughtExceptionPreHandler"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r1)     // Catch: java.lang.Throwable -> L2f
            int r2 = r0.getModifiers()     // Catch: java.lang.Throwable -> L2f
            boolean r2 = java.lang.reflect.Modifier.isPublic(r2)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2f
            int r2 = r0.getModifiers()     // Catch: java.lang.Throwable -> L2f
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch: java.lang.Throwable -> L2f
            if (r2 == 0) goto L2f
            goto L30
        L2f:
            r0 = r1
        L30:
            r3._preHandler = r0
        L32:
            if (r0 == 0) goto L39
            java.lang.Object r0 = r0.invoke(r1, r1)
            goto L3a
        L39:
            r0 = r1
        L3a:
            boolean r2 = r0 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r2 == 0) goto L41
            r1 = r0
            java.lang.Thread$UncaughtExceptionHandler r1 = (java.lang.Thread.UncaughtExceptionHandler) r1
        L41:
            if (r1 == 0) goto L4a
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r1.uncaughtException(r0, r4)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.b.D(java.lang.Throwable):void");
    }
}
