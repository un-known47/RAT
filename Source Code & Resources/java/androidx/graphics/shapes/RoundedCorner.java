package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.e;
import m0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;

    /* renamed from: d1, reason: collision with root package name */
    private final long f137d1;
    private final long d2;
    private final float expectedRoundCut;

    /* renamed from: p0, reason: collision with root package name */
    private final long f138p0;

    /* renamed from: p1, reason: collision with root package name */
    private final long f139p1;
    private final long p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, e eVar) {
        this(j, j2, j3, cornerRounding);
    }

    private final float calculateActualSmoothingValue(float f2) {
        if (f2 > getExpectedCut()) {
            return this.smoothing;
        }
        float f3 = this.expectedRoundCut;
        if (f2 <= f3) {
            return 0.0f;
        }
        return ((f2 - f3) * this.smoothing) / (getExpectedCut() - this.expectedRoundCut);
    }

    /* renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m61computeFlankingCurveoAJzIJU(float f2, float f3, long j, long j2, long j3, long j4, long j5, float f4) {
        long jM48getDirectionDnnuFBc = PointKt.m48getDirectionDnnuFBc(PointKt.m54minusybeJwSQ(j2, j));
        long jM55plusybeJwSQ = PointKt.m55plusybeJwSQ(j, PointKt.m57timesso9K2fw(PointKt.m57timesso9K2fw(jM48getDirectionDnnuFBc, f2), 1 + f3));
        long jM16unboximpl = j3;
        long jM53interpolatedLqxh1s = PointKt.m53interpolatedLqxh1s(jM16unboximpl, PointKt.m45divso9K2fw(PointKt.m55plusybeJwSQ(j3, j4), 2.0f), f3);
        long jM55plusybeJwSQ2 = PointKt.m55plusybeJwSQ(j5, PointKt.m57timesso9K2fw(Utils.directionVector(PointKt.m51getXDnnuFBc(jM53interpolatedLqxh1s) - PointKt.m51getXDnnuFBc(j5), PointKt.m52getYDnnuFBc(jM53interpolatedLqxh1s) - PointKt.m52getYDnnuFBc(j5)), f4));
        FloatFloatPair floatFloatPairM62lineIntersectionCBFvKDc = m62lineIntersectionCBFvKDc(j2, jM48getDirectionDnnuFBc, jM55plusybeJwSQ2, Utils.m72rotate90DnnuFBc(PointKt.m54minusybeJwSQ(jM55plusybeJwSQ2, j5)));
        if (floatFloatPairM62lineIntersectionCBFvKDc != null) {
            jM16unboximpl = floatFloatPairM62lineIntersectionCBFvKDc.m16unboximpl();
        }
        return new Cubic(jM55plusybeJwSQ, PointKt.m45divso9K2fw(PointKt.m55plusybeJwSQ(jM55plusybeJwSQ, PointKt.m57timesso9K2fw(jM16unboximpl, 2.0f)), 3.0f), jM16unboximpl, jM55plusybeJwSQ2, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f2, float f3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f3 = f2;
        }
        return roundedCorner.getCubics(f2, f3);
    }

    /* renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m62lineIntersectionCBFvKDc(long j, long j2, long j3, long j4) {
        long jM72rotate90DnnuFBc = Utils.m72rotate90DnnuFBc(j4);
        float fM47dotProductybeJwSQ = PointKt.m47dotProductybeJwSQ(j2, jM72rotate90DnnuFBc);
        if (Math.abs(fM47dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float fM47dotProductybeJwSQ2 = PointKt.m47dotProductybeJwSQ(PointKt.m54minusybeJwSQ(j3, j), jM72rotate90DnnuFBc);
        if (Math.abs(fM47dotProductybeJwSQ) < Math.abs(fM47dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m5boximpl(PointKt.m55plusybeJwSQ(j, PointKt.m57timesso9K2fw(j2, fM47dotProductybeJwSQ2 / fM47dotProductybeJwSQ)));
    }

    /* renamed from: getCenter-1ufDz9w, reason: not valid java name */
    public final long m63getCenter1ufDz9w() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float f2) {
        return getCubics$default(this, f2, 0.0f, 2, null);
    }

    /* renamed from: getD1-1ufDz9w, reason: not valid java name */
    public final long m64getD11ufDz9w() {
        return this.f137d1;
    }

    /* renamed from: getD2-1ufDz9w, reason: not valid java name */
    public final long m65getD21ufDz9w() {
        return this.d2;
    }

    public final float getExpectedCut() {
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* renamed from: getP0-1ufDz9w, reason: not valid java name */
    public final long m66getP01ufDz9w() {
        return this.f138p0;
    }

    /* renamed from: getP1-1ufDz9w, reason: not valid java name */
    public final long m67getP11ufDz9w() {
        return this.f139p1;
    }

    /* renamed from: getP2-1ufDz9w, reason: not valid java name */
    public final long m68getP21ufDz9w() {
        return this.p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m69setCenterDnnuFBc(long j) {
        this.center = j;
    }

    private RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding) {
        this.f138p0 = j;
        this.f139p1 = j2;
        this.p2 = j3;
        this.rounding = cornerRounding;
        long jM48getDirectionDnnuFBc = PointKt.m48getDirectionDnnuFBc(PointKt.m54minusybeJwSQ(j, j2));
        this.f137d1 = jM48getDirectionDnnuFBc;
        long jM48getDirectionDnnuFBc2 = PointKt.m48getDirectionDnnuFBc(PointKt.m54minusybeJwSQ(j3, j2));
        this.d2 = jM48getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float fM47dotProductybeJwSQ = PointKt.m47dotProductybeJwSQ(jM48getDirectionDnnuFBc, jM48getDirectionDnnuFBc2);
        this.cosAngle = fM47dotProductybeJwSQ;
        float f2 = 1;
        float fSqrt = (float) Math.sqrt(f2 - Utils.square(fM47dotProductybeJwSQ));
        this.sinAngle = fSqrt;
        this.expectedRoundCut = ((double) fSqrt) > 0.001d ? ((fM47dotProductybeJwSQ + f2) * radius) / fSqrt : 0.0f;
        this.center = FloatFloatPair.m8constructorimpl(0.0f, 0.0f);
    }

    public final List<Cubic> getCubics(float f2, float f3) {
        float fMin = Math.min(f2, f3);
        float f4 = this.expectedRoundCut;
        if (f4 < 1.0E-4f || fMin < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j = this.f139p1;
            this.center = j;
            return p.a.G(Cubic.Companion.straightLine(PointKt.m51getXDnnuFBc(j), PointKt.m52getYDnnuFBc(this.f139p1), PointKt.m51getXDnnuFBc(this.f139p1), PointKt.m52getYDnnuFBc(this.f139p1)));
        }
        float fMin2 = Math.min(fMin, f4);
        float fCalculateActualSmoothingValue = calculateActualSmoothingValue(f2);
        float fCalculateActualSmoothingValue2 = calculateActualSmoothingValue(f3);
        float f5 = (this.cornerRadius * fMin2) / this.expectedRoundCut;
        this.center = PointKt.m55plusybeJwSQ(this.f139p1, PointKt.m57timesso9K2fw(PointKt.m48getDirectionDnnuFBc(PointKt.m45divso9K2fw(PointKt.m55plusybeJwSQ(this.f137d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(fMin2) + Utils.square(f5))));
        long jM55plusybeJwSQ = PointKt.m55plusybeJwSQ(this.f139p1, PointKt.m57timesso9K2fw(this.f137d1, fMin2));
        long jM55plusybeJwSQ2 = PointKt.m55plusybeJwSQ(this.f139p1, PointKt.m57timesso9K2fw(this.d2, fMin2));
        Cubic cubicM61computeFlankingCurveoAJzIJU = m61computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue, this.f139p1, this.f138p0, jM55plusybeJwSQ, jM55plusybeJwSQ2, this.center, f5);
        Cubic cubicReverse = m61computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue2, this.f139p1, this.p2, jM55plusybeJwSQ2, jM55plusybeJwSQ, this.center, f5).reverse();
        return l.h0(cubicM61computeFlankingCurveoAJzIJU, Cubic.Companion.circularArc(PointKt.m51getXDnnuFBc(this.center), PointKt.m52getYDnnuFBc(this.center), cubicM61computeFlankingCurveoAJzIJU.getAnchor1X(), cubicM61computeFlankingCurveoAJzIJU.getAnchor1Y(), cubicReverse.getAnchor0X(), cubicReverse.getAnchor0Y()), cubicReverse);
    }

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, int i2, e eVar) {
        this(j, j2, j3, (i2 & 8) != 0 ? null : cornerRounding, null);
    }
}
