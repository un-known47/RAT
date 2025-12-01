package okhttp3.internal.cache;

import kotlin.jvm.internal.j;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class CacheInterceptorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Request requestForCache(Request request) {
        HttpUrl httpUrlCacheUrlOverride = request.cacheUrlOverride();
        return httpUrlCacheUrlOverride != null ? (j.a(request.method(), "GET") || j.a(request.method(), "POST")) ? request.newBuilder().get().url(httpUrlCacheUrlOverride).cacheUrlOverride(null).build() : request : request;
    }
}
