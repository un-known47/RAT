package q1;

import java.io.IOException;
import java.lang.reflect.Method;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d0 extends b1 {
    public final Method d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1068e;

    /* renamed from: f, reason: collision with root package name */
    public final m f1069f;

    public d0(Method method, int i2, m mVar) {
        this.d = method;
        this.f1068e = i2;
        this.f1069f = mVar;
    }

    @Override // q1.b1
    public final void a(p0 p0Var, Object obj) {
        int i2 = this.f1068e;
        Method method = this.d;
        if (obj == null) {
            throw b1.n(method, i2, "Body parameter value must not be null.", new Object[0]);
        }
        try {
            p0Var.f1110k = (RequestBody) this.f1069f.a(obj);
        } catch (IOException e2) {
            throw b1.o(method, e2, i2, "Unable to convert " + obj + " to RequestBody", new Object[0]);
        }
    }
}
