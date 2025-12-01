package o1;

import java.io.Closeable;
import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public l f901a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f902b;
    public l0 c;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f903e;
    public long d = -1;

    /* renamed from: f, reason: collision with root package name */
    public int f904f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f905g = -1;

    public final int D(long j) {
        l lVar = this.f901a;
        if (lVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (j >= -1) {
            long j2 = lVar.f919b;
            if (j <= j2) {
                if (j == -1 || j == j2) {
                    this.c = null;
                    this.d = j;
                    this.f903e = null;
                    this.f904f = -1;
                    this.f905g = -1;
                    return -1;
                }
                l0 l0Var = lVar.f918a;
                l0 l0Var2 = this.c;
                long j3 = 0;
                if (l0Var2 != null) {
                    long j4 = this.d - (this.f904f - l0Var2.f921b);
                    if (j4 > j) {
                        l0Var2 = l0Var;
                        l0Var = l0Var2;
                        j2 = j4;
                    } else {
                        j3 = j4;
                    }
                } else {
                    l0Var2 = l0Var;
                }
                if (j2 - j > j - j3) {
                    while (true) {
                        kotlin.jvm.internal.j.b(l0Var2);
                        long j5 = (l0Var2.c - l0Var2.f921b) + j3;
                        if (j < j5) {
                            break;
                        }
                        l0Var2 = l0Var2.f923f;
                        j3 = j5;
                    }
                } else {
                    while (j2 > j) {
                        kotlin.jvm.internal.j.b(l0Var);
                        l0Var = l0Var.f924g;
                        kotlin.jvm.internal.j.b(l0Var);
                        j2 -= l0Var.c - l0Var.f921b;
                    }
                    j3 = j2;
                    l0Var2 = l0Var;
                }
                if (this.f902b) {
                    kotlin.jvm.internal.j.b(l0Var2);
                    if (l0Var2.d) {
                        byte[] bArr = l0Var2.f920a;
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                        kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(...)");
                        l0 l0Var3 = new l0(bArrCopyOf, l0Var2.f921b, l0Var2.c, false, true);
                        if (lVar.f918a == l0Var2) {
                            lVar.f918a = l0Var3;
                        }
                        l0Var2.b(l0Var3);
                        l0 l0Var4 = l0Var3.f924g;
                        kotlin.jvm.internal.j.b(l0Var4);
                        l0Var4.a();
                        l0Var2 = l0Var3;
                    }
                }
                this.c = l0Var2;
                this.d = j;
                kotlin.jvm.internal.j.b(l0Var2);
                this.f903e = l0Var2.f920a;
                int i2 = l0Var2.f921b + ((int) (j - j3));
                this.f904f = i2;
                int i3 = l0Var2.c;
                this.f905g = i3;
                return i3 - i2;
            }
        }
        throw new ArrayIndexOutOfBoundsException("offset=" + j + " > size=" + lVar.f919b);
    }

    public final void a(long j) {
        l lVar = this.f901a;
        if (lVar == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        if (!this.f902b) {
            throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
        }
        long j2 = lVar.f919b;
        if (j <= j2) {
            if (j < 0) {
                throw new IllegalArgumentException(androidx.appcompat.app.g.f("newSize < 0: ", j).toString());
            }
            long j3 = j2 - j;
            while (true) {
                if (j3 <= 0) {
                    break;
                }
                l0 l0Var = lVar.f918a;
                kotlin.jvm.internal.j.b(l0Var);
                l0 l0Var2 = l0Var.f924g;
                kotlin.jvm.internal.j.b(l0Var2);
                int i2 = l0Var2.c;
                long j4 = i2 - l0Var2.f921b;
                if (j4 > j3) {
                    l0Var2.c = i2 - ((int) j3);
                    break;
                } else {
                    lVar.f918a = l0Var2.a();
                    m0.a(l0Var2);
                    j3 -= j4;
                }
            }
            this.c = null;
            this.d = j;
            this.f903e = null;
            this.f904f = -1;
            this.f905g = -1;
        } else if (j > j2) {
            long j5 = j - j2;
            boolean z2 = true;
            for (long j6 = 0; j5 > j6; j6 = 0) {
                l0 l0VarS = lVar.S(1);
                int iMin = (int) Math.min(j5, 8192 - l0VarS.c);
                int i3 = l0VarS.c + iMin;
                l0VarS.c = i3;
                j5 -= iMin;
                if (z2) {
                    this.c = l0VarS;
                    this.d = j2;
                    this.f903e = l0VarS.f920a;
                    this.f904f = i3 - iMin;
                    this.f905g = i3;
                    z2 = false;
                }
            }
        }
        lVar.f919b = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f901a == null) {
            throw new IllegalStateException("not attached to a buffer");
        }
        this.f901a = null;
        this.c = null;
        this.d = -1L;
        this.f903e = null;
        this.f904f = -1;
        this.f905g = -1;
    }
}
