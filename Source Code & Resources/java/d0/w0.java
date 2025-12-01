package d0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class w0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        try {
            int iP = aVar.P();
            if (iP <= 65535 && iP >= -32768) {
                return Short.valueOf((short) iP);
            }
            StringBuilder sbQ = androidx.appcompat.app.g.q("Lossy conversion from ", iP, " to short; at path ");
            sbQ.append(aVar.J(true));
            throw new a0.p(sbQ.toString());
        } catch (NumberFormatException e2) {
            throw new a0.p(e2);
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            bVar.K();
        } else {
            bVar.P(r4.shortValue());
        }
    }
}
