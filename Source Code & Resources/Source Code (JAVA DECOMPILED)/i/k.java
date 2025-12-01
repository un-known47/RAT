package i;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f615a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f616b;

    public /* synthetic */ k(r.e eVar) {
        this.f615a = 0;
        this.f616b = eVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f615a) {
            case 0:
                this.f616b.post(runnable);
                break;
            case 1:
                this.f616b.post(runnable);
                break;
            default:
                ((r.e) this.f616b).post(runnable);
                break;
        }
    }

    public k(int i2) {
        this.f615a = i2;
        switch (i2) {
            case 2:
                r.e eVar = new r.e(Looper.getMainLooper());
                Looper.getMainLooper();
                this.f616b = eVar;
                break;
            default:
                this.f616b = new Handler(Looper.getMainLooper());
                break;
        }
    }
}
