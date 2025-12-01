package okhttp3.internal.http;

import java.io.IOException;
import o1.o0;
import o1.p0;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.connection.RealCall;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface ExchangeCodec {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public interface Carrier {
        /* renamed from: cancel */
        void mo230cancel();

        Route getRoute();

        void noNewExchanges();

        void trackFailure(RealCall realCall, IOException iOException);
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

        private Companion() {
        }
    }

    void cancel();

    o0 createRequestBody(Request request, long j);

    void finishRequest();

    void flushRequest();

    Carrier getCarrier();

    boolean isResponseComplete();

    p0 openResponseBodySource(Response response);

    Headers peekTrailers();

    Response.Builder readResponseHeaders(boolean z2);

    long reportedContentLength(Response response);

    void writeRequestHeaders(Request request);
}
