package okhttp3.internal.http;

import f1.q;
import java.net.ProtocolException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import okhttp3.Protocol;
import okhttp3.Response;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final StatusLine get(Response response) {
            j.e(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String statusLine) throws ProtocolException {
            Protocol protocol;
            int i2;
            String strSubstring;
            j.e(statusLine, "statusLine");
            if (q.o0(statusLine, "HTTP/1.", false)) {
                i2 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else if (q.o0(statusLine, "ICY ", false)) {
                protocol = Protocol.HTTP_1_0;
                i2 = 4;
            } else {
                if (!q.o0(statusLine, "SOURCETABLE ", false)) {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                protocol = Protocol.HTTP_1_1;
                i2 = 12;
            }
            int i3 = i2 + 3;
            if (statusLine.length() < i3) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            String strSubstring2 = statusLine.substring(i2, i3);
            j.d(strSubstring2, "substring(...)");
            Integer numP0 = q.p0(strSubstring2);
            if (numP0 == null) {
                throw new ProtocolException("Unexpected status line: ".concat(statusLine));
            }
            int iIntValue = numP0.intValue();
            if (statusLine.length() <= i3) {
                strSubstring = "";
            } else {
                if (statusLine.charAt(i3) != ' ') {
                    throw new ProtocolException("Unexpected status line: ".concat(statusLine));
                }
                strSubstring = statusLine.substring(i2 + 4);
                j.d(strSubstring, "substring(...)");
            }
            return new StatusLine(protocol, iIntValue, strSubstring);
        }

        private Companion() {
        }
    }

    public StatusLine(Protocol protocol, int i2, String message) {
        j.e(protocol, "protocol");
        j.e(message, "message");
        this.protocol = protocol;
        this.code = i2;
        this.message = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            sb.append("HTTP/1.0");
        } else {
            sb.append("HTTP/1.1");
        }
        sb.append(' ');
        sb.append(this.code);
        sb.append(' ');
        sb.append(this.message);
        return sb.toString();
    }
}
