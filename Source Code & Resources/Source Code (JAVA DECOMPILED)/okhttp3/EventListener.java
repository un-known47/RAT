package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response cachedResponse) {
        j.e(call, "call");
        j.e(cachedResponse, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        j.e(call, "call");
        j.e(response, "response");
    }

    public void cacheMiss(Call call) {
        j.e(call, "call");
    }

    public void callEnd(Call call) {
        j.e(call, "call");
    }

    public void callFailed(Call call, IOException ioe) {
        j.e(call, "call");
        j.e(ioe, "ioe");
    }

    public void callStart(Call call) {
        j.e(call, "call");
    }

    public void canceled(Call call) {
        j.e(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        j.e(call, "call");
        j.e(inetSocketAddress, "inetSocketAddress");
        j.e(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        j.e(call, "call");
        j.e(inetSocketAddress, "inetSocketAddress");
        j.e(proxy, "proxy");
        j.e(ioe, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        j.e(call, "call");
        j.e(inetSocketAddress, "inetSocketAddress");
        j.e(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        j.e(call, "call");
        j.e(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        j.e(call, "call");
        j.e(connection, "connection");
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        j.e(call, "call");
        j.e(domainName, "domainName");
        j.e(inetAddressList, "inetAddressList");
    }

    public void dnsStart(Call call, String domainName) {
        j.e(call, "call");
        j.e(domainName, "domainName");
    }

    public void followUpDecision(Call call, Response networkResponse, Request request) {
        j.e(call, "call");
        j.e(networkResponse, "networkResponse");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
        j.e(call, "call");
        j.e(url, "url");
        j.e(proxies, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        j.e(call, "call");
        j.e(url, "url");
    }

    public void requestBodyEnd(Call call, long j) {
        j.e(call, "call");
    }

    public void requestBodyStart(Call call) {
        j.e(call, "call");
    }

    public void requestFailed(Call call, IOException ioe) {
        j.e(call, "call");
        j.e(ioe, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        j.e(call, "call");
        j.e(request, "request");
    }

    public void requestHeadersStart(Call call) {
        j.e(call, "call");
    }

    public void responseBodyEnd(Call call, long j) {
        j.e(call, "call");
    }

    public void responseBodyStart(Call call) {
        j.e(call, "call");
    }

    public void responseFailed(Call call, IOException ioe) {
        j.e(call, "call");
        j.e(ioe, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        j.e(call, "call");
        j.e(response, "response");
    }

    public void responseHeadersStart(Call call) {
        j.e(call, "call");
    }

    public void retryDecision(Call call, IOException exception, boolean z2) {
        j.e(call, "call");
        j.e(exception, "exception");
    }

    public void satisfactionFailure(Call call, Response response) {
        j.e(call, "call");
        j.e(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        j.e(call, "call");
    }

    public void secureConnectStart(Call call) {
        j.e(call, "call");
    }
}
