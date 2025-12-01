package okhttp3.internal.platform;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.List;
import kotlin.jvm.internal.j;
import m0.q;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class PlatformInitializer implements Initializer<Platform> {
    @Override // androidx.startup.Initializer
    public List<Class<Initializer<?>>> dependencies() {
        return q.f867a;
    }

    @Override // androidx.startup.Initializer
    public Platform create(Context context) {
        j.e(context, "context");
        PlatformRegistry.INSTANCE.setApplicationContext(context);
        return Platform.Companion.get();
    }
}
