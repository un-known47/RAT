package k;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i extends l.a {

    @NonNull
    public static final Parcelable.Creator<i> CREATOR = new e.a(10);

    /* renamed from: a, reason: collision with root package name */
    public final int f742a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f743b;
    public final boolean c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final int f744e;

    public i(int i2, boolean z2, boolean z3, int i3, int i4) {
        this.f742a = i2;
        this.f743b = z2;
        this.c = z3;
        this.d = i3;
        this.f744e = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f742a);
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(this.f743b ? 1 : 0);
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        p.a.f0(parcel, 4, 4);
        parcel.writeInt(this.d);
        p.a.f0(parcel, 5, 4);
        parcel.writeInt(this.f744e);
        p.a.d0(parcel, iC0);
    }
}
