package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
class ObjectAnimatorUtils {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static <T, V> ObjectAnimator ofObject(T t2, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t2, property, (TypeConverter) null, path);
        }
    }

    private ObjectAnimatorUtils() {
    }

    public static <T> ObjectAnimator ofPointF(T t2, Property<T, PointF> property, Path path) {
        return Api21Impl.ofObject(t2, property, path);
    }
}
