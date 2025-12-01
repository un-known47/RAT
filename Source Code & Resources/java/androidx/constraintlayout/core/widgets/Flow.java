package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i2;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i3;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i2 = this.mCount;
            for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < Flow.this.mDisplayedWidgetsCount; i3++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i3];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i4 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.mWidth = width + i4 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i5 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i5 = 0;
                    }
                    this.mHeight = widgetHeight2 + i5 + this.mHeight;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth = widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0) + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight = widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0) + this.mHeight;
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z2, int i2, boolean z3) {
            ConstraintWidget constraintWidget;
            float f2;
            float f3;
            int i3 = this.mCount;
            for (int i4 = 0; i4 < i3 && this.mStartIndex + i4 < Flow.this.mDisplayedWidgetsCount; i4++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i4];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i3 == 0 || this.biggest == null) {
                return;
            }
            boolean z4 = z3 && i2 == 0;
            int i5 = -1;
            int i6 = -1;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = z2 ? (i3 - 1) - i7 : i7;
                if (this.mStartIndex + i8 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                if (Flow.this.mDisplayedWidgets[this.mStartIndex + i8].getVisibility() == 0) {
                    if (i5 == -1) {
                        i5 = i7;
                    }
                    i6 = i7;
                }
            }
            ConstraintWidget constraintWidget3 = null;
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget4 = this.biggest;
                constraintWidget4.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i9 = this.mPaddingLeft;
                if (i2 > 0) {
                    i9 += Flow.this.mHorizontalGap;
                }
                if (z2) {
                    constraintWidget4.mRight.connect(this.mRight, i9);
                    if (z3) {
                        constraintWidget4.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget4.mRight, 0);
                    }
                } else {
                    constraintWidget4.mLeft.connect(this.mLeft, i9);
                    if (z3) {
                        constraintWidget4.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget4.mLeft, 0);
                    }
                }
                int i10 = 0;
                while (i10 < i3 && this.mStartIndex + i10 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget5 = Flow.this.mDisplayedWidgets[this.mStartIndex + i10];
                    if (i10 == 0) {
                        constraintWidget5.connect(constraintWidget5.mTop, this.mTop, this.mPaddingTop);
                        int i11 = Flow.this.mVerticalStyle;
                        float f4 = Flow.this.mVerticalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                            i11 = Flow.this.mFirstVerticalStyle;
                            f4 = Flow.this.mFirstVerticalBias;
                        } else if (z3 && Flow.this.mLastVerticalStyle != -1) {
                            i11 = Flow.this.mLastVerticalStyle;
                            f4 = Flow.this.mLastVerticalBias;
                        }
                        constraintWidget5.setVerticalChainStyle(i11);
                        constraintWidget5.setVerticalBiasPercent(f4);
                    }
                    if (i10 == i3 - 1) {
                        constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget5.mTop.connect(constraintWidget3.mBottom, Flow.this.mVerticalGap);
                        if (i10 == i5) {
                            constraintWidget5.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget3.mBottom.connect(constraintWidget5.mTop, 0);
                        if (i10 == i6 + 1) {
                            constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget5 != constraintWidget4) {
                        if (z2) {
                            int i12 = Flow.this.mHorizontalAlign;
                            if (i12 == 0) {
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            } else if (i12 == 1) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                            } else if (i12 == 2) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            }
                        } else {
                            int i13 = Flow.this.mHorizontalAlign;
                            if (i13 == 0) {
                                constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                            } else if (i13 == 1) {
                                constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                            } else if (i13 == 2) {
                                if (z4) {
                                    constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget5.mLeft.connect(constraintWidget4.mLeft, 0);
                                    constraintWidget5.mRight.connect(constraintWidget4.mRight, 0);
                                }
                            }
                        }
                    }
                    i10++;
                    constraintWidget3 = constraintWidget5;
                }
                return;
            }
            ConstraintWidget constraintWidget6 = this.biggest;
            constraintWidget6.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i14 = this.mPaddingTop;
            if (i2 > 0) {
                i14 += Flow.this.mVerticalGap;
            }
            constraintWidget6.mTop.connect(this.mTop, i14);
            if (z3) {
                constraintWidget6.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i2 > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget6.mTop, 0);
            }
            if (Flow.this.mVerticalAlign != 3 || constraintWidget6.hasBaseline()) {
                constraintWidget = constraintWidget6;
            } else {
                for (int i15 = 0; i15 < i3; i15++) {
                    int i16 = z2 ? (i3 - 1) - i15 : i15;
                    if (this.mStartIndex + i16 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i16];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget6;
            }
            int i17 = 0;
            while (i17 < i3) {
                int i18 = z2 ? (i3 - 1) - i17 : i17;
                if (this.mStartIndex + i18 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget7 = Flow.this.mDisplayedWidgets[this.mStartIndex + i18];
                if (i17 == 0) {
                    constraintWidget7.connect(constraintWidget7.mLeft, this.mLeft, this.mPaddingLeft);
                }
                if (i18 == 0) {
                    int i19 = Flow.this.mHorizontalStyle;
                    float f5 = Flow.this.mHorizontalBias;
                    if (z2) {
                        f5 = 1.0f - f5;
                    }
                    if (this.mStartIndex != 0 || Flow.this.mFirstHorizontalStyle == -1) {
                        if (z3 && Flow.this.mLastHorizontalStyle != -1) {
                            i19 = Flow.this.mLastHorizontalStyle;
                            if (z2) {
                                f3 = Flow.this.mLastHorizontalBias;
                                f2 = 1.0f - f3;
                                f5 = f2;
                            } else {
                                f2 = Flow.this.mLastHorizontalBias;
                                f5 = f2;
                            }
                        }
                        constraintWidget7.setHorizontalChainStyle(i19);
                        constraintWidget7.setHorizontalBiasPercent(f5);
                    } else {
                        i19 = Flow.this.mFirstHorizontalStyle;
                        if (z2) {
                            f3 = Flow.this.mFirstHorizontalBias;
                            f2 = 1.0f - f3;
                            f5 = f2;
                            constraintWidget7.setHorizontalChainStyle(i19);
                            constraintWidget7.setHorizontalBiasPercent(f5);
                        } else {
                            f2 = Flow.this.mFirstHorizontalBias;
                            f5 = f2;
                            constraintWidget7.setHorizontalChainStyle(i19);
                            constraintWidget7.setHorizontalBiasPercent(f5);
                        }
                    }
                }
                if (i17 == i3 - 1) {
                    constraintWidget7.connect(constraintWidget7.mRight, this.mRight, this.mPaddingRight);
                }
                if (constraintWidget3 != null) {
                    constraintWidget7.mLeft.connect(constraintWidget3.mRight, Flow.this.mHorizontalGap);
                    if (i17 == i5) {
                        constraintWidget7.mLeft.setGoneMargin(this.mPaddingLeft);
                    }
                    constraintWidget3.mRight.connect(constraintWidget7.mLeft, 0);
                    if (i17 == i6 + 1) {
                        constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                    }
                }
                if (constraintWidget7 != constraintWidget6) {
                    if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget7 != constraintWidget && constraintWidget7.hasBaseline()) {
                        constraintWidget7.mBaseline.connect(constraintWidget.mBaseline, 0);
                    } else {
                        int i20 = Flow.this.mVerticalAlign;
                        if (i20 == 0) {
                            constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                        } else if (i20 == 1) {
                            constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                        } else if (z4) {
                            constraintWidget7.mTop.connect(this.mTop, this.mPaddingTop);
                            constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
                        } else {
                            constraintWidget7.mTop.connect(constraintWidget6.mTop, 0);
                            constraintWidget7.mBottom.connect(constraintWidget6.mBottom, 0);
                        }
                    }
                }
                i17++;
                constraintWidget3 = constraintWidget7;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i2) {
            int i3 = this.mNbMatchConstraintsWidgets;
            if (i3 == 0) {
                return;
            }
            int i4 = this.mCount;
            int i5 = i2 / i3;
            for (int i6 = 0; i6 < i4 && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i7 = i5;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i7);
                    i5 = i7;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i2) {
            this.mStartIndex = i2;
        }

        public void setup(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.mOrientation = i2;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i3;
            this.mPaddingTop = i4;
            this.mPaddingRight = i5;
            this.mPaddingBottom = i6;
            this.mMax = i7;
        }
    }

    private void createAlignedConstraints(boolean z2) {
        ConstraintWidget constraintWidget;
        float f2;
        int i2;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i3 = 0; i3 < this.mDisplayedWidgetsCount; i3++) {
            this.mDisplayedWidgets[i3].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i4 = iArr[0];
        int i5 = iArr[1];
        float f3 = this.mHorizontalBias;
        ConstraintWidget constraintWidget2 = null;
        int i6 = 0;
        while (i6 < i4) {
            if (z2) {
                i2 = (i4 - i6) - 1;
                f2 = 1.0f - this.mHorizontalBias;
            } else {
                f2 = f3;
                i2 = i6;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i2];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i6 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f2);
                }
                if (i6 == i4 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i6 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i6++;
            f3 = f2;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i7];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i7 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i7 == i5 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i7 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < i5; i9++) {
                int i10 = (i9 * i4) + i8;
                if (this.mOrientation == 1) {
                    i10 = (i8 * i5) + i9;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i10 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i10]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i8];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i9];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.mMatchConstraintPercentHeight * i2);
                if (i4 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
                }
                return i4;
            }
            constraintWidget2 = constraintWidget;
            if (i3 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.mMatchConstraintPercentWidth * i2);
                if (i4 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i4;
            }
            constraintWidget2 = constraintWidget;
            if (i3 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        int i5;
        Flow flow;
        int i6;
        ConstraintAnchor constraintAnchor;
        int i7;
        Flow flow2 = this;
        if (i2 == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i8 = i4;
        WidgetsList widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
        flow2.mChainList.add(widgetsList);
        if (i3 == 0) {
            i5 = 0;
            int i9 = 0;
            int i10 = 0;
            while (i10 < i2) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i10];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i8);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i11 = i5;
                boolean z2 = (i9 == i8 || (flow2.mHorizontalGap + i9) + widgetWidth > i8) && widgetsList.biggest != null;
                if (!z2 && i10 > 0 && (i7 = flow2.mMaxElementsWrap) > 0 && i10 % i7 == 0) {
                    z2 = true;
                }
                if (z2) {
                    widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
                    widgetsList.setStartIndex(i10);
                    flow2.mChainList.add(widgetsList);
                } else {
                    if (i10 > 0) {
                        i9 = flow2.mHorizontalGap + widgetWidth + i9;
                    }
                    widgetsList.add(constraintWidget);
                    i10++;
                    i5 = i11;
                }
                i9 = widgetWidth;
                widgetsList.add(constraintWidget);
                i10++;
                i5 = i11;
            }
        } else {
            i5 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i13 < i2) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i13];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i8);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i14 = i5;
                boolean z3 = (i12 == i8 || (flow2.mVerticalGap + i12) + widgetHeight > i8) && widgetsList.biggest != null;
                if (!z3 && i13 > 0 && (i6 = flow2.mMaxElementsWrap) > 0 && i13 % i6 == 0) {
                    z3 = true;
                }
                if (z3) {
                    widgetsList = flow2.new WidgetsList(i3, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i8);
                    flow = flow2;
                    widgetsList.setStartIndex(i13);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i13 > 0) {
                        i12 = flow.mVerticalGap + widgetHeight + i12;
                    }
                    widgetsList.add(constraintWidget2);
                    i13++;
                    i8 = i4;
                    i5 = i14;
                    flow2 = flow;
                }
                i12 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i13++;
                i8 = i4;
                i5 = i14;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z4 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i5 > 0 && z4) {
            for (int i15 = 0; i15 < size; i15++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i15);
                if (i3 == 0) {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i4 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int paddingBottom2 = paddingBottom;
        int i16 = 0;
        int paddingRight2 = paddingRight;
        int i17 = paddingTop;
        int i18 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i19 = 0;
        for (int i20 = 0; i20 < size; i20++) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i20);
            if (i3 == 0) {
                if (i20 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i20 + 1).biggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.biggest.mBottom;
                int i21 = i19;
                widgetsList3.setup(i3, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i18, i17, paddingRight2, paddingBottom2, i4);
                int iMax = Math.max(i16, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i21;
                if (i20 > 0) {
                    height += flow3.mVerticalGap;
                }
                i19 = height;
                i16 = iMax;
                constraintAnchor9 = constraintAnchor10;
                i17 = 0;
            } else {
                int i22 = i16;
                int i23 = i19;
                if (i20 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i20 + 1).biggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i3, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i18, i17, paddingRight2, paddingBottom2, i4);
                int width = widgetsList3.getWidth() + i22;
                int iMax2 = Math.max(i23, widgetsList3.getHeight());
                if (i20 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i24 = width;
                i19 = iMax2;
                i16 = i24;
                constraintAnchor6 = constraintAnchor11;
                i18 = 0;
            }
        }
        iArr[0] = i16;
        iArr[1] = i19;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        WidgetsList widgetsList;
        if (i2 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i4);
            widgetsList = widgetsList2;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            widgetsList.add(constraintWidgetArr[i5]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z2) {
        super.addToSolver(linearSystem, z2);
        boolean z3 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i2 = this.mWrapMode;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = this.mChainList.size();
                int i3 = 0;
                while (i3 < size) {
                    this.mChainList.get(i3).createConstraints(z3, i3, i3 == size + (-1));
                    i3++;
                }
            } else if (i2 == 2) {
                createAlignedConstraints(z3);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z3, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i2, int i3, int i4, int i5) {
        int i6;
        ConstraintWidget[] constraintWidgetArr;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i7 = (i3 - paddingLeft) - paddingRight;
        int i8 = this.mOrientation;
        if (i8 == 1) {
            i7 = (i5 - paddingTop) - paddingBottom;
        }
        int i9 = i7;
        if (i8 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i6 = this.mWidgetsCount;
            if (i10 >= i6) {
                break;
            }
            if (this.mWidgets[i10].getVisibility() == 8) {
                i11++;
            }
            i10++;
        }
        if (i11 > 0) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[i6 - i11];
            int i12 = 0;
            i6 = 0;
            while (i12 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget = this.mWidgets[i12];
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr4[i6] = constraintWidget;
                    i6++;
                }
                i12++;
                constraintWidgetArr3 = constraintWidgetArr4;
            }
            constraintWidgetArr = constraintWidgetArr3;
        } else {
            constraintWidgetArr = constraintWidgetArr2;
        }
        int i13 = i6;
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i13;
        int i14 = this.mWrapMode;
        if (i14 == 0) {
            measureNoWrap(constraintWidgetArr, i13, this.mOrientation, i9, iArr);
        } else if (i14 == 1) {
            measureChainWrap(constraintWidgetArr, i13, this.mOrientation, i9, iArr);
        } else if (i14 == 2) {
            measureAligned(constraintWidgetArr, i13, this.mOrientation, i9, iArr);
        }
        int iMin = iArr[0] + paddingLeft + paddingRight;
        int iMin2 = iArr[1] + paddingTop + paddingBottom;
        if (i2 == 1073741824) {
            iMin = i3;
        } else if (i2 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i3);
        } else if (i2 != 0) {
            iMin = 0;
        }
        if (i4 == 1073741824) {
            iMin2 = i5;
        } else if (i4 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i5);
        } else if (i4 != 0) {
            iMin2 = 0;
        }
        setMeasure(iMin, iMin2);
        setWidth(iMin);
        setHeight(iMin2);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }

    public void setFirstHorizontalBias(float f2) {
        this.mFirstHorizontalBias = f2;
    }

    public void setFirstHorizontalStyle(int i2) {
        this.mFirstHorizontalStyle = i2;
    }

    public void setFirstVerticalBias(float f2) {
        this.mFirstVerticalBias = f2;
    }

    public void setFirstVerticalStyle(int i2) {
        this.mFirstVerticalStyle = i2;
    }

    public void setHorizontalAlign(int i2) {
        this.mHorizontalAlign = i2;
    }

    public void setHorizontalBias(float f2) {
        this.mHorizontalBias = f2;
    }

    public void setHorizontalGap(int i2) {
        this.mHorizontalGap = i2;
    }

    public void setHorizontalStyle(int i2) {
        this.mHorizontalStyle = i2;
    }

    public void setLastHorizontalBias(float f2) {
        this.mLastHorizontalBias = f2;
    }

    public void setLastHorizontalStyle(int i2) {
        this.mLastHorizontalStyle = i2;
    }

    public void setLastVerticalBias(float f2) {
        this.mLastVerticalBias = f2;
    }

    public void setLastVerticalStyle(int i2) {
        this.mLastVerticalStyle = i2;
    }

    public void setMaxElementsWrap(int i2) {
        this.mMaxElementsWrap = i2;
    }

    public void setOrientation(int i2) {
        this.mOrientation = i2;
    }

    public void setVerticalAlign(int i2) {
        this.mVerticalAlign = i2;
    }

    public void setVerticalBias(float f2) {
        this.mVerticalBias = f2;
    }

    public void setVerticalGap(int i2) {
        this.mVerticalGap = i2;
    }

    public void setVerticalStyle(int i2) {
        this.mVerticalStyle = i2;
    }

    public void setWrapMode(int i2) {
        this.mWrapMode = i2;
    }
}
