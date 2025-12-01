package k;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import androidx.core.os.EnvironmentCompat;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b0 implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f702a;

    public /* synthetic */ b0(c0 c0Var) {
        this.f702a = c0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f702a.f710a) {
                try {
                    z zVar = (z) message.obj;
                    a0 a0Var = (a0) this.f702a.f710a.get(zVar);
                    if (a0Var != null && a0Var.f697a.isEmpty()) {
                        if (a0Var.c) {
                            a0Var.f701g.c.removeMessages(1, a0Var.f699e);
                            c0 c0Var = a0Var.f701g;
                            c0Var.d.a(c0Var.f711b, a0Var);
                            a0Var.c = false;
                            a0Var.f698b = 2;
                        }
                        this.f702a.f710a.remove(zVar);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i2 != 1) {
            return false;
        }
        synchronized (this.f702a.f710a) {
            try {
                z zVar2 = (z) message.obj;
                a0 a0Var2 = (a0) this.f702a.f710a.get(zVar2);
                if (a0Var2 != null && a0Var2.f698b == 3) {
                    String.valueOf(zVar2);
                    new Exception();
                    ComponentName componentName = a0Var2.f700f;
                    if (componentName == null) {
                        zVar2.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = zVar2.f774b;
                        s.b(str);
                        componentName = new ComponentName(str, EnvironmentCompat.MEDIA_UNKNOWN);
                    }
                    a0Var2.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
