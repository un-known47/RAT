package h1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f549b = AtomicIntegerFieldUpdater.newUpdater(k.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f550a;

    public k(boolean z2, Throwable th) {
        this.f550a = th;
        this._handled = z2 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f550a + ']';
    }
}
