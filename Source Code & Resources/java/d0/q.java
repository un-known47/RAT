package d0;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f411a;

    /* renamed from: b, reason: collision with root package name */
    public final Field f412b;
    public final String c;
    public final /* synthetic */ Method d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a0.b0 f413e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ a0.b0 f414f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ boolean f415g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f416h;

    public q(String str, Field field, Method method, a0.b0 b0Var, a0.b0 b0Var2, boolean z2, boolean z3) {
        this.d = method;
        this.f413e = b0Var;
        this.f414f = b0Var2;
        this.f415g = z2;
        this.f416h = z3;
        this.f411a = str;
        this.f412b = field;
        this.c = field.getName();
    }

    public final void a(i0.b bVar, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        Method method = this.d;
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e2) {
                throw new a0.p(androidx.appcompat.app.g.i("Accessor ", f0.c.d(method, false), " threw exception"), e2.getCause());
            }
        } else {
            objInvoke = this.f412b.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        bVar.I(this.f411a);
        this.f413e.c(bVar, objInvoke);
    }
}
