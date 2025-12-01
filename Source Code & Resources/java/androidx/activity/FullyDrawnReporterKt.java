package androidx.activity;

import l0.i;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class FullyDrawnReporterKt {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @r0.e(c = "androidx.activity.FullyDrawnReporterKt", f = "FullyDrawnReporter.kt", l = {185}, m = "reportWhenComplete")
    /* renamed from: androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1, reason: invalid class name */
    public static final class AnonymousClass1 extends r0.c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(p0.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // r0.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FullyDrawnReporterKt.reportWhenComplete(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object reportWhenComplete(androidx.activity.FullyDrawnReporter r5, y0.l r6, p0.d<? super l0.i> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.activity.FullyDrawnReporterKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            q0.a r1 = q0.a.f1043a
            int r2 = r0.label
            l0.i r3 = l0.i.f856a
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r5 = r0.L$0
            androidx.activity.FullyDrawnReporter r5 = (androidx.activity.FullyDrawnReporter) r5
            p.a.S(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r6 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            p.a.S(r7)
            r5.addReporter()
            boolean r7 = r5.isFullyDrawnReported()
            if (r7 == 0) goto L44
            return r3
        L44:
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2d
            r0.label = r4     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r6 = r6.invoke(r0)     // Catch: java.lang.Throwable -> L2d
            if (r6 != r1) goto L4f
            return r1
        L4f:
            r5.removeReporter()
            return r3
        L53:
            r5.removeReporter()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.reportWhenComplete(androidx.activity.FullyDrawnReporter, y0.l, p0.d):java.lang.Object");
    }

    private static final Object reportWhenComplete$$forInline(FullyDrawnReporter fullyDrawnReporter, l lVar, p0.d<? super i> dVar) {
        fullyDrawnReporter.addReporter();
        boolean zIsFullyDrawnReported = fullyDrawnReporter.isFullyDrawnReported();
        i iVar = i.f856a;
        if (zIsFullyDrawnReported) {
            return iVar;
        }
        try {
            lVar.invoke(dVar);
            return iVar;
        } finally {
            fullyDrawnReporter.removeReporter();
        }
    }
}
