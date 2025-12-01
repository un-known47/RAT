package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface SocketAdapter {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean matchesSocketFactory(SocketAdapter socketAdapter, SSLSocketFactory sslSocketFactory) {
            j.e(sslSocketFactory, "sslSocketFactory");
            return a.a(socketAdapter, sslSocketFactory);
        }

        @Deprecated
        public static X509TrustManager trustManager(SocketAdapter socketAdapter, SSLSocketFactory sslSocketFactory) {
            j.e(sslSocketFactory, "sslSocketFactory");
            return a.b(socketAdapter, sslSocketFactory);
        }
    }

    void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list);

    String getSelectedProtocol(SSLSocket sSLSocket);

    boolean isSupported();

    boolean matchesSocket(SSLSocket sSLSocket);

    boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory);

    X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory);
}
