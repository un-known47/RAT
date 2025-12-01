package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.Arrays;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import l0.d;
import m0.i;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class Cubic {
    public static final Companion Companion = new Companion(null);
    private final float[] points;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Cubic circularArc(float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = f4 - f2;
            float f9 = f5 - f3;
            long jDirectionVector = Utils.directionVector(f8, f9);
            float f10 = f6 - f2;
            float f11 = f7 - f3;
            long jDirectionVector2 = Utils.directionVector(f10, f11);
            long jM72rotate90DnnuFBc = Utils.m72rotate90DnnuFBc(jDirectionVector);
            long jM72rotate90DnnuFBc2 = Utils.m72rotate90DnnuFBc(jDirectionVector2);
            boolean z2 = PointKt.m46dotProduct5P9i7ZU(jM72rotate90DnnuFBc, f10, f11) >= 0.0f;
            float fM47dotProductybeJwSQ = PointKt.m47dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM47dotProductybeJwSQ > 0.999f) {
                return straightLine(f4, f5, f6, f7);
            }
            float fSqrt = (((((float) Math.sqrt(2 * r9)) - ((float) Math.sqrt(r5 - (fM47dotProductybeJwSQ * fM47dotProductybeJwSQ)))) * ((Utils.distance(f8, f9) * 4.0f) / 3.0f)) / (1 - fM47dotProductybeJwSQ)) * (z2 ? 1.0f : -1.0f);
            return CubicKt.Cubic(f4, f5, (PointKt.m51getXDnnuFBc(jM72rotate90DnnuFBc) * fSqrt) + f4, (PointKt.m52getYDnnuFBc(jM72rotate90DnnuFBc) * fSqrt) + f5, f6 - (PointKt.m51getXDnnuFBc(jM72rotate90DnnuFBc2) * fSqrt), f7 - (PointKt.m52getYDnnuFBc(jM72rotate90DnnuFBc2) * fSqrt), f6, f7);
        }

        public final Cubic straightLine(float f2, float f3, float f4, float f5) {
            return CubicKt.Cubic(f2, f3, Utils.interpolate(f2, f4, 0.33333334f), Utils.interpolate(f3, f5, 0.33333334f), Utils.interpolate(f2, f4, 0.6666667f), Utils.interpolate(f3, f5, 0.6666667f), f4, f5);
        }

        private Companion() {
        }
    }

    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z2);
    }

    public static final Cubic circularArc(float f2, float f3, float f4, float f5, float f6, float f7) {
        return Companion.circularArc(f2, f3, f4, f5, f6, f7);
    }

    public static final Cubic straightLine(float f2, float f3, float f4, float f5) {
        return Companion.straightLine(f2, f3, f4, f5);
    }

    private final boolean zeroIsh(float f2) {
        return Math.abs(f2) < 1.0E-4f;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d9 A[PHI: r3 r7
  0x01d9: PHI (r3v15 float) = (r3v12 float), (r3v21 float) binds: [B:85:0x022b, B:62:0x01d7] A[DONT_GENERATE, DONT_INLINE]
  0x01d9: PHI (r7v14 float) = (r7v10 float), (r7v16 float) binds: [B:85:0x022b, B:62:0x01d7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x022e A[PHI: r9 r13
  0x022e: PHI (r9v5 float) = (r9v2 float), (r9v3 float), (r9v3 float), (r9v2 float), (r9v2 float), (r9v2 float) binds: [B:65:0x01e4, B:77:0x0214, B:79:0x0218, B:51:0x01b4, B:54:0x01c0, B:56:0x01c4] A[DONT_GENERATE, DONT_INLINE]
  0x022e: PHI (r13v13 float) = (r13v9 float), (r13v10 float), (r13v10 float), (r13v9 float), (r13v9 float), (r13v9 float) binds: [B:65:0x01e4, B:77:0x0214, B:79:0x0218, B:51:0x01b4, B:54:0x01c0, B:56:0x01c4] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void calculateBounds$graphics_shapes_release(float[] r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.Cubic.calculateBounds$graphics_shapes_release(float[], boolean):void");
    }

    public final Cubic div(float f2) {
        return times(1.0f / f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) obj).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    public final float[] getPoints$graphics_shapes_release() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic o) {
        j.e(o, "o");
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = this.points[i2] + o.points[i2];
        }
        return new Cubic(fArr);
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m39pointOnCurveOOQOV4g$graphics_shapes_release(float f2) {
        float f3 = 1 - f2;
        float f4 = f3 * f3 * f3;
        float f5 = 3 * f2;
        float f6 = f5 * f3 * f3;
        float f7 = f5 * f2 * f3;
        float f8 = f2 * f2 * f2;
        return FloatFloatPair.m8constructorimpl((getAnchor1X() * f8) + (getControl1X() * f7) + (getControl0X() * f6) + (getAnchor0X() * f4), (getAnchor1Y() * f8) + (getControl1Y() * f7) + (getControl0Y() * f6) + (getAnchor0Y() * f4));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final d split(float f2) {
        float f3 = 1 - f2;
        long jM39pointOnCurveOOQOV4g$graphics_shapes_release = m39pointOnCurveOOQOV4g$graphics_shapes_release(f2);
        float f4 = f3 * f3;
        float f5 = 2 * f3 * f2;
        float f6 = f2 * f2;
        return new d(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f3) + (getControl0X() * f2), (getAnchor0Y() * f3) + (getControl0Y() * f2), (getControl1X() * f6) + (getControl0X() * f5) + (getAnchor0X() * f4), (getControl1Y() * f6) + (getControl0Y() * f5) + (getAnchor0Y() * f4), PointKt.m51getXDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m52getYDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m51getXDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m52getYDnnuFBc(jM39pointOnCurveOOQOV4g$graphics_shapes_release), (getAnchor1X() * f6) + (getControl1X() * f5) + (getControl0X() * f4), (getAnchor1Y() * f6) + (getControl1Y() * f5) + (getControl0Y() * f4), (getAnchor1X() * f2) + (getControl1X() * f3), (getAnchor1Y() * f2) + (getControl1Y() * f3), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float f2) {
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < 8; i2++) {
            fArr[i2] = this.points[i2] * f2;
        }
        return new Cubic(fArr);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer f2) {
        j.e(f2, "f");
        MutableCubic mutableCubic = new MutableCubic();
        float[] fArr = this.points;
        i.j0(fArr, 0, mutableCubic.getPoints$graphics_shapes_release(), 0, fArr.length);
        mutableCubic.transform(f2);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    public /* synthetic */ Cubic(long j, long j2, long j3, long j4, e eVar) {
        this(j, j2, j3, j4);
    }

    public final Cubic div(int i2) {
        return div(i2);
    }

    public final Cubic times(int i2) {
        return times(i2);
    }

    public Cubic(float[] points) {
        j.e(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8");
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i2, e eVar) {
        this((i2 & 1) != 0 ? new float[8] : fArr);
    }

    private Cubic(long j, long j2, long j3, long j4) {
        this(new float[]{PointKt.m51getXDnnuFBc(j), PointKt.m52getYDnnuFBc(j), PointKt.m51getXDnnuFBc(j2), PointKt.m52getYDnnuFBc(j2), PointKt.m51getXDnnuFBc(j3), PointKt.m52getYDnnuFBc(j3), PointKt.m51getXDnnuFBc(j4), PointKt.m52getYDnnuFBc(j4)});
    }
}
