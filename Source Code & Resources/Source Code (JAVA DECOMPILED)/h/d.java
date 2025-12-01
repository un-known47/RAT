package h;

import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class d extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final Status f515a;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Status status) {
        int i2 = status.f223a;
        String str = status.f224b;
        super(i2 + ": " + (str == null ? "" : str));
        this.f515a = status;
    }
}
