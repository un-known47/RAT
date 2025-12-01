package y;

import k.s;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final g f1211a = new g();

    public final void a(v.d dVar) {
        g gVar = this.f1211a;
        synchronized (gVar.f1217a) {
            gVar.d();
            gVar.c = true;
            gVar.d = dVar;
        }
        gVar.f1218b.b(gVar);
    }

    public final void b(Exception exc) {
        g gVar = this.f1211a;
        gVar.getClass();
        s.c(exc, "Exception must not be null");
        synchronized (gVar.f1217a) {
            try {
                if (gVar.c) {
                    return;
                }
                gVar.c = true;
                gVar.f1219e = exc;
                gVar.f1218b.b(gVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
