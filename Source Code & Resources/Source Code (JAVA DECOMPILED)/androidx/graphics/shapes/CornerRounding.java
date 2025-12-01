package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import com.google.android.material.color.utilities.Contrast;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class CornerRounding {
    public static final Companion Companion;
    public static final CornerRounding Unrounded;
    private final float radius;
    private final float smoothing;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        e eVar = null;
        Companion = new Companion(eVar);
        float f2 = 0.0f;
        Unrounded = new CornerRounding(f2, f2, 3, eVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CornerRounding() {
        float f2 = 0.0f;
        this(f2, f2, 3, null);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    public CornerRounding(@FloatRange(from = 0.0d) float f2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f3) {
        this.radius = f2;
        this.smoothing = f3;
    }

    public /* synthetic */ CornerRounding(float f2, float f3, int i2, e eVar) {
        this((i2 & 1) != 0 ? 0.0f : f2, (i2 & 2) != 0 ? 0.0f : f3);
    }
}
