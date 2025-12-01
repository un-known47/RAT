package okhttp3.logging.internal;

import java.io.EOFException;
import kotlin.jvm.internal.j;
import o1.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class IsProbablyUtf8Kt {
    public static final boolean isProbablyUtf8(l lVar) {
        l lVar2;
        int i2;
        j.e(lVar, "<this>");
        try {
            lVar2 = new l();
            long j = lVar.f919b;
            long j2 = 64;
            if (j <= 64) {
                j2 = j;
            }
            lVar.G(0L, lVar2, j2);
        } catch (EOFException unused) {
        }
        for (i2 = 0; i2 < 16; i2++) {
            if (lVar2.q()) {
                return true;
            }
            int iQ = lVar2.Q();
            if (Character.isISOControl(iQ) && !Character.isWhitespace(iQ)) {
                return false;
            }
        }
        return true;
    }
}
