package androidx.lifecycle;

import h1.a1;
import h1.b0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.internal.k;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        j.e(lifecycle, "<this>");
        while (true) {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl != null) {
                return lifecycleCoroutineScopeImpl;
            }
            a1 a1Var = new a1();
            kotlinx.coroutines.scheduling.d dVar = b0.f530a;
            i1.c context = k.f813a.c;
            j.e(context, "context");
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = new LifecycleCoroutineScopeImpl(lifecycle, p.a.J(a1Var, context));
            AtomicReference<Object> internalScopeRef = lifecycle.getInternalScopeRef();
            while (!internalScopeRef.compareAndSet(null, lifecycleCoroutineScopeImpl2)) {
                if (internalScopeRef.get() != null) {
                    break;
                }
            }
            lifecycleCoroutineScopeImpl2.register();
            return lifecycleCoroutineScopeImpl2;
        }
    }
}
