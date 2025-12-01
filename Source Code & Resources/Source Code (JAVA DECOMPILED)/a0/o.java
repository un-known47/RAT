package a0;

import d0.a1;
import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class o {
    public final String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            i0.b bVar = new i0.b(new c0.s(sb));
            bVar.f677h = 1;
            a1.f388z.getClass();
            d0.l.e(bVar, this);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
