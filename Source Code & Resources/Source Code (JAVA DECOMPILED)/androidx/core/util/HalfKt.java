package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(short s2) {
        return Half.valueOf(s2);
    }

    @RequiresApi(26)
    public static final Half toHalf(float f2) {
        return Half.valueOf(f2);
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    public static final Half toHalf(double d) {
        return Half.valueOf((float) d);
    }
}
