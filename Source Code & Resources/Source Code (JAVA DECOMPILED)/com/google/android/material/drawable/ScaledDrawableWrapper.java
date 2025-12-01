package com.google.android.material.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class ScaledDrawableWrapper extends DrawableWrapperCompat {
    private boolean mutated;
    private ScaledDrawableWrapperState state;

    public ScaledDrawableWrapper(@NonNull Drawable drawable, int i2, int i3) {
        super(drawable);
        this.state = new ScaledDrawableWrapperState(getConstantStateFrom(drawable), i2, i3);
    }

    @Nullable
    private Drawable.ConstantState getConstantStateFrom(@Nullable Drawable drawable) {
        if (drawable != null) {
            return drawable.getConstantState();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        if (this.state.canConstantState()) {
            return this.state;
        }
        return null;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.state.height;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.state.width;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.mutate();
            }
            this.state = new ScaledDrawableWrapperState(getConstantStateFrom(drawable), this.state.width, this.state.height);
            this.mutated = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat
    public void setDrawable(@Nullable Drawable drawable) {
        super.setDrawable(drawable);
        ScaledDrawableWrapperState scaledDrawableWrapperState = this.state;
        if (scaledDrawableWrapperState != null) {
            scaledDrawableWrapperState.wrappedDrawableState = getConstantStateFrom(drawable);
            this.mutated = false;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class ScaledDrawableWrapperState extends Drawable.ConstantState {
        private final int height;
        private final int width;
        private Drawable.ConstantState wrappedDrawableState;

        public ScaledDrawableWrapperState(@Nullable Drawable.ConstantState constantState, int i2, int i3) {
            this.wrappedDrawableState = constantState;
            this.width = i2;
            this.height = i3;
        }

        public boolean canConstantState() {
            return this.wrappedDrawableState != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            Drawable.ConstantState constantState = this.wrappedDrawableState;
            if (constantState != null) {
                return constantState.getChangingConfigurations();
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(), this.width, this.height);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(@Nullable Resources resources) {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(resources), this.width, this.height);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(@Nullable Resources resources, @Nullable Resources.Theme theme) {
            return new ScaledDrawableWrapper(this.wrappedDrawableState.newDrawable(resources, theme), this.width, this.height);
        }
    }
}
