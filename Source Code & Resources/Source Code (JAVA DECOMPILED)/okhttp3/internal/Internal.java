package okhttp3.internal;

import f1.a;
import java.nio.charset.Charset;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.j;
import l0.d;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.ConnectionListener;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String line) {
        j.e(builder, "builder");
        j.e(line, "line");
        return builder.addLenient$okhttp(line);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sslSocket, boolean z2) {
        j.e(connectionSpec, "connectionSpec");
        j.e(sslSocket, "sslSocket");
        connectionSpec.apply$okhttp(sslSocket, z2);
    }

    public static final ConnectionPool buildConnectionPool(ConnectionListener connectionListener, TaskRunner taskRunner) {
        j.e(connectionListener, "connectionListener");
        j.e(taskRunner, "taskRunner");
        return new ConnectionPool(0, 0L, null, taskRunner, connectionListener, 0, 0, 0, 0, 0, false, false, null, 8167, null);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        j.e(cache, "cache");
        j.e(request, "request");
        return cache.get$okhttp(request);
    }

    public static final Charset charsetOrUtf8(MediaType mediaType) {
        Charset charsetCharset$default;
        return (mediaType == null || (charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null)) == null) ? a.f458a : charsetCharset$default;
    }

    public static final d chooseCharset(MediaType mediaType) {
        Charset charset = a.f458a;
        if (mediaType != null) {
            Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
            if (charsetCharset$default == null) {
                mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
            } else {
                charset = charsetCharset$default;
            }
        }
        return new d(charset, mediaType);
    }

    public static final String cookieToString(Cookie cookie, boolean z2) {
        j.e(cookie, "cookie");
        return cookie.toString$okhttp(z2);
    }

    public static final String[] effectiveCipherSuites(ConnectionSpec connectionSpec, String[] socketEnabledCipherSuites) {
        j.e(connectionSpec, "<this>");
        j.e(socketEnabledCipherSuites, "socketEnabledCipherSuites");
        return connectionSpec.getCipherSuitesAsString$okhttp() != null ? _UtilCommonKt.intersect(connectionSpec.getCipherSuitesAsString$okhttp(), socketEnabledCipherSuites, CipherSuite.Companion.getORDER_BY_NAME$okhttp()) : socketEnabledCipherSuites;
    }

    public static final RealConnection getConnection(Response response) {
        j.e(response, "<this>");
        Exchange exchange = response.exchange();
        j.b(exchange);
        return exchange.getConnection$okhttp();
    }

    public static final Cookie parseCookie(long j, HttpUrl url, String setCookie) {
        j.e(url, "url");
        j.e(setCookie, "setCookie");
        return Cookie.Companion.parse$okhttp(j, url, setCookie);
    }

    public static final OkHttpClient.Builder taskRunnerInternal(OkHttpClient.Builder builder, TaskRunner taskRunner) {
        j.e(builder, "<this>");
        j.e(taskRunner, "taskRunner");
        return builder.taskRunner$okhttp(taskRunner);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String name, String value) {
        j.e(builder, "builder");
        j.e(name, "name");
        j.e(value, "value");
        return builder.addLenient$okhttp(name, value);
    }
}
