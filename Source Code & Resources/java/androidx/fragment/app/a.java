package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f130a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f131b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f130a = i2;
        this.f131b = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        switch (this.f130a) {
            case 0:
                return ((FragmentActivity) this.f131b).lambda$init$0();
            case 1:
                return ((FragmentManager) this.f131b).lambda$attachController$4();
            default:
                return SavedStateHandle.savedStateProvider$lambda$0((SavedStateHandle) this.f131b);
        }
    }
}
