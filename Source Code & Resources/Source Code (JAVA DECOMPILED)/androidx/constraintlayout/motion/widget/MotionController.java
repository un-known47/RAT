package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.appcompat.app.g;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class MotionController {
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
    private HashMap<String, ViewSpline> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, ViewOscillator> mCycleMap;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private KeyTrigger[] mKeyTriggers;
    private boolean mNoMovement;
    private int mPathMotionArc;
    private Interpolator mQuantizeMotionInterpolator;
    private float mQuantizeMotionPhase;
    private int mQuantizeMotionSteps;
    private CurveFit[] mSpline;
    private HashMap<String, ViewTimeCycle> mTimeCycleAttributesMap;
    private int mTransformPivotTarget;
    private View mTransformPivotView;
    View mView;
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
    private ArrayList<Key> mKeyList = new ArrayList<>();

    public MotionController(View view) {
        int i2 = Key.UNSET;
        this.mPathMotionArc = i2;
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
        this.mQuantizeMotionSteps = i2;
        this.mQuantizeMotionPhase = Float.NaN;
        this.mQuantizeMotionInterpolator = null;
        this.mNoMovement = false;
        setView(view);
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

    private static Interpolator getInterpolator(Context context, int i2, String str, int i3) {
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(context, i3);
        }
        if (i2 == -1) {
            final Easing interpolator = Easing.getInterpolator(str);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                @Override // android.animation.TimeInterpolator
                public float getInterpolation(float f2) {
                    return (float) interpolator.get(f2);
                }
            };
        }
        if (i2 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (i2 == 1) {
            return new AccelerateInterpolator();
        }
        if (i2 == 2) {
            return new DecelerateInterpolator();
        }
        if (i2 == 4) {
            return new BounceInterpolator();
        }
        if (i2 != 5) {
            return null;
        }
        return new OvershootInterpolator();
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
        if (Collections.binarySearch(this.mMotionPaths, motionPaths) == 0) {
            float f2 = motionPaths.position;
        }
        this.mMotionPaths.add((-r0) - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((int) this.mView.getX(), (int) this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void addKey(Key key) {
        this.mKeyList.add(key);
    }

    public void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void buildBounds(float[] fArr, int i2) {
        float f2 = 1.0f;
        float f3 = 1.0f / (i2 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            map.get("translationX");
        }
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        if (map2 != null) {
            map2.get("translationY");
        }
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        if (map3 != null) {
            map3.get("translationX");
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
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

    public int buildKeyFrames(float[] fArr, int[] iArr) {
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
        for (int i5 = 0; i5 < timePoints.length; i5++) {
            this.mSpline[0].getPos(timePoints[i5], this.mInterpolateData);
            this.mStartMotionPath.getCenter(timePoints[i5], this.mInterpolateVariables, this.mInterpolateData, fArr, i4);
            i4 += 2;
        }
        return i4 / 2;
    }

    public void buildPath(float[] fArr, int i2) {
        int i3 = i2;
        float f2 = 1.0f;
        float f3 = 1.0f / (i3 - 1);
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewOscillator> map3 = this.mCycleMap;
        ViewOscillator viewOscillator = map3 == null ? null : map3.get("translationX");
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map4 != null ? map4.get("translationY") : null;
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
            if (viewOscillator != null) {
                fArr[i6] = viewOscillator.get(fMin) + fArr[i6];
            } else if (viewSpline != null) {
                fArr[i6] = viewSpline.get(fMin) + fArr[i6];
            }
            if (viewOscillator2 != null) {
                int i7 = i6 + 1;
                fArr[i7] = viewOscillator2.get(fMin) + fArr[i7];
            } else if (viewSpline2 != null) {
                int i8 = i6 + 1;
                fArr[i8] = viewSpline2.get(fMin) + fArr[i8];
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

    public void endTrigger(boolean z2) {
        if (!"button".equals(Debug.getName(this.mView)) || this.mKeyTriggers == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
            if (i2 >= keyTriggerArr.length) {
                return;
            }
            keyTriggerArr[i2].conditionallyFire(z2 ? -100.0f : 100.0f, this.mView);
            i2++;
        }
    }

    public int getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public int getAttributeValues(String str, float[] fArr, int i2) {
        ViewSpline viewSpline = this.mAttributesMap.get(str);
        if (viewSpline == null) {
            return -1;
        }
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = viewSpline.get(i3 / (fArr.length - 1));
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
            float f5 = motionPaths.f56x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f6 = f5 - motionPaths2.f56x;
            float f7 = motionPaths.f57y - motionPaths2.f57y;
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
        return this.mEndMotionPath.f56x;
    }

    public float getFinalY() {
        return this.mEndMotionPath.f57y;
    }

    public MotionPaths getKeyFrame(int i2) {
        return this.mMotionPaths.get(i2);
    }

    public int getKeyFrameInfo(int i2, int[] iArr) {
        float[] fArr = new float[2];
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < size) {
            int i6 = i3 + 1;
            Key key = arrayList.get(i3);
            int i7 = key.mType;
            if (i7 == i2 || i2 != -1) {
                iArr[i5] = 0;
                iArr[i5 + 1] = i7;
                int i8 = key.mFramePosition;
                iArr[i5 + 2] = i8;
                double d = i8 / 100.0f;
                this.mSpline[0].getPos(d, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i5 + 3] = Float.floatToIntBits(fArr[0]);
                int i9 = i5 + 4;
                iArr[i9] = Float.floatToIntBits(fArr[1]);
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    iArr[i5 + 5] = keyPosition.mPositionType;
                    iArr[i5 + 6] = Float.floatToIntBits(keyPosition.mPercentX);
                    i9 = i5 + 7;
                    iArr[i9] = Float.floatToIntBits(keyPosition.mPercentY);
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
        float f4 = motionPaths.f56x;
        MotionPaths motionPaths2 = this.mStartMotionPath;
        float f5 = motionPaths2.f56x;
        float f6 = f4 - f5;
        float f7 = motionPaths.f57y;
        float f8 = motionPaths2.f57y;
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
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            int i5 = i3 + 1;
            Key key = arrayList.get(i3);
            int i6 = key.mFramePosition;
            iArr[i2] = (key.mType * 1000) + i6;
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

    public KeyPositionBase getPositionKeyframe(int i2, int i3, float f2, float f3) {
        int i4;
        int i5;
        float f4;
        float f5;
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f6 = motionPaths.f56x;
        rectF.left = f6;
        float f7 = motionPaths.f57y;
        rectF.top = f7;
        rectF.right = f6 + motionPaths.width;
        rectF.bottom = f7 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f8 = motionPaths2.f56x;
        rectF2.left = f8;
        float f9 = motionPaths2.f57y;
        rectF2.top = f9;
        rectF2.right = f8 + motionPaths2.width;
        rectF2.bottom = f9 + motionPaths2.height;
        ArrayList<Key> arrayList = this.mKeyList;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            int i7 = i6 + 1;
            Key key = arrayList.get(i6);
            if (key instanceof KeyPositionBase) {
                KeyPositionBase keyPositionBase = (KeyPositionBase) key;
                i4 = i2;
                i5 = i3;
                f4 = f2;
                f5 = f3;
                if (keyPositionBase.intersects(i4, i5, rectF, rectF2, f4, f5)) {
                    return keyPositionBase;
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
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        ViewSpline viewSpline = map == null ? null : map.get("translationX");
        HashMap<String, ViewSpline> map2 = this.mAttributesMap;
        ViewSpline viewSpline2 = map2 == null ? null : map2.get("translationY");
        HashMap<String, ViewSpline> map3 = this.mAttributesMap;
        ViewSpline viewSpline3 = map3 == null ? null : map3.get(Key.ROTATION);
        HashMap<String, ViewSpline> map4 = this.mAttributesMap;
        ViewSpline viewSpline4 = map4 == null ? null : map4.get("scaleX");
        HashMap<String, ViewSpline> map5 = this.mAttributesMap;
        ViewSpline viewSpline5 = map5 == null ? null : map5.get("scaleY");
        HashMap<String, ViewOscillator> map6 = this.mCycleMap;
        ViewOscillator viewOscillator = map6 == null ? null : map6.get("translationX");
        HashMap<String, ViewOscillator> map7 = this.mCycleMap;
        ViewOscillator viewOscillator2 = map7 == null ? null : map7.get("translationY");
        HashMap<String, ViewOscillator> map8 = this.mCycleMap;
        ViewOscillator viewOscillator3 = map8 == null ? null : map8.get(Key.ROTATION);
        HashMap<String, ViewOscillator> map9 = this.mCycleMap;
        ViewOscillator viewOscillator4 = map9 == null ? null : map9.get("scaleX");
        HashMap<String, ViewOscillator> map10 = this.mCycleMap;
        ViewOscillator viewOscillator5 = map10 != null ? map10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
        velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
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
            float f5 = motionPaths.f56x;
            MotionPaths motionPaths2 = this.mStartMotionPath;
            float f6 = f5 - motionPaths2.f56x;
            float f7 = motionPaths.f57y - motionPaths2.f57y;
            float f8 = motionPaths.width - motionPaths2.width;
            float f9 = f7 + (motionPaths.height - motionPaths2.height);
            fArr[0] = ((f8 + f6) * f3) + ((1.0f - f3) * f6);
            fArr[1] = (f9 * f4) + ((1.0f - f4) * f7);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(viewSpline3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewSpline, viewSpline2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewSpline4, viewSpline5, adjustedPosition);
            velocityMatrix.setRotationVelocity(viewOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(viewOscillator, viewOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(viewOscillator4, viewOscillator5, adjustedPosition);
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
        return this.mStartMotionPath.f56x;
    }

    public float getStartY() {
        return this.mStartMotionPath.f57y;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public View getView() {
        return this.mView;
    }

    public boolean interpolate(View view, float f2, long j, KeyCache keyCache) {
        ViewTimeCycle.PathRotate pathRotate;
        boolean pathRotate2;
        View view2;
        View view3;
        double d;
        float f3;
        float f4;
        View view4 = view;
        float adjustedPosition = getAdjustedPosition(f2, null);
        int i2 = this.mQuantizeMotionSteps;
        if (i2 != Key.UNSET) {
            float f5 = 1.0f / i2;
            float fFloor = ((float) Math.floor(adjustedPosition / f5)) * f5;
            float f6 = (adjustedPosition % f5) / f5;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f6 = (f6 + this.mQuantizeMotionPhase) % 1.0f;
            }
            Interpolator interpolator = this.mQuantizeMotionInterpolator;
            adjustedPosition = ((interpolator != null ? interpolator.getInterpolation(f6) : ((double) f6) > 0.5d ? 1.0f : 0.0f) * f5) + fFloor;
        }
        HashMap<String, ViewSpline> map = this.mAttributesMap;
        if (map != null) {
            Iterator<ViewSpline> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().setProperty(view4, adjustedPosition);
            }
        }
        HashMap<String, ViewTimeCycle> map2 = this.mTimeCycleAttributesMap;
        if (map2 != null) {
            pathRotate = null;
            boolean property = false;
            for (ViewTimeCycle viewTimeCycle : map2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    property |= viewTimeCycle.setProperty(view4, adjustedPosition, j, keyCache);
                    view4 = view;
                }
            }
            pathRotate2 = property;
        } else {
            pathRotate = null;
            pathRotate2 = false;
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d2 = adjustedPosition;
            curveFitArr[0].getPos(d2, this.mInterpolateData);
            this.mSpline[0].getSlope(d2, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d2, dArr);
                    this.mArcSpline.getSlope(d2, this.mInterpolateVelocity);
                }
            }
            if (this.mNoMovement) {
                view3 = view;
            } else {
                float f7 = adjustedPosition;
                this.mStartMotionPath.setView(f7, view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                adjustedPosition = f7;
                view3 = view;
            }
            if (this.mTransformPivotTarget != Key.UNSET) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = ((View) view3.getParent()).findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float bottom = (this.mTransformPivotView.getBottom() + r1.getTop()) / 2.0f;
                    float right = (this.mTransformPivotView.getRight() + this.mTransformPivotView.getLeft()) / 2.0f;
                    if (view3.getRight() - view3.getLeft() > 0 && view3.getBottom() - view3.getTop() > 0) {
                        view3.setPivotX(right - view3.getLeft());
                        view3.setPivotY(bottom - view3.getTop());
                    }
                }
            }
            HashMap<String, ViewSpline> map3 = this.mAttributesMap;
            if (map3 != null) {
                for (ViewSpline viewSpline : map3.values()) {
                    if (viewSpline instanceof ViewSpline.PathRotate) {
                        double[] dArr2 = this.mInterpolateVelocity;
                        if (dArr2.length > 1) {
                            ((ViewSpline.PathRotate) viewSpline).setPathRotate(view3, adjustedPosition, dArr2[0], dArr2[1]);
                        }
                    }
                    view3 = view;
                }
            }
            if (pathRotate != null) {
                double[] dArr3 = this.mInterpolateVelocity;
                view2 = view;
                d = d2;
                f3 = 0.0f;
                f4 = 1.0f;
                float f8 = adjustedPosition;
                adjustedPosition = f8;
                pathRotate2 |= pathRotate.setPathRotate(view2, keyCache, f8, j, dArr3[0], dArr3[1]);
            } else {
                view2 = view;
                d = d2;
                f3 = 0.0f;
                f4 = 1.0f;
            }
            int i3 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i3 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i3].getPos(d, this.mValuesBuff);
                this.mStartMotionPath.attributes.get(this.mAttributeNames[i3 - 1]).setInterpolatedValue(view2, this.mValuesBuff);
                i3++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.mStartPoint;
            if (motionConstrainedPoint.mVisibilityMode == 0) {
                if (adjustedPosition <= f3) {
                    view2.setVisibility(motionConstrainedPoint.visibility);
                } else if (adjustedPosition >= f4) {
                    view2.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != motionConstrainedPoint.visibility) {
                    view2.setVisibility(0);
                }
            }
            if (this.mKeyTriggers != null) {
                int i4 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.mKeyTriggers;
                    if (i4 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i4].conditionallyFire(adjustedPosition, view2);
                    i4++;
                }
            }
        } else {
            view2 = view;
            MotionPaths motionPaths = this.mStartMotionPath;
            float f9 = motionPaths.f56x;
            MotionPaths motionPaths2 = this.mEndMotionPath;
            float fB = g.b(motionPaths2.f56x, f9, adjustedPosition, f9);
            float f10 = motionPaths.f57y;
            float fB2 = g.b(motionPaths2.f57y, f10, adjustedPosition, f10);
            float f11 = motionPaths.width;
            float f12 = motionPaths2.width;
            float fB3 = g.b(f12, f11, adjustedPosition, f11);
            float f13 = motionPaths.height;
            float f14 = motionPaths2.height;
            float f15 = fB + 0.5f;
            int i5 = (int) f15;
            float f16 = fB2 + 0.5f;
            int i6 = (int) f16;
            int i7 = (int) (f15 + fB3);
            int iB = (int) (f16 + g.b(f14, f13, adjustedPosition, f13));
            int i8 = i7 - i5;
            int i9 = iB - i6;
            if (f12 != f11 || f14 != f13) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i8, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(i9, BasicMeasure.EXACTLY));
            }
            view2.layout(i5, i6, i7, iB);
        }
        HashMap<String, ViewOscillator> map4 = this.mCycleMap;
        if (map4 != null) {
            for (ViewOscillator viewOscillator : map4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr4 = this.mInterpolateVelocity;
                    ((ViewOscillator.PathRotateSet) viewOscillator).setPathRotate(view2, adjustedPosition, dArr4[0], dArr4[1]);
                } else {
                    viewOscillator.setProperty(view2, adjustedPosition);
                }
            }
        }
        return pathRotate2;
    }

    public String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    public void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f2, float f3, String[] strArr, float[] fArr) {
        RectF rectF = new RectF();
        MotionPaths motionPaths = this.mStartMotionPath;
        float f4 = motionPaths.f56x;
        rectF.left = f4;
        float f5 = motionPaths.f57y;
        rectF.top = f5;
        rectF.right = f4 + motionPaths.width;
        rectF.bottom = f5 + motionPaths.height;
        RectF rectF2 = new RectF();
        MotionPaths motionPaths2 = this.mEndMotionPath;
        float f6 = motionPaths2.f56x;
        rectF2.left = f6;
        float f7 = motionPaths2.f57y;
        rectF2.top = f7;
        rectF2.right = f6 + motionPaths2.width;
        rectF2.bottom = f7 + motionPaths2.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f2, f3, strArr, fArr);
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

    public void setBothStates(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        this.mNoMovement = true;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mEndMotionPath.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
        this.mEndPoint.setState(view);
    }

    public void setDrawPath(int i2) {
        this.mStartMotionPath.mDrawPath = i2;
    }

    public void setEndState(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        MotionController motionController;
        int i4 = constraintSet.mRotate;
        if (i4 != 0) {
            motionController = this;
            motionController.rotate(rect, this.mTempRect, i4, i2, i3);
            rect = motionController.mTempRect;
        } else {
            motionController = this;
        }
        MotionPaths motionPaths = motionController.mEndMotionPath;
        motionPaths.time = 1.0f;
        motionPaths.position = 1.0f;
        readView(motionPaths);
        motionController.mEndMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        motionController.mEndMotionPath.applyParameters(constraintSet.getParameters(motionController.mId));
        motionController.mEndPoint.setState(rect, constraintSet, i4, motionController.mId);
    }

    public void setPathMotionArc(int i2) {
        this.mPathMotionArc = i2;
    }

    public void setStartCurrentState(View view) {
        MotionPaths motionPaths = this.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        motionPaths.setBounds(view.getX(), view.getY(), view.getWidth(), view.getHeight());
        this.mStartPoint.setState(view);
    }

    public void setStartState(ViewState viewState, View view, int i2, int i3, int i4) {
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
        this.mStartPoint.setState(rect, view, i2, viewState.rotation);
    }

    public void setTransformPivotTarget(int i2) {
        this.mTransformPivotTarget = i2;
        this.mTransformPivotView = null;
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mConstraintTag = ((ConstraintLayout.LayoutParams) layoutParams).getConstraintTag();
        }
    }

    public void setup(int i2, int i3, float f2, long j) {
        ArrayList arrayList;
        char c;
        String[] strArr;
        int i4;
        int i5;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle viewTimeCycleMakeSpline;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        ViewSpline viewSplineMakeSpline;
        ConstraintAttribute constraintAttribute3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        int i6 = this.mPathMotionArc;
        if (i6 != Key.UNSET) {
            this.mStartMotionPath.mPathMotionArc = i6;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<Key> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            arrayList = null;
            int i7 = 0;
            while (i7 < size) {
                Key key = arrayList2.get(i7);
                i7++;
                Key key2 = key;
                if (key2 instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key2;
                    insertKey(new MotionPaths(i2, i3, keyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    int i8 = keyPosition.mCurveFit;
                    if (i8 != Key.UNSET) {
                        this.mCurveFitType = i8;
                    }
                } else if (key2 instanceof KeyCycle) {
                    key2.getAttributeNames(hashSet3);
                } else if (key2 instanceof KeyTimeCycle) {
                    key2.getAttributeNames(hashSet);
                } else if (key2 instanceof KeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((KeyTrigger) key2);
                } else {
                    key2.setInterpolation(map);
                    key2.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (KeyTrigger[]) arrayList.toArray(new KeyTrigger[0]);
        }
        char c2 = 1;
        if (hashSet2.isEmpty()) {
            c = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it = hashSet2.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str = next.split(",")[c2];
                    ArrayList<Key> arrayList3 = this.mKeyList;
                    int size2 = arrayList3.size();
                    int i9 = 0;
                    while (i9 < size2) {
                        Key key3 = arrayList3.get(i9);
                        i9++;
                        Key key4 = key3;
                        HashMap<String, ConstraintAttribute> map2 = key4.mCustomConstraints;
                        if (map2 != null && (constraintAttribute3 = map2.get(str)) != null) {
                            sparseArray.append(key4.mFramePosition, constraintAttribute3);
                        }
                    }
                    viewSplineMakeSpline = ViewSpline.makeCustomSpline(next, (SparseArray<ConstraintAttribute>) sparseArray);
                } else {
                    viewSplineMakeSpline = ViewSpline.makeSpline(next);
                }
                if (viewSplineMakeSpline != null) {
                    viewSplineMakeSpline.setType(next);
                    this.mAttributesMap.put(next, viewSplineMakeSpline);
                }
                c2 = 1;
            }
            c = 1;
            ArrayList<Key> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                int size3 = arrayList4.size();
                int i10 = 0;
                while (i10 < size3) {
                    Key key5 = arrayList4.get(i10);
                    i10++;
                    Key key6 = key5;
                    if (key6 instanceof KeyAttributes) {
                        key6.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int iIntValue = (!map.containsKey(str2) || (num = map.get(str2)) == null) ? 0 : num.intValue();
                ViewSpline viewSpline = this.mAttributesMap.get(str2);
                if (viewSpline != null) {
                    viewSpline.setup(iIntValue);
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
                        SparseArray sparseArray2 = new SparseArray();
                        String str3 = next2.split(",")[c];
                        ArrayList<Key> arrayList5 = this.mKeyList;
                        int size4 = arrayList5.size();
                        int i11 = 0;
                        while (i11 < size4) {
                            Key key7 = arrayList5.get(i11);
                            i11++;
                            Key key8 = key7;
                            HashMap<String, ConstraintAttribute> map3 = key8.mCustomConstraints;
                            if (map3 != null && (constraintAttribute2 = map3.get(str3)) != null) {
                                sparseArray2.append(key8.mFramePosition, constraintAttribute2);
                            }
                        }
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeCustomSpline(next2, sparseArray2);
                    } else {
                        viewTimeCycleMakeSpline = ViewTimeCycle.makeSpline(next2, j);
                    }
                    if (viewTimeCycleMakeSpline != null) {
                        viewTimeCycleMakeSpline.setType(next2);
                        this.mTimeCycleAttributesMap.put(next2, viewTimeCycleMakeSpline);
                    }
                }
            }
            ArrayList<Key> arrayList6 = this.mKeyList;
            if (arrayList6 != null) {
                int size5 = arrayList6.size();
                int i12 = 0;
                while (i12 < size5) {
                    Key key9 = arrayList6.get(i12);
                    i12++;
                    Key key10 = key9;
                    if (key10 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key10).addTimeValues(this.mTimeCycleAttributesMap);
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
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
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
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.attributes.keySet()) {
            if (this.mStartMotionPath.attributes.containsKey(str5)) {
                if (!hashSet2.contains("CUSTOM," + str5)) {
                    hashSet4.add(str5);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
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
                if (motionPathsArr[i17].attributes.containsKey(str6) && (constraintAttribute = motionPathsArr[i17].attributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i16] = constraintAttribute.numberOfInterpolatedValues() + iArr[i16];
                    break;
                }
                i17++;
            }
            i16++;
        }
        boolean z2 = motionPathsArr[0].mPathMotionArc != Key.UNSET;
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
        if (motionPathsArr[0].mPathMotionArc != Key.UNSET) {
            int[] iArr5 = new int[i13];
            double[] dArr5 = new double[i13];
            int[] iArr6 = new int[2];
            iArr6[c] = 2;
            iArr6[0] = i13;
            double[][] dArr6 = (double[][]) Array.newInstance((Class<?>) cls, iArr6);
            for (int i31 = 0; i31 < i13; i31++) {
                iArr5[i31] = motionPathsArr[i31].mPathMotionArc;
                dArr5[i31] = r8.time;
                double[] dArr7 = dArr6[i31];
                dArr7[0] = r8.f56x;
                dArr7[c] = r8.f57y;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it3 = hashSet3.iterator();
            float preCycleDistance = Float.NaN;
            while (it3.hasNext()) {
                String next3 = it3.next();
                ViewOscillator viewOscillatorMakeSpline = ViewOscillator.makeSpline(next3);
                if (viewOscillatorMakeSpline != null) {
                    if (viewOscillatorMakeSpline.variesByPath() && Float.isNaN(preCycleDistance)) {
                        preCycleDistance = getPreCycleDistance();
                    }
                    viewOscillatorMakeSpline.setType(next3);
                    this.mCycleMap.put(next3, viewOscillatorMakeSpline);
                }
            }
            ArrayList<Key> arrayList8 = this.mKeyList;
            int size8 = arrayList8.size();
            int i32 = 0;
            while (i32 < size8) {
                Key key11 = arrayList8.get(i32);
                i32++;
                Key key12 = key11;
                if (key12 instanceof KeyCycle) {
                    ((KeyCycle) key12).addCycleValues(this.mCycleMap);
                }
            }
            Iterator<ViewOscillator> it4 = this.mCycleMap.values().iterator();
            while (it4.hasNext()) {
                it4.next().setup(preCycleDistance);
            }
        }
    }

    public void setupRelative(MotionController motionController) {
        this.mStartMotionPath.setupRelative(motionController, motionController.mStartMotionPath);
        this.mEndMotionPath.setupRelative(motionController, motionController.mEndMotionPath);
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.f56x + " y: " + this.mStartMotionPath.f57y + " end: x: " + this.mEndMotionPath.f56x + " y: " + this.mEndMotionPath.f57y;
    }

    public void setStartState(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        MotionController motionController;
        Rect rect2;
        int i4 = constraintSet.mRotate;
        if (i4 != 0) {
            motionController = this;
            rect2 = rect;
            motionController.rotate(rect2, this.mTempRect, i4, i2, i3);
        } else {
            motionController = this;
            rect2 = rect;
        }
        MotionPaths motionPaths = motionController.mStartMotionPath;
        motionPaths.time = 0.0f;
        motionPaths.position = 0.0f;
        readView(motionPaths);
        motionController.mStartMotionPath.setBounds(rect2.left, rect2.top, rect2.width(), rect2.height());
        ConstraintSet.Constraint parameters = constraintSet.getParameters(motionController.mId);
        motionController.mStartMotionPath.applyParameters(parameters);
        motionController.mMotionStagger = parameters.motion.mMotionStagger;
        motionController.mStartPoint.setState(rect2, constraintSet, i4, motionController.mId);
        motionController.mTransformPivotTarget = parameters.transform.transformPivotTarget;
        ConstraintSet.Motion motion = parameters.motion;
        motionController.mQuantizeMotionSteps = motion.mQuantizeMotionSteps;
        motionController.mQuantizeMotionPhase = motion.mQuantizeMotionPhase;
        Context context = motionController.mView.getContext();
        ConstraintSet.Motion motion2 = parameters.motion;
        motionController.mQuantizeMotionInterpolator = getInterpolator(context, motion2.mQuantizeInterpolatorType, motion2.mQuantizeInterpolatorString, motion2.mQuantizeInterpolatorID);
    }
}
