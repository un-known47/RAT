package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import kotlin.jvm.internal.j;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    private final Class<T> clazz;
    private final l initializer;

    public ViewModelInitializer(Class<T> clazz, l initializer) {
        j.e(clazz, "clazz");
        j.e(initializer, "initializer");
        this.clazz = clazz;
        this.initializer = initializer;
    }

    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final l getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
