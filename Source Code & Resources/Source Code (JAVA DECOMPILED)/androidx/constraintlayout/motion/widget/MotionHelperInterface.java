package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.util.HashMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public interface MotionHelperInterface extends Animatable, MotionLayout.TransitionListener {
    boolean isDecorator();

    boolean isUseOnHide();

    boolean isUsedOnShow();

    void onFinishedMotionScene(MotionLayout motionLayout);

    void onPostDraw(Canvas canvas);

    void onPreDraw(Canvas canvas);

    void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> map);
}
