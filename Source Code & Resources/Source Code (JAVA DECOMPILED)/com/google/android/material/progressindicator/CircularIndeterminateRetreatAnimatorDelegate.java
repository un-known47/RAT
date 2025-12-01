package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
final class CircularIndeterminateRetreatAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<CircularIndeterminateRetreatAnimatorDelegate, Float> ANIMATION_FRACTION;
    private static final Property<CircularIndeterminateRetreatAnimatorDelegate, Float> COMPLETE_END_FRACTION;
    private static final int CONSTANT_ROTATION_DEGREES = 1080;
    private static final int DELAY_GROW_ACTIVE_IN_MS = 0;
    private static final int DELAY_SHRINK_ACTIVE_IN_MS = 3000;
    private static final int DURATION_GROW_ACTIVE_IN_MS = 3000;
    private static final int DURATION_SHRINK_ACTIVE_IN_MS = 3000;
    private static final int DURATION_SPIN_IN_MS = 500;
    private static final int DURATION_TO_COMPLETE_END_IN_MS = 500;
    private static final int DURATION_TO_FADE_IN_MS = 100;
    private static final int SPIN_ROTATION_DEGREES = 90;
    private static final float START_FRACTION = 0.0f;
    private static final int TOTAL_DURATION_IN_MS = 6000;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    private int indicatorColorIndexOffset;
    private final TimeInterpolator standardInterpolator;
    private static final TimeInterpolator DEFAULT_INTERPOLATOR = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    private static final int[] DELAY_SPINS_IN_MS = {0, 1500, PathInterpolatorCompat.MAX_NUM_POINTS, 4500};
    private static final float[] END_FRACTION_RANGE = {0.1f, 0.87f};

    static {
        Class<Float> cls = Float.class;
        ANIMATION_FRACTION = new Property<CircularIndeterminateRetreatAnimatorDelegate, Float>(cls, "animationFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate.3
            @Override // android.util.Property
            public Float get(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateRetreatAnimatorDelegate.getAnimationFraction());
            }

            @Override // android.util.Property
            public void set(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f2) {
                circularIndeterminateRetreatAnimatorDelegate.setAnimationFraction(f2.floatValue());
            }
        };
        COMPLETE_END_FRACTION = new Property<CircularIndeterminateRetreatAnimatorDelegate, Float>(cls, "completeEndFraction") { // from class: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate.4
            @Override // android.util.Property
            public Float get(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
                return Float.valueOf(circularIndeterminateRetreatAnimatorDelegate.getCompleteEndFraction());
            }

            @Override // android.util.Property
            public void set(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f2) {
                circularIndeterminateRetreatAnimatorDelegate.setCompleteEndFraction(f2.floatValue());
            }
        };
    }

    public CircularIndeterminateRetreatAnimatorDelegate(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = circularProgressIndicatorSpec;
        this.standardInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingStandardInterpolator, DEFAULT_INTERPOLATOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getAnimationFraction() {
        return this.animationFraction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 6000.0f));
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate = CircularIndeterminateRetreatAnimatorDelegate.this;
                    circularIndeterminateRetreatAnimatorDelegate.indicatorColorIndexOffset = (circularIndeterminateRetreatAnimatorDelegate.indicatorColorIndexOffset + CircularIndeterminateRetreatAnimatorDelegate.DELAY_SPINS_IN_MS.length) % CircularIndeterminateRetreatAnimatorDelegate.this.baseSpec.indicatorColors.length;
                }
            });
        }
        if (this.completeEndAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, 0.0f, 1.0f);
            this.completeEndAnimator = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 500.0f));
            this.completeEndAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateRetreatAnimatorDelegate.this.cancelAnimatorImmediately();
                    CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate = CircularIndeterminateRetreatAnimatorDelegate.this;
                    Animatable2Compat.AnimationCallback animationCallback = circularIndeterminateRetreatAnimatorDelegate.animatorCompleteCallback;
                    if (animationCallback != null) {
                        animationCallback.onAnimationEnd(circularIndeterminateRetreatAnimatorDelegate.drawable);
                    }
                }
            });
        }
    }

    private void maybeUpdateSegmentColors(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = DELAY_SPINS_IN_MS;
            if (i3 >= iArr.length) {
                return;
            }
            float fractionInRange = getFractionInRange(i2, iArr[i3], 100);
            if (fractionInRange >= 0.0f && fractionInRange <= 1.0f) {
                int i4 = i3 + this.indicatorColorIndexOffset;
                int[] iArr2 = this.baseSpec.indicatorColors;
                int length = i4 % iArr2.length;
                int length2 = (length + 1) % iArr2.length;
                int i5 = iArr2[length];
                int i6 = iArr2[length2];
                float interpolation = this.standardInterpolator.getInterpolation(fractionInRange);
                this.activeIndicators.get(0).color = ArgbEvaluatorCompat.getInstance().evaluate(interpolation, Integer.valueOf(i5), Integer.valueOf(i6)).intValue();
                return;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCompleteEndFraction(float f2) {
        this.completeEndFraction = f2;
    }

    private void updateAnimatorsDuration() {
        maybeInitializeAnimators();
        this.animator.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 6000.0f));
        this.completeEndAnimator.setDuration((long) (this.baseSpec.indeterminateAnimatorDurationScale * 500.0f));
    }

    private void updateSegmentPositions(int i2) {
        DrawingDelegate.ActiveIndicator activeIndicator = this.activeIndicators.get(0);
        float f2 = this.animationFraction * 1080.0f;
        float interpolation = 0.0f;
        for (int i3 : DELAY_SPINS_IN_MS) {
            interpolation += this.standardInterpolator.getInterpolation(getFractionInRange(i2, i3, 500)) * 90.0f;
        }
        activeIndicator.rotationDegree = f2 + interpolation;
        float interpolation2 = this.standardInterpolator.getInterpolation(getFractionInRange(i2, 0, PathInterpolatorCompat.MAX_NUM_POINTS)) - this.standardInterpolator.getInterpolation(getFractionInRange(i2, PathInterpolatorCompat.MAX_NUM_POINTS, PathInterpolatorCompat.MAX_NUM_POINTS));
        activeIndicator.startFraction = 0.0f;
        float[] fArr = END_FRACTION_RANGE;
        float fLerp = MathUtils.lerp(fArr[0], fArr[1], interpolation2);
        activeIndicator.endFraction = fLerp;
        float f3 = this.completeEndFraction;
        if (f3 > 0.0f) {
            activeIndicator.endFraction = (1.0f - f3) * fLerp;
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void cancelAnimatorImmediately() {
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void invalidateSpecValues() {
        updateAnimatorsDuration();
        resetPropertiesForNewStart();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.animatorCompleteCallback = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
        ObjectAnimator objectAnimator = this.completeEndAnimator;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.drawable.isVisible()) {
            this.completeEndAnimator.start();
        } else {
            cancelAnimatorImmediately();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.activeIndicators.get(0).color = this.baseSpec.indicatorColors[0];
        this.completeEndFraction = 0.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    @VisibleForTesting
    public void setAnimationFraction(float f2) {
        this.animationFraction = f2;
        int i2 = (int) (f2 * 6000.0f);
        updateSegmentPositions(i2);
        maybeUpdateSegmentColors(i2);
        this.drawable.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
