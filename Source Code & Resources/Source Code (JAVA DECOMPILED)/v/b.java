package v;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends l.a {

    @NonNull
    public static final Parcelable.Creator<b> CREATOR = new e.a(19);

    /* renamed from: a, reason: collision with root package name */
    public String f1187a;

    /* renamed from: b, reason: collision with root package name */
    public DataHolder f1188b;
    public ParcelFileDescriptor c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f1189e;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.Z(parcel, 2, this.f1187a);
        p.a.Y(parcel, 3, this.f1188b, i2);
        p.a.Y(parcel, 4, this.c, i2);
        long j = this.d;
        p.a.f0(parcel, 5, 8);
        parcel.writeLong(j);
        byte[] bArr = this.f1189e;
        if (bArr != null) {
            int iC02 = p.a.c0(parcel, 6);
            parcel.writeByteArray(bArr);
            p.a.d0(parcel, iC02);
        }
        p.a.d0(parcel, iC0);
        this.c = null;
    }
}
