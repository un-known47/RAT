package q1;

import java.util.concurrent.Executor;
import okhttp3.Request;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class o implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f1096a;

    /* renamed from: b, reason: collision with root package name */
    public final d f1097b;

    public o(Executor executor, d dVar) {
        this.f1096a = executor;
        this.f1097b = dVar;
    }

    @Override // q1.d
    public final void D(g gVar) {
        this.f1097b.D(new h.c(7, this, gVar));
    }

    @Override // q1.d
    public final void cancel() {
        this.f1097b.cancel();
    }

    @Override // q1.d
    public final s0 execute() {
        return this.f1097b.execute();
    }

    @Override // q1.d
    public final boolean isCanceled() {
        return this.f1097b.isCanceled();
    }

    @Override // q1.d
    public final Request request() {
        return this.f1097b.request();
    }

    @Override // q1.d
    public final d clone() {
        return new o(this.f1096a, this.f1097b.clone());
    }
}
