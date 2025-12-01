package d0;

import java.io.IOException;
import java.util.BitSet;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class r0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException, NumberFormatException {
        boolean zN;
        BitSet bitSet = new BitSet();
        aVar.a();
        int iX = aVar.X();
        int i2 = 0;
        while (iX != 2) {
            int iA = a0.u.a(iX);
            if (iA == 5 || iA == 6) {
                int iP = aVar.P();
                if (iP == 0) {
                    zN = false;
                } else {
                    if (iP != 1) {
                        StringBuilder sbQ = androidx.appcompat.app.g.q("Invalid bitset value ", iP, ", expected 0 or 1; at path ");
                        sbQ.append(aVar.J(true));
                        throw new a0.p(sbQ.toString());
                    }
                    zN = true;
                }
            } else {
                if (iA != 7) {
                    throw new a0.p("Invalid bitset value type: " + androidx.appcompat.app.g.w(iX) + "; at path " + aVar.J(false));
                }
                zN = aVar.N();
            }
            if (zN) {
                bitSet.set(i2);
            }
            i2++;
            iX = aVar.X();
        }
        aVar.G();
        return bitSet;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        bVar.D();
        int length = bitSet.length();
        for (int i2 = 0; i2 < length; i2++) {
            bVar.P(bitSet.get(i2) ? 1L : 0L);
        }
        bVar.G();
    }
}
