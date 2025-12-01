package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class ComputableLiveData<T> {
    private final LiveData<T> _liveData;
    private final AtomicBoolean computing;
    private final Executor executor;
    private final AtomicBoolean invalid;
    public final Runnable invalidationRunnable;
    private final LiveData<T> liveData;
    public final Runnable refreshRunnable;

    public ComputableLiveData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidationRunnable$lambda$1(ComputableLiveData this$0) {
        j.e(this$0, "this$0");
        boolean zHasActiveObservers = this$0.getLiveData().hasActiveObservers();
        if (this$0.invalid.compareAndSet(false, true) && zHasActiveObservers) {
            this$0.executor.execute(this$0.refreshRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void refreshRunnable$lambda$0(ComputableLiveData this$0) {
        j.e(this$0, "this$0");
        do {
            boolean z2 = false;
            if (this$0.computing.compareAndSet(false, true)) {
                Object objCompute = null;
                boolean z3 = false;
                while (this$0.invalid.compareAndSet(true, false)) {
                    try {
                        objCompute = this$0.compute();
                        z3 = true;
                    } catch (Throwable th) {
                        this$0.computing.set(false);
                        throw th;
                    }
                }
                if (z3) {
                    this$0.getLiveData().postValue(objCompute);
                }
                this$0.computing.set(false);
                z2 = z3;
            }
            if (!z2) {
                return;
            }
        } while (this$0.invalid.get());
    }

    @WorkerThread
    public abstract T compute();

    public final AtomicBoolean getComputing$lifecycle_livedata_release() {
        return this.computing;
    }

    public final Executor getExecutor$lifecycle_livedata_release() {
        return this.executor;
    }

    public final AtomicBoolean getInvalid$lifecycle_livedata_release() {
        return this.invalid;
    }

    public LiveData<T> getLiveData() {
        return this.liveData;
    }

    public void invalidate() {
        ArchTaskExecutor.getInstance().executeOnMainThread(this.invalidationRunnable);
    }

    public ComputableLiveData(Executor executor) {
        j.e(executor, "executor");
        this.executor = executor;
        LiveData<T> liveData = new LiveData<T>(this) { // from class: androidx.lifecycle.ComputableLiveData$_liveData$1
            final /* synthetic */ ComputableLiveData<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.lifecycle.LiveData
            public void onActive() {
                this.this$0.getExecutor$lifecycle_livedata_release().execute(this.this$0.refreshRunnable);
            }
        };
        this._liveData = liveData;
        this.liveData = liveData;
        this.invalid = new AtomicBoolean(true);
        final int i2 = 0;
        this.computing = new AtomicBoolean(false);
        this.refreshRunnable = new Runnable(this) { // from class: androidx.lifecycle.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ComputableLiveData f143b;

            {
                this.f143b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        ComputableLiveData.refreshRunnable$lambda$0(this.f143b);
                        break;
                    default:
                        ComputableLiveData.invalidationRunnable$lambda$1(this.f143b);
                        break;
                }
            }
        };
        final int i3 = 1;
        this.invalidationRunnable = new Runnable(this) { // from class: androidx.lifecycle.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ComputableLiveData f143b;

            {
                this.f143b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i3) {
                    case 0:
                        ComputableLiveData.refreshRunnable$lambda$0(this.f143b);
                        break;
                    default:
                        ComputableLiveData.invalidationRunnable$lambda$1(this.f143b);
                        break;
                }
            }
        };
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ComputableLiveData(Executor executor, int i2, kotlin.jvm.internal.e eVar) {
        if ((i2 & 1) != 0) {
            executor = ArchTaskExecutor.getIOThreadExecutor();
            j.d(executor, "getIOThreadExecutor()");
        }
        this(executor);
    }

    @VisibleForTesting
    public static /* synthetic */ void getInvalidationRunnable$lifecycle_livedata_release$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$lifecycle_livedata_release$annotations() {
    }
}
