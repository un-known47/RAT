package i;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public final int f644a;

    public v(int i2) {
        this.f644a = i2;
    }

    public static Status g(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean a(p pVar);

    public abstract g.c[] b(p pVar);

    public abstract void c(Status status);

    public abstract void d(Exception exc);

    public abstract void e(p pVar);

    public abstract void f(h.c cVar, boolean z2);
}
