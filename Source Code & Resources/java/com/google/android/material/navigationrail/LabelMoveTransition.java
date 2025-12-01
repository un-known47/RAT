package com.google.android.material.navigationrail;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class LabelMoveTransition extends Transition {
    private static final float HORIZONTAL_DISTANCE = -30.0f;
    private static final String LABEL_VISIBILITY = "NavigationRailLabelVisibility";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createAnimator$0(View view, ValueAnimator valueAnimator) {
        view.setTranslationX((1.0f - valueAnimator.getAnimatedFraction()) * HORIZONTAL_DISTANCE);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        transitionValues.values.put(LABEL_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        transitionValues.values.put(LABEL_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
    }

    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || transitionValues.values.get(LABEL_VISIBILITY) == null || transitionValues2.values.get(LABEL_VISIBILITY) == null) {
            return super.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
        if (((Integer) transitionValues.values.get(LABEL_VISIBILITY)).intValue() != 8 || ((Integer) transitionValues2.values.get(LABEL_VISIBILITY)).intValue() != 0) {
            return super.createAnimator(viewGroup, transitionValues, transitionValues2);
        }
        final View view = transitionValues2.view;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.navigationrail.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LabelMoveTransition.lambda$createAnimator$0(view, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }
}
