package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T t2) {
            this.value = t2;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public abstract Intent createIntent(Context context, I i2);

    public SynchronousResult<O> getSynchronousResult(Context context, I i2) {
        j.e(context, "context");
        return null;
    }

    public abstract O parseResult(int i2, Intent intent);
}
