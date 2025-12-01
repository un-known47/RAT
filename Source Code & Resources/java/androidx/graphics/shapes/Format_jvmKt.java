package androidx.graphics.shapes;

import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Format_jvmKt {
    public static final String toStringWithLessPrecision(float f2) {
        return String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
    }
}
