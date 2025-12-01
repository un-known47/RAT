package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RequiresApi(29)
/* loaded from: classes.dex */
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i2) {
        android.os.Trace.beginAsyncSection(str, i2);
    }

    public static void endAsyncSection(@NonNull String str, int i2) {
        android.os.Trace.endAsyncSection(str, i2);
    }

    public static void setCounter(@NonNull String str, int i2) {
        android.os.Trace.setCounter(str, i2);
    }
}
