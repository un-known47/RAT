package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class TransitionValues {

    @SuppressLint({"UnknownNullness"})
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    @NonNull
    public String toString() {
        StringBuilder sbR = g.r("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbR.append(this.view);
        sbR.append("\n");
        String strH = g.h(sbR.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strH = strH + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strH;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
