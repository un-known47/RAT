package y;

import i.r;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f1213a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1214b = new Object();
    public final b c;

    public e(Executor executor, b bVar) {
        this.f1213a = executor;
        this.c = bVar;
    }

    public final void a(g gVar) {
        synchronized (this.f1214b) {
        }
        this.f1213a.execute(new r(8, this, gVar));
    }
}
