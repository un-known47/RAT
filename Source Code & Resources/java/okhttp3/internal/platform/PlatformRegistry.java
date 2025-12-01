package okhttp3.internal.platform;

import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.g;
import okhttp3.internal.platform.android.AndroidLog;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class PlatformRegistry {
    public static final PlatformRegistry INSTANCE = new PlatformRegistry();

    private PlatformRegistry() {
    }

    public final Platform findPlatform() {
        AndroidLog.INSTANCE.enable();
        Platform platformBuildIfSupported = Android10Platform.Companion.buildIfSupported();
        if (platformBuildIfSupported == null) {
            platformBuildIfSupported = AndroidPlatform.Companion.buildIfSupported();
        }
        if (platformBuildIfSupported != null) {
            return platformBuildIfSupported;
        }
        throw new IllegalStateException(g.c(Build.VERSION.SDK_INT, "Expected Android API level 21+ but was "));
    }

    public final Context getApplicationContext() {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            return contextAwarePlatform.getApplicationContext();
        }
        return null;
    }

    public final boolean isAndroid() {
        return true;
    }

    public final void setApplicationContext(Context context) {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            contextAwarePlatform.setApplicationContext(context);
        }
    }
}
