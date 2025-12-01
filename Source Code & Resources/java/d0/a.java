package d0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class a implements a0.c0 {
    @Override // a0.c0
    public final a0.b0 a(a0.m mVar, h0.a aVar) {
        Type type = aVar.f526b;
        boolean z2 = type instanceof GenericArrayType;
        if (!z2 && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type genericComponentType = z2 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
        return new b(mVar, mVar.b(new h0.a(genericComponentType)), c0.i.g(genericComponentType));
    }
}
