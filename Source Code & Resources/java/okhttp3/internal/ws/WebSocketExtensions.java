package okhttp3.internal.ws;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00b9 A[PHI: r7 r9 r11
  0x00b9: PHI (r7v5 java.lang.Integer) = (r7v4 java.lang.Integer), (r7v9 java.lang.Integer) binds: [B:52:0x00e0, B:34:0x00b0] A[DONT_GENERATE, DONT_INLINE]
  0x00b9: PHI (r9v8 java.lang.Integer) = (r9v6 java.lang.Integer), (r9v4 java.lang.Integer) binds: [B:52:0x00e0, B:34:0x00b0] A[DONT_GENERATE, DONT_INLINE]
  0x00b9: PHI (r11v16 boolean) = (r11v10 boolean), (r11v19 boolean) binds: [B:52:0x00e0, B:34:0x00b0] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final okhttp3.internal.ws.WebSocketExtensions parse(okhttp3.Headers r19) {
            /*
                Method dump skipped, instructions count: 262
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.WebSocketExtensions.Companion.parse(okhttp3.Headers):okhttp3.internal.ws.WebSocketExtensions");
        }

        private Companion() {
        }
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = webSocketExtensions.perMessageDeflate;
        }
        if ((i2 & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i2 & 4) != 0) {
            z3 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i2 & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i2 & 16) != 0) {
            z4 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i2 & 32) != 0) {
            z5 = webSocketExtensions.unknownValues;
        }
        boolean z6 = z4;
        boolean z7 = z5;
        return webSocketExtensions.copy(z2, num, z3, num2, z6, z7);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        return new WebSocketExtensions(z2, num, z3, num2, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && j.a(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && j.a(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        int i2 = (this.perMessageDeflate ? 1231 : 1237) * 31;
        Integer num = this.clientMaxWindowBits;
        int iHashCode = (((i2 + (num == null ? 0 : num.hashCode())) * 31) + (this.clientNoContextTakeover ? 1231 : 1237)) * 31;
        Integer num2 = this.serverMaxWindowBits;
        return ((((iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31) + (this.serverNoContextTakeover ? 1231 : 1237)) * 31) + (this.unknownValues ? 1231 : 1237);
    }

    public final boolean noContextTakeover(boolean z2) {
        return z2 ? this.clientNoContextTakeover : this.serverNoContextTakeover;
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5) {
        this.perMessageDeflate = z2;
        this.clientMaxWindowBits = num;
        this.clientNoContextTakeover = z3;
        this.serverMaxWindowBits = num2;
        this.serverNoContextTakeover = z4;
        this.unknownValues = z5;
    }

    public /* synthetic */ WebSocketExtensions(boolean z2, Integer num, boolean z3, Integer num2, boolean z4, boolean z5, int i2, e eVar) {
        this((i2 & 1) != 0 ? false : z2, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? false : z4, (i2 & 32) != 0 ? false : z5);
    }
}
