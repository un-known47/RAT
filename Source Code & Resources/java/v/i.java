package v;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i extends l.a {
    public static final Parcelable.Creator<i> CREATOR = new e.a(18);

    /* renamed from: a, reason: collision with root package name */
    public final int f1196a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1197b;

    public i(int i2, boolean z2) {
        this.f1196a = i2;
        this.f1197b = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(this.f1196a);
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(this.f1197b ? 1 : 0);
        p.a.d0(parcel, iC0);
    }
}
