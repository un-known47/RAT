package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context context, int i2, int i3, int i4, boolean z2, boolean z3) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context context, int i2, int i3, int i4, boolean z2, boolean z3) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context context, int i2, int i3, int i4, boolean z2, boolean z3) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context context, int i2, int i3, int i4, boolean z2, boolean z3) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context context, int i2, int i3, int i4, boolean z2, boolean z3) {
        return null;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context context, int i2, int i3, int i4, boolean z2, boolean z3) {
        return null;
    }

    public void initialize(@NonNull Context context) {
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context context, int i2, int i3, int i4, boolean z2, boolean z3, @Nullable CharSequence charSequence) {
        return charSequence;
    }
}
