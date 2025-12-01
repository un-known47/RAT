package androidx.constraintlayout.helper.widget;

import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f53b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f52a = i2;
        this.f53b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f52a) {
            case 0:
                ((Carousel) this.f53b).lambda$updateItems$0();
                break;
            case 1:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) this.f53b);
                break;
            case 2:
                ((MaterialButton) this.f53b).lambda$setOpticalCenterEnabled$1();
                break;
            case 3:
                ((CarouselLayoutManager) this.f53b).refreshKeylineState();
                break;
            default:
                ((MaterialBackOrchestrator) this.f53b).startListeningForBackCallbacksWithPriorityOverlay();
                break;
        }
    }
}
