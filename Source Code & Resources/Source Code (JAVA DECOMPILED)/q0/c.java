package q0;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r;
import p0.d;
import p0.i;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class c extends r0.c {

    /* renamed from: a, reason: collision with root package name */
    public int f1046a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f1047b;
    public final /* synthetic */ d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d dVar, i iVar, p pVar, d dVar2) {
        super(dVar, iVar);
        this.f1047b = pVar;
        this.c = dVar2;
    }

    @Override // r0.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i2 = this.f1046a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f1046a = 2;
            p.a.S(obj);
            return obj;
        }
        this.f1046a = 1;
        p.a.S(obj);
        p pVar = this.f1047b;
        j.c(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        r.c(pVar);
        return pVar.invoke(this.c, this);
    }
}
