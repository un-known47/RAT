package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
@r0.e(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends r0.h implements y0.p {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, p0.d<? super ViewKt$allViews$1> dVar) {
        super(dVar);
        this.$this_allViews = view;
    }

    @Override // r0.a
    public final p0.d<l0.i> create(Object obj, p0.d<?> dVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, dVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // y0.p
    public final Object invoke(e1.k kVar, p0.d<? super l0.i> dVar) {
        return ((ViewKt$allViews$1) create(kVar, dVar)).invokeSuspend(l0.i.f856a);
    }

    @Override // r0.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object obj2;
        Object obj3 = q0.a.f1043a;
        int i2 = this.label;
        if (i2 == 0) {
            p.a.S(obj);
            e1.k kVar = (e1.k) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = kVar;
            this.label = 1;
            kVar.a(view, this);
            return obj3;
        }
        Object obj4 = l0.i.f856a;
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p.a.S(obj);
            return obj4;
        }
        e1.k kVar2 = (e1.k) this.L$0;
        p.a.S(obj);
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            e1.i descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            kVar2.getClass();
            Iterator it = descendants.iterator();
            e1.j jVar = (e1.j) kVar2;
            if (it.hasNext()) {
                jVar.c = it;
                jVar.f443a = 2;
                jVar.d = this;
                obj2 = obj3;
            } else {
                obj2 = obj4;
            }
            if (obj2 != obj3) {
                obj2 = obj4;
            }
            if (obj2 == obj3) {
                return obj3;
            }
        }
        return obj4;
    }
}
