package q1;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class p extends e {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f1100a;

    public p(Executor executor) {
        this.f1100a = executor;
    }

    @Override // q1.e
    public final f a(Type type, Annotation[] annotationArr) {
        if (b1.h(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new h.c(b1.g(0, (ParameterizedType) type), b1.l(annotationArr, w0.class) ? null : this.f1100a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
