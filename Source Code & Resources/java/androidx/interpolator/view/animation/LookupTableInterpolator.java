package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;
import androidx.appcompat.app.g;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int iMin = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = this.mStepSize;
        float f4 = (f2 - (iMin * f3)) / f3;
        float[] fArr2 = this.mValues;
        float f5 = fArr2[iMin];
        return g.b(fArr2[iMin + 1], f5, f4, f5);
    }
}
