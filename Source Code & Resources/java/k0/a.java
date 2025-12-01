package k0;

import i.o;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f775a;

    public a(o oVar) {
        this.f775a = oVar;
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Response responseProceed = chain.proceed(chain.request());
        return responseProceed.newBuilder().body(new e(responseProceed.body(), this.f775a)).build();
    }
}
