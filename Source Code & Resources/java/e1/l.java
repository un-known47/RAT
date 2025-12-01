package e1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class l extends p.a {
    public static Object g0(g gVar) {
        f fVar = new f(gVar);
        if (fVar.hasNext()) {
            return fVar.next();
        }
        return null;
    }

    public static i h0(Object obj, y0.l nextFunction) {
        kotlin.jvm.internal.j.e(nextFunction, "nextFunction");
        return obj == null ? e.f436a : new g(new n(0, obj), nextFunction);
    }

    public static g i0(i iVar, y0.l transform) {
        kotlin.jvm.internal.j.e(transform, "transform");
        return new g(new g(iVar, transform), new o());
    }

    public static List j0(i iVar) {
        Iterator it = iVar.iterator();
        if (!it.hasNext()) {
            return m0.q.f867a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return p.a.G(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
