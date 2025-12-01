package androidx.lifecycle;

import kotlin.jvm.internal.k;
import l0.i;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Transformations$switchMap$1$onChanged$1 extends k implements l {
    final /* synthetic */ MediatorLiveData<Y> $result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Transformations$switchMap$1$onChanged$1(MediatorLiveData<Y> mediatorLiveData) {
        super(1);
        this.$result = mediatorLiveData;
    }

    @Override // y0.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m76invoke((Transformations$switchMap$1$onChanged$1) obj);
        return i.f856a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m76invoke(Y y2) {
        this.$result.setValue(y2);
    }
}
