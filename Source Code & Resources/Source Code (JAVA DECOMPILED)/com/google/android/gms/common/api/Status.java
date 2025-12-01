package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.g;
import com.google.android.gms.common.internal.ReflectedParcelable;
import h.c;
import java.util.Arrays;
import k.s;
import l.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Status extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new e.a(4);

    /* renamed from: a, reason: collision with root package name */
    public final int f223a;

    /* renamed from: b, reason: collision with root package name */
    public final String f224b;
    public final PendingIntent c;
    public final g.a d;

    public Status(int i2, String str, PendingIntent pendingIntent, g.a aVar) {
        this.f223a = i2;
        this.f224b = str;
        this.c = pendingIntent;
        this.d = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f223a == status.f223a && s.d(this.f224b, status.f224b) && s.d(this.c, status.c) && s.d(this.d, status.d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f223a), this.f224b, this.c, this.d});
    }

    public final String toString() {
        c cVar = new c(this);
        String strC = this.f224b;
        if (strC == null) {
            int i2 = this.f223a;
            switch (i2) {
                case -1:
                    strC = "SUCCESS_CACHE";
                    break;
                case 0:
                    strC = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strC = g.c(i2, "unknown status code: ");
                    break;
                case 2:
                    strC = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strC = "SERVICE_DISABLED";
                    break;
                case 4:
                    strC = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strC = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strC = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strC = "NETWORK_ERROR";
                    break;
                case 8:
                    strC = "INTERNAL_ERROR";
                    break;
                case 10:
                    strC = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strC = "ERROR";
                    break;
                case 14:
                    strC = "INTERRUPTED";
                    break;
                case 15:
                    strC = "TIMEOUT";
                    break;
                case 16:
                    strC = "CANCELED";
                    break;
                case 17:
                    strC = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strC = "DEAD_CLIENT";
                    break;
                case 19:
                    strC = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strC = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strC = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strC = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        cVar.f(strC, "statusCode");
        cVar.f(this.c, "resolution");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iC0 = p.a.c0(parcel, 20293);
        p.a.f0(parcel, 1, 4);
        parcel.writeInt(this.f223a);
        p.a.Z(parcel, 2, this.f224b);
        p.a.Y(parcel, 3, this.c, i2);
        p.a.Y(parcel, 4, this.d, i2);
        p.a.d0(parcel, iC0);
    }
}
