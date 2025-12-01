package o1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final i f888a = new i();

    public static final boolean a(int i2, int i3, int i4, byte[] a2, byte[] b2) {
        kotlin.jvm.internal.j.e(a2, "a");
        kotlin.jvm.internal.j.e(b2, "b");
        for (int i5 = 0; i5 < i4; i5++) {
            if (a2[i5 + i2] != b2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static final j0 b(o0 o0Var) {
        kotlin.jvm.internal.j.e(o0Var, "<this>");
        return new j0(o0Var);
    }

    public static final k0 c(p0 p0Var) {
        kotlin.jvm.internal.j.e(p0Var, "<this>");
        return new k0(p0Var);
    }

    public static void d(long j, l lVar, int i2, ArrayList arrayList, int i3, int i4, ArrayList arrayList2) {
        int i5;
        int i6;
        ArrayList arrayList3;
        long j2;
        int i7;
        int i8 = i2;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i3 >= i4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i9 = i3; i9 < i4; i9++) {
            if (((o) arrayList4.get(i9)).d() < i8) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        o oVar = (o) arrayList.get(i3);
        o oVar2 = (o) arrayList4.get(i4 - 1);
        if (i8 == oVar.d()) {
            int iIntValue = ((Number) arrayList5.get(i3)).intValue();
            int i10 = i3 + 1;
            o oVar3 = (o) arrayList4.get(i10);
            i5 = i10;
            i6 = iIntValue;
            oVar = oVar3;
        } else {
            i5 = i3;
            i6 = -1;
        }
        if (oVar.i(i8) == oVar2.i(i8)) {
            int iMin = Math.min(oVar.d(), oVar2.d());
            int i11 = 0;
            for (int i12 = i8; i12 < iMin && oVar.i(i12) == oVar2.i(i12); i12++) {
                i11++;
            }
            long j3 = 4;
            long j4 = (lVar.f919b / j3) + j + 2 + i11 + 1;
            lVar.X(-i11);
            lVar.X(i6);
            int i13 = i8 + i11;
            while (i8 < i13) {
                lVar.X(oVar.i(i8) & 255);
                i8++;
            }
            if (i5 + 1 == i4) {
                if (i13 != ((o) arrayList4.get(i5)).d()) {
                    throw new IllegalStateException("Check failed.");
                }
                lVar.X(((Number) arrayList5.get(i5)).intValue());
                return;
            } else {
                l lVar2 = new l();
                lVar.X(((int) ((lVar2.f919b / j3) + j4)) * (-1));
                d(j4, lVar2, i13, arrayList4, i5, i4, arrayList5);
                lVar.f(lVar2);
                return;
            }
        }
        int i14 = 1;
        for (int i15 = i5 + 1; i15 < i4; i15++) {
            if (((o) arrayList4.get(i15 - 1)).i(i8) != ((o) arrayList4.get(i15)).i(i8)) {
                i14++;
            }
        }
        long j5 = 4;
        long j6 = (lVar.f919b / j5) + j + 2 + (i14 * 2);
        lVar.X(i14);
        lVar.X(i6);
        for (int i16 = i5; i16 < i4; i16++) {
            int i17 = ((o) arrayList4.get(i16)).i(i8);
            if (i16 == i5 || i17 != ((o) arrayList4.get(i16 - 1)).i(i8)) {
                lVar.X(i17 & 255);
            }
        }
        l lVar3 = new l();
        int i18 = i5;
        while (i18 < i4) {
            byte bI = ((o) arrayList4.get(i18)).i(i8);
            int i19 = i18 + 1;
            int i20 = i19;
            while (true) {
                if (i20 >= i4) {
                    i20 = i4;
                    break;
                } else if (bI != ((o) arrayList4.get(i20)).i(i8)) {
                    break;
                } else {
                    i20++;
                }
            }
            if (i19 == i20 && i8 + 1 == ((o) arrayList4.get(i18)).d()) {
                lVar.X(((Number) arrayList5.get(i18)).intValue());
                arrayList3 = arrayList5;
                j2 = j6;
                i7 = i20;
            } else {
                lVar.X(((int) ((lVar3.f919b / j5) + j6)) * (-1));
                arrayList3 = arrayList5;
                j2 = j6;
                i7 = i20;
                d(j2, lVar3, i8 + 1, arrayList, i18, i7, arrayList3);
                arrayList4 = arrayList;
            }
            j6 = j2;
            i18 = i7;
            arrayList5 = arrayList3;
        }
        lVar.f(lVar3);
    }

    public static final void e(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x012e, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static o1.g0 f(o1.o... r14) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.b.f(o1.o[]):o1.g0");
    }

    public static final int g(int i2) {
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static final o0 h(Socket socket) throws IOException {
        kotlin.jvm.internal.j.e(socket, "<this>");
        p1.j jVar = new p1.j(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.j.d(outputStream, "getOutputStream(...)");
        return jVar.sink(new e(1, outputStream, jVar));
    }

    public static final f i(InputStream inputStream) {
        return new f(inputStream, new s0());
    }

    public static final p0 j(Socket socket) throws IOException {
        kotlin.jvm.internal.j.e(socket, "<this>");
        p1.j jVar = new p1.j(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.j.d(inputStream, "getInputStream(...)");
        return jVar.source(new f(inputStream, jVar));
    }

    public static final String k(byte b2) {
        char[] cArr = p1.b.f992a;
        return new String(new char[]{cArr[(b2 >> 4) & 15], cArr[b2 & 15]});
    }

    public static final String l(int i2) {
        if (i2 == 0) {
            return "0";
        }
        char[] cArr = p1.b.f992a;
        int i3 = 0;
        char[] cArr2 = {cArr[(i2 >> 28) & 15], cArr[(i2 >> 24) & 15], cArr[(i2 >> 20) & 15], cArr[(i2 >> 16) & 15], cArr[(i2 >> 12) & 15], cArr[(i2 >> 8) & 15], cArr[(i2 >> 4) & 15], cArr[i2 & 15]};
        while (i3 < 8 && cArr2[i3] == '0') {
            i3++;
        }
        m0.e.Companion.getClass();
        if (i3 < 0) {
            throw new IndexOutOfBoundsException(androidx.appcompat.app.g.e("startIndex: ", i3, ", endIndex: 8, size: 8"));
        }
        if (i3 <= 8) {
            return new String(cArr2, i3, 8 - i3);
        }
        throw new IllegalArgumentException(androidx.appcompat.app.g.e("startIndex: ", i3, " > endIndex: 8"));
    }
}
