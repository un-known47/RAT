package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements l0.c {
    private VM cached;
    private final y0.a extrasProducer;
    private final y0.a factoryProducer;
    private final y0.a storeProducer;
    private final d1.c viewModelClass;

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements y0.a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // y0.a
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(d1.c viewModelClass, y0.a storeProducer, y0.a factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        j.e(viewModelClass, "viewModelClass");
        j.e(storeProducer, "storeProducer");
        j.e(factoryProducer, "factoryProducer");
    }

    public boolean isInitialized() {
        return this.cached != null;
    }

    public ViewModelLazy(d1.c viewModelClass, y0.a storeProducer, y0.a factoryProducer, y0.a extrasProducer) {
        j.e(viewModelClass, "viewModelClass");
        j.e(storeProducer, "storeProducer");
        j.e(factoryProducer, "factoryProducer");
        j.e(extrasProducer, "extrasProducer");
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    @Override // l0.c
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke());
        d1.c cVar = this.viewModelClass;
        j.e(cVar, "<this>");
        Class clsA = ((kotlin.jvm.internal.c) cVar).a();
        j.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        VM vm2 = (VM) viewModelProvider.get(clsA);
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(d1.c cVar, y0.a aVar, y0.a aVar2, y0.a aVar3, int i2, kotlin.jvm.internal.e eVar) {
        this(cVar, aVar, aVar2, (i2 & 8) != 0 ? AnonymousClass1.INSTANCE : aVar3);
    }
}
