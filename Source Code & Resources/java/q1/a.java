package q1;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class a implements m {

    /* renamed from: b, reason: collision with root package name */
    public static final a f1048b = new a(0);
    public static final a c = new a(1);
    public static final a d = new a(2);

    /* renamed from: e, reason: collision with root package name */
    public static final a f1049e = new a(3);

    /* renamed from: f, reason: collision with root package name */
    public static final a f1050f = new a(4);

    /* renamed from: g, reason: collision with root package name */
    public static final a f1051g = new a(5);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1052a;

    public /* synthetic */ a(int i2) {
        this.f1052a = i2;
    }

    /* JADX WARN: Finally extract failed */
    @Override // q1.m
    public Object a(Object obj) {
        switch (this.f1052a) {
            case 0:
                return obj.toString();
            case 1:
                ResponseBody responseBody = (ResponseBody) obj;
                try {
                    o1.l lVar = new o1.l();
                    responseBody.source().i(lVar);
                    ResponseBody responseBodyCreate = ResponseBody.create(responseBody.contentType(), responseBody.contentLength(), lVar);
                    responseBody.close();
                    return responseBodyCreate;
                } catch (Throwable th) {
                    responseBody.close();
                    throw th;
                }
            case 2:
                return (RequestBody) obj;
            case 3:
                return (ResponseBody) obj;
            case 4:
                ((ResponseBody) obj).close();
                return l0.i.f856a;
            default:
                ((ResponseBody) obj).close();
                return null;
        }
    }

    public List b(Executor executor) {
        return Collections.singletonList(new p(executor));
    }

    public List c() {
        return Collections.EMPTY_LIST;
    }

    public String d(Method method, int i2) {
        return "parameter #" + (i2 + 1);
    }

    public Object e(Object obj, Method method, Object[] objArr) {
        throw new AssertionError();
    }

    public boolean f(Method method) {
        return false;
    }
}
