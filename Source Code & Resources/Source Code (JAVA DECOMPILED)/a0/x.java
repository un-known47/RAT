package a0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public enum x extends z {
    public x() {
        super("LONG_OR_DOUBLE", 2);
    }

    public static Double b(String str, i0.a aVar) throws NumberFormatException, i0.c {
        try {
            Double dValueOf = Double.valueOf(str);
            if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                if (aVar.o != 1) {
                    throw new i0.c("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.J(true));
                }
            }
            return dValueOf;
        } catch (NumberFormatException e2) {
            StringBuilder sbS = androidx.appcompat.app.g.s("Cannot parse ", str, "; at path ");
            sbS.append(aVar.J(true));
            throw new s(sbS.toString(), e2);
        }
    }

    @Override // a0.z
    public final Number a(i0.a aVar) throws IOException {
        String strV = aVar.V();
        if (strV.indexOf(46) >= 0) {
            return b(strV, aVar);
        }
        try {
            return Long.valueOf(Long.parseLong(strV));
        } catch (NumberFormatException unused) {
            return b(strV, aVar);
        }
    }
}
