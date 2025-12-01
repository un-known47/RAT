package d0;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends a0.b0 {
    public static final a c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Class f389a;

    /* renamed from: b, reason: collision with root package name */
    public final m f390b;

    public b(a0.m mVar, a0.b0 b0Var, Class cls) {
        this.f390b = new m(mVar, b0Var, cls);
        this.f389a = cls;
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.K()) {
            arrayList.add(this.f390b.c.b(aVar));
        }
        aVar.G();
        int size = arrayList.size();
        Class cls = this.f389a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            bVar.K();
            return;
        }
        bVar.D();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f390b.c(bVar, Array.get(obj, i2));
        }
        bVar.G();
    }
}
