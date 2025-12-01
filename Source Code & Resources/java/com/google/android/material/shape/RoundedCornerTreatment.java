package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        float f5 = f4 * f3;
        shapePath.reset(0.0f, f5, 180.0f, 180.0f - f2);
        float f6 = f5 * 2.0f;
        shapePath.addArc(0.0f, 0.0f, f6, f6, 180.0f, f2);
    }

    @Deprecated
    public RoundedCornerTreatment(float f2) {
        this.radius = f2;
    }
}
