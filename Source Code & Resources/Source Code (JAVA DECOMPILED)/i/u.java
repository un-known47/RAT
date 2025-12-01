package i;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class u extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public Context f642a;

    /* renamed from: b, reason: collision with root package name */
    public final h.c f643b;

    public u(h.c cVar) {
        this.f643b = cVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            h.c cVar = this.f643b;
            j jVar = (j) ((r) cVar.c).c;
            jVar.c.set(null);
            r.e eVar = jVar.f614g.f604n;
            eVar.sendMessage(eVar.obtainMessage(3));
            AlertDialog alertDialog = (AlertDialog) cVar.f514b;
            if (alertDialog.isShowing()) {
                alertDialog.dismiss();
            }
            synchronized (this) {
                try {
                    Context context2 = this.f642a;
                    if (context2 != null) {
                        context2.unregisterReceiver(this);
                    }
                    this.f642a = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
