package o1;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class l implements n, m, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public l0 f918a;

    /* renamed from: b, reason: collision with root package name */
    public long f919b;

    /* JADX WARN: Removed duplicated region for block: B:32:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d A[EDGE_INSN: B:43:0x008d->B:37:0x008d BREAK  A[LOOP:0: B:5:0x000b->B:45:?], SYNTHETIC] */
    @Override // o1.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long A() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f919b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L94
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            o1.l0 r6 = r15.f918a
            kotlin.jvm.internal.j.b(r6)
            byte[] r7 = r6.f920a
            int r8 = r6.f921b
            int r9 = r6.c
        L16:
            if (r8 >= r9) goto L79
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L25
            r11 = 57
            if (r10 > r11) goto L25
            int r11 = r10 + (-48)
            goto L3a
        L25:
            r11 = 97
            if (r10 < r11) goto L30
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L30
            int r11 = r10 + (-87)
            goto L3a
        L30:
            r11 = 65
            if (r10 < r11) goto L65
            r11 = 70
            if (r10 > r11) goto L65
            int r11 = r10 + (-55)
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L16
        L4a:
            o1.l r0 = new o1.l
            r0.<init>()
            r0.W(r4)
            r0.U(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.P()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L65:
            if (r0 == 0) goto L69
            r1 = 1
            goto L79
        L69:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = o1.b.k(r10)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L79:
            if (r8 != r9) goto L85
            o1.l0 r7 = r6.a()
            r15.f918a = r7
            o1.m0.a(r6)
            goto L87
        L85:
            r6.f921b = r8
        L87:
            if (r1 != 0) goto L8d
            o1.l0 r6 = r15.f918a
            if (r6 != 0) goto Lb
        L8d:
            long r1 = r15.f919b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f919b = r1
            return r4
        L94:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.l.A():long");
    }

    @Override // o1.n
    public final String B(Charset charset) {
        kotlin.jvm.internal.j.e(charset, "charset");
        return O(this.f919b, charset);
    }

    @Override // o1.n
    public final InputStream C() {
        return new j(this, 0);
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final l clone() {
        l lVar = new l();
        if (this.f919b == 0) {
            return lVar;
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        l0 l0VarC = l0Var.c();
        lVar.f918a = l0VarC;
        l0VarC.f924g = l0VarC;
        l0VarC.f923f = l0VarC;
        for (l0 l0Var2 = l0Var.f923f; l0Var2 != l0Var; l0Var2 = l0Var2.f923f) {
            l0 l0Var3 = l0VarC.f924g;
            kotlin.jvm.internal.j.b(l0Var3);
            kotlin.jvm.internal.j.b(l0Var2);
            l0Var3.b(l0Var2.c());
        }
        lVar.f919b = this.f919b;
        return lVar;
    }

    public final long F() {
        long j = this.f919b;
        if (j == 0) {
            return 0L;
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        l0 l0Var2 = l0Var.f924g;
        kotlin.jvm.internal.j.b(l0Var2);
        return (l0Var2.c >= 8192 || !l0Var2.f922e) ? j : j - (r3 - l0Var2.f921b);
    }

    public final void G(long j, l out, long j2) {
        kotlin.jvm.internal.j.e(out, "out");
        long j3 = j;
        b.e(this.f919b, j3, j2);
        if (j2 == 0) {
            return;
        }
        out.f919b += j2;
        l0 l0Var = this.f918a;
        while (true) {
            kotlin.jvm.internal.j.b(l0Var);
            long j4 = l0Var.c - l0Var.f921b;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            l0Var = l0Var.f923f;
        }
        l0 l0Var2 = l0Var;
        long j5 = j2;
        while (j5 > 0) {
            kotlin.jvm.internal.j.b(l0Var2);
            l0 l0VarC = l0Var2.c();
            int i2 = l0VarC.f921b + ((int) j3);
            l0VarC.f921b = i2;
            l0VarC.c = Math.min(i2 + ((int) j5), l0VarC.c);
            l0 l0Var3 = out.f918a;
            if (l0Var3 == null) {
                l0VarC.f924g = l0VarC;
                l0VarC.f923f = l0VarC;
                out.f918a = l0VarC;
            } else {
                l0 l0Var4 = l0Var3.f924g;
                kotlin.jvm.internal.j.b(l0Var4);
                l0Var4.b(l0VarC);
            }
            j5 -= l0VarC.c - l0VarC.f921b;
            l0Var2 = l0Var2.f923f;
            j3 = 0;
        }
    }

    public final byte H(long j) {
        b.e(this.f919b, j, 1L);
        l0 l0Var = this.f918a;
        if (l0Var == null) {
            kotlin.jvm.internal.j.b(null);
            throw null;
        }
        long j2 = this.f919b;
        if (j2 - j < j) {
            while (j2 > j) {
                l0Var = l0Var.f924g;
                kotlin.jvm.internal.j.b(l0Var);
                j2 -= l0Var.c - l0Var.f921b;
            }
            return l0Var.f920a[(int) ((l0Var.f921b + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i2 = l0Var.c;
            int i3 = l0Var.f921b;
            long j4 = (i2 - i3) + j3;
            if (j4 > j) {
                return l0Var.f920a[(int) ((i3 + j) - j3)];
            }
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
            j3 = j4;
        }
    }

    public final long I(byte b2, long j, long j2) {
        l0 l0Var;
        long j3 = 0;
        if (0 > j || j > j2) {
            throw new IllegalArgumentException(("size=" + this.f919b + " fromIndex=" + j + " toIndex=" + j2).toString());
        }
        long j4 = this.f919b;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j == j2 || (l0Var = this.f918a) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                l0Var = l0Var.f924g;
                kotlin.jvm.internal.j.b(l0Var);
                j4 -= l0Var.c - l0Var.f921b;
            }
            while (j4 < j2) {
                byte[] bArr = l0Var.f920a;
                int iMin = (int) Math.min(l0Var.c, (l0Var.f921b + j2) - j4);
                for (int i2 = (int) ((l0Var.f921b + j) - j4); i2 < iMin; i2++) {
                    if (bArr[i2] == b2) {
                        return (i2 - l0Var.f921b) + j4;
                    }
                }
                j4 += l0Var.c - l0Var.f921b;
                l0Var = l0Var.f923f;
                kotlin.jvm.internal.j.b(l0Var);
                j = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = (l0Var.c - l0Var.f921b) + j3;
            if (j5 > j) {
                break;
            }
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
            j3 = j5;
        }
        while (j3 < j2) {
            byte[] bArr2 = l0Var.f920a;
            int iMin2 = (int) Math.min(l0Var.c, (l0Var.f921b + j2) - j3);
            for (int i3 = (int) ((l0Var.f921b + j) - j3); i3 < iMin2; i3++) {
                if (bArr2[i3] == b2) {
                    return (i3 - l0Var.f921b) + j3;
                }
            }
            j3 += l0Var.c - l0Var.f921b;
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
            j = j3;
        }
        return -1L;
    }

    public final long J(o targetBytes) {
        int i2;
        int i3;
        kotlin.jvm.internal.j.e(targetBytes, "targetBytes");
        l0 l0Var = this.f918a;
        if (l0Var == null) {
            return -1L;
        }
        long j = this.f919b;
        long j2 = 0;
        if (j < 0) {
            while (j > 0) {
                l0Var = l0Var.f924g;
                kotlin.jvm.internal.j.b(l0Var);
                j -= l0Var.c - l0Var.f921b;
            }
            if (targetBytes.d() == 2) {
                byte bI = targetBytes.i(0);
                byte bI2 = targetBytes.i(1);
                while (j < this.f919b) {
                    byte[] bArr = l0Var.f920a;
                    i2 = (int) ((l0Var.f921b + j2) - j);
                    int i4 = l0Var.c;
                    while (i2 < i4) {
                        byte b2 = bArr[i2];
                        if (b2 == bI || b2 == bI2) {
                            i3 = l0Var.f921b;
                        } else {
                            i2++;
                        }
                    }
                    j2 = (l0Var.c - l0Var.f921b) + j;
                    l0Var = l0Var.f923f;
                    kotlin.jvm.internal.j.b(l0Var);
                    j = j2;
                }
                return -1L;
            }
            byte[] bArrH = targetBytes.h();
            while (j < this.f919b) {
                byte[] bArr2 = l0Var.f920a;
                i2 = (int) ((l0Var.f921b + j2) - j);
                int i5 = l0Var.c;
                while (i2 < i5) {
                    byte b3 = bArr2[i2];
                    for (byte b4 : bArrH) {
                        if (b3 == b4) {
                            i3 = l0Var.f921b;
                        }
                    }
                    i2++;
                }
                j2 = (l0Var.c - l0Var.f921b) + j;
                l0Var = l0Var.f923f;
                kotlin.jvm.internal.j.b(l0Var);
                j = j2;
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j3 = (l0Var.c - l0Var.f921b) + j;
            if (j3 > 0) {
                break;
            }
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
            j = j3;
        }
        if (targetBytes.d() == 2) {
            byte bI3 = targetBytes.i(0);
            byte bI4 = targetBytes.i(1);
            while (j < this.f919b) {
                byte[] bArr3 = l0Var.f920a;
                i2 = (int) ((l0Var.f921b + j2) - j);
                int i6 = l0Var.c;
                while (i2 < i6) {
                    byte b5 = bArr3[i2];
                    if (b5 == bI3 || b5 == bI4) {
                        i3 = l0Var.f921b;
                    } else {
                        i2++;
                    }
                }
                j2 = (l0Var.c - l0Var.f921b) + j;
                l0Var = l0Var.f923f;
                kotlin.jvm.internal.j.b(l0Var);
                j = j2;
            }
            return -1L;
        }
        byte[] bArrH2 = targetBytes.h();
        while (j < this.f919b) {
            byte[] bArr4 = l0Var.f920a;
            i2 = (int) ((l0Var.f921b + j2) - j);
            int i7 = l0Var.c;
            while (i2 < i7) {
                byte b6 = bArr4[i2];
                for (byte b7 : bArrH2) {
                    if (b6 == b7) {
                        i3 = l0Var.f921b;
                    }
                }
                i2++;
            }
            j2 = (l0Var.c - l0Var.f921b) + j;
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
            j = j2;
        }
        return -1L;
        return (i2 - i3) + j;
    }

    public final boolean K(int i2, o bytes, long j) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        if (i2 >= 0 && j >= 0 && i2 + j <= this.f919b && i2 <= bytes.d()) {
            return i2 == 0 || p1.a.a(this, bytes, j, j + 1, i2) != -1;
        }
        return false;
    }

    public final i L(i unsafeCursor) {
        kotlin.jvm.internal.j.e(unsafeCursor, "unsafeCursor");
        byte[] bArr = p1.a.f990a;
        if (unsafeCursor == b.f888a) {
            unsafeCursor = new i();
        }
        if (unsafeCursor.f901a != null) {
            throw new IllegalStateException("already attached to a buffer");
        }
        unsafeCursor.f901a = this;
        unsafeCursor.f902b = true;
        return unsafeCursor;
    }

    public final byte[] M(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount: ", j).toString());
        }
        if (this.f919b < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    public final short N() throws EOFException {
        short s2 = readShort();
        return (short) (((s2 & 255) << 8) | ((65280 & s2) >>> 8));
    }

    public final String O(long j, Charset charset) throws EOFException {
        kotlin.jvm.internal.j.e(charset, "charset");
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount: ", j).toString());
        }
        if (this.f919b < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        int i2 = l0Var.f921b;
        if (i2 + j > l0Var.c) {
            return new String(M(j), charset);
        }
        int i3 = (int) j;
        String str = new String(l0Var.f920a, i2, i3, charset);
        int i4 = l0Var.f921b + i3;
        l0Var.f921b = i4;
        this.f919b -= j;
        if (i4 == l0Var.c) {
            this.f918a = l0Var.a();
            m0.a(l0Var);
        }
        return str;
    }

    public final String P() {
        return O(this.f919b, f1.a.f458a);
    }

    public final int Q() throws EOFException {
        int i2;
        int i3;
        int i4;
        if (this.f919b == 0) {
            throw new EOFException();
        }
        byte bH = H(0L);
        if ((bH & 128) == 0) {
            i2 = bH & 127;
            i3 = 1;
            i4 = 0;
        } else if ((bH & 224) == 192) {
            i2 = bH & 31;
            i3 = 2;
            i4 = 128;
        } else if ((bH & 240) == 224) {
            i2 = bH & 15;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((bH & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i2 = bH & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j = i3;
        if (this.f919b < j) {
            StringBuilder sbQ = androidx.appcompat.app.g.q("size < ", i3, ": ");
            sbQ.append(this.f919b);
            sbQ.append(" (to read code point prefixed 0x");
            sbQ.append(b.k(bH));
            sbQ.append(')');
            throw new EOFException(sbQ.toString());
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j2 = i5;
            byte bH2 = H(j2);
            if ((bH2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i2 = (i2 << 6) | (bH2 & 63);
        }
        skip(j);
        if (i2 > 1114111) {
            return 65533;
        }
        if ((55296 > i2 || i2 >= 57344) && i2 >= i4) {
            return i2;
        }
        return 65533;
    }

    public final o R(int i2) {
        if (i2 == 0) {
            return o.d;
        }
        b.e(this.f919b, 0L, i2);
        l0 l0Var = this.f918a;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            kotlin.jvm.internal.j.b(l0Var);
            int i6 = l0Var.c;
            int i7 = l0Var.f921b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            l0Var = l0Var.f923f;
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        l0 l0Var2 = this.f918a;
        int i8 = 0;
        while (i3 < i2) {
            kotlin.jvm.internal.j.b(l0Var2);
            bArr[i8] = l0Var2.f920a;
            i3 += l0Var2.c - l0Var2.f921b;
            iArr[i8] = Math.min(i3, i2);
            iArr[i8 + i5] = l0Var2.f921b;
            l0Var2.d = true;
            i8++;
            l0Var2 = l0Var2.f923f;
        }
        return new n0(bArr, iArr);
    }

    public final l0 S(int i2) {
        if (i2 < 1 || i2 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        l0 l0Var = this.f918a;
        if (l0Var == null) {
            l0 l0VarB = m0.b();
            this.f918a = l0VarB;
            l0VarB.f924g = l0VarB;
            l0VarB.f923f = l0VarB;
            return l0VarB;
        }
        l0 l0Var2 = l0Var.f924g;
        kotlin.jvm.internal.j.b(l0Var2);
        if (l0Var2.c + i2 <= 8192 && l0Var2.f922e) {
            return l0Var2;
        }
        l0 l0VarB2 = m0.b();
        l0Var2.b(l0VarB2);
        return l0VarB2;
    }

    public final void T(o byteString) {
        kotlin.jvm.internal.j.e(byteString, "byteString");
        byteString.s(byteString.d(), this);
    }

    public final void U(int i2) {
        l0 l0VarS = S(1);
        byte[] bArr = l0VarS.f920a;
        int i3 = l0VarS.c;
        l0VarS.c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.f919b++;
    }

    public final void V(long j) {
        boolean z2;
        if (j == 0) {
            U(48);
            return;
        }
        if (j < 0) {
            j = -j;
            if (j < 0) {
                b0("-9223372036854775808");
                return;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        byte[] bArr = p1.a.f990a;
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j)) * 10) >>> 5;
        int i2 = iNumberOfLeadingZeros + (j > p1.a.f991b[iNumberOfLeadingZeros] ? 1 : 0);
        if (z2) {
            i2++;
        }
        l0 l0VarS = S(i2);
        byte[] bArr2 = l0VarS.f920a;
        int i3 = l0VarS.c + i2;
        while (j != 0) {
            long j2 = 10;
            i3--;
            bArr2[i3] = p1.a.f990a[(int) (j % j2)];
            j /= j2;
        }
        if (z2) {
            bArr2[i3 - 1] = 45;
        }
        l0VarS.c += i2;
        this.f919b += i2;
    }

    public final void W(long j) {
        if (j == 0) {
            U(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i2 = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        l0 l0VarS = S(i2);
        byte[] bArr = l0VarS.f920a;
        int i3 = l0VarS.c;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = p1.a.f990a[(int) (15 & j)];
            j >>>= 4;
        }
        l0VarS.c += i2;
        this.f919b += i2;
    }

    public final void X(int i2) {
        l0 l0VarS = S(4);
        byte[] bArr = l0VarS.f920a;
        int i3 = l0VarS.c;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        bArr[i3 + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i3 + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 3] = (byte) (i2 & 255);
        l0VarS.c = i3 + 4;
        this.f919b += 4;
    }

    public final void Y(long j) {
        l0 l0VarS = S(8);
        byte[] bArr = l0VarS.f920a;
        int i2 = l0VarS.c;
        bArr[i2] = (byte) ((j >>> 56) & 255);
        bArr[i2 + 1] = (byte) ((j >>> 48) & 255);
        bArr[i2 + 2] = (byte) ((j >>> 40) & 255);
        bArr[i2 + 3] = (byte) ((j >>> 32) & 255);
        bArr[i2 + 4] = (byte) ((j >>> 24) & 255);
        bArr[i2 + 5] = (byte) ((j >>> 16) & 255);
        bArr[i2 + 6] = (byte) ((j >>> 8) & 255);
        bArr[i2 + 7] = (byte) (j & 255);
        l0VarS.c = i2 + 8;
        this.f919b += 8;
    }

    public final void Z(int i2) {
        l0 l0VarS = S(2);
        byte[] bArr = l0VarS.f920a;
        int i3 = l0VarS.c;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i3 + 1] = (byte) (i2 & 255);
        l0VarS.c = i3 + 2;
        this.f919b += 2;
    }

    public final void a() throws EOFException {
        skip(this.f919b);
    }

    public final void a0(String str, int i2, int i3, Charset charset) {
        kotlin.jvm.internal.j.e(charset, "charset");
        if (i2 < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.c(i2, "beginIndex < 0: ").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        if (i3 > str.length()) {
            StringBuilder sbQ = androidx.appcompat.app.g.q("endIndex > string.length: ", i3, " > ");
            sbQ.append(str.length());
            throw new IllegalArgumentException(sbQ.toString().toString());
        }
        if (charset.equals(f1.a.f458a)) {
            c0(str, i2, i3);
            return;
        }
        String strSubstring = str.substring(i2, i3);
        kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.j.d(bytes, "getBytes(...)");
        m80write(bytes, 0, bytes.length);
    }

    public final void b0(String string) {
        kotlin.jvm.internal.j.e(string, "string");
        c0(string, 0, string.length());
    }

    @Override // o1.n
    public final int c(g0 options) throws EOFException {
        kotlin.jvm.internal.j.e(options, "options");
        int iD = p1.a.d(this, options, false);
        if (iD == -1) {
            return -1;
        }
        skip(options.f897a[iD].d());
        return iD;
    }

    public final void c0(String string, int i2, int i3) {
        char cCharAt;
        kotlin.jvm.internal.j.e(string, "string");
        if (i2 < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.c(i2, "beginIndex < 0: ").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        if (i3 > string.length()) {
            StringBuilder sbQ = androidx.appcompat.app.g.q("endIndex > string.length: ", i3, " > ");
            sbQ.append(string.length());
            throw new IllegalArgumentException(sbQ.toString().toString());
        }
        while (i2 < i3) {
            char cCharAt2 = string.charAt(i2);
            if (cCharAt2 < 128) {
                l0 l0VarS = S(1);
                byte[] bArr = l0VarS.f920a;
                int i4 = l0VarS.c - i2;
                int iMin = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                bArr[i2 + i4] = (byte) cCharAt2;
                while (true) {
                    i2 = i5;
                    if (i2 >= iMin || (cCharAt = string.charAt(i2)) >= 128) {
                        break;
                    }
                    i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) cCharAt;
                }
                int i6 = l0VarS.c;
                int i7 = (i4 + i2) - i6;
                l0VarS.c = i6 + i7;
                this.f919b += i7;
            } else {
                if (cCharAt2 < 2048) {
                    l0 l0VarS2 = S(2);
                    byte[] bArr2 = l0VarS2.f920a;
                    int i8 = l0VarS2.c;
                    bArr2[i8] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    l0VarS2.c = i8 + 2;
                    this.f919b += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    l0 l0VarS3 = S(3);
                    byte[] bArr3 = l0VarS3.f920a;
                    int i9 = l0VarS3.c;
                    bArr3[i9] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i9 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    l0VarS3.c = i9 + 3;
                    this.f919b += 3;
                } else {
                    int i10 = i2 + 1;
                    char cCharAt3 = i10 < i3 ? string.charAt(i10) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        U(63);
                        i2 = i10;
                    } else {
                        int i11 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        l0 l0VarS4 = S(4);
                        byte[] bArr4 = l0VarS4.f920a;
                        int i12 = l0VarS4.c;
                        bArr4[i12] = (byte) ((i11 >> 18) | 240);
                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                        l0VarS4.c = i12 + 4;
                        this.f919b += 4;
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m d(String str, int i2, int i3) {
        c0(str, i2, i3);
        return this;
    }

    public final void d0(int i2) {
        if (i2 < 128) {
            U(i2);
            return;
        }
        if (i2 < 2048) {
            l0 l0VarS = S(2);
            byte[] bArr = l0VarS.f920a;
            int i3 = l0VarS.c;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            l0VarS.c = i3 + 2;
            this.f919b += 2;
            return;
        }
        if (55296 <= i2 && i2 < 57344) {
            U(63);
            return;
        }
        if (i2 < 65536) {
            l0 l0VarS2 = S(3);
            byte[] bArr2 = l0VarS2.f920a;
            int i4 = l0VarS2.c;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            l0VarS2.c = i4 + 3;
            this.f919b += 3;
            return;
        }
        if (i2 > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x".concat(b.l(i2)));
        }
        l0 l0VarS3 = S(4);
        byte[] bArr3 = l0VarS3.f920a;
        int i5 = l0VarS3.c;
        bArr3[i5] = (byte) ((i2 >> 18) | 240);
        bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
        bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
        bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
        l0VarS3.c = i5 + 4;
        this.f919b += 4;
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m e(long j) {
        W(j);
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        long j = this.f919b;
        l lVar = (l) obj;
        if (j != lVar.f919b) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        l0 l0Var2 = lVar.f918a;
        kotlin.jvm.internal.j.b(l0Var2);
        int i2 = l0Var.f921b;
        int i3 = l0Var2.f921b;
        long j2 = 0;
        while (j2 < this.f919b) {
            long jMin = Math.min(l0Var.c - i2, l0Var2.c - i3);
            long j3 = 0;
            while (j3 < jMin) {
                int i4 = i2 + 1;
                int i5 = i3 + 1;
                if (l0Var.f920a[i2] != l0Var2.f920a[i3]) {
                    return false;
                }
                j3++;
                i2 = i4;
                i3 = i5;
            }
            if (i2 == l0Var.c) {
                l0Var = l0Var.f923f;
                kotlin.jvm.internal.j.b(l0Var);
                i2 = l0Var.f921b;
            }
            if (i3 == l0Var2.c) {
                l0Var2 = l0Var2.f923f;
                kotlin.jvm.internal.j.b(l0Var2);
                i3 = l0Var2.f921b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // o1.m
    public final long f(p0 source) {
        kotlin.jvm.internal.j.e(source, "source");
        long j = 0;
        while (true) {
            long j2 = source.read(this, 8192L);
            if (j2 == -1) {
                return j;
            }
            j += j2;
        }
    }

    @Override // o1.n
    public final o g() {
        return h(this.f919b);
    }

    @Override // o1.n
    public final o h(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount: ", j).toString());
        }
        if (this.f919b < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new o(M(j));
        }
        o oVarR = R((int) j);
        skip(j);
        return oVarR;
    }

    public final int hashCode() {
        l0 l0Var = this.f918a;
        if (l0Var == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = l0Var.c;
            for (int i4 = l0Var.f921b; i4 < i3; i4++) {
                i2 = (i2 * 31) + l0Var.f920a[i4];
            }
            l0Var = l0Var.f923f;
            kotlin.jvm.internal.j.b(l0Var);
        } while (l0Var != this.f918a);
        return i2;
    }

    @Override // o1.n
    public final long i(l lVar) {
        long j = this.f919b;
        if (j > 0) {
            lVar.write(this, j);
        }
        return j;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    @Override // o1.n
    public final boolean k(long j) {
        return this.f919b >= j;
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m l(int i2) {
        d0(i2);
        return this;
    }

    @Override // o1.n
    public final boolean m(long j, o bytes) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        return K(bytes.d(), bytes, j);
    }

    @Override // o1.n
    public final String n() {
        return t(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // o1.n
    public final byte[] o() {
        return M(this.f919b);
    }

    @Override // o1.n
    public final void p(l sink, long j) throws EOFException {
        kotlin.jvm.internal.j.e(sink, "sink");
        long j2 = this.f919b;
        if (j2 >= j) {
            sink.write(this, j);
        } else {
            sink.write(this, j2);
            throw new EOFException();
        }
    }

    @Override // o1.n
    public final k0 peek() {
        return b.c(new i0(this));
    }

    @Override // o1.n
    public final boolean q() {
        return this.f919b == 0;
    }

    @Override // o1.p0
    public final long read(l sink, long j) {
        kotlin.jvm.internal.j.e(sink, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("byteCount < 0: ", j).toString());
        }
        long j2 = this.f919b;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        sink.write(this, j);
        return j;
    }

    @Override // o1.n
    public final byte readByte() throws EOFException {
        if (this.f919b == 0) {
            throw new EOFException();
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        int i2 = l0Var.f921b;
        int i3 = l0Var.c;
        int i4 = i2 + 1;
        byte b2 = l0Var.f920a[i2];
        this.f919b--;
        if (i4 != i3) {
            l0Var.f921b = i4;
            return b2;
        }
        this.f918a = l0Var.a();
        m0.a(l0Var);
        return b2;
    }

    @Override // o1.n
    public final void readFully(byte[] sink) throws EOFException {
        kotlin.jvm.internal.j.e(sink, "sink");
        int i2 = 0;
        while (i2 < sink.length) {
            int i3 = read(sink, i2, sink.length - i2);
            if (i3 == -1) {
                throw new EOFException();
            }
            i2 += i3;
        }
    }

    @Override // o1.n
    public final int readInt() throws EOFException {
        if (this.f919b < 4) {
            throw new EOFException();
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        int i2 = l0Var.f921b;
        int i3 = l0Var.c;
        if (i3 - i2 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = l0Var.f920a;
        int i4 = i2 + 3;
        int i5 = ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 2] & 255) << 8);
        int i6 = i2 + 4;
        int i7 = (bArr[i4] & 255) | i5;
        this.f919b -= 4;
        if (i6 != i3) {
            l0Var.f921b = i6;
            return i7;
        }
        this.f918a = l0Var.a();
        m0.a(l0Var);
        return i7;
    }

    @Override // o1.n
    public final long readLong() throws EOFException {
        if (this.f919b < 8) {
            throw new EOFException();
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        int i2 = l0Var.f921b;
        int i3 = l0Var.c;
        if (i3 - i2 < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = l0Var.f920a;
        int i4 = i2 + 7;
        long j = ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2] & 255) << 56) | ((bArr[i2 + 1] & 255) << 48) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 4] & 255) << 24) | ((bArr[i2 + 5] & 255) << 16) | ((bArr[i2 + 6] & 255) << 8);
        int i5 = i2 + 8;
        long j2 = j | (bArr[i4] & 255);
        this.f919b -= 8;
        if (i5 != i3) {
            l0Var.f921b = i5;
            return j2;
        }
        this.f918a = l0Var.a();
        m0.a(l0Var);
        return j2;
    }

    @Override // o1.n
    public final short readShort() throws EOFException {
        if (this.f919b < 2) {
            throw new EOFException();
        }
        l0 l0Var = this.f918a;
        kotlin.jvm.internal.j.b(l0Var);
        int i2 = l0Var.f921b;
        int i3 = l0Var.c;
        if (i3 - i2 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = l0Var.f920a;
        int i4 = i2 + 1;
        int i5 = (bArr[i2] & 255) << 8;
        int i6 = i2 + 2;
        int i7 = (bArr[i4] & 255) | i5;
        this.f919b -= 2;
        if (i6 == i3) {
            this.f918a = l0Var.a();
            m0.a(l0Var);
        } else {
            l0Var.f921b = i6;
        }
        return (short) i7;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r1 = new o1.l();
        r1.V(r8);
        r1.U(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        if (r2 != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        r1.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        throw new java.lang.NumberFormatException("Number too large: ".concat(r1.P()));
     */
    @Override // o1.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long s() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.l.s():long");
    }

    @Override // o1.n
    public final void skip(long j) throws EOFException {
        while (j > 0) {
            l0 l0Var = this.f918a;
            if (l0Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, l0Var.c - l0Var.f921b);
            long j2 = iMin;
            this.f919b -= j2;
            j -= j2;
            int i2 = l0Var.f921b + iMin;
            l0Var.f921b = i2;
            if (i2 == l0Var.c) {
                this.f918a = l0Var.a();
                m0.a(l0Var);
            }
        }
    }

    @Override // o1.n
    public final String t(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException(androidx.appcompat.app.g.f("limit < 0: ", j).toString());
        }
        long j2 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j2 = j + 1;
        }
        long j3 = j2;
        long jI = I((byte) 10, 0L, j3);
        if (jI != -1) {
            return p1.a.c(this, jI);
        }
        if (j3 < this.f919b && H(j3 - 1) == 13 && H(j3) == 10) {
            return p1.a.c(this, j3);
        }
        l lVar = new l();
        G(0L, lVar, Math.min(32, this.f919b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f919b, j) + " content=" + lVar.h(lVar.f919b).e() + (char) 8230);
    }

    @Override // o1.p0
    public final s0 timeout() {
        return s0.NONE;
    }

    public final String toString() {
        long j = this.f919b;
        if (j <= 2147483647L) {
            return R((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f919b).toString());
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m u(o oVar) {
        T(oVar);
        return this;
    }

    @Override // o1.n
    public final long v(long j, o bytes) {
        kotlin.jvm.internal.j.e(bytes, "bytes");
        byte[] bArr = p1.a.f990a;
        return p1.a.a(this, bytes, 0L, j, bytes.d());
    }

    @Override // o1.n
    public final void w(long j) throws EOFException {
        if (this.f919b < j) {
            throw new EOFException();
        }
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m write(byte[] bArr) {
        m79write(bArr);
        return this;
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m writeByte(int i2) {
        U(i2);
        return this;
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m writeInt(int i2) {
        X(i2);
        return this;
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m writeShort(int i2) {
        Z(i2);
        return this;
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m x(String str) {
        b0(str);
        return this;
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m y(long j) {
        V(j);
        return this;
    }

    @Override // o1.m
    public final OutputStream z() {
        return new k(this, 0);
    }

    @Override // o1.m
    public final /* bridge */ /* synthetic */ m write(byte[] bArr, int i2, int i3) {
        m80write(bArr, i2, i3);
        return this;
    }

    @Override // o1.o0
    public final void write(l source, long j) {
        l0 l0VarB;
        kotlin.jvm.internal.j.e(source, "source");
        if (source != this) {
            b.e(source.f919b, 0L, j);
            while (j > 0) {
                l0 l0Var = source.f918a;
                kotlin.jvm.internal.j.b(l0Var);
                int i2 = l0Var.c;
                kotlin.jvm.internal.j.b(source.f918a);
                int i3 = 0;
                if (j < i2 - r1.f921b) {
                    l0 l0Var2 = this.f918a;
                    l0 l0Var3 = l0Var2 != null ? l0Var2.f924g : null;
                    if (l0Var3 != null && l0Var3.f922e) {
                        if ((l0Var3.c + j) - (l0Var3.d ? 0 : l0Var3.f921b) <= 8192) {
                            l0 l0Var4 = source.f918a;
                            kotlin.jvm.internal.j.b(l0Var4);
                            l0Var4.d(l0Var3, (int) j);
                            source.f919b -= j;
                            this.f919b += j;
                            return;
                        }
                    }
                    l0 l0Var5 = source.f918a;
                    kotlin.jvm.internal.j.b(l0Var5);
                    int i4 = (int) j;
                    if (i4 > 0 && i4 <= l0Var5.c - l0Var5.f921b) {
                        if (i4 >= 1024) {
                            l0VarB = l0Var5.c();
                        } else {
                            l0VarB = m0.b();
                            byte[] bArr = l0Var5.f920a;
                            byte[] bArr2 = l0VarB.f920a;
                            int i5 = l0Var5.f921b;
                            m0.i.h0(0, i5, i5 + i4, bArr, bArr2);
                        }
                        l0VarB.c = l0VarB.f921b + i4;
                        l0Var5.f921b += i4;
                        l0 l0Var6 = l0Var5.f924g;
                        kotlin.jvm.internal.j.b(l0Var6);
                        l0Var6.b(l0VarB);
                        source.f918a = l0VarB;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range");
                    }
                }
                l0 l0Var7 = source.f918a;
                kotlin.jvm.internal.j.b(l0Var7);
                long j2 = l0Var7.c - l0Var7.f921b;
                source.f918a = l0Var7.a();
                l0 l0Var8 = this.f918a;
                if (l0Var8 == null) {
                    this.f918a = l0Var7;
                    l0Var7.f924g = l0Var7;
                    l0Var7.f923f = l0Var7;
                } else {
                    l0 l0Var9 = l0Var8.f924g;
                    kotlin.jvm.internal.j.b(l0Var9);
                    l0Var9.b(l0Var7);
                    l0 l0Var10 = l0Var7.f924g;
                    if (l0Var10 != l0Var7) {
                        kotlin.jvm.internal.j.b(l0Var10);
                        if (l0Var10.f922e) {
                            int i6 = l0Var7.c - l0Var7.f921b;
                            l0 l0Var11 = l0Var7.f924g;
                            kotlin.jvm.internal.j.b(l0Var11);
                            int i7 = 8192 - l0Var11.c;
                            l0 l0Var12 = l0Var7.f924g;
                            kotlin.jvm.internal.j.b(l0Var12);
                            if (!l0Var12.d) {
                                l0 l0Var13 = l0Var7.f924g;
                                kotlin.jvm.internal.j.b(l0Var13);
                                i3 = l0Var13.f921b;
                            }
                            if (i6 <= i7 + i3) {
                                l0 l0Var14 = l0Var7.f924g;
                                kotlin.jvm.internal.j.b(l0Var14);
                                l0Var7.d(l0Var14, i6);
                                l0Var7.a();
                                m0.a(l0Var7);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact");
                    }
                }
                source.f919b -= j2;
                this.f919b += j2;
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        kotlin.jvm.internal.j.e(sink, "sink");
        l0 l0Var = this.f918a;
        if (l0Var == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), l0Var.c - l0Var.f921b);
        sink.put(l0Var.f920a, l0Var.f921b, iMin);
        int i2 = l0Var.f921b + iMin;
        l0Var.f921b = i2;
        this.f919b -= iMin;
        if (i2 == l0Var.c) {
            this.f918a = l0Var.a();
            m0.a(l0Var);
        }
        return iMin;
    }

    public final int read(byte[] sink, int i2, int i3) {
        kotlin.jvm.internal.j.e(sink, "sink");
        b.e(sink.length, i2, i3);
        l0 l0Var = this.f918a;
        if (l0Var == null) {
            return -1;
        }
        int iMin = Math.min(i3, l0Var.c - l0Var.f921b);
        byte[] bArr = l0Var.f920a;
        int i4 = l0Var.f921b;
        m0.i.h0(i2, i4, i4 + iMin, bArr, sink);
        int i5 = l0Var.f921b + iMin;
        l0Var.f921b = i5;
        this.f919b -= iMin;
        if (i5 == l0Var.c) {
            this.f918a = l0Var.a();
            m0.a(l0Var);
        }
        return iMin;
    }

    @Override // o1.n
    public final l b() {
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, o1.o0
    public final void close() {
    }

    @Override // o1.m, o1.o0, java.io.Flushable
    public final void flush() {
    }

    @Override // o1.m
    public final m j() {
        return this;
    }

    @Override // o1.m
    public final m r() {
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        kotlin.jvm.internal.j.e(source, "source");
        int iRemaining = source.remaining();
        int i2 = iRemaining;
        while (i2 > 0) {
            l0 l0VarS = S(1);
            int iMin = Math.min(i2, 8192 - l0VarS.c);
            source.get(l0VarS.f920a, l0VarS.c, iMin);
            i2 -= iMin;
            l0VarS.c += iMin;
        }
        this.f919b += iRemaining;
        return iRemaining;
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m79write(byte[] source) {
        kotlin.jvm.internal.j.e(source, "source");
        m80write(source, 0, source.length);
    }

    /* renamed from: write, reason: collision with other method in class */
    public final void m80write(byte[] source, int i2, int i3) {
        kotlin.jvm.internal.j.e(source, "source");
        long j = i3;
        b.e(source.length, i2, j);
        int i4 = i3 + i2;
        while (i2 < i4) {
            l0 l0VarS = S(1);
            int iMin = Math.min(i4 - i2, 8192 - l0VarS.c);
            int i5 = i2 + iMin;
            m0.i.h0(l0VarS.c, i2, i5, source, l0VarS.f920a);
            l0VarS.c += iMin;
            i2 = i5;
        }
        this.f919b += j;
    }
}
