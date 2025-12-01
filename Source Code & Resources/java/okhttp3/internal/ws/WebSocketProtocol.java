package okhttp3.internal.ws;

import g.g;
import kotlin.jvm.internal.j;
import o1.i;
import o1.l;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String key) {
        j.e(key, "key");
        o oVar = o.d;
        return g.e(key.concat(ACCEPT_MAGIC)).c("SHA-1").a();
    }

    public final String closeCodeExceptionMessage(int i2) {
        if (i2 < 1000 || i2 >= 5000) {
            return androidx.appcompat.app.g.c(i2, "Code must be in range [1000,5000): ");
        }
        if ((1004 > i2 || i2 >= 1007) && (1015 > i2 || i2 >= 3000)) {
            return null;
        }
        return androidx.appcompat.app.g.e("Code ", i2, " is reserved and may not be used.");
    }

    public final void toggleMask(i cursor, byte[] key) {
        long j;
        j.e(cursor, "cursor");
        j.e(key, "key");
        int length = key.length;
        int i2 = 0;
        do {
            byte[] bArr = cursor.f903e;
            int i3 = cursor.f904f;
            int i4 = cursor.f905g;
            if (bArr != null) {
                while (i3 < i4) {
                    int i5 = i2 % length;
                    bArr[i3] = (byte) (bArr[i3] ^ key[i5]);
                    i3++;
                    i2 = i5 + 1;
                }
            }
            long j2 = cursor.d;
            l lVar = cursor.f901a;
            j.b(lVar);
            if (j2 == lVar.f919b) {
                throw new IllegalStateException("no more bytes");
            }
            j = cursor.d;
        } while (cursor.D(j == -1 ? 0L : j + (cursor.f905g - cursor.f904f)) != -1);
    }

    public final void validateCloseCode(int i2) {
        String strCloseCodeExceptionMessage = closeCodeExceptionMessage(i2);
        if (strCloseCodeExceptionMessage == null) {
            return;
        }
        j.b(strCloseCodeExceptionMessage);
        throw new IllegalArgumentException(strCloseCodeExceptionMessage.toString());
    }
}
