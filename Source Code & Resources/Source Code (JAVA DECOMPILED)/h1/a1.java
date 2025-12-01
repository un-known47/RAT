package h1;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class a1 extends u0 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f528b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1() {
        super(true);
        boolean z2 = true;
        s(null);
        h hVarO = o();
        i iVar = hVarO instanceof i ? (i) hVarO : null;
        if (iVar == null) {
            z2 = false;
            break;
        }
        u0 u0VarK = iVar.k();
        while (!u0VarK.m()) {
            h hVarO2 = u0VarK.o();
            i iVar2 = hVarO2 instanceof i ? (i) hVarO2 : null;
            if (iVar2 == null) {
                z2 = false;
                break;
            }
            u0VarK = iVar2.k();
        }
        this.f528b = z2;
    }

    @Override // h1.u0
    public final boolean h(Throwable th) {
        return false;
    }

    @Override // h1.u0
    public final boolean m() {
        return this.f528b;
    }
}
