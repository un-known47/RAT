package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.progressindicator.DrawingDelegate;
import com.google.android.material.transformation.FabTransformationScrimBehavior;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float adjustedWavelength;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedInnerCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> endPoints;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private float trackLength;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair, float f2, float f3, float f4, float f5) {
        int i2 = this.drawingDeterminateIndicator ? ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        if (pathMeasure == this.activePathMeasure && i2 != this.cachedWavelength) {
            this.cachedWavelength = i2;
            invalidateCachedPaths();
        }
        path.rewind();
        float f6 = (-this.trackLength) / 2.0f;
        boolean zHasWavyEffect = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator);
        if (zHasWavyEffect) {
            float f7 = this.trackLength;
            float f8 = this.adjustedWavelength;
            float f9 = f7 / f8;
            float f10 = f5 / f9;
            float f11 = f9 / (f9 + 1.0f);
            f2 = (f2 + f10) * f11;
            f3 = (f3 + f10) * f11;
            f6 -= f5 * f8;
        }
        float length = pathMeasure.getLength() * f2;
        float length2 = pathMeasure.getLength() * f3;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setTranslate(f6, 0.0f);
        pathPoint.translate(f6, 0.0f);
        pathPoint2.translate(f6, 0.0f);
        if (zHasWavyEffect) {
            float f12 = this.displayedAmplitude * f4;
            this.transform.postScale(1.0f, f12);
            pathPoint.scale(1.0f, f12);
            pathPoint2.scale(1.0f, f12);
        }
        path.transform(this.transform);
    }

    private void drawLine(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, @ColorInt int i2, @Px int i3, @Px int i4, float f4, float f5, boolean z2) {
        float f6;
        float fLerp;
        Paint paint2;
        Canvas canvas2;
        float fClamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        float fClamp2 = MathUtils.clamp(f3, 0.0f, 1.0f);
        float fLerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp);
        float fLerp3 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp2);
        int iClamp = (int) ((MathUtils.clamp(fLerp2, 0.0f, 0.01f) * i3) / 0.01f);
        float fClamp3 = 1.0f - MathUtils.clamp(fLerp3, 0.99f, 1.0f);
        float f7 = this.trackLength;
        int i5 = (int) ((fLerp2 * f7) + iClamp);
        int i6 = (int) ((fLerp3 * f7) - ((int) ((fClamp3 * i4) / 0.01f)));
        float f8 = this.displayedCornerRadius;
        float f9 = this.displayedInnerCornerRadius;
        if (f8 != f9) {
            float fMax = Math.max(f8, f9);
            float f10 = this.trackLength;
            float f11 = fMax / f10;
            float fLerp4 = com.google.android.material.math.MathUtils.lerp(this.displayedCornerRadius, this.displayedInnerCornerRadius, MathUtils.clamp(i5 / f10, 0.0f, f11) / f11);
            float f12 = this.displayedCornerRadius;
            float f13 = this.displayedInnerCornerRadius;
            float f14 = this.trackLength;
            fLerp = com.google.android.material.math.MathUtils.lerp(f12, f13, MathUtils.clamp((f14 - i6) / f14, 0.0f, f11) / f11);
            f6 = fLerp4;
        } else {
            f6 = f8;
            fLerp = f6;
        }
        float f15 = (-this.trackLength) / 2.0f;
        boolean z3 = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z2 && f4 > 0.0f;
        if (i5 <= i6) {
            float f16 = i5 + f6;
            float f17 = i6 - fLerp;
            float f18 = f6 * 2.0f;
            float f19 = 2.0f * fLerp;
            paint.setColor(i2);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.first).translate(f16 + f15, 0.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).translate(f15 + f17, 0.0f);
            if (i5 == 0 && f17 + fLerp < f16 + f6) {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair = this.endPoints;
                DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
                float f20 = this.displayedTrackThickness;
                drawRoundedBlock(canvas, paint, pathPoint, f18, f20, f6, (DrawingDelegate.PathPoint) pair.second, f19, f20, fLerp, true);
                return;
            }
            if (f16 - f6 > f17 - fLerp) {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair2 = this.endPoints;
                DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair2.second;
                float f21 = this.displayedTrackThickness;
                drawRoundedBlock(canvas, paint, pathPoint2, f19, f21, fLerp, (DrawingDelegate.PathPoint) pair2.first, f18, f21, f6, false);
                return;
            }
            float f22 = fLerp;
            float f23 = f6;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(((LinearProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            if (z3) {
                paint2 = paint;
                PathMeasure pathMeasure = this.activePathMeasure;
                Path path = this.displayedActivePath;
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair3 = this.endPoints;
                float f24 = this.trackLength;
                calculateDisplayedPath(pathMeasure, path, pair3, f16 / f24, f17 / f24, f4, f5);
                canvas2 = canvas;
                canvas2.drawPath(this.displayedActivePath, paint2);
            } else {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair4 = this.endPoints;
                Object obj = pair4.first;
                float f25 = ((DrawingDelegate.PathPoint) obj).posVec[0];
                float f26 = ((DrawingDelegate.PathPoint) obj).posVec[1];
                Object obj2 = pair4.second;
                canvas.drawLine(f25, f26, ((DrawingDelegate.PathPoint) obj2).posVec[0], ((DrawingDelegate.PathPoint) obj2).posVec[1], paint);
                paint2 = paint;
                canvas2 = canvas;
            }
            if (((LinearProgressIndicatorSpec) this.spec).useStrokeCap()) {
                return;
            }
            if (f16 > 0.0f && f23 > 0.0f) {
                drawRoundedBlock(canvas2, paint2, (DrawingDelegate.PathPoint) this.endPoints.first, f18, this.displayedTrackThickness, f23);
            }
            if (f17 >= this.trackLength || f22 <= 0.0f) {
                return;
            }
            drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f19, this.displayedTrackThickness, f22);
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f2, float f3, float f4) {
        drawRoundedBlock(canvas, paint, pathPoint, f2, f3, f4, null, 0.0f, 0.0f, 0.0f, false);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f2, boolean z2, boolean z3) {
        if (this.trackLength != rect.width()) {
            this.trackLength = rect.width();
            invalidateCachedPaths();
        }
        float preferredHeight = getPreferredHeight();
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - preferredHeight) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f3 = this.trackLength / 2.0f;
        float f4 = preferredHeight / 2.0f;
        canvas.clipRect(-f3, -f4, f3, f4);
        S s2 = this.spec;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) s2).trackThickness * f2;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) s2).trackThickness / 2, ((LinearProgressIndicatorSpec) s2).getTrackCornerRadiusInPx()) * f2;
        S s3 = this.spec;
        this.displayedAmplitude = ((LinearProgressIndicatorSpec) s3).waveAmplitude * f2;
        this.displayedInnerCornerRadius = Math.min(((LinearProgressIndicatorSpec) s3).trackThickness / 2.0f, ((LinearProgressIndicatorSpec) s3).getTrackInnerCornerRadiusInPx()) * f2;
        if (z2 || z3) {
            if ((z2 && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z3 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z2 || (z3 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, ((1.0f - f2) * ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f);
            }
        }
        if (z3 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f2;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i2, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i3) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i2, i3);
        this.drawingDeterminateIndicator = false;
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize <= 0 || iCompositeARGBWithAlpha == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iCompositeARGBWithAlpha);
        S s2 = this.spec;
        DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint = new DrawingDelegate.PathPoint(new float[]{(this.trackLength / 2.0f) - (((LinearProgressIndicatorSpec) s2).trackStopIndicatorPadding != null ? (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize / 2.0f) + ((LinearProgressIndicatorSpec) s2).trackStopIndicatorPadding.floatValue() : this.displayedTrackThickness / 2.0f), 0.0f}, new float[]{1.0f, 0.0f});
        S s3 = this.spec;
        drawRoundedBlock(canvas, paint, pathPoint, ((LinearProgressIndicatorSpec) s3).trackStopIndicatorSize, ((LinearProgressIndicatorSpec) s3).trackStopIndicatorSize, (this.displayedCornerRadius * ((LinearProgressIndicatorSpec) s3).trackStopIndicatorSize) / this.displayedTrackThickness);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i2) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i2);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        float f2 = activeIndicator.startFraction;
        float f3 = activeIndicator.endFraction;
        int i3 = activeIndicator.gapSize;
        drawLine(canvas, paint, f2, f3, iCompositeARGBWithAlpha, i3, i3, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f2, float f3, int i2, int i3, @Px int i4) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i2, i3);
        this.drawingDeterminateIndicator = false;
        drawLine(canvas, paint, f2, f3, iCompositeARGBWithAlpha, i4, i4, 0.0f, 0.0f, false);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        S s2 = this.spec;
        return (((LinearProgressIndicatorSpec) s2).waveAmplitude * 2) + ((LinearProgressIndicatorSpec) s2).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        if (((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            int i2 = this.drawingDeterminateIndicator ? ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
            float f2 = this.trackLength;
            int i3 = (int) (f2 / i2);
            this.adjustedWavelength = f2 / i3;
            for (int i4 = 0; i4 <= i3; i4++) {
                int i5 = i4 * 2;
                float f3 = i5 + 1;
                this.cachedActivePath.cubicTo(i5 + 0.48f, 0.0f, f3 - 0.48f, 1.0f, f3, 1.0f);
                float f4 = i5 + 2;
                this.cachedActivePath.cubicTo(f3 + 0.48f, 1.0f, f4 - 0.48f, 0.0f, f4, 0.0f);
            }
            this.transform.reset();
            this.transform.setScale(this.adjustedWavelength / 2.0f, -2.0f);
            this.transform.postTranslate(0.0f, 1.0f);
            this.cachedActivePath.transform(this.transform);
        } else {
            this.cachedActivePath.lineTo(this.trackLength, 0.0f);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f2, float f3, float f4, @Nullable DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2, float f5, float f6, float f7, boolean z2) {
        char c;
        float f8;
        float f9;
        float fMin = Math.min(f3, this.displayedTrackThickness);
        float f10 = (-f2) / 2.0f;
        float f11 = (-fMin) / 2.0f;
        float f12 = f2 / 2.0f;
        float f13 = fMin / 2.0f;
        RectF rectF = new RectF(f10, f11, f12, f13);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pathPoint2 != null) {
            float fMin2 = Math.min(f6, this.displayedTrackThickness);
            float fMin3 = Math.min(f5 / 2.0f, (f7 * fMin2) / this.displayedTrackThickness);
            RectF rectF2 = new RectF();
            if (z2) {
                c = 0;
                float f14 = (pathPoint2.posVec[0] - fMin3) - (pathPoint.posVec[0] - f4);
                if (f14 > 0.0f) {
                    pathPoint2.translate((-f14) / 2.0f, 0.0f);
                    f9 = f5 + f14;
                } else {
                    f9 = f5;
                }
                rectF2.set(0.0f, f11, f12, f13);
            } else {
                c = 0;
                float f15 = (pathPoint2.posVec[0] + fMin3) - (pathPoint.posVec[0] + f4);
                if (f15 < 0.0f) {
                    pathPoint2.translate((-f15) / 2.0f, 0.0f);
                    f8 = f5 - f15;
                } else {
                    f8 = f5;
                }
                rectF2.set(f10, f11, 0.0f, f13);
                f9 = f8;
            }
            RectF rectF3 = new RectF((-f9) / 2.0f, (-fMin2) / 2.0f, f9 / 2.0f, fMin2 / 2.0f);
            float[] fArr = pathPoint2.posVec;
            canvas.translate(fArr[c], fArr[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint2.tanVec));
            Path path = new Path();
            path.addRoundRect(rectF3, fMin3, fMin3, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.rotate(-vectorToCanvasRotation(pathPoint2.tanVec));
            float[] fArr2 = pathPoint2.posVec;
            canvas.translate(-fArr2[c], -fArr2[1]);
            float[] fArr3 = pathPoint.posVec;
            canvas.translate(fArr3[c], fArr3[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRect(rectF2, paint);
            canvas.drawRoundRect(rectF, f4, f4, paint);
        } else {
            float[] fArr4 = pathPoint.posVec;
            canvas.translate(fArr4[0], fArr4[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRoundRect(rectF, f4, f4, paint);
        }
        canvas.restore();
    }
}
