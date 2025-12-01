package x;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends l.a {
    public static final Parcelable.Creator<d> CREATOR = new e.a(21);

    /* renamed from: a, reason: collision with root package name */
    public final List f1206a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1207b;

    public d(String str, ArrayList arrayList) {
        this.f1206a = arrayList;
        this.f1207b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        List<String> list = this.f1206a;
        if (list != null) {
            int iC02 = p.a.c0(parcel, 1);
            parcel.writeStringList(list);
            p.a.d0(parcel, iC02);
        }
        p.a.Z(parcel, 2, this.f1207b);
        p.a.d0(parcel, iC0);
    }
}
