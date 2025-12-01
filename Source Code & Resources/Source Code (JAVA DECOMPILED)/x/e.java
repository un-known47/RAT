package x;

import android.os.Parcel;
import android.os.Parcelable;
import k.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e extends l.a {
    public static final Parcelable.Creator<e> CREATOR = new e.a(22);

    /* renamed from: a, reason: collision with root package name */
    public final int f1208a;

    /* renamed from: b, reason: collision with root package name */
    public final g.a f1209b;
    public final o c;

    public e(int i2, g.a aVar, o oVar) {
        this.f1208a = i2;
        this.f1209b = aVar;
        this.c = oVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f1208a);
        p.a.Y(parcel, 2, this.f1209b, i2);
        p.a.Y(parcel, 3, this.c, i2);
        p.a.d0(parcel, iC0);
    }
}
