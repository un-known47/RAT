package o1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f920a;

    /* renamed from: b, reason: collision with root package name */
    public int f921b;
    public int c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f922e;

    /* renamed from: f, reason: collision with root package name */
    public l0 f923f;

    /* renamed from: g, reason: collision with root package name */
    public l0 f924g;

    public l0() {
        this.f920a = new byte[8192];
        this.f922e = true;
        this.d = false;
    }

    public final l0 a() {
        l0 l0Var = this.f923f;
        if (l0Var == this) {
            l0Var = null;
        }
        l0 l0Var2 = this.f924g;
        kotlin.jvm.internal.j.b(l0Var2);
        l0Var2.f923f = this.f923f;
        l0 l0Var3 = this.f923f;
        kotlin.jvm.internal.j.b(l0Var3);
        l0Var3.f924g = this.f924g;
        this.f923f = null;
        this.f924g = null;
        return l0Var;
    }

    public final void b(l0 segment) {
        kotlin.jvm.internal.j.e(segment, "segment");
        segment.f924g = this;
        segment.f923f = this.f923f;
        l0 l0Var = this.f923f;
        kotlin.jvm.internal.j.b(l0Var);
        l0Var.f924g = segment;
        this.f923f = segment;
    }

    public final l0 c() {
        this.d = true;
        return new l0(this.f920a, this.f921b, this.c, true, false);
    }

    public final void d(l0 sink, int i2) {
        kotlin.jvm.internal.j.e(sink, "sink");
        byte[] bArr = sink.f920a;
        if (!sink.f922e) {
            throw new IllegalStateException("only owner can write");
        }
        int i3 = sink.c;
        int i4 = i3 + i2;
        if (i4 > 8192) {
            if (sink.d) {
                throw new IllegalArgumentException();
            }
            int i5 = sink.f921b;
            if (i4 - i5 > 8192) {
                throw new IllegalArgumentException();
            }
            m0.i.h0(0, i5, i3, bArr, bArr);
            sink.c -= sink.f921b;
            sink.f921b = 0;
        }
        int i6 = sink.c;
        int i7 = this.f921b;
        m0.i.h0(i6, i7, i7 + i2, this.f920a, bArr);
        sink.c += i2;
        this.f921b += i2;
    }

    public l0(byte[] data, int i2, int i3, boolean z2, boolean z3) {
        kotlin.jvm.internal.j.e(data, "data");
        this.f920a = data;
        this.f921b = i2;
        this.c = i3;
        this.d = z2;
        this.f922e = z3;
    }
}
