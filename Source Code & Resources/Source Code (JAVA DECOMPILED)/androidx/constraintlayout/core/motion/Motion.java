package androidx.constraintlayout.core.motion;

import androidx.appcompat.app.g;
import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class Motion {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private MotionKeyTrigger[] mKeyTriggers;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    MotionWidget mView;
    Rect mTempRect = new Rect();
    private int mCurveFitType = -1;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int MAX_DIMENSION = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private int mPathMotionArc = -1;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private int mQuantizeMotionSteps = -1;
    private float mQuantizeMotionPhase = Float.NaN;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    private float getAdjustedPosition(float f2, float[] fArr) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.mStaggerScale;
            if (f4 != 1.0d) {
                float f5 = this.mStaggerOffset;
                if (f2 < f5) {
                    f2 = 0.0f;
                }
                if (f2 > f5 && f2 < 1.0d) {
                    f2 = Math.min((f2 - f5) * f4, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        float f6 = Float.NaN;
        int i2 = 0;
        while (i2 < size) {
            MotionPaths motionPaths = arrayList.get(i2);
            i2++;
            MotionPaths motionPaths2 = motionPaths;
            Easing easing2 = motionPaths2.mKeyFrameEasing;
            if (easing2 != null) {
                float f7 = motionPaths2.time;
                if (f7 < f2) {
                    easing = easing2;
                    f3 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = motionPaths2.time;
                }
            }
        }
        if (easing != null) {
            float f8 = (Float.isNaN(f6) ? 1.0f : f6) - f3;
            double d = (f2 - f3) / f8;
            f2 = (((float) easing.get(d)) * f8) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f2;
    }

    private static DifferentialInterpolator getInterpolator(int i2, String str, int i3) {
        if (i2 != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1
            float mX;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f2) {
                this.mX = f2;
                return (float) interpolator.get(f2);
            }

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getVelocity() {
                return (float) interpolator.getDiff(this.mX);
            }
        };
    }

    private float getPreCycleDistance() {
        float[] fArr = new float[2];
        float f2 = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        int i2 = 0;
        float fHypot = 0.0f;
        while (i2 < 100) {
            float f3 = i2 * f2;
            double d3 = f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f4 = Float.NaN;
            int i3 = 0;
            float f5 = 0.0f;
            while (i3 < size) {
                MotionPaths motionPaths = arrayList.get(i3);
                i3++;
                float f6 = f2;
                MotionPaths motionPaths2 = motionPaths;
                int i4 = i2;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f7 = motionPaths2.time;
                    if (f7 < f3) {
                        f5 = f7;
                        easing = easing2;
                    } else if (Float.isNaN(f4)) {
                        f4 = motionPaths2.time;
                    }
                }
                i2 = i4;
                f2 = f6;
            }
            float f8 = f2;
            int i5 = i2;
            if (easing != null) {
                if (Float.isNaN(f4)) {
                    f4 = 1.0f;
                }
                d3 = (((float) easing.get((f3 - f5) / r16)) * (f4 - f5)) + f5;
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            float f9 = fHypot;
            this.mStartMotionPath.getCenter(d3, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i5 > 0) {
                fHypot = (float) (Math.hypot(d2 - fArr[1], d - fArr[0]) + f9);
            } else {
                fHypot = f9;
            }
            d = fArr[0];
            d2 = fArr[1];
            i2 = i5 + 1;
            f2 = f8;
        }
        return fHypot;
    }

    private void insertKey(MotionPaths motionPaths) {
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        MotionPaths motionPaths2 = null;
        int i2 = 0;
        while (i2 < size) {
            MotionPaths motionPaths3 = arrayList.get(i2);
            i2++;
            MotionPaths motionPaths4 = motionPaths3;
            if (motionPaths.position == motionPaths4.position) {
                motionPaths2 = motionPaths4;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.position + "\" outside of range");
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    public void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i2) {
        float f2 = 1.0f;
        float f3 = 1.0f / (i2 - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            map4.get("translationY");
        }
        int i3 = 0;
        while (i3 < i2) {
            float fMin = i3 * f3;
            float f4 = this.mStaggerScale;
            float f5 = 0.0f;
            if (f4 != f2) {
                float f6 = this.mStaggerOffset;
                if (fMin < f6) {
                    fMin = 0.0f;
                }
                if (fMin > f6 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f6) * f4, f2);
                }
            }
            double d = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f7 = Float.NaN;
            int i4 = 0;
            while (i4 < size) {
                MotionPaths motionPaths = arrayList.get(i4);
                i4++;
                MotionPaths motionPaths2 = motionPaths;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f8 = motionPaths2.time;
                    if (f8 < fMin) {
                        easing = easing2;
                        f5 = f8;
                    } else if (Float.isNaN(f7)) {
                        f7 = motionPaths2.time;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                d = (((float) easing.get((fMin - f5) / r13)) * (f7 - f5)) + f5;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 2);
            i3++;
            f2 = 1.0f;
        }
    }

    public int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                MotionPaths motionPaths = arrayList.get(i3);
                i3++;
                iArr[i2] = motionPaths.mMode;
                i2++;
            }
        }
        int i4 = 0;
        for (double d : timePoints) {
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
            i4 += 2;
        }
        return i4 / 2;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr == null) {
            return 0;
        }
        double[] timePoints = this.mSpline[0].getTimePoints();
        if (iArr != null) {
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            int i2 = 0;
            int i3 = 0;
            while (i3 < size) {
                MotionPaths motionPaths = arrayList.get(i3);
                i3++;
                iArr[i2] = motionPaths.mMode;
                i2++;
            }
        }
        if (iArr2 != null) {
            ArrayList<MotionPaths> arrayList2 = this.mMotionPaths;
            int size2 = arrayList2.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size2) {
                MotionPaths motionPaths2 = arrayList2.get(i5);
                i5++;
                iArr2[i4] = (int) (motionPaths2.position * 100.0f);
                i4++;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < timePoints.length; i7++) {
            this.mSpline[0].getPos(timePoints[i7], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i7], this.mInterpolateVariables, this.mInterpolateData, fArr, i6);
            i6 += 2;
        }
        return i6 / 2;
    }

    public void buildPath(float[] fArr, int i2) {
        int i3 = i2;
        float f2 = 1.0f;
        float f3 = 1.0f / (i3 - 1);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, KeyCycleOscillator> map3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, KeyCycleOscillator> map4 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map4 != null ? map4.get("translationY") : null;
        int i4 = 0;
        while (i4 < i3) {
            float fMin = i4 * f3;
            float f4 = this.mStaggerScale;
            float f5 = 0.0f;
            if (f4 != f2) {
                float f6 = this.mStaggerOffset;
                if (fMin < f6) {
                    fMin = 0.0f;
                }
                if (fMin > f6 && fMin < 1.0d) {
                    fMin = Math.min((fMin - f6) * f4, f2);
                }
            }
            double d = fMin;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            ArrayList<MotionPaths> arrayList = this.mMotionPaths;
            int size = arrayList.size();
            float f7 = Float.NaN;
            int i5 = 0;
            while (i5 < size) {
                MotionPaths motionPaths = arrayList.get(i5);
                i5++;
                MotionPaths motionPaths2 = motionPaths;
                float f8 = f3;
                Easing easing2 = motionPaths2.mKeyFrameEasing;
                if (easing2 != null) {
                    float f9 = motionPaths2.time;
                    if (f9 < fMin) {
                        f5 = f9;
                        easing = easing2;
                    } else if (Float.isNaN(f7)) {
                        f7 = motionPaths2.time;
                    }
                }
                f3 = f8;
            }
            float f10 = f3;
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                d = (((float) easing.get((fMin - f5) / r17)) * (f7 - f5)) + f5;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i6 = i4 * 2;
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i6);
            if (keyCycleOscillator != null) {
                fArr[i6] = keyCycleOscillator.get(fMin) + fArr[i6];
            } else if (splineSet != null) {
                fArr[i6] = splineSet.get(fMin) + fArr[i6];
            }
            if (keyCycleOscillator2 != null) {
                int i7 = i6 + 1;
                fArr[i7] = keyCycleOscillator2.get(fMin) + fArr[i7];
            } else if (splineSet2 != null) {
                int i8 = i6 + 1;
                fArr[i8] = splineSet2.get(fMin) + fArr[i8];
            }
            i4++;
            i3 = i2;
            f3 = f10;
            f2 = 1.0f;
        }
    }

    public void buildRect(float f2, float[] fArr, int i2) {
        this.mSpline[0].getPos(getAdjustedPosition(f2, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
    }

    public void buildRectangles(float[] fArr, int i2) {
        float f2 = 1.0f / (i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            this.mSpline[0].getPos(getAdjustedPosition(i3 * f2, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i3 * 8);
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i2) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = splineSet.get(i3 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d, dArr);
        this.mSpline[0].getSlope(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getDpDt(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i2 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f5 = motionPaths.f46x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f6 = f5 - motionPaths2.f46x;
            float f7 = motionPaths.f47y - motionPaths2.f47y;
            float f8 = motionPaths.width - motionPaths2.width;
            float f9 = (motionPaths.height - motionPaths2.height) + f7;
            fArr[0] = ((f8 + f6) * f3) + ((1.0f - f3) * f6);
            fArr[1] = (f9 * f4) + ((1.0f - f4) * f7);
            return;
        }
        double d = adjustedPosition;
        curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d, this.mInterpolateData);
        float f10 = this.mVelocity[0];
        while (true) {
            dArr = this.mInterpolateVelocity;
            if (i2 >= dArr.length) {
                break;
            }
            dArr[i2] = dArr[i2] * f10;
            i2++;
        }
        CurveFit curveFit = this.mArcSpline;
        if (curveFit == null) {
            this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        double[] dArr2 = this.mInterpolateData;
        if (dArr2.length > 0) {
            curveFit.getPos(d, dArr2);
            this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
        }
    }

    public int getDrawPath() {
        int iMax = this.mStartMotionPath.mDrawPath;
        ArrayList<MotionPaths> arrayList = this.mMotionPaths;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            MotionPaths motionPaths = arrayList.get(i2);
            i2++;
            iMax = Math.max(iMax, motionPaths.mDrawPath);
        }
        return Math.max(iMax, this.mEndMotionPath.mDrawPath);
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.height;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.width;
    }

    public float getFinalX() {
        return this.mEndMotionPath.f46x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f47y;
    }

    public MotionPaths getKeyFrame(int i2) {
        return this.mMotionPaths.get(i2);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < size) {
            int i6 = i3 + 1;
            MotionKey motionKey = arrayList.get(i3);
            int i7 = motionKey.mType;
            if (i7 == i2 || i2 != -1) {
                iArr[i5] = 0;
                iArr[i5 + 1] = i7;
                int i8 = motionKey.mFramePosition;
                iArr[i5 + 2] = i8;
                double d = i8 / 100.0f;
                this.mSpline[0].getPos(d, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i5 + 3] = Float.floatToIntBits(fArr[0]);
                int i9 = i5 + 4;
                iArr[i9] = Float.floatToIntBits(fArr[1]);
                if (motionKey instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                    iArr[i5 + 5] = motionKeyPosition.mPositionType;
                    iArr[i5 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i9 = i5 + 7;
                    iArr[i9] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i10 = i9 + 1;
                iArr[i5] = i10 - i5;
                i4++;
                i5 = i10;
            }
            i3 = i6;
        }
        return i4;
    }

    public float getKeyFrameParameter(int i2, float f2, float f3) {
        MotionPaths motionPaths = this.mEndMotionPath;
        float f4 = motionPaths.f46x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f5 = motionPaths2.f46x;
        float f6 = f4 - f5;
        float f7 = motionPaths.f47y;
        float f8 = motionPaths2.f47y;
        float f9 = f7 - f8;
        float f10 = (motionPaths2.width / 2.0f) + f5;
        float f11 = (motionPaths2.height / 2.0f) + f8;
        float fHypot = (float) Math.hypot(f6, f9);
        if (fHypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f12 = f2 - f10;
        float f13 = f3 - f11;
        if (((float) Math.hypot(f12, f13)) == 0.0f) {
            return 0.0f;
        }
        float f14 = (f13 * f9) + (f12 * f6);
        if (i2 == 0) {
            return f14 / fHypot;
        }
        if (i2 == 1) {
            return (float) Math.sqrt((fHypot * fHypot) - (f14 * f14));
        }
        if (i2 == 2) {
            return f12 / f6;
        }
        if (i2 == 3) {
            return f13 / f6;
        }
        if (i2 == 4) {
            return f12 / f9;
        }
        if (i2 != 5) {
            return 0.0f;
        }
        return f13 / f9;
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            int i5 = i3 + 1;
            MotionKey motionKey = arrayList.get(i3);
            int i6 = motionKey.mFramePosition;
            iArr[i2] = (motionKey.mType * 1000) + i6;
            double d = i6 / 100.0f;
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
            i4 += 2;
            i3 = i5;
            i2++;
        }
        return i2;
    }

    public double[] getPos(double d) {
        this.mSpline[0].getPos(d, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d, dArr);
            }
        }
        return this.mInterpolateData;
    }

    public MotionKeyPosition getPositionKeyframe(int i2, int i3, float f2, float f3) {
        int i4;
        int i5;
        float f4;
        float f5;
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f6 = motionPaths.f46x;
        floatRect.left = f6;
        float f7 = motionPaths.f47y;
        floatRect.top = f7;
        floatRect.right = f6 + motionPaths.width;
        floatRect.bottom = f7 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f8 = motionPaths2.f46x;
        floatRect2.left = f8;
        float f9 = motionPaths2.f47y;
        floatRect2.top = f9;
        floatRect2.right = f8 + motionPaths2.width;
        floatRect2.bottom = f9 + motionPaths2.height;
        ArrayList<MotionKey> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            MotionKey motionKey = arrayList.get(i6);
            if (motionKey instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey;
                i4 = i2;
                i5 = i3;
                f4 = f2;
                f5 = f3;
                if (motionKeyPosition.intersects(i4, i5, floatRect, floatRect2, f4, f5)) {
                    return motionKeyPosition;
                }
            } else {
                i4 = i2;
                i5 = i3;
                f4 = f2;
                f5 = f3;
            }
            i2 = i4;
            i3 = i5;
            f2 = f4;
            f3 = f5;
            i6 = i7;
        }
        return null;
    }

    public void getPostLayoutDvDp(float f2, int i2, int i3, float f3, float f4, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f2, this.mVelocity);
        HashMap<String, SplineSet> map = this.mAttributesMap;
        SplineSet splineSet = map == null ? null : map.get("translationX");
        HashMap<String, SplineSet> map2 = this.mAttributesMap;
        SplineSet splineSet2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, SplineSet> map3 = this.mAttributesMap;
        SplineSet splineSet3 = map3 == null ? null : map3.get("rotationZ");
        HashMap<String, SplineSet> map4 = this.mAttributesMap;
        SplineSet splineSet4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, SplineSet> map5 = this.mAttributesMap;
        SplineSet splineSet5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, KeyCycleOscillator> map6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, KeyCycleOscillator> map7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, KeyCycleOscillator> map8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = map8 == null ? null : map8.get("rotationZ");
        HashMap<String, KeyCycleOscillator> map9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, KeyCycleOscillator> map10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = adjustedPosition;
                curveFit.getPos(d, dArr);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
            return;
        }
        int i4 = 0;
        if (this.mSpline == null) {
            MotionPaths motionPaths = this.mEndMotionPath;
            float f5 = motionPaths.f46x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f6 = f5 - motionPaths2.f46x;
            float f7 = motionPaths.f47y - motionPaths2.f47y;
            float f8 = motionPaths.width - motionPaths2.width;
            float f9 = f7 + (motionPaths.height - motionPaths2.height);
            fArr[0] = ((f8 + f6) * f3) + ((1.0f - f3) * f6);
            fArr[1] = (f9 * f4) + ((1.0f - f4) * f7);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
            return;
        }
        double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
        this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
        this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
        float f10 = this.mVelocity[0];
        while (true) {
            double[] dArr2 = this.mInterpolateVelocity;
            if (i4 >= dArr2.length) {
                this.mStartMotionPath.setDpDt(f3, f4, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                velocityMatrix.applyTransform(f3, f4, i2, i3, fArr);
                return;
            } else {
                dArr2[i4] = dArr2[i4] * f10;
                i4++;
            }
        }
    }

    public float getStartHeight() {
        return this.mStartMotionPath.height;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.width;
    }

    public float getStartX() {
        return this.mStartMotionPath.f46x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f47y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public boolean interpolate(MotionWidget motionWidget, float f2, long j, KeyCache keyCache) {
        MotionWidget motionWidget2 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f2, null);
        int i2 = this.mQuantizeMotionSteps;
        if (i2 != -1) {
            float f3 = 1.0f / i2;
            float fFloor = ((float) Math.floor(adjustedPosition / f3)) * f3;
            float f4 = (adjustedPosition % f3) / f3;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f4 = (f4 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((differentialInterpolator != null ? differentialInterpolator.getInterpolation(f4) : ((double) f4) > 0.5d ? 1.0f : 0.0f) * f3) + fFloor;
        }
        float f5 = adjustedPosition;
        HashMap<String, SplineSet> map = this.mAttributesMap;
        if (map != null) {
            Iterator<SplineSet> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(motionWidget2, f5);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d = f5;
            curveFitArr[0].getPos(d, this.mInterpolateData);
            this.mSpline[0].getSlope(d, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                this.mStartMotionPath.setView(f5, motionWidget2, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                f5 = f5;
                motionWidget2 = motionWidget2;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget2.getParent().findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + r1.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (motionWidget2.getRight() - motionWidget2.getLeft() > 0 && motionWidget2.getBottom() - motionWidget2.getTop() > 0) {
                        motionWidget2.setPivotX(right - motionWidget2.getLeft());
                        motionWidget2.setPivotY(bottom - motionWidget2.getTop());
                    }
                }
            }
            int i3 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i3 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i3].getPos(d, this.mValuesBuff);
                this.mStartMotionPath.customAttributes.get(this.mAttributeNames[i3 - 1]).setInterpolatedValue(motionWidget2, this.mValuesBuff);
                i3++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (f5 <= 0.0f) {
                    motionWidget2.setVisibility(motionConstrainedPoint.visibility);
                } else if (f5 >= 1.0f) {
                    motionWidget2.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    motionWidget2.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i4 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i4 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i4].conditionallyFire(f5, motionWidget2);
                    i4++;
                }
            }
        } else {
            MotionPaths motionPaths = this.mStartMotionPath;
            float f6 = motionPaths.f46x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float fB = g.b(motionPaths2.f46x, f6, f5, f6);
            float f7 = motionPaths.f47y;
            float fB2 = g.b(motionPaths2.f47y, f7, f5, f7);
            float f8 = motionPaths.width;
            float fB3 = g.b(motionPaths2.width, f8, f5, f8);
            float f9 = motionPaths.height;
            float f10 = fB + 0.5f;
            float f11 = fB2 + 0.5f;
            motionWidget2.layout((int) f10, (int) f11, (int) (f10 + fB3), (int) (f11 + g.b(motionPaths2.height, f9, f5, f9)));
        }
        HashMap<String, KeyCycleOscillator> map2 = this.mCycleMap;
        if (map2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : map2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget2, f5, dArr2[0], dArr2[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget2, f5);
                }
            }
        }
        return false;
    }

    public String name() {
        return this.mView.getName();
    }

    public void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f2, float f3, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f4 = motionPaths.f46x;
        floatRect.left = f4;
        float f5 = motionPaths.f47y;
        floatRect.top = f5;
        floatRect.right = f4 + motionPaths.width;
        floatRect.bottom = f5 + motionPaths.height;
        FloatRect floatRect2 = new FloatRect();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f6 = motionPaths2.f46x;
        floatRect2.left = f6;
        float f7 = motionPaths2.f47y;
        floatRect2.top = f7;
        floatRect2.right = f6 + motionPaths2.width;
        floatRect2.bottom = f7 + motionPaths2.height;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f2, f3, strArr, fArr);
    }

    public void rotate(Rect rect, Rect rect2, int i2, int i3, int i4) {
        if (i2 == 1) {
            int i5 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i4 - ((rect.height() + i5) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 == 2) {
            int i6 = rect.left + rect.right;
            rect2.left = i3 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 == 3) {
            int i7 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i7 / 2);
            rect2.top = i4 - ((rect.height() + i7) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 != 4) {
            return;
        }
        int i8 = rect.left + rect.right;
        rect2.left = i3 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i8 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public void setBothStates(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setDrawPath(int i2) {
        this.mStartMotionPath.mDrawPath = i2;
    }

    public void setEnd(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        this.mEndMotionPath.setBounds(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setPathMotionArc(int i2) {
        this.mPathMotionArc = i2;
    }

    public void setStart(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i2, int i3, int i4) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        Rect rect = new Rect();
        if (i2 == 1) {
            int i5 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i3 - ((viewState.height() + i5) / 2);
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        } else if (i2 == 2) {
            int i6 = viewState.left + viewState.right;
            rect.left = i4 - ((viewState.width() + (viewState.top + viewState.bottom)) / 2);
            rect.top = (i6 - viewState.height()) / 2;
            rect.right = viewState.width() + rect.left;
            rect.bottom = viewState.height() + rect.top;
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, motionWidget, i2, viewState.rotation);
    }

    public void setTransformPivotTarget(int i2) {
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    public void setup(int i2, int i3, float f2, long j) {
        ArrayList arrayList;
        HashSet<String> hashSet;
        HashSet<String> hashSet2;
        char c;
        String[] strArr;
        int i4;
        int i5;
        CustomVariable customVariable;
        SplineSet splineSetMakeSpline;
        CustomVariable customVariable2;
        Integer num;
        HashSet<String> hashSet3;
        HashSet<String> hashSet4;
        SplineSet splineSetMakeSpline2;
        CustomVariable customVariable3;
        new HashSet();
        HashSet<String> hashSet5 = new HashSet<>();
        HashSet<String> hashSet6 = new HashSet<>();
        HashSet<String> hashSet7 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i6 = this.mPathMotionArc;
        if (i6 != -1) {
            this.mStartMotionPath.mPathMotionArc = i6;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet6);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        int i7 = 0;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            arrayList = null;
            int i8 = 0;
            while (i8 < size) {
                MotionKey motionKey = arrayList2.get(i8);
                i8++;
                MotionKey motionKey2 = motionKey;
                if (motionKey2 instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) motionKey2;
                    insertKey(new MotionPaths(i2, i3, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i9 = motionKeyPosition.mCurveFit;
                    if (i9 != -1) {
                        this.mCurveFitType = i9;
                    }
                } else if (motionKey2 instanceof MotionKeyCycle) {
                    motionKey2.getAttributeNames(hashSet7);
                } else if (motionKey2 instanceof MotionKeyTimeCycle) {
                    motionKey2.getAttributeNames(hashSet5);
                } else if (motionKey2 instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) motionKey2);
                } else {
                    motionKey2.setInterpolation(map);
                    motionKey2.getAttributeNames(hashSet6);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        char c2 = 1;
        if (hashSet6.isEmpty()) {
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            c = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it = hashSet6.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str = next.split(",")[c2];
                    ArrayList<MotionKey> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    while (i7 < size2) {
                        MotionKey motionKey3 = arrayList3.get(i7);
                        i7++;
                        HashSet<String> hashSet8 = hashSet5;
                        MotionKey motionKey4 = motionKey3;
                        HashSet<String> hashSet9 = hashSet7;
                        HashMap<String, CustomVariable> map2 = motionKey4.mCustom;
                        if (map2 != null && (customVariable3 = map2.get(str)) != null) {
                            customVar.append(motionKey4.mFramePosition, customVariable3);
                        }
                        hashSet7 = hashSet9;
                        hashSet5 = hashSet8;
                    }
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    splineSetMakeSpline2 = SplineSet.makeCustomSplineSet(next, customVar);
                } else {
                    hashSet3 = hashSet5;
                    hashSet4 = hashSet7;
                    splineSetMakeSpline2 = SplineSet.makeSpline(next, j);
                }
                if (splineSetMakeSpline2 != null) {
                    splineSetMakeSpline2.setType(next);
                    this.mAttributesMap.put(next, splineSetMakeSpline2);
                }
                hashSet7 = hashSet4;
                hashSet5 = hashSet3;
                i7 = 0;
                c2 = 1;
            }
            hashSet = hashSet5;
            hashSet2 = hashSet7;
            c = 1;
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i10 = 0;
                while (i10 < size3) {
                    MotionKey motionKey5 = arrayList4.get(i10);
                    i10++;
                    MotionKey motionKey6 = motionKey5;
                    if (motionKey6 instanceof MotionKeyAttributes) {
                        motionKey6.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int iIntValue = (!map.containsKey(str2) || (num = map.get(str2)) == null) ? 0 : num.intValue();
                SplineSet splineSet = this.mAttributesMap.get(str2);
                if (splineSet != null) {
                    splineSet.setup(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next2)) {
                    if (next2.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str3 = next2.split(",")[c];
                        ArrayList<MotionKey> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i11 = 0;
                        while (i11 < size4) {
                            MotionKey motionKey7 = arrayList5.get(i11);
                            i11++;
                            MotionKey motionKey8 = motionKey7;
                            HashMap<String, CustomVariable> map3 = motionKey8.mCustom;
                            if (map3 != null && (customVariable2 = map3.get(str3)) != null) {
                                customVar2.append(motionKey8.mFramePosition, customVariable2);
                            }
                        }
                        splineSetMakeSpline = SplineSet.makeCustomSplineSet(next2, customVar2);
                    } else {
                        splineSetMakeSpline = SplineSet.makeSpline(next2, j);
                    }
                    if (splineSetMakeSpline != null) {
                        splineSetMakeSpline.setType(next2);
                    }
                }
            }
            ArrayList<MotionKey> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i12 = 0;
                while (i12 < size5) {
                    MotionKey motionKey9 = arrayList6.get(i12);
                    i12++;
                    MotionKey motionKey10 = motionKey9;
                    if (motionKey10 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) motionKey10).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(map.containsKey(str4) ? map.get(str4).intValue() : 0);
            }
        }
        int size6 = this.mMotionPaths.size();
        int i13 = size6 + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i13];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size6 + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        ArrayList<MotionPaths> arrayList7 = this.mMotionPaths;
        int size7 = arrayList7.size();
        int i14 = 0;
        int i15 = 1;
        while (i14 < size7) {
            MotionPaths motionPaths = arrayList7.get(i14);
            i14++;
            motionPathsArr[i15] = motionPaths;
            i15++;
        }
        HashSet hashSet10 = new HashSet();
        for (String str5 : this.mEndMotionPath.customAttributes.keySet()) {
            if (this.mStartMotionPath.customAttributes.containsKey(str5)) {
                if (!hashSet6.contains("CUSTOM," + str5)) {
                    hashSet10.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet10.toArray(new String[0]);
        this.mAttributeNames = strArr2;
        this.mAttributeInterpolatorCount = new int[strArr2.length];
        int i16 = 0;
        while (true) {
            strArr = this.mAttributeNames;
            if (i16 >= strArr.length) {
                break;
            }
            String str6 = strArr[i16];
            this.mAttributeInterpolatorCount[i16] = 0;
            int i17 = 0;
            while (true) {
                if (i17 >= i13) {
                    break;
                }
                if (motionPathsArr[i17].customAttributes.containsKey(str6) && (customVariable = motionPathsArr[i17].customAttributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i16] = customVariable.numberOfInterpolatedValues() + iArr[i16];
                    break;
                }
                i17++;
            }
            i16++;
        }
        boolean z2 = motionPathsArr[0].mPathMotionArc != -1;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i18 = 1; i18 < i13; i18++) {
            motionPathsArr[i18].different(motionPathsArr[i18 - 1], zArr, this.mAttributeNames, z2);
        }
        int i19 = 0;
        for (int i20 = 1; i20 < length; i20++) {
            if (zArr[i20]) {
                i19++;
            }
        }
        this.mInterpolateVariables = new int[i19];
        int i21 = 2;
        int iMax = Math.max(2, i19);
        this.mInterpolateData = new double[iMax];
        this.mInterpolateVelocity = new double[iMax];
        int i22 = 0;
        for (int i23 = 1; i23 < length; i23++) {
            if (zArr[i23]) {
                this.mInterpolateVariables[i22] = i23;
                i22++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[c] = this.mInterpolateVariables.length;
        iArr2[0] = i13;
        Class cls = Double.TYPE;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr2 = new double[i13];
        for (int i24 = 0; i24 < i13; i24++) {
            motionPathsArr[i24].fillStandard(dArr[i24], this.mInterpolateVariables);
            dArr2[i24] = motionPathsArr[i24].time;
        }
        int i25 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i25 >= iArr3.length) {
                break;
            }
            if (iArr3[i25] < MotionPaths.names.length) {
                String strK = g.k(new StringBuilder(), MotionPaths.names[this.mInterpolateVariables[i25]], " [");
                for (int i26 = 0; i26 < i13; i26++) {
                    StringBuilder sbP = g.p(strK);
                    sbP.append(dArr[i26][i25]);
                    strK = sbP.toString();
                }
            }
            i25++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i27 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i27 >= strArr3.length) {
                break;
            }
            String str7 = strArr3[i27];
            int i28 = 0;
            int i29 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            while (i28 < i13) {
                if (motionPathsArr[i28].hasCustomData(str7)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i13];
                        int[] iArr4 = new int[i21];
                        iArr4[c] = motionPathsArr[i28].getCustomDataCount(str7);
                        i5 = 0;
                        iArr4[0] = i13;
                        dArr4 = (double[][]) Array.newInstance((Class<?>) cls, iArr4);
                    } else {
                        i5 = 0;
                    }
                    MotionPaths motionPaths2 = motionPathsArr[i28];
                    i4 = i27;
                    dArr3[i29] = motionPaths2.time;
                    motionPaths2.getCustomData(str7, dArr4[i29], i5);
                    i29++;
                } else {
                    i4 = i27;
                }
                i28++;
                i27 = i4;
                i21 = 2;
            }
            int i30 = i27 + 1;
            this.mSpline[i30] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i29), (double[][]) Arrays.copyOf(dArr4, i29));
            i27 = i30;
            i21 = 2;
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int[] iArr5 = new int[i13];
            double[] dArr5 = new double[i13];
            int[] iArr6 = new int[2];
            iArr6[c] = 2;
            iArr6[0] = i13;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i31 = 0; i31 < i13; i31++) {
                iArr5[i31] = motionPathsArr[i31].mPathMotionArc;
                dArr5[i31] = r6.time;
                double[] dArr7 = dArr6[i31];
                dArr7[0] = r6.f46x;
                dArr7[c] = r6.f47y;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it3 = hashSet2.iterator();
            float preCycleDistance = Float.NaN;
            while (it3.hasNext()) {
                String next3 = it3.next();
                KeyCycleOscillator keyCycleOscillatorMakeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(next3);
                if (keyCycleOscillatorMakeWidgetCycle != null) {
                    if (keyCycleOscillatorMakeWidgetCycle.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    keyCycleOscillatorMakeWidgetCycle.setType(next3);
                    this.mCycleMap.put(next3, keyCycleOscillatorMakeWidgetCycle);
                }
            }
            ArrayList<MotionKey> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i32 = 0;
            while (i32 < size8) {
                MotionKey motionKey11 = arrayList8.get(i32);
                i32++;
                MotionKey motionKey12 = motionKey11;
                if (motionKey12 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) motionKey12).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<KeyCycleOscillator> it4 = this.mCycleMap.values().iterator();
            while (it4.hasNext()) {
                it4.next().setup(preCycleDistance);
            }
        }
    }

    public void setupRelative(Motion motion) {
        this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motion, motion.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f46x + " y: " + this.mStartMotionPath.f47y + " end: x: " + this.mEndMotionPath.f46x + " y: " + this.mEndMotionPath.f47y;
    }

    public void endTrigger(boolean z2) {
    }
}
