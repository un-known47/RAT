package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class CutoutDrawable extends MaterialShapeDrawable {

    @NonNull
    CutoutDrawableState drawableState;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class ImplApi18 extends CutoutDrawable {
        public ImplApi18(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public void drawStrokeShape(@NonNull Canvas canvas) {
            if (((CutoutDrawable) this).drawableState.cutoutBounds.isEmpty()) {
                super.drawStrokeShape(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(((CutoutDrawable) this).drawableState.cutoutBounds);
            } else {
                canvas.clipRect(((CutoutDrawable) this).drawableState.cutoutBounds, Region.Op.DIFFERENCE);
            }
            super.drawStrokeShape(canvas);
            canvas.restore();
        }
    }

    public static CutoutDrawable create(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel == null) {
            shapeAppearanceModel = new ShapeAppearanceModel();
        }
        return create(new CutoutDrawableState(shapeAppearanceModel, new RectF()));
    }

    public boolean hasCutout() {
        return !this.drawableState.cutoutBounds.isEmpty();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        this.drawableState = new CutoutDrawableState(this.drawableState);
        return this;
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float f2, float f3, float f4, float f5) {
        if (f2 == this.drawableState.cutoutBounds.left && f3 == this.drawableState.cutoutBounds.top && f4 == this.drawableState.cutoutBounds.right && f5 == this.drawableState.cutoutBounds.bottom) {
            return;
        }
        this.drawableState.cutoutBounds.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {

        @NonNull
        private final RectF cutoutBounds;

        @Override // com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState, android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            CutoutDrawable cutoutDrawableCreate = CutoutDrawable.create(this);
            cutoutDrawableCreate.invalidateSelf();
            return cutoutDrawableCreate;
        }

        private CutoutDrawableState(@NonNull ShapeAppearanceModel shapeAppearanceModel, @NonNull RectF rectF) {
            super(shapeAppearanceModel, null);
            this.cutoutBounds = rectF;
        }

        private CutoutDrawableState(@NonNull CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
            this.cutoutBounds = cutoutDrawableState.cutoutBounds;
        }
    }

    private CutoutDrawable(@NonNull CutoutDrawableState cutoutDrawableState) {
        super(cutoutDrawableState);
        this.drawableState = cutoutDrawableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CutoutDrawable create(@NonNull CutoutDrawableState cutoutDrawableState) {
        return new ImplApi18(cutoutDrawableState);
    }

    public void setCutout(@NonNull RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
