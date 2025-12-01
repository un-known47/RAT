package v;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f extends l.a {
    public static final Parcelable.Creator<f> CREATOR = new e.a(14);

    /* renamed from: a, reason: collision with root package name */
    public final String f1192a;

    public f(String str) {
        this.f1192a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.Z(parcel, 2, this.f1192a);
        p.a.d0(parcel, iC0);
    }
}
