package kotlinx.coroutines.scheduling;

import h1.u;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class j extends h {
    public final Runnable c;

    public j(Runnable runnable, long j, i iVar) {
        super(j, iVar);
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.c.run();
        } finally {
            this.f839b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(u.c(runnable));
        sb.append(", ");
        sb.append(this.f838a);
        sb.append(", ");
        sb.append(this.f839b);
        sb.append(']');
        return sb.toString();
    }
}
