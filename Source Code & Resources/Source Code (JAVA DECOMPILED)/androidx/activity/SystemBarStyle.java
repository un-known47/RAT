package androidx.activity;

import androidx.annotation.ColorInt;
import kotlin.jvm.internal.j;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class SystemBarStyle {
    public static final Companion Companion = new Companion(null);
    private final int darkScrim;
    private final l detectDarkMode;
    private final int lightScrim;
    private final int nightMode;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        public static /* synthetic */ SystemBarStyle auto$default(Companion companion, int i2, int i3, l lVar, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                lVar = SystemBarStyle$Companion$auto$1.INSTANCE;
            }
            return companion.auto(i2, i3, lVar);
        }

        public final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i3) {
            return auto$default(this, i2, i3, null, 4, null);
        }

        public final SystemBarStyle dark(@ColorInt int i2) {
            return new SystemBarStyle(i2, i2, 2, SystemBarStyle$Companion$dark$1.INSTANCE, null);
        }

        public final SystemBarStyle light(@ColorInt int i2, @ColorInt int i3) {
            return new SystemBarStyle(i2, i3, 1, SystemBarStyle$Companion$light$1.INSTANCE, null);
        }

        private Companion() {
        }

        public final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i3, l detectDarkMode) {
            j.e(detectDarkMode, "detectDarkMode");
            return new SystemBarStyle(i2, i3, 0, detectDarkMode, null);
        }
    }

    public /* synthetic */ SystemBarStyle(int i2, int i3, int i4, l lVar, kotlin.jvm.internal.e eVar) {
        this(i2, i3, i4, lVar);
    }

    public static final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i3) {
        return Companion.auto(i2, i3);
    }

    public static final SystemBarStyle dark(@ColorInt int i2) {
        return Companion.dark(i2);
    }

    public static final SystemBarStyle light(@ColorInt int i2, @ColorInt int i3) {
        return Companion.light(i2, i3);
    }

    public final int getDarkScrim$activity_release() {
        return this.darkScrim;
    }

    public final l getDetectDarkMode$activity_release() {
        return this.detectDarkMode;
    }

    public final int getNightMode$activity_release() {
        return this.nightMode;
    }

    public final int getScrim$activity_release(boolean z2) {
        return z2 ? this.darkScrim : this.lightScrim;
    }

    public final int getScrimWithEnforcedContrast$activity_release(boolean z2) {
        if (this.nightMode == 0) {
            return 0;
        }
        return z2 ? this.darkScrim : this.lightScrim;
    }

    private SystemBarStyle(int i2, int i3, int i4, l lVar) {
        this.lightScrim = i2;
        this.darkScrim = i3;
        this.nightMode = i4;
        this.detectDarkMode = lVar;
    }

    public static final SystemBarStyle auto(@ColorInt int i2, @ColorInt int i3, l lVar) {
        return Companion.auto(i2, i3, lVar);
    }
}
