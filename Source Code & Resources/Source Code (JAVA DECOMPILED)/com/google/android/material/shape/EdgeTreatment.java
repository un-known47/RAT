package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f2, float f3, @NonNull ShapePath shapePath) {
        getEdgePath(f2, f2 / 2.0f, f3, shapePath);
    }

    public void getEdgePath(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f2, 0.0f);
    }
}
