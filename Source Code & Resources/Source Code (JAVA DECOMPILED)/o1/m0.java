package o1;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f925a = new l0(new byte[0], 0, 0, false, false);

    /* renamed from: b, reason: collision with root package name */
    public static final int f926b;
    public static final AtomicReference[] c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f926b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i2 = 0; i2 < iHighestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference();
        }
        c = atomicReferenceArr;
    }

    public static final void a(l0 segment) {
        kotlin.jvm.internal.j.e(segment, "segment");
        if (segment.f923f != null || segment.f924g != null) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (segment.d) {
            return;
        }
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (f926b - 1))];
        l0 l0Var = f925a;
        l0 l0Var2 = (l0) atomicReference.getAndSet(l0Var);
        if (l0Var2 == l0Var) {
            return;
        }
        int i2 = l0Var2 != null ? l0Var2.c : 0;
        if (i2 >= 65536) {
            atomicReference.set(l0Var2);
            return;
        }
        segment.f923f = l0Var2;
        segment.f921b = 0;
        segment.c = i2 + 8192;
        atomicReference.set(segment);
    }

    public static final l0 b() {
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (f926b - 1))];
        l0 l0Var = f925a;
        l0 l0Var2 = (l0) atomicReference.getAndSet(l0Var);
        if (l0Var2 == l0Var) {
            return new l0();
        }
        if (l0Var2 == null) {
            atomicReference.set(null);
            return new l0();
        }
        atomicReference.set(l0Var2.f923f);
        l0Var2.f923f = null;
        l0Var2.c = 0;
        return l0Var2;
    }
}
