package d0;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class z0 extends a0.b0 {
    @Override // a0.b0
    public final Object b(i0.a aVar) {
        return new AtomicBoolean(aVar.N());
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        bVar.S(((AtomicBoolean) obj).get());
    }
}
