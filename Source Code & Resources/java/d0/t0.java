package d0;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class t0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        int iX = aVar.X();
        if (iX != 9) {
            return iX == 6 ? Boolean.valueOf(Boolean.parseBoolean(aVar.V())) : Boolean.valueOf(aVar.N());
        }
        aVar.T();
        return null;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            bVar.K();
            return;
        }
        bVar.T();
        bVar.a();
        bVar.f672a.write(bool.booleanValue() ? "true" : "false");
    }
}
