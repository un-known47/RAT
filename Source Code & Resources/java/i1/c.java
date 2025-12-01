package i1;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.g;
import h1.b0;
import h1.n0;
import h1.p;
import h1.q;
import h1.u0;
import h1.x;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.k;
import p0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends p implements x {
    private volatile c _immediate;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f680a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f681b;
    public final c c;

    public c(Handler handler, boolean z2) {
        this.f680a = handler;
        this.f681b = z2;
        this._immediate = z2 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, true);
            this._immediate = cVar;
        }
        this.c = cVar;
    }

    @Override // h1.p
    public final void dispatch(i iVar, Runnable runnable) {
        if (this.f680a.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        n0 n0Var = (n0) iVar.get(q.f562b);
        if (n0Var != null) {
            ((u0) n0Var).e(cancellationException);
        }
        b0.f531b.dispatch(iVar, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f680a == this.f680a;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f680a);
    }

    @Override // h1.p
    public final boolean isDispatchNeeded(i iVar) {
        return (this.f681b && j.a(Looper.myLooper(), this.f680a.getLooper())) ? false : true;
    }

    @Override // h1.p
    public p limitedParallelism(int i2) {
        kotlinx.coroutines.internal.b.a(i2);
        return this;
    }

    @Override // h1.p
    public final String toString() {
        c cVar;
        String str;
        kotlinx.coroutines.scheduling.d dVar = b0.f530a;
        c cVar2 = k.f813a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.c;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f680a.toString();
        return this.f681b ? g.h(string, ".immediate") : string;
    }
}
