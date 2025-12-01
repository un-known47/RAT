package a0;

import android.os.Parcel;
import okhttp3.Response;
import q1.s0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class s extends RuntimeException {
    public s(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }

    public s(s0 s0Var) {
        StringBuilder sb = new StringBuilder("HTTP ");
        Response response = s0Var.f1140a;
        sb.append(response.code());
        sb.append(" ");
        sb.append(response.message());
        super(sb.toString());
        response.code();
        response.message();
    }
}
