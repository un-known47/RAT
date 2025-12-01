package d0;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class p extends a0.b0 {
    public static final n c = new n(1, a0.z.f20a);

    /* renamed from: a, reason: collision with root package name */
    public final a0.m f409a;

    /* renamed from: b, reason: collision with root package name */
    public final a0.z f410b;

    public p(a0.m mVar, a0.z zVar) {
        this.f409a = mVar;
        this.f410b = zVar;
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        int iX = aVar.X();
        int iA = a0.u.a(iX);
        if (iA == 0) {
            aVar.a();
            arrayList = new ArrayList();
        } else if (iA != 2) {
            arrayList = null;
        } else {
            aVar.D();
            arrayList = new c0.p(true);
        }
        if (arrayList == null) {
            return d(aVar, iX);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.K()) {
                String strR = arrayList instanceof Map ? aVar.R() : null;
                int iX2 = aVar.X();
                int iA2 = a0.u.a(iX2);
                if (iA2 == 0) {
                    aVar.a();
                    arrayList2 = new ArrayList();
                } else if (iA2 != 2) {
                    arrayList2 = null;
                } else {
                    aVar.D();
                    arrayList2 = new c0.p(true);
                }
                boolean z2 = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = d(aVar, iX2);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strR, arrayList2);
                }
                if (z2) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    aVar.G();
                } else {
                    aVar.H();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        if (obj == null) {
            bVar.K();
            return;
        }
        Class<?> cls = obj.getClass();
        a0.m mVar = this.f409a;
        mVar.getClass();
        a0.b0 b0VarB = mVar.b(new h0.a(cls));
        if (!(b0VarB instanceof p)) {
            b0VarB.c(bVar, obj);
        } else {
            bVar.E();
            bVar.H();
        }
    }

    public final Serializable d(i0.a aVar, int i2) {
        int iA = a0.u.a(i2);
        if (iA == 5) {
            return aVar.V();
        }
        if (iA == 6) {
            return this.f410b.a(aVar);
        }
        if (iA == 7) {
            return Boolean.valueOf(aVar.N());
        }
        if (iA != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(androidx.appcompat.app.g.w(i2)));
        }
        aVar.T();
        return null;
    }
}
