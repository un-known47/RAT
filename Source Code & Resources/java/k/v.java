package k;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class v implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f766a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f767b;

    public v(com.google.android.gms.common.internal.a aVar, int i2) {
        this.f767b = aVar;
        this.f766a = i2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.common.internal.a aVar = this.f767b;
        if (iBinder == null) {
            com.google.android.gms.common.internal.a.u(aVar);
            return;
        }
        synchronized (aVar.f237g) {
            try {
                com.google.android.gms.common.internal.a aVar2 = this.f767b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar2.f238h = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof r)) ? new r(iBinder) : (r) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.common.internal.a aVar3 = this.f767b;
        int i2 = this.f766a;
        x xVar = new x(aVar3, 0);
        t tVar = aVar3.f235e;
        tVar.sendMessage(tVar.obtainMessage(7, i2, -1, xVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.a aVar;
        synchronized (this.f767b.f237g) {
            aVar = this.f767b;
            aVar.f238h = null;
        }
        int i2 = this.f766a;
        t tVar = aVar.f235e;
        tVar.sendMessage(tVar.obtainMessage(6, i2, 1));
    }
}
