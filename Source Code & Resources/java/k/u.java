package k;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class u extends s.a {

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.common.internal.a f765b;
    public final int c;

    public u(com.google.android.gms.common.internal.a aVar, int i2) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.f765b = aVar;
        this.c = i2;
    }

    @Override // s.a
    public final boolean d(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) s.b.a(parcel, Bundle.CREATOR);
            s.b.b(parcel);
            s.c(this.f765b, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar = this.f765b;
            int i4 = this.c;
            aVar.getClass();
            w wVar = new w(aVar, i3, strongBinder, bundle);
            t tVar = aVar.f235e;
            tVar.sendMessage(tVar.obtainMessage(1, i4, -1, wVar));
            this.f765b = null;
        } else if (i2 == 2) {
            parcel.readInt();
            s.b.b(parcel);
            new Exception();
        } else {
            if (i2 != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            y yVar = (y) s.b.a(parcel, y.CREATOR);
            s.b.b(parcel);
            com.google.android.gms.common.internal.a aVar2 = this.f765b;
            s.c(aVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            s.b(yVar);
            aVar2.u = yVar;
            if (aVar2 instanceof t.a) {
                d dVar = yVar.d;
                h hVarB = h.b();
                i iVar = dVar == null ? null : dVar.f714a;
                synchronized (hVarB) {
                    if (iVar == null) {
                        iVar = h.c;
                    } else {
                        i iVar2 = (i) hVarB.f741a;
                        if (iVar2 == null || iVar2.f742a < iVar.f742a) {
                        }
                    }
                    hVarB.f741a = iVar;
                }
            }
            Bundle bundle2 = yVar.f771a;
            s.c(this.f765b, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar3 = this.f765b;
            int i6 = this.c;
            aVar3.getClass();
            w wVar2 = new w(aVar3, i5, strongBinder2, bundle2);
            t tVar2 = aVar3.f235e;
            tVar2.sendMessage(tVar2.obtainMessage(1, i6, -1, wVar2));
            this.f765b = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
