package i0;

import a0.i;
import androidx.constraintlayout.widget.R;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class b implements Closeable, Flushable {

    /* renamed from: l, reason: collision with root package name */
    public static final Pattern f669l = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f670m = new String[128];

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f671n;

    /* renamed from: a, reason: collision with root package name */
    public final Writer f672a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f673b;
    public int c;
    public i d;

    /* renamed from: e, reason: collision with root package name */
    public String f674e;

    /* renamed from: f, reason: collision with root package name */
    public String f675f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f676g;

    /* renamed from: h, reason: collision with root package name */
    public int f677h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f678i;
    public String j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f679k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f670m[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f670m;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f671n = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        int[] iArr = new int[32];
        this.f673b = iArr;
        this.c = 0;
        if (iArr.length == 0) {
            this.f673b = Arrays.copyOf(iArr, 0);
        }
        int[] iArr2 = this.f673b;
        int i2 = this.c;
        this.c = i2 + 1;
        iArr2[i2] = 6;
        this.f677h = 2;
        this.f679k = true;
        Objects.requireNonNull(writer, "out == null");
        this.f672a = writer;
        M(i.d);
    }

    public void D() throws IOException {
        T();
        a();
        int i2 = this.c;
        int[] iArr = this.f673b;
        if (i2 == iArr.length) {
            this.f673b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f673b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = 1;
        this.f672a.write(91);
    }

    public void E() throws IOException {
        T();
        a();
        int i2 = this.c;
        int[] iArr = this.f673b;
        if (i2 == iArr.length) {
            this.f673b = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f673b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr2[i3] = 3;
        this.f672a.write(R.styleable.AppCompatTheme_windowFixedWidthMinor);
    }

    public final void F(int i2, int i3, char c) throws IOException {
        int iL = L();
        if (iL != i3 && iL != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.j != null) {
            throw new IllegalStateException("Dangling name: " + this.j);
        }
        this.c--;
        if (iL == i3) {
            J();
        }
        this.f672a.write(c);
    }

    public void G() throws IOException {
        F(1, 2, ']');
    }

    public void H() throws IOException {
        F(3, 5, '}');
    }

    public void I(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.j != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iL = L();
        if (iL != 3 && iL != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.j = str;
    }

    public final void J() throws IOException {
        if (this.f676g) {
            return;
        }
        String str = this.d.f2a;
        Writer writer = this.f672a;
        writer.write(str);
        int i2 = this.c;
        for (int i3 = 1; i3 < i2; i3++) {
            writer.write(this.d.f3b);
        }
    }

    public b K() throws IOException {
        if (this.j != null) {
            if (!this.f679k) {
                this.j = null;
                return this;
            }
            T();
        }
        a();
        this.f672a.write("null");
        return this;
    }

    public final int L() {
        int i2 = this.c;
        if (i2 != 0) {
            return this.f673b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void M(i iVar) {
        Objects.requireNonNull(iVar);
        this.d = iVar;
        this.f675f = ",";
        if (iVar.c) {
            this.f674e = ": ";
            if (iVar.f2a.isEmpty()) {
                this.f675f = ", ";
            }
        } else {
            this.f674e = ":";
        }
        this.f676g = this.d.f2a.isEmpty() && this.d.f3b.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void N(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f678i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = i0.b.f671n
            goto L9
        L7:
            java.lang.String[] r0 = i0.b.f670m
        L9:
            java.io.Writer r1 = r8.f672a
            r2 = 34
            r1.write(r2)
            int r3 = r9.length()
            r4 = 0
            r5 = 0
        L16:
            if (r4 >= r3) goto L41
            char r6 = r9.charAt(r4)
            r7 = 128(0x80, float:1.8E-43)
            if (r6 >= r7) goto L25
            r6 = r0[r6]
            if (r6 != 0) goto L32
            goto L3e
        L25:
            r7 = 8232(0x2028, float:1.1535E-41)
            if (r6 != r7) goto L2c
            java.lang.String r6 = "\\u2028"
            goto L32
        L2c:
            r7 = 8233(0x2029, float:1.1537E-41)
            if (r6 != r7) goto L3e
            java.lang.String r6 = "\\u2029"
        L32:
            if (r5 >= r4) goto L39
            int r7 = r4 - r5
            r1.write(r9, r5, r7)
        L39:
            r1.write(r6)
            int r5 = r4 + 1
        L3e:
            int r4 = r4 + 1
            goto L16
        L41:
            if (r5 >= r3) goto L47
            int r3 = r3 - r5
            r1.write(r9, r5, r3)
        L47:
            r1.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.b.N(java.lang.String):void");
    }

    public void O(double d) throws IOException {
        T();
        if (this.f677h == 1 || !(Double.isNaN(d) || Double.isInfinite(d))) {
            a();
            this.f672a.append((CharSequence) Double.toString(d));
        } else {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
    }

    public void P(long j) throws IOException {
        T();
        a();
        this.f672a.write(Long.toString(j));
    }

    public void Q(Number number) throws IOException {
        if (number == null) {
            K();
            return;
        }
        T();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (cls != Integer.class && cls != Long.class && cls != Byte.class && cls != Short.class && cls != BigDecimal.class && cls != BigInteger.class && cls != AtomicInteger.class && cls != AtomicLong.class) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.f677h != 1) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(string));
                }
            } else if (cls != Float.class && cls != Double.class && !f669l.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        a();
        this.f672a.append((CharSequence) string);
    }

    public void R(String str) throws IOException {
        if (str == null) {
            K();
            return;
        }
        T();
        a();
        N(str);
    }

    public void S(boolean z2) throws IOException {
        T();
        a();
        this.f672a.write(z2 ? "true" : "false");
    }

    public final void T() throws IOException {
        if (this.j != null) {
            int iL = L();
            if (iL == 5) {
                this.f672a.write(this.f675f);
            } else if (iL != 3) {
                throw new IllegalStateException("Nesting problem.");
            }
            J();
            this.f673b[this.c - 1] = 4;
            N(this.j);
            this.j = null;
        }
    }

    public final void a() throws IOException {
        int iL = L();
        if (iL == 1) {
            this.f673b[this.c - 1] = 2;
            J();
            return;
        }
        Writer writer = this.f672a;
        if (iL == 2) {
            writer.append((CharSequence) this.f675f);
            J();
        } else {
            if (iL == 4) {
                writer.append((CharSequence) this.f674e);
                this.f673b[this.c - 1] = 5;
                return;
            }
            if (iL != 6) {
                if (iL != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (this.f677h != 1) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            this.f673b[this.c - 1] = 7;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f672a.close();
        int i2 = this.c;
        if (i2 > 1 || (i2 == 1 && this.f673b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.c = 0;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f672a.flush();
    }
}
