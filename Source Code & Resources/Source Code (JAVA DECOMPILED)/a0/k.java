package a0;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class k extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f6b;

    public /* synthetic */ k(b0 b0Var, int i2) {
        this.f5a = i2;
        this.f6b = b0Var;
    }

    @Override // a0.b0
    public final Object b(i0.a aVar) throws IOException {
        switch (this.f5a) {
            case 0:
                return new AtomicLong(((Number) this.f6b.b(aVar)).longValue());
            default:
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.K()) {
                    arrayList.add(Long.valueOf(((Number) this.f6b.b(aVar)).longValue()));
                }
                aVar.G();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
        }
    }

    @Override // a0.b0
    public final void c(i0.b bVar, Object obj) throws IOException {
        switch (this.f5a) {
            case 0:
                this.f6b.c(bVar, Long.valueOf(((AtomicLong) obj).get()));
                break;
            default:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                bVar.D();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.f6b.c(bVar, Long.valueOf(atomicLongArray.get(i2)));
                }
                bVar.G();
                break;
        }
    }
}
