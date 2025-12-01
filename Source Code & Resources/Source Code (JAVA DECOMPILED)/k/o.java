package k;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class o extends l.a {
    public static final Parcelable.Creator<o> CREATOR = new e.a(9);

    /* renamed from: a, reason: collision with root package name */
    public final int f754a;

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f755b;
    public final g.a c;
    public final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f756e;

    public o(int i2, IBinder iBinder, g.a aVar, boolean z2, boolean z3) {
        this.f754a = i2;
        this.f755b = iBinder;
        this.c = aVar;
        this.d = z2;
        this.f756e = z3;
    }

    public final boolean equals(Object obj) {
        Object e0Var;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (!this.c.equals(oVar.c)) {
            return false;
        }
        Object e0Var2 = null;
        IBinder iBinder = this.f755b;
        if (iBinder == null) {
            e0Var = null;
        } else {
            int i2 = a.f696b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            e0Var = iInterfaceQueryLocalInterface instanceof f ? (f) iInterfaceQueryLocalInterface : new e0(iBinder);
        }
        IBinder iBinder2 = oVar.f755b;
        if (iBinder2 != null) {
            int i3 = a.f696b;
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            e0Var2 = iInterfaceQueryLocalInterface2 instanceof f ? (f) iInterfaceQueryLocalInterface2 : new e0(iBinder2);
        }
        return s.d(e0Var, e0Var2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f754a);
        IBinder iBinder = this.f755b;
        if (iBinder != null) {
            int iC02 = p.a.c0(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            p.a.d0(parcel, iC02);
        }
        p.a.Y(parcel, 3, this.c, i2);
        p.a.f0(parcel, 4, 4);
        parcel.writeInt(this.d ? 1 : 0);
        p.a.f0(parcel, 5, 4);
        parcel.writeInt(this.f756e ? 1 : 0);
        p.a.d0(parcel, iC0);
    }
}
