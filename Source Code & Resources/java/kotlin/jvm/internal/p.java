package kotlin.jvm.internal;

/* compiled from: r8-map-id-c8096209f0e2080d5582fbabe6f93271c3e851e14af30d598fd54a8437fc175f */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final q f790a;

    static {
        q qVar = null;
        try {
            qVar = (q) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (qVar == null) {
            qVar = new q();
        }
        f790a = qVar;
    }

    public static d a(Class cls) {
        f790a.getClass();
        return new d(cls);
    }
}
