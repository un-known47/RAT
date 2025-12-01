package q1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.MediaType;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: x, reason: collision with root package name */
    public static final Pattern f1111x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* renamed from: y, reason: collision with root package name */
    public static final Pattern f1112y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

    /* renamed from: a, reason: collision with root package name */
    public final u0 f1113a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f1114b;
    public final Annotation[] c;
    public final Annotation[][] d;

    /* renamed from: e, reason: collision with root package name */
    public final Type[] f1115e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1116f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1117g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1118h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1119i;
    public boolean j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1120k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1121l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1122m;

    /* renamed from: n, reason: collision with root package name */
    public String f1123n;
    public boolean o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1124p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1125q;

    /* renamed from: r, reason: collision with root package name */
    public String f1126r;

    /* renamed from: s, reason: collision with root package name */
    public Headers f1127s;

    /* renamed from: t, reason: collision with root package name */
    public MediaType f1128t;
    public LinkedHashSet u;

    /* renamed from: v, reason: collision with root package name */
    public b1[] f1129v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1130w;

    public q0(u0 u0Var, Method method) {
        this.f1113a = u0Var;
        this.f1114b = method;
        this.c = method.getAnnotations();
        this.f1115e = method.getGenericParameterTypes();
        this.d = method.getParameterAnnotations();
    }

    public static Class a(Class cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }

    public final void b(String str, String str2, boolean z2) {
        String str3 = this.f1123n;
        Method method = this.f1114b;
        if (str3 != null) {
            throw b1.m(method, null, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }
        this.f1123n = str;
        this.o = z2;
        if (str2.isEmpty()) {
            return;
        }
        int iIndexOf = str2.indexOf(63);
        Pattern pattern = f1111x;
        if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
            String strSubstring = str2.substring(iIndexOf + 1);
            if (pattern.matcher(strSubstring).find()) {
                throw b1.m(method, null, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        this.f1126r = str2;
        Matcher matcher = pattern.matcher(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        this.u = linkedHashSet;
    }

    public final void c(int i2, Type type) {
        if (b1.j(type)) {
            throw b1.n(this.f1114b, i2, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }
}
