package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.appcompat.app.g;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class MotionScene {
    static final int ANTICIPATE = 6;
    static final int BOUNCE = 4;
    private static final String CONSTRAINTSET_TAG = "ConstraintSet";
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final String INCLUDE_TAG = "include";
    private static final String INCLUDE_TAG_UC = "Include";
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final String KEYFRAMESET_TAG = "KeyFrameSet";
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int MIN_DURATION = 8;
    private static final String MOTIONSCENE_TAG = "MotionScene";
    private static final String ONCLICK_TAG = "OnClick";
    private static final String ONSWIPE_TAG = "OnSwipe";
    static final int OVERSHOOT = 5;
    private static final int SPLINE_STRING = -1;
    private static final String STATESET_TAG = "StateSet";
    private static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    private static final String TRANSITION_TAG = "Transition";
    public static final int UNSET = -1;
    private static final String VIEW_TRANSITION = "ViewTransition";
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout.MotionTracker mVelocityTracker;
    final ViewTransitionController mViewTransitionController;
    StateSet mStateSet = null;
    Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<Transition> mTransitionList = new ArrayList<>();
    private Transition mDefaultTransition = null;
    private ArrayList<Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean DEBUG_DESKTOP = false;
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
    }

    private int getId(Context context, String str) {
        int identifier;
        if (str.contains("/")) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        return (identifier != -1 || str.length() <= 1) ? identifier : Integer.parseInt(str.substring(1));
    }

    private int getIndex(Transition transition) {
        int i2 = transition.mId;
        if (i2 == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i3 = 0; i3 < this.mTransitionList.size(); i3++) {
            if (this.mTransitionList.get(i3).mId == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static String getLine(Context context, int i2, XmlPullParser xmlPullParser) {
        return ".(" + Debug.getName(context, i2) + ".xml:" + xmlPullParser.getLineNumber() + ") \"" + xmlPullParser.getName() + "\"";
    }

    private int getRealID(int i2) {
        int iStateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        return (stateSet == null || (iStateGetConstraintID = stateSet.stateGetConstraintID(i2, -1, -1)) == -1) ? i2 : iStateGetConstraintID;
    }

    private boolean hasCycleDependency(int i2) {
        int i3 = this.mDeriveMap.get(i2);
        int size = this.mDeriveMap.size();
        while (i3 > 0) {
            if (i3 == i2) {
                return true;
            }
            int i4 = size - 1;
            if (size < 0) {
                return true;
            }
            i3 = this.mDeriveMap.get(i3);
            size = i4;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void load(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            Transition transition = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.DEBUG_DESKTOP) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals(CONSTRAINTSET_TAG)) {
                                parseConstraintSet(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                KeyFrames keyFrames = new KeyFrames(context, xml);
                                if (transition != null) {
                                    transition.mKeyFramesList.add(keyFrames);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        case -687739768:
                            if (name.equals(INCLUDE_TAG_UC)) {
                                parseInclude(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                this.mViewTransitionController.add(new ViewTransition(context, xml));
                                break;
                            } else {
                                break;
                            }
                        case 269306229:
                            if (name.equals(TRANSITION_TAG)) {
                                ArrayList<Transition> arrayList = this.mTransitionList;
                                transition = new Transition(this, context, xml);
                                arrayList.add(transition);
                                if (this.mCurrentTransition == null && !transition.mIsAbstract) {
                                    this.mCurrentTransition = transition;
                                    if (transition.mTouchResponse != null) {
                                        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
                                    }
                                }
                                if (transition.mIsAbstract) {
                                    if (transition.mConstraintSetEnd == -1) {
                                        this.mDefaultTransition = transition;
                                    } else {
                                        this.mAbstractTransitionList.add(transition);
                                    }
                                    this.mTransitionList.remove(transition);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                            break;
                        case 312750793:
                            if (!name.equals(ONCLICK_TAG) || transition == null) {
                                break;
                            } else {
                                transition.addOnClick(context, xml);
                                break;
                            }
                            break;
                        case 327855227:
                            if (name.equals(ONSWIPE_TAG)) {
                                if (transition == null) {
                                    context.getResources().getResourceEntryName(i2);
                                    xml.getLineNumber();
                                }
                                if (transition != null) {
                                    transition.mTouchResponse = new TouchResponse(context, this.mMotionLayout, xml);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        case 793277014:
                            if (name.equals("MotionScene")) {
                                parseMotionSceneTags(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 1382829617:
                            if (name.equals(STATESET_TAG)) {
                                this.mStateSet = new StateSet(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 1942574248:
                            if (name.equals(INCLUDE_TAG)) {
                                parseInclude(context, xml);
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parseConstraintSet(android.content.Context r14, org.xmlpull.v1.XmlPullParser r15) {
        /*
            r13 = this;
            androidx.constraintlayout.widget.ConstraintSet r0 = new androidx.constraintlayout.widget.ConstraintSet
            r0.<init>()
            r1 = 0
            r0.setForceId(r1)
            int r2 = r15.getAttributeCount()
            r3 = -1
            r4 = 0
            r5 = -1
            r6 = -1
        L11:
            r7 = 1
            if (r4 >= r2) goto L87
            java.lang.String r8 = r15.getAttributeName(r4)
            java.lang.String r9 = r15.getAttributeValue(r4)
            boolean r10 = r13.DEBUG_DESKTOP
            if (r10 == 0) goto L33
            java.io.PrintStream r10 = java.lang.System.out
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "id string = "
            r11.<init>(r12)
            r11.append(r9)
            java.lang.String r11 = r11.toString()
            r10.println(r11)
        L33:
            r8.getClass()
            int r10 = r8.hashCode()
            switch(r10) {
                case -1995929160: goto L53;
                case -1496482599: goto L4a;
                case 3355: goto L3f;
                default: goto L3d;
            }
        L3d:
            r7 = -1
            goto L5d
        L3f:
            java.lang.String r7 = "id"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L48
            goto L3d
        L48:
            r7 = 2
            goto L5d
        L4a:
            java.lang.String r10 = "deriveConstraintsFrom"
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L5d
            goto L3d
        L53:
            java.lang.String r7 = "ConstraintRotate"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L5c
            goto L3d
        L5c:
            r7 = 0
        L5d:
            switch(r7) {
                case 0: goto L7e;
                case 1: goto L79;
                case 2: goto L61;
                default: goto L60;
            }
        L60:
            goto L84
        L61:
            int r5 = r13.getId(r14, r9)
            java.util.HashMap<java.lang.String, java.lang.Integer> r7 = r13.mConstraintSetIdMap
            java.lang.String r8 = stripID(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r5)
            r7.put(r8, r9)
            java.lang.String r7 = androidx.constraintlayout.motion.widget.Debug.getName(r14, r5)
            r0.mIdString = r7
            goto L84
        L79:
            int r6 = r13.getId(r14, r9)
            goto L84
        L7e:
            int r7 = java.lang.Integer.parseInt(r9)
            r0.mRotate = r7
        L84:
            int r4 = r4 + 1
            goto L11
        L87:
            if (r5 == r3) goto La1
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r13.mMotionLayout
            int r1 = r1.mDebugPath
            if (r1 == 0) goto L92
            r0.setValidateOnParse(r7)
        L92:
            r0.load(r14, r15)
            if (r6 == r3) goto L9c
            android.util.SparseIntArray r14 = r13.mDeriveMap
            r14.put(r5, r6)
        L9c:
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintSet> r14 = r13.mConstraintSetMap
            r14.put(r5, r0)
        La1:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.parseConstraintSet(android.content.Context, org.xmlpull.v1.XmlPullParser):int");
    }

    private void parseInclude(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, Resources.NotFoundException, IOException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.include_constraintSet) {
                parseInclude(context, typedArrayObtainStyledAttributes.getResourceId(index, -1));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i3 = typedArrayObtainStyledAttributes.getInt(index, this.mDefaultDuration);
                this.mDefaultDuration = i3;
                if (i3 < 8) {
                    this.mDefaultDuration = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i2, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.mConstraintSetMap.get(i2);
        constraintSet.derivedState = constraintSet.mIdString;
        int i3 = this.mDeriveMap.get(i2);
        if (i3 > 0) {
            readConstraintChain(i3, motionLayout);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i3);
            if (constraintSet2 == null) {
                Debug.getName(this.mMotionLayout.getContext(), i3);
                return;
            }
            constraintSet.derivedState += "/" + constraintSet2.derivedState;
            constraintSet.readFallback(constraintSet2);
        } else {
            constraintSet.derivedState = g.k(new StringBuilder(), constraintSet.derivedState, "  layout");
            constraintSet.readFallback(motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i2) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Transition transition = arrayList.get(i3);
            i3++;
            Transition transition2 = transition;
            if (transition2.mOnClicks.size() > 0) {
                ArrayList arrayList2 = transition2.mOnClicks;
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj = arrayList2.get(i4);
                    i4++;
                    ((Transition.TransitionOnClick) obj).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList3 = this.mAbstractTransitionList;
        int size3 = arrayList3.size();
        int i5 = 0;
        while (i5 < size3) {
            Transition transition3 = arrayList3.get(i5);
            i5++;
            Transition transition4 = transition3;
            if (transition4.mOnClicks.size() > 0) {
                ArrayList arrayList4 = transition4.mOnClicks;
                int size4 = arrayList4.size();
                int i6 = 0;
                while (i6 < size4) {
                    Object obj2 = arrayList4.get(i6);
                    i6++;
                    ((Transition.TransitionOnClick) obj2).removeOnClickListeners(motionLayout);
                }
            }
        }
        ArrayList<Transition> arrayList5 = this.mTransitionList;
        int size5 = arrayList5.size();
        int i7 = 0;
        while (i7 < size5) {
            Transition transition5 = arrayList5.get(i7);
            i7++;
            Transition transition6 = transition5;
            if (transition6.mOnClicks.size() > 0) {
                ArrayList arrayList6 = transition6.mOnClicks;
                int size6 = arrayList6.size();
                int i8 = 0;
                while (i8 < size6) {
                    Object obj3 = arrayList6.get(i8);
                    i8++;
                    ((Transition.TransitionOnClick) obj3).addOnClickListeners(motionLayout, i2, transition6);
                }
            }
        }
        ArrayList<Transition> arrayList7 = this.mAbstractTransitionList;
        int size7 = arrayList7.size();
        int i9 = 0;
        while (i9 < size7) {
            Transition transition7 = arrayList7.get(i9);
            i9++;
            Transition transition8 = transition7;
            if (transition8.mOnClicks.size() > 0) {
                ArrayList arrayList8 = transition8.mOnClicks;
                int size8 = arrayList8.size();
                int i10 = 0;
                while (i10 < size8) {
                    Object obj4 = arrayList8.get(i10);
                    i10++;
                    ((Transition.TransitionOnClick) obj4).addOnClickListeners(motionLayout, i2, transition8);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int index = getIndex(transition);
        if (index == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(index, transition);
        }
    }

    public boolean applyViewTransition(int i2, MotionController motionController) {
        return this.mViewTransitionController.applyViewTransition(i2, motionController);
    }

    public boolean autoTransition(MotionLayout motionLayout, int i2) {
        Transition transition;
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Transition transition2 = arrayList.get(i3);
            i3++;
            Transition transition3 = transition2;
            if (transition3.mAutoTransition != 0 && ((transition = this.mCurrentTransition) != transition3 || !transition.isTransitionFlag(2))) {
                if (i2 == transition3.mConstraintSetStart && (transition3.mAutoTransition == 4 || transition3.mAutoTransition == 2)) {
                    MotionLayout.TransitionState transitionState = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i2 == transition3.mConstraintSetEnd && (transition3.mAutoTransition == 3 || transition3.mAutoTransition == 1)) {
                    MotionLayout.TransitionState transitionState2 = MotionLayout.TransitionState.FINISHED;
                    motionLayout.setState(transitionState2);
                    motionLayout.setTransition(transition3);
                    if (transition3.mAutoTransition == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(transitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public Transition bestTransitionFor(int i2, float f2, float f3, MotionEvent motionEvent) {
        if (i2 == -1) {
            return this.mCurrentTransition;
        }
        List<Transition> transitionsWithState = getTransitionsWithState(i2);
        RectF rectF = new RectF();
        float f4 = 0.0f;
        Transition transition = null;
        for (Transition transition2 : transitionsWithState) {
            if (!transition2.mDisable && transition2.mTouchResponse != null) {
                transition2.mTouchResponse.setRTL(this.mRtl);
                RectF touchRegion = transition2.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF limitBoundsTo = transition2.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo == null || motionEvent == null || limitBoundsTo.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fDot = transition2.mTouchResponse.dot(f2, f3);
                        if (transition2.mTouchResponse.mIsRotateMode && motionEvent != null) {
                            fDot = ((float) (Math.atan2(f3 + r10, f2 + r9) - Math.atan2(motionEvent.getX() - transition2.mTouchResponse.mRotateCenterX, motionEvent.getY() - transition2.mTouchResponse.mRotateCenterY))) * 10.0f;
                        }
                        float f5 = fDot * (transition2.mConstraintSetEnd == i2 ? -1.0f : 1.1f);
                        if (f5 > f4) {
                            transition = transition2;
                            f4 = f5;
                        }
                    }
                }
            }
        }
        return transition;
    }

    public void disableAutoTransition(boolean z2) {
        this.mDisableAutoTransition = z2;
    }

    public void enableViewTransition(int i2, boolean z2) {
        this.mViewTransitionController.enableViewTransition(i2, z2);
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mPathMotionArc;
        }
        return -1;
    }

    public int getAutoCompleteMode() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getAutoCompleteMode();
    }

    public ConstraintSet getConstraintSet(Context context, String str) throws Resources.NotFoundException {
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + str);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i2);
            String resourceName = context.getResources().getResourceName(iKeyAt);
            if (this.DEBUG_DESKTOP) {
                System.out.println("Id for <" + i2 + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(iKeyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = this.mConstraintSetMap.keyAt(i2);
        }
        return iArr;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        return transition != null ? transition.mDuration : this.mDefaultDuration;
    }

    public int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetEnd;
    }

    public Interpolator getInterpolator() {
        int i2 = this.mCurrentTransition.mDefaultInterpolator;
        if (i2 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), this.mCurrentTransition.mDefaultInterpolatorID);
        }
        if (i2 == -1) {
            final Easing interpolator = Easing.getInterpolator(this.mCurrentTransition.mDefaultInterpolatorString);
            return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
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
        if (i2 == 5) {
            return new OvershootInterpolator();
        }
        if (i2 != 6) {
            return null;
        }
        return new AnticipateInterpolator();
    }

    public Key getKeyFrame(Context context, int i2, int i3, int i4) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return null;
        }
        ArrayList arrayList = transition.mKeyFramesList;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            KeyFrames keyFrames = (KeyFrames) obj;
            for (Integer num : keyFrames.getKeys()) {
                if (i3 == num.intValue()) {
                    ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(num.intValue());
                    int size2 = keyFramesForView.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        Key key = keyFramesForView.get(i6);
                        i6++;
                        Key key2 = key;
                        if (key2.mFramePosition == i4 && key2.mType == i2) {
                            return key2;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.mCurrentTransition;
        int i2 = 0;
        if (transition != null) {
            ArrayList arrayList = transition.mKeyFramesList;
            int size = arrayList.size();
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((KeyFrames) obj).addFrames(motionController);
            }
            return;
        }
        Transition transition2 = this.mDefaultTransition;
        if (transition2 != null) {
            ArrayList arrayList2 = transition2.mKeyFramesList;
            int size2 = arrayList2.size();
            while (i2 < size2) {
                Object obj2 = arrayList2.get(i2);
                i2++;
                ((KeyFrames) obj2).addFrames(motionController);
            }
        }
    }

    public float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxAcceleration();
    }

    public float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return false;
        }
        return this.mCurrentTransition.mTouchResponse.getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i2) {
        return 0.0f;
    }

    public float getProgressDirection(float f2, float f3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getProgressDirection(f2, f3);
    }

    public int getSpringBoundary() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringBoundary();
    }

    public float getSpringDamping() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringDamping();
    }

    public float getSpringMass() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringMass();
    }

    public float getSpringStiffiness() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStiffness();
    }

    public float getSpringStopThreshold() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return 0.0f;
        }
        return this.mCurrentTransition.mTouchResponse.getSpringStopThreshold();
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            return transition.mStagger;
        }
        return 0.0f;
    }

    public int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return -1;
        }
        return transition.mConstraintSetStart;
    }

    public Transition getTransitionById(int i2) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Transition transition = arrayList.get(i3);
            i3++;
            Transition transition2 = transition;
            if (transition2.mId == i2) {
                return transition2;
            }
        }
        return null;
    }

    public int getTransitionDirection(int i2) {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Transition transition = arrayList.get(i3);
            i3++;
            if (transition.mConstraintSetStart == i2) {
                return 0;
            }
        }
        return 1;
    }

    public List<Transition> getTransitionsWithState(int i2) {
        int realID = getRealID(i2);
        ArrayList arrayList = new ArrayList();
        ArrayList<Transition> arrayList2 = this.mTransitionList;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Transition transition = arrayList2.get(i3);
            i3++;
            Transition transition2 = transition;
            if (transition2.mConstraintSetStart == realID || transition2.mConstraintSetEnd == realID) {
                arrayList.add(transition2);
            }
        }
        return arrayList;
    }

    public boolean hasKeyFramePosition(View view, int i2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return false;
        }
        ArrayList arrayList = transition.mKeyFramesList;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ArrayList<Key> keyFramesForView = ((KeyFrames) obj).getKeyFramesForView(view.getId());
            int size2 = keyFramesForView.size();
            int i4 = 0;
            while (i4 < size2) {
                Key key = keyFramesForView.get(i4);
                i4++;
                if (key.mFramePosition == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isViewTransitionEnabled(int i2) {
        return this.mViewTransitionController.isViewTransitionEnabled(i2);
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.mConstraintSetIdMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i2) {
        for (Map.Entry<String, Integer> entry : this.mConstraintSetIdMap.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void processScrollMove(float f2, float f3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollMove(f2, f3);
    }

    public void processScrollUp(float f2, float f3) {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.scrollUp(f2, f3);
    }

    public void processTouchEvent(MotionEvent motionEvent, int i2, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i2 != -1) {
            int action = motionEvent.getAction();
            boolean z2 = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (this.mCurrentTransition.mTouchResponse != null) {
                    RectF limitBoundsTo = this.mCurrentTransition.mTouchResponse.getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    RectF touchRegion = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mMotionOutsideRegion = false;
                    } else {
                        this.mMotionOutsideRegion = true;
                    }
                    this.mCurrentTransition.mTouchResponse.setDown(this.mLastTouchX, this.mLastTouchY);
                    return;
                }
                return;
            }
            if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                    return;
                }
                Transition transitionBestTransitionFor = bestTransitionFor(i2, rawX, rawY, motionEvent2);
                if (transitionBestTransitionFor != null) {
                    motionLayout.setTransition(transitionBestTransitionFor);
                    RectF touchRegion2 = this.mCurrentTransition.mTouchResponse.getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        z2 = true;
                    }
                    this.mMotionOutsideRegion = z2;
                    this.mCurrentTransition.mTouchResponse.setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                }
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        Transition transition = this.mCurrentTransition;
        if (transition != null && transition.mTouchResponse != null && !this.mMotionOutsideRegion) {
            this.mCurrentTransition.mTouchResponse.processTouchEvent(motionEvent, this.mVelocityTracker, i2, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionTracker = this.mVelocityTracker) == null) {
            return;
        }
        motionTracker.recycle();
        this.mVelocityTracker = null;
        int i3 = motionLayout.mCurrentState;
        if (i3 != -1) {
            autoTransition(motionLayout, i3);
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i2);
            if (hasCycleDependency(iKeyAt)) {
                return;
            }
            readConstraintChain(iKeyAt, motionLayout);
        }
    }

    public void removeTransition(Transition transition) {
        int index = getIndex(transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i2, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i2, constraintSet);
    }

    public void setDuration(int i2) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(i2);
        } else {
            this.mDefaultDuration = i2;
        }
    }

    public void setKeyframe(View view, int i2, String str, Object obj) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) {
            return;
        }
        ArrayList arrayList = transition.mKeyFramesList;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            ArrayList<Key> keyFramesForView = ((KeyFrames) obj2).getKeyFramesForView(view.getId());
            int size2 = keyFramesForView.size();
            int i4 = 0;
            while (i4 < size2) {
                Key key = keyFramesForView.get(i4);
                i4++;
                if (key.mFramePosition == i2) {
                    if (obj != null) {
                    }
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z2) {
        this.mRtl = z2;
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setTransition(int r10, int r11) {
        /*
            r9 = this;
            androidx.constraintlayout.widget.StateSet r0 = r9.mStateSet
            r1 = -1
            if (r0 == 0) goto L18
            int r0 = r0.stateGetConstraintID(r10, r1, r1)
            if (r0 == r1) goto Lc
            goto Ld
        Lc:
            r0 = r10
        Ld:
            androidx.constraintlayout.widget.StateSet r2 = r9.mStateSet
            int r2 = r2.stateGetConstraintID(r11, r1, r1)
            if (r2 == r1) goto L16
            goto L1a
        L16:
            r2 = r11
            goto L1a
        L18:
            r0 = r10
            goto L16
        L1a:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            if (r3 == 0) goto L2d
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r3)
            if (r3 != r11) goto L2d
            androidx.constraintlayout.motion.widget.MotionScene$Transition r3 = r9.mCurrentTransition
            int r3 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r3)
            if (r3 != r10) goto L2d
            goto L6c
        L2d:
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mTransitionList
            int r4 = r3.size()
            r5 = 0
            r6 = 0
        L35:
            if (r6 >= r4) goto L6d
            java.lang.Object r7 = r3.get(r6)
            int r6 = r6 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r7 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r7
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r7)
            if (r8 != r2) goto L4b
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r7)
            if (r8 == r0) goto L57
        L4b:
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r7)
            if (r8 != r11) goto L35
            int r8 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$100(r7)
            if (r8 != r10) goto L35
        L57:
            r9.mCurrentTransition = r7
            if (r7 == 0) goto L6c
            androidx.constraintlayout.motion.widget.TouchResponse r10 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$200(r7)
            if (r10 == 0) goto L6c
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mCurrentTransition
            androidx.constraintlayout.motion.widget.TouchResponse r10 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$200(r10)
            boolean r11 = r9.mRtl
            r10.setRTL(r11)
        L6c:
            return
        L6d:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r10 = r9.mDefaultTransition
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r3 = r9.mAbstractTransitionList
            int r4 = r3.size()
        L75:
            if (r5 >= r4) goto L87
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            androidx.constraintlayout.motion.widget.MotionScene$Transition r6 = (androidx.constraintlayout.motion.widget.MotionScene.Transition) r6
            int r7 = androidx.constraintlayout.motion.widget.MotionScene.Transition.access$000(r6)
            if (r7 != r11) goto L75
            r10 = r6
            goto L75
        L87:
            androidx.constraintlayout.motion.widget.MotionScene$Transition r11 = new androidx.constraintlayout.motion.widget.MotionScene$Transition
            r11.<init>(r9, r10)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.access$102(r11, r0)
            androidx.constraintlayout.motion.widget.MotionScene.Transition.access$002(r11, r2)
            if (r0 == r1) goto L99
            java.util.ArrayList<androidx.constraintlayout.motion.widget.MotionScene$Transition> r10 = r9.mTransitionList
            r10.add(r11)
        L99:
            r9.mCurrentTransition = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.setTransition(int, int):void");
    }

    public void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setupTouch();
    }

    public boolean supportTouch() {
        ArrayList<Transition> arrayList = this.mTransitionList;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Transition transition = arrayList.get(i2);
            i2++;
            if (transition.mTouchResponse != null) {
                return true;
            }
        }
        Transition transition2 = this.mCurrentTransition;
        return (transition2 == null || transition2.mTouchResponse == null) ? false : true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.mScene == this;
    }

    public void viewTransition(int i2, View... viewArr) {
        this.mViewTransitionController.viewTransition(i2, viewArr);
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        static final int TRANSITION_FLAG_INTRA_AUTO = 2;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList<KeyFrames> mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList<TransitionOnClick> mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        public Transition(MotionScene motionScene, Transition transition) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = motionScene;
            this.mDuration = motionScene.mDefaultDuration;
            if (transition != null) {
                this.mPathMotionArc = transition.mPathMotionArc;
                this.mDefaultInterpolator = transition.mDefaultInterpolator;
                this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
                this.mDuration = transition.mDuration;
                this.mKeyFramesList = transition.mKeyFramesList;
                this.mStagger = transition.mStagger;
                this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
            }
        }

        private void fill(MotionScene motionScene, Context context, TypedArray typedArray) throws Resources.NotFoundException {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintSetEnd);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.mConstraintSetEnd);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetEnd, constraintSet);
                    } else if ("xml".equals(resourceTypeName)) {
                        this.mConstraintSetEnd = motionScene.parseInclude(context, this.mConstraintSetEnd);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.mConstraintSetStart);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.mConstraintSetStart);
                        motionScene.mConstraintSetMap.append(this.mConstraintSetStart, constraintSet2);
                    } else if ("xml".equals(resourceTypeName2)) {
                        this.mConstraintSetStart = motionScene.parseInclude(context, this.mConstraintSetStart);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    int i3 = typedArray.peekValue(index).type;
                    if (i3 == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolatorID = resourceId;
                        if (resourceId != -1) {
                            this.mDefaultInterpolator = -2;
                        }
                    } else if (i3 == 3) {
                        String string = typedArray.getString(index);
                        this.mDefaultInterpolatorString = string;
                        if (string != null) {
                            if (string.indexOf("/") > 0) {
                                this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                                this.mDefaultInterpolator = -2;
                            } else {
                                this.mDefaultInterpolator = -1;
                            }
                        }
                    } else {
                        this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i4 = typedArray.getInt(index, this.mDuration);
                    this.mDuration = i4;
                    if (i4 < 8) {
                        this.mDuration = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.mStagger = typedArray.getFloat(index, this.mStagger);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
                } else if (index == R.styleable.Transition_android_id) {
                    this.mId = typedArray.getResourceId(index, this.mId);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.mDisable = typedArray.getBoolean(index, this.mDisable);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = typedArray.getInteger(index, 0);
                }
            }
            if (this.mConstraintSetStart == -1) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            fill(motionScene, context, typedArrayObtainStyledAttributes);
            typedArrayObtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.mKeyFramesList.add(keyFrames);
        }

        public void addOnClick(int i2, int i3) {
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                TransitionOnClick transitionOnClick = arrayList.get(i4);
                i4++;
                TransitionOnClick transitionOnClick2 = transitionOnClick;
                if (transitionOnClick2.mTargetId == i2) {
                    transitionOnClick2.mMode = i3;
                    return;
                }
            }
            this.mOnClicks.add(new TransitionOnClick(this, i2, i3));
        }

        public String debugString(Context context) {
            String resourceEntryName = this.mConstraintSetStart == -1 ? "null" : context.getResources().getResourceEntryName(this.mConstraintSetStart);
            if (this.mConstraintSetEnd == -1) {
                return g.h(resourceEntryName, " -> null");
            }
            StringBuilder sbR = g.r(resourceEntryName, " -> ");
            sbR.append(context.getResources().getResourceEntryName(this.mConstraintSetEnd));
            return sbR.toString();
        }

        public int getAutoTransition() {
            return this.mAutoTransition;
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return !this.mDisable;
        }

        public boolean isTransitionFlag(int i2) {
            return (i2 & this.mTransitionFlags) != 0;
        }

        public void removeOnClick(int i2) {
            TransitionOnClick transitionOnClick;
            ArrayList<TransitionOnClick> arrayList = this.mOnClicks;
            int size = arrayList.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    transitionOnClick = null;
                    break;
                }
                TransitionOnClick transitionOnClick2 = arrayList.get(i3);
                i3++;
                transitionOnClick = transitionOnClick2;
                if (transitionOnClick.mTargetId == i2) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.mOnClicks.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i2) {
            this.mAutoTransition = i2;
        }

        public void setDuration(int i2) {
            this.mDuration = Math.max(i2, 8);
        }

        public void setEnable(boolean z2) {
            setEnabled(z2);
        }

        public void setEnabled(boolean z2) {
            this.mDisable = !z2;
        }

        public void setInterpolatorInfo(int i2, String str, int i3) {
            this.mDefaultInterpolator = i2;
            this.mDefaultInterpolatorString = str;
            this.mDefaultInterpolatorID = i3;
        }

        public void setLayoutDuringTransition(int i2) {
            this.mLayoutDuringTransition = i2;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            this.mTouchResponse = onSwipe == null ? null : new TouchResponse(this.mMotionScene.mMotionLayout, onSwipe);
        }

        public void setOnTouchUp(int i2) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i2);
            }
        }

        public void setPathMotionArc(int i2) {
            this.mPathMotionArc = i2;
        }

        public void setStagger(float f2) {
            this.mStagger = f2;
        }

        public void setTransitionFlag(int i2) {
            this.mTransitionFlags = i2;
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = transition;
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
                for (int i2 = 0; i2 < indexCount; i2++) {
                    int index = typedArrayObtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.OnClick_targetId) {
                        this.mTargetId = typedArrayObtainStyledAttributes.getResourceId(index, this.mTargetId);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.mMode = typedArrayObtainStyledAttributes.getInt(index, this.mMode);
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v2, types: [android.view.View] */
            public void addOnClickListeners(MotionLayout motionLayout, int i2, Transition transition) {
                int i3 = this.mTargetId;
                MotionLayout motionLayoutFindViewById = motionLayout;
                if (i3 != -1) {
                    motionLayoutFindViewById = motionLayout.findViewById(i3);
                }
                if (motionLayoutFindViewById == null) {
                    return;
                }
                int i4 = transition.mConstraintSetStart;
                int i5 = transition.mConstraintSetEnd;
                if (i4 == -1) {
                    motionLayoutFindViewById.setOnClickListener(this);
                    return;
                }
                int i6 = this.mMode;
                boolean z2 = false;
                boolean z3 = ((i6 & 1) != 0 && i2 == i4) | ((i6 & 1) != 0 && i2 == i4) | ((i6 & 256) != 0 && i2 == i4) | ((i6 & 16) != 0 && i2 == i5);
                if ((i6 & 4096) != 0 && i2 == i5) {
                    z2 = true;
                }
                if (z3 || z2) {
                    motionLayoutFindViewById.setOnClickListener(this);
                }
            }

            public boolean isTransitionViable(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.mTransition;
                if (transition2 == transition) {
                    return true;
                }
                int i2 = transition2.mConstraintSetEnd;
                int i3 = this.mTransition.mConstraintSetStart;
                if (i3 == -1) {
                    return motionLayout.mCurrentState != i2;
                }
                int i4 = motionLayout.mCurrentState;
                return i4 == i3 || i4 == i2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MotionLayout motionLayout = this.mTransition.mMotionScene.mMotionLayout;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.mTransition.mConstraintSetStart == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        Transition transition = new Transition(this.mTransition.mMotionScene, this.mTransition);
                        transition.mConstraintSetStart = currentState;
                        transition.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                        motionLayout.setTransition(transition);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    Transition transition2 = this.mTransition.mMotionScene.mCurrentTransition;
                    int i2 = this.mMode;
                    boolean z2 = false;
                    boolean z3 = ((i2 & 1) == 0 && (i2 & 256) == 0) ? false : true;
                    boolean z4 = ((i2 & 16) == 0 && (i2 & 4096) == 0) ? false : true;
                    if (z3 && z4) {
                        Transition transition3 = this.mTransition.mMotionScene.mCurrentTransition;
                        Transition transition4 = this.mTransition;
                        if (transition3 != transition4) {
                            motionLayout.setTransition(transition4);
                        }
                        if (motionLayout.getCurrentState() != motionLayout.getEndState() && motionLayout.getProgress() <= 0.5f) {
                            z2 = z3;
                            z4 = false;
                        }
                    } else {
                        z2 = z3;
                    }
                    if (isTransitionViable(transition2, motionLayout)) {
                        if (z2 && (this.mMode & 1) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToEnd();
                            return;
                        }
                        if (z4 && (this.mMode & 16) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.transitionToStart();
                        } else if (z2 && (this.mMode & 256) != 0) {
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(1.0f);
                        } else {
                            if (!z4 || (this.mMode & 4096) == 0) {
                                return;
                            }
                            motionLayout.setTransition(this.mTransition);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                View viewFindViewById;
                int i2 = this.mTargetId;
                if (i2 == -1 || (viewFindViewById = motionLayout.findViewById(i2)) == null) {
                    return;
                }
                viewFindViewById.setOnClickListener(null);
            }

            public TransitionOnClick(Transition transition, int i2, int i3) {
                this.mTransition = transition;
                this.mTargetId = i2;
                this.mMode = i3;
            }
        }

        public Transition(int i2, MotionScene motionScene, int i3, int i4) {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = i2;
            this.mMotionScene = motionScene;
            this.mConstraintSetStart = i3;
            this.mConstraintSetEnd = i4;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
        }

        public Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0.0f;
            this.mKeyFramesList = new ArrayList<>();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList<>();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = motionScene.mDefaultDuration;
            this.mLayoutDuringTransition = motionScene.mLayoutDuringTransition;
            this.mMotionScene = motionScene;
            fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseInclude(Context context, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && CONSTRAINTSET_TAG.equals(name)) {
                    return parseConstraintSet(context, xml);
                }
            }
            return -1;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
            return -1;
        }
    }

    public ConstraintSet getConstraintSet(int i2) {
        return getConstraintSet(i2, -1, -1);
    }

    public ConstraintSet getConstraintSet(int i2, int i3, int i4) {
        int iStateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + i2);
            System.out.println("size " + this.mConstraintSetMap.size());
        }
        StateSet stateSet = this.mStateSet;
        if (stateSet != null && (iStateGetConstraintID = stateSet.stateGetConstraintID(i2, i3, i4)) != -1) {
            i2 = iStateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i2) == null) {
            Debug.getName(this.mMotionLayout.getContext(), i2);
            SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.mConstraintSetMap.get(i2);
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i2) throws XmlPullParserException, Resources.NotFoundException, IOException {
        this.mMotionLayout = motionLayout;
        this.mViewTransitionController = new ViewTransitionController(motionLayout);
        load(context, i2);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i3 = R.id.motion_base;
        sparseArray.put(i3, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i3));
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition == null || transition.mTouchResponse == null) {
            return;
        }
        this.mCurrentTransition.mTouchResponse.setRTL(this.mRtl);
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
    }
}
