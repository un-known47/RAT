package o1;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class o implements Serializable, Comparable {
    public static final o d = new o(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f929a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f930b;
    public transient String c;

    public o(byte[] data) {
        kotlin.jvm.internal.j.e(data, "data");
        this.f929a = data;
    }

    public static int g(o oVar, o other) {
        oVar.getClass();
        kotlin.jvm.internal.j.e(other, "other");
        return oVar.f(other.h(), 0);
    }

    public static int k(o oVar, o other) {
        oVar.getClass();
        kotlin.jvm.internal.j.e(other, "other");
        return oVar.j(other.h());
    }

    public static /* synthetic */ o p(o oVar, int i2, int i3, int i4) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = -1234567890;
        }
        return oVar.o(i2, i3);
    }

    public String a() {
        byte[] map = a.f884a;
        byte[] bArr = this.f929a;
        kotlin.jvm.internal.j.e(bArr, "<this>");
        kotlin.jvm.internal.j.e(map, "map");
        byte[] bArr2 = new byte[((bArr.length + 2) / 3) * 4];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i2 + 2;
            byte b3 = bArr[i2 + 1];
            i2 += 3;
            byte b4 = bArr[i4];
            bArr2[i3] = map[(b2 & 255) >> 2];
            bArr2[i3 + 1] = map[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i5 = i3 + 3;
            bArr2[i3 + 2] = map[((b3 & 15) << 2) | ((b4 & 255) >> 6)];
            i3 += 4;
            bArr2[i5] = map[b4 & 63];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i2];
            bArr2[i3] = map[(b5 & 255) >> 2];
            bArr2[i3 + 1] = map[(b5 & 3) << 4];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
        } else if (length2 == 2) {
            int i6 = i2 + 1;
            byte b6 = bArr[i2];
            byte b7 = bArr[i6];
            bArr2[i3] = map[(b6 & 255) >> 2];
            bArr2[i3 + 1] = map[((b6 & 3) << 4) | ((b7 & 255) >> 4)];
            bArr2[i3 + 2] = map[(b7 & 15) << 2];
            bArr2[i3 + 3] = 61;
        }
        return new String(bArr2, f1.a.f458a);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(o other) {
        kotlin.jvm.internal.j.e(other, "other");
        int iD = d();
        int iD2 = other.d();
        int iMin = Math.min(iD, iD2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = i(i2) & 255;
            int i4 = other.i(i2) & 255;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
        }
        if (iD == iD2) {
            return 0;
        }
        return iD < iD2 ? -1 : 1;
    }

    public o c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f929a, 0, d());
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.j.b(bArrDigest);
        return new o(bArrDigest);
    }

    public int d() {
        return this.f929a.length;
    }

    public String e() {
        byte[] bArr = this.f929a;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = p1.b.f992a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 += 2;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            int iD = oVar.d();
            byte[] bArr = this.f929a;
            if (iD == bArr.length && oVar.m(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int f(byte[] other, int i2) {
        kotlin.jvm.internal.j.e(other, "other");
        byte[] bArr = this.f929a;
        int length = bArr.length - other.length;
        int iMax = Math.max(i2, 0);
        if (iMax > length) {
            return -1;
        }
        while (!b.a(iMax, 0, other.length, bArr, other)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] h() {
        return this.f929a;
    }

    public int hashCode() {
        int i2 = this.f930b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f929a);
        this.f930b = iHashCode;
        return iHashCode;
    }

    public byte i(int i2) {
        return this.f929a[i2];
    }

    public int j(byte[] other) {
        kotlin.jvm.internal.j.e(other, "other");
        int iD = d();
        byte[] bArr = this.f929a;
        for (int iMin = Math.min(iD, bArr.length - other.length); -1 < iMin; iMin--) {
            if (b.a(iMin, 0, other.length, bArr, other)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean l(int i2, o other, int i3) {
        kotlin.jvm.internal.j.e(other, "other");
        return other.m(0, this.f929a, i2, i3);
    }

    public boolean m(int i2, byte[] other, int i3, int i4) {
        kotlin.jvm.internal.j.e(other, "other");
        if (i2 < 0) {
            return false;
        }
        byte[] bArr = this.f929a;
        return i2 <= bArr.length - i4 && i3 >= 0 && i3 <= other.length - i4 && b.a(i2, i3, i4, bArr, other);
    }

    public String n(Charset charset) {
        kotlin.jvm.internal.j.e(charset, "charset");
        return new String(this.f929a, charset);
    }

    public o o(int i2, int i3) {
        if (i3 == -1234567890) {
            i3 = d();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f929a;
        if (i3 <= bArr.length) {
            if (i3 - i2 >= 0) {
                return (i2 == 0 && i3 == bArr.length) ? this : new o(m0.i.o0(bArr, i2, i3));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }

    public o q() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f929a;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                kotlin.jvm.internal.j.d(bArrCopyOf, "copyOf(...)");
                bArrCopyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArrCopyOf.length; i3++) {
                    byte b3 = bArrCopyOf[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArrCopyOf[i3] = (byte) (b3 + 32);
                    }
                }
                return new o(bArrCopyOf);
            }
            i2++;
        }
    }

    public final String r() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        byte[] bArrH = h();
        kotlin.jvm.internal.j.e(bArrH, "<this>");
        String str2 = new String(bArrH, f1.a.f458a);
        this.c = str2;
        return str2;
    }

    public void s(int i2, l lVar) {
        lVar.m80write(this.f929a, 0, i2);
    }

    public String toString() {
        byte b2;
        int i2;
        byte[] bArr = this.f929a;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        loop0: while (true) {
            if (i3 >= length) {
                break;
            }
            byte b3 = bArr[i3];
            if (b3 >= 0) {
                int i6 = i5 + 1;
                if (i5 == 64) {
                    break;
                }
                if ((b3 != 10 && b3 != 13 && ((b3 >= 0 && b3 < 32) || (127 <= b3 && b3 < 160))) || b3 == 65533) {
                    break;
                }
                i4 += b3 < 65536 ? 1 : 2;
                i3++;
                while (true) {
                    i5 = i6;
                    if (i3 < length && (b2 = bArr[i3]) >= 0) {
                        i3++;
                        i6 = i5 + 1;
                        if (i5 == 64) {
                            break loop0;
                        }
                        if ((b2 != 10 && b2 != 13 && ((b2 >= 0 && b2 < 32) || (127 <= b2 && b2 < 160))) || b2 == 65533) {
                            break loop0;
                        }
                        i4 += b2 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b3 >> 5) == -2) {
                int i7 = i3 + 1;
                if (length > i7) {
                    byte b4 = bArr[i7];
                    if ((b4 & 192) == 128) {
                        int i8 = (b4 ^ 3968) ^ (b3 << 6);
                        if (i8 >= 128) {
                            i2 = i5 + 1;
                            if (i5 == 64) {
                                break;
                            }
                            if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160))) || i8 == 65533) {
                                break;
                            }
                            i4 += i8 < 65536 ? 1 : 2;
                            i3 += 2;
                            i5 = i2;
                        } else if (i5 != 64) {
                            break;
                        }
                    } else if (i5 != 64) {
                        break;
                    }
                } else if (i5 != 64) {
                    break;
                }
            } else if ((b3 >> 4) == -2) {
                int i9 = i3 + 2;
                if (length > i9) {
                    byte b5 = bArr[i3 + 1];
                    if ((b5 & 192) == 128) {
                        byte b6 = bArr[i9];
                        if ((b6 & 192) == 128) {
                            int i10 = ((b6 ^ (-123008)) ^ (b5 << 6)) ^ (b3 << 12);
                            if (i10 < 2048) {
                                if (i5 != 64) {
                                    break;
                                }
                            } else if (55296 > i10 || i10 >= 57344) {
                                i2 = i5 + 1;
                                if (i5 == 64) {
                                    break;
                                }
                                if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                                    break;
                                }
                                i4 += i10 < 65536 ? 1 : 2;
                                i3 += 3;
                                i5 = i2;
                            } else if (i5 != 64) {
                                break;
                            }
                        } else if (i5 != 64) {
                            break;
                        }
                    } else if (i5 != 64) {
                        break;
                    }
                } else if (i5 != 64) {
                    break;
                }
            } else if ((b3 >> 3) == -2) {
                int i11 = i3 + 3;
                if (length > i11) {
                    byte b7 = bArr[i3 + 1];
                    if ((b7 & 192) == 128) {
                        byte b8 = bArr[i3 + 2];
                        if ((b8 & 192) == 128) {
                            byte b9 = bArr[i11];
                            if ((b9 & 192) == 128) {
                                int i12 = (((b9 ^ 3678080) ^ (b8 << 6)) ^ (b7 << 12)) ^ (b3 << 18);
                                if (i12 > 1114111) {
                                    if (i5 != 64) {
                                        break;
                                    }
                                } else if (55296 > i12 || i12 >= 57344) {
                                    if (i12 >= 65536) {
                                        i2 = i5 + 1;
                                        if (i5 == 64) {
                                            break;
                                        }
                                        if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && i12 < 32) || (127 <= i12 && i12 < 160))) || i12 == 65533) {
                                            break;
                                        }
                                        i4 += i12 < 65536 ? 1 : 2;
                                        i3 += 4;
                                        i5 = i2;
                                    } else if (i5 != 64) {
                                        break;
                                    }
                                } else if (i5 != 64) {
                                    break;
                                }
                            } else if (i5 != 64) {
                                break;
                            }
                        } else if (i5 != 64) {
                            break;
                        }
                    } else if (i5 != 64) {
                        break;
                    }
                } else if (i5 != 64) {
                    break;
                }
            } else if (i5 != 64) {
                break;
            }
        }
        i4 = -1;
        if (i4 != -1) {
            String strR = r();
            String strSubstring = strR.substring(0, i4);
            kotlin.jvm.internal.j.d(strSubstring, "substring(...)");
            String strM0 = f1.q.m0(f1.q.m0(f1.q.m0(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i4 >= strR.length()) {
                return "[text=" + strM0 + ']';
            }
            return "[size=" + bArr.length + " text=" + strM0 + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + e() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 <= bArr.length) {
            sb.append((64 == bArr.length ? this : new o(m0.i.o0(bArr, 0, 64))).e());
            sb.append("…]");
            return sb.toString();
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }
}
