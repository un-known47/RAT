package okhttp3.internal.idn;

import kotlin.jvm.internal.j;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class IdnaMappingTableKt {
    public static final int binarySearch(int i2, int i3, l compare) {
        j.e(compare, "compare");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) / 2;
            int iIntValue = ((Number) compare.invoke(Integer.valueOf(i5))).intValue();
            if (iIntValue < 0) {
                i4 = i5 - 1;
            } else {
                if (iIntValue <= 0) {
                    return i5;
                }
                i2 = i5 + 1;
            }
        }
        return (-i2) - 1;
    }

    public static final int read14BitInt(String str, int i2) {
        j.e(str, "<this>");
        char cCharAt = str.charAt(i2);
        return (cCharAt << 7) + str.charAt(i2 + 1);
    }
}
