package androidx.core.util;

import l0.i;
import p0.d;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class RunnableKt {
    public static final Runnable asRunnable(d<? super i> dVar) {
        return new ContinuationRunnable(dVar);
    }
}
