package d0;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i extends a0.b0 {
    public static final h d = new h();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f398a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f399b = new HashMap();
    public final HashMap c = new HashMap();

    public i(Class cls) throws SecurityException {
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i2 = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    declaredFields[i2] = field;
                    i2++;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i2);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r4 = (Enum) field2.get(null);
                String strName = r4.name();
                String string = r4.toString();
                b0.b bVar = (b0.b) field2.getAnnotation(b0.b.class);
                if (bVar != null) {
                    strName = bVar.value();
                    for (String str : bVar.alternate()) {
                        this.f398a.put(str, r4);
                    }
                }
                this.f398a.put(strName, r4);
                this.f399b.put(string, r4);
                this.c.put(r4, strName);
            }
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        String strV = aVar.V();
        Enum r02 = (Enum) this.f398a.get(strV);
        return r02 == null ? (Enum) this.f399b.get(strV) : r02;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        Enum r3 = (Enum) obj;
        bVar.R(r3 == null ? null : (String) this.c.get(r3));
    }
}
