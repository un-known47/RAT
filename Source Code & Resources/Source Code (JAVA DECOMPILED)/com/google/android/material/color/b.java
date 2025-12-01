package com.google.android.material.color;

import android.os.Build;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static ColorResourcesOverride a() {
        int i2 = Build.VERSION.SDK_INT;
        if (30 <= i2 && i2 <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i2 >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }
}
