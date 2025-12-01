package d0;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends a0.b0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f391a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f392b;
    public final Object c;

    public c(m mVar, c0.q qVar) {
        this.f392b = mVar;
        this.c = qVar;
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        switch (this.f391a) {
            case 0:
                if (aVar.X() == 9) {
                    aVar.T();
                    return null;
                }
                Collection collection = (Collection) ((c0.q) this.c).a();
                aVar.a();
                while (aVar.K()) {
                    collection.add(((m) this.f392b).c.b(aVar));
                }
                aVar.G();
                return collection;
            default:
                Class cls = (Class) this.f392b;
                Object objB = ((q0) this.c).c.b(aVar);
                if (objB == null || cls.isInstance(objB)) {
                    return objB;
                }
                throw new a0.p("Expected a " + cls.getName() + " but was " + objB.getClass().getName() + "; at path " + aVar.J(true));
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        switch (this.f391a) {
            case 0:
                Collection collection = (Collection) obj;
                if (collection != null) {
                    bVar.D();
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        ((m) this.f392b).c(bVar, it.next());
                    }
                    bVar.G();
                    break;
                } else {
                    bVar.K();
                    break;
                }
            default:
                ((q0) this.c).c.c(bVar, obj);
                break;
        }
    }

    public c(q0 q0Var, Class cls) {
        this.c = q0Var;
        this.f392b = cls;
    }
}
