package androidx.graphics.shapes;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer pointTransformer, int i2) {
        int i3 = i2 + 1;
        long jMo60transformXgqJiTY = pointTransformer.mo60transformXgqJiTY(getPoints$graphics_shapes_release()[i2], getPoints$graphics_shapes_release()[i3]);
        getPoints$graphics_shapes_release()[i2] = Float.intBitsToFloat((int) (jMo60transformXgqJiTY >> 32));
        getPoints$graphics_shapes_release()[i3] = Float.intBitsToFloat((int) (jMo60transformXgqJiTY & 4294967295L));
    }

    public final void interpolate(Cubic c12, Cubic c2, float f2) {
        j.e(c12, "c1");
        j.e(c2, "c2");
        for (int i2 = 0; i2 < 8; i2++) {
            getPoints$graphics_shapes_release()[i2] = Utils.interpolate(c12.getPoints$graphics_shapes_release()[i2], c2.getPoints$graphics_shapes_release()[i2], f2);
        }
    }

    public final void transform(PointTransformer f2) {
        j.e(f2, "f");
        transformOnePoint(f2, 0);
        transformOnePoint(f2, 2);
        transformOnePoint(f2, 4);
        transformOnePoint(f2, 6);
    }
}
