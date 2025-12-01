package v;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g extends l.a {
    public static final Parcelable.Creator<g> CREATOR = new e.a(16);

    /* renamed from: a, reason: collision with root package name */
    public final long f1193a;

    /* renamed from: b, reason: collision with root package name */
    public final a[] f1194b;
    public final int c;
    public final boolean d;

    public g(long j, a[] aVarArr, int i2, boolean z2) {
        this.f1193a = j;
        this.f1194b = aVarArr;
        this.d = z2;
        if (z2) {
            this.c = i2;
        } else {
            this.c = -1;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 2, 8);
        parcel.writeLong(this.f1193a);
        p.a.a0(parcel, 3, this.f1194b, i2);
        p.a.f0(parcel, 4, 4);
        parcel.writeInt(this.c);
        p.a.f0(parcel, 5, 4);
        parcel.writeInt(this.d ? 1 : 0);
        p.a.d0(parcel, iC0);
    }
}
