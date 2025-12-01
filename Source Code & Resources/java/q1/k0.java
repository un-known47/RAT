package q1;

import okhttp3.MultipartBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class k0 extends b1 {
    public static final k0 d = new k0();

    @Override // q1.b1
    public final void a(p0 p0Var, Object obj) {
        MultipartBody.Part part = (MultipartBody.Part) obj;
        if (part != null) {
            p0Var.f1109i.addPart(part);
        }
    }
}
