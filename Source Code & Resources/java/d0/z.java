package d0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class z extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) {
        if (aVar.X() != 9) {
            return Float.valueOf((float) aVar.O());
        }
        aVar.T();
        return null;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        Number numberValueOf = (Number) obj;
        if (numberValueOf == null) {
            bVar.K();
            return;
        }
        if (!(numberValueOf instanceof Float)) {
            numberValueOf = Float.valueOf(numberValueOf.floatValue());
        }
        bVar.Q(numberValueOf);
    }
}
