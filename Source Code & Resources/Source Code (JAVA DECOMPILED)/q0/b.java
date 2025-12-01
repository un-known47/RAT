package q0;

import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r;
import p0.d;
import r0.g;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends g {

    /* renamed from: a, reason: collision with root package name */
    public int f1044a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f1045b;
    public final /* synthetic */ d c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, d dVar2, p pVar) {
        super(dVar);
        this.f1045b = pVar;
        this.c = dVar2;
    }

    @Override // r0.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i2 = this.f1044a;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("This coroutine had already completed");
            }
            this.f1044a = 2;
            p.a.S(obj);
            return obj;
        }
        this.f1044a = 1;
        p.a.S(obj);
        p pVar = this.f1045b;
        j.c(pVar, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
        r.c(pVar);
        return pVar.invoke(this.c, this);
    }
}
