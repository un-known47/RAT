package l0;

import java.io.Serializable;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class g implements c, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public y0.a f853a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f854b = h.f855a;
    public final Object c = this;

    public g(y0.a aVar) {
        this.f853a = aVar;
    }

    @Override // l0.c
    public final Object getValue() {
        Object objInvoke;
        Object obj = this.f854b;
        h hVar = h.f855a;
        if (obj != hVar) {
            return obj;
        }
        synchronized (this.c) {
            objInvoke = this.f854b;
            if (objInvoke == hVar) {
                y0.a aVar = this.f853a;
                j.b(aVar);
                objInvoke = aVar.invoke();
                this.f854b = objInvoke;
                this.f853a = null;
            }
        }
        return objInvoke;
    }

    public final String toString() {
        return this.f854b != h.f855a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
