package y;

import java.util.ArrayDeque;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1215a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f1216b;
    public boolean c;

    public final void a(e eVar) {
        synchronized (this.f1215a) {
            try {
                if (this.f1216b == null) {
                    this.f1216b = new ArrayDeque();
                }
                this.f1216b.add(eVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(g gVar) {
        e eVar;
        synchronized (this.f1215a) {
            if (this.f1216b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.f1215a) {
                        try {
                            eVar = (e) this.f1216b.poll();
                            if (eVar == null) {
                                this.c = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    eVar.a(gVar);
                }
            }
        }
    }
}
