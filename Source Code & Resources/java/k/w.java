package k;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class w extends p {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f768g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f769h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(com.google.android.gms.common.internal.a aVar, int i2, IBinder iBinder, Bundle bundle) {
        super(aVar, i2, bundle);
        this.f769h = aVar;
        this.f768g = iBinder;
    }

    @Override // k.p
    public final void a(g.a aVar) {
        h hVar = this.f769h.o;
        if (hVar != null) {
            ((h.h) hVar.f741a).c(aVar);
        }
        System.currentTimeMillis();
    }

    @Override // k.p
    public final boolean b() throws RemoteException {
        IInterface iInterfaceN;
        IBinder iBinder = this.f768g;
        try {
            s.b(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            com.google.android.gms.common.internal.a aVar = this.f769h;
            if (!aVar.r().equals(interfaceDescriptor) || (iInterfaceN = aVar.n(iBinder)) == null) {
                return false;
            }
            if (!com.google.android.gms.common.internal.a.v(aVar, 2, 4, iInterfaceN) && !com.google.android.gms.common.internal.a.v(aVar, 3, 4, iInterfaceN)) {
                return false;
            }
            aVar.f247s = null;
            h hVar = aVar.f243n;
            if (hVar == null) {
                return true;
            }
            ((h.g) hVar.f741a).b();
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
