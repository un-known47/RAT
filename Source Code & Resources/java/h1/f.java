package h1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class f extends k {
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(f.class, "_resumed");
    private volatile /* synthetic */ int _resumed;

    public f(e eVar, Throwable th, boolean z2) {
        super(z2, th);
        this._resumed = 0;
    }
}
