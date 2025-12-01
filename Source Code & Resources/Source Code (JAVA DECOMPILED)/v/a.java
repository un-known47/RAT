package v;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a extends l.a {

    @NonNull
    public static final Parcelable.Creator<a> CREATOR = new e.a(15);

    /* renamed from: a, reason: collision with root package name */
    public final String f1185a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f1186b;
    public final int c;

    public a(String str, byte[] bArr, int i2) {
        this.f1185a = str;
        this.f1186b = bArr;
        this.c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.Z(parcel, 2, this.f1185a);
        byte[] bArr = this.f1186b;
        if (bArr != null) {
            int iC02 = p.a.c0(parcel, 3);
            parcel.writeByteArray(bArr);
            p.a.d0(parcel, iC02);
        }
        p.a.f0(parcel, 4, 4);
        parcel.writeInt(this.c);
        p.a.d0(parcel, iC0);
    }
}
