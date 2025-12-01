package q1;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h0 extends b1 {
    public final /* synthetic */ int d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Method f1080e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1081f;

    /* renamed from: g, reason: collision with root package name */
    public final m f1082g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1083h;

    public h0(Method method, int i2, Headers headers, m mVar) {
        this.f1080e = method;
        this.f1081f = i2;
        this.f1083h = headers;
        this.f1082g = mVar;
    }

    @Override // q1.b1
    public final void a(p0 p0Var, Object obj) {
        int i2 = this.d;
        m mVar = this.f1082g;
        Object obj2 = this.f1083h;
        Method method = this.f1080e;
        int i3 = this.f1081f;
        switch (i2) {
            case 0:
                if (obj == null) {
                    return;
                }
                try {
                    p0Var.f1109i.addPart((Headers) obj2, (RequestBody) mVar.a(obj));
                    return;
                } catch (IOException e2) {
                    throw b1.n(method, i3, "Unable to convert " + obj + " to RequestBody", e2);
                }
            default:
                Map map = (Map) obj;
                if (map == null) {
                    throw b1.n(method, i3, "Part map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw b1.n(method, i3, "Part map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw b1.n(method, i3, androidx.appcompat.app.g.i("Part map contained null value for key '", str, "'."), new Object[0]);
                    }
                    p0Var.f1109i.addPart(Headers.of("Content-Disposition", androidx.appcompat.app.g.i("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", (String) obj2), (RequestBody) mVar.a(value));
                }
                return;
        }
    }

    public h0(Method method, int i2, m mVar, String str) {
        this.f1080e = method;
        this.f1081f = i2;
        this.f1082g = mVar;
        this.f1083h = str;
    }
}
