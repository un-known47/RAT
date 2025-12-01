package g;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import k.s;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a extends l.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f479a;

    /* renamed from: b, reason: collision with root package name */
    public final int f480b;
    public final PendingIntent c;
    public final String d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f478e = new a(0);

    @NonNull
    public static final Parcelable.Creator<a> CREATOR = new e.a(1);

    public a(int i2, int i3, PendingIntent pendingIntent, String str) {
        this.f479a = i2;
        this.f480b = i3;
        this.c = pendingIntent;
        this.d = str;
    }

    public static String a(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return androidx.appcompat.app.g.e("UNKNOWN_ERROR_CODE(", i2, ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f480b == aVar.f480b && s.d(this.c, aVar.c) && s.d(this.d, aVar.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f480b), this.c, this.d});
    }

    public final String toString() {
        h.c cVar = new h.c(this);
        cVar.f(a(this.f480b), "statusCode");
        cVar.f(this.c, "resolution");
        cVar.f(this.d, "message");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f479a);
        p.a.f0(parcel, 2, 4);
        parcel.writeInt(this.f480b);
        p.a.Y(parcel, 3, this.c, i2);
        p.a.Z(parcel, 4, this.d);
        p.a.d0(parcel, iC0);
    }

    public a(int i2) {
        this(1, i2, null, null);
    }

    public a(int i2, PendingIntent pendingIntent) {
        this(1, i2, pendingIntent, null);
    }
}
