package k;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends l.a {

    @NonNull
    public static final Parcelable.Creator<j> CREATOR = new e.a(6);

    /* renamed from: a, reason: collision with root package name */
    public final int f745a;

    /* renamed from: b, reason: collision with root package name */
    public List f746b;

    public j(int i2, List list) {
        this.f745a = i2;
        this.f746b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f745a);
        p.a.b0(parcel, 2, this.f746b);
        p.a.d0(parcel, iC0);
    }
}
