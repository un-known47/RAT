package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class RetryTlsHandshakeKt {
    public static final boolean retryTlsHandshake(IOException e2) {
        j.e(e2, "e");
        if ((e2 instanceof ProtocolException) || (e2 instanceof InterruptedIOException)) {
            return false;
        }
        return (((e2 instanceof SSLHandshakeException) && (e2.getCause() instanceof CertificateException)) || (e2 instanceof SSLPeerUnverifiedException) || !(e2 instanceof SSLException)) ? false : true;
    }
}
