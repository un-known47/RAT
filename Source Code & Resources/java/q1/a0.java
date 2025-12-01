package q1;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a0 extends ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    public final MediaType f1053a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1054b;

    public a0(MediaType mediaType, long j) {
        this.f1053a = mediaType;
        this.f1054b = j;
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.f1054b;
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        return this.f1053a;
    }

    @Override // okhttp3.ResponseBody
    public final o1.n source() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}
