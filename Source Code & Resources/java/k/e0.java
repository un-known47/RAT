package k;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e0 implements f, IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f732a;

    public e0(IBinder iBinder) {
        this.f732a = iBinder;
    }

    public final Account a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
        parcelObtain = Parcel.obtain();
        try {
            this.f732a.transact(2, parcelObtain, parcelObtain, 0);
            parcelObtain.readException();
            parcelObtain.recycle();
            return (Account) s.b.a(parcelObtain, Account.CREATOR);
        } catch (RuntimeException e2) {
            throw e2;
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f732a;
    }
}
