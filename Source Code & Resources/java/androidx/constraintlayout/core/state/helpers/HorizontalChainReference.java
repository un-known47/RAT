package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class HorizontalChainReference extends ChainReference {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain;

        static {
            int[] iArr = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((HelperReference) this).mState.constraints(obj).clearHorizontal();
        }
        ArrayList<Object> arrayList2 = this.mReferences;
        int size2 = arrayList2.size();
        ConstraintReference constraintReference = null;
        ConstraintReference constraintReference2 = null;
        int i3 = 0;
        while (i3 < size2) {
            Object obj2 = arrayList2.get(i3);
            i3++;
            ConstraintReference constraintReferenceConstraints = ((HelperReference) this).mState.constraints(obj2);
            if (constraintReference2 == null) {
                Object obj3 = this.mStartToStart;
                if (obj3 != null) {
                    constraintReferenceConstraints.startToStart(obj3).margin(this.mMarginStart);
                } else {
                    Object obj4 = this.mStartToEnd;
                    if (obj4 != null) {
                        constraintReferenceConstraints.startToEnd(obj4).margin(this.mMarginStart);
                    } else {
                        constraintReferenceConstraints.startToStart(State.PARENT);
                    }
                }
                constraintReference2 = constraintReferenceConstraints;
            }
            if (constraintReference != null) {
                constraintReference.endToStart(constraintReferenceConstraints.getKey());
                constraintReferenceConstraints.startToEnd(constraintReference.getKey());
            }
            constraintReference = constraintReferenceConstraints;
        }
        if (constraintReference != null) {
            Object obj5 = this.mEndToStart;
            if (obj5 != null) {
                constraintReference.endToStart(obj5).margin(this.mMarginEnd);
            } else {
                Object obj6 = this.mEndToEnd;
                if (obj6 != null) {
                    constraintReference.endToEnd(obj6).margin(this.mMarginEnd);
                } else {
                    constraintReference.endToEnd(State.PARENT);
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f2 = this.mBias;
        if (f2 != 0.5f) {
            constraintReference2.horizontalBias(f2);
        }
        int i4 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (i4 == 1) {
            constraintReference2.setHorizontalChainStyle(0);
        } else if (i4 == 2) {
            constraintReference2.setHorizontalChainStyle(1);
        } else {
            if (i4 != 3) {
                return;
            }
            constraintReference2.setHorizontalChainStyle(2);
        }
    }
}
