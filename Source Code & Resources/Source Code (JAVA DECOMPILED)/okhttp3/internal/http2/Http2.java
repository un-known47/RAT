package okhttp3.internal.http2;

import f1.q;
import kotlin.jvm.internal.j;
import o1.o;
import okhttp3.internal._UtilJvmKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Http2 {
    private static final String[] BINARY;
    public static final o CONNECTION_PREFACE;
    private static final String[] FLAGS;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        o oVar = o.d;
        CONNECTION_PREFACE = g.g.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int i2 = 0; i2 < 256; i2++) {
            String binaryString = Integer.toBinaryString(i2);
            j.d(binaryString, "toBinaryString(...)");
            strArr[i2] = q.l0(_UtilJvmKt.format("%8s", binaryString), ' ', '0');
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i3 = iArr[0];
        strArr2[i3 | 8] = androidx.appcompat.app.g.k(new StringBuilder(), strArr2[i3], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            int i6 = iArr[0];
            String[] strArr3 = FLAGS;
            int i7 = i6 | i5;
            strArr3[i7] = strArr3[i6] + '|' + strArr3[i5];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i6]);
            sb.append('|');
            strArr3[i7 | 8] = androidx.appcompat.app.g.k(sb, strArr3[i5], "|PADDED");
        }
        int length = FLAGS.length;
        for (int i8 = 0; i8 < length; i8++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i8] == null) {
                strArr4[i8] = BINARY[i8];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i2, int i3) {
        String str;
        if (i3 == 0) {
            return "";
        }
        if (i2 != 2 && i2 != 3) {
            if (i2 == 4 || i2 == 6) {
                return i3 == 1 ? "ACK" : BINARY[i3];
            }
            if (i2 != 7 && i2 != 8) {
                String[] strArr = FLAGS;
                if (i3 < strArr.length) {
                    str = strArr[i3];
                    j.b(str);
                } else {
                    str = BINARY[i3];
                }
                return (i2 != 5 || (i3 & 4) == 0) ? (i2 != 0 || (i3 & 32) == 0) ? str : q.m0(str, "PRIORITY", "COMPRESSED") : q.m0(str, "HEADERS", "PUSH_PROMISE");
            }
        }
        return BINARY[i3];
    }

    public final String formattedType$okhttp(int i2) {
        String[] strArr = FRAME_NAMES;
        return i2 < strArr.length ? strArr[i2] : _UtilJvmKt.format("0x%02x", Integer.valueOf(i2));
    }

    public final String frameLog(boolean z2, int i2, int i3, int i4, int i5) {
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i3), formattedType$okhttp(i4), formatFlags(i4, i5));
    }

    public final String frameLogWindowUpdate(boolean z2, int i2, int i3, long j) {
        return _UtilJvmKt.format("%s 0x%08x %5d %-13s %d", z2 ? "<<" : ">>", Integer.valueOf(i2), Integer.valueOf(i3), formattedType$okhttp(8), Long.valueOf(j));
    }
}
