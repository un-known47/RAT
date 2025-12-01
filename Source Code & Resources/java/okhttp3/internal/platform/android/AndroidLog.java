package okhttp3.internal.platform.android;

import android.util.Log;
import f1.j;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import m0.v;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@SuppressSignatureCheck
/* loaded from: classes.dex */
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = v.i0(linkedHashMap);
    }

    private AndroidLog() {
    }

    public static /* synthetic */ void androidLog$okhttp$default(AndroidLog androidLog, String str, int i2, String str2, Throwable th, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            th = null;
        }
        androidLog.androidLog$okhttp(str, i2, str2, th);
    }

    private final void enableLogging(String str, String str2) throws SecurityException {
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        return str2 == null ? j.C0(23, str) : str2;
    }

    public final void androidLog$okhttp(String loggerName, int i2, String message, Throwable th) {
        int iMin;
        kotlin.jvm.internal.j.e(loggerName, "loggerName");
        kotlin.jvm.internal.j.e(message, "message");
        String strLoggerTag = loggerTag(loggerName);
        if (Log.isLoggable(strLoggerTag, i2)) {
            if (th != null) {
                message = message + '\n' + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i3 = 0;
            while (i3 < length) {
                int iU0 = j.u0(message, '\n', i3, 4);
                if (iU0 == -1) {
                    iU0 = length;
                }
                while (true) {
                    iMin = Math.min(iU0, i3 + MAX_LOG_LENGTH);
                    String strSubstring = message.substring(i3, iMin);
                    kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
                    Log.println(i2, strLoggerTag, strSubstring);
                    if (iMin >= iU0) {
                        break;
                    } else {
                        i3 = iMin;
                    }
                }
                i3 = iMin + 1;
            }
        }
    }

    public final void enable() {
        try {
            for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
                enableLogging(entry.getKey(), entry.getValue());
            }
        } catch (RuntimeException e2) {
            e2.printStackTrace();
        }
    }
}
