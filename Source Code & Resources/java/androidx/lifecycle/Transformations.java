package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import l0.i;
import y0.l;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class Transformations {

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.lifecycle.Transformations$distinctUntilChanged$1, reason: invalid class name */
    public static final class AnonymousClass1 extends k implements l {
        final /* synthetic */ m $firstTime;
        final /* synthetic */ MediatorLiveData<X> $outputLiveData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MediatorLiveData<X> mediatorLiveData, m mVar) {
            super(1);
            this.$outputLiveData = mediatorLiveData;
            this.$firstTime = mVar;
        }

        @Override // y0.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m73invoke((AnonymousClass1) obj);
            return i.f856a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m73invoke(X x2) {
            Object value = this.$outputLiveData.getValue();
            if (this.$firstTime.f787a || ((value == null && x2 != 0) || !(value == null || value.equals(x2)))) {
                this.$firstTime.f787a = false;
                this.$outputLiveData.setValue(x2);
            }
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.lifecycle.Transformations$map$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00211 extends k implements l {
        final /* synthetic */ MediatorLiveData<Y> $result;
        final /* synthetic */ l $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00211(MediatorLiveData<Y> mediatorLiveData, l lVar) {
            super(1);
            this.$result = mediatorLiveData;
            this.$transform = lVar;
        }

        @Override // y0.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m74invoke((C00211) obj);
            return i.f856a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m74invoke(X x2) {
            this.$result.setValue(this.$transform.invoke(x2));
        }
    }

    /* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
    /* renamed from: androidx.lifecycle.Transformations$map$2, reason: invalid class name */
    public static final class AnonymousClass2 extends k implements l {
        final /* synthetic */ Function $mapFunction;
        final /* synthetic */ MediatorLiveData $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MediatorLiveData mediatorLiveData, Function function) {
            super(1);
            this.$result = mediatorLiveData;
            this.$mapFunction = function;
        }

        @Override // y0.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m75invoke(obj);
            return i.f856a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m75invoke(Object obj) {
            this.$result.setValue(this.$mapFunction.apply(obj));
        }
    }

    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        j.e(liveData, "<this>");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        m mVar = new m();
        mVar.f787a = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            mVar.f787a = false;
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(mediatorLiveData, mVar)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, l transform) {
        j.e(liveData, "<this>");
        j.e(transform, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C00211(mediatorLiveData, transform)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, final l transform) {
        j.e(liveData, "<this>");
        j.e(transform, "transform");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer<X>() { // from class: androidx.lifecycle.Transformations.switchMap.1
            private LiveData<Y> liveData;

            public final LiveData<Y> getLiveData() {
                return this.liveData;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.lifecycle.Observer
            public void onChanged(X x2) {
                LiveData<Y> liveData2 = (LiveData) transform.invoke(x2);
                Object obj = this.liveData;
                if (obj == liveData2) {
                    return;
                }
                if (obj != null) {
                    MediatorLiveData<Y> mediatorLiveData2 = mediatorLiveData;
                    j.b(obj);
                    mediatorLiveData2.removeSource(obj);
                }
                this.liveData = liveData2;
                if (liveData2 != 0) {
                    MediatorLiveData<Y> mediatorLiveData3 = mediatorLiveData;
                    j.b(liveData2);
                    mediatorLiveData3.addSource(liveData2, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$1$onChanged$1(mediatorLiveData)));
                }
            }

            public final void setLiveData(LiveData<Y> liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function mapFunction) {
        j.e(liveData, "<this>");
        j.e(mapFunction, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(mediatorLiveData, mapFunction)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, final Function switchMapFunction) {
        j.e(liveData, "<this>");
        j.e(switchMapFunction, "switchMapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer() { // from class: androidx.lifecycle.Transformations.switchMap.2
            private LiveData liveData;

            public final LiveData getLiveData() {
                return this.liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                LiveData liveData2 = (LiveData) switchMapFunction.apply(obj);
                LiveData liveData3 = this.liveData;
                if (liveData3 == liveData2) {
                    return;
                }
                if (liveData3 != null) {
                    MediatorLiveData mediatorLiveData2 = mediatorLiveData;
                    j.b(liveData3);
                    mediatorLiveData2.removeSource(liveData3);
                }
                this.liveData = liveData2;
                if (liveData2 != null) {
                    MediatorLiveData mediatorLiveData3 = mediatorLiveData;
                    j.b(liveData2);
                    mediatorLiveData3.addSource(liveData2, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(mediatorLiveData)));
                }
            }

            public final void setLiveData(LiveData liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }
}
