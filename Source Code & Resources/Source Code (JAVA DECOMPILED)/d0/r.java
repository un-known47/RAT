package d0;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class r extends a0.b0 {

    /* renamed from: a, reason: collision with root package name */
    public final t f419a;

    public r(t tVar) {
        this.f419a = tVar;
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        Object objD = d();
        Map map = this.f419a.f423a;
        try {
            aVar.D();
            while (aVar.K()) {
                q qVar = (q) map.get(aVar.R());
                if (qVar == null) {
                    aVar.d0();
                } else {
                    f(objD, aVar, qVar);
                }
            }
            aVar.H();
            return e(objD);
        } catch (IllegalAccessException e2) {
            p.a aVar2 = f0.c.f457a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
        } catch (IllegalStateException e3) {
            throw new a0.p(e3);
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            bVar.K();
            return;
        }
        bVar.E();
        try {
            Iterator it = this.f419a.f424b.iterator();
            while (it.hasNext()) {
                ((q) it.next()).a(bVar, obj);
            }
            bVar.H();
        } catch (IllegalAccessException e2) {
            p.a aVar = f0.c.f457a;
            throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
        }
    }

    public abstract Object d();

    public abstract Object e(Object obj);

    public abstract void f(Object obj, i0.a aVar, q qVar);
}
