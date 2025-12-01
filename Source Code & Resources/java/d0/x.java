package d0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class x extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.K()) {
            try {
                arrayList.add(Integer.valueOf(aVar.P()));
            } catch (NumberFormatException e2) {
                throw new a0.p(e2);
            }
        }
        aVar.G();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        bVar.D();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i2 = 0; i2 < length; i2++) {
            bVar.P(r6.get(i2));
        }
        bVar.G();
    }
}
