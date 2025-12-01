package q1;

import java.lang.reflect.Method;
import java.util.Map;
import okhttp3.FormBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f0 extends b1 {
    public final /* synthetic */ int d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f1073e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1074f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1075g;

    public /* synthetic */ f0(Method method, int i2, boolean z2, int i3) {
        this.d = i3;
        this.f1073e = method;
        this.f1074f = i2;
        this.f1075g = z2;
    }

    @Override // q1.b1
    public final void a(p0 p0Var, Object obj) {
        switch (this.d) {
            case 0:
                Map map = (Map) obj;
                int i2 = this.f1074f;
                Method method = this.f1073e;
                if (map == null) {
                    throw b1.n(method, i2, "Field map was null.", new Object[0]);
                }
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (str == null) {
                        throw b1.n(method, i2, "Field map contained null key.", new Object[0]);
                    }
                    Object value = entry.getValue();
                    if (value == null) {
                        throw b1.n(method, i2, androidx.appcompat.app.g.i("Field map contained null value for key '", str, "'."), new Object[0]);
                    }
                    String string = value.toString();
                    if (string == null) {
                        throw b1.n(method, i2, "Field map value '" + value + "' converted to null by " + a.class.getName() + " for key '" + str + "'.", new Object[0]);
                    }
                    FormBody.Builder builder = p0Var.j;
                    if (this.f1075g) {
                        builder.addEncoded(str, string);
                    } else {
                        builder.add(str, string);
                    }
                }
                return;
            case 1:
                Map map2 = (Map) obj;
                int i3 = this.f1074f;
                Method method2 = this.f1073e;
                if (map2 == null) {
                    throw b1.n(method2, i3, "Header map was null.", new Object[0]);
                }
                for (Map.Entry entry2 : map2.entrySet()) {
                    String str2 = (String) entry2.getKey();
                    if (str2 == null) {
                        throw b1.n(method2, i3, "Header map contained null key.", new Object[0]);
                    }
                    Object value2 = entry2.getValue();
                    if (value2 == null) {
                        throw b1.n(method2, i3, androidx.appcompat.app.g.i("Header map contained null value for key '", str2, "'."), new Object[0]);
                    }
                    p0Var.a(str2, value2.toString(), this.f1075g);
                }
                return;
            default:
                Map map3 = (Map) obj;
                int i4 = this.f1074f;
                Method method3 = this.f1073e;
                if (map3 == null) {
                    throw b1.n(method3, i4, "Query map was null", new Object[0]);
                }
                for (Map.Entry entry3 : map3.entrySet()) {
                    String str3 = (String) entry3.getKey();
                    if (str3 == null) {
                        throw b1.n(method3, i4, "Query map contained null key.", new Object[0]);
                    }
                    Object value3 = entry3.getValue();
                    if (value3 == null) {
                        throw b1.n(method3, i4, androidx.appcompat.app.g.i("Query map contained null value for key '", str3, "'."), new Object[0]);
                    }
                    String string2 = value3.toString();
                    if (string2 == null) {
                        throw b1.n(method3, i4, "Query map value '" + value3 + "' converted to null by " + a.class.getName() + " for key '" + str3 + "'.", new Object[0]);
                    }
                    p0Var.b(str3, string2, this.f1075g);
                }
                return;
        }
    }
}
