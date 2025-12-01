package f1;

import java.util.Comparator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class q extends p {
    public static boolean h0(String str, String suffix, boolean z2) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(suffix, "suffix");
        return !z2 ? str.endsWith(suffix) : k0(str, str.length() - suffix.length(), true, suffix, 0, suffix.length());
    }

    public static boolean i0(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static void j0() {
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.j.d(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
    }

    public static boolean k0(String str, int i2, boolean z2, String other, int i3, int i4) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(other, "other");
        return !z2 ? str.regionMatches(i2, other, i3, i4) : str.regionMatches(z2, i2, other, i3, i4);
    }

    public static String l0(String str, char c, char c2) {
        kotlin.jvm.internal.j.e(str, "<this>");
        String strReplace = str.replace(c, c2);
        kotlin.jvm.internal.j.d(strReplace, "replace(...)");
        return strReplace;
    }

    public static String m0(String str, String str2, String str3) {
        kotlin.jvm.internal.j.e(str, "<this>");
        int iT0 = j.t0(str, str2, 0, false);
        if (iT0 < 0) {
            return str;
        }
        int length = str2.length();
        int i2 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        int i3 = 0;
        do {
            sb.append((CharSequence) str, i3, iT0);
            sb.append(str3);
            i3 = iT0 + length;
            if (iT0 >= str.length()) {
                break;
            }
            iT0 = j.t0(str, str2, iT0 + i2, false);
        } while (iT0 > 0);
        sb.append((CharSequence) str, i3, str.length());
        String string = sb.toString();
        kotlin.jvm.internal.j.d(string, "toString(...)");
        return string;
    }

    public static boolean n0(String str, String str2, int i2, boolean z2) {
        kotlin.jvm.internal.j.e(str, "<this>");
        return !z2 ? str.startsWith(str2, i2) : k0(str, i2, z2, str2, 0, str2.length());
    }

    public static boolean o0(String str, String prefix, boolean z2) {
        kotlin.jvm.internal.j.e(str, "<this>");
        kotlin.jvm.internal.j.e(prefix, "prefix");
        return !z2 ? str.startsWith(prefix) : k0(str, 0, z2, prefix, 0, prefix.length());
    }

    public static Integer p0(String str) {
        boolean z2;
        int i2;
        int i3;
        p.a.j(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        if (kotlin.jvm.internal.j.f(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '+') {
                z2 = false;
            } else {
                if (cCharAt != '-') {
                    return null;
                }
                i5 = Integer.MIN_VALUE;
                z2 = true;
            }
        } else {
            z2 = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int iDigit = Character.digit((int) str.charAt(i2), 10);
            if (iDigit < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / 10))) || (i3 = i4 * 10) < i5 + iDigit) {
                return null;
            }
            i4 = i3 - iDigit;
            i2++;
        }
        return z2 ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }
}
