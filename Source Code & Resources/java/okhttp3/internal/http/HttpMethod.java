package okhttp3.internal.http;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean invalidatesCache(String method) {
        j.e(method, "method");
        return method.equals("POST") || method.equals("PATCH") || method.equals("PUT") || method.equals("DELETE") || method.equals("MOVE");
    }

    public static final boolean permitsRequestBody(String method) {
        j.e(method, "method");
        return (method.equals("GET") || method.equals("HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String method) {
        j.e(method, "method");
        return method.equals("POST") || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT");
    }

    public final boolean redirectsToGet(String method) {
        j.e(method, "method");
        return !method.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        j.e(method, "method");
        return method.equals("PROPFIND");
    }
}
