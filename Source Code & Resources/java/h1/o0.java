package h1;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class o0 extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient u0 f560a;

    public o0(String str, Throwable th, u0 u0Var) {
        super(str);
        this.f560a = u0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return kotlin.jvm.internal.j.a(o0Var.getMessage(), getMessage()) && kotlin.jvm.internal.j.a(o0Var.f560a, this.f560a) && kotlin.jvm.internal.j.a(o0Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        kotlin.jvm.internal.j.b(message);
        int iHashCode = (this.f560a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f560a;
    }
}
