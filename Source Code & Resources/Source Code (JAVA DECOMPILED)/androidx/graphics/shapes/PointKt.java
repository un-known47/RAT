package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class PointKt {
    /* renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m42clockwiseybeJwSQ(long j, long j2) {
        return (m52getYDnnuFBc(j2) * m51getXDnnuFBc(j)) - (m51getXDnnuFBc(j2) * m52getYDnnuFBc(j)) > 0.0f;
    }

    /* renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m43copy5P9i7ZU(long j, float f2, float f3) {
        return FloatFloatPair.m8constructorimpl(f2, f3);
    }

    /* renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m44copy5P9i7ZU$default(long j, float f2, float f3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i2 & 2) != 0) {
            f3 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m43copy5P9i7ZU(j, f2, f3);
    }

    /* renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m45divso9K2fw(long j, float f2) {
        return FloatFloatPair.m8constructorimpl(m51getXDnnuFBc(j) / f2, m52getYDnnuFBc(j) / f2);
    }

    /* renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m46dotProduct5P9i7ZU(long j, float f2, float f3) {
        return (m52getYDnnuFBc(j) * f3) + (m51getXDnnuFBc(j) * f2);
    }

    /* renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m47dotProductybeJwSQ(long j, long j2) {
        return (m52getYDnnuFBc(j2) * m52getYDnnuFBc(j)) + (m51getXDnnuFBc(j2) * m51getXDnnuFBc(j));
    }

    /* renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m48getDirectionDnnuFBc(long j) {
        float fM49getDistanceDnnuFBc = m49getDistanceDnnuFBc(j);
        if (fM49getDistanceDnnuFBc > 0.0f) {
            return m45divso9K2fw(j, fM49getDistanceDnnuFBc);
        }
        throw new IllegalArgumentException("Can't get the direction of a 0-length vector");
    }

    /* renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m49getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m52getYDnnuFBc(j) * m52getYDnnuFBc(j)) + (m51getXDnnuFBc(j) * m51getXDnnuFBc(j)));
    }

    /* renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m50getDistanceSquaredDnnuFBc(long j) {
        return (m52getYDnnuFBc(j) * m52getYDnnuFBc(j)) + (m51getXDnnuFBc(j) * m51getXDnnuFBc(j));
    }

    /* renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m51getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m52getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m53interpolatedLqxh1s(long j, long j2, float f2) {
        return FloatFloatPair.m8constructorimpl(Utils.interpolate(m51getXDnnuFBc(j), m51getXDnnuFBc(j2), f2), Utils.interpolate(m52getYDnnuFBc(j), m52getYDnnuFBc(j2), f2));
    }

    /* renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m54minusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m8constructorimpl(m51getXDnnuFBc(j) - m51getXDnnuFBc(j2), m52getYDnnuFBc(j) - m52getYDnnuFBc(j2));
    }

    /* renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m55plusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m8constructorimpl(m51getXDnnuFBc(j2) + m51getXDnnuFBc(j), m52getYDnnuFBc(j2) + m52getYDnnuFBc(j));
    }

    /* renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m56remso9K2fw(long j, float f2) {
        return FloatFloatPair.m8constructorimpl(m51getXDnnuFBc(j) % f2, m52getYDnnuFBc(j) % f2);
    }

    /* renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m57timesso9K2fw(long j, float f2) {
        return FloatFloatPair.m8constructorimpl(m51getXDnnuFBc(j) * f2, m52getYDnnuFBc(j) * f2);
    }

    /* renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m58transformedso9K2fw(long j, PointTransformer f2) {
        j.e(f2, "f");
        long jMo60transformXgqJiTY = f2.mo60transformXgqJiTY(m51getXDnnuFBc(j), m52getYDnnuFBc(j));
        return FloatFloatPair.m8constructorimpl(Float.intBitsToFloat((int) (jMo60transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo60transformXgqJiTY & 4294967295L)));
    }

    /* renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m59unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m8constructorimpl(-m51getXDnnuFBc(j), -m52getYDnnuFBc(j));
    }
}
