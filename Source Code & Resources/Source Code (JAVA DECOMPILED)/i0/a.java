package i0;

import g.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final Reader f658a;

    /* renamed from: h, reason: collision with root package name */
    public long f663h;

    /* renamed from: i, reason: collision with root package name */
    public int f664i;
    public String j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f665k;

    /* renamed from: m, reason: collision with root package name */
    public String[] f667m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f668n;
    public int o = 2;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f659b = new char[1024];
    public int c = 0;
    public int d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f660e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f661f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f662g = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f666l = 1;

    static {
        g.c = new g(4);
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f665k = iArr;
        iArr[0] = 6;
        this.f667m = new String[32];
        this.f668n = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f658a = reader;
    }

    public final void D() throws IOException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF != 1) {
            throw f0("BEGIN_OBJECT");
        }
        Y(3);
        this.f662g = 0;
    }

    public final void E() throws c {
        if (this.o == 1) {
            return;
        }
        e0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x0217, code lost:
    
        if (L(r12) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0187 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x026f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int F() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 791
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.F():int");
    }

    public final void G() throws IOException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF != 4) {
            throw f0("END_ARRAY");
        }
        int i2 = this.f666l;
        this.f666l = i2 - 1;
        int[] iArr = this.f668n;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f662g = 0;
    }

    public final void H() throws IOException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF != 2) {
            throw f0("END_OBJECT");
        }
        int i2 = this.f666l;
        int i3 = i2 - 1;
        this.f666l = i3;
        this.f667m[i3] = null;
        int[] iArr = this.f668n;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f662g = 0;
    }

    public final boolean I(int i2) throws IOException {
        int i3;
        int i4;
        int i5 = this.f661f;
        int i6 = this.c;
        this.f661f = i5 - i6;
        int i7 = this.d;
        char[] cArr = this.f659b;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.d = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.d = 0;
        }
        this.c = 0;
        do {
            int i9 = this.d;
            int i10 = this.f658a.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.d + i10;
            this.d = i3;
            if (this.f660e == 0 && (i4 = this.f661f) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.c++;
                this.f661f = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final String J(boolean z2) {
        StringBuilder sb = new StringBuilder("$");
        int i2 = 0;
        while (true) {
            int i3 = this.f666l;
            if (i2 >= i3) {
                return sb.toString();
            }
            int i4 = this.f665k[i2];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.f668n[i2];
                    if (z2 && i5 > 0 && i2 == i3 - 1) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.f667m[i2];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(androidx.appcompat.app.g.c(i4, "Unknown scope value: "));
            }
            i2++;
        }
    }

    public final boolean K() throws IOException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        return (iF == 2 || iF == 4 || iF == 17) ? false : true;
    }

    public final boolean L(char c) throws c {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        E();
        return false;
    }

    public final String M() {
        return " at line " + (this.f660e + 1) + " column " + ((this.c - this.f661f) + 1) + " path " + J(false);
    }

    public final boolean N() throws IOException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF == 5) {
            this.f662g = 0;
            int[] iArr = this.f668n;
            int i2 = this.f666l - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iF != 6) {
            throw f0("a boolean");
        }
        this.f662g = 0;
        int[] iArr2 = this.f668n;
        int i3 = this.f666l - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    public final double O() throws IOException, NumberFormatException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF == 15) {
            this.f662g = 0;
            int[] iArr = this.f668n;
            int i2 = this.f666l - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f663h;
        }
        if (iF == 16) {
            this.j = new String(this.f659b, this.c, this.f664i);
            this.c += this.f664i;
        } else if (iF == 8 || iF == 9) {
            this.j = U(iF == 8 ? '\'' : '\"');
        } else if (iF == 10) {
            this.j = W();
        } else if (iF != 11) {
            throw f0("a double");
        }
        this.f662g = 11;
        double d = Double.parseDouble(this.j);
        if (this.o != 1 && (Double.isNaN(d) || Double.isInfinite(d))) {
            e0("JSON forbids NaN and infinities: " + d);
            throw null;
        }
        this.j = null;
        this.f662g = 0;
        int[] iArr2 = this.f668n;
        int i3 = this.f666l - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d;
    }

    public final int P() throws IOException, NumberFormatException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF == 15) {
            long j = this.f663h;
            int i2 = (int) j;
            if (j != i2) {
                throw new NumberFormatException("Expected an int but was " + this.f663h + M());
            }
            this.f662g = 0;
            int[] iArr = this.f668n;
            int i3 = this.f666l - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (iF == 16) {
            this.j = new String(this.f659b, this.c, this.f664i);
            this.c += this.f664i;
        } else {
            if (iF != 8 && iF != 9 && iF != 10) {
                throw f0("an int");
            }
            if (iF == 10) {
                this.j = W();
            } else {
                this.j = U(iF == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.j);
                this.f662g = 0;
                int[] iArr2 = this.f668n;
                int i5 = this.f666l - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f662g = 11;
        double d = Double.parseDouble(this.j);
        int i6 = (int) d;
        if (i6 != d) {
            throw new NumberFormatException("Expected an int but was " + this.j + M());
        }
        this.j = null;
        this.f662g = 0;
        int[] iArr3 = this.f668n;
        int i7 = this.f666l - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public final long Q() throws IOException, NumberFormatException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF == 15) {
            this.f662g = 0;
            int[] iArr = this.f668n;
            int i2 = this.f666l - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f663h;
        }
        if (iF == 16) {
            this.j = new String(this.f659b, this.c, this.f664i);
            this.c += this.f664i;
        } else {
            if (iF != 8 && iF != 9 && iF != 10) {
                throw f0("a long");
            }
            if (iF == 10) {
                this.j = W();
            } else {
                this.j = U(iF == 8 ? '\'' : '\"');
            }
            try {
                long j = Long.parseLong(this.j);
                this.f662g = 0;
                int[] iArr2 = this.f668n;
                int i3 = this.f666l - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.f662g = 11;
        double d = Double.parseDouble(this.j);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.j + M());
        }
        this.j = null;
        this.f662g = 0;
        int[] iArr3 = this.f668n;
        int i4 = this.f666l - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j2;
    }

    public final String R() throws IOException {
        String strU;
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF == 14) {
            strU = W();
        } else if (iF == 12) {
            strU = U('\'');
        } else {
            if (iF != 13) {
                throw f0("a name");
            }
            strU = U('\"');
        }
        this.f662g = 0;
        this.f667m[this.f666l - 1] = strU;
        return strU;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int S(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.S(boolean):int");
    }

    public final void T() {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF != 7) {
            throw f0("null");
        }
        this.f662g = 0;
        int[] iArr = this.f668n;
        int i2 = this.f666l - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
    
        r11.c = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006b, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007b, code lost:
    
        r1.append(r7, r3, r2 - r3);
        r11.c = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String U(char r12) throws i0.c {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.c
            int r3 = r11.d
        L6:
            r4 = r3
            r3 = r2
        L8:
            r5 = 16
            r6 = 1
            char[] r7 = r11.f659b
            if (r2 >= r4) goto L6b
            int r8 = r2 + 1
            char r2 = r7[r2]
            int r9 = r11.o
            r10 = 3
            if (r9 != r10) goto L23
            r9 = 32
            if (r2 < r9) goto L1d
            goto L23
        L1d:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.e0(r12)
            throw r0
        L23:
            if (r2 != r12) goto L39
            r11.c = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L31
            java.lang.String r12 = new java.lang.String
            r12.<init>(r7, r3, r8)
            return r12
        L31:
            r1.append(r7, r3, r8)
            java.lang.String r12 = r1.toString()
            return r12
        L39:
            r9 = 92
            if (r2 != r9) goto L5e
            r11.c = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L4f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r5)
            r1.<init>(r4)
        L4f:
            r1.append(r7, r3, r2)
            char r2 = r11.Z()
            r1.append(r2)
            int r2 = r11.c
            int r3 = r11.d
            goto L6
        L5e:
            r5 = 10
            if (r2 != r5) goto L69
            int r2 = r11.f660e
            int r2 = r2 + r6
            r11.f660e = r2
            r11.f661f = r8
        L69:
            r2 = r8
            goto L8
        L6b:
            if (r1 != 0) goto L7b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L7b:
            int r4 = r2 - r3
            r1.append(r7, r3, r4)
            r11.c = r2
            boolean r2 = r11.I(r6)
            if (r2 == 0) goto L8a
            goto L2
        L8a:
            java.lang.String r12 = "Unterminated string"
            r11.e0(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.U(char):java.lang.String");
    }

    public final String V() throws IOException {
        String str;
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF == 10) {
            str = W();
        } else if (iF == 8) {
            str = U('\'');
        } else if (iF == 9) {
            str = U('\"');
        } else if (iF == 11) {
            str = this.j;
            this.j = null;
        } else if (iF == 15) {
            str = Long.toString(this.f663h);
        } else {
            if (iF != 16) {
                throw f0("a string");
            }
            str = new String(this.f659b, this.c, this.f664i);
            this.c += this.f664i;
        }
        this.f662g = 0;
        int[] iArr = this.f668n;
        int i2 = this.f666l - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        E();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String W() throws i0.c {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r7.c
            int r4 = r3 + r2
            int r5 = r7.d
            char[] r6 = r7.f659b
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.E()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.I(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.c
            r0.append(r6, r3, r2)
            int r3 = r7.c
            int r3 = r3 + r2
            r7.c = r3
            r2 = 1
            boolean r2 = r7.I(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.c
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.c
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.c
            int r2 = r2 + r1
            r7.c = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.W():java.lang.String");
    }

    public final int X() throws IOException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        switch (iF) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            case 17:
                return 10;
            default:
                throw new AssertionError();
        }
    }

    public final void Y(int i2) throws c {
        int i3 = this.f666l;
        if (i3 - 1 >= 255) {
            throw new c("Nesting limit 255 reached" + M());
        }
        int[] iArr = this.f665k;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f665k = Arrays.copyOf(iArr, i4);
            this.f668n = Arrays.copyOf(this.f668n, i4);
            this.f667m = (String[]) Arrays.copyOf(this.f667m, i4);
        }
        int[] iArr2 = this.f665k;
        int i5 = this.f666l;
        this.f666l = i5 + 1;
        iArr2[i5] = i2;
    }

    public final char Z() throws c {
        int i2;
        if (this.c == this.d && !I(1)) {
            e0("Unterminated escape sequence");
            throw null;
        }
        int i3 = this.c;
        int i4 = i3 + 1;
        this.c = i4;
        char[] cArr = this.f659b;
        char c = cArr[i3];
        if (c != '\n') {
            if (c != '\"') {
                if (c != '\'') {
                    if (c != '/' && c != '\\') {
                        if (c == 'b') {
                            return '\b';
                        }
                        if (c == 'f') {
                            return '\f';
                        }
                        if (c == 'n') {
                            return '\n';
                        }
                        if (c == 'r') {
                            return '\r';
                        }
                        if (c == 't') {
                            return '\t';
                        }
                        if (c != 'u') {
                            e0("Invalid escape sequence");
                            throw null;
                        }
                        if (i3 + 5 > this.d && !I(4)) {
                            e0("Unterminated escape sequence");
                            throw null;
                        }
                        int i5 = this.c;
                        int i6 = i5 + 4;
                        int i7 = 0;
                        while (i5 < i6) {
                            char c2 = cArr[i5];
                            int i8 = i7 << 4;
                            if (c2 >= '0' && c2 <= '9') {
                                i2 = c2 - '0';
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                i2 = c2 - 'W';
                            } else {
                                if (c2 < 'A' || c2 > 'F') {
                                    e0("Malformed Unicode escape \\u".concat(new String(cArr, this.c, 4)));
                                    throw null;
                                }
                                i2 = c2 - '7';
                            }
                            i7 = i2 + i8;
                            i5++;
                        }
                        this.c += 4;
                        return (char) i7;
                    }
                }
            }
            return c;
        }
        if (this.o == 3) {
            e0("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.f660e++;
        this.f661f = i4;
        if (this.o == 3) {
            e0("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c;
    }

    public final void a() throws IOException {
        int iF = this.f662g;
        if (iF == 0) {
            iF = F();
        }
        if (iF != 3) {
            throw f0("BEGIN_ARRAY");
        }
        Y(1);
        this.f668n[this.f666l - 1] = 0;
        this.f662g = 0;
    }

    public final void a0(char c) throws c {
        do {
            int i2 = this.c;
            int i3 = this.d;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c2 = this.f659b[i2];
                if (c2 == c) {
                    this.c = i4;
                    return;
                }
                if (c2 == '\\') {
                    this.c = i4;
                    Z();
                    i2 = this.c;
                    i3 = this.d;
                } else {
                    if (c2 == '\n') {
                        this.f660e++;
                        this.f661f = i4;
                    }
                    i2 = i4;
                }
            }
            this.c = i2;
        } while (I(1));
        e0("Unterminated string");
        throw null;
    }

    public final void b0() {
        char c;
        do {
            if (this.c >= this.d && !I(1)) {
                return;
            }
            int i2 = this.c;
            int i3 = i2 + 1;
            this.c = i3;
            c = this.f659b[i2];
            if (c == '\n') {
                this.f660e++;
                this.f661f = i3;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        E();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c0() throws i0.c {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.c
            int r2 = r1 + r0
            int r3 = r4.d
            if (r2 >= r3) goto L51
            char[] r2 = r4.f659b
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.E()
        L4b:
            int r1 = r4.c
            int r1 = r1 + r0
            r4.c = r1
            return
        L51:
            int r1 = r1 + r0
            r4.c = r1
            r0 = 1
            boolean r0 = r4.I(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.a.c0():void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f662g = 0;
        this.f665k[0] = 8;
        this.f666l = 1;
        this.f658a.close();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void d0() throws IOException {
        int i2 = 0;
        do {
            int iF = this.f662g;
            if (iF == 0) {
                iF = F();
            }
            switch (iF) {
                case 1:
                    Y(3);
                    i2++;
                    this.f662g = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.f667m[this.f666l - 1] = null;
                    }
                    this.f666l--;
                    i2--;
                    this.f662g = 0;
                    break;
                case 3:
                    Y(1);
                    i2++;
                    this.f662g = 0;
                    break;
                case 4:
                    this.f666l--;
                    i2--;
                    this.f662g = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f662g = 0;
                    break;
                case 8:
                    a0('\'');
                    this.f662g = 0;
                    break;
                case 9:
                    a0('\"');
                    this.f662g = 0;
                    break;
                case 10:
                    c0();
                    this.f662g = 0;
                    break;
                case 12:
                    a0('\'');
                    if (i2 == 0) {
                        this.f667m[this.f666l - 1] = "<skipped>";
                    }
                    this.f662g = 0;
                    break;
                case 13:
                    a0('\"');
                    if (i2 == 0) {
                        this.f667m[this.f666l - 1] = "<skipped>";
                    }
                    this.f662g = 0;
                    break;
                case 14:
                    c0();
                    if (i2 == 0) {
                        this.f667m[this.f666l - 1] = "<skipped>";
                    }
                    this.f662g = 0;
                    break;
                case 16:
                    this.c += this.f664i;
                    this.f662g = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.f668n;
        int i3 = this.f666l - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public final void e0(String str) throws c {
        StringBuilder sbP = androidx.appcompat.app.g.p(str);
        sbP.append(M());
        sbP.append("\nSee ");
        sbP.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("malformed-json"));
        throw new c(sbP.toString());
    }

    public final IllegalStateException f0(String str) {
        String str2 = X() == 9 ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbS = androidx.appcompat.app.g.s("Expected ", str, " but was ");
        sbS.append(androidx.appcompat.app.g.w(X()));
        sbS.append(M());
        sbS.append("\nSee ");
        sbS.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(str2));
        return new IllegalStateException(sbS.toString());
    }

    public final String toString() {
        return a.class.getSimpleName() + M();
    }
}
