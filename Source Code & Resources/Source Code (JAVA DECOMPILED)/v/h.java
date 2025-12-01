package v;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h extends l.a {
    public static final Parcelable.Creator<h> CREATOR = new e.a(17);

    /* renamed from: a, reason: collision with root package name */
    public final String f1195a;

    public h(String str) {
        this.f1195a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.Z(parcel, 2, this.f1195a);
        p.a.d0(parcel, iC0);
    }
}
