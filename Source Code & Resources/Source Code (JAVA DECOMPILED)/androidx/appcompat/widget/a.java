package androidx.appcompat.widget;

import android.graphics.drawable.Icon;
import android.os.Parcelable;
import android.widget.SpinnerAdapter;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ boolean C(Parcelable parcelable) {
        return parcelable instanceof Icon;
    }

    public static /* bridge */ /* synthetic */ boolean D(SpinnerAdapter spinnerAdapter) {
        return spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter;
    }

    public static /* bridge */ /* synthetic */ Icon v(Parcelable parcelable) {
        return (Icon) parcelable;
    }

    public static /* bridge */ /* synthetic */ android.widget.ThemedSpinnerAdapter z(SpinnerAdapter spinnerAdapter) {
        return (android.widget.ThemedSpinnerAdapter) spinnerAdapter;
    }
}
