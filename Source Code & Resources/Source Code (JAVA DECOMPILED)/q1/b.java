package q1;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class b extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1057a;

    public /* synthetic */ b(int i2) {
        this.f1057a = i2;
    }

    @Override // q1.l
    public m a(Type type) {
        switch (this.f1057a) {
            case 0:
                if (RequestBody.class.isAssignableFrom(b1.h(type))) {
                    return a.d;
                }
                return null;
            default:
                return super.a(type);
        }
    }

    @Override // q1.l
    public final m b(Type type, Annotation[] annotationArr, u0 u0Var) {
        switch (this.f1057a) {
            case 0:
                if (type == ResponseBody.class) {
                    return b1.l(annotationArr, s1.w.class) ? a.f1049e : a.c;
                }
                if (type == Void.class) {
                    return a.f1051g;
                }
                if (b1.f1066b && type == l0.i.class) {
                    return a.f1050f;
                }
                return null;
            default:
                if (b1.h(type) != com.google.android.material.datepicker.f.w()) {
                    return null;
                }
                return new i.o(5, u0Var.c(b1.g(0, (ParameterizedType) type), annotationArr));
        }
    }
}
