package androidx.core.content;

import android.content.ClipData;
import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f69a;

    public /* synthetic */ e(int i2) {
        this.f69a = i2;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i2 = this.f69a;
        return androidx.core.util.c.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f69a) {
        }
        return androidx.core.util.c.b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i2 = this.f69a;
        return androidx.core.util.c.c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f69a) {
            case 0:
                return IntentSanitizer.Builder.lambda$allowAnyComponent$10((ComponentName) obj);
            case 1:
                return IntentSanitizer.Builder.lambda$allowExtra$14(obj);
            case 2:
                return IntentSanitizer.Builder.lambda$new$0((String) obj);
            case 3:
                return IntentSanitizer.Builder.lambda$new$1((Uri) obj);
            case 4:
                return IntentSanitizer.Builder.lambda$new$2((String) obj);
            case 5:
                return IntentSanitizer.Builder.lambda$new$3((String) obj);
            case 6:
                return IntentSanitizer.Builder.lambda$new$4((String) obj);
            case 7:
                return IntentSanitizer.Builder.lambda$new$5((ComponentName) obj);
            case 8:
                return IntentSanitizer.Builder.lambda$new$6((Uri) obj);
            case 9:
                return IntentSanitizer.Builder.lambda$new$7((ClipData) obj);
            case 10:
                return IntentSanitizer.Builder.lambda$allowExtra$12(obj);
            default:
                return androidx.core.util.c.h(obj);
        }
    }
}
