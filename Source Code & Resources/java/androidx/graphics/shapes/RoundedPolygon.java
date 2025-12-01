package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import l0.d;
import m0.k;
import m0.l;
import n0.c;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class RoundedPolygon {
    public static final Companion Companion = new Companion(null);
    private final float centerX;
    private final float centerY;
    private final List<Cubic> cubics;
    private final List<Feature> features;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RoundedPolygon(List<? extends Feature> features, float f2, float f3) {
        ArrayList arrayListI0;
        ArrayList arrayListI02;
        Cubic cubic;
        List<Cubic> cubics;
        j.e(features, "features");
        this.features = features;
        this.centerX = f2;
        this.centerY = f3;
        c cVarQ = p.a.q();
        int i2 = 0;
        Cubic cubic2 = null;
        if (features.size() <= 0 || ((Feature) features.get(0)).getCubics().size() != 3) {
            arrayListI0 = null;
            arrayListI02 = null;
        } else {
            d dVarSplit = ((Feature) features.get(0)).getCubics().get(1).split(0.5f);
            Cubic cubic3 = (Cubic) dVarSplit.f850a;
            Cubic cubic4 = (Cubic) dVarSplit.f851b;
            arrayListI02 = l.i0(((Feature) features.get(0)).getCubics().get(0), cubic3);
            arrayListI0 = l.i0(cubic4, ((Feature) features.get(0)).getCubics().get(2));
        }
        int size = features.size();
        if (size >= 0) {
            Cubic cubic5 = null;
            int i3 = 0;
            while (true) {
                if (i3 == 0 && arrayListI0 != null) {
                    cubics = arrayListI0;
                } else if (i3 != this.features.size()) {
                    cubics = this.features.get(i3).getCubics();
                } else if (arrayListI02 == null) {
                    break;
                } else {
                    cubics = arrayListI02;
                }
                int size2 = cubics.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Cubic cubic6 = cubics.get(i4);
                    if (!cubic6.zeroLength$graphics_shapes_release()) {
                        if (cubic5 != null) {
                            cVarQ.add(cubic5);
                        }
                        if (cubic2 == null) {
                            cubic2 = cubic6;
                            cubic5 = cubic2;
                        } else {
                            cubic5 = cubic6;
                        }
                    } else if (cubic5 != null) {
                        cubic5.getPoints$graphics_shapes_release()[6] = cubic6.getAnchor1X();
                        cubic5.getPoints$graphics_shapes_release()[7] = cubic6.getAnchor1Y();
                    }
                }
                if (i3 == size) {
                    break;
                } else {
                    i3++;
                }
            }
            cubic = cubic2;
            cubic2 = cubic5;
        } else {
            cubic = null;
        }
        if (cubic2 != null && cubic != null) {
            cVarQ.add(CubicKt.Cubic(cubic2.getAnchor0X(), cubic2.getAnchor0Y(), cubic2.getControl0X(), cubic2.getControl0Y(), cubic2.getControl1X(), cubic2.getControl1Y(), cubic.getAnchor0X(), cubic.getAnchor0Y()));
        }
        c cVarE = p.a.e(cVarQ);
        this.cubics = cVarE;
        Object obj = cVarE.get(cVarE.a() - 1);
        int iA = cVarE.a();
        while (i2 < iA) {
            Cubic cubic7 = this.cubics.get(i2);
            Cubic cubic8 = (Cubic) obj;
            if (Math.abs(cubic7.getAnchor0X() - cubic8.getAnchor1X()) > 1.0E-4f || Math.abs(cubic7.getAnchor0Y() - cubic8.getAnchor1Y()) > 1.0E-4f) {
                throw new IllegalArgumentException("RoundedPolygon must be contiguous, with the anchor points of all curves matching the anchor points of the preceding and succeeding cubics");
            }
            i2++;
            obj = cubic7;
        }
    }

    public static /* synthetic */ float[] calculateBounds$default(RoundedPolygon roundedPolygon, float[] fArr, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return roundedPolygon.calculateBounds(fArr, z2);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(RoundedPolygon roundedPolygon, float[] fArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        return roundedPolygon.calculateMaxBounds(fArr);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        j.e(bounds, "bounds");
        if (bounds.length < 4) {
            throw new IllegalArgumentException("Required bounds size of 4");
        }
        int size = this.cubics.size();
        float fMax = 0.0f;
        for (int i2 = 0; i2 < size; i2++) {
            Cubic cubic = this.cubics.get(i2);
            float fDistanceSquared = Utils.distanceSquared(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY);
            long jM39pointOnCurveOOQOV4g$graphics_shapes_release = cubic.m39pointOnCurveOOQOV4g$graphics_shapes_release(0.5f);
            fMax = Math.max(fMax, Math.max(fDistanceSquared, Utils.distanceSquared(PointKt.m51getXDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerX, PointKt.m52getYDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release) - this.centerY)));
        }
        float fSqrt = (float) Math.sqrt(fMax);
        float f2 = this.centerX;
        bounds[0] = f2 - fSqrt;
        float f3 = this.centerY;
        bounds[1] = f3 - fSqrt;
        bounds[2] = f2 + fSqrt;
        bounds[3] = f3 + fSqrt;
        return bounds;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RoundedPolygon) {
            return j.a(this.features, ((RoundedPolygon) obj).features);
        }
        return false;
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public final List<Feature> getFeatures$graphics_shapes_release() {
        return this.features;
    }

    public int hashCode() {
        return this.features.hashCode();
    }

    public final RoundedPolygon normalized() {
        float[] fArrCalculateBounds$default = calculateBounds$default(this, null, false, 3, null);
        float f2 = fArrCalculateBounds$default[2] - fArrCalculateBounds$default[0];
        float f3 = fArrCalculateBounds$default[3] - fArrCalculateBounds$default[1];
        final float fMax = Math.max(f2, f3);
        float f4 = 2;
        final float f5 = ((fMax - f2) / f4) - fArrCalculateBounds$default[0];
        final float f6 = ((fMax - f3) / f4) - fArrCalculateBounds$default[1];
        return transformed(new PointTransformer() { // from class: androidx.graphics.shapes.RoundedPolygon.normalized.1
            @Override // androidx.graphics.shapes.PointTransformer
            /* renamed from: transform-XgqJiTY */
            public final long mo60transformXgqJiTY(float f7, float f8) {
                float f9 = f7 + f5;
                float f10 = fMax;
                return FloatFloatPair.m8constructorimpl(f9 / f10, (f8 + f6) / f10);
            }
        });
    }

    public String toString() {
        return "[RoundedPolygon. Cubics = " + k.s0(this.cubics, null, null, null, 63) + " || Features = " + k.s0(this.features, null, null, null, 63) + " || Center = (" + this.centerX + ", " + this.centerY + ")]";
    }

    public final RoundedPolygon transformed(PointTransformer f2) {
        j.e(f2, "f");
        long jM58transformedso9K2fw = PointKt.m58transformedso9K2fw(FloatFloatPair.m8constructorimpl(this.centerX, this.centerY), f2);
        c cVarQ = p.a.q();
        int size = this.features.size();
        for (int i2 = 0; i2 < size; i2++) {
            cVarQ.add(this.features.get(i2).transformed$graphics_shapes_release(f2));
        }
        return new RoundedPolygon(p.a.e(cVarQ), PointKt.m51getXDnnuFBc(jM58transformedso9K2fw), PointKt.m52getYDnnuFBc(jM58transformedso9K2fw));
    }

    public final float[] calculateBounds(float[] bounds) {
        j.e(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public final float[] calculateBounds(float[] bounds, boolean z2) {
        j.e(bounds, "bounds");
        if (bounds.length >= 4) {
            int size = this.cubics.size();
            float fMax = Float.MIN_VALUE;
            float fMax2 = Float.MIN_VALUE;
            float fMin = Float.MAX_VALUE;
            float fMin2 = Float.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                this.cubics.get(i2).calculateBounds$graphics_shapes_release(bounds, z2);
                fMin = Math.min(fMin, bounds[0]);
                fMin2 = Math.min(fMin2, bounds[1]);
                fMax = Math.max(fMax, bounds[2]);
                fMax2 = Math.max(fMax2, bounds[3]);
            }
            bounds[0] = fMin;
            bounds[1] = fMin2;
            bounds[2] = fMax;
            bounds[3] = fMax2;
            return bounds;
        }
        throw new IllegalArgumentException("Required bounds size of 4");
    }
}
