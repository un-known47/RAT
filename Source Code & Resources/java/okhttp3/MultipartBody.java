package okhttp3;

import g.g;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import o1.l;
import o1.m;
import o1.o;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal._UtilJvmKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final o boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Builder {
        private final o boundary;
        private final List<Part> parts;
        private MediaType type;

        public Builder() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final Builder addFormDataPart(String name, String value) {
            j.e(name, "name");
            j.e(value, "value");
            addPart(Part.Companion.createFormData(name, value));
            return this;
        }

        public final Builder addPart(RequestBody body) {
            j.e(body, "body");
            addPart(Part.Companion.create(body));
            return this;
        }

        public final MultipartBody build() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new MultipartBody(this.boundary, this.type, _UtilJvmKt.toImmutableList(this.parts));
        }

        public final Builder setType(MediaType type) {
            j.e(type, "type");
            if (j.a(type.type(), "multipart")) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        public Builder(String boundary) {
            j.e(boundary, "boundary");
            o oVar = o.d;
            this.boundary = g.e(boundary);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        public final Builder addFormDataPart(String name, String str, RequestBody body) {
            j.e(name, "name");
            j.e(body, "body");
            addPart(Part.Companion.createFormData(name, str, body));
            return this;
        }

        public final Builder addPart(Headers headers, RequestBody body) {
            j.e(body, "body");
            addPart(Part.Companion.create(headers, body));
            return this;
        }

        public final Builder addPart(Part part) {
            j.e(part, "part");
            this.parts.add(part);
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Builder(String str, int i2, e eVar) {
            if ((i2 & 1) != 0) {
                str = UUID.randomUUID().toString();
                j.d(str, "toString(...)");
            }
            this(str);
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final void appendQuotedString$okhttp(StringBuilder sb, String key) {
            j.e(sb, "<this>");
            j.e(key, "key");
            sb.append('\"');
            int length = key.length();
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = key.charAt(i2);
                if (cCharAt == '\n') {
                    sb.append("%0A");
                } else if (cCharAt == '\r') {
                    sb.append("%0D");
                } else if (cCharAt != '\"') {
                    sb.append(cCharAt);
                } else {
                    sb.append("%22");
                }
            }
            sb.append('\"');
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Part {
        public static final Companion Companion = new Companion(null);
        private final RequestBody body;
        private final Headers headers;

        /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
        public static final class Companion {
            public /* synthetic */ Companion(e eVar) {
                this();
            }

            public final Part create(RequestBody body) {
                j.e(body, "body");
                return create(null, body);
            }

            public final Part createFormData(String name, String value) {
                j.e(name, "name");
                j.e(value, "value");
                return createFormData(name, null, RequestBody.Companion.create$default(RequestBody.Companion, value, (MediaType) null, 1, (Object) null));
            }

            private Companion() {
            }

            public final Part create(Headers headers, RequestBody body) {
                j.e(body, "body");
                e eVar = null;
                if ((headers != null ? headers.get("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.get("Content-Length") : null) == null) {
                    return new Part(headers, body, eVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final Part createFormData(String name, String str, RequestBody body) {
                j.e(name, "name");
                j.e(body, "body");
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, name);
                if (str != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str);
                }
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString()).build(), body);
            }
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, e eVar) {
            this(headers, requestBody);
        }

        public static final Part create(Headers headers, RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        public static final Part createFormData(String str, String str2) {
            return Companion.createFormData(str, str2);
        }

        /* renamed from: -deprecated_body, reason: not valid java name */
        public final RequestBody m171deprecated_body() {
            return this.body;
        }

        /* renamed from: -deprecated_headers, reason: not valid java name */
        public final Headers m172deprecated_headers() {
            return this.headers;
        }

        public final RequestBody body() {
            return this.body;
        }

        public final Headers headers() {
            return this.headers;
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part create(RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        public static final Part createFormData(String str, String str2, RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get("multipart/form-data");
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{45, 45};
    }

    public MultipartBody(o boundaryByteString, MediaType type, List<Part> parts) {
        j.e(boundaryByteString, "boundaryByteString");
        j.e(type, "type");
        j.e(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = MediaType.Companion.get(type + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(m mVar, boolean z2) throws EOFException {
        l lVar;
        if (z2) {
            mVar = new l();
            lVar = mVar;
        } else {
            lVar = 0;
        }
        int size = this.parts.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Part part = this.parts.get(i2);
            Headers headers = part.headers();
            RequestBody requestBodyBody = part.body();
            j.b(mVar);
            mVar.write(DASHDASH);
            mVar.u(this.boundaryByteString);
            mVar.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    mVar.x(headers.name(i3)).write(COLONSPACE).x(headers.value(i3)).write(CRLF);
                }
            }
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                mVar.x("Content-Type: ").x(mediaTypeContentType.toString()).write(CRLF);
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength == -1 && z2) {
                j.b(lVar);
                lVar.a();
                return -1L;
            }
            byte[] bArr = CRLF;
            mVar.write(bArr);
            if (z2) {
                j += jContentLength;
            } else {
                requestBodyBody.writeTo(mVar);
            }
            mVar.write(bArr);
        }
        j.b(mVar);
        byte[] bArr2 = DASHDASH;
        mVar.write(bArr2);
        mVar.u(this.boundaryByteString);
        mVar.write(bArr2);
        mVar.write(CRLF);
        if (!z2) {
            return j;
        }
        j.b(lVar);
        long j2 = j + lVar.f919b;
        lVar.a();
        return j2;
    }

    /* renamed from: -deprecated_boundary, reason: not valid java name */
    public final String m167deprecated_boundary() {
        return boundary();
    }

    /* renamed from: -deprecated_parts, reason: not valid java name */
    public final List<Part> m168deprecated_parts() {
        return this.parts;
    }

    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m169deprecated_size() {
        return size();
    }

    /* renamed from: -deprecated_type, reason: not valid java name */
    public final MediaType m170deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.r();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws EOFException {
        long j = this.contentLength;
        if (j != -1) {
            return j;
        }
        long jWriteOrCountBytes = writeOrCountBytes(null, true);
        this.contentLength = jWriteOrCountBytes;
        return jWriteOrCountBytes;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.contentType;
    }

    @Override // okhttp3.RequestBody
    public boolean isOneShot() {
        List<Part> list = this.parts;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Part) it.next()).body().isOneShot()) {
                return true;
            }
        }
        return false;
    }

    public final Part part(int i2) {
        return this.parts.get(i2);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(m sink) throws EOFException {
        j.e(sink, "sink");
        writeOrCountBytes(sink, false);
    }
}
