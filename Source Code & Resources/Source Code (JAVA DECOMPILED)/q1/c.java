package q1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends a {
    @Override // q1.a
    public final List b(Executor executor) {
        return Arrays.asList(new k(), new p(executor));
    }

    @Override // q1.a
    public final List c() {
        return Collections.singletonList(new b(1));
    }
}
