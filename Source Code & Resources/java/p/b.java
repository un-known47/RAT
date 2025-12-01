package p;

import android.content.Context;
import i.o;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f983b;

    /* renamed from: a, reason: collision with root package name */
    public o f984a;

    static {
        b bVar = new b();
        bVar.f984a = null;
        f983b = bVar;
    }

    public static o a(Context context) {
        o oVar;
        b bVar = f983b;
        synchronized (bVar) {
            try {
                if (bVar.f984a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    bVar.f984a = new o(4, context);
                }
                oVar = bVar.f984a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }
}
