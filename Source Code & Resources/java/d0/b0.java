package d0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class b0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        String strV = aVar.V();
        if (strV.length() == 1) {
            return Character.valueOf(strV.charAt(0));
        }
        StringBuilder sbS = androidx.appcompat.app.g.s("Expecting character, got: ", strV, "; at ");
        sbS.append(aVar.J(true));
        throw new a0.p(sbS.toString());
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        Character ch = (Character) obj;
        bVar.R(ch == null ? null : String.valueOf(ch));
    }
}
