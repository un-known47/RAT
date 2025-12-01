package androidx.transition;

import androidx.transition.Transition;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class c {
    public static void a(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
        transitionListener.onTransitionEnd(transition);
    }

    public static void b(Transition.TransitionListener transitionListener, Transition transition, boolean z2) {
        transitionListener.onTransitionStart(transition);
    }
}
