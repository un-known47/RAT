package d0;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class l extends a0.b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l f402a = new l();

    private l() {
    }

    public static a0.o d(i0.a aVar, int i2) {
        int iA = a0.u.a(i2);
        if (iA == 5) {
            return new a0.t(aVar.V());
        }
        if (iA == 6) {
            return new a0.t(new c0.k(aVar.V()));
        }
        if (iA == 7) {
            return new a0.t(Boolean.valueOf(aVar.N()));
        }
        if (iA != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(androidx.appcompat.app.g.w(i2)));
        }
        aVar.T();
        return a0.q.f17a;
    }

    public static void e(i0.b bVar, a0.o oVar) {
        if (oVar == null || (oVar instanceof a0.q)) {
            bVar.K();
            return;
        }
        boolean z2 = oVar instanceof a0.t;
        if (z2) {
            if (!z2) {
                throw new IllegalStateException("Not a JSON Primitive: " + oVar);
            }
            a0.t tVar = (a0.t) oVar;
            Serializable serializable = tVar.f19a;
            if (serializable instanceof Number) {
                bVar.Q(tVar.b());
                return;
            } else if (serializable instanceof Boolean) {
                bVar.S(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(tVar.c()));
                return;
            } else {
                bVar.R(tVar.c());
                return;
            }
        }
        boolean z3 = oVar instanceof a0.n;
        if (z3) {
            bVar.D();
            if (!z3) {
                throw new IllegalStateException("Not a JSON Array: " + oVar);
            }
            ArrayList arrayList = ((a0.n) oVar).f16a;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                e(bVar, (a0.o) obj);
            }
            bVar.G();
            return;
        }
        boolean z4 = oVar instanceof a0.r;
        if (!z4) {
            throw new IllegalArgumentException("Couldn't write " + oVar.getClass());
        }
        bVar.E();
        if (!z4) {
            throw new IllegalStateException("Not a JSON Object: " + oVar);
        }
        Iterator it = ((c0.n) ((a0.r) oVar).f18a.entrySet()).iterator();
        while (((c0.m) it).hasNext()) {
            c0.o oVarB = ((c0.m) it).b();
            bVar.I((String) oVarB.getKey());
            e(bVar, (a0.o) oVarB.getValue());
        }
        bVar.H();
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        a0.o nVar;
        a0.o nVar2;
        int iX = aVar.X();
        int iA = a0.u.a(iX);
        if (iA == 0) {
            aVar.a();
            nVar = new a0.n();
        } else if (iA != 2) {
            nVar = null;
        } else {
            aVar.D();
            nVar = new a0.r();
        }
        if (nVar == null) {
            return d(aVar, iX);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.K()) {
                String strR = nVar instanceof a0.r ? aVar.R() : null;
                int iX2 = aVar.X();
                int iA2 = a0.u.a(iX2);
                if (iA2 == 0) {
                    aVar.a();
                    nVar2 = new a0.n();
                } else if (iA2 != 2) {
                    nVar2 = null;
                } else {
                    aVar.D();
                    nVar2 = new a0.r();
                }
                boolean z2 = nVar2 != null;
                if (nVar2 == null) {
                    nVar2 = d(aVar, iX2);
                }
                if (nVar instanceof a0.n) {
                    ((a0.n) nVar).f16a.add(nVar2);
                } else {
                    ((a0.r) nVar).f18a.put(strR, nVar2);
                }
                if (z2) {
                    arrayDeque.addLast(nVar);
                    nVar = nVar2;
                }
            } else {
                if (nVar instanceof a0.n) {
                    aVar.G();
                } else {
                    aVar.H();
                }
                if (arrayDeque.isEmpty()) {
                    return nVar;
                }
                nVar = (a0.o) arrayDeque.removeLast();
            }
        }
    }

    @Override // a0.b0
    public final /* bridge */ /* synthetic */ void c(i0.b bVar, Object obj) {
        e(bVar, (a0.o) obj);
    }
}
