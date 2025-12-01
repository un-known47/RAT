package okhttp3;

import androidx.appcompat.app.g;
import f1.q;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.p;
import m0.l;
import m0.r;
import m0.v;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.GzipRequestBody;
import okhttp3.internal.http.HttpMethod;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Request {
    private final RequestBody body;
    private final HttpUrl cacheUrlOverride;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<d1.c, Object> tags;
    private final HttpUrl url;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class Builder {
        private RequestBody body;
        private HttpUrl cacheUrlOverride;
        private Headers.Builder headers;
        private String method;
        private Map<d1.c, ? extends Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = r.f868a;
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        private final String canonicalUrl(String str) {
            if (q.o0(str, "ws:", true)) {
                String strSubstring = str.substring(3);
                j.d(strSubstring, "substring(...)");
                return "http:".concat(strSubstring);
            }
            if (!q.o0(str, "wss:", true)) {
                return str;
            }
            String strSubstring2 = str.substring(4);
            j.d(strSubstring2, "substring(...)");
            return "https:".concat(strSubstring2);
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i2 & 1) != 0) {
                requestBody = RequestBody.EMPTY;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String name, String value) {
            j.e(name, "name");
            j.e(value, "value");
            this.headers.add(name, value);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder cacheControl(CacheControl cacheControl) {
            j.e(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public final Builder cacheUrlOverride(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
            return this;
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder get() {
            return method("GET", null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final HttpUrl getCacheUrlOverride$okhttp() {
            return this.cacheUrlOverride;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<d1.c, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public final Builder gzip() {
            RequestBody requestBody = this.body;
            if (requestBody == null) {
                throw new IllegalStateException("cannot gzip a request that has no body");
            }
            String str = this.headers.get("Content-Encoding");
            if (str != null) {
                throw new IllegalStateException(g.v("Content-Encoding already set: ", str).toString());
            }
            this.headers.add("Content-Encoding", "gzip");
            this.body = new GzipRequestBody(requestBody);
            return this;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String name, String value) {
            j.e(name, "name");
            j.e(value, "value");
            this.headers.set(name, value);
            return this;
        }

        public Builder headers(Headers headers) {
            j.e(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String method, RequestBody requestBody) {
            j.e(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(method)) {
                    throw new IllegalArgumentException(g.i("method ", method, " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(g.i("method ", method, " must not have a request body.").toString());
            }
            this.method = method;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody body) {
            j.e(body, "body");
            return method("PATCH", body);
        }

        public Builder post(RequestBody body) {
            j.e(body, "body");
            return method("POST", body);
        }

        public Builder put(RequestBody body) {
            j.e(body, "body");
            return method("PUT", body);
        }

        public final /* synthetic */ <T> Builder reifiedTag(T t2) {
            j.g();
            throw null;
        }

        public Builder removeHeader(String name) {
            j.e(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setCacheUrlOverride$okhttp(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            j.e(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            j.e(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<d1.c, ? extends Object> map) {
            j.e(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public <T> Builder tag(Class<? super T> type, T t2) {
            j.e(type, "type");
            return tag((d1.c) p.a(type), (kotlin.jvm.internal.d) t2);
        }

        public Builder url(HttpUrl url) {
            j.e(url, "url");
            this.url = url;
            return this;
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder url(String url) {
            j.e(url, "url");
            return url(HttpUrl.Companion.get(canonicalUrl(url)));
        }

        public final <T> Builder tag(d1.c type, T t2) {
            Map mapB;
            boolean zIsInstance;
            String strD;
            j.e(type, "type");
            if (t2 == null) {
                if (!this.tags.isEmpty()) {
                    Map<d1.c, ? extends Object> map = this.tags;
                    j.c(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
                    kotlin.jvm.internal.r.b(map).remove(type);
                }
                return this;
            }
            if (this.tags.isEmpty()) {
                mapB = new LinkedHashMap();
                this.tags = mapB;
            } else {
                Map<d1.c, ? extends Object> map2 = this.tags;
                j.c(map2, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
                mapB = kotlin.jvm.internal.r.b(map2);
            }
            Class jClass = ((kotlin.jvm.internal.d) type).f784a;
            j.e(jClass, "jClass");
            Map map3 = kotlin.jvm.internal.d.f783b;
            j.c(map3, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map3.get(jClass);
            if (num != null) {
                zIsInstance = kotlin.jvm.internal.r.e(num.intValue(), t2);
            } else {
                zIsInstance = (jClass.isPrimitive() ? p.a.z(p.a(jClass)) : jClass).isInstance(t2);
            }
            if (!zIsInstance) {
                StringBuilder sb = new StringBuilder("Value cannot be cast to ");
                String strD2 = null;
                if (!jClass.isAnonymousClass() && !jClass.isLocalClass()) {
                    if (jClass.isArray()) {
                        Class<?> componentType = jClass.getComponentType();
                        if (componentType.isPrimitive() && (strD = kotlin.jvm.internal.r.d(componentType.getName())) != null) {
                            strD2 = strD.concat("Array");
                        }
                        if (strD2 == null) {
                            strD2 = "kotlin.Array";
                        }
                    } else {
                        strD2 = kotlin.jvm.internal.r.d(jClass.getName());
                        if (strD2 == null) {
                            strD2 = jClass.getCanonicalName();
                        }
                    }
                }
                sb.append(strD2);
                throw new ClassCastException(sb.toString());
            }
            mapB.put(type, t2);
            return this;
        }

        public Builder url(URL url) {
            j.e(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            j.d(string, "toString(...)");
            return url(companion.get(string));
        }

        public Builder(Request request) {
            j.e(request, "request");
            Map linkedHashMap = r.f868a;
            this.tags = linkedHashMap;
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (!request.getTags$okhttp().isEmpty()) {
                Map<d1.c, Object> tags$okhttp = request.getTags$okhttp();
                j.e(tags$okhttp, "<this>");
                linkedHashMap = new LinkedHashMap(tags$okhttp);
            }
            this.tags = linkedHashMap;
            this.headers = request.headers().newBuilder();
            this.cacheUrlOverride = request.cacheUrlOverride();
        }

        public Builder tag(Object obj) {
            return tag((d1.c) p.a(Object.class), (kotlin.jvm.internal.d) obj);
        }
    }

    public Request(Builder builder) {
        j.e(builder, "builder");
        HttpUrl url$okhttp = builder.getUrl$okhttp();
        if (url$okhttp == null) {
            throw new IllegalStateException("url == null");
        }
        this.url = url$okhttp;
        this.method = builder.getMethod$okhttp();
        this.headers = builder.getHeaders$okhttp().build();
        this.body = builder.getBody$okhttp();
        this.cacheUrlOverride = builder.getCacheUrlOverride$okhttp();
        this.tags = v.i0(builder.getTags$okhttp());
    }

    /* renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m207deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m208deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m209deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_method, reason: not valid java name */
    public final String m210deprecated_method() {
        return this.method;
    }

    /* renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m211deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    public final HttpUrl cacheUrlOverride() {
        return this.cacheUrlOverride;
    }

    public final Map<d1.c, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String name) {
        j.e(name, "name");
        return this.headers.get(name);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final /* synthetic */ <T> T reifiedTag() {
        j.g();
        throw null;
    }

    public final <T> T tag(d1.c type) {
        j.e(type, "type");
        Class clsA = ((kotlin.jvm.internal.c) type).a();
        j.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return (T) clsA.cast(this.tags.get(type));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i2 = 0;
            for (l0.d dVar : this.headers) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    l.j0();
                    throw null;
                }
                l0.d dVar2 = dVar;
                String str = (String) dVar2.f850a;
                String str2 = (String) dVar2.f851b;
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                if (_UtilCommonKt.isSensitiveHeader(str)) {
                    str2 = "██";
                }
                sb.append(str2);
                i2 = i3;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        return sb.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String name) {
        j.e(name, "name");
        return this.headers.values(name);
    }

    public final <T> T tag(Class<? extends T> type) {
        j.e(type, "type");
        return (T) tag(p.a(type));
    }

    public final Object tag() {
        return tag(p.a(Object.class));
    }

    public /* synthetic */ Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody, int i2, e eVar) {
        this(httpUrl, (i2 & 2) != 0 ? Headers.Companion.of(new String[0]) : headers, (i2 & 4) != 0 ? "\u0000" : str, (i2 & 8) != 0 ? null : requestBody);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Request(HttpUrl url, Headers headers, String method, RequestBody requestBody) {
        j.e(url, "url");
        j.e(headers, "headers");
        j.e(method, "method");
        Builder builderHeaders = new Builder().url(url).headers(headers);
        if (method.equals("\u0000")) {
            if (requestBody != null) {
                method = "POST";
            } else {
                method = "GET";
            }
        }
        this(builderHeaders.method(method, requestBody));
    }
}
