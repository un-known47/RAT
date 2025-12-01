package q1;

import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f1101l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f1102m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    public final String f1103a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpUrl f1104b;
    public String c;
    public HttpUrl.Builder d;

    /* renamed from: e, reason: collision with root package name */
    public final Request.Builder f1105e = new Request.Builder();

    /* renamed from: f, reason: collision with root package name */
    public final Headers.Builder f1106f;

    /* renamed from: g, reason: collision with root package name */
    public MediaType f1107g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1108h;

    /* renamed from: i, reason: collision with root package name */
    public final MultipartBody.Builder f1109i;
    public final FormBody.Builder j;

    /* renamed from: k, reason: collision with root package name */
    public RequestBody f1110k;

    public p0(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z2, boolean z3, boolean z4) {
        this.f1103a = str;
        this.f1104b = httpUrl;
        this.c = str2;
        this.f1107g = mediaType;
        this.f1108h = z2;
        if (headers != null) {
            this.f1106f = headers.newBuilder();
        } else {
            this.f1106f = new Headers.Builder();
        }
        if (z3) {
            this.j = new FormBody.Builder();
        } else if (z4) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f1109i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    public final void a(String str, String str2, boolean z2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.f1107g = MediaType.get(str2);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException(androidx.appcompat.app.g.v("Malformed content type: ", str2), e2);
            }
        } else {
            Headers.Builder builder = this.f1106f;
            if (z2) {
                builder.addUnsafeNonAscii(str, str2);
            } else {
                builder.add(str, str2);
            }
        }
    }

    public final void b(String str, String str2, boolean z2) {
        String str3 = this.c;
        if (str3 != null) {
            HttpUrl httpUrl = this.f1104b;
            HttpUrl.Builder builderNewBuilder = httpUrl.newBuilder(str3);
            this.d = builderNewBuilder;
            if (builderNewBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + httpUrl + ", Relative: " + this.c);
            }
            this.c = null;
        }
        if (z2) {
            this.d.addEncodedQueryParameter(str, str2);
        } else {
            this.d.addQueryParameter(str, str2);
        }
    }
}
