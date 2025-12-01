package androidx.graphics.shapes;

import kotlin.jvm.internal.k;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class FeatureMappingKt$featureMapper$2$1$2 extends k implements l {
    final /* synthetic */ int $N;
    final /* synthetic */ DoubleMapper $dm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureMappingKt$featureMapper$2$1$2(DoubleMapper doubleMapper, int i2) {
        super(1);
        this.$dm = doubleMapper;
        this.$N = i2;
    }

    @Override // y0.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final CharSequence invoke(int i2) {
        return Format_jvmKt.toStringWithLessPrecision(this.$dm.mapBack(i2 / this.$N));
    }
}
