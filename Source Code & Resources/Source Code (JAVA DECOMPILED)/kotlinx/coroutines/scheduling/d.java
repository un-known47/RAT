package kotlinx.coroutines.scheduling;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: b, reason: collision with root package name */
    public static final d f835b;

    static {
        int i2 = k.f842b;
        int i3 = k.c;
        long j = k.d;
        d dVar = new d();
        dVar.f837a = new b(i2, j, i3);
        f835b = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // h1.p
    public final String toString() {
        return "Dispatchers.Default";
    }
}
