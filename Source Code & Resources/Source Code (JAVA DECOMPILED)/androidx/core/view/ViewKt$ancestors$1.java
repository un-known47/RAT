package androidx.core.view;

import android.view.ViewParent;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends kotlin.jvm.internal.i implements y0.l {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, kotlin.jvm.internal.b.NO_RECEIVER, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;");
    }

    @Override // y0.l
    public final ViewParent invoke(ViewParent viewParent) {
        return viewParent.getParent();
    }
}
