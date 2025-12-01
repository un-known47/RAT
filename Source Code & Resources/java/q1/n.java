package q1;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1093a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.c f1094b;
    public final /* synthetic */ g c;
    public final /* synthetic */ Object d;

    public /* synthetic */ n(h.c cVar, g gVar, Object obj, int i2) {
        this.f1093a = i2;
        this.f1094b = cVar;
        this.c = gVar;
        this.d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1093a) {
            case 0:
                s0 s0Var = (s0) this.d;
                o oVar = (o) this.f1094b.c;
                boolean zIsCanceled = oVar.f1097b.isCanceled();
                g gVar = this.c;
                if (!zIsCanceled) {
                    gVar.b(oVar, s0Var);
                    break;
                } else {
                    gVar.e(oVar, new IOException("Canceled"));
                    break;
                }
            default:
                Throwable th = (Throwable) this.d;
                this.c.e((o) this.f1094b.c, th);
                break;
        }
    }
}
