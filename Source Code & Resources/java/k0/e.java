package k0;

import i.o;
import o1.k0;
import o1.n;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class e extends ResponseBody {

    /* renamed from: a, reason: collision with root package name */
    public final ResponseBody f779a;

    /* renamed from: b, reason: collision with root package name */
    public final o f780b;
    public k0 c;

    public e(ResponseBody responseBody, o oVar) {
        this.f779a = responseBody;
        this.f780b = oVar;
    }

    @Override // okhttp3.ResponseBody
    public final long contentLength() {
        return this.f779a.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public final MediaType contentType() {
        return this.f779a.contentType();
    }

    @Override // okhttp3.ResponseBody
    public final n source() {
        if (this.c == null) {
            this.c = o1.b.c(new d(this, this.f779a.source()));
        }
        return this.c;
    }
}
