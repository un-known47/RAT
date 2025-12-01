package okhttp3.internal;

import g.g;
import java.io.Closeable;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r;
import m0.q;
import n0.c;
import o1.b;
import o1.g0;
import o1.h0;
import o1.m;
import o1.n;
import o1.o;
import o1.u;
import y0.a;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class _UtilCommonKt {
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final g0 UNICODE_BOMS;
    public static final String USER_AGENT = "okhttp/5.1.0";

    static {
        o oVar = o.d;
        UNICODE_BOMS = b.f(g.d("efbbbf"), g.d("feff"), g.d("fffe0000"), g.d("fffe"), g.d("0000feff"));
    }

    public static final <E> void addIfAbsent(List<E> list, E e2) {
        j.e(list, "<this>");
        if (list.contains(e2)) {
            return;
        }
        list.add(e2);
    }

    public static final int and(byte b2, int i2) {
        return b2 & i2;
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("length=" + j + ", offset=" + j2 + ", count=" + j2);
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        j.e(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String value) {
        j.e(strArr, "<this>");
        j.e(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        j.d(objArrCopyOf, "copyOf(...)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[strArr2.length - 1] = value;
        return strArr2;
    }

    public static final void deleteContents(u uVar, h0 directory) throws IOException {
        j.e(uVar, "<this>");
        j.e(directory, "directory");
        try {
            IOException iOException = null;
            for (h0 h0Var : uVar.list(directory)) {
                try {
                    if (uVar.metadata(h0Var).f938b) {
                        deleteContents(uVar, h0Var);
                    }
                    uVar.delete(h0Var);
                } catch (IOException e2) {
                    if (iOException == null) {
                        iOException = e2;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void deleteIfExists(u uVar, h0 path) {
        j.e(uVar, "<this>");
        j.e(path, "path");
        try {
            uVar.delete(path);
        } catch (FileNotFoundException unused) {
        }
    }

    public static final int delimiterOffset(String str, String delimiters, int i2, int i3) {
        j.e(str, "<this>");
        j.e(delimiters, "delimiters");
        while (i2 < i3) {
            if (f1.j.q0(delimiters, str.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, str2, i2, i3);
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, l predicate) {
        j.e(iterable, "<this>");
        j.e(predicate, "predicate");
        ArrayList arrayList = q.f867a;
        for (T t2 : iterable) {
            if (((Boolean) predicate.invoke(t2)).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                r.a(arrayList).add(t2);
            }
        }
        return arrayList;
    }

    public static final g0 getUNICODE_BOMS() {
        return UNICODE_BOMS;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean hasIntersection(java.lang.String[] r7, java.lang.String[] r8, java.util.Comparator<? super java.lang.String> r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.e(r7, r0)
            java.lang.String r0 = "comparator"
            kotlin.jvm.internal.j.e(r9, r0)
            int r0 = r7.length
            r1 = 0
            if (r0 != 0) goto Lf
            goto L40
        Lf:
            if (r8 == 0) goto L40
            int r0 = r8.length
            if (r0 != 0) goto L15
            goto L40
        L15:
            int r0 = r7.length
            r2 = 0
        L17:
            if (r2 >= r0) goto L40
            r3 = r7[r2]
            r4 = 0
        L1c:
            int r5 = r8.length
            r6 = 1
            if (r4 >= r5) goto L22
            r5 = 1
            goto L23
        L22:
            r5 = 0
        L23:
            if (r5 == 0) goto L3d
            int r5 = r4 + 1
            r4 = r8[r4]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L32
            int r4 = r9.compare(r3, r4)
            if (r4 != 0) goto L30
            return r6
        L30:
            r4 = r5
            goto L1c
        L32:
            r7 = move-exception
            java.util.NoSuchElementException r8 = new java.util.NoSuchElementException
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r7)
            throw r8
        L3d:
            int r2 = r2 + 1
            goto L17
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._UtilCommonKt.hasIntersection(java.lang.String[], java.lang.String[], java.util.Comparator):boolean");
    }

    public static final void ignoreIoExceptions(a block) {
        j.e(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    public static final int indexOf(String[] strArr, String value, Comparator<String> comparator) {
        j.e(strArr, "<this>");
        j.e(value, "value");
        j.e(comparator, "comparator");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], value) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        j.e(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (j.f(cCharAt, 31) <= 0 || j.f(cCharAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i2, int i3) {
        j.e(str, "<this>");
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i2, int i3) {
        j.e(str, "<this>");
        int i4 = i3 - 1;
        if (i2 <= i4) {
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4--;
            }
        }
        return i2;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i2, i3);
    }

    public static final int indexOfNonWhitespace(String str, int i2) {
        j.e(str, "<this>");
        int length = str.length();
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return indexOfNonWhitespace(str, i2);
    }

    public static final <T> List<T> interleave(Iterable<? extends T> a2, Iterable<? extends T> b2) {
        j.e(a2, "a");
        j.e(b2, "b");
        Iterator<? extends T> it = a2.iterator();
        Iterator<? extends T> it2 = b2.iterator();
        c cVarQ = p.a.q();
        while (true) {
            if (!it.hasNext() && !it2.hasNext()) {
                return p.a.e(cVarQ);
            }
            if (it.hasNext()) {
                cVarQ.add(it.next());
            }
            if (it2.hasNext()) {
                cVarQ.add(it2.next());
            }
        }
    }

    public static final String[] intersect(String[] strArr, String[] other, Comparator<? super String> comparator) {
        j.e(strArr, "<this>");
        j.e(other, "other");
        j.e(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isCivilized(o1.u r2, o1.h0 r3) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "file"
            kotlin.jvm.internal.j.e(r3, r0)
            o1.o0 r0 = r2.sink(r3)
            r2.delete(r3)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L24
            r2 = 1
            if (r0 == 0) goto L17
            r0.close()     // Catch: java.lang.Throwable -> L17
        L17:
            return r2
        L18:
            r1 = move-exception
            if (r0 == 0) goto L2f
            r0.close()     // Catch: java.lang.Throwable -> L1f
            goto L2f
        L1f:
            r0 = move-exception
            p.a.b(r1, r0)
            goto L2f
        L24:
            if (r0 == 0) goto L2d
            r0.close()     // Catch: java.lang.Throwable -> L2a
            goto L2d
        L2a:
            r0 = move-exception
        L2b:
            r1 = r0
            goto L2f
        L2d:
            r0 = 0
            goto L2b
        L2f:
            if (r1 != 0) goto L36
            r2.delete(r3)
            r2 = 0
            return r2
        L36:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._UtilCommonKt.isCivilized(o1.u, o1.h0):boolean");
    }

    public static final boolean isSensitiveHeader(String name) {
        j.e(name, "name");
        return name.equalsIgnoreCase("Authorization") || name.equalsIgnoreCase("Cookie") || name.equalsIgnoreCase("Proxy-Authorization") || name.equalsIgnoreCase("Set-Cookie");
    }

    public static final int parseHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' > c || c >= 'G') {
            return -1;
        }
        return c - '7';
    }

    public static final int readMedium(n nVar) {
        j.e(nVar, "<this>");
        return and(nVar.readByte(), 255) | (and(nVar.readByte(), 255) << 16) | (and(nVar.readByte(), 255) << 8);
    }

    public static final int skipAll(o1.l lVar, byte b2) throws EOFException {
        j.e(lVar, "<this>");
        int i2 = 0;
        while (!lVar.q() && lVar.H(0L) == b2) {
            i2++;
            lVar.readByte();
        }
        return i2;
    }

    public static final long toLongOrDefault(String str, long j) {
        j.e(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int toNonNegativeInt(String str, int i2) throws NumberFormatException {
        if (str == null) {
            return i2;
        }
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static final String trimSubstring(String str, int i2, int i3) {
        j.e(str, "<this>");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i2, i3);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i3));
        j.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return trimSubstring(str, i2, i3);
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> suppressed) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        j.e(exc, "<this>");
        j.e(suppressed, "suppressed");
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            p.a.b(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(m mVar, int i2) {
        j.e(mVar, "<this>");
        mVar.writeByte((i2 >>> 16) & 255);
        mVar.writeByte((i2 >>> 8) & 255);
        mVar.writeByte(i2 & 255);
    }

    public static final int and(short s2, int i2) {
        return s2 & i2;
    }

    public static final int delimiterOffset(String str, char c, int i2, int i3) {
        j.e(str, "<this>");
        while (i2 < i3) {
            if (str.charAt(i2) == c) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final long and(int i2, long j) {
        return j & i2;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return delimiterOffset(str, c, i2, i3);
    }
}
