package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ConstraintReference constraintReferenceConstraints = ((HelperReference) this).mState.constraints(obj);
            constraintReferenceConstraints.clearVertical();
            Object obj2 = this.mTopToTop;
            if (obj2 != null) {
                constraintReferenceConstraints.topToTop(obj2);
            } else {
                Object obj3 = this.mTopToBottom;
                if (obj3 != null) {
                    constraintReferenceConstraints.topToBottom(obj3);
                } else {
                    constraintReferenceConstraints.topToTop(State.PARENT);
                }
            }
            Object obj4 = this.mBottomToTop;
            if (obj4 != null) {
                constraintReferenceConstraints.bottomToTop(obj4);
            } else {
                Object obj5 = this.mBottomToBottom;
                if (obj5 != null) {
                    constraintReferenceConstraints.bottomToBottom(obj5);
                } else {
                    constraintReferenceConstraints.bottomToBottom(State.PARENT);
                }
            }
            float f2 = this.mBias;
            if (f2 != 0.5f) {
                constraintReferenceConstraints.verticalBias(f2);
            }
        }
    }
}
