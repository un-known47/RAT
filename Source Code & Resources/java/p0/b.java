package p0;

import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f985a;

    public /* synthetic */ b(int i2) {
        this.f985a = i2;
    }

    @Override // y0.p
    public final Object invoke(Object obj, Object obj2) {
        c cVar;
        switch (this.f985a) {
            case 0:
                String acc = (String) obj;
                g element = (g) obj2;
                kotlin.jvm.internal.j.e(acc, "acc");
                kotlin.jvm.internal.j.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            default:
                i acc2 = (i) obj;
                g element2 = (g) obj2;
                kotlin.jvm.internal.j.e(acc2, "acc");
                kotlin.jvm.internal.j.e(element2, "element");
                i iVarMinusKey = acc2.minusKey(element2.getKey());
                j jVar = j.f989a;
                if (iVarMinusKey == jVar) {
                    return element2;
                }
                e eVar = e.f988a;
                f fVar = (f) iVarMinusKey.get(eVar);
                if (fVar == null) {
                    cVar = new c(iVarMinusKey, element2);
                } else {
                    i iVarMinusKey2 = iVarMinusKey.minusKey(eVar);
                    if (iVarMinusKey2 == jVar) {
                        return new c(element2, fVar);
                    }
                    cVar = new c(new c(iVarMinusKey2, element2), fVar);
                }
                return cVar;
        }
    }
}
