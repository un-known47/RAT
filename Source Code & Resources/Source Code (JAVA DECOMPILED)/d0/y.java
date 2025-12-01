package d0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class y extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        try {
            return Long.valueOf(aVar.Q());
        } catch (NumberFormatException e2) {
            throw new a0.p(e2);
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            bVar.K();
        } else {
            bVar.P(number.longValue());
        }
    }
}
