package androidx.core.util;

import androidx.annotation.RequiresApi;
import p0.d;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RequiresApi(24)
/* loaded from: classes.dex */
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(d<? super T> dVar) {
        return androidx.core.os.a.t(new ContinuationConsumer(dVar));
    }
}
