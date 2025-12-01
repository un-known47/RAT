package kotlin.jvm.internal;

import h1.t;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class h extends b implements g, d1.e {
    private final int arity;
    private final int flags;

    public h(int i2, Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, false);
        this.arity = i2;
        this.flags = 0;
    }

    @Override // kotlin.jvm.internal.b
    public d1.b computeReflected() {
        p.f790a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return getName().equals(hVar.getName()) && getSignature().equals(hVar.getSignature()) && this.flags == hVar.flags && this.arity == hVar.arity && j.a(getBoundReceiver(), hVar.getBoundReceiver()) && j.a(getOwner(), hVar.getOwner());
        }
        if (obj instanceof d1.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.g
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // d1.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // d1.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // d1.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // d1.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // d1.e
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        d1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.b
    public d1.e getReflected() {
        d1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (d1.e) bVarCompute;
        }
        throw new t("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
