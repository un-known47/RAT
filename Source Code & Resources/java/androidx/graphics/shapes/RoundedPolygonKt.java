package androidx.graphics.shapes;

import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.j;
import l0.d;
import m0.k;
import m0.m;
import m0.t;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2) {
        return RoundedPolygon$default(i2, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i2, float f2, float f3, float f4, CornerRounding cornerRounding, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i3 & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i3 & 8) != 0) {
            f4 = 0.0f;
        }
        if ((i3 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i3 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        float f5 = f4;
        return RoundedPolygon(i2, f2, f3, f5, cornerRounding, list2);
    }

    private static final long calculateCenter(float[] fArr) {
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        while (i2 < fArr.length) {
            int i3 = i2 + 1;
            f2 += fArr[i2];
            i2 += 2;
            f3 += fArr[i3];
        }
        float f4 = 2;
        return FloatFloatPair.m8constructorimpl((f2 / fArr.length) / f4, (f3 / fArr.length) / f4);
    }

    private static final float[] verticesFromNumVerts(int i2, float f2, float f3, float f4) {
        float[] fArr = new float[i2 * 2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            float f5 = f2;
            long jM55plusybeJwSQ = PointKt.m55plusybeJwSQ(Utils.m71radialToCartesianL6JJ3z0$default(f5, (Utils.getFloatPi() / i2) * 2 * i3, 0L, 4, null), FloatFloatPair.m8constructorimpl(f3, f4));
            int i5 = i4 + 1;
            fArr[i4] = PointKt.m51getXDnnuFBc(jM55plusybeJwSQ);
            i4 += 2;
            fArr[i5] = PointKt.m52getYDnnuFBc(jM55plusybeJwSQ);
            i3++;
            f2 = f5;
        }
        return fArr;
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f2) {
        return RoundedPolygon$default(i2, f2, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f2, float f3) {
        return RoundedPolygon$default(i2, f2, f3, 0.0f, null, null, 56, null);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f2, float f3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i2 & 4) != 0) {
            list = null;
        }
        if ((i2 & 8) != 0) {
            f2 = Float.MIN_VALUE;
        }
        if ((i2 & 16) != 0) {
            f3 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f2, f3);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f2, float f3, float f4) {
        return RoundedPolygon$default(i2, f2, f3, f4, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f2, float f3, float f4, CornerRounding rounding) {
        j.e(rounding, "rounding");
        return RoundedPolygon$default(i2, f2, f3, f4, rounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices) {
        j.e(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding) {
        j.e(vertices, "vertices");
        j.e(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list) {
        j.e(vertices, "vertices");
        j.e(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f2) {
        j.e(vertices, "vertices");
        j.e(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f2, 0.0f, 16, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i2, float f2, float f3, float f4, CornerRounding rounding, List<CornerRounding> list) {
        j.e(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i2, f2, f3, f4), rounding, list, f3, f4);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon source) {
        j.e(source, "source");
        return new RoundedPolygon(source.getFeatures$graphics_shapes_release(), source.getCenterX(), source.getCenterY());
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f2, float f3) {
        long jCalculateCenter;
        d dVar;
        CornerRounding cornerRounding;
        Float fValueOf = Float.valueOf(1.0f);
        j.e(vertices, "vertices");
        j.e(rounding, "rounding");
        if (vertices.length >= 6) {
            int i2 = 1;
            if (vertices.length % 2 != 1) {
                if (list != null && list.size() * 2 != vertices.length) {
                    throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
                }
                ArrayList arrayList = new ArrayList();
                int length = vertices.length / 2;
                ArrayList arrayList2 = new ArrayList();
                int i3 = 0;
                int i4 = 0;
                while (i4 < length) {
                    CornerRounding cornerRounding2 = (list == null || (cornerRounding = list.get(i4)) == null) ? rounding : cornerRounding;
                    int i5 = (((i4 + length) - i2) % length) * 2;
                    int i6 = i4 + 1;
                    int i7 = (i6 % length) * 2;
                    int i8 = i4 * 2;
                    arrayList2.add(new RoundedCorner(FloatFloatPair.m8constructorimpl(vertices[i5], vertices[i5 + i2]), FloatFloatPair.m8constructorimpl(vertices[i8], vertices[i8 + i2]), FloatFloatPair.m8constructorimpl(vertices[i7], vertices[i7 + 1]), cornerRounding2, null));
                    i4 = i6;
                    i2 = 1;
                }
                c1.d dVarV = p.a.V(0, length);
                ArrayList arrayList3 = new ArrayList(m.k0(dVarV, 10));
                Iterator it = dVarV.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((t) it).nextInt();
                    int i9 = (iNextInt + 1) % length;
                    float expectedRoundCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i9)).getExpectedRoundCut();
                    float expectedCut = ((RoundedCorner) arrayList2.get(iNextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i9)).getExpectedCut();
                    int i10 = iNextInt * 2;
                    int i11 = i9 * 2;
                    float fDistance = Utils.distance(vertices[i10] - vertices[i11], vertices[i10 + 1] - vertices[i11 + 1]);
                    if (expectedRoundCut > fDistance) {
                        dVar = new d(Float.valueOf(fDistance / expectedRoundCut), Float.valueOf(0.0f));
                    } else if (expectedCut > fDistance) {
                        dVar = new d(fValueOf, Float.valueOf((fDistance - expectedRoundCut) / (expectedCut - expectedRoundCut)));
                    } else {
                        dVar = new d(fValueOf, fValueOf);
                    }
                    arrayList3.add(dVar);
                }
                for (int i12 = 0; i12 < length; i12++) {
                    MutableFloatList mutableFloatList = new MutableFloatList(2);
                    for (int i13 = 0; i13 < 2; i13++) {
                        d dVar2 = (d) arrayList3.get((((i12 + length) - 1) + i13) % length);
                        mutableFloatList.add(((((RoundedCorner) arrayList2.get(i12)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i12)).getExpectedRoundCut()) * ((Number) dVar2.f851b).floatValue()) + (((RoundedCorner) arrayList2.get(i12)).getExpectedRoundCut() * ((Number) dVar2.f850a).floatValue()));
                    }
                    arrayList.add(((RoundedCorner) arrayList2.get(i12)).getCubics(mutableFloatList.get(0), mutableFloatList.get(1)));
                }
                ArrayList arrayList4 = new ArrayList();
                while (i3 < length) {
                    int i14 = i3 + 1;
                    int i15 = i14 % length;
                    int i16 = i3 * 2;
                    long jM8constructorimpl = FloatFloatPair.m8constructorimpl(vertices[i16], vertices[i16 + 1]);
                    int i17 = (((i3 + length) - 1) % length) * 2;
                    long jM8constructorimpl2 = FloatFloatPair.m8constructorimpl(vertices[i17], vertices[i17 + 1]);
                    int i18 = i15 * 2;
                    arrayList4.add(new Feature.Corner((List) arrayList.get(i3), jM8constructorimpl, ((RoundedCorner) arrayList2.get(i3)).m63getCenter1ufDz9w(), PointKt.m42clockwiseybeJwSQ(PointKt.m54minusybeJwSQ(jM8constructorimpl, jM8constructorimpl2), PointKt.m54minusybeJwSQ(FloatFloatPair.m8constructorimpl(vertices[i18], vertices[i18 + 1]), jM8constructorimpl)), null));
                    arrayList4.add(new Feature.Edge(p.a.G(Cubic.Companion.straightLine(((Cubic) k.t0((List) arrayList.get(i3))).getAnchor1X(), ((Cubic) k.t0((List) arrayList.get(i3))).getAnchor1Y(), ((Cubic) k.o0((List) arrayList.get(i15))).getAnchor0X(), ((Cubic) k.o0((List) arrayList.get(i15))).getAnchor0Y()))));
                    i3 = i14;
                }
                if (f2 == Float.MIN_VALUE || f3 == Float.MIN_VALUE) {
                    jCalculateCenter = calculateCenter(vertices);
                } else {
                    jCalculateCenter = FloatFloatPair.m8constructorimpl(f2, f3);
                }
                return new RoundedPolygon(arrayList4, Float.intBitsToFloat((int) (jCalculateCenter >> 32)), Float.intBitsToFloat((int) (jCalculateCenter & 4294967295L)));
            }
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        throw new IllegalArgumentException("Polygons must have at least 3 vertices");
    }
}
