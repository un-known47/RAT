package h1;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class g0 extends p {

    /* renamed from: a, reason: collision with root package name */
    public long f542a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f543b;
    public kotlinx.coroutines.internal.a c;

    public final void D() {
        long j = this.f542a - 4294967296L;
        this.f542a = j;
        if (j <= 0 && this.f543b) {
            shutdown();
        }
    }

    public final void E(a0 a0Var) {
        kotlinx.coroutines.internal.a aVar = this.c;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a();
            aVar.f791a = new Object[16];
            this.c = aVar;
        }
        Object[] objArr = aVar.f791a;
        int i2 = aVar.c;
        objArr[i2] = a0Var;
        int length = (objArr.length - 1) & (i2 + 1);
        aVar.c = length;
        int i3 = aVar.f792b;
        if (length == i3) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[length2 << 1];
            m0.i.n0(objArr, objArr2, 0, i3, 0, 10);
            Object[] objArr3 = aVar.f791a;
            int length3 = objArr3.length;
            int i4 = aVar.f792b;
            m0.i.n0(objArr3, objArr2, length3 - i4, 0, i4, 4);
            aVar.f791a = objArr2;
            aVar.f792b = 0;
            aVar.c = length2;
        }
    }

    public abstract Thread F();

    public final void G(boolean z2) {
        this.f542a = (z2 ? 4294967296L : 1L) + this.f542a;
        if (z2) {
            return;
        }
        this.f543b = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v0 */
    public final boolean H() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlinx.coroutines.internal.a aVar = this.c;
        if (aVar == null) {
            return false;
        }
        int i2 = aVar.f792b;
        a0 a0Var = null;
        if (i2 != aVar.c) {
            ?? r3 = aVar.f791a;
            ?? r6 = r3[i2];
            r3[i2] = 0;
            aVar.f792b = (i2 + 1) & (r3.length - 1);
            if (r6 == 0) {
                throw new NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
            }
            a0Var = r6;
        }
        a0 a0Var2 = a0Var;
        if (a0Var2 == null) {
            return false;
        }
        a0Var2.run();
        return true;
    }

    @Override // h1.p
    public final p limitedParallelism(int i2) {
        kotlinx.coroutines.internal.b.a(i2);
        return this;
    }

    public abstract void shutdown();
}
