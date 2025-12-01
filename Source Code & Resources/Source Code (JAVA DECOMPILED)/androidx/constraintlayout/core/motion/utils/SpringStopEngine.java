package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d) {
        double d2 = this.mStiffness;
        double d3 = this.mDamping;
        int iSqrt = (int) ((9.0d / ((Math.sqrt(d2 / this.mMass) * d) * 4.0d)) + 1.0d);
        double d4 = d / iSqrt;
        int i2 = 0;
        while (i2 < iSqrt) {
            float f2 = this.mPos;
            double d5 = this.mTargetPos;
            float f3 = this.mV;
            double d6 = d2;
            double d7 = ((-d2) * (f2 - d5)) - (f3 * d3);
            float f4 = this.mMass;
            double d8 = d3;
            double d9 = (((d7 / f4) * d4) / 2.0d) + f3;
            double d10 = ((((-((((d4 * d9) / 2.0d) + f2) - d5)) * d6) - (d9 * d8)) / f4) * d4;
            float f5 = (float) (f3 + d10);
            this.mV = f5;
            float f6 = (float) ((((d10 / 2.0d) + f3) * d4) + f2);
            this.mPos = f6;
            int i3 = this.mBoundaryMode;
            if (i3 > 0) {
                if (f6 < 0.0f && (i3 & 1) == 1) {
                    this.mPos = -f6;
                    this.mV = -f5;
                }
                float f7 = this.mPos;
                if (f7 > 1.0f && (i3 & 2) == 2) {
                    this.mPos = 2.0f - f7;
                    this.mV = -this.mV;
                }
            }
            i2++;
            d2 = d6;
            d3 = d8;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f2) {
        return null;
    }

    public float getAcceleration() {
        return ((float) (((-this.mStiffness) * (this.mPos - this.mTargetPos)) - (this.mDamping * this.mV))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f2) {
        compute(f2 - this.mLastTime);
        this.mLastTime = f2;
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d = this.mPos - this.mTargetPos;
        double d2 = this.mStiffness;
        double d3 = this.mV;
        return Math.sqrt((((d2 * d) * d) + ((d3 * d3) * ((double) this.mMass))) / d2) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    public void springConfig(float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        this.mTargetPos = f3;
        this.mDamping = f7;
        this.mInitialized = false;
        this.mPos = f2;
        this.mLastVelocity = f4;
        this.mStiffness = f6;
        this.mMass = f5;
        this.mStopThreshold = f8;
        this.mBoundaryMode = i2;
        this.mLastTime = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f2) {
        return this.mV;
    }
}
