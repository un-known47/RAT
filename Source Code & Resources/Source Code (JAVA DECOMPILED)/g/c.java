package g;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends l.a {

    @NonNull
    public static final Parcelable.Creator<c> CREATOR = new e.a(2);

    /* renamed from: a, reason: collision with root package name */
    public final String f483a;

    /* renamed from: b, reason: collision with root package name */
    public final int f484b;
    public final long c;

    public c() {
        this.f483a = "CLIENT_TELEMETRY";
        this.c = 1L;
        this.f484b = -1;
    }

    public final long a() {
        long j = this.c;
        return j == -1 ? this.f484b : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            String str = cVar.f483a;
            String str2 = this.f483a;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && a() == cVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f483a, Long.valueOf(a())});
    }

    public final String toString() {
        h.c cVar = new h.c(this);
        cVar.f(this.f483a, "name");
        cVar.f(Long.valueOf(a()), "version");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.Z(parcel, 1, this.f483a);
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(this.f484b);
        long jA = a();
        p.a.f0(parcel, 3, 8);
        parcel.writeLong(jA);
        p.a.d0(parcel, iC0);
    }

    public c(String str, int i2, long j) {
        this.f483a = str;
        this.f484b = i2;
        this.c = j;
    }
}
