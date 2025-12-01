package androidx.activity.contextaware;

import android.content.Context;
import h1.d;
import h1.e;
import kotlin.jvm.internal.j;
import p.a;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ d $co;
    final /* synthetic */ l $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(d dVar, l lVar) {
        this.$co = dVar;
        this.$onContextAvailable = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object objP;
        j.e(context, "context");
        d dVar = this.$co;
        try {
            objP = this.$onContextAvailable.invoke(context);
        } catch (Throwable th) {
            objP = a.p(th);
        }
        ((e) dVar).resumeWith(objP);
    }
}
