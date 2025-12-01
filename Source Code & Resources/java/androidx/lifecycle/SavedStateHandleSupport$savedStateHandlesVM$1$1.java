package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class SavedStateHandleSupport$savedStateHandlesVM$1$1 extends k implements l {
    public static final SavedStateHandleSupport$savedStateHandlesVM$1$1 INSTANCE = new SavedStateHandleSupport$savedStateHandlesVM$1$1();

    public SavedStateHandleSupport$savedStateHandlesVM$1$1() {
        super(1);
    }

    @Override // y0.l
    public final SavedStateHandlesVM invoke(CreationExtras initializer) {
        j.e(initializer, "$this$initializer");
        return new SavedStateHandlesVM();
    }
}
