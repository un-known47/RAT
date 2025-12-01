package k;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f707g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static c0 f708h;

    /* renamed from: i, reason: collision with root package name */
    public static HandlerThread f709i;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f710a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f711b;
    public volatile r.e c;
    public final n.a d;

    /* renamed from: e, reason: collision with root package name */
    public final long f712e;

    /* renamed from: f, reason: collision with root package name */
    public final long f713f;

    public c0(Context context, Looper looper) {
        b0 b0Var = new b0(this);
        this.f711b = context.getApplicationContext();
        r.e eVar = new r.e(looper, b0Var);
        Looper.getMainLooper();
        this.c = eVar;
        if (n.a.f873b == null) {
            synchronized (n.a.f872a) {
                try {
                    if (n.a.f873b == null) {
                        n.a aVar = new n.a();
                        new ConcurrentHashMap();
                        n.a.f873b = aVar;
                    }
                } finally {
                }
            }
        }
        n.a aVar2 = n.a.f873b;
        s.b(aVar2);
        this.d = aVar2;
        this.f712e = 5000L;
        this.f713f = 300000L;
    }

    public static HandlerThread a() {
        synchronized (f707g) {
            try {
                HandlerThread handlerThread = f709i;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f709i = handlerThread2;
                handlerThread2.start();
                return f709i;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(String str, ServiceConnection serviceConnection, boolean z2) {
        z zVar = new z(str, z2);
        s.c(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f710a) {
            try {
                a0 a0Var = (a0) this.f710a.get(zVar);
                if (a0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(zVar.toString()));
                }
                if (!a0Var.f697a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(zVar.toString()));
                }
                a0Var.f697a.remove(serviceConnection);
                if (a0Var.f697a.isEmpty()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, zVar), this.f712e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c(z zVar, v vVar, String str) {
        boolean z2;
        synchronized (this.f710a) {
            try {
                a0 a0Var = (a0) this.f710a.get(zVar);
                if (a0Var == null) {
                    a0Var = new a0(this, zVar);
                    a0Var.f697a.put(vVar, vVar);
                    a0Var.a(str, null);
                    this.f710a.put(zVar, a0Var);
                } else {
                    this.c.removeMessages(0, zVar);
                    if (a0Var.f697a.containsKey(vVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(zVar.toString()));
                    }
                    a0Var.f697a.put(vVar, vVar);
                    int i2 = a0Var.f698b;
                    if (i2 == 1) {
                        vVar.onServiceConnected(a0Var.f700f, a0Var.d);
                    } else if (i2 == 2) {
                        a0Var.a(str, null);
                    }
                }
                z2 = a0Var.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z2;
    }
}
