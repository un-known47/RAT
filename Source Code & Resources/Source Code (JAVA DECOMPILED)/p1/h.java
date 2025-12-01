package p1;

import java.io.IOException;
import o1.p0;
import o1.x;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h extends x {

    /* renamed from: a, reason: collision with root package name */
    public final long f1013a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1014b;
    public long c;

    public h(p0 p0Var, long j, boolean z2) {
        super(p0Var);
        this.f1013a = j;
        this.f1014b = z2;
    }

    @Override // o1.x, o1.p0
    public final long read(o1.l sink, long j) throws IOException {
        kotlin.jvm.internal.j.e(sink, "sink");
        long j2 = this.c;
        long j3 = this.f1013a;
        if (j2 > j3) {
            j = 0;
        } else if (this.f1014b) {
            long j4 = j3 - j2;
            if (j4 == 0) {
                return -1L;
            }
            j = Math.min(j, j4);
        }
        long j5 = super.read(sink, j);
        if (j5 != -1) {
            this.c += j5;
        }
        long j6 = this.c;
        if ((j6 >= j3 || j5 != -1) && j6 <= j3) {
            return j5;
        }
        if (j5 > 0 && j6 > j3) {
            long j7 = sink.f919b - (j6 - j3);
            o1.l lVar = new o1.l();
            lVar.f(sink);
            sink.write(lVar, j7);
            lVar.a();
        }
        throw new IOException("expected " + j3 + " bytes but got " + this.c);
    }
}
