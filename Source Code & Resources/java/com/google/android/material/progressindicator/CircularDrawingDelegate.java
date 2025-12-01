package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.progressindicator.DrawingDelegate;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH = 0.5522848f;
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float adjustedWavelength;
    private final RectF arcBounds;
    private float cachedAmplitude;
    private float cachedRadius;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    private final Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> endPoints;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcBounds = new RectF();
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    private void appendCubicPerHalfCycle(@NonNull Path path, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint2) {
        float f2 = (this.adjustedWavelength / 2.0f) * 0.48f;
        DrawingDelegate.PathPoint pathPoint3 = new DrawingDelegate.PathPoint(this, pathPoint);
        DrawingDelegate.PathPoint pathPoint4 = new DrawingDelegate.PathPoint(this, pathPoint2);
        pathPoint3.moveAlong(f2);
        pathPoint4.moveAlong(-f2);
        float[] fArr = pathPoint3.posVec;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float[] fArr2 = pathPoint4.posVec;
        float f5 = fArr2[0];
        float f6 = fArr2[1];
        float[] fArr3 = pathPoint2.posVec;
        path.cubicTo(f3, f4, f5, f6, fArr3[0], fArr3[1]);
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> pair, float f2, float f3, float f4, float f5) {
        float f6 = this.displayedAmplitude * f4;
        int i2 = this.drawingDeterminateIndicator ? ((CircularProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((CircularProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        float f7 = this.adjustedRadius;
        if (f7 != this.cachedRadius || (pathMeasure == this.activePathMeasure && (f6 != this.cachedAmplitude || i2 != this.cachedWavelength))) {
            this.cachedAmplitude = f6;
            this.cachedWavelength = i2;
            this.cachedRadius = f7;
            invalidateCachedPaths();
        }
        path.rewind();
        float f8 = 0.0f;
        float fClamp = MathUtils.clamp(f3, 0.0f, 1.0f);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            float f9 = f5 / ((float) ((this.adjustedRadius * 6.283185307179586d) / this.adjustedWavelength));
            f2 += f9;
            f8 = 0.0f - (f9 * 360.0f);
        }
        float f10 = f2 % 1.0f;
        float length = (pathMeasure.getLength() * f10) / 2.0f;
        float length2 = (pathMeasure.getLength() * (f10 + fClamp)) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setRotate(f8);
        pathPoint.rotate(f8);
        pathPoint2.rotate(f8);
        path.transform(this.transform);
    }

    private void createWavyPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, float f2) {
        path.rewind();
        float length = pathMeasure.getLength();
        int iMax = Math.max(3, (int) ((length / (this.drawingDeterminateIndicator ? ((CircularProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((CircularProgressIndicatorSpec) this.spec).wavelengthIndeterminate)) / 2.0f)) * 2;
        this.adjustedWavelength = length / iMax;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < iMax; i2++) {
            DrawingDelegate.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            float f3 = i2;
            pathMeasure.getPosTan(this.adjustedWavelength * f3, pathPoint.posVec, pathPoint.tanVec);
            DrawingDelegate.PathPoint pathPoint2 = new DrawingDelegate.PathPoint();
            float f4 = this.adjustedWavelength;
            pathMeasure.getPosTan((f4 / 2.0f) + (f3 * f4), pathPoint2.posVec, pathPoint2.tanVec);
            arrayList.add(pathPoint);
            pathPoint2.moveAcross(f2 * 2.0f);
            arrayList.add(pathPoint2);
        }
        arrayList.add((DrawingDelegate.PathPoint) arrayList.get(0));
        DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint3 = (DrawingDelegate.PathPoint) arrayList.get(0);
        float[] fArr = pathPoint3.posVec;
        int i3 = 1;
        path.moveTo(fArr[0], fArr[1]);
        while (i3 < arrayList.size()) {
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint4 = (DrawingDelegate.PathPoint) arrayList.get(i3);
            appendCubicPerHalfCycle(path, pathPoint3, pathPoint4);
            i3++;
            pathPoint3 = pathPoint4;
        }
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, @ColorInt int i2, @Px int i3, @Px int i4, float f4, float f5, boolean z2) {
        float f6 = f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2;
        float f7 = f2 % 1.0f;
        if (f7 < 0.0f) {
            f7 += 1.0f;
        }
        if (this.totalTrackLengthFraction < 1.0f) {
            float f8 = f7 + f6;
            if (f8 > 1.0f) {
                drawArc(canvas, paint, f7, 1.0f, i2, i3, 0, f4, f5, z2);
                drawArc(canvas, paint, 1.0f, f8, i2, 0, i4, f4, f5, z2);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        float f9 = f6 - 0.99f;
        if (f9 >= 0.0f) {
            float f10 = ((f9 * degrees) / 180.0f) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
            f6 += f10;
            if (!z2) {
                f7 -= f10 / 2.0f;
            }
        }
        float fLerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f7);
        float fLerp2 = com.google.android.material.math.MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f6);
        float degrees2 = (float) Math.toDegrees(i3 / this.adjustedRadius);
        float degrees3 = ((fLerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i4 / this.adjustedRadius));
        float f11 = (fLerp * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        boolean z3 = ((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z2 && f4 > 0.0f;
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f12 = this.displayedCornerRadius * 2.0f;
        float f13 = degrees * 2.0f;
        if (degrees3 < f13) {
            float f14 = degrees3 / f13;
            float f15 = (degrees * f14) + f11;
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            if (z3) {
                float length = (this.activePathMeasure.getLength() * (f15 / 360.0f)) / 2.0f;
                float f16 = this.displayedAmplitude * f4;
                float f17 = this.adjustedRadius;
                if (f17 != this.cachedRadius || f16 != this.cachedAmplitude) {
                    this.cachedAmplitude = f16;
                    this.cachedRadius = f17;
                    invalidateCachedPaths();
                }
                this.activePathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
            } else {
                pathPoint.rotate(f15 + 90.0f);
                pathPoint.moveAcross(-this.adjustedRadius);
            }
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, pathPoint, f12, this.displayedTrackThickness, f14);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(((CircularProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f18 = f11 + degrees;
        float f19 = degrees3 - f13;
        ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
        ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
        if (z3) {
            calculateDisplayedPath(this.activePathMeasure, this.displayedActivePath, this.endPoints, f18 / 360.0f, f19 / 360.0f, f4, f5);
            canvas.drawPath(this.displayedActivePath, paint);
        } else {
            ((DrawingDelegate.PathPoint) this.endPoints.first).rotate(f18 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.first).moveAcross(-this.adjustedRadius);
            ((DrawingDelegate.PathPoint) this.endPoints.second).rotate(f18 + f19 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).moveAcross(-this.adjustedRadius);
            RectF rectF = this.arcBounds;
            float f20 = this.adjustedRadius;
            rectF.set(-f20, -f20, f20, f20);
            canvas.drawArc(this.arcBounds, f18, f19, false, paint);
        }
        if (((CircularProgressIndicatorSpec) this.spec).useStrokeCap() || this.displayedCornerRadius <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.first, f12, this.displayedTrackThickness);
        drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f12, this.displayedTrackThickness);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f2, float f3) {
        drawRoundedBlock(canvas, paint, pathPoint, f2, f3, 1.0f);
    }

    private int getSize() {
        S s2 = this.spec;
        return (((CircularProgressIndicatorSpec) s2).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s2).indicatorSize;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f2, boolean z2, boolean z3) {
        float fWidth = rect.width() / getPreferredWidth();
        float fHeight = rect.height() / getPreferredHeight();
        S s2 = this.spec;
        float f3 = (((CircularProgressIndicatorSpec) s2).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s2).indicatorInset;
        canvas.translate((f3 * fWidth) + rect.left, (f3 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
            if (Build.VERSION.SDK_INT == 29) {
                canvas.rotate(0.1f);
            }
        }
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        S s3 = this.spec;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) s3).trackThickness * f2;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) s3).trackThickness / 2, ((CircularProgressIndicatorSpec) s3).getTrackCornerRadiusInPx()) * f2;
        S s4 = this.spec;
        this.displayedAmplitude = ((CircularProgressIndicatorSpec) s4).waveAmplitude * f2;
        float f5 = (((CircularProgressIndicatorSpec) s4).indicatorSize - ((CircularProgressIndicatorSpec) s4).trackThickness) / 2.0f;
        this.adjustedRadius = f5;
        if (z2 || z3) {
            float f6 = ((1.0f - f2) * ((CircularProgressIndicatorSpec) s4).trackThickness) / 2.0f;
            if ((z2 && ((CircularProgressIndicatorSpec) s4).showAnimationBehavior == 2) || (z3 && ((CircularProgressIndicatorSpec) s4).hideAnimationBehavior == 1)) {
                this.adjustedRadius = f5 + f6;
            } else if ((z2 && ((CircularProgressIndicatorSpec) s4).showAnimationBehavior == 1) || (z3 && ((CircularProgressIndicatorSpec) s4).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f5 - f6;
            }
        }
        if (z3 && ((CircularProgressIndicatorSpec) s4).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f2;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i2) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i2);
        canvas.save();
        canvas.rotate(activeIndicator.rotationDegree);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        float f2 = activeIndicator.startFraction;
        float f3 = activeIndicator.endFraction;
        int i3 = activeIndicator.gapSize;
        drawArc(canvas, paint, f2, f3, iCompositeARGBWithAlpha, i3, i3, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, @ColorInt int i2, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i3, int i4) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i2, i3);
        this.drawingDeterminateIndicator = false;
        drawArc(canvas, paint, f2, f3, iCompositeARGBWithAlpha, i4, i4, 0.0f, 0.0f, false);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        this.cachedActivePath.moveTo(1.0f, 0.0f);
        for (int i2 = 0; i2 < 2; i2++) {
            this.cachedActivePath.cubicTo(1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, 1.0f, 0.0f, 1.0f);
            this.cachedActivePath.cubicTo(-0.5522848f, 1.0f, -1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 0.0f);
            this.cachedActivePath.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, 0.0f, -1.0f);
            this.cachedActivePath.cubicTo(QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 1.0f, -0.5522848f, 1.0f, 0.0f);
        }
        this.transform.reset();
        Matrix matrix = this.transform;
        float f2 = this.adjustedRadius;
        matrix.setScale(f2, f2);
        this.cachedActivePath.transform(this.transform);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            this.activePathMeasure.setPath(this.cachedActivePath, false);
            createWavyPath(this.activePathMeasure, this.cachedActivePath, this.cachedAmplitude);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f2, float f3, float f4) {
        float fMin = Math.min(f3, this.displayedTrackThickness);
        float f5 = f2 / 2.0f;
        float fMin2 = Math.min(f5, (this.displayedCornerRadius * fMin) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f2) / 2.0f, (-fMin) / 2.0f, f5, fMin / 2.0f);
        canvas.save();
        float[] fArr = pathPoint.posVec;
        canvas.translate(fArr[0], fArr[1]);
        canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
        canvas.scale(f4, f4);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i2, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i3) {
    }
}
