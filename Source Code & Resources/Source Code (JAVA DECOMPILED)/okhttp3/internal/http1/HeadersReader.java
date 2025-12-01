package okhttp3.internal.http1;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import o1.n;
import okhttp3.Headers;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class HeadersReader {
    public static final Companion Companion = new Companion(null);
    private static final int HEADER_LIMIT = 262144;
    private long headerLimit;
    private final n source;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public HeadersReader(n source) {
        j.e(source, "source");
        this.source = source;
        this.headerLimit = 262144L;
    }

    public final n getSource() {
        return this.source;
    }

    public final Headers readHeaders() {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String line = readLine();
            if (line.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(line);
        }
    }

    public final String readLine() {
        String strT = this.source.t(this.headerLimit);
        this.headerLimit -= strT.length();
        return strT;
    }
}
