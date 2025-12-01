package okhttp3.internal.publicsuffix;

import kotlin.jvm.internal.j;
import okhttp3.internal.publicsuffix.PublicSuffixList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class PublicSuffixList_androidKt {
    public static final PublicSuffixList getDefault(PublicSuffixList.Companion companion) {
        j.e(companion, "<this>");
        return new AssetPublicSuffixList(null, 1, null);
    }
}
