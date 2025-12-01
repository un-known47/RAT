package m0;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class l extends p.a {
    public static int g0(List list) {
        kotlin.jvm.internal.j.e(list, "<this>");
        return list.size() - 1;
    }

    public static List h0(Object... objArr) {
        return objArr.length > 0 ? i.g0(objArr) : q.f867a;
    }

    public static ArrayList i0(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new g(objArr, true));
    }

    public static void j0() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
