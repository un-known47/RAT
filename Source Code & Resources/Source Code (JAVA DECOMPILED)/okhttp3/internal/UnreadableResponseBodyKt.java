package okhttp3.internal;

import kotlin.jvm.internal.j;
import okhttp3.Response;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class UnreadableResponseBodyKt {
    public static final Response stripBody(Response response) {
        j.e(response, "<this>");
        return response.newBuilder().body(new UnreadableResponseBody(response.body().contentType(), response.body().contentLength())).build();
    }
}
