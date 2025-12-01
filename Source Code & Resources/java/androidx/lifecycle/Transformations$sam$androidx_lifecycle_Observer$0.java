package androidx.lifecycle;

import kotlin.jvm.internal.j;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, kotlin.jvm.internal.f {
    private final /* synthetic */ l function;

    public Transformations$sam$androidx_lifecycle_Observer$0(l function) {
        j.e(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof kotlin.jvm.internal.f)) {
            return j.a(getFunctionDelegate(), ((kotlin.jvm.internal.f) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.f
    public final l0.a getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
