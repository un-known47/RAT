package o1;

import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c {
    public static final void a(c cVar, g gVar, long j, boolean z2) {
        cVar.getClass();
        if (g.head == null) {
            g.head = new g();
            d dVar = new d("Okio Watchdog");
            dVar.setDaemon(true);
            dVar.start();
        }
        long jNanoTime = System.nanoTime();
        if (j != 0 && z2) {
            gVar.timeoutAt = Math.min(j, gVar.deadlineNanoTime() - jNanoTime) + jNanoTime;
        } else if (j != 0) {
            gVar.timeoutAt = j + jNanoTime;
        } else {
            if (!z2) {
                throw new AssertionError();
            }
            gVar.timeoutAt = gVar.deadlineNanoTime();
        }
        long jAccess$remainingNanos = g.access$remainingNanos(gVar, jNanoTime);
        g gVar2 = g.head;
        kotlin.jvm.internal.j.b(gVar2);
        while (gVar2.next != null) {
            g gVar3 = gVar2.next;
            kotlin.jvm.internal.j.b(gVar3);
            if (jAccess$remainingNanos < g.access$remainingNanos(gVar3, jNanoTime)) {
                break;
            }
            gVar2 = gVar2.next;
            kotlin.jvm.internal.j.b(gVar2);
        }
        gVar.next = gVar2.next;
        gVar2.next = gVar;
        if (gVar2 == g.head) {
            g.condition.signal();
        }
    }

    public static final void b(c cVar, g gVar) {
        cVar.getClass();
        for (g gVar2 = g.head; gVar2 != null; gVar2 = gVar2.next) {
            if (gVar2.next == gVar) {
                gVar2.next = gVar.next;
                gVar.next = null;
                return;
            }
        }
        throw new IllegalStateException("node was not found in the queue");
    }

    public static g c() throws InterruptedException {
        g gVar = g.head;
        kotlin.jvm.internal.j.b(gVar);
        g gVar2 = gVar.next;
        if (gVar2 == null) {
            long jNanoTime = System.nanoTime();
            g.condition.await(g.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            g gVar3 = g.head;
            kotlin.jvm.internal.j.b(gVar3);
            if (gVar3.next != null || System.nanoTime() - jNanoTime < g.IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return g.head;
        }
        long jAccess$remainingNanos = g.access$remainingNanos(gVar2, System.nanoTime());
        if (jAccess$remainingNanos > 0) {
            g.condition.await(jAccess$remainingNanos, TimeUnit.NANOSECONDS);
            return null;
        }
        g gVar4 = g.head;
        kotlin.jvm.internal.j.b(gVar4);
        gVar4.next = gVar2.next;
        gVar2.next = null;
        gVar2.state = 2;
        return gVar2;
    }
}
