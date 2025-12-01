package androidx.lifecycle;

import h1.n0;
import h1.s;
import h1.u;
import kotlin.jvm.internal.j;
import r0.i;
import y0.p;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements s {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @r0.e(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", l = {337}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ p $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(p pVar, p0.d<? super AnonymousClass1> dVar) {
            super(dVar);
            this.$block = pVar;
        }

        @Override // r0.a
        public final p0.d<l0.i> create(Object obj, p0.d<?> dVar) {
            return LifecycleCoroutineScope.this.new AnonymousClass1(this.$block, dVar);
        }

        @Override // y0.p
        public final Object invoke(s sVar, p0.d<? super l0.i> dVar) {
            return ((AnonymousClass1) create(sVar, dVar)).invokeSuspend(l0.i.f856a);
        }

        @Override // r0.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            q0.a aVar = q0.a.f1043a;
            int i2 = this.label;
            if (i2 == 0) {
                p.a.S(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_common, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p.a.S(obj);
            }
            return l0.i.f856a;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @r0.e(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.kt", l = {375}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00191 extends i implements p {
        final /* synthetic */ p $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00191(p pVar, p0.d<? super C00191> dVar) {
            super(dVar);
            this.$block = pVar;
        }

        @Override // r0.a
        public final p0.d<l0.i> create(Object obj, p0.d<?> dVar) {
            return LifecycleCoroutineScope.this.new C00191(this.$block, dVar);
        }

        @Override // y0.p
        public final Object invoke(s sVar, p0.d<? super l0.i> dVar) {
            return ((C00191) create(sVar, dVar)).invokeSuspend(l0.i.f856a);
        }

        @Override // r0.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            q0.a aVar = q0.a.f1043a;
            int i2 = this.label;
            if (i2 == 0) {
                p.a.S(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenResumed(lifecycle$lifecycle_common, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p.a.S(obj);
            }
            return l0.i.f856a;
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    @r0.e(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", l = {356}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00201 extends i implements p {
        final /* synthetic */ p $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00201(p pVar, p0.d<? super C00201> dVar) {
            super(dVar);
            this.$block = pVar;
        }

        @Override // r0.a
        public final p0.d<l0.i> create(Object obj, p0.d<?> dVar) {
            return LifecycleCoroutineScope.this.new C00201(this.$block, dVar);
        }

        @Override // y0.p
        public final Object invoke(s sVar, p0.d<? super l0.i> dVar) {
            return ((C00201) create(sVar, dVar)).invokeSuspend(l0.i.f856a);
        }

        @Override // r0.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            q0.a aVar = q0.a.f1043a;
            int i2 = this.label;
            if (i2 == 0) {
                p.a.S(obj);
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle$lifecycle_common();
                p pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_common, pVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p.a.S(obj);
            }
            return l0.i.f856a;
        }
    }

    @Override // h1.s
    public abstract /* synthetic */ p0.i getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    public final n0 launchWhenCreated(p block) {
        j.e(block, "block");
        return u.f(this, null, new AnonymousClass1(block, null), 3);
    }

    public final n0 launchWhenResumed(p block) {
        j.e(block, "block");
        return u.f(this, null, new C00191(block, null), 3);
    }

    public final n0 launchWhenStarted(p block) {
        j.e(block, "block");
        return u.f(this, null, new C00201(block, null), 3);
    }
}
