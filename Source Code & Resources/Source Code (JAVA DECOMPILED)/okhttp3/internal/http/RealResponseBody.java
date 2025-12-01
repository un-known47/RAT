package okhttp3.internal.http;

import kotlin.jvm.internal.j;
import o1.n;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final n source;

    public RealResponseBody(String str, long j, n source) {
        j.e(source, "source");
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = source;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override // okhttp3.ResponseBody
    public n source() {
        return this.source;
    }
}
