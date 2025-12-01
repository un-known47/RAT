package androidx.core.util;

import androidx.core.content.IntentSanitizer;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Predicate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f96a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Predicate f97b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(Predicate predicate, Predicate predicate2, int i2) {
        this.f96a = i2;
        this.f97b = predicate;
        this.c = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i2 = this.f96a;
        return c.a(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        switch (this.f96a) {
        }
        return c.b(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i2 = this.f96a;
        return c.c(this, predicate);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        switch (this.f96a) {
            case 0:
                return c.f(this.f97b, (Predicate) this.c, obj);
            case 1:
                return c.d(this.f97b, (Predicate) this.c, obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.c, this.f97b, obj);
        }
    }

    public /* synthetic */ a(Class cls, Predicate predicate) {
        this.f96a = 2;
        this.c = cls;
        this.f97b = predicate;
    }
}
