package androidx.constraintlayout.core.motion;

import androidx.appcompat.app.g;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    HashMap<String, CustomVariable> customAttributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    Motion mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;

    /* renamed from: x, reason: collision with root package name */
    float f46x;

    /* renamed from: y, reason: collision with root package name */
    float f47y;

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    private boolean diff(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    private static final float xRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (((f6 - f4) * f3) - ((f7 - f5) * f2)) + f4;
    }

    private static final float yRotate(float f2, float f3, float f4, float f5, float f6, float f7) {
        return ((f7 - f5) * f3) + ((f6 - f4) * f2) + f5;
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(str, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos(this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z2) {
        boolean zDiff = diff(this.f46x, motionPaths.f46x);
        boolean zDiff2 = diff(this.f47y, motionPaths.f47y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z3 = zDiff | zDiff2 | z2;
        zArr[1] = zArr[1] | z3;
        zArr[2] = z3 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.f46x, this.f47y, this.width, this.height, this.mPathRotate};
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 < 6) {
                dArr[i2] = fArr[r1];
                i2++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.width;
        float f3 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f4 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 3) {
                f2 = f4;
            } else if (i4 == 4) {
                f3 = f4;
            }
        }
        fArr[i2] = f2;
        fArr[i2 + 1] = f3;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i2) {
        float fA = this.f46x;
        float fCos = this.f47y;
        float f2 = this.width;
        float f3 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f4 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                fA = f4;
            } else if (i4 == 2) {
                fCos = f4;
            } else if (i4 == 3) {
                f2 = f4;
            } else if (i4 == 4) {
                f3 = f4;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            double d2 = fA;
            double d3 = fCos;
            fA = (float) (g.a(d3, d2, f5) - (f2 / 2.0f));
            fCos = (float) ((f6 - (Math.cos(d3) * d2)) - (f3 / 2.0f));
        }
        fArr[i2] = (f2 / 2.0f) + fA + 0.0f;
        fArr[i2 + 1] = (f3 / 2.0f) + fCos + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i2) {
        float fA = this.f46x;
        float fCos = this.f47y;
        float f2 = this.width;
        float f3 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f4 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                fA = f4;
            } else if (i4 == 2) {
                fCos = f4;
            } else if (i4 == 3) {
                f2 = f4;
            } else if (i4 == 4) {
                f3 = f4;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            double d2 = fA;
            double d3 = fCos;
            fA = (float) (g.a(d3, d2, f5) - (f2 / 2.0f));
            fCos = (float) ((f6 - (Math.cos(d3) * d2)) - (f3 / 2.0f));
        }
        fArr[i2] = (f2 / 2.0f) + fA + 0.0f;
        fArr[i2 + 1] = (f3 / 2.0f) + fCos + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i2) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i3 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i2] = customVariable.getValueToInterpolate();
            return 1;
        }
        int iNumberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[iNumberOfInterpolatedValues]);
        while (i3 < iNumberOfInterpolatedValues) {
            dArr[i2] = r2[i3];
            i3++;
            i2++;
        }
        return iNumberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float fA = this.f46x;
        float fCos = this.f47y;
        float f2 = this.width;
        float f3 = this.height;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f4 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                fA = f4;
            } else if (i4 == 2) {
                fCos = f4;
            } else if (i4 == 3) {
                f2 = f4;
            } else if (i4 == 4) {
                f3 = f4;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = fA;
            double d2 = fCos;
            fA = (float) (g.a(d2, d, centerX) - (f2 / 2.0f));
            fCos = (float) ((centerY - (Math.cos(d2) * d)) - (f3 / 2.0f));
        }
        float f5 = f2 + fA;
        float f6 = f3 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i2] = fA + 0.0f;
        fArr[i2 + 1] = fCos + 0.0f;
        fArr[i2 + 2] = f5 + 0.0f;
        fArr[i2 + 3] = fCos + 0.0f;
        fArr[i2 + 4] = f5 + 0.0f;
        fArr[i2 + 5] = f6 + 0.0f;
        fArr[i2 + 6] = fA + 0.0f;
        fArr[i2 + 7] = f6 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = f5 - f6;
        float f8 = motionPaths2.height;
        float f9 = motionPaths.height;
        float f10 = f8 - f9;
        this.position = this.time;
        float f11 = motionPaths.f46x;
        float f12 = motionPaths.f47y;
        float f13 = f2;
        float f14 = ((f5 / 2.0f) + motionPaths2.f46x) - ((f6 / 2.0f) + f11);
        float f15 = ((f8 / 2.0f) + motionPaths2.f47y) - ((f9 / 2.0f) + f12);
        float f16 = (f7 * f3) / 2.0f;
        this.f46x = (int) (((f14 * f13) + f11) - f16);
        float f17 = (f10 * f4) / 2.0f;
        this.f47y = (int) (((f15 * f13) + f12) - f17);
        this.width = (int) (f6 + r9);
        this.height = (int) (f9 + r12);
        float f18 = Float.isNaN(motionKeyPosition.mPercentX) ? f13 : motionKeyPosition.mPercentX;
        float f19 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f13 = motionKeyPosition.mPercentY;
        }
        float f20 = Float.isNaN(motionKeyPosition.mAltPercentX) ? 0.0f : motionKeyPosition.mAltPercentX;
        this.mMode = 0;
        this.f46x = (int) (((f20 * f15) + ((f18 * f14) + motionPaths.f46x)) - f16);
        this.f47y = (int) (((f15 * f13) + ((f14 * f19) + motionPaths.f47y)) - f17);
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width - motionPaths.width;
        float f6 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f2 = motionKeyPosition.mPercentX;
        }
        float f7 = motionPaths.f46x;
        float f8 = motionPaths.width;
        float f9 = motionPaths.f47y;
        float f10 = motionPaths.height;
        float f11 = f2;
        float f12 = ((motionPaths2.width / 2.0f) + motionPaths2.f46x) - ((f8 / 2.0f) + f7);
        float f13 = ((motionPaths2.height / 2.0f) + motionPaths2.f47y) - ((f10 / 2.0f) + f9);
        float f14 = f12 * f11;
        float f15 = (f5 * f3) / 2.0f;
        this.f46x = (int) ((f7 + f14) - f15);
        float f16 = f13 * f11;
        float f17 = (f6 * f4) / 2.0f;
        this.f47y = (int) ((f9 + f16) - f17);
        this.width = (int) (f8 + r7);
        this.height = (int) (f10 + r8);
        float f18 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        this.mMode = 1;
        float f19 = (int) ((motionPaths.f46x + f14) - f15);
        float f20 = (int) ((motionPaths.f47y + f16) - f17);
        this.f46x = f19 + ((-f13) * f18);
        this.f47y = f20 + (f12 * f18);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initPolar(int i2, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float fMin;
        float fB;
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (((f5 - f6) * f3) + f6);
        this.height = (int) (((f7 - f8) * f4) + f8);
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            float f9 = Float.isNaN(motionKeyPosition.mPercentX) ? f2 : motionKeyPosition.mPercentX;
            float f10 = motionPaths2.f46x;
            float f11 = motionPaths.f46x;
            this.f46x = g.b(f10, f11, f9, f11);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f2 = motionKeyPosition.mPercentY;
            }
            float f12 = motionPaths2.f47y;
            float f13 = motionPaths.f47y;
            this.f47y = g.b(f12, f13, f2, f13);
        } else if (i4 != 2) {
            float f14 = Float.isNaN(motionKeyPosition.mPercentX) ? f2 : motionKeyPosition.mPercentX;
            float f15 = motionPaths2.f46x;
            float f16 = motionPaths.f46x;
            this.f46x = g.b(f15, f16, f14, f16);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f2 = motionKeyPosition.mPercentY;
            }
            float f17 = motionPaths2.f47y;
            float f18 = motionPaths.f47y;
            this.f47y = g.b(f17, f18, f2, f18);
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f19 = motionPaths2.f46x;
                float f20 = motionPaths.f46x;
                fMin = g.b(f19, f20, f2, f20);
            } else {
                fMin = Math.min(f4, f3) * motionKeyPosition.mPercentX;
            }
            this.f46x = fMin;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f21 = motionPaths2.f47y;
                float f22 = motionPaths.f47y;
                fB = g.b(f21, f22, f2, f22);
            } else {
                fB = motionKeyPosition.mPercentY;
            }
            this.f47y = fB;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i2, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = f5 - motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = f7 - motionPaths.height;
        this.position = this.time;
        float f9 = motionPaths.f46x;
        float f10 = motionPaths.f47y;
        float f11 = (f5 / 2.0f) + motionPaths2.f46x;
        float f12 = (f7 / 2.0f) + motionPaths2.f47y;
        float f13 = f6 * f3;
        this.f46x = (int) ((((f11 - ((r8 / 2.0f) + f9)) * f2) + f9) - (f13 / 2.0f));
        float f14 = f8 * f4;
        this.f47y = (int) ((((f12 - ((r11 / 2.0f) + f10)) * f2) + f10) - (f14 / 2.0f));
        this.width = (int) (r8 + f13);
        this.height = (int) (r11 + f14);
        this.mMode = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.f46x = (int) (motionKeyPosition.mPercentX * ((int) (i2 - this.width)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.f47y = (int) (motionKeyPosition.mPercentY * ((int) (i3 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void setBounds(float f2, float f3, float f4, float f5) {
        this.f46x = f2;
        this.f47y = f3;
        this.width = f4;
        this.height = f5;
    }

    public void setDpDt(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f8 = (float) dArr[i2];
            double d = dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f4 = f8;
            } else if (i3 == 2) {
                f6 = f8;
            } else if (i3 == 3) {
                f5 = f8;
            } else if (i3 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (((f5 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
        fArr[1] = (((f7 * 1.0f) + f10) * f3) + ((1.0f - f3) * f10) + 0.0f;
    }

    public void setView(float f2, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f3;
        float f4 = this.f46x;
        float f5 = this.f47y;
        float f6 = this.width;
        float f7 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i2 = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i2];
            this.mTempDelta = new double[i2];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i3 = 0; i3 < iArr.length; i3++) {
            double[] dArr4 = this.mTempValue;
            int i4 = iArr[i3];
            dArr4[i4] = dArr[i3];
            this.mTempDelta[i4] = dArr2[i3];
        }
        float f8 = Float.NaN;
        int i5 = 0;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            double[] dArr5 = this.mTempValue;
            if (i5 >= dArr5.length) {
                break;
            }
            if (Double.isNaN(dArr5[i5]) && (dArr3 == null || dArr3[i5] == 0.0d)) {
                f3 = f8;
            } else {
                double d = dArr3 != null ? dArr3[i5] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i5])) {
                    d = this.mTempValue[i5] + d;
                }
                f3 = f8;
                float f13 = (float) d;
                float f14 = (float) this.mTempDelta[i5];
                if (i5 == 1) {
                    f8 = f3;
                    f9 = f14;
                    f4 = f13;
                } else if (i5 == 2) {
                    f8 = f3;
                    f10 = f14;
                    f5 = f13;
                } else if (i5 == 3) {
                    f8 = f3;
                    f11 = f14;
                    f6 = f13;
                } else if (i5 == 4) {
                    f8 = f3;
                    f12 = f14;
                    f7 = f13;
                } else if (i5 == 5) {
                    f8 = f13;
                }
                i5++;
            }
            f8 = f3;
            i5++;
        }
        float f15 = f8;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f2, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d2 = f16;
            double d3 = f4;
            double d4 = f5;
            float fA = (float) (g.a(d4, d3, d2) - (f6 / 2.0f));
            float fCos = (float) ((f17 - (Math.cos(d4) * d3)) - (f7 / 2.0f));
            double d5 = f18;
            double d6 = f9;
            double d7 = f10;
            float fCos2 = (float) ((Math.cos(d4) * d3 * d7) + g.a(d4, d6, d5));
            float fSin = (float) ((Math.sin(d4) * d3 * d7) + (f19 - (Math.cos(d4) * d6)));
            if (dArr2.length >= 2) {
                dArr2[0] = fCos2;
                dArr2[1] = fSin;
            }
            if (!Float.isNaN(f15)) {
                motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2(fSin, fCos2)) + f15));
            }
            f4 = fA;
            f5 = fCos;
        } else if (!Float.isNaN(f15)) {
            motionWidget.setRotationZ((float) (Math.toDegrees(Math.atan2((f12 / 2.0f) + f10, (f11 / 2.0f) + f9)) + f15 + 0.0f));
        }
        float f20 = f4 + 0.5f;
        float f21 = f5 + 0.5f;
        motionWidget.layout((int) f20, (int) f21, (int) (f20 + f6), (int) (f21 + f7));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = (((this.width / 2.0f) + this.f46x) - motionPaths.f46x) - (motionPaths.width / 2.0f);
        double d2 = (((this.height / 2.0f) + this.f47y) - motionPaths.f47y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motion;
        this.f46x = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.f47y = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.f47y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i2, int i3, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = -1;
        this.mAnimateRelativeTo = -1;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.customAttributes = new HashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i2, i3, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i4 = motionKeyPosition.mPositionType;
        if (i4 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i4 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i2, i3, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f2;
        float fA = this.f46x;
        float fCos = this.f47y;
        float f3 = this.width;
        float f4 = this.height;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f9 = (float) dArr[i2];
            float f10 = (float) dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                fA = f9;
                f5 = f10;
            } else if (i3 == 2) {
                fCos = f9;
                f7 = f10;
            } else if (i3 == 3) {
                f3 = f9;
                f6 = f10;
            } else if (i3 == 4) {
                f4 = f9;
                f8 = f10;
            }
        }
        float f11 = (f6 / 2.0f) + f5;
        float fA2 = (f8 / 2.0f) + f7;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
            float f12 = fArr3[0];
            float f13 = fArr3[1];
            float f14 = fArr4[0];
            float f15 = fArr4[1];
            f2 = 2.0f;
            double d2 = fA;
            double d3 = fCos;
            fA = (float) (g.a(d3, d2, f12) - (f3 / 2.0f));
            fCos = (float) ((f13 - (Math.cos(d3) * d2)) - (f4 / 2.0f));
            double d4 = f5;
            double dA = g.a(d3, d4, f14);
            double d5 = f7;
            float fCos2 = (float) ((Math.cos(d3) * d5) + dA);
            fA2 = (float) g.a(d3, d5, f15 - (Math.cos(d3) * d4));
            f11 = fCos2;
        } else {
            f2 = 2.0f;
        }
        fArr[0] = (f3 / f2) + fA + 0.0f;
        fArr[1] = (f4 / f2) + fCos + 0.0f;
        fArr2[0] = f11;
        fArr2[1] = fA2;
    }
}
