package d0;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class k0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        if (aVar.X() == 9) {
            aVar.T();
            return null;
        }
        try {
            String strV = aVar.V();
            if (strV.equals("null")) {
                return null;
            }
            return new URI(strV);
        } catch (URISyntaxException e2) {
            throw new a0.p(e2);
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        URI uri = (URI) obj;
        bVar.R(uri == null ? null : uri.toASCIIString());
    }
}
