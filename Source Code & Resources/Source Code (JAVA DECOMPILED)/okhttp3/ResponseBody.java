package okhttp3;

import androidx.appcompat.app.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import o1.l;
import o1.n;
import o1.o;
import okhttp3.internal.Internal;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion;
    public static final ResponseBody EMPTY;
    private Reader reader;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final n source;

        public BomAwareReader(n source, Charset charset) {
            j.e(source, "source");
            j.e(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int i2, int i3) throws IOException {
            j.e(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.C(), _UtilJvmKt.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i2, i3);
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String str, MediaType mediaType) {
            j.e(str, "<this>");
            l0.d dVarChooseCharset = Internal.chooseCharset(mediaType);
            Charset charset = (Charset) dVarChooseCharset.f850a;
            MediaType mediaType2 = (MediaType) dVarChooseCharset.f851b;
            l lVar = new l();
            j.e(charset, "charset");
            lVar.a0(str, 0, str.length(), charset);
            return create(lVar, mediaType2, lVar.f919b);
        }

        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, o oVar, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(oVar, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, n nVar, MediaType mediaType, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            if ((i2 & 2) != 0) {
                j = -1;
            }
            return companion.create(nVar, mediaType, j);
        }

        public final ResponseBody create(byte[] bArr, MediaType mediaType) {
            j.e(bArr, "<this>");
            l lVar = new l();
            lVar.m79write(bArr);
            return create(lVar, mediaType, bArr.length);
        }

        public final ResponseBody create(o oVar, MediaType mediaType) {
            j.e(oVar, "<this>");
            l lVar = new l();
            lVar.T(oVar);
            return create(lVar, mediaType, oVar.d());
        }

        public final ResponseBody create(final n nVar, final MediaType mediaType, final long j) {
            j.e(nVar, "<this>");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public n source() {
                    return nVar;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String content) {
            j.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] content) {
            j.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, o content) {
            j.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j, n content) {
            j.e(content, "content");
            return create(content, mediaType, j);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        EMPTY = Companion.create$default(companion, o.d, (MediaType) null, 1, (Object) null);
    }

    private final Charset charset() {
        return Internal.charsetOrUtf8(contentType());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v9 */
    private final <T> T consumeSource(ResponseBody responseBody, y0.l lVar, y0.l lVar2) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jContentLength = responseBody.contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException(g.f("Cannot buffer entire body for content length: ", jContentLength));
        }
        n nVarSource = responseBody.source();
        T t2 = null;
        try {
            Object objInvoke = lVar.invoke(nVarSource);
            if (nVarSource != null) {
                try {
                    nVarSource.close();
                } catch (Throwable 
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                    */
                /*
                    this = this;
                    long r0 = r7.contentLength()
                    r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
                    int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r4 > 0) goto L65
                    o1.n r7 = r7.source()
                    r2 = 0
                    java.lang.Object r8 = r8.invoke(r7)     // Catch: java.lang.Throwable -> L1f
                    if (r7 == 0) goto L1b
                    r7.close()     // Catch: java.lang.Throwable -> L1a
                    goto L1b
                L1a:
                    r2 = move-exception
                L1b:
                    r5 = r2
                    r2 = r8
                    r8 = r5
                    goto L2a
                L1f:
                    r8 = move-exception
                    if (r7 == 0) goto L2a
                    r7.close()     // Catch: java.lang.Throwable -> L26
                    goto L2a
                L26:
                    r7 = move-exception
                    p.a.b(r8, r7)
                L2a:
                    if (r8 != 0) goto L64
                    java.lang.Object r7 = r9.invoke(r2)
                    java.lang.Number r7 = (java.lang.Number) r7
                    int r7 = r7.intValue()
                    r8 = -1
                    int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                    if (r3 == 0) goto L63
                    long r8 = (long) r7
                    int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                    if (r3 != 0) goto L42
                    goto L63
                L42:
                    java.io.IOException r8 = new java.io.IOException
                    java.lang.StringBuilder r9 = new java.lang.StringBuilder
                    java.lang.String r2 = "Content-Length ("
                    r9.<init>(r2)
                    r9.append(r0)
                    java.lang.String r0 = ") and stream length ("
                    r9.append(r0)
                    r9.append(r7)
                    java.lang.String r7 = ") disagree"
                    r9.append(r7)
                    java.lang.String r7 = r9.toString()
                    r8.<init>(r7)
                    throw r8
                L63:
                    return r2
                L64:
                    throw r8
                L65:
                    java.io.IOException r7 = new java.io.IOException
                    java.lang.String r8 = "Cannot buffer entire body for content length: "
                    java.lang.String r8 = androidx.appcompat.app.g.f(r8, r0)
                    r7.<init>(r8)
                    throw r7
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.ResponseBody.consumeSource(okhttp3.ResponseBody, y0.l, y0.l):java.lang.Object");
            }

            public static final ResponseBody create(String str, MediaType mediaType) {
                return Companion.create(str, mediaType);
            }

            public final InputStream byteStream() {
                return source().C();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v7 */
            public final o byteString() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                long jContentLength = contentLength();
                if (jContentLength > 2147483647L) {
                    throw new IOException(g.f("Cannot buffer entire body for content length: ", jContentLength));
                }
                n nVarSource = source();
                o th = null;
                try {
                    o oVarG = nVarSource.g();
                    try {
                        nVarSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = oVarG;
                } catch (Throwable th3) {
                    th = th3;
                    if (nVarSource != null) {
                        try {
                            nVarSource.close();
                        } catch (Throwable th4) {
                            p.a.b(th, th4);
                        }
                    }
                }
                if (th != 0) {
                    throw th;
                }
                int iD = th.d();
                if (jContentLength == -1 || jContentLength == iD) {
                    return th;
                }
                throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iD + ") disagree");
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r4v7 */
            public final byte[] bytes() throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
                long jContentLength = contentLength();
                if (jContentLength > 2147483647L) {
                    throw new IOException(g.f("Cannot buffer entire body for content length: ", jContentLength));
                }
                n nVarSource = source();
                byte[] th = null;
                try {
                    byte[] bArrO = nVarSource.o();
                    try {
                        nVarSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = bArrO;
                } catch (Throwable th3) {
                    th = th3;
                    if (nVarSource != null) {
                        try {
                            nVarSource.close();
                        } catch (Throwable th4) {
                            p.a.b(th, th4);
                        }
                    }
                }
                if (th != 0) {
                    throw th;
                }
                int length = th.length;
                if (jContentLength == -1 || jContentLength == length) {
                    return th;
                }
                throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
            }

            public final Reader charStream() {
                Reader reader = this.reader;
                if (reader != null) {
                    return reader;
                }
                BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
                this.reader = bomAwareReader;
                return bomAwareReader;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                _UtilCommonKt.closeQuietly(source());
            }

            public abstract long contentLength();

            public abstract MediaType contentType();

            public abstract n source();

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
            /* JADX WARN: Type inference failed for: r2v5 */
            public final String string() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                n nVarSource = source();
                String th = null;
                try {
                    String strB = nVarSource.B(_UtilJvmKt.readBomAsCharset(nVarSource, charset()));
                    try {
                        nVarSource.close();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    th = th;
                    th = strB;
                } catch (Throwable th3) {
                    th = th3;
                    if (nVarSource != null) {
                        try {
                            nVarSource.close();
                        } catch (Throwable th4) {
                            p.a.b(th, th4);
                        }
                    }
                }
                if (th == 0) {
                    return th;
                }
                throw th;
            }

            public static final ResponseBody create(n nVar, MediaType mediaType, long j) {
                return Companion.create(nVar, mediaType, j);
            }

            public static final ResponseBody create(o oVar, MediaType mediaType) {
                return Companion.create(oVar, mediaType);
            }

            public static final ResponseBody create(MediaType mediaType, long j, n nVar) {
                return Companion.create(mediaType, j, nVar);
            }

            public static final ResponseBody create(MediaType mediaType, String str) {
                return Companion.create(mediaType, str);
            }

            public static final ResponseBody create(MediaType mediaType, o oVar) {
                return Companion.create(mediaType, oVar);
            }

            public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
                return Companion.create(mediaType, bArr);
            }

            public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
                return Companion.create(bArr, mediaType);
            }
        }
