package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class AlignHorizontallyReference extends HelperReference {
    private float mBias;

    public AlignHorizontallyReference(State state) {
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
            constraintReferenceConstraints.clearHorizontal();
            Object obj2 = this.mStartToStart;
            if (obj2 != null) {
                constraintReferenceConstraints.startToStart(obj2);
            } else {
                Object obj3 = this.mStartToEnd;
                if (obj3 != null) {
                    constraintReferenceConstraints.startToEnd(obj3);
                } else {
                    constraintReferenceConstraints.startToStart(State.PARENT);
                }
            }
            Object obj4 = this.mEndToStart;
            if (obj4 != null) {
                constraintReferenceConstraints.endToStart(obj4);
            } else {
                Object obj5 = this.mEndToEnd;
                if (obj5 != null) {
                    constraintReferenceConstraints.endToEnd(obj5);
                } else {
                    constraintReferenceConstraints.endToEnd(State.PARENT);
                }
            }
            float f2 = this.mBias;
            if (f2 != 0.5f) {
                constraintReferenceConstraints.horizontalBias(f2);
            }
        }
    }
}
