package a0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public enum y extends z {
    public y() {
        super("BIG_DECIMAL", 3);
    }

    @Override // a0.z
    public final Number a(i0.a aVar) throws IOException {
        String strV = aVar.V();
        try {
            return c0.i.i(strV);
        } catch (NumberFormatException e2) {
            StringBuilder sbS = androidx.appcompat.app.g.s("Cannot parse ", strV, "; at path ");
            sbS.append(aVar.J(true));
            throw new s(sbS.toString(), e2);
        }
    }
}
