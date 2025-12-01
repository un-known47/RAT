package q1;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class z extends ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    public final ResponseBody f1161a;

    /* renamed from: b, reason: collision with root package name */
    public final o1.k0 f1162b;
    public IOException c;

    public z(ResponseBody responseBody) {
        this.f1161a = responseBody;
        this.f1162b = o1.b.c(new y(this, responseBody.source()));
    }

    @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1161a.close();
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.f1161a.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        return this.f1161a.contentType();
    }

    @Override // okhttp3.ResponseBody
    public final o1.n source() {
        return this.f1162b;
    }
}
