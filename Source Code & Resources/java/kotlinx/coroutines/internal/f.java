package kotlinx.coroutines.internal;

import h1.t;
import h1.u;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final /* synthetic */ class f extends kotlin.jvm.internal.b implements d1.f, y0.a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f803a;

    public f(g gVar) {
        super(gVar, u.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f803a = false;
    }

    @Override // kotlin.jvm.internal.b
    public final d1.b compute() {
        return this.f803a ? this : super.compute();
    }

    @Override // kotlin.jvm.internal.b
    public final d1.b computeReflected() {
        kotlin.jvm.internal.p.f790a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return getOwner().equals(fVar.getOwner()) && getName().equals(fVar.getName()) && getSignature().equals(fVar.getSignature()) && kotlin.jvm.internal.j.a(getBoundReceiver(), fVar.getBoundReceiver());
        }
        if (obj instanceof d1.f) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.b
    public final d1.b getReflected() {
        if (this.f803a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        d1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (d1.f) bVarCompute;
        }
        throw new t("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public final int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // y0.a
    public final Object invoke() {
        return this.receiver.getClass().getSimpleName();
    }

    public final String toString() {
        d1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
