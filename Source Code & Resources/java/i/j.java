package i;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArraySet;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f611b;
    public final AtomicReference c;
    public final r.e d;

    /* renamed from: e, reason: collision with root package name */
    public final g.d f612e;

    /* renamed from: f, reason: collision with root package name */
    public final ArraySet f613f;

    /* renamed from: g, reason: collision with root package name */
    public final c f614g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(e eVar, c cVar) {
        super(eVar);
        g.d dVar = g.d.c;
        this.c = new AtomicReference(null);
        this.d = new r.e(Looper.getMainLooper(), 0);
        this.f612e = dVar;
        this.f613f = new ArraySet();
        this.f614g = cVar;
        eVar.b(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void b(int i2, int i3, Intent intent) {
        AtomicReference atomicReference = this.c;
        c0 c0Var = (c0) atomicReference.get();
        c cVar = this.f614g;
        if (i2 != 1) {
            if (i2 == 2) {
                int iB = this.f612e.b(a(), g.e.f486a);
                if (iB == 0) {
                    atomicReference.set(null);
                    r.e eVar = cVar.f604n;
                    eVar.sendMessage(eVar.obtainMessage(3));
                    return;
                } else {
                    if (c0Var == null) {
                        return;
                    }
                    if (c0Var.f606b.f480b == 18 && iB == 18) {
                        return;
                    }
                }
            }
        } else if (i3 == -1) {
            atomicReference.set(null);
            r.e eVar2 = cVar.f604n;
            eVar2.sendMessage(eVar2.obtainMessage(3));
            return;
        } else if (i3 == 0) {
            if (c0Var != null) {
                g.a aVar = new g.a(1, intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, c0Var.f606b.toString());
                int i4 = c0Var.f605a;
                atomicReference.set(null);
                cVar.g(aVar, i4);
                return;
            }
            return;
        }
        if (c0Var != null) {
            g.a aVar2 = c0Var.f606b;
            int i5 = c0Var.f605a;
            atomicReference.set(null);
            cVar.g(aVar2, i5);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void c(Bundle bundle) {
        if (bundle != null) {
            this.c.set(bundle.getBoolean("resolving_error", false) ? new c0(new g.a(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void d() {
        if (this.f613f.isEmpty()) {
            return;
        }
        this.f614g.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e(Bundle bundle) {
        c0 c0Var = (c0) this.c.get();
        if (c0Var == null) {
            return;
        }
        g.a aVar = c0Var.f606b;
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", c0Var.f605a);
        bundle.putInt("failed_status", aVar.f480b);
        bundle.putParcelable("failed_resolution", aVar.c);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void f() {
        this.f611b = true;
        if (this.f613f.isEmpty()) {
            return;
        }
        this.f614g.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void g() {
        this.f611b = false;
        c cVar = this.f614g;
        cVar.getClass();
        synchronized (c.f592r) {
            try {
                if (cVar.f601k == this) {
                    cVar.f601k = null;
                    cVar.f602l.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        g.a aVar = new g.a(13, null);
        AtomicReference atomicReference = this.c;
        c0 c0Var = (c0) atomicReference.get();
        int i2 = c0Var == null ? -1 : c0Var.f605a;
        atomicReference.set(null);
        this.f614g.g(aVar, i2);
    }
}
