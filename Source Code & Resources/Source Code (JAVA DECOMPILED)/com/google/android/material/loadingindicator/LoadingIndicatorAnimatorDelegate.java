package com.google.android.material.loadingindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.loadingindicator.LoadingIndicatorDrawingDelegate;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class LoadingIndicatorAnimatorDelegate {
    private static final int CONSTANT_ROTATION_PER_SHAPE_DEGREES = 50;
    private static final int DURATION_PER_SHAPE_IN_MS = 650;
    private static final int EXTRA_ROTATION_PER_SHAPE_DEGREES = 90;
    private static final float SPRING_DAMPING_RATIO = 0.6f;
    private static final float SPRING_STIFFNESS = 200.0f;
    private float animationFraction;
    private ObjectAnimator animator;

    @Nullable
    LoadingIndicatorDrawable drawable;
    LoadingIndicatorDrawingDelegate.IndicatorState indicatorState = new LoadingIndicatorDrawingDelegate.IndicatorState();
    private float morphFactor;
    private int morphFactorTarget;

    @NonNull
    LoadingIndicatorSpec specs;
    private SpringAnimation springAnimation;
    private static final Property<LoadingIndicatorAnimatorDelegate, Float> ANIMATION_FRACTION = new Property<LoadingIndicatorAnimatorDelegate, Float>(Float.class, "animationFraction") { // from class: com.google.android.material.loadingindicator.LoadingIndicatorAnimatorDelegate.2
        @Override // android.util.Property
        public Float get(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return Float.valueOf(loadingIndicatorAnimatorDelegate.getAnimationFraction());
        }

        @Override // android.util.Property
        public void set(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, Float f2) {
            loadingIndicatorAnimatorDelegate.setAnimationFraction(f2.floatValue());
        }
    };
    private static final FloatPropertyCompat<LoadingIndicatorAnimatorDelegate> MORPH_FACTOR = new FloatPropertyCompat<LoadingIndicatorAnimatorDelegate>("morphFactor") { // from class: com.google.android.material.loadingindicator.LoadingIndicatorAnimatorDelegate.3
        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return loadingIndicatorAnimatorDelegate.getMorphFactor();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, float f2) {
            loadingIndicatorAnimatorDelegate.setMorphFactor(f2);
        }
    };

    public LoadingIndicatorAnimatorDelegate(@NonNull LoadingIndicatorSpec loadingIndicatorSpec) {
        this.specs = loadingIndicatorSpec;
    }

    public static /* synthetic */ int access$004(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        int i2 = loadingIndicatorAnimatorDelegate.morphFactorTarget + 1;
        loadingIndicatorAnimatorDelegate.morphFactorTarget = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getAnimationFraction() {
        return this.animationFraction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMorphFactor() {
        return this.morphFactor;
    }

    private void maybeInitializeAnimators() {
        if (this.springAnimation == null) {
            this.springAnimation = new SpringAnimation(this, MORPH_FACTOR).setSpring(new SpringForce().setStiffness(200.0f).setDampingRatio(SPRING_DAMPING_RATIO)).setMinimumVisibleChange(0.01f);
        }
        if (this.animator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(650L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.loadingindicator.LoadingIndicatorAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LoadingIndicatorAnimatorDelegate.this.springAnimation.animateToFinalPosition(LoadingIndicatorAnimatorDelegate.access$004(LoadingIndicatorAnimatorDelegate.this));
                }
            });
        }
    }

    private void updateIndicatorRotation(int i2) {
        float f2 = this.morphFactorTarget - 1;
        float f3 = this.morphFactor - f2;
        float f4 = i2 / 650.0f;
        if (f4 == 1.0f) {
            f4 = 0.0f;
        }
        this.indicatorState.rotationDegree = ((f3 * 90.0f) + ((f4 * 50.0f) + (f2 * 140.0f))) % 360.0f;
    }

    private void updateIndicatorShapeAndColor() {
        LoadingIndicatorDrawingDelegate.IndicatorState indicatorState = this.indicatorState;
        indicatorState.morphFraction = this.morphFactor;
        int i2 = this.morphFactorTarget - 1;
        int[] iArr = this.specs.indicatorColors;
        int length = i2 % iArr.length;
        indicatorState.color = ArgbEvaluatorCompat.getInstance().evaluate(MathUtils.clamp(this.morphFactor - (this.morphFactorTarget - 1), 0.0f, 1.0f), Integer.valueOf(iArr[length]), Integer.valueOf(iArr[(length + 1) % iArr.length])).intValue();
    }

    public void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        SpringAnimation springAnimation = this.springAnimation;
        if (springAnimation != null) {
            springAnimation.skipToEnd();
        }
    }

    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    public void registerDrawable(@NonNull LoadingIndicatorDrawable loadingIndicatorDrawable) {
        this.drawable = loadingIndicatorDrawable;
    }

    public void resetPropertiesForNewStart() {
        this.morphFactorTarget = 1;
        setMorphFactor(0.0f);
        this.indicatorState.color = this.specs.indicatorColors[0];
    }

    @VisibleForTesting
    public void setAnimationFraction(float f2) {
        this.animationFraction = f2;
        updateIndicatorRotation((int) (f2 * 650.0f));
        LoadingIndicatorDrawable loadingIndicatorDrawable = this.drawable;
        if (loadingIndicatorDrawable != null) {
            loadingIndicatorDrawable.invalidateSelf();
        }
    }

    @VisibleForTesting
    public void setMorphFactor(float f2) {
        this.morphFactor = f2;
        updateIndicatorShapeAndColor();
        LoadingIndicatorDrawable loadingIndicatorDrawable = this.drawable;
        if (loadingIndicatorDrawable != null) {
            loadingIndicatorDrawable.invalidateSelf();
        }
    }

    @VisibleForTesting
    public void setMorphFactorTarget(int i2) {
        this.morphFactorTarget = i2;
    }

    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.springAnimation.animateToFinalPosition(this.morphFactorTarget);
        this.animator.start();
    }
}
