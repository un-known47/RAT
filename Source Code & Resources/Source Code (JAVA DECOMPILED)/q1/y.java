package q1;

import java.io.IOException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class y extends o1.x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f1159a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, o1.n nVar) {
        super(nVar);
        this.f1159a = zVar;
    }

    @Override // o1.x, o1.p0
    public final long read(o1.l lVar, long j) throws IOException {
        try {
            return super.read(lVar, j);
        } catch (IOException e2) {
            this.f1159a.c = e2;
            throw e2;
        }
    }
}
