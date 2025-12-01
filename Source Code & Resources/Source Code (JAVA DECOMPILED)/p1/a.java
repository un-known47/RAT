package p1;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import o1.l0;
import o1.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f990a;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f991b;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(f1.a.f458a);
        kotlin.jvm.internal.j.d(bytes, "getBytes(...)");
        f990a = bytes;
        f991b = new long[]{-1, 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, 9999999999L, 99999999999L, 999999999999L, 9999999999999L, 99999999999999L, 999999999999999L, 9999999999999999L, 99999999999999999L, 999999999999999999L, LocationRequestCompat.PASSIVE_INTERVAL};
    }

    public static final long a(o1.l lVar, o bytes, long j, long j2, int i2) {
        l0 l0Var;
        byte[] bArr;
        long j3 = j;
        long j4 = j2;
        kotlin.jvm.internal.j.e(bytes, "bytes");
        long j5 = i2;
        o1.b.e(bytes.d(), 0, j5);
        if (i2 <= 0) {
            throw new IllegalArgumentException("byteCount == 0");
        }
        long j6 = 0;
        if (j3 < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("fromIndex < 0: ", j3).toString());
        }
        if (j3 > j4) {
            throw new IllegalArgumentException(("fromIndex > toIndex: " + j3 + " > " + j4).toString());
        }
        long j7 = lVar.f919b;
        if (j4 > j7) {
            j4 = j7;
        }
        if (j3 == j4 || (l0Var = lVar.f918a) == null) {
            return -1L;
        }
        if (j7 - j3 >= j3) {
            while (true) {
                long j8 = (l0Var.c - l0Var.f921b) + j6;
                if (j8 > j3) {
                    break;
                }
                l0Var = l0Var.f923f;
                kotlin.jvm.internal.j.b(l0Var);
                j6 = j8;
            }
            byte[] bArrH = bytes.h();
            byte b2 = bArrH[0];
            long jMin = Math.min(j4, (lVar.f919b - j5) + 1);
            while (j6 < jMin) {
                byte[] bArr2 = l0Var.f920a;
                long j9 = j3;
                int iMin = (int) Math.min(l0Var.c, (l0Var.f921b + jMin) - j6);
                for (int i3 = (int) ((l0Var.f921b + j9) - j6); i3 < iMin; i3++) {
                    if (bArr2[i3] == b2 && b(l0Var, i3 + 1, bArrH, 1, i2)) {
                        return (i3 - l0Var.f921b) + j6;
                    }
                }
                j6 += l0Var.c - l0Var.f921b;
                l0Var = l0Var.f923f;
                kotlin.jvm.internal.j.b(l0Var);
                j3 = j6;
            }
            return -1L;
        }
        while (j7 > j3) {
            l0Var = l0Var.f924g;
            kotlin.jvm.internal.j.b(l0Var);
            j7 -= l0Var.c - l0Var.f921b;
        }
        byte[] bArrH2 = bytes.h();
        byte b3 = bArrH2[0];
        byte[] bArr3 = bArrH2;
        long jMin2 = Math.min(j4, (lVar.f919b - j5) + 1);
        while (j7 < jMin2) {
            byte[] bArr4 = l0Var.f920a;
            int iMin2 = (int) Math.min(l0Var.c, (l0Var.f921b + jMin2) - j7);
            int i4 = (int) ((l0Var.f921b + j3) - j7);
            while (i4 < iMin2) {
                if (bArr4[i4] == b3) {
                    bArr = bArr3;
                    if (b(l0Var, i4 + 1, bArr, 1, i2)) {
                        return (i4 - l0Var.f921b) + j7;
                    }
                } else {
                    bArr = bArr3;
                }
                i4++;
                bArr3 = bArr;
            }
            j7 += l0Var.c - l0Var.f921b;
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
            j3 = j7;
        }
        return -1L;
    }

    public static final boolean b(l0 l0Var, int i2, byte[] bArr, int i3, int i4) {
        int i5 = l0Var.c;
        byte[] bArr2 = l0Var.f920a;
        while (i3 < i4) {
            if (i2 == i5) {
                l0Var = l0Var.f923f;
                kotlin.jvm.internal.j.b(l0Var);
                byte[] bArr3 = l0Var.f920a;
                bArr2 = bArr3;
                i2 = l0Var.f921b;
                i5 = l0Var.c;
            }
            if (bArr2[i2] != bArr[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public static final String c(o1.l lVar, long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (lVar.H(j2) == 13) {
                String strO = lVar.O(j2, f1.a.f458a);
                lVar.skip(2L);
                return strO;
            }
        }
        String strO2 = lVar.O(j, f1.a.f458a);
        lVar.skip(1L);
        return strO2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007e, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int d(o1.l r16, o1.g0 r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 173
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.a.d(o1.l, o1.g0, boolean):int");
    }
}
