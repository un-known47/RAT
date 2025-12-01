package s;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import i.r;
import i.z;
import k.d0;
import v.d;
import v.j;
import x.e;
import y.g;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a extends Binder implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1177a;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i2 = this.f1177a;
        return this;
    }

    public boolean d(int i2, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
        switch (this.f1177a) {
            case 0:
                if (i2 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i2, parcel, parcel2, i3)) {
                    return true;
                }
                return d(i2, parcel, parcel2);
            case 1:
                if (i2 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i2, parcel, parcel2, i3)) {
                    return true;
                }
                j jVar = (j) this;
                if (i2 == 1) {
                    throw new UnsupportedOperationException();
                }
                if (i2 == 2) {
                    parcel.readString();
                    throw new UnsupportedOperationException();
                }
                if (i2 == 3) {
                    throw new UnsupportedOperationException();
                }
                if (i2 == 4) {
                    Status status = (Status) t.b.a(parcel, Status.CREATOR);
                    boolean z2 = parcel.readInt() != 0;
                    d0 d0Var = new d0();
                    d0Var.f719b = status;
                    d0Var.f718a = z2;
                    d dVar = new d();
                    dVar.f1191a = d0Var;
                    y.c cVar = jVar.f1198b;
                    if (status.f223a <= 0) {
                        cVar.a(dVar);
                        return true;
                    }
                    Exception jVar2 = status.c != null ? new h.j(status) : new h.d(status);
                    g gVar = cVar.f1211a;
                    gVar.getClass();
                    synchronized (gVar.f1217a) {
                        gVar.d();
                        gVar.c = true;
                        gVar.f1219e = jVar2;
                    }
                    gVar.f1218b.b(gVar);
                    return true;
                }
                if (i2 == 6) {
                    throw new UnsupportedOperationException();
                }
                if (i2 == 8) {
                    throw new UnsupportedOperationException();
                }
                if (i2 == 10) {
                    parcel.readInt();
                    throw new UnsupportedOperationException();
                }
                if (i2 == 11) {
                    throw new UnsupportedOperationException();
                }
                if (i2 == 15) {
                    throw new UnsupportedOperationException();
                }
                if (i2 != 16) {
                    return false;
                }
                parcel.readString();
                parcel.readInt();
                throw new UnsupportedOperationException();
            default:
                if (i2 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i2, parcel, parcel2, i3)) {
                    return true;
                }
                switch (i2) {
                    case 3:
                        r.b.b(parcel);
                        break;
                    case 4:
                        r.b.b(parcel);
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        r.b.b(parcel);
                        break;
                    case 7:
                        r.b.b(parcel);
                        break;
                    case 8:
                        e eVar = (e) r.b.a(parcel, e.CREATOR);
                        r.b.b(parcel);
                        z zVar = (z) this;
                        zVar.c.post(new r(1, zVar, eVar));
                        break;
                    case 9:
                        r.b.b(parcel);
                        break;
                }
                parcel2.writeNoException();
                return true;
        }
    }

    public a(String str) {
        this.f1177a = 0;
        attachInterface(this, str);
    }
}
