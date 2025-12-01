package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public abstract class TextAppearanceFontCallback {
    public abstract void onFontRetrievalFailed(int i2);

    public abstract void onFontRetrieved(Typeface typeface, boolean z2);
}
