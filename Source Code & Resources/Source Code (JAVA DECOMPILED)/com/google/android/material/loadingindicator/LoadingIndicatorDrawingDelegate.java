package com.google.android.material.loadingindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.collection.ScatterMapKt;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.Shapes_androidKt;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.shape.MaterialShapes;
import com.google.android.material.transformation.FabTransformationScrimBehavior;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class LoadingIndicatorDrawingDelegate {
    private static final Morph[] INDETERMINATE_MORPH_SEQUENCE;
    private static final RoundedPolygon[] INDETERMINATE_SHAPES;

    @NonNull
    final Path indicatorPath = new Path();

    @NonNull
    final Matrix indicatorPathTransform = new Matrix();

    @NonNull
    LoadingIndicatorSpec specs;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class IndicatorState {

        @ColorInt
        int color;
        float morphFraction;
        float rotationDegree;
    }

    static {
        int i2 = 0;
        RoundedPolygon[] roundedPolygonArr = {MaterialShapes.normalize(MaterialShapes.SOFT_BURST, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.COOKIE_9, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.PENTAGON, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.PILL, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.SUNNY, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.COOKIE_4, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.OVAL, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f))};
        INDETERMINATE_SHAPES = roundedPolygonArr;
        INDETERMINATE_MORPH_SEQUENCE = new Morph[roundedPolygonArr.length];
        while (true) {
            RoundedPolygon[] roundedPolygonArr2 = INDETERMINATE_SHAPES;
            if (i2 >= roundedPolygonArr2.length) {
                return;
            }
            int i3 = i2 + 1;
            INDETERMINATE_MORPH_SEQUENCE[i2] = new Morph(roundedPolygonArr2[i2], roundedPolygonArr2[i3 % roundedPolygonArr2.length]);
            i2 = i3;
        }
    }

    public LoadingIndicatorDrawingDelegate(@NonNull LoadingIndicatorSpec loadingIndicatorSpec) {
        this.specs = loadingIndicatorSpec;
    }

    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect) {
        canvas.translate(rect.centerX(), rect.centerY());
        if (this.specs.scaleToFit) {
            float fMin = Math.min(rect.width() / getPreferredWidth(), rect.height() / getPreferredHeight());
            canvas.scale(fMin, fMin);
        }
        canvas.clipRect((-getPreferredWidth()) / 2.0f, (-getPreferredHeight()) / 2.0f, getPreferredWidth() / 2.0f, getPreferredHeight() / 2.0f);
        canvas.rotate(-90.0f);
    }

    public void drawContainer(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i2, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i3) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        float fMin = Math.min(loadingIndicatorSpec.containerWidth, loadingIndicatorSpec.containerHeight) / 2.0f;
        paint.setColor(MaterialColors.compositeARGBWithAlpha(i2, i3));
        paint.setStyle(Paint.Style.FILL);
        LoadingIndicatorSpec loadingIndicatorSpec2 = this.specs;
        canvas.drawRoundRect(new RectF((-r2) / 2.0f, (-r9) / 2.0f, loadingIndicatorSpec2.containerWidth / 2.0f, loadingIndicatorSpec2.containerHeight / 2.0f), fMin, fMin, paint);
    }

    public void drawIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull IndicatorState indicatorState, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i2) {
        paint.setColor(MaterialColors.compositeARGBWithAlpha(indicatorState.color, i2));
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.rotate(indicatorState.rotationDegree);
        this.indicatorPath.rewind();
        int iFloor = (int) Math.floor(indicatorState.morphFraction);
        Morph[] morphArr = INDETERMINATE_MORPH_SEQUENCE;
        Shapes_androidKt.toPath(morphArr[MathUtils.floorMod(iFloor, morphArr.length)], indicatorState.morphFraction - iFloor, this.indicatorPath);
        Matrix matrix = this.indicatorPathTransform;
        int i3 = this.specs.indicatorSize;
        matrix.setScale(i3 / 2.0f, i3 / 2.0f);
        this.indicatorPath.transform(this.indicatorPathTransform);
        canvas.drawPath(this.indicatorPath, paint);
        canvas.restore();
    }

    public int getPreferredHeight() {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        return Math.max(loadingIndicatorSpec.containerWidth, loadingIndicatorSpec.indicatorSize);
    }

    public int getPreferredWidth() {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        return Math.max(loadingIndicatorSpec.containerHeight, loadingIndicatorSpec.indicatorSize);
    }
}
