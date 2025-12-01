package g0;

import a0.b0;
import java.sql.Timestamp;
import java.util.Date;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public static final c f504b = new c();

    /* renamed from: a, reason: collision with root package name */
    public final b0 f505a;

    public d(b0 b0Var) {
        this.f505a = b0Var;
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) {
        Date date = (Date) this.f505a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) {
        this.f505a.c(bVar, (Timestamp) obj);
    }
}
