package i;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a0 extends v {

    /* renamed from: b, reason: collision with root package name */
    public final i f585b;
    public final y.c c;
    public final g.g d;

    public a0(int i2, i iVar, y.c cVar, g.g gVar) {
        super(i2);
        this.c = cVar;
        this.f585b = iVar;
        this.d = gVar;
        if (i2 == 2 && iVar.f610b) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // i.v
    public final boolean a(p pVar) {
        return this.f585b.f610b;
    }

    @Override // i.v
    public final g.c[] b(p pVar) {
        return this.f585b.f609a;
    }

    @Override // i.v
    public final void c(Status status) {
        this.d.getClass();
        this.c.b(status.c != null ? new h.j(status) : new h.d(status));
    }

    @Override // i.v
    public final void d(Exception exc) {
        this.c.b(exc);
    }

    @Override // i.v
    public final void e(p pVar) throws DeadObjectException {
        y.c cVar = this.c;
        try {
            i iVar = this.f585b;
            ((h) ((i) iVar.d).d).accept(pVar.f625b, cVar);
        } catch (DeadObjectException e2) {
            throw e2;
        } catch (RemoteException e3) {
            c(v.g(e3));
        } catch (RuntimeException e4) {
            cVar.b(e4);
        }
    }

    @Override // i.v
    public final void f(h.c cVar, boolean z2) {
        y.c cVar2 = this.c;
        ((Map) cVar.c).put(cVar2, Boolean.valueOf(z2));
        y.g gVar = cVar2.f1211a;
        h.c cVar3 = new h.c(1, cVar, cVar2);
        gVar.getClass();
        gVar.f1218b.a(new y.e(y.d.f1212a, cVar3));
        synchronized (gVar.f1217a) {
            try {
                if (gVar.c) {
                    gVar.f1218b.b(gVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
