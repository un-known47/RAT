package okhttp3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import o1.f;
import o1.h0;
import o1.m;
import o1.o;
import o1.p0;
import o1.s0;
import o1.u;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class RequestBody {
    public static final Companion Companion;
    public static final RequestBody EMPTY;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content) {
            j.e(content, "content");
            return create$default(this, mediaType, content, 0, 0, 12, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, o oVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(oVar, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content, int i2) {
            j.e(content, "content");
            return create$default(this, mediaType, content, i2, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, FileDescriptor fileDescriptor, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(fileDescriptor, mediaType);
        }

        public final RequestBody create(byte[] bArr) {
            j.e(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                mediaType = null;
            }
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return companion.create(bArr, mediaType, i2, i3);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            j.e(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i2) {
            j.e(bArr, "<this>");
            return create$default(this, bArr, mediaType, i2, 0, 4, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(String str, MediaType mediaType) {
            j.e(str, "<this>");
            l0.d dVarChooseCharset = Internal.chooseCharset(mediaType);
            Charset charset = (Charset) dVarChooseCharset.f850a;
            MediaType mediaType2 = (MediaType) dVarChooseCharset.f851b;
            byte[] bytes = str.getBytes(charset);
            j.d(bytes, "getBytes(...)");
            return create(bytes, mediaType2, 0, bytes.length);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, h0 h0Var, u uVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                mediaType = null;
            }
            return companion.create(h0Var, uVar, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            if ((i4 & 8) != 0) {
                i3 = bArr.length;
            }
            return companion.create(mediaType, bArr, i2, i3);
        }

        public final RequestBody create(final o oVar, final MediaType mediaType) {
            j.e(oVar, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return oVar.d();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m sink) {
                    j.e(sink, "sink");
                    sink.u(oVar);
                }
            };
        }

        public final RequestBody create(final FileDescriptor fileDescriptor, final MediaType mediaType) {
            j.e(fileDescriptor, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public boolean isOneShot() {
                    return true;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m sink) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                    j.e(sink, "sink");
                    FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                    try {
                        sink.b().f(o1.b.i(fileInputStream));
                        fileInputStream.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(final byte[] bArr, final MediaType mediaType, final int i2, final int i3) {
            j.e(bArr, "<this>");
            _UtilCommonKt.checkOffsetAndCount(bArr.length, i2, i3);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$3
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i3;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m sink) {
                    j.e(sink, "sink");
                    sink.write(bArr, i2, i3);
                }
            };
        }

        public final RequestBody create(final File file, final MediaType mediaType) {
            j.e(file, "<this>");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m sink) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                    j.e(sink, "sink");
                    File file2 = file;
                    j.e(file2, "<this>");
                    f fVar = new f(new FileInputStream(file2), s0.NONE);
                    try {
                        sink.f(fVar);
                        fVar.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(final h0 h0Var, final u fileSystem, final MediaType mediaType) {
            j.e(h0Var, "<this>");
            j.e(fileSystem, "fileSystem");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    Long l2 = fileSystem.metadata(h0Var).d;
                    if (l2 != null) {
                        return l2.longValue();
                    }
                    return -1L;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(m sink) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                    j.e(sink, "sink");
                    p0 p0VarSource = fileSystem.source(h0Var);
                    try {
                        sink.f(p0VarSource);
                        p0VarSource.close();
                    } finally {
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String content) {
            j.e(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, o content) {
            j.e(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content, int i2, int i3) {
            j.e(content, "content");
            return create(content, mediaType, i2, i3);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            j.e(file, "file");
            return create(file, mediaType);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, o.d, (MediaType) null, 1, (Object) null);
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(m mVar);

    public static final RequestBody create(FileDescriptor fileDescriptor, MediaType mediaType) {
        return Companion.create(fileDescriptor, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(o oVar, MediaType mediaType) {
        return Companion.create(oVar, mediaType);
    }

    public static final RequestBody create(h0 h0Var, u uVar, MediaType mediaType) {
        return Companion.create(h0Var, uVar, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, o oVar) {
        return Companion.create(mediaType, oVar);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i2) {
        return Companion.create(mediaType, bArr, i2);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i2, int i3) {
        return Companion.create(mediaType, bArr, i2, i3);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create(bArr);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i2) {
        return Companion.create(bArr, mediaType, i2);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i2, int i3) {
        return Companion.create(bArr, mediaType, i2, i3);
    }
}
