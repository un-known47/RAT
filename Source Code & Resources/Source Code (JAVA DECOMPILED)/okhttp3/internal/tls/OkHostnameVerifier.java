package okhttp3.internal.tls;

import androidx.appcompat.app.g;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.jvm.internal.j;
import m0.k;
import m0.q;
import okhttp3.internal._HostnamesCommonKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    private final String asciiToLowercase(String str) {
        if (!isAscii(str)) {
            return str;
        }
        Locale US = Locale.US;
        j.d(US, "US");
        String lowerCase = str.toLowerCase(US);
        j.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i2) throws CertificateParsingException {
        Object obj;
        q qVar = q.f867a;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return qVar;
            }
            ArrayList arrayList = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && j.a(list.get(0), Integer.valueOf(i2)) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return qVar;
        }
    }

    private final boolean isAscii(String str) {
        int i2;
        int length = str.length();
        int length2 = str.length();
        if (length2 < 0) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + length2 + " < 0").toString());
        }
        if (length2 > str.length()) {
            StringBuilder sbQ = g.q("endIndex > string.length: ", length2, " > ");
            sbQ.append(str.length());
            throw new IllegalArgumentException(sbQ.toString().toString());
        }
        long j = 0;
        int i3 = 0;
        while (i3 < length2) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i2 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i2 = 3;
                } else {
                    int i4 = i3 + 1;
                    char cCharAt2 = i4 < length2 ? str.charAt(i4) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i3 = i4;
                    } else {
                        j += 4;
                        i3 += 2;
                    }
                }
                j += i2;
            }
            i3++;
        }
        return length == ((int) j);
    }

    private final boolean verifyHostname(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String strAsciiToLowercase = asciiToLowercase(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 2);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (INSTANCE.verifyHostname(strAsciiToLowercase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyIpAddress(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
        List<String> subjectAltNames = getSubjectAltNames(x509Certificate, 7);
        if (subjectAltNames != null && subjectAltNames.isEmpty()) {
            return false;
        }
        Iterator<T> it = subjectAltNames.iterator();
        while (it.hasNext()) {
            if (j.a(canonicalHost, _HostnamesCommonKt.toCanonicalHost((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    public final List<String> allSubjectAltNames(X509Certificate certificate) {
        j.e(certificate, "certificate");
        return k.u0(getSubjectAltNames(certificate, 7), getSubjectAltNames(certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String host, SSLSession session) {
        j.e(host, "host");
        j.e(session, "session");
        if (!isAscii(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            j.c(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(host, (X509Certificate) certificate);
        } catch (SSLException unused) {
            return false;
        }
    }

    public final boolean verify(String host, X509Certificate certificate) {
        j.e(host, "host");
        j.e(certificate, "certificate");
        return _HostnamesCommonKt.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyHostname(String str, String str2) {
        int length;
        if (str != null && str.length() != 0 && !f1.q.o0(str, ".", false) && !f1.q.h0(str, "..", false) && str2 != null && str2.length() != 0 && !f1.q.o0(str2, ".", false) && !f1.q.h0(str2, "..", false)) {
            if (!f1.q.h0(str, ".", false)) {
                str = str.concat(".");
            }
            if (!f1.q.h0(str2, ".", false)) {
                str2 = str2.concat(".");
            }
            String strAsciiToLowercase = asciiToLowercase(str2);
            if (!f1.j.r0(strAsciiToLowercase, "*")) {
                return j.a(str, strAsciiToLowercase);
            }
            if (f1.q.o0(strAsciiToLowercase, "*.", false) && f1.j.u0(strAsciiToLowercase, '*', 1, 4) == -1 && str.length() >= strAsciiToLowercase.length() && !"*.".equals(strAsciiToLowercase)) {
                String strSubstring = strAsciiToLowercase.substring(1);
                j.d(strSubstring, "substring(...)");
                if (f1.q.h0(str, strSubstring, false) && ((length = str.length() - strSubstring.length()) <= 0 || f1.j.x0(str, '.', length - 1, 4) == -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
