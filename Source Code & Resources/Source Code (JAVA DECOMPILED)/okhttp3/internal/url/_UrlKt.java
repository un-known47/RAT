package okhttp3.internal.url;

import f1.a;
import java.io.EOFException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.j;
import o1.l;
import okhttp3.internal._UtilCommonKt;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class _UrlKt {
    public static final String FORM_ENCODE_SET = " !\"#$&'()+,/:;<=>?@[\\]^`{|}~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    public static final String canonicalize(String str, int i2, int i3, String encodeSet, boolean z2, boolean z3, boolean z4, boolean z5) {
        j.e(str, "<this>");
        j.e(encodeSet, "encodeSet");
        return canonicalizeWithCharset$default(str, i2, i3, encodeSet, z2, z3, z4, z5, null, 128, null);
    }

    public static /* synthetic */ String canonicalize$default(String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 8) != 0) {
            z2 = false;
        }
        if ((i4 & 16) != 0) {
            z3 = false;
        }
        if ((i4 & 32) != 0) {
            z4 = false;
        }
        if ((i4 & 64) != 0) {
            z5 = false;
        }
        return canonicalize(str, i2, i3, str2, z2, z3, z4, z5);
    }

    public static final String canonicalizeWithCharset(String str, int i2, int i3, String encodeSet, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) throws EOFException {
        j.e(str, "<this>");
        j.e(encodeSet, "encodeSet");
        int iCharCount = i2;
        while (iCharCount < i3) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z5) || f1.j.q0(encodeSet, (char) iCodePointAt) || ((iCodePointAt == 37 && (!z2 || (z3 && !isPercentEncoded(str, iCharCount, i3)))) || (iCodePointAt == 43 && z4)))) {
                l lVar = new l();
                lVar.c0(str, i2, iCharCount);
                writeCanonicalized(lVar, str, iCharCount, i3, encodeSet, z2, z3, z4, z5, charset);
                return lVar.P();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        String strSubstring = str.substring(i2, i3);
        j.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String canonicalizeWithCharset$default(String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 8) != 0) {
            z2 = false;
        }
        if ((i4 & 16) != 0) {
            z3 = false;
        }
        if ((i4 & 32) != 0) {
            z4 = false;
        }
        if ((i4 & 64) != 0) {
            z5 = false;
        }
        if ((i4 & 128) != 0) {
            charset = null;
        }
        return canonicalizeWithCharset(str, i2, i3, str2, z2, z3, z4, z5, charset);
    }

    public static final char[] getHEX_DIGITS() {
        return HEX_DIGITS;
    }

    public static final boolean isPercentEncoded(String str, int i2, int i3) {
        j.e(str, "<this>");
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && _UtilCommonKt.parseHexDigit(str.charAt(i2 + 1)) != -1 && _UtilCommonKt.parseHexDigit(str.charAt(i4)) != -1;
    }

    public static final String percentDecode(String str, int i2, int i3, boolean z2) {
        j.e(str, "<this>");
        for (int i4 = i2; i4 < i3; i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                l lVar = new l();
                lVar.c0(str, i2, i4);
                writePercentDecoded(lVar, str, i4, i3, z2);
                return lVar.P();
            }
        }
        String strSubstring = str.substring(i2, i3);
        j.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String percentDecode$default(String str, int i2, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return percentDecode(str, i2, i3, z2);
    }

    public static final void writeCanonicalized(l lVar, String input, int i2, int i3, String encodeSet, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) throws EOFException {
        j.e(lVar, "<this>");
        j.e(input, "input");
        j.e(encodeSet, "encodeSet");
        l lVar2 = null;
        while (i2 < i3) {
            int iCodePointAt = input.codePointAt(i2);
            if (!z2 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 32 && encodeSet == FORM_ENCODE_SET) {
                    lVar.b0("+");
                } else if (iCodePointAt == 43 && z4) {
                    lVar.b0(z2 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z5) || f1.j.q0(encodeSet, (char) iCodePointAt) || (iCodePointAt == 37 && (!z2 || (z3 && !isPercentEncoded(input, i2, i3)))))) {
                    if (lVar2 == null) {
                        lVar2 = new l();
                    }
                    if (charset == null || charset.equals(a.f458a)) {
                        lVar2.d0(iCodePointAt);
                    } else {
                        lVar2.a0(input, i2, Character.charCount(iCodePointAt) + i2, charset);
                    }
                    while (!lVar2.q()) {
                        byte b2 = lVar2.readByte();
                        lVar.U(37);
                        char[] cArr = HEX_DIGITS;
                        lVar.U(cArr[((b2 & 255) >> 4) & 15]);
                        lVar.U(cArr[b2 & 15]);
                    }
                } else {
                    lVar.d0(iCodePointAt);
                }
            }
            i2 += Character.charCount(iCodePointAt);
        }
    }

    public static final void writePercentDecoded(l lVar, String encoded, int i2, int i3, boolean z2) {
        int i4;
        j.e(lVar, "<this>");
        j.e(encoded, "encoded");
        while (i2 < i3) {
            int iCodePointAt = encoded.codePointAt(i2);
            if (iCodePointAt == 37 && (i4 = i2 + 2) < i3) {
                int hexDigit = _UtilCommonKt.parseHexDigit(encoded.charAt(i2 + 1));
                int hexDigit2 = _UtilCommonKt.parseHexDigit(encoded.charAt(i4));
                if (hexDigit == -1 || hexDigit2 == -1) {
                    lVar.d0(iCodePointAt);
                    i2 += Character.charCount(iCodePointAt);
                } else {
                    lVar.U((hexDigit << 4) + hexDigit2);
                    i2 = Character.charCount(iCodePointAt) + i4;
                }
            } else if (iCodePointAt == 43 && z2) {
                lVar.U(32);
                i2++;
            } else {
                lVar.d0(iCodePointAt);
                i2 += Character.charCount(iCodePointAt);
            }
        }
    }
}
