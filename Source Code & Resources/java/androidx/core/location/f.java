package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f78a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Consumer f79b;
    public final /* synthetic */ Location c;

    public /* synthetic */ f(Consumer consumer, Location location, int i2) {
        this.f78a = i2;
        this.f79b = consumer;
        this.c = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f78a) {
            case 0:
                this.f79b.accept(this.c);
                break;
            default:
                this.f79b.accept(this.c);
                break;
        }
    }
}
