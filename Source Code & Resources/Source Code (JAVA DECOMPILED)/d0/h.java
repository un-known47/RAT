package d0;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class h implements a0.c0 {
    @Override // a0.c0
    public final a0.b0 a(a0.m mVar, h0.a aVar) {
        Class superclass = aVar.f525a;
        if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
            return null;
        }
        if (!superclass.isEnum()) {
            superclass = superclass.getSuperclass();
        }
        return new i(superclass);
    }
}
