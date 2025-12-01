package okhttp3.internal;

import c1.d;
import f1.i;
import f1.q;
import java.io.EOFException;
import kotlin.jvm.internal.j;
import o1.l;
import okhttp3.internal.idn.IdnaMappingTableInstanceKt;
import okhttp3.internal.idn.Punycode;
import p.a;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class _HostnamesCommonKt {
    private static final i VERIFY_AS_IP_ADDRESS = new i("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String str) {
        j.e(str, "<this>");
        i iVar = VERIFY_AS_IP_ADDRESS;
        iVar.getClass();
        return iVar.f476a.matcher(str).matches();
    }

    public static final byte[] canonicalizeInetAddress(byte[] address) {
        j.e(address, "address");
        if (!isMappedIpv4Address(address)) {
            return address;
        }
        d indices = a.V(12, 16);
        j.e(indices, "indices");
        return indices.isEmpty() ? new byte[0] : m0.i.o0(address, indices.f205a, indices.f206b + 1);
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String str) {
        j.e(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (j.f(cCharAt, 31) <= 0 || j.f(cCharAt, 127) >= 0 || f1.j.u0(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean containsInvalidLabelLengths(String str) {
        j.e(str, "<this>");
        int length = str.length();
        if (1 <= length && length < 254) {
            int i2 = 0;
            while (true) {
                int iU0 = f1.j.u0(str, '.', i2, 4);
                int length2 = iU0 == -1 ? str.length() - i2 : iU0 - i2;
                if (1 > length2 || length2 >= 64) {
                    break;
                }
                if (iU0 == -1 || iU0 == str.length() - 1) {
                    break;
                }
                i2 = iU0 + 1;
            }
            return false;
        }
        return true;
    }

    public static final boolean decodeIpv4Suffix(String input, int i2, int i3, byte[] address, int i4) {
        j.e(input, "input");
        j.e(address, "address");
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == address.length) {
                return false;
            }
            if (i5 != i4) {
                if (input.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char cCharAt = input.charAt(i6);
                if (j.f(cCharAt, 48) < 0 || j.f(cCharAt, 57) > 0) {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            address[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:
    
        if (r4 == 16) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:
    
        if (r5 != (-1)) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0081, code lost:
    
        m0.i.h0(16 - (r4 - r5), r5, r4, r1, r1);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final byte[] decodeIpv6(java.lang.String r10, int r11, int r12) {
        /*
            java.lang.String r0 = "input"
            kotlin.jvm.internal.j.e(r10, r0)
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        Le:
            if (r11 >= r12) goto L7b
            if (r4 != r0) goto L14
            goto L7f
        L14:
            int r7 = r11 + 2
            if (r7 > r12) goto L2c
            java.lang.String r8 = "::"
            boolean r8 = f1.q.n0(r10, r8, r11, r2)
            if (r8 == 0) goto L2c
            if (r5 == r3) goto L24
            goto L7f
        L24:
            int r4 = r4 + 2
            r5 = r4
            if (r7 != r12) goto L2a
            goto L7b
        L2a:
            r6 = r7
            goto L4e
        L2c:
            if (r4 == 0) goto L38
            java.lang.String r7 = ":"
            boolean r7 = f1.q.n0(r10, r7, r11, r2)
            if (r7 == 0) goto L3a
            int r11 = r11 + 1
        L38:
            r6 = r11
            goto L4e
        L3a:
            java.lang.String r7 = "."
            boolean r11 = f1.q.n0(r10, r7, r11, r2)
            if (r11 == 0) goto L7f
            int r11 = r4 + (-2)
            boolean r10 = decodeIpv4Suffix(r10, r6, r12, r1, r11)
            if (r10 != 0) goto L4b
            goto L7f
        L4b:
            int r4 = r4 + 2
            goto L7b
        L4e:
            r11 = r6
            r7 = 0
        L50:
            if (r11 >= r12) goto L62
            char r8 = r10.charAt(r11)
            int r8 = okhttp3.internal._UtilCommonKt.parseHexDigit(r8)
            if (r8 == r3) goto L62
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L50
        L62:
            int r8 = r11 - r6
            if (r8 == 0) goto L7f
            r9 = 4
            if (r8 <= r9) goto L6a
            goto L7f
        L6a:
            int r8 = r4 + 1
            int r9 = r7 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r4 + 2
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r1[r8] = r7
            goto Le
        L7b:
            if (r4 == r0) goto L8d
            if (r5 != r3) goto L81
        L7f:
            r10 = 0
            return r10
        L81:
            int r10 = r4 - r5
            int r10 = 16 - r10
            m0.i.h0(r10, r5, r4, r1, r1)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._HostnamesCommonKt.decodeIpv6(java.lang.String, int, int):byte[]");
    }

    public static final String idnToAscii(String host) throws EOFException {
        j.e(host, "host");
        l lVar = new l();
        lVar.b0(host);
        l lVar2 = new l();
        while (!lVar.q()) {
            if (!IdnaMappingTableInstanceKt.getIDNA_MAPPING_TABLE().map(lVar.Q(), lVar2)) {
                return null;
            }
        }
        lVar.b0(_NormalizeJvmKt.normalizeNfc(lVar2.P()));
        Punycode punycode = Punycode.INSTANCE;
        String strDecode = punycode.decode(lVar.P());
        if (strDecode != null && strDecode.equals(_NormalizeJvmKt.normalizeNfc(strDecode))) {
            return punycode.encode(strDecode);
        }
        return null;
    }

    public static final String inet4AddressToAscii(byte[] address) {
        j.e(address, "address");
        if (address.length != 4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        l lVar = new l();
        lVar.V(_UtilCommonKt.and(address[0], 255));
        lVar.U(46);
        lVar.V(_UtilCommonKt.and(address[1], 255));
        lVar.U(46);
        lVar.V(_UtilCommonKt.and(address[2], 255));
        lVar.U(46);
        lVar.V(_UtilCommonKt.and(address[3], 255));
        return lVar.P();
    }

    public static final String inet6AddressToAscii(byte[] address) {
        j.e(address, "address");
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < address.length) {
            int i6 = i4;
            while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        l lVar = new l();
        while (i3 < address.length) {
            if (i3 == i2) {
                lVar.U(58);
                i3 += i5;
                if (i3 == 16) {
                    lVar.U(58);
                }
            } else {
                if (i3 > 0) {
                    lVar.U(58);
                }
                lVar.W((_UtilCommonKt.and(address[i3], 255) << 8) | _UtilCommonKt.and(address[i3 + 1], 255));
                i3 += 2;
            }
        }
        return lVar.P();
    }

    private static final boolean isMappedIpv4Address(byte[] bArr) {
        if (bArr.length != 16) {
            return false;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            if (bArr[i2] != 0) {
                return false;
            }
        }
        return bArr[10] == -1 && bArr[11] == -1;
    }

    public static final String toCanonicalHost(String str) {
        j.e(str, "<this>");
        if (f1.j.r0(str, ":")) {
            byte[] bArrDecodeIpv6 = (q.o0(str, "[", false) && q.h0(str, "]", false)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
            if (bArrDecodeIpv6 != null) {
                byte[] bArrCanonicalizeInetAddress = canonicalizeInetAddress(bArrDecodeIpv6);
                if (bArrCanonicalizeInetAddress.length == 16) {
                    return inet6AddressToAscii(bArrCanonicalizeInetAddress);
                }
                if (bArrCanonicalizeInetAddress.length == 4) {
                    return inet4AddressToAscii(bArrCanonicalizeInetAddress);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        } else {
            String strIdnToAscii = idnToAscii(str);
            if (strIdnToAscii != null && strIdnToAscii.length() != 0 && !containsInvalidHostnameAsciiCodes(strIdnToAscii) && !containsInvalidLabelLengths(strIdnToAscii)) {
                return strIdnToAscii;
            }
        }
        return null;
    }
}
