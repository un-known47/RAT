package p0;

import java.io.Serializable;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final i f986a;

    /* renamed from: b, reason: collision with root package name */
    public final g f987b;

    public c(i left, g element) {
        kotlin.jvm.internal.j.e(left, "left");
        kotlin.jvm.internal.j.e(element, "element");
        this.f986a = left;
        this.f987b = element;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            int i2 = 2;
            c cVar2 = cVar;
            int i3 = 2;
            while (true) {
                i iVar = cVar2.f986a;
                cVar2 = iVar instanceof c ? (c) iVar : null;
                if (cVar2 == null) {
                    break;
                }
                i3++;
            }
            c cVar3 = this;
            while (true) {
                i iVar2 = cVar3.f986a;
                cVar3 = iVar2 instanceof c ? (c) iVar2 : null;
                if (cVar3 == null) {
                    break;
                }
                i2++;
            }
            if (i3 == i2) {
                c cVar4 = this;
                while (true) {
                    g gVar = cVar4.f987b;
                    if (!kotlin.jvm.internal.j.a(cVar.get(gVar.getKey()), gVar)) {
                        zA = false;
                        break;
                    }
                    i iVar3 = cVar4.f986a;
                    if (!(iVar3 instanceof c)) {
                        kotlin.jvm.internal.j.c(iVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        g gVar2 = (g) iVar3;
                        zA = kotlin.jvm.internal.j.a(cVar.get(gVar2.getKey()), gVar2);
                        break;
                    }
                    cVar4 = (c) iVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p0.i
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(this.f986a.fold(obj, pVar), this.f987b);
    }

    @Override // p0.i
    public final g get(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        c cVar = this;
        while (true) {
            g gVar = cVar.f987b.get(key);
            if (gVar != null) {
                return gVar;
            }
            i iVar = cVar.f986a;
            if (!(iVar instanceof c)) {
                return iVar.get(key);
            }
            cVar = (c) iVar;
        }
    }

    public final int hashCode() {
        return this.f987b.hashCode() + this.f986a.hashCode();
    }

    @Override // p0.i
    public final i minusKey(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        g gVar = this.f987b;
        g gVar2 = gVar.get(key);
        i iVar = this.f986a;
        if (gVar2 != null) {
            return iVar;
        }
        i iVarMinusKey = iVar.minusKey(key);
        return iVarMinusKey == iVar ? this : iVarMinusKey == j.f989a ? gVar : new c(iVarMinusKey, gVar);
    }

    @Override // p0.i
    public final i plus(i iVar) {
        return p.a.J(this, iVar);
    }

    public final String toString() {
        return "[" + ((String) fold("", new b(0))) + ']';
    }
}
