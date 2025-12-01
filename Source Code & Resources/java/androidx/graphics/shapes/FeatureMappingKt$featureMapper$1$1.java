package androidx.graphics.shapes;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import l0.d;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class FeatureMappingKt$featureMapper$1$1 extends k implements l {
    public static final FeatureMappingKt$featureMapper$1$1 INSTANCE = new FeatureMappingKt$featureMapper$1$1();

    public FeatureMappingKt$featureMapper$1$1() {
        super(1);
    }

    @Override // y0.l
    public final CharSequence invoke(d it) {
        j.e(it, "it");
        return ((Number) it.f850a).floatValue() + " -> " + ((Number) it.f851b).floatValue();
    }
}
