package f1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class j extends q {
    public static List A0(String str, char[] cArr) {
        kotlin.jvm.internal.j.e(str, "<this>");
        if (cArr.length == 1) {
            String strValueOf = String.valueOf(cArr[0]);
            int iT0 = t0(str, strValueOf, 0, false);
            if (iT0 == -1) {
                return p.a.G(str.toString());
            }
            ArrayList arrayList = new ArrayList(10);
            int length = 0;
            do {
                arrayList.add(str.subSequence(length, iT0).toString());
                length = strValueOf.length() + iT0;
                iT0 = t0(str, strValueOf, length, false);
            } while (iT0 != -1);
            arrayList.add(str.subSequence(length, str.length()).toString());
            return arrayList;
        }
        e1.p pVar = new e1.p(new e1.g(str, new r(cArr)));
        ArrayList arrayList2 = new ArrayList(m0.m.k0(pVar, 10));
        Iterator it = pVar.iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return arrayList2;
            }
            c1.d range = (c1.d) bVar.next();
            kotlin.jvm.internal.j.e(range, "range");
            arrayList2.add(str.subSequence(range.f205a, range.f206b + 1).toString());
        }
    }

    public static String B0(String str, String delimiter) {
        kotlin.jvm.internal.j.e(delimiter, "delimiter");
        int iV0 = v0(str, delimiter, 0, 6);
        if (iV0 == -1) {
            return str;
        }
        String strSubstring = str.substring(delimiter.length() + iV0, str.length());
        kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String C0(int i2, String str) {
        kotlin.jvm.internal.j.e(str, "<this>");
        if (i2 < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.e("Requested character count ", i2, " is less than zero.").toString());
        }
        int length = str.length();
        if (i2 > length) {
            i2 = length;
        }
        String strSubstring = str.substring(0, i2);
        kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence D0(String str) {
        kotlin.jvm.internal.j.e(str, "<this>");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            char cCharAt = str.charAt(!z2 ? i2 : length);
            boolean z3 = Character.isWhitespace(cCharAt) || Character.isSpaceChar(cCharAt);
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (z3) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return str.subSequence(i2, length + 1);
    }

    public static boolean q0(CharSequence charSequence, char c) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        return u0(charSequence, c, 0, 2) >= 0;
    }

    public static boolean r0(String str, String str2) {
        kotlin.jvm.internal.j.e(str, "<this>");
        return v0(str, str2, 0, 2) >= 0;
    }

    public static final int s0(CharSequence charSequence) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int t0(CharSequence other, String string, int i2, boolean z2) {
        kotlin.jvm.internal.j.e(other, "<this>");
        kotlin.jvm.internal.j.e(string, "string");
        if (!z2 && (other instanceof String)) {
            return ((String) other).indexOf(string, i2);
        }
        int length = other.length();
        if (i2 < 0) {
            i2 = 0;
        }
        int length2 = other.length();
        if (length > length2) {
            length = length2;
        }
        c1.d dVar = new c1.d(i2, length, 1);
        boolean z3 = other instanceof String;
        int i3 = dVar.c;
        int i4 = dVar.f206b;
        int i5 = dVar.f205a;
        if (z3 && (string instanceof String)) {
            if ((i3 <= 0 || i5 > i4) && (i3 >= 0 || i4 > i5)) {
                return -1;
            }
            int i6 = i5;
            while (true) {
                String str = string;
                boolean z4 = z2;
                if (q.k0(str, 0, z4, (String) other, i6, string.length())) {
                    return i6;
                }
                if (i6 == i4) {
                    return -1;
                }
                i6 += i3;
                string = str;
                z2 = z4;
            }
        } else {
            if ((i3 <= 0 || i5 > i4) && (i3 >= 0 || i4 > i5)) {
                return -1;
            }
            while (true) {
                int length3 = string.length();
                kotlin.jvm.internal.j.e(string, "<this>");
                kotlin.jvm.internal.j.e(other, "other");
                boolean z5 = false;
                if (i5 >= 0 && string.length() - length3 >= 0 && i5 <= other.length() - length3) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= length3) {
                            z5 = true;
                            break;
                        }
                        if (!p.a.w(string.charAt(0 + i7), other.charAt(i5 + i7), z2)) {
                            break;
                        }
                        i7++;
                    }
                }
                if (z5) {
                    return i5;
                }
                if (i5 == i4) {
                    return -1;
                }
                i5 += i3;
            }
        }
    }

    public static int u0(CharSequence charSequence, char c, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        return !(charSequence instanceof String) ? w0(charSequence, new char[]{c}, i2, false) : ((String) charSequence).indexOf(c, i2);
    }

    public static /* synthetic */ int v0(CharSequence charSequence, String str, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return t0(charSequence, str, i2, false);
    }

    public static final int w0(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        kotlin.jvm.internal.j.e(charSequence, "<this>");
        if (!z2 && cArr.length == 1 && (charSequence instanceof String)) {
            int length = cArr.length;
            if (length == 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            if (length != 1) {
                throw new IllegalArgumentException("Array has more than one element.");
            }
            return ((String) charSequence).indexOf(cArr[0], i2);
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int iS0 = s0(charSequence);
        if (i2 > iS0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i2);
            for (char c : cArr) {
                if (p.a.w(c, cCharAt, z2)) {
                    return i2;
                }
            }
            if (i2 == iS0) {
                return -1;
            }
            i2++;
        }
    }

    public static int x0(String str, char c, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = s0(str);
        }
        kotlin.jvm.internal.j.e(str, "<this>");
        return str.lastIndexOf(c, i2);
    }

    public static String y0(String str) {
        CharSequence charSequenceSubSequence;
        if (8 <= str.length()) {
            charSequenceSubSequence = str.subSequence(0, str.length());
        } else {
            StringBuilder sb = new StringBuilder(8);
            int length = 8 - str.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append('0');
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append((CharSequence) str);
            charSequenceSubSequence = sb;
        }
        return charSequenceSubSequence.toString();
    }

    public static String z0(String str, String str2) {
        if (!q.o0(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
        return strSubstring;
    }
}
