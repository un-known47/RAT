package q1;

import java.util.concurrent.CompletableFuture;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends CompletableFuture {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f1090a;

    public j(b0 b0Var) {
        this.f1090a = b0Var;
    }

    @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
    public final boolean cancel(boolean z2) {
        if (z2) {
            this.f1090a.cancel();
        }
        return super.cancel(z2);
    }
}
