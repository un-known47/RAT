package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.f;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class InitializerViewModelFactory implements ViewModelProvider.Factory {
    private final ViewModelInitializer<?>[] initializers;

    public InitializerViewModelFactory(ViewModelInitializer<?>... initializers) {
        j.e(initializers, "initializers");
        this.initializers = initializers;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final /* synthetic */ ViewModel create(Class cls) {
        return f.a(this, cls);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        j.e(modelClass, "modelClass");
        j.e(extras, "extras");
        T t2 = null;
        for (ViewModelInitializer<?> viewModelInitializer : this.initializers) {
            if (j.a(viewModelInitializer.getClazz$lifecycle_viewmodel_release(), modelClass)) {
                Object objInvoke = viewModelInitializer.getInitializer$lifecycle_viewmodel_release().invoke(extras);
                t2 = objInvoke instanceof ViewModel ? (T) objInvoke : null;
            }
        }
        if (t2 != null) {
            return t2;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(modelClass.getName()));
    }
}
