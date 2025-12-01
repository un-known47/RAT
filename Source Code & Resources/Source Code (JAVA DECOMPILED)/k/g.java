package k;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g extends l.a {

    @NonNull
    public static final Parcelable.Creator<g> CREATOR = new e.a(7);

    /* renamed from: a, reason: collision with root package name */
    public final int f733a;

    /* renamed from: b, reason: collision with root package name */
    public final int f734b;
    public final int c;
    public final long d;

    /* renamed from: e, reason: collision with root package name */
    public final long f735e;

    /* renamed from: f, reason: collision with root package name */
    public final String f736f;

    /* renamed from: g, reason: collision with root package name */
    public final String f737g;

    /* renamed from: h, reason: collision with root package name */
    public final int f738h;

    /* renamed from: i, reason: collision with root package name */
    public final int f739i;

    public g(int i2, int i3, int i4, long j, long j2, String str, String str2, int i5, int i6) {
        this.f733a = i2;
        this.f734b = i3;
        this.c = i4;
        this.d = j;
        this.f735e = j2;
        this.f736f = str;
        this.f737g = str2;
        this.f738h = i5;
        this.f739i = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f733a);
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(this.f734b);
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(this.c);
        p.a.f0(parcel, 4, 8);
        parcel.writeLong(this.d);
        p.a.f0(parcel, 5, 8);
        parcel.writeLong(this.f735e);
        p.a.Z(parcel, 6, this.f736f);
        p.a.Z(parcel, 7, this.f737g);
        p.a.f0(parcel, 8, 4);
        parcel.writeInt(this.f738h);
        p.a.f0(parcel, 9, 4);
        parcel.writeInt(this.f739i);
        p.a.d0(parcel, iC0);
    }
}
