package k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class r implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f761a;

    public r(IBinder iBinder) {
        this.f761a = iBinder;
    }

    public final void a(u uVar, e eVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(uVar);
            parcelObtain.writeInt(1);
            e.a.a(eVar, parcelObtain, 0);
            this.f761a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f761a;
    }
}
