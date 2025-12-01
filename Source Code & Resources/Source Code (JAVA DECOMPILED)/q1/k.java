package q1;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class k extends e {
    @Override // q1.e
    public final f a(Type type, Annotation[] annotationArr) {
        if (b1.h(type) != com.google.android.material.datepicker.f.e()) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeG = b1.g(0, (ParameterizedType) type);
        if (b1.h(typeG) != s0.class) {
            return new i(0, typeG);
        }
        if (!(typeG instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        return new i(1, b1.g(0, (ParameterizedType) typeG));
    }
}
