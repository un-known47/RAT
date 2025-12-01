package androidx.graphics.shapes;

import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class AngleMeasurer implements Measurer {
    private final float centerX;
    private final float centerY;

    public AngleMeasurer(float f2, float f3) {
        this.centerX = f2;
        this.centerY = f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float findCubicCutPoint$lambda$1(Cubic c, AngleMeasurer this$0, float f2, float f3, float f4) {
        j.e(c, "$c");
        j.e(this$0, "this$0");
        long jM39pointOnCurveOOQOV4g$graphics_shapes_release = c.m39pointOnCurveOOQOV4g$graphics_shapes_release(f4);
        return Math.abs(Utils.positiveModulo(Utils.angle(PointKt.m51getXDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release) - this$0.centerX, PointKt.m52getYDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release) - this$0.centerY) - f2, Utils.getTwoPi()) - f3);
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(final Cubic c, final float f2) {
        j.e(c, "c");
        final float fAngle = Utils.angle(c.getAnchor0X() - this.centerX, c.getAnchor0Y() - this.centerY);
        return Utils.findMinimum(0.0f, 1.0f, 1.0E-5f, new FindMinimumFunction() { // from class: androidx.graphics.shapes.a
            @Override // androidx.graphics.shapes.FindMinimumFunction
            public final float invoke(float f3) {
                return AngleMeasurer.findCubicCutPoint$lambda$1(c, this, fAngle, f2, f3);
            }
        });
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(Cubic c) {
        j.e(c, "c");
        float fPositiveModulo = Utils.positiveModulo(Utils.angle(c.getAnchor1X() - this.centerX, c.getAnchor1Y() - this.centerY) - Utils.angle(c.getAnchor0X() - this.centerX, c.getAnchor0Y() - this.centerY), Utils.getTwoPi());
        if (fPositiveModulo > Utils.getTwoPi() - 1.0E-4f) {
            return 0.0f;
        }
        return fPositiveModulo;
    }
}
