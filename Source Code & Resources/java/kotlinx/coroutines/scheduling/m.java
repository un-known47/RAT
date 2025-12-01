package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f847b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f848e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f849a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public final h a(h hVar) {
        if (hVar.f839b.f840a == 1) {
            f848e.incrementAndGet(this);
        }
        if (this.producerIndex - this.consumerIndex == 127) {
            return hVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.f849a.get(i2) != null) {
            Thread.yield();
        }
        this.f849a.lazySet(i2, hVar);
        c.incrementAndGet(this);
        return null;
    }

    public final int b() {
        return this.lastScheduledTask != null ? (this.producerIndex - this.consumerIndex) + 1 : this.producerIndex - this.consumerIndex;
    }

    public final h c() {
        h hVar;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (d.compareAndSet(this, i2, i2 + 1) && (hVar = (h) this.f849a.getAndSet(i3, null)) != null) {
                if (hVar.f839b.f840a == 1) {
                    f848e.decrementAndGet(this);
                }
                return hVar;
            }
        }
    }

    public final long d(m mVar) {
        int i2 = mVar.producerIndex;
        AtomicReferenceArray atomicReferenceArray = mVar.f849a;
        for (int i3 = mVar.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (mVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = (h) atomicReferenceArray.get(i4);
            if (hVar != null && hVar.f839b.f840a == 1) {
                while (!atomicReferenceArray.compareAndSet(i4, hVar, null)) {
                    if (atomicReferenceArray.get(i4) != hVar) {
                        break;
                    }
                }
                f848e.decrementAndGet(mVar);
                h hVar2 = (h) f847b.getAndSet(this, hVar);
                if (hVar2 == null) {
                    return -1L;
                }
                a(hVar2);
                return -1L;
            }
        }
        return e(mVar, true);
    }

    public final long e(m mVar, boolean z2) {
        while (true) {
            h hVar = (h) mVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z2 && hVar.f839b.f840a != 1) {
                return -2L;
            }
            k.f843e.getClass();
            long jNanoTime = System.nanoTime() - hVar.f838a;
            long j = k.f841a;
            if (jNanoTime < j) {
                return j - jNanoTime;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f847b;
            while (!atomicReferenceFieldUpdater.compareAndSet(mVar, hVar, null)) {
                if (atomicReferenceFieldUpdater.get(mVar) != hVar) {
                    break;
                }
            }
            h hVar2 = (h) f847b.getAndSet(this, hVar);
            if (hVar2 == null) {
                return -1L;
            }
            a(hVar2);
            return -1L;
        }
    }
}
