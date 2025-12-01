package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static boolean a(SocketAdapter socketAdapter, SSLSocketFactory sslSocketFactory) {
        j.e(sslSocketFactory, "sslSocketFactory");
        return false;
    }

    public static X509TrustManager b(SocketAdapter socketAdapter, SSLSocketFactory sslSocketFactory) {
        j.e(sslSocketFactory, "sslSocketFactory");
        return null;
    }
}
