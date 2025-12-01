package d0;

import java.io.IOException;
import java.math.BigInteger;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class e0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        String strV = aVar.V();
        try {
            c0.i.c(strV);
            return new BigInteger(strV);
        } catch (NumberFormatException e2) {
            StringBuilder sbS = androidx.appcompat.app.g.s("Failed parsing '", strV, "' as BigInteger; at path ");
            sbS.append(aVar.J(true));
            throw new a0.p(sbS.toString(), e2);
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        bVar.Q((BigInteger) obj);
    }
}
