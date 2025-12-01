package androidx.lifecycle;

import kotlin.jvm.internal.k;
import l0.i;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Transformations$switchMap$2$onChanged$1 extends k implements l {
    final /* synthetic */ MediatorLiveData $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$2$onChanged$1(MediatorLiveData mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    @Override // y0.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m77invoke(obj);
        return i.f856a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m77invoke(Object obj) {
        this.$result.setValue(obj);
    }
}
