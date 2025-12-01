package i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public g.c[] f609a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f610b;
    public int c;
    public Object d;

    public i a() {
        if (!(((h) this.d) != null)) {
            throw new IllegalArgumentException("execute parameter required");
        }
        g.c[] cVarArr = this.f609a;
        boolean z2 = this.f610b;
        int i2 = this.c;
        i iVar = new i();
        iVar.d = this;
        iVar.f609a = cVarArr;
        boolean z3 = false;
        if (cVarArr != null && z2) {
            z3 = true;
        }
        iVar.f610b = z3;
        iVar.c = i2;
        return iVar;
    }
}
