package k;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class h implements b {

    /* renamed from: b, reason: collision with root package name */
    public static h f740b;
    public static final i c = new i(0, false, false, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public Object f741a;

    public /* synthetic */ h(Object obj) {
        this.f741a = obj;
    }

    public static synchronized h b() {
        try {
            if (f740b == null) {
                f740b = new h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f740b;
    }

    @Override // k.b
    public void a(g.a aVar) {
        x.a aVar2 = (x.a) this.f741a;
        if (aVar.f480b == 0) {
            aVar2.b(null, aVar2.f250w);
            return;
        }
        h hVar = aVar2.o;
        if (hVar != null) {
            ((h.h) hVar.f741a).c(aVar);
        }
    }
}
