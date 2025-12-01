package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.j;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application) {
        j.e(application, "application");
        this.application = application;
    }

    public <T extends Application> T getApplication() {
        T t2 = (T) this.application;
        j.c(t2, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t2;
    }
}
