package okhttp3.internal;

import java.text.Normalizer;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class _NormalizeJvmKt {
    public static final String normalizeNfc(String string) {
        j.e(string, "string");
        String strNormalize = Normalizer.normalize(string, Normalizer.Form.NFC);
        j.d(strNormalize, "normalize(...)");
        return strNormalize;
    }
}
