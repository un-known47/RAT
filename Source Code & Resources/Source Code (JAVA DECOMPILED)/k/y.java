package k;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class y extends l.a {
    public static final Parcelable.Creator<y> CREATOR = new e.a(11);

    /* renamed from: a, reason: collision with root package name */
    public Bundle f771a;

    /* renamed from: b, reason: collision with root package name */
    public g.c[] f772b;
    public int c;
    public d d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.X(parcel, 1, this.f771a);
        p.a.a0(parcel, 2, this.f772b, i2);
        int i3 = this.c;
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(i3);
        p.a.Y(parcel, 4, this.d, i2);
        p.a.d0(parcel, iC0);
    }
}
