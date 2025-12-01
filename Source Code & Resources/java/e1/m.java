package e1;

import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class m implements i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f445a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f446b;

    public /* synthetic */ m(int i2, Object obj) {
        this.f445a = i2;
        this.f446b = obj;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [r0.h, y0.p] */
    @Override // e1.i
    public final Iterator iterator() {
        switch (this.f445a) {
            case 0:
                return p.a.F((r0.h) this.f446b);
            case 1:
                return (Iterator) this.f446b;
            default:
                return ((Iterable) this.f446b).iterator();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(y0.p pVar) {
        this.f445a = 0;
        this.f446b = (r0.h) pVar;
    }
}
