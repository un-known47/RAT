package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.RoundedPolygon;
import c1.c;
import c1.d;
import com.google.android.material.color.utilities.Contrast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import m0.i;
import m0.k;
import m0.t;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ShapesKt {
    public static final RoundedPolygon circle(RoundedPolygon.Companion companion) {
        j.e(companion, "<this>");
        return circle$default(companion, 0, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i2, float f2, float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8;
        }
        if ((i3 & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i3 & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i3 & 8) != 0) {
            f4 = 0.0f;
        }
        return circle(companion, i2, f2, f3, f4);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion) {
        j.e(companion, "<this>");
        return pill$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f2, float f3, float f4, float f5, float f6, int i2, Object obj) {
        float f7;
        float f8;
        float f9;
        float f10;
        RoundedPolygon.Companion companion2;
        float f11;
        if ((i2 & 1) != 0) {
            f2 = 2.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f5 = 0.0f;
        }
        if ((i2 & 16) != 0) {
            f7 = 0.0f;
            f10 = f4;
            f8 = f5;
            f11 = f2;
            f9 = f3;
            companion2 = companion;
        } else {
            f7 = f6;
            f8 = f5;
            f9 = f3;
            f10 = f4;
            companion2 = companion;
            f11 = f2;
        }
        return pill(companion2, f11, f9, f10, f8, f7);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion) {
        j.e(companion, "<this>");
        return pillStar$default(companion, 0.0f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2047, null);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f2, float f3, int i2, float f4, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f5, float f6, float f7, float f8, int i3, Object obj) {
        float f9;
        float f10;
        float f11;
        float f12;
        CornerRounding cornerRounding3;
        List list2;
        float f13;
        CornerRounding cornerRounding4;
        float f14;
        int i4;
        RoundedPolygon.Companion companion2;
        float f15;
        if ((i3 & 1) != 0) {
            f2 = 2.0f;
        }
        if ((i3 & 2) != 0) {
            f3 = 1.0f;
        }
        if ((i3 & 4) != 0) {
            i2 = 8;
        }
        if ((i3 & 8) != 0) {
            f4 = 0.5f;
        }
        if ((i3 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i3 & 32) != 0) {
            cornerRounding2 = null;
        }
        if ((i3 & 64) != 0) {
            list = null;
        }
        if ((i3 & 128) != 0) {
            f5 = 0.5f;
        }
        if ((i3 & 256) != 0) {
            f6 = 0.0f;
        }
        if ((i3 & 512) != 0) {
            f7 = 0.0f;
        }
        if ((i3 & 1024) != 0) {
            f9 = 0.0f;
            f12 = f6;
            f10 = f7;
            list2 = list;
            f11 = f5;
            cornerRounding4 = cornerRounding;
            cornerRounding3 = cornerRounding2;
            i4 = i2;
            f13 = f4;
            f15 = f2;
            f14 = f3;
            companion2 = companion;
        } else {
            f9 = f8;
            f10 = f7;
            f11 = f5;
            f12 = f6;
            cornerRounding3 = cornerRounding2;
            list2 = list;
            f13 = f4;
            cornerRounding4 = cornerRounding;
            f14 = f3;
            i4 = i2;
            companion2 = companion;
            f15 = f2;
        }
        return pillStar(companion2, f15, f14, i4, f13, cornerRounding4, cornerRounding3, list2, f11, f12, f10, f9);
    }

    private static final float[] pillStarVerticesFromNumVerts(int i2, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        int i3;
        float f9;
        float f10;
        float f11;
        long jM8constructorimpl;
        float fMin = Math.min(f2, f3);
        float f12 = f3 - f2;
        if (f12 < 0.0f) {
            f12 = 0.0f;
        }
        float f13 = f2 - f3;
        if (f13 < 0.0f) {
            f13 = 0.0f;
        }
        float f14 = 2;
        float f15 = f12 / f14;
        float f16 = f13 / f14;
        float fInterpolate = Utils.interpolate(f4, 1.0f, f5) * Utils.getTwoPi() * fMin;
        float f17 = (f14 * f12) + (f14 * f13) + fInterpolate;
        float f18 = fInterpolate / 4;
        float f19 = f15 + f18;
        float f20 = f19 + f13;
        float f21 = f20 + f18;
        float f22 = f21 + f12;
        float f23 = f22 + f18;
        float f24 = f23 + f13;
        float f25 = f24 + f18;
        float[] fArr = {0.0f, f15, f19, f20, f21, f22, f23, f24, f25, f25 + f15, f17};
        int i4 = i2 * 2;
        float f26 = f17 / i4;
        float f27 = f6 * f17;
        float[] fArr2 = new float[i2 * 4];
        float f28 = f13;
        long jM8constructorimpl2 = FloatFloatPair.m8constructorimpl(f16, f15);
        float f29 = -f16;
        long jM8constructorimpl3 = FloatFloatPair.m8constructorimpl(f29, f15);
        float f30 = -f15;
        long jM8constructorimpl4 = FloatFloatPair.m8constructorimpl(f29, f30);
        long jM8constructorimpl5 = FloatFloatPair.m8constructorimpl(f16, f30);
        float f31 = f12;
        float f32 = f15;
        int i5 = 0;
        float f33 = 0.0f;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        while (i5 < i4) {
            float f34 = f27 % f17;
            if (f34 < f33) {
                i6 = 0;
            }
            while (true) {
                int i8 = (i6 + 1) % 11;
                float f35 = fArr[i8];
                if (f34 >= f35) {
                    f32 = fArr[(i8 + 1) % 11];
                    i6 = i8;
                    f33 = f35;
                } else {
                    float f36 = (f34 - f33) / (f32 - f33);
                    if (z2) {
                        i3 = i5;
                        f9 = fMin * f4;
                    } else {
                        i3 = i5;
                        f9 = fMin;
                    }
                    switch (i6) {
                        case 0:
                            f10 = f15;
                            float f37 = f9;
                            f11 = f16;
                            jM8constructorimpl = FloatFloatPair.m8constructorimpl(f37, f36 * f10);
                            break;
                        case 1:
                            f10 = f15;
                            float f38 = f9;
                            f11 = f16;
                            jM8constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f38, (Utils.getFloatPi() * f36) / f14, 0L, 4, null), jM8constructorimpl2);
                            break;
                        case 2:
                            f10 = f15;
                            float f39 = f9;
                            f11 = f16;
                            jM8constructorimpl = FloatFloatPair.m8constructorimpl(f11 - (f36 * f28), f39);
                            break;
                        case 3:
                            f10 = f15;
                            float f40 = f9;
                            f11 = f16;
                            jM8constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f40, ((Utils.getFloatPi() * f36) / f14) + (Utils.getFloatPi() / f14), 0L, 4, null), jM8constructorimpl3);
                            break;
                        case 4:
                            f10 = f15;
                            float f41 = f9;
                            f11 = f16;
                            jM8constructorimpl = FloatFloatPair.m8constructorimpl(-f41, f10 - (f36 * f31));
                            break;
                        case 5:
                            f10 = f15;
                            float f42 = f9;
                            f11 = f16;
                            jM8constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f42, ((Utils.getFloatPi() * f36) / f14) + Utils.getFloatPi(), 0L, 4, null), jM8constructorimpl4);
                            break;
                        case 6:
                            f10 = f15;
                            float f43 = f9;
                            f11 = f16;
                            jM8constructorimpl = FloatFloatPair.m8constructorimpl((f36 * f28) + f29, -f43);
                            break;
                        case 7:
                            f10 = f15;
                            float f44 = f9;
                            f11 = f16;
                            jM8constructorimpl = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f44, ((Utils.getFloatPi() * f36) / f14) + (Utils.getFloatPi() * 1.5f), 0L, 4, null), jM8constructorimpl5);
                            break;
                        default:
                            f10 = f15;
                            jM8constructorimpl = FloatFloatPair.m8constructorimpl(f9, (f36 * f15) + f30);
                            f11 = f16;
                            break;
                    }
                    int i9 = i7 + 1;
                    fArr2[i7] = PointKt.m51getXDnnuFBc(jM8constructorimpl) + f7;
                    i7 += 2;
                    fArr2[i9] = PointKt.m52getYDnnuFBc(jM8constructorimpl) + f8;
                    f27 += f26;
                    z2 = !z2;
                    f16 = f11;
                    i5 = i3 + 1;
                    f15 = f10;
                }
            }
        }
        return fArr2;
    }

    public static final RoundedPolygon rectangle(RoundedPolygon.Companion companion, float f2, float f3, CornerRounding rounding, List<CornerRounding> list, float f4, float f5) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        float f6 = 2;
        float f7 = f2 / f6;
        float f8 = f4 - f7;
        float f9 = f3 / f6;
        float f10 = f5 - f9;
        float f11 = f7 + f4;
        float f12 = f9 + f5;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f11, f12, f8, f12, f8, f10, f11, f10}, rounding, list, f4, f5);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f2, float f3, CornerRounding cornerRounding, List list, float f4, float f5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = 2.0f;
        }
        if ((i2 & 2) != 0) {
            f3 = 2.0f;
        }
        if ((i2 & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i2 & 8) != 0) {
            list = null;
        }
        if ((i2 & 16) != 0) {
            f4 = 0.0f;
        }
        if ((i2 & 32) != 0) {
            f5 = 0.0f;
        }
        return rectangle(companion, f2, f3, cornerRounding, list, f4, f5);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2) {
        j.e(companion, "<this>");
        return star$default(companion, i2, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, 254, null);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i2, float f2, float f3, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f4, float f5, int i3, Object obj) {
        return star(companion, i2, (i3 & 2) != 0 ? 1.0f : f2, (i3 & 4) != 0 ? 0.5f : f3, (i3 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding, (i3 & 16) != 0 ? null : cornerRounding2, (i3 & 32) == 0 ? list : null, (i3 & 64) != 0 ? 0.0f : f4, (i3 & 128) != 0 ? 0.0f : f5);
    }

    private static final float[] starVerticesFromNumVerts(int i2, float f2, float f3, float f4, float f5) {
        float[] fArr = new float[i2 * 4];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f6 = i2;
            long jM71radialToCartesianL6JJ3z0$default = Utils.m71radialToCartesianL6JJ3z0$default(f2, (Utils.getFloatPi() / f6) * 2 * i4, 0L, 4, null);
            fArr[i3] = PointKt.m51getXDnnuFBc(jM71radialToCartesianL6JJ3z0$default) + f4;
            fArr[i3 + 1] = PointKt.m52getYDnnuFBc(jM71radialToCartesianL6JJ3z0$default) + f5;
            long jM71radialToCartesianL6JJ3z0$default2 = Utils.m71radialToCartesianL6JJ3z0$default(f3, (Utils.getFloatPi() / f6) * ((i4 * 2) + 1), 0L, 4, null);
            int i5 = i3 + 3;
            fArr[i3 + 2] = PointKt.m51getXDnnuFBc(jM71radialToCartesianL6JJ3z0$default2) + f4;
            i3 += 4;
            fArr[i5] = PointKt.m52getYDnnuFBc(jM71radialToCartesianL6JJ3z0$default2) + f5;
        }
        return fArr;
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2) {
        j.e(companion, "<this>");
        return circle$default(companion, i2, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f2) {
        j.e(companion, "<this>");
        return pill$default(companion, f2, 0.0f, 0.0f, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2) {
        j.e(companion, "<this>");
        return pillStar$default(companion, f2, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2046, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f2) {
        j.e(companion, "<this>");
        return star$default(companion, i2, f2, 0.0f, null, null, null, 0.0f, 0.0f, 252, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2, float f2) {
        j.e(companion, "<this>");
        return circle$default(companion, i2, f2, 0.0f, 0.0f, 12, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f2, float f3) {
        j.e(companion, "<this>");
        return pill$default(companion, f2, f3, 0.0f, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3) {
        j.e(companion, "<this>");
        return pillStar$default(companion, f2, f3, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2044, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f2, float f3) {
        j.e(companion, "<this>");
        return star$default(companion, i2, f2, f3, null, null, null, 0.0f, 0.0f, 248, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2, float f2, float f3) {
        j.e(companion, "<this>");
        return circle$default(companion, i2, f2, f3, 0.0f, 8, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f2, float f3, float f4) {
        j.e(companion, "<this>");
        return pill$default(companion, f2, f3, f4, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2) {
        j.e(companion, "<this>");
        return pillStar$default(companion, f2, f3, i2, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2040, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f2, float f3, CornerRounding rounding) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return star$default(companion, i2, f2, f3, rounding, null, null, 0.0f, 0.0f, 240, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i2, float f2, float f3, float f4) {
        j.e(companion, "<this>");
        if (i2 >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i2, f2 / ((float) Math.cos(Utils.getFloatPi() / i2)), f3, f4, new CornerRounding(f2, 0.0f, 2, null), null, 32, null);
        }
        throw new IllegalArgumentException("Circle must have at least three vertices");
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f2, float f3, float f4, float f5) {
        j.e(companion, "<this>");
        return pill$default(companion, f2, f3, f4, f5, 0.0f, 16, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4) {
        j.e(companion, "<this>");
        return pillStar$default(companion, f2, f3, i2, f4, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2032, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f2, float f3, CornerRounding rounding, CornerRounding cornerRounding) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return star$default(companion, i2, f2, f3, rounding, cornerRounding, null, 0.0f, 0.0f, 224, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f2, float f3, float f4, float f5, float f6) {
        j.e(companion, "<this>");
        if (f2 > 0.0f && f3 > 0.0f) {
            float f7 = 2;
            float f8 = f2 / f7;
            float f9 = f3 / f7;
            float f10 = f8 + f5;
            float f11 = f9 + f6;
            float f12 = (-f8) + f5;
            float f13 = (-f9) + f6;
            return RoundedPolygonKt.RoundedPolygon$default(new float[]{f10, f11, f12, f11, f12, f13, f10, f13}, new CornerRounding(Math.min(f8, f9), f4), null, f5, f6, 4, null);
        }
        throw new IllegalArgumentException("Pill shapes must have positive width and height");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4, CornerRounding rounding) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return pillStar$default(companion, f2, f3, i2, f4, rounding, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2016, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f2, float f3, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return star$default(companion, i2, f2, f3, rounding, cornerRounding, list, 0.0f, 0.0f, 192, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4, CornerRounding rounding, CornerRounding cornerRounding) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return pillStar$default(companion, f2, f3, i2, f4, rounding, cornerRounding, null, 0.0f, 0.0f, 0.0f, 0.0f, 1984, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f2, float f3, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f4) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return star$default(companion, i2, f2, f3, rounding, cornerRounding, list, f4, 0.0f, 128, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return pillStar$default(companion, f2, f3, i2, f4, rounding, cornerRounding, list, 0.0f, 0.0f, 0.0f, 0.0f, 1920, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i2, float f2, float f3, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, float f4, float f5) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        if (f2 <= 0.0f || f3 <= 0.0f) {
            throw new IllegalArgumentException("Star radii must both be greater than 0");
        }
        if (f3 < f2) {
            if (list == null && cornerRounding != null) {
                d dVarV = p.a.V(0, i2);
                ArrayList arrayList = new ArrayList();
                Iterator it = dVarV.iterator();
                while (((c) it).c) {
                    ((t) it).nextInt();
                    k.m0(arrayList, i.g0(new CornerRounding[]{rounding, cornerRounding}));
                }
                list = arrayList;
            }
            return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i2, f2, f3, f4, f5), rounding, list, f4, f5);
        }
        throw new IllegalArgumentException("innerRadius must be less than radius");
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f5) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return pillStar$default(companion, f2, f3, i2, f4, rounding, cornerRounding, list, f5, 0.0f, 0.0f, 0.0f, 1792, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return pillStar$default(companion, f2, f3, i2, f4, rounding, cornerRounding, list, f5, f6, 0.0f, 0.0f, 1536, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6, float f7) {
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        return pillStar$default(companion, f2, f3, i2, f4, rounding, cornerRounding, list, f5, f6, f7, 0.0f, 1024, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f2, float f3, int i2, @FloatRange(from = 0.0d, fromInclusive = false, to = Contrast.RATIO_MIN, toInclusive = false) float f4, CornerRounding rounding, CornerRounding cornerRounding, List<CornerRounding> list, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6, float f7, float f8) {
        List<CornerRounding> arrayList;
        j.e(companion, "<this>");
        j.e(rounding, "rounding");
        if (f2 <= 0.0f || f3 <= 0.0f) {
            throw new IllegalArgumentException("Pill shapes must have positive width and height");
        }
        if (f4 > 0.0f && f4 <= 1.0f) {
            if (list != null || cornerRounding == null) {
                arrayList = list;
            } else {
                d dVarV = p.a.V(0, i2);
                arrayList = new ArrayList<>();
                Iterator it = dVarV.iterator();
                while (((c) it).c) {
                    ((t) it).nextInt();
                    k.m0(arrayList, i.g0(new CornerRounding[]{rounding, cornerRounding}));
                }
            }
            return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i2, f2, f3, f4, f5, f6, f7, f8), rounding, arrayList, f7, f8);
        }
        throw new IllegalArgumentException("innerRadius must be between 0 and 1");
    }
}
