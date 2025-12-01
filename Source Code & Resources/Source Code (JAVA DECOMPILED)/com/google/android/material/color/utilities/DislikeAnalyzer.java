package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class DislikeAnalyzer {
    private DislikeAnalyzer() {
        throw new UnsupportedOperationException();
    }

    public static Hct fixIfDisliked(Hct hct) {
        return isDisliked(hct) ? Hct.from(hct.getHue(), hct.getChroma(), 70.0d) : hct;
    }

    public static boolean isDisliked(Hct hct) {
        return ((((double) Math.round(hct.getHue())) > 90.0d ? 1 : (((double) Math.round(hct.getHue())) == 90.0d ? 0 : -1)) >= 0 && (((double) Math.round(hct.getHue())) > 111.0d ? 1 : (((double) Math.round(hct.getHue())) == 111.0d ? 0 : -1)) <= 0) && ((((double) Math.round(hct.getChroma())) > 16.0d ? 1 : (((double) Math.round(hct.getChroma())) == 16.0d ? 0 : -1)) > 0) && ((((double) Math.round(hct.getTone())) > 65.0d ? 1 : (((double) Math.round(hct.getTone())) == 65.0d ? 0 : -1)) < 0);
    }
}
