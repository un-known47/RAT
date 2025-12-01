package y;

import a0.s;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1217a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final f f1218b = new f();
    public boolean c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public Exception f1219e;

    public final Exception a() {
        Exception exc;
        synchronized (this.f1217a) {
            exc = this.f1219e;
        }
        return exc;
    }

    public final Object b() {
        Object obj;
        synchronized (this.f1217a) {
            try {
                if (!this.c) {
                    throw new IllegalStateException("Task is not yet complete");
                }
                Exception exc = this.f1219e;
                if (exc != null) {
                    throw new s(exc);
                }
                obj = this.d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public final boolean c() {
        boolean z2;
        synchronized (this.f1217a) {
            try {
                z2 = false;
                if (this.c && this.f1219e == null) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    public final void d() {
        boolean z2;
        if (this.c) {
            int i2 = a.f1210a;
            synchronized (this.f1217a) {
                z2 = this.c;
            }
            if (!z2) {
                throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            }
            Exception excA = a();
        }
    }
}
