package com.google.android.material.sidesheet;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
interface SheetCallback {
    void onSlide(@NonNull View view, float f2);

    void onStateChanged(@NonNull View view, int i2);
}
