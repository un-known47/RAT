package q1;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class o0 extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    public final RequestBody f1098a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaType f1099b;

    public o0(RequestBody requestBody, MediaType mediaType) {
        this.f1098a = requestBody;
        this.f1099b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public final long contentLength() {
        return this.f1098a.contentLength();
    }

    @Override // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.f1099b;
    }

    @Override // okhttp3.RequestBody
    public final void writeTo(o1.m mVar) {
        this.f1098a.writeTo(mVar);
    }
}
