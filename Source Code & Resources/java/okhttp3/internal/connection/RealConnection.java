package okhttp3.internal.connection;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import o1.b;
import o1.l;
import o1.m;
import o1.n;
import o1.o0;
import o1.p0;
import o1.s0;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.FlowControlListener;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection, ExchangeCodec.Carrier, Lockable {
    public static final Companion Companion = new Companion(null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private int allocationLimit;
    private final List<Reference<RealCall>> calls;
    private final ConnectionListener connectionListener;
    private final RealConnectionPool connectionPool;
    private final Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private final int pingIntervalMillis;
    private final Protocol protocol;
    private final Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private final m sink;
    private final Socket socket;
    private final n source;
    private int successCount;
    private final TaskRunner taskRunner;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final RealConnection newTestConnection(TaskRunner taskRunner, RealConnectionPool connectionPool, Route route, Socket socket, long j) {
            j.e(taskRunner, "taskRunner");
            j.e(connectionPool, "connectionPool");
            j.e(route, "route");
            j.e(socket, "socket");
            RealConnection realConnection = new RealConnection(taskRunner, connectionPool, route, new Socket(), socket, null, Protocol.HTTP_2, b.c(new p0() { // from class: okhttp3.internal.connection.RealConnection$Companion$newTestConnection$result$1
                @Override // o1.p0
                public long read(l sink, long j2) {
                    j.e(sink, "sink");
                    throw new UnsupportedOperationException();
                }

                @Override // o1.p0
                public s0 timeout() {
                    return s0.NONE;
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }
            }), b.b(new o0() { // from class: okhttp3.internal.connection.RealConnection$Companion$newTestConnection$result$2
                @Override // o1.o0
                public s0 timeout() {
                    return s0.NONE;
                }

                @Override // o1.o0
                public void write(l source, long j2) {
                    j.e(source, "source");
                    throw new UnsupportedOperationException();
                }

                @Override // o1.o0, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                @Override // o1.o0, java.io.Flushable
                public void flush() {
                }
            }), 0, ConnectionListener.Companion.getNONE());
            realConnection.setIdleAtNs(j);
            return realConnection;
        }

        private Companion() {
        }
    }

    public RealConnection(TaskRunner taskRunner, RealConnectionPool connectionPool, Route route, Socket rawSocket, Socket socket, Handshake handshake, Protocol protocol, n source, m sink, int i2, ConnectionListener connectionListener) {
        j.e(taskRunner, "taskRunner");
        j.e(connectionPool, "connectionPool");
        j.e(route, "route");
        j.e(rawSocket, "rawSocket");
        j.e(socket, "socket");
        j.e(protocol, "protocol");
        j.e(source, "source");
        j.e(sink, "sink");
        j.e(connectionListener, "connectionListener");
        this.taskRunner = taskRunner;
        this.connectionPool = connectionPool;
        this.route = route;
        this.rawSocket = rawSocket;
        this.socket = socket;
        this.handshake = handshake;
        this.protocol = protocol;
        this.source = source;
        this.sink = sink;
        this.pingIntervalMillis = i2;
        this.connectionListener = connectionListener;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = LocationRequestCompat.PASSIVE_INTERVAL;
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake) {
        List<Certificate> listPeerCertificates = handshake.peerCertificates();
        if (!listPeerCertificates.isEmpty()) {
            OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.INSTANCE;
            String strHost = httpUrl.host();
            Certificate certificate = listPeerCertificates.get(0);
            j.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (okHostnameVerifier.verify(strHost, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    private final boolean routeMatchesAny(List<Route> list) {
        if (list != null && list.isEmpty()) {
            return false;
        }
        for (Route route : list) {
            Proxy.Type type = route.proxy().type();
            Proxy.Type type2 = Proxy.Type.DIRECT;
            if (type == type2 && getRoute().proxy().type() == type2 && j.a(getRoute().socketAddress(), route.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private final void startHttp2() throws SocketException {
        this.socket.setSoTimeout(0);
        Object obj = this.connectionListener;
        FlowControlListener flowControlListener = obj instanceof FlowControlListener ? (FlowControlListener) obj : null;
        if (flowControlListener == null) {
            flowControlListener = FlowControlListener.None.INSTANCE;
        }
        Http2Connection http2ConnectionBuild = new Http2Connection.Builder(true, this.taskRunner).socket(this.socket, getRoute().address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(this.pingIntervalMillis).flowControlListener(flowControlListener).build();
        this.http2Connection = http2ConnectionBuild;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(http2ConnectionBuild, false, 1, null);
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        Handshake handshake;
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        HttpUrl httpUrlUrl = getRoute().address().url();
        if (httpUrl.port() != httpUrlUrl.port()) {
            return false;
        }
        if (j.a(httpUrl.host(), httpUrlUrl.host())) {
            return true;
        }
        return (this.noCoalescedConnections || (handshake = this.handshake) == null || !certificateSupportHost(httpUrl, handshake)) ? false : true;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    /* renamed from: cancel */
    public void mo230cancel() {
        _UtilJvmKt.closeQuietly(this.rawSocket);
    }

    public final void connectFailed$okhttp(OkHttpClient client, Route failedRoute, IOException failure) {
        j.e(client, "client");
        j.e(failedRoute, "failedRoute");
        j.e(failure, "failure");
        if (failedRoute.proxy().type() != Proxy.Type.DIRECT) {
            Address address = failedRoute.address();
            address.proxySelector().connectFailed(address.url().uri(), failedRoute.proxy().address(), failure);
        }
        client.getRouteDatabase$okhttp().failed(failedRoute);
    }

    public final int getAllocationLimit$okhttp() {
        return this.allocationLimit;
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final ConnectionListener getConnectionListener$okhttp() {
        return this.connectionListener;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public Route getRoute() {
        return this.route;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public final void incrementSuccessCount$okhttp() {
        synchronized (this) {
            this.successCount++;
        }
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        j.e(address, "address");
        if (_UtilJvmKt.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !getRoute().address().equalsNonHost$okhttp(address)) {
            return false;
        }
        if (j.a(address.url().host(), route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            CertificatePinner certificatePinner = address.certificatePinner();
            j.b(certificatePinner);
            String strHost = address.url().host();
            Handshake handshake = handshake();
            j.b(handshake);
            certificatePinner.check(strHost, handshake.peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean isHealthy(boolean z2) {
        long j;
        if (_UtilJvmKt.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        if (this.rawSocket.isClosed() || this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return http2Connection.isHealthy(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.idleAtNs;
        }
        if (j < IDLE_CONNECTION_HEALTHY_NS || !z2) {
            return true;
        }
        return _UtilJvmKt.isHealthy(this.socket, this.source);
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient client, RealInterceptorChain chain) throws SocketException {
        j.e(client, "client");
        j.e(chain, "chain");
        Socket socket = this.socket;
        n nVar = this.source;
        m mVar = this.sink;
        Http2Connection http2Connection = this.http2Connection;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(client, this, chain, http2Connection);
        }
        socket.setSoTimeout(chain.readTimeoutMillis());
        s0 s0VarTimeout = nVar.timeout();
        long readTimeoutMillis$okhttp = chain.getReadTimeoutMillis$okhttp();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        s0VarTimeout.timeout(readTimeoutMillis$okhttp, timeUnit);
        mVar.timeout().timeout(chain.getWriteTimeoutMillis$okhttp(), timeUnit);
        return new Http1ExchangeCodec(client, this, nVar, mVar);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(final Exchange exchange) throws SocketException {
        j.e(exchange, "exchange");
        this.socket.setSoTimeout(0);
        noNewExchanges();
        final n nVar = this.source;
        final m mVar = this.sink;
        return new RealWebSocket.Streams(nVar, mVar) { // from class: okhttp3.internal.connection.RealConnection$newWebSocketStreams$1
            @Override // okhttp3.internal.ws.RealWebSocket.Streams
            public void cancel() {
                exchange.cancel();
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                exchange.bodyComplete(-1L, true, true, null);
            }
        };
    }

    public final void noCoalescedConnections$okhttp() {
        synchronized (this) {
            this.noCoalescedConnections = true;
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    public void noNewExchanges() {
        synchronized (this) {
            this.noNewExchanges = true;
        }
        this.connectionListener.noNewExchanges(this);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection connection, Settings settings) {
        j.e(connection, "connection");
        j.e(settings, "settings");
        synchronized (this) {
            try {
                int i2 = this.allocationLimit;
                int maxConcurrentStreams = settings.getMaxConcurrentStreams();
                this.allocationLimit = maxConcurrentStreams;
                if (maxConcurrentStreams < i2) {
                    this.connectionPool.scheduleOpener(getRoute().address());
                } else if (maxConcurrentStreams > i2) {
                    this.connectionPool.scheduleCloser();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream stream) {
        j.e(stream, "stream");
        stream.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.protocol;
    }

    @Override // okhttp3.Connection
    public Route route() {
        return getRoute();
    }

    public final void setIdleAtNs(long j) {
        this.idleAtNs = j;
    }

    public final void setNoNewExchanges(boolean z2) {
        this.noNewExchanges = z2;
    }

    public final void setRouteFailureCount$okhttp(int i2) {
        this.routeFailureCount = i2;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.socket;
    }

    public final void start() throws SocketException {
        this.idleAtNs = System.nanoTime();
        Protocol protocol = this.protocol;
        if (protocol == Protocol.HTTP_2 || protocol == Protocol.H2_PRIOR_KNOWLEDGE) {
            startHttp2();
        }
    }

    public String toString() {
        Object objCipherSuite;
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(getRoute().address().url().host());
        sb.append(':');
        sb.append(getRoute().address().url().port());
        sb.append(", proxy=");
        sb.append(getRoute().proxy());
        sb.append(" hostAddress=");
        sb.append(getRoute().socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.handshake;
        if (handshake == null || (objCipherSuite = handshake.cipherSuite()) == null) {
            objCipherSuite = "none";
        }
        sb.append(objCipherSuite);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    @Override // okhttp3.internal.http.ExchangeCodec.Carrier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void trackFailure(okhttp3.internal.connection.RealCall r4, java.io.IOException r5) {
        /*
            r3 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.j.e(r4, r0)
            monitor-enter(r3)
            boolean r0 = r5 instanceof okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> L26
            r1 = 1
            if (r0 == 0) goto L41
            r0 = r5
            okhttp3.internal.http2.StreamResetException r0 = (okhttp3.internal.http2.StreamResetException) r0     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r0 = r0.errorCode     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r2 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch: java.lang.Throwable -> L26
            if (r0 != r2) goto L28
            int r4 = r3.refusedStreamCount     // Catch: java.lang.Throwable -> L26
            int r4 = r4 + r1
            r3.refusedStreamCount = r4     // Catch: java.lang.Throwable -> L26
            if (r4 <= r1) goto L4c
            boolean r4 = r3.noNewExchanges     // Catch: java.lang.Throwable -> L26
            r4 = r4 ^ r1
            r3.noNewExchanges = r1     // Catch: java.lang.Throwable -> L26
            int r5 = r3.routeFailureCount     // Catch: java.lang.Throwable -> L26
            int r5 = r5 + r1
            r3.routeFailureCount = r5     // Catch: java.lang.Throwable -> L26
            goto L6a
        L26:
            r4 = move-exception
            goto L73
        L28:
            okhttp3.internal.http2.StreamResetException r5 = (okhttp3.internal.http2.StreamResetException) r5     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r5 = r5.errorCode     // Catch: java.lang.Throwable -> L26
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch: java.lang.Throwable -> L26
            if (r5 != r0) goto L36
            boolean r4 = r4.isCanceled()     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L4c
        L36:
            boolean r4 = r3.noNewExchanges     // Catch: java.lang.Throwable -> L26
            r4 = r4 ^ r1
            r3.noNewExchanges = r1     // Catch: java.lang.Throwable -> L26
            int r5 = r3.routeFailureCount     // Catch: java.lang.Throwable -> L26
            int r5 = r5 + r1
            r3.routeFailureCount = r5     // Catch: java.lang.Throwable -> L26
            goto L6a
        L41:
            boolean r0 = r3.isMultiplexed$okhttp()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L4e
            boolean r0 = r5 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L4c
            goto L4e
        L4c:
            r4 = 0
            goto L6a
        L4e:
            boolean r0 = r3.noNewExchanges     // Catch: java.lang.Throwable -> L26
            r0 = r0 ^ r1
            r3.noNewExchanges = r1     // Catch: java.lang.Throwable -> L26
            int r2 = r3.successCount     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L69
            if (r5 == 0) goto L64
            okhttp3.OkHttpClient r4 = r4.getClient()     // Catch: java.lang.Throwable -> L26
            okhttp3.Route r2 = r3.getRoute()     // Catch: java.lang.Throwable -> L26
            r3.connectFailed$okhttp(r4, r2, r5)     // Catch: java.lang.Throwable -> L26
        L64:
            int r4 = r3.routeFailureCount     // Catch: java.lang.Throwable -> L26
            int r4 = r4 + r1
            r3.routeFailureCount = r4     // Catch: java.lang.Throwable -> L26
        L69:
            r4 = r0
        L6a:
            monitor-exit(r3)
            if (r4 == 0) goto L72
            okhttp3.internal.connection.ConnectionListener r4 = r3.connectionListener
            r4.noNewExchanges(r3)
        L72:
            return
        L73:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.trackFailure(okhttp3.internal.connection.RealCall, java.io.IOException):void");
    }
}
