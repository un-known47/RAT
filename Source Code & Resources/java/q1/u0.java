package q1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f1148a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Call.Factory f1149b;
    public final HttpUrl c;
    public final List d;

    /* renamed from: e, reason: collision with root package name */
    public final List f1150e;

    /* renamed from: f, reason: collision with root package name */
    public final Executor f1151f;

    public u0(Call.Factory factory, HttpUrl httpUrl, List list, List list2, Executor executor) {
        this.f1149b = factory;
        this.c = httpUrl;
        this.d = list;
        this.f1150e = list2;
        this.f1151f = executor;
    }

    public final f a(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.f1150e;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            f fVarA = ((e) list.get(i2)).a(type, annotationArr);
            if (fVarA != null) {
                return fVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((e) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final m b(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        List list = this.d;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            m mVarA = ((l) list.get(i2)).a(type);
            if (mVarA != null) {
                return mVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((l) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final m c(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        List list = this.d;
        int iIndexOf = list.indexOf(null) + 1;
        int size = list.size();
        for (int i2 = iIndexOf; i2 < size; i2++) {
            m mVarB = ((l) list.get(i2)).b(type, annotationArr, this);
            if (mVarB != null) {
                return mVarB;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n  Tried:");
        int size2 = list.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(((l) list.get(iIndexOf)).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public final void d(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        List list = this.d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((l) list.get(i2)).getClass();
        }
    }
}
