package q1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1146a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f1147b;
    public final List c;

    public u(Object obj, Method method, ArrayList arrayList) {
        this.f1146a = obj;
        this.f1147b = method;
        this.c = Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        return String.format("%s.%s() %s", k0.c.class.getName(), this.f1147b.getName(), this.c);
    }
}
