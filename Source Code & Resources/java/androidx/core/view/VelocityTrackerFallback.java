package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j;
        int i2 = this.mDataPointsBufferSize;
        if (i2 < 2) {
            return 0.0f;
        }
        int i3 = this.mDataPointsBufferLastUsedIndex;
        int i4 = ((i3 + 20) - (i2 - 1)) % 20;
        long j2 = this.mEventTimes[i3];
        while (true) {
            jArr = this.mEventTimes;
            j = jArr[i4];
            if (j2 - j <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            i4 = (i4 + 1) % 20;
        }
        int i5 = this.mDataPointsBufferSize;
        if (i5 < 2) {
            return 0.0f;
        }
        if (i5 == 2) {
            int i6 = (i4 + 1) % 20;
            if (j == jArr[i6]) {
                return 0.0f;
            }
            return this.mMovements[i6] / (r2 - j);
        }
        int i7 = 0;
        float f2 = 0.0f;
        for (int i8 = 0; i8 < this.mDataPointsBufferSize - 1; i8++) {
            int i9 = i8 + i4;
            long[] jArr2 = this.mEventTimes;
            long j3 = jArr2[i9 % 20];
            int i10 = (i9 + 1) % 20;
            if (jArr2[i10] != j3) {
                i7++;
                float fKineticEnergyToVelocity = kineticEnergyToVelocity(f2);
                float f3 = this.mMovements[i10] / (this.mEventTimes[i10] - j3);
                float fAbs = (Math.abs(f3) * (f3 - fKineticEnergyToVelocity)) + f2;
                if (i7 == 1) {
                    fAbs *= 0.5f;
                }
                f2 = fAbs;
            }
        }
        return kineticEnergyToVelocity(f2);
    }

    private static float kineticEnergyToVelocity(float f2) {
        return (f2 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f2) * 2.0f));
    }

    public void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i2 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i2;
        int i3 = this.mDataPointsBufferSize;
        if (i3 != 20) {
            this.mDataPointsBufferSize = i3 + 1;
        }
        this.mMovements[i2] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    public void computeCurrentVelocity(int i2) {
        computeCurrentVelocity(i2, Float.MAX_VALUE);
    }

    public float getAxisVelocity(int i2) {
        if (i2 != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int i2, float f2) {
        float currentVelocity = getCurrentVelocity() * i2;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f2))) {
            this.mLastComputedVelocity = -Math.abs(f2);
        } else if (this.mLastComputedVelocity > Math.abs(f2)) {
            this.mLastComputedVelocity = Math.abs(f2);
        }
    }
}
