package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class ColorContrast {
    private static final float HIGH_CONTRAST_THRESHOLD = 0.6666667f;
    private static final float MEDIUM_CONTRAST_THRESHOLD = 0.33333334f;

    private ColorContrast() {
    }

    public static void applyToActivitiesIfAvailable(@NonNull Application application, @NonNull ColorContrastOptions colorContrastOptions) {
        if (isContrastAvailable()) {
            application.registerActivityLifecycleCallbacks(new ColorContrastActivityLifecycleCallbacks(colorContrastOptions));
        }
    }

    public static void applyToActivityIfAvailable(@NonNull Activity activity, @NonNull ColorContrastOptions colorContrastOptions) {
        int contrastThemeOverlayResourceId;
        if (isContrastAvailable() && (contrastThemeOverlayResourceId = getContrastThemeOverlayResourceId(activity, colorContrastOptions)) != 0) {
            ThemeUtils.applyThemeOverlay(activity, contrastThemeOverlayResourceId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int getContrastThemeOverlayResourceId(android.content.Context r2, com.google.android.material.color.ColorContrastOptions r3) {
        /*
            java.lang.String r0 = "uimode"
            java.lang.Object r2 = r2.getSystemService(r0)
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2
            boolean r0 = isContrastAvailable()
            if (r0 == 0) goto L32
            if (r2 != 0) goto L11
            goto L32
        L11:
            float r2 = com.google.android.material.color.a.a(r2)
            int r0 = r3.getMediumContrastThemeOverlay()
            int r3 = r3.getHighContrastThemeOverlay()
            r1 = 1059760811(0x3f2aaaab, float:0.6666667)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L27
            if (r3 != 0) goto L30
            goto L31
        L27:
            r1 = 1051372203(0x3eaaaaab, float:0.33333334)
            int r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r2 < 0) goto L32
            if (r0 != 0) goto L31
        L30:
            return r3
        L31:
            return r0
        L32:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorContrast.getContrastThemeOverlayResourceId(android.content.Context, com.google.android.material.color.ColorContrastOptions):int");
    }

    @ChecksSdkIntAtLeast(api = 34)
    public static boolean isContrastAvailable() {
        return Build.VERSION.SDK_INT >= 34;
    }

    @NonNull
    public static Context wrapContextIfAvailable(@NonNull Context context, @NonNull ColorContrastOptions colorContrastOptions) {
        int contrastThemeOverlayResourceId;
        return (isContrastAvailable() && (contrastThemeOverlayResourceId = getContrastThemeOverlayResourceId(context, colorContrastOptions)) != 0) ? new ContextThemeWrapper(context, contrastThemeOverlayResourceId) : context;
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @RequiresApi(34)
    public static class ColorContrastActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final Set<Activity> activitiesInStack = new LinkedHashSet();
        private final ColorContrastOptions colorContrastOptions;

        @Nullable
        private UiModeManager.ContrastChangeListener contrastChangeListener;

        public ColorContrastActivityLifecycleCallbacks(ColorContrastOptions colorContrastOptions) {
            this.colorContrastOptions = colorContrastOptions;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            this.activitiesInStack.remove(activity);
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager == null || this.contrastChangeListener == null || !this.activitiesInStack.isEmpty()) {
                return;
            }
            uiModeManager.removeContrastChangeListener(this.contrastChangeListener);
            this.contrastChangeListener = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            UiModeManager uiModeManager = (UiModeManager) activity.getSystemService("uimode");
            if (uiModeManager != null && this.activitiesInStack.isEmpty() && this.contrastChangeListener == null) {
                this.contrastChangeListener = new UiModeManager.ContrastChangeListener() { // from class: com.google.android.material.color.ColorContrast.ColorContrastActivityLifecycleCallbacks.1
                    @Override // android.app.UiModeManager.ContrastChangeListener
                    public void onContrastChanged(float f2) {
                        Iterator it = ColorContrastActivityLifecycleCallbacks.this.activitiesInStack.iterator();
                        while (it.hasNext()) {
                            ((Activity) it.next()).recreate();
                        }
                    }
                };
                uiModeManager.addContrastChangeListener(ContextCompat.getMainExecutor(activity.getApplicationContext()), this.contrastChangeListener);
            }
            this.activitiesInStack.add(activity);
            if (uiModeManager != null) {
                ColorContrast.applyToActivityIfAvailable(activity, this.colorContrastOptions);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }
}
