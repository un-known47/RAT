package m0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class i extends p.a {
    public static List g0(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        kotlin.jvm.internal.j.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static void h0(int i2, int i3, int i4, byte[] bArr, byte[] destination) {
        kotlin.jvm.internal.j.e(bArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(bArr, i3, destination, i2, i4 - i3);
    }

    public static void i0(int i2, int i3, int[] iArr, int[] destination, int i4) {
        kotlin.jvm.internal.j.e(iArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(iArr, i3, destination, i2, i4 - i3);
    }

    public static void j0(float[] fArr, int i2, float[] destination, int i3, int i4) {
        kotlin.jvm.internal.j.e(fArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(fArr, i3, destination, i2, i4 - i3);
    }

    public static void k0(long[] jArr, long[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.j.e(jArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(jArr, i3, destination, i2, i4 - i3);
    }

    public static void l0(Object[] objArr, Object[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        kotlin.jvm.internal.j.e(destination, "destination");
        System.arraycopy(objArr, i3, destination, i2, i4 - i3);
    }

    public static /* synthetic */ void m0(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length;
        }
        i0(i2, 0, iArr, iArr2, i3);
    }

    public static /* synthetic */ void n0(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        l0(objArr, objArr2, i2, i3, i4);
    }

    public static byte[] o0(byte[] bArr, int i2, int i3) {
        kotlin.jvm.internal.j.e(bArr, "<this>");
        p.a.m(i3, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i3);
        kotlin.jvm.internal.j.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] p0(Object[] objArr, int i2, int i3) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        p.a.m(i3, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i2, i3);
        kotlin.jvm.internal.j.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static void q0(Object[] objArr, int i2, int i3) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        Arrays.fill(objArr, i2, i3, (Object) null);
    }

    public static void r0(long[] jArr) {
        int length = jArr.length;
        kotlin.jvm.internal.j.e(jArr, "<this>");
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static ArrayList s0(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object t0(Object[] objArr, int i2) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        if (i2 < 0 || i2 >= objArr.length) {
            return null;
        }
        return objArr[i2];
    }

    public static int u0(Object[] objArr, Object obj) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        int i2 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i2 < length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i2 < length2) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static List v0(Object[] objArr) {
        kotlin.jvm.internal.j.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new g(objArr, false)) : p.a.G(objArr[0]) : q.f867a;
    }
}
