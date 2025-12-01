package q1;

import java.lang.reflect.Method;
import okhttp3.Headers;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g0 extends b1 {
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f1076e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1077f;

    public /* synthetic */ g0(Method method, int i2, int i3) {
        this.d = i3;
        this.f1076e = method;
        this.f1077f = i2;
    }

    @Override // q1.b1
    public final void a(p0 p0Var, Object obj) {
        switch (this.d) {
            case 0:
                Headers headers = (Headers) obj;
                if (headers != null) {
                    p0Var.f1106f.addAll(headers);
                    return;
                } else {
                    throw b1.n(this.f1076e, this.f1077f, "Headers parameter must not be null.", new Object[0]);
                }
            default:
                if (obj != null) {
                    p0Var.c = obj.toString();
                    return;
                } else {
                    throw b1.n(this.f1076e, this.f1077f, "@Url parameter is null.", new Object[0]);
                }
        }
    }
}
