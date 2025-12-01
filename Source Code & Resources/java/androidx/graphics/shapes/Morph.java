package androidx.graphics.shapes;

import androidx.graphics.shapes.MeasuredPolygon;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.j;
import l0.d;
import m0.k;
import n0.c;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Morph {
    public static final Companion Companion = new Companion(null);
    private final List<d> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final List<d> match$graphics_shapes_release(RoundedPolygon p12, RoundedPolygon p2) {
            d dVarCutAtProgress;
            d dVarCutAtProgress2;
            j.e(p12, "p1");
            j.e(p2, "p2");
            MeasuredPolygon.Companion companion = MeasuredPolygon.Companion;
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p12.getCenterX(), p12.getCenterY()), p12);
            MeasuredPolygon measuredPolygonMeasurePolygon$graphics_shapes_release2 = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(p2.getCenterX(), p2.getCenterY()), p2);
            DoubleMapper doubleMapperFeatureMapper = FeatureMappingKt.featureMapper(measuredPolygonMeasurePolygon$graphics_shapes_release.getFeatures(), measuredPolygonMeasurePolygon$graphics_shapes_release2.getFeatures());
            float map = doubleMapperFeatureMapper.map(0.0f);
            String unused = MorphKt.LOG_TAG;
            MeasuredPolygon measuredPolygonCutAndShift = measuredPolygonMeasurePolygon$graphics_shapes_release2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon.MeasuredCubic measuredCubic = (MeasuredPolygon.MeasuredCubic) k.q0(measuredPolygonMeasurePolygon$graphics_shapes_release, 0);
            MeasuredPolygon.MeasuredCubic measuredCubic2 = (MeasuredPolygon.MeasuredCubic) k.q0(measuredPolygonCutAndShift, 0);
            int i2 = 1;
            int i3 = 1;
            while (measuredCubic != null && measuredCubic2 != null) {
                float endOutlineProgress = i2 == measuredPolygonMeasurePolygon$graphics_shapes_release.size() ? 1.0f : measuredCubic.getEndOutlineProgress();
                float fMapBack = i3 == measuredPolygonCutAndShift.size() ? 1.0f : doubleMapperFeatureMapper.mapBack(Utils.positiveModulo(measuredCubic2.getEndOutlineProgress() + map, 1.0f));
                float fMin = Math.min(endOutlineProgress, fMapBack);
                String unused2 = MorphKt.LOG_TAG;
                float f2 = 1.0E-6f + fMin;
                if (endOutlineProgress > f2) {
                    String unused3 = MorphKt.LOG_TAG;
                    dVarCutAtProgress = measuredCubic.cutAtProgress(fMin);
                } else {
                    d dVar = new d(measuredCubic, k.q0(measuredPolygonMeasurePolygon$graphics_shapes_release, i2));
                    i2++;
                    dVarCutAtProgress = dVar;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic3 = (MeasuredPolygon.MeasuredCubic) dVarCutAtProgress.f850a;
                measuredCubic = (MeasuredPolygon.MeasuredCubic) dVarCutAtProgress.f851b;
                if (fMapBack > f2) {
                    String unused4 = MorphKt.LOG_TAG;
                    dVarCutAtProgress2 = measuredCubic2.cutAtProgress(Utils.positiveModulo(doubleMapperFeatureMapper.map(fMin) - map, 1.0f));
                } else {
                    d dVar2 = new d(measuredCubic2, k.q0(measuredPolygonCutAndShift, i3));
                    i3++;
                    dVarCutAtProgress2 = dVar2;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic4 = (MeasuredPolygon.MeasuredCubic) dVarCutAtProgress2.f850a;
                measuredCubic2 = (MeasuredPolygon.MeasuredCubic) dVarCutAtProgress2.f851b;
                String unused5 = MorphKt.LOG_TAG;
                arrayList.add(new d(measuredCubic3.getCubic(), measuredCubic4.getCubic()));
            }
            if (measuredCubic == null && measuredCubic2 == null) {
                return arrayList;
            }
            throw new IllegalArgumentException("Expected both Polygon's Cubic to be fully matched");
        }

        private Companion() {
        }
    }

    public Morph(RoundedPolygon start, RoundedPolygon end) {
        j.e(start, "start");
        j.e(end, "end");
        this.start = start;
        this.end = end;
        this._morphMatch = Companion.match$graphics_shapes_release(start, end);
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return morph.calculateBounds(fArr, z2);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public static void forEachCubic$default(Morph morph, float f2, MutableCubic mutableCubic, l callback, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        j.e(mutableCubic, "mutableCubic");
        j.e(callback, "callback");
        int size = morph.getMorphMatch().size();
        for (int i3 = 0; i3 < size; i3++) {
            mutableCubic.interpolate((Cubic) morph.getMorphMatch().get(i3).f850a, (Cubic) morph.getMorphMatch().get(i3).f851b, f2);
            callback.invoke(mutableCubic);
        }
    }

    public final List<Cubic> asCubics(float f2) {
        c cVarQ = p.a.q();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i2 = 0;
        while (i2 < size) {
            float[] fArr = new float[8];
            for (int i3 = 0; i3 < 8; i3++) {
                fArr[i3] = Utils.interpolate(((Cubic) this._morphMatch.get(i2).f850a).getPoints$graphics_shapes_release()[i3], ((Cubic) this._morphMatch.get(i2).f851b).getPoints$graphics_shapes_release()[i3], f2);
            }
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                cVarQ.add(cubic);
            }
            i2++;
            cubic = cubic3;
        }
        if (cubic != null && cubic2 != null) {
            cVarQ.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return p.a.e(cVarQ);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }

    public final float[] calculateMaxBounds(float[] bounds) {
        j.e(bounds, "bounds");
        this.start.calculateMaxBounds(bounds);
        float f2 = bounds[0];
        float f3 = bounds[1];
        float f4 = bounds[2];
        float f5 = bounds[3];
        this.end.calculateMaxBounds(bounds);
        bounds[0] = Math.min(f2, bounds[0]);
        bounds[1] = Math.min(f3, bounds[1]);
        bounds[2] = Math.max(f4, bounds[2]);
        bounds[3] = Math.max(f5, bounds[3]);
        return bounds;
    }

    public final void forEachCubic(float f2, MutableCubic mutableCubic, l callback) {
        j.e(mutableCubic, "mutableCubic");
        j.e(callback, "callback");
        int size = getMorphMatch().size();
        for (int i2 = 0; i2 < size; i2++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i2).f850a, (Cubic) getMorphMatch().get(i2).f851b, f2);
            callback.invoke(mutableCubic);
        }
    }

    public final List<d> getMorphMatch() {
        return this._morphMatch;
    }

    public final float[] calculateBounds(float[] bounds) {
        j.e(bounds, "bounds");
        return calculateBounds$default(this, bounds, false, 2, null);
    }

    public final float[] calculateBounds(float[] bounds, boolean z2) {
        j.e(bounds, "bounds");
        this.start.calculateBounds(bounds, z2);
        float f2 = bounds[0];
        float f3 = bounds[1];
        float f4 = bounds[2];
        float f5 = bounds[3];
        this.end.calculateBounds(bounds, z2);
        bounds[0] = Math.min(f2, bounds[0]);
        bounds[1] = Math.min(f3, bounds[1]);
        bounds[2] = Math.max(f4, bounds[2]);
        bounds[3] = Math.max(f5, bounds[3]);
        return bounds;
    }

    public final void forEachCubic(float f2, l callback) {
        j.e(callback, "callback");
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i2 = 0; i2 < size; i2++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i2).f850a, (Cubic) getMorphMatch().get(i2).f851b, f2);
            callback.invoke(mutableCubic);
        }
    }

    public static /* synthetic */ void getMorphMatch$annotations() {
    }
}
