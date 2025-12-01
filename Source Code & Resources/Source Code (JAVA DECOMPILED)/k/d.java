package k;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends l.a {

    @NonNull
    public static final Parcelable.Creator<d> CREATOR = new e.a(12);

    /* renamed from: a, reason: collision with root package name */
    public final i f714a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f715b;
    public final boolean c;
    public final int[] d;

    /* renamed from: e, reason: collision with root package name */
    public final int f716e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f717f;

    public d(i iVar, boolean z2, boolean z3, int[] iArr, int i2, int[] iArr2) {
        this.f714a = iVar;
        this.f715b = z2;
        this.c = z3;
        this.d = iArr;
        this.f716e = i2;
        this.f717f = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.Y(parcel, 1, this.f714a, i2);
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(this.f715b ? 1 : 0);
        p.a.f0(parcel, 3, 4);
        parcel.writeInt(this.c ? 1 : 0);
        int[] iArr = this.d;
        if (iArr != null) {
            int iC02 = p.a.c0(parcel, 4);
            parcel.writeIntArray(iArr);
            p.a.d0(parcel, iC02);
        }
        p.a.f0(parcel, 5, 4);
        parcel.writeInt(this.f716e);
        int[] iArr2 = this.f717f;
        if (iArr2 != null) {
            int iC03 = p.a.c0(parcel, 6);
            parcel.writeIntArray(iArr2);
            p.a.d0(parcel, iC03);
        }
        p.a.d0(parcel, iC0);
    }
}
