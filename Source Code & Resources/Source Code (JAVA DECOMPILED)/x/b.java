package x;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends l.a {
    public static final Parcelable.Creator<b> CREATOR = new e.a(20);

    /* renamed from: a, reason: collision with root package name */
    public final int f1204a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1205b;
    public final Intent c;

    public b(int i2, int i3, Intent intent) {
        this.f1204a = i2;
        this.f1205b = i3;
        this.c = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f1204a);
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(this.f1205b);
        p.a.Y(parcel, 3, this.c, i2);
        p.a.d0(parcel, iC0);
    }
}
