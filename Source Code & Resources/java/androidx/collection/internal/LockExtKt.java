package androidx.collection.internal;

import kotlin.jvm.internal.j;
import y0.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class LockExtKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m31synchronized(Lock lock, a block) {
        T t2;
        j.e(lock, "<this>");
        j.e(block, "block");
        synchronized (lock) {
            t2 = (T) block.invoke();
        }
        return t2;
    }
}
