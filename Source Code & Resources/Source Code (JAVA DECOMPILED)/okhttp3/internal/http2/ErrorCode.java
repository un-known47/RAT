package okhttp3.internal.http2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ErrorCode {
    private static final /* synthetic */ s0.a $ENTRIES;
    private static final /* synthetic */ ErrorCode[] $VALUES;
    public static final Companion Companion;
    private final int httpCode;
    public static final ErrorCode NO_ERROR = new ErrorCode("NO_ERROR", 0, 0);
    public static final ErrorCode PROTOCOL_ERROR = new ErrorCode("PROTOCOL_ERROR", 1, 1);
    public static final ErrorCode INTERNAL_ERROR = new ErrorCode("INTERNAL_ERROR", 2, 2);
    public static final ErrorCode FLOW_CONTROL_ERROR = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
    public static final ErrorCode SETTINGS_TIMEOUT = new ErrorCode("SETTINGS_TIMEOUT", 4, 4);
    public static final ErrorCode STREAM_CLOSED = new ErrorCode("STREAM_CLOSED", 5, 5);
    public static final ErrorCode FRAME_SIZE_ERROR = new ErrorCode("FRAME_SIZE_ERROR", 6, 6);
    public static final ErrorCode REFUSED_STREAM = new ErrorCode("REFUSED_STREAM", 7, 7);
    public static final ErrorCode CANCEL = new ErrorCode("CANCEL", 8, 8);
    public static final ErrorCode COMPRESSION_ERROR = new ErrorCode("COMPRESSION_ERROR", 9, 9);
    public static final ErrorCode CONNECT_ERROR = new ErrorCode("CONNECT_ERROR", 10, 10);
    public static final ErrorCode ENHANCE_YOUR_CALM = new ErrorCode("ENHANCE_YOUR_CALM", 11, 11);
    public static final ErrorCode INADEQUATE_SECURITY = new ErrorCode("INADEQUATE_SECURITY", 12, 12);
    public static final ErrorCode HTTP_1_1_REQUIRED = new ErrorCode("HTTP_1_1_REQUIRED", 13, 13);

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final ErrorCode fromHttp2(int i2) {
            for (ErrorCode errorCode : ErrorCode.values()) {
                if (errorCode.getHttpCode() == i2) {
                    return errorCode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ErrorCode[] $values() {
        return new ErrorCode[]{NO_ERROR, PROTOCOL_ERROR, INTERNAL_ERROR, FLOW_CONTROL_ERROR, SETTINGS_TIMEOUT, STREAM_CLOSED, FRAME_SIZE_ERROR, REFUSED_STREAM, CANCEL, COMPRESSION_ERROR, CONNECT_ERROR, ENHANCE_YOUR_CALM, INADEQUATE_SECURITY, HTTP_1_1_REQUIRED};
    }

    static {
        ErrorCode[] errorCodeArr$values = $values();
        $VALUES = errorCodeArr$values;
        $ENTRIES = p.a.v(errorCodeArr$values);
        Companion = new Companion(null);
    }

    private ErrorCode(String str, int i2, int i3) {
        this.httpCode = i3;
    }

    public static s0.a getEntries() {
        return $ENTRIES;
    }

    public static ErrorCode valueOf(String str) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, str);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
